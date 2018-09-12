using System;
using System.Collections;
using System.IO;
using System.Text;
using Microsoft.Office.Interop.Outlook;
using System.Windows.Forms;

// Dommoni References
using RoundTable;
using RoundTable.ProjectServer.Services.TaskManager;

namespace OutlookOIS
{
	/// <summary>
	/// SyncManager provides methods for synchronizing Outlook 2002/2003 
	/// tasks with ToDo items in RoundTable
	/// </summary>
	class SyncManager
	{
		// TODO: Only create a timer if they have enabled auto-sync.
		private System.Timers.Timer timer;

		private Microsoft.Office.Interop.Outlook.Application appOutlook;
		private Settings settings; 
		private ProjectServerConnection psc;
		private ITaskManager taskMgr;

		private ArrayList taskFolders = new ArrayList();
		private FieldMappingRegistry fieldsRegistry;
		//private Hashtable hshFieldMappings;

		private Hashtable hshEventFolders = new Hashtable();
		private Hashtable hshEventTasks = new Hashtable();

		private Hashtable newTaskItems;
		private Hashtable taskItems;
		private Hashtable todoItems;
		private ArrayList deletedTasks;
		private System.Timers.ElapsedEventHandler timerHandler;

		private Logger logger = new Logger(Utils.LogFile);

		public SyncManager( ref Microsoft.Office.Interop.Outlook.Application _appOutlook)
		{
			appOutlook = _appOutlook;
			timer = new System.Timers.Timer();

			try
			{
				string dir = Utils.GetAppPath;
				FileStream xmlFileStream = File.OpenRead(dir + "\\" + Utils.FIELD_MAPPINGS_FILE);
				XmlFieldMappingsReader cfr = new XmlFieldMappingsReader(xmlFileStream);
				
				fieldsRegistry = new FieldMappingRegistry(cfr.ReadXml());
			}
			catch (System.Exception ex)
			{
				string msg = ex.Message;
			}
		}

		public void StartTimer()
		{
			// wire up the timer and start it
			int interval;

			if (this.Settings.AutoSyncInterval > 0)
			{	
				interval = this.Settings.AutoSyncInterval;
			}
			else
			{	
				interval = 5;
			}

			timer.Interval = interval * 1000 * 60; // mins to miliseconds

			// remove the handler if already present
			if ( timerHandler != null ) 
				timer.Elapsed -= timerHandler;
			
			timerHandler = new System.Timers.ElapsedEventHandler(timer_Elapsed);
			timer.Elapsed += timerHandler;

			timer.Start();
		}

		public void StopTimer()
		{
			logger.LogMessage("Performing Sync process shutdown routine");
			try
			{
				if(timer != null)
				{
					timer.Stop();
					timer.Close();

					timer = null;

					GC.Collect();
					GC.WaitForPendingFinalizers();
					GC.Collect();
					GC.WaitForPendingFinalizers();
				}
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex);
			}
		}

		public void GetSettings()
		{
			settings = Settings.LoadSettings();
		}

		/// <summary>
		/// Establish the connection to the Roundtable project server using the
		/// cached info.
		/// 
		/// Note: I removed the prompting of the user from this method. Rather than prompt
		///       the user will be presented with the connection info tab of the edit settings
		///       dialog once after starting, if connection is unsuccesful.
		/// </summary>
		/// <returns></returns>
		public bool GetConnection() 
		{
			try
			{
				string sUser = settings.User;
				string sPass = settings.Password;
				string sAddress = settings.ServerAddress;
				int iPort = settings.Port;
				bool bSavePass = settings.SavePassword;

				int iSessionType = -1; // TODO: NEXT VERSION  determine what to do with the Session Type

				// if there are any required settings missing (username, 
				// password, server address, or port), then return false
				if ( sUser == string.Empty  ||
					sPass == string.Empty  ||
					sAddress == string.Empty  ||
					iPort == 0)
				{
					return false;					
				}

				psc = new ProjectServerConnection(sUser, sPass, iSessionType, sAddress, iPort);

				// TODO: NEXT VERSION ... Add code to psc to return bool on .login() and provide
				//       a means of returning state information and/or login failure info.
				// register the assembly resolution handler
				
				if ( ! IsLoggedIn() )
				{
					ResolveEventHandler resolveHander = new ResolveEventHandler(Utils.MyResolveEventHandler);
					AppDomain.CurrentDomain.AssemblyResolve += resolveHander;
				
					psc.login();
				
					// unregister the handler
					AppDomain.CurrentDomain.AssemblyResolve -= resolveHander;
				}

				bool bLoginSuccess = true; // this hack has got to go
				if ( bLoginSuccess )
				{
					// TODO: NEXT VERSION ... switch to using psc.getCurrentAccount or equivalent 
					//       when available. In the meantime ...
					settings.AccountID = psc.AccountManager.getAccountFromUsername(sUser).id;

					taskMgr = psc.TaskManager;
			
					// TODO: NEXT VERSION ... if we made it this far, we have a successful login, 
					//       so we'll set that flag here. However, in the future, set this based
					//       on the return value from the psc.login (see notes above)
					settings.IsSuccessfulConnection = true;
					
					// save settings if successful login
					settings.User = sUser;
					settings.ServerAddress = sAddress;
					settings.Port = iPort;
					if (bSavePass) 
					{
						settings.Password = sPass;
					}
					else
					{
						settings.Password = "";
					}
					settings.SavePassword = bSavePass;

					settings.SaveSettings(); //write hashtable to file

					// log the successful connection
					logger.LogMessage("Connected to Project Server");

					return true;
				}
				else
				{
					ErrorHandler.PublishError("Unable to connect to the Project Server", logger); 
					return false;
				}
			}
			catch (System.Exception ex)
			{
				ErrorHandler.PublishError(ex,logger);
				return false;
			}
			
		}

		/// <summary>
		/// GetProjects: Connect to the project server with the current credentials 
		///              and return a hashtable containing all projects available
		///              to the current user. If the projects already exist in the
		///              local settings, transfer the settings info.
		/// </summary>
		/// <returns></returns>
		public Hashtable GetProjects(bool bUseCached)
		{
			try
			{
				// if we haven't got a successful connection yet this session, don't try now
				if (psc == null) bUseCached = true;

				Hashtable hshServerProjects = new Hashtable();
            
				// get projects from the server using the ProjectManager
				Project[] projects = null;

				if ( ! bUseCached ) 
				// don't attempt to get the projects from the server if UseCache is specified
				{
					try
					{
						projects = psc.ProjectManager.getAllProjectsForAccount(settings.AccountID);
					}
					catch (System.Exception ex) 
					{
						ErrorHandler.PublishError(ex,logger);
					}
				}
				
				if ( projects != null )
				{
					foreach (Project proj in projects) 
					{
						ProjectInfo projInfo = new ProjectInfo();
						projInfo.ProjID = proj.id;
						projInfo.ProjectName = proj.name;

						hshServerProjects.Add(projInfo.ProjID, projInfo);
					}

					// get the existing projects from the settings file
					Hashtable hshExistingProjects = settings.ProjectInfoTable;
					
					if ( hshExistingProjects != null ) 
					{
						// update the ProjInfo objects from the server with the local settings
						foreach (ProjectInfo projInfo in hshServerProjects.Values)
						{
							if ( hshExistingProjects.ContainsKey(projInfo.ProjID))
							{
								ProjectInfo projCurrent = (ProjectInfo) hshExistingProjects[projInfo.ProjID];
								projInfo.SyncFolder = projCurrent.SyncFolder;
								projInfo.SyncEnabled = projCurrent.SyncEnabled;
								projInfo.SyncCompletedTasks = projCurrent.SyncCompletedTasks;
								// TODO: NEXT VERSION ... Add additional settings later if needed
							}
						}
					}

					// replace the local settings with the new project info table
					settings.ProjectInfoTable = hshServerProjects;

					return hshServerProjects;
				}
				else
				{
					// couldn't get the project info from the server, so
					// use the existing info from the settings file
					return settings.ProjectInfoTable;
				}
			}
			catch (System.Exception ex)
			{
				ErrorHandler.PublishError(ex, logger);
				return null;
			}
		}

		
		/// <summary>
		/// The main routine for syncronizing Outlook tasks with Roundtable project server.
		/// It gets complete sets of tasks and todos in hashtables with the taskID as the key
		/// and then copies all new tasks from RT to Outlook, and then the reverse. 
		/// </summary>
		public void SyncTasks(bool bIsAutoSync)
		{
			ProgressBar frmSyncProgress = null;
			try
			{
				//deletedTasks = new ArrayList();

				if (! bIsAutoSync) 
					frmSyncProgress = ProgressBar.ShowProgressBar(ProgressBarType.Synchronizing);

				// get all Todo's from the Project Server for enabled projects this user is assigned to
				GetAllToDos(out todoItems);

				// get all Outlook Tasks assigned to projects enabled for sync
				GetAllOutlookTasks(out taskItems, out newTaskItems);

				// create todo's on the Project Server for all task items assigned 
				// to a project but not yet having a RoundTable ToDo ID.
				CreateNewToDos(newTaskItems);

				// download new items from the server and update local items
				// that were modified more recently on the server's copy 
				foreach (int iTaskID in todoItems.Keys)
				{
					if ( taskItems.ContainsKey(iTaskID)) 
					{
						// the item already exists locally, update 
						TaskItem taskItem = (TaskItem) taskItems[iTaskID];
						RoundTable.Task todoItem = (RoundTable.Task) todoItems[iTaskID];
						
						// use the last modified property to determine the direction of updating
						
						/*----------------------------------------------------------------------------
						 * NOTE: This will never work. The Modification dates will never be equal to each
						 * other. We need to maintain a list of "dirty" tasks. 
						 * 
						 * Once Update-Todo-From-Task is called, update the list, then compare agains
						 * the list.
						 * */
						if (todoItem.lastModified.CompareTo(taskItem.LastModificationTime) > 0)	
						{
							UpdateTaskByTodo(taskItem,todoItem);
						}
						else
						{
							UpdateTodoByTask(todoItem,taskItem);
						}
					}
					else
					{
						if ( settings.LastSyncIDs.Contains(iTaskID) ) 
						{
							// we had the task as of the last sync, but now it's gone, so we must
							// have deleted it. add to the list of items to process for deletion
							
							// REVIEW: NEXT_VERSION ... Figure out how to best handle it when the
							//         user deletes a task. i'm leery about removing from the project
							//         server. i'm not convinced it's intuitive
							//deletedTasks.Add(iTaskID);
						}

						// we don't have the task create it
						// NOTE: this was in the else section of the above conditional, but
						//       for now it seems better to always retrieve from the server
						CreateOutlookTask((RoundTable.Task) todoItems[iTaskID]);
					}
				}

				// if set to do so, delete from the server todos owned by the current 
				// user that have been deleted locally since the last sync. 
				if (settings.RemoveDeletedTasks)
				{
					// TODO: NEXT_VERSION ... the problem with this right now is that there's
					//       no way to tell if the todo on the server that corresponds to the 
					//       task deleted locally is currently owned by this user, without 
					//       getting the task (if it's still there), and checking the prop. 
					//       Since all we're trying to do is delete it, this seems wasteful.
					//       Perhaps a Project Server method could be added to accomodate this.

					/*
					 * Option 1:
					 * Idea for performing deletes (Poor Mans Delete Handler):
					 * 
					 * Maintain a list of downloaded, added tasks...
					 * 
					 * 
					 * Cons:
					 * Delete Notification Dialog wont happen in RealTime... It will 
					 * only appear on Sync Events... Then when the window is reactivated, 
					 * the user will be presented with a dialog for something that happened
					 * N minutes ago. 
					 * 
					 * ------------------------------------------------------------------
					 * 
					 * Option 2:
					 * Wrap each object and proxy the events through the Wrapper... Fuck. 
					 * */
				}

				// save the settings info (LastSyncID's project info, etc.)
				settings.SaveSettings();

				// reset the timer (so that we don't autosync shortly after manually syncing)
				if (! bIsAutoSync ) 
				{
					timer.Stop();
					timer.Start();
				}
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex,logger);
			}
			finally
			{
				// close the progress bar if needed
				if ( frmSyncProgress != null ) frmSyncProgress.Close();
			}
		}

		/// <summary>
		/// Create an Outlook task in the task folder based on a specified Roundtable ToDo item
		/// </summary>
		/// <param name="todo"></param>
		private void CreateOutlookTask(Task todo)
		{
			try
			{
				// get the task folder
				ProjectInfo projInfo = (ProjectInfo) settings.ProjectInfoTable[todo.projectId];
				
				MAPIFolder taskFolder = GetFolderByPath(projInfo.SyncFolder);
				if ( taskFolder == null ) 
				{
					taskFolder = appOutlook.Session.GetDefaultFolder(OlDefaultFolders.olFolderTasks);
				}
				
				logger.LogMessage("New Outlook Item: ");
				logger.LogMessage("          folder path: " + taskFolder.FolderPath);
				logger.LogMessage("          projInfo.SyncFolder: " + projInfo.SyncFolder);

				// Find Custom Form...
				string messageClass = null;
				if (todo.customFields != null && todo.customFields.Length > 0)
				{
					foreach (CustomField cf in todo.customFields)
					{
						if (cf.name.Equals(Utils.RT_SHARED_OFTFILE_TAG))
						{
							messageClass = ((CustomFieldValueWrapperString)cf.valueWrapper).value;
						}
					}
				}

				TaskItem taskItem = null;
				if (messageClass != null)
				{	
					taskItem = (TaskItem)taskFolder.Items.Add(messageClass);

					// Add it back as a UserProperty... otherwise, It will be erased on Modifications...
					UserProperty propSharedOft = taskItem.UserProperties.Add(Utils.RT_SHARED_OFTFILE_TAG, 
						OlUserPropertyType.olText, false, Type.Missing);
					propSharedOft.Value = taskItem.FormDescription.MessageClass;
				}
				else
				{	
					taskItem = (TaskItem)taskFolder.Items.Add(Type.Missing);
				}

				taskItem.Subject = todo.title;
				taskItem.Body = todo.description;
				taskItem.Owner = psc.AccountManager.getAccount(todo.createdBy).name; // TODO: NEXT VERSION ... change handling of Task Owner/Creator/AssignedTo
				taskItem.DueDate = todo.dueDate;
			
				// TODO: NEXT VERSION ... create mapping from Outlook Task Status to Todo.Status.
				//       For now, set one of 3 default status values by comparing the text
				string sStatus = todo.currentStatus.title.Trim().ToLower();

				if ( sStatus == "not started" ) 
				{
					taskItem.Status = OlTaskStatus.olTaskNotStarted; 
				}
				if ( sStatus == "in progress" ) 
				{
					taskItem.Status = OlTaskStatus.olTaskInProgress;
				}
				if ( sStatus == "completed" ) 
				{
					taskItem.Status = OlTaskStatus.olTaskComplete;
				}

				// create the user property field used to uniquely identify the task and associate with a project
				UserProperty propTaskID = taskItem.UserProperties.Add(Utils.RT_TODO_ID_PROP_NAME, OlUserPropertyType.olNumber, true, Type.Missing);
				propTaskID.Value = todo.id;
				UserProperty propProjID = taskItem.UserProperties.Add(Utils.RT_TODO_PROJID_PROP_NAME, OlUserPropertyType.olNumber, true, Type.Missing);
				propProjID.Value = todo.projectId;
				
				//-----------------------------------------------------------------------
				// Custom Fields and NamedTemplates

				if (todo.customFields != null && todo.customFields.Length > 0)
				{
					foreach (CustomField customField in todo.customFields)
					{
						try
						{
							CustomFieldDefinition fieldDef = 
								fieldsRegistry.FindFieldDefFromName(customField.name);
							if (fieldDef != null)
							{
								UserProperty prop = taskItem.UserProperties.Add(fieldDef.Tag, 
									Utils.GetOlTypeForFieldType(fieldDef.Type), false, Type.Missing);
									
								if (fieldDef.Type == CustomField.T_INTEGER)
								{
									prop.Value = ((CustomFieldValueWrapperInt)customField.valueWrapper).value;
								}
								else if (fieldDef.Type == CustomField.T_STRING) 
								{
									prop.Value = ((CustomFieldValueWrapperString)customField.valueWrapper).value;
								}
							}
							else
							{
								if (!customField.hidden)
								{
									// make a new id, register it, and possibly add it to the XML file..?...
								}
							}
						}
						catch (System.Exception ex)
						{
							logger.LogMessage(ex.Message);
						}
					}
				}

				//
				// Named Field Collections...
				//
				if (todo.namedFieldCollections != null && todo.namedFieldCollections.Length > 0)
				{
					// this is required to match the 
					// Collection to the Template Def on Modify events
					StringBuilder sbTemplateTags = new StringBuilder();

					foreach (NamedFieldCollection nfc in todo.namedFieldCollections)
					{
						TemplateDefinition templateDef = 
							fieldsRegistry.FindTemplateDefFromName(nfc.name);
						if (templateDef != null)
						{
							sbTemplateTags.Append(templateDef.Tag + 
								Utils.RT_TEMPLATE_TAG_DELIMETER);
						}

						#region CollectionFields
						foreach (CustomField customField in nfc.fields)
						{
							string olTag = null;
							if (customField.attributes != null && customField.attributes.Length > 0)
							{
								CustomFieldAttribute[] attributes = customField.attributes;
								foreach (CustomFieldAttribute attribute in attributes)
								{
									if (attribute.name.Equals(Utils.RT_EMBEDDED_PROPERTY))
									{
										olTag = attribute.value;
									}
								}
							}

							// we found the tag as a name so... create it.
							if (olTag != null)
							{
								UserProperty prop = taskItem.UserProperties.Add(olTag, 
									Utils.GetOlTypeForFieldType(customField.type), false, Type.Missing);
											
								if (customField.type == CustomField.T_INTEGER)
								{
									prop.Value = ((CustomFieldValueWrapperInt)customField.valueWrapper).value;
								}
								else if (customField.type == CustomField.T_STRING) 
								{
									prop.Value = ((CustomFieldValueWrapperString)customField.valueWrapper).value;
								}
							}
						}
						#endregion 
					} // end foreach

					//
					// Handle the TemplateTags String.... VERY IMPORTANT this gets added. 
					string templateTags = sbTemplateTags.ToString();
					if (templateTags != null && templateTags.Length > 0)
					{
						UserProperty prpTemplateTags = taskItem.UserProperties.Add(Utils.RT_TEMPLATE_TAGS, 
							OlUserPropertyType.olText, false, Type.Missing);
						
						if (templateTags.EndsWith(Utils.RT_TEMPLATE_TAG_DELIMETER))
						{
							// chop the last delim...
							templateTags = templateTags.Remove(templateTags.Length - 1, 1);
						}

						prpTemplateTags.Value = templateTags;
					}
				}
				taskItem.Save();

				// add to LastSyncIDs
				if (! settings.LastSyncIDs.Contains(todo.id) ) 
					settings.LastSyncIDs.Add(todo.id);
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex, logger);
			}
		}

		public void GetAllToDos(out Hashtable hshTodoItems)
		{
			hshTodoItems = new Hashtable();

			try
			{	// loop through the projects 
				foreach ( ProjectInfo proj in settings.ProjectInfoTable.Values)
				{
					if (proj.SyncEnabled)	// only process those with sync enabled
					{
						// get an array list of completed status id's for all toDos belonging to the current project
						ArrayList lstCompleteIDs = new ArrayList();
						if ( !proj.SyncCompletedTasks) 
						{
							TaskStatus[] projectStatuses = psc.TaskManager.getAllTaskStatusForProject(proj.ProjID);
							try 
							{
								foreach( RoundTable.TaskStatus status in projectStatuses)
								{
									if ( status.title.ToLower().StartsWith("complete") )
									{
										if ( ! lstCompleteIDs.Contains(status.id) )
										{
											lstCompleteIDs.Add(status.id);
										}
									}
								}
							}
							catch (System.Exception ex)
							{
							}
						}

						// add each toDo for the current project to the returned hashtable
						RoundTable.Task[] projectTasks = psc.TaskManager.getAllTasksForProject(proj.ProjID);
						foreach (RoundTable.Task todo in projectTasks)
						{
							// don't include the task if it's status is set to complete and 
							// we are not syncing completed items for this project
							if ( ! lstCompleteIDs.Contains(todo.currentStatus.id) || proj.SyncCompletedTasks)
							{
								hshTodoItems.Add(todo.id, todo);
							}
						}
					}
				}
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex,logger);
			}
		}
	
		public void GetAllOutlookTasks(out Hashtable hshTaskItems, out Hashtable hshNewTaskItems)
		{
			// get all Outlook Tasks assigned to projects enabled for sync
			hshTaskItems = new Hashtable();
			hshNewTaskItems = new Hashtable();

			try
			{
				foreach (MAPIFolder taskFolder in TaskFolders) 
				{
					foreach (object oTask in taskFolder.Items)
					{
						TaskItem task;

						try 
						{   // attempt to cast to a TaskItem
							task = (TaskItem) oTask;
						}
						catch 
						{
							// not a task item (could be a task request or some other odd item). skip it
							task = null;
						}

						if ( task != null ) 
						{
							// only include tasks that have a Proj ID 
							if (Utils.HasUserProperty(task, Utils.RT_TODO_PROJID_PROP_NAME))
							{
								int iProjID = Convert.ToInt32(
									task.UserProperties[Utils.RT_TODO_PROJID_PROP_NAME].Value);
						
								if (settings.ProjectInfoTable.Contains(iProjID) )
								{
									// make sure the project has sync enabled
									ProjectInfo proj = (ProjectInfo)settings.ProjectInfoTable[iProjID];

									if ( proj.SyncEnabled ) 
									{
										// if the task item already has a RoundTable todo id, it has already
										// been synced before. Otherwise it is new.
										int iTaskID = -1;
										if (Utils.HasUserProperty(task, Utils.RT_TODO_ID_PROP_NAME))
											iTaskID = Convert.ToInt32(task.UserProperties[Utils.RT_TODO_ID_PROP_NAME].Value);

										if ( iTaskID > -1 ) 
										{
											if ( ! hshTaskItems.Contains(iTaskID)) 
												hshTaskItems.Add(iTaskID,task);
										}
										else
										{
											// use the MAPIItem Entry ID as a temporary key until we get 
											// one from the RoundTable project server
											if ( ! hshNewTaskItems.Contains(task.EntryID)) 
												hshNewTaskItems.Add(task.EntryID,task);
										}
									}
								}
							}
						}
					}
				}
				return;
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex,logger);
				return;
			}
		}

		public void CreateNewToDos(Hashtable hshNewTasks)
		{
			try
			{
				foreach(TaskItem task in hshNewTasks.Values)
				{
					RoundTable.Task todo = new RoundTable.Task();
				
					todo.projectId = Convert.ToInt32(task.UserProperties[Utils.RT_TODO_PROJID_PROP_NAME].Value);
					todo.title = task.Subject;
					if ( task.Body != null) 
						todo.description = task.Body.ToString();
					
					if ( IsDateTimeValid(task.DueDate) ) 
						todo.dueDate = task.DueDate;
					else
						todo.dueDate = DateTime.MinValue;
					
					todo.createdBy = settings.AccountID;
					todo.createdOn = task.CreationTime;
				
					// TODO: NEXT VERSION ... As the object model currently stands, there's no concept of 
					//       todo "owner" or account(s) assigned to the task. The following code will need 
					//       to modified once that's implemented.

					// TODO: NEXT VERSION ... Improve handling of status. As it is, mapping is straightforward
					//       for three of the default status options, but something more will be needed to 
					//       accomodate RoundTable's dynamic project status possibilities (custom form?)

					RoundTable.TaskStatus status = GetProjStatusByOutlookStatus(task.Status,todo.projectId);
					todo.currentStatus = status;

					// Custom Forms...
					ArrayList alCustomFields = new ArrayList();

					UserProperty prpCustomForm = task.UserProperties[Utils.RT_SHARED_OFTFILE_TAG];
					if (prpCustomForm != null)
					{
						CustomField cfSharedOft = new CustomField();
						cfSharedOft.name = Utils.RT_SHARED_OFTFILE_TAG;
						cfSharedOft.type = CustomField.T_STRING;
						
						CustomFieldValueWrapperString val = 
							new CustomFieldValueWrapperString();
						val.value = (string)prpCustomForm.Value;

						cfSharedOft.valueWrapper = val;

						alCustomFields.Add(cfSharedOft);
					}
					
					// Custom Fields...
					IEnumerator cfen = task.UserProperties.GetEnumerator();
					while (cfen.MoveNext())
					{
						UserProperty prop =  (UserProperty)cfen.Current;
						CustomFieldDefinition fieldDef = 
							fieldsRegistry.GetFieldDefFromTag(prop.Name);
						if (fieldDef != null)
						{
							CustomField cf = new CustomField();
							cf.name = fieldDef.Name;
							cf.type = fieldDef.Type;
							cf.ordinal = fieldDef.Ordinal;
							
							if (cf.type == CustomField.T_INTEGER)
							{
								CustomFieldValueWrapperInt 
									cv = new CustomFieldValueWrapperInt();

								try {
									cv.value = Convert.ToInt32(prop.Value);
									cf.valueWrapper = cv;
								} catch {
								}
							}
							else if (cf.type == CustomField.T_STRING)
							{
								CustomFieldValueWrapperString
									cv = new CustomFieldValueWrapperString();
								
								try {
									cv.value = (string)prop.Value;
									cf.valueWrapper = cv;
								} catch {
								}
							}

							alCustomFields.Add(cf);
						}
					}
					todo.customFields = (CustomField[])alCustomFields.ToArray(typeof(RoundTable.CustomField));

					//------------------------------------------------------------------------
					// Named-Templates...
					
					// Gets embedded in the form... to Ref the Tag.
					// RoundTableNamedTemplates="tag1;tag2;" - needs to be added/appended in the form without... Chomping the rest...

					UserProperty prpTemplateTags = 
						task.UserProperties[Utils.RT_TEMPLATE_TAGS];
					if (prpTemplateTags != null)
					{
						ArrayList alCollections = new ArrayList();
						string tmptags = prpTemplateTags.Value.ToString();
						string[] tags = tmptags.Split(new char[] {';'});
						if (tags != null && tags.Length > 0)
						{
							foreach (string tag in tags)
							{
								if (null == tag)
									continue;

								TemplateDefinition def = fieldsRegistry.GetTemplateDefFromTag(tag);
								if (def != null)
								{
									NamedFieldCollection collection = new NamedFieldCollection();
									collection.name = def.DisplayName;
									collection.projectId = Convert.ToInt32(task.UserProperties[Utils.RT_TODO_PROJID_PROP_NAME].Value);
									collection.description = def.Description;
									collection.createdBy = settings.AccountID;
									collection.createdOn = task.CreationTime;
							
									#region TemplateFieldDefs
									if (def.FieldDefinitions != null && def.FieldDefinitions.Length > 0)
									{
										ArrayList alFieldDefs = new ArrayList();
										foreach (TemplateFieldDefinition tfd in def.FieldDefinitions)
										{
											try
											{
												CustomField field = new CustomField();
												field.name = tfd.Name;
												field.createdBy = settings.AccountID;
												field.createdOn = task.CreationTime;
												field.ordinal = tfd.Ordinal;

												if (tfd.Type.Equals("INTEGER"))
												{	
													field.type = CustomField.T_INTEGER;
												}
												else
												{	
													field.type = CustomField.T_STRING;
												}

												UserProperty prop = task.UserProperties[tfd.Tag];
												if (prop != null)
												{
													if (OlUserPropertyType.olNumber == prop.Type)
													{	
														CustomFieldValueWrapperInt valWrapper = new CustomFieldValueWrapperInt();
														valWrapper.value = (int)prop.Value;
														field.valueWrapper = valWrapper;
													}
													else if (OlUserPropertyType.olText == prop.Type)
													{	
														CustomFieldValueWrapperString valWrapper = new CustomFieldValueWrapperString();
														valWrapper.value = (string)prop.Value;
														field.valueWrapper = valWrapper;
													}
												}
												else // we add it anyway, even if it wasnt found, in order to maintain the integrity of the NFC. 
												{	
													if (CustomField.T_INTEGER == field.type)
													{	
														field.valueWrapper = new CustomFieldValueWrapperInt();
													}
													else if (CustomField.T_STRING == field.type)
													{	
														field.valueWrapper = new CustomFieldValueWrapperString();
													}
												}
												
												// Add the Embedded Attribute...
												CustomFieldAttribute tagAttribute = new CustomFieldAttribute();
												tagAttribute.name = Utils.RT_EMBEDDED_PROPERTY;
												tagAttribute.value = tfd.Tag; // outlook tag name...
												field.attributes = new CustomFieldAttribute[] {tagAttribute};

												alFieldDefs.Add(field);
											}
											catch (System.Exception ex)
											{
												ErrorHandler.PublishError(ex, logger);
											}
										} //foreach
										collection.fields = (CustomField[])alFieldDefs.ToArray(typeof(CustomField));
									} // if
									#endregion
									alCollections.Add(collection);
								}
							}
						} // if (tags.length)

						if (alCollections.Count > 0)
						{	
							todo.namedFieldCollections = (NamedFieldCollection[])alCollections.ToArray(typeof(NamedFieldCollection));
						}
					}
						
					// add the new Todo to the Project 
					int todoID = psc.TaskManager.addTask(todo);

					// update the TaskID prop of the task
					UserProperty propTaskID = task.UserProperties.Add(Utils.RT_TODO_ID_PROP_NAME,OlUserPropertyType.olNumber,true, Type.Missing);
					propTaskID.Value = todoID;
					task.Save();

					// add to LastSyncIDs
					if (! settings.LastSyncIDs.Contains(todoID) ) 
						settings.LastSyncIDs.Add(todoID);
				}
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex, logger);
			}
		}

		private void UpdateTaskByTodo(TaskItem task, RoundTable.Task todo)
		{
			task.Subject = todo.title;
			task.Body = todo.description;
			task.Status = GetOutlookStatusByTitle(todo.currentStatus.title);
			task.DueDate = todo.dueDate;

			//
			// TODO: Add modifications here for Fields and Collections!!!
			//
            CustomField[] customFields = todo.customFields;
			foreach (CustomField field in customFields)
			{
				if (field != null)
				{
					/*
					 * Determining how to handle as a OlProperty:
					 * 
					 *    1. Search the Field Attributes, 
					 *        1.A.  if EMB. ATTR exists, use that
					 *        1.B.  other wise, search the FieldDefinitions 
					 *              Registry for the Field Name
					 * */
					UserProperty prop = null;
					CustomFieldAttribute embeddedAttribute = null;

					// first, let's try the ATTRIBUTE
					CustomFieldAttribute[] attributes = field.attributes;
					foreach (CustomFieldAttribute attribute in attributes)
					{
						if (attribute.name.Equals(Utils.RT_EMBEDDED_PROPERTY))
						{
							embeddedAttribute = attribute;
							try
							{
								prop = task.UserProperties[attribute.value];
							}
							catch 
							{
							}
						}
					}

					if (prop == null)
					{
						// not found in the attribute... let's try the name in the defs...
						CustomFieldDefinition fieldDefinition = fieldsRegistry.FindFieldDefFromName(field.name);
						if (fieldDefinition != null)
						{
							try
							{
								prop = task.UserProperties[fieldDefinition.Tag];
							} 
							catch 
							{
							}
						}
					}

					if (prop != null)
					{
						if (field.valueWrapper is CustomFieldValueWrapperInt)
						{
							prop.Value = ((CustomFieldValueWrapperInt)field.valueWrapper).value;
						}
						else if (field.valueWrapper is CustomFieldValueWrapperString)
						{
							prop.Value = ((CustomFieldValueWrapperString)field.valueWrapper).value;
						}
					}
				}
			}

			//
			// Named Field Collections...
			//
			NamedFieldCollection[] namedCollections = todo.namedFieldCollections;
			if (namedCollections != null)
			{
				foreach (NamedFieldCollection namedCollection in namedCollections)
				{
					CustomField[] collectionFields = namedCollection.fields;
					foreach (CustomField field in collectionFields)
					{
						if (field != null)
						{
							/*
							 * Determining how to handle as a OlProperty:
							 * 
							 *    1. Search the Field Attributes, 
							 *        1.A.  if EMB. ATTR exists, use that
							 *        1.B.  other wise, search the FieldDefinitions 
							 *              Registry for the Field Name
							 * */
							UserProperty prop = null;
							CustomFieldAttribute embeddedAttribute = null;

							// first, let's try the ATTRIBUTE
							CustomFieldAttribute[] attributes = field.attributes;
							foreach (CustomFieldAttribute attribute in attributes)
							{
								if (attribute.name.Equals(Utils.RT_EMBEDDED_PROPERTY))
								{
									embeddedAttribute = attribute;
									try
									{
										prop = task.UserProperties[attribute.value];
									}
									catch 
									{
									}
								}
							}

							if (prop == null)
							{
								// not found in the attribute... let's try the name in the defs...
								CustomFieldDefinition fieldDefinition = fieldsRegistry.FindFieldDefFromName(field.name);
								if (fieldDefinition != null)
								{
									try
									{
										prop = task.UserProperties[fieldDefinition.Tag];
									} 
									catch 
									{
									}
								}
							}

							if (prop != null)
							{
								if (field.valueWrapper is CustomFieldValueWrapperInt)
								{
									prop.Value = ((CustomFieldValueWrapperInt)field.valueWrapper).value;
								}
								else if (field.valueWrapper is CustomFieldValueWrapperString)
								{
									prop.Value = ((CustomFieldValueWrapperString)field.valueWrapper).value;
								}
							}
						}
					}
				}
			}

			task.Save();

			// add to LastSyncIDs
			if (! settings.LastSyncIDs.Contains(todo.id) ) 
				settings.LastSyncIDs.Add(todo.id);
		}


		private void UpdateTodoByTask(RoundTable.Task todo, TaskItem task)
		{
			todo.title = task.Subject;
			todo.description = task.Body;
			todo.currentStatus = GetProjStatusByOutlookStatus(task.Status,todo.projectId);
			todo.dueDate = task.DueDate;

			//
			// Custom Fields...
			//
			ArrayList alCustomFields = new ArrayList();
			FieldMappingHelper activeFields = new FieldMappingHelper(todo);

			// Custom Forms...
			UserProperty prpCustomForm = task.UserProperties[Utils.RT_SHARED_OFTFILE_TAG];
			if (prpCustomForm != null)
			{
				//CustomField cfSharedOft = new CustomField();
				CustomField cfSharedOft = 
					activeFields.FindFieldFromName(Utils.RT_SHARED_OFTFILE_TAG);
				//cfSharedOft.name = Utils.RT_SHARED_OFTFILE_TAG;
				//cfSharedOft.type = CustomField.T_STRING;
						
				CustomFieldValueWrapperString val = 
					new CustomFieldValueWrapperString();
				val.value = (string)prpCustomForm.Value;

				cfSharedOft.valueWrapper = val;

				alCustomFields.Add(cfSharedOft);
			}

			// Custom Fields...
			IEnumerator cfen = task.UserProperties.GetEnumerator();
			while (cfen.MoveNext())
			{
				try
				{
					UserProperty prop = (UserProperty)cfen.Current;
					CustomFieldDefinition fieldDef = 
						fieldsRegistry.GetFieldDefFromTag(prop.Name);
					if (fieldDef != null)
					{
						//CustomField cf = new CustomField();
						//cf.name = fieldDef.Name;
						CustomField cf = 
							activeFields.FindFieldFromName(fieldDef.Name);
					
						if (fieldDef.Type.Equals("INTEGER"))
							cf.type = CustomField.T_INTEGER;
						else
							cf.type = CustomField.T_STRING;

						cf.ordinal = fieldDef.Ordinal;
							
						if (cf.type == CustomField.T_INTEGER)
						{
							CustomFieldValueWrapperInt 
								cv = new CustomFieldValueWrapperInt();

							try 
							{
								cv.value = Convert.ToInt32(prop.Value);
								cf.valueWrapper = cv;
							} 
							catch 
							{
							}
						}
						else if (cf.type == CustomField.T_STRING)
						{
							CustomFieldValueWrapperString
								cv = new CustomFieldValueWrapperString();
								
							try 
							{
								cv.value = (string)prop.Value;
								cf.valueWrapper = cv;
							} 
							catch 
							{
							}
						}

						alCustomFields.Add(cf);
					}// if
				}
				catch (System.Exception ex)
				{
				}
			} // while
			todo.customFields = (CustomField[])alCustomFields.ToArray(typeof(RoundTable.CustomField));

			//------------------------------------------------------------------------
			// Named-Templates...
					
			// Gets embedded in the form... to Ref the Tag.
			// RoundTableNamedTemplates="tag1;tag2;" - needs to be added/appended in the form without... Chomping the rest...

			UserProperty prpTemplateTags = 
				task.UserProperties[Utils.RT_TEMPLATE_TAGS];
			if (prpTemplateTags != null)
			{
				ArrayList alCollections = new ArrayList();
				string tmptags = prpTemplateTags.Value.ToString();
				string[] tags = tmptags.Split(new char[] {';'});
				foreach (string tag in tags)
				{
					TemplateDefinition def = fieldsRegistry.GetTemplateDefFromTag(tag);
					if (def != null)
					{
						//NamedFieldCollection collection = new NamedFieldCollection();
						NamedFieldCollection collection = 
							activeFields.FindCollectionFromName(def.DisplayName);
						collection.name = def.DisplayName;
						collection.projectId = Convert.ToInt32(task.UserProperties[Utils.RT_TODO_PROJID_PROP_NAME].Value);
						collection.description = def.Description;
						collection.createdBy = settings.AccountID;
						collection.createdOn = task.CreationTime;
						
						if (def.FieldDefinitions != null && def.FieldDefinitions.Length > 0)
						{
							ArrayList alFieldDefs = new ArrayList();
							foreach (TemplateFieldDefinition tfd in def.FieldDefinitions)
							{
								try
								{
									//CustomField field = new CustomField();
									CustomField field = 
										activeFields.FindCollectionFieldFromName(collection.name, tfd.Name);
									field.name = tfd.Name;
									field.createdBy = settings.AccountID;
									field.createdOn = task.CreationTime;
									field.ordinal = tfd.Ordinal;

									if (tfd.Type.Equals("INTEGER"))
									{	
										field.type = CustomField.T_INTEGER;
									}
									else
									{	
										field.type = CustomField.T_STRING;
									}

									UserProperty prop = task.UserProperties[tfd.Tag];
									if (prop != null)
									{
										if (OlUserPropertyType.olNumber == prop.Type)
										{	
											CustomFieldValueWrapperInt valWrapper = new CustomFieldValueWrapperInt();
											valWrapper.value = (int)prop.Value;
											field.valueWrapper = valWrapper;
										}
										else if (OlUserPropertyType.olText == prop.Type)
										{	
											CustomFieldValueWrapperString valWrapper = new CustomFieldValueWrapperString();
											valWrapper.value = (string)prop.Value;
											field.valueWrapper = valWrapper;
										}
									}
									else // we add it anyway, even if it wasnt found, in order to maintain the integrity of the NFC. 
									{	
										if (CustomField.T_INTEGER == field.type)
										{	
											field.valueWrapper = new CustomFieldValueWrapperInt();
										}
										else if (CustomField.T_STRING == field.type)
										{	
											field.valueWrapper = new CustomFieldValueWrapperString();
										}
									}
											
									// Add the Embedded Attribute...
									CustomFieldAttribute tagAttribute = new CustomFieldAttribute();
									tagAttribute.name = Utils.RT_EMBEDDED_PROPERTY;
									tagAttribute.value = tfd.Tag; // outlook tag name...
									field.attributes = new CustomFieldAttribute[] {tagAttribute};

									alFieldDefs.Add(field);
								}
								catch (System.Exception ex)
								{
									ErrorHandler.PublishError(ex, logger);
								}
							} //foreach
							collection.fields = (CustomField[])alFieldDefs.ToArray(typeof(CustomField));
						} // if
						alCollections.Add(collection);
					}
				}

				if (alCollections.Count > 0)
				{	
					todo.namedFieldCollections = (NamedFieldCollection[])alCollections.ToArray(typeof(NamedFieldCollection));
				}
			}
			psc.TaskManager.modifyTask(todo);

			// add to LastSyncIDs
			if (! settings.LastSyncIDs.Contains(todo.id) ) 
				settings.LastSyncIDs.Add(todo.id);
		}

		/*
		 * Performs a simple check for years. 
		 */
		private bool IsDateTimeValid(System.DateTime date)
		{
			if (date > DateTime.MinValue && date < DateTime.MaxValue)
			{
				DateTime today = DateTime.Today;
				if (((today.Year + 100) > date.Year) && (today.Year - 100) < date.Year)
					return true;
			}
			return false;
		}

		public Logger Logger
		{
			get { return logger; }
		}
		
		public Microsoft.Office.Interop.Outlook.Application AppOutlook
		{
			get{ return appOutlook; }
		}
		
		public Settings Settings
		{
			get { return settings;}
		}

		public ArrayList TaskFolders
		{
			get 
			{
				// REVIEW: NEXT_VERSION ... is this the logic we want for deciding which
				//         folder to consider when syncing? As it is, only the main Task Folder
				//         and folders specified in the Project settings will be synced.
				try
				{
					// build a new list each time this is called
					taskFolders = new ArrayList();
					taskFolders.Add(appOutlook.Session.GetDefaultFolder(OlDefaultFolders.olFolderTasks));
				
					foreach (ProjectInfo projInfo in settings.ProjectInfoTable.Values)
					{
						MAPIFolder folder = GetFolderByPath(projInfo.SyncFolder);
						if ( folder != null ) 
						{
							if ( ! settings.IgnoredFolders.Contains(folder.FolderPath) )
							{
								taskFolders.Add(folder);
							}
						}
					}

					return taskFolders;
				}
				catch ( System.Exception ex) 
				{
					ErrorHandler.PublishError(ex, logger);
					return null;
				}
			}
		}
	
		private MAPIFolder GetFolderByPath(string sFolderPath) 
		{
			// given a full path to a folder, returns the corresponding MAPIFolder object
			try
			{
				if ( sFolderPath == string.Empty ) 
					return null;

				sFolderPath = sFolderPath.Replace("\\\\","");

				string[] sFolders = sFolderPath.Split('\\');
			
				MAPIFolder curFolder = appOutlook.Session.Folders[sFolders[0]];

				for ( int i = 1; i < sFolders.Length ; i ++ ) 
				{
					if ( curFolder != null ) 
					{
						curFolder = curFolder.Folders[sFolders[i]];
					}
				}
				return curFolder;
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex, logger);
				return null;
			}
		}

		public void AddAllFolderEventHandlers()
		{
			// REVIEW: NEXT VERSION ... this is a possible speed problem if the user has a lot of public 
			//         folders (e.g., 100+), since the Outlook session object isn't super speedy at returning 
			//         folder objects, and we're recursing everything visible. if it becomes a problem, 
			//         perhaps we could look into some method of cacheing to speed it up.
			try
			{
				appOutlook.Session.Folders.FolderAdd += new FoldersEvents_FolderAddEventHandler(Folders_FolderAdd);
				foreach (MAPIFolder folder in appOutlook.Session.Folders)
				{
					AddFolderEventHandlers(folder);
				}
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex, logger);
			}
		}

		public void AddFolderEventHandlers(MAPIFolder folder)
		{
			try
			{
				AddSingleFolderEventHandler(folder);

				foreach(MAPIFolder childFolder in folder.Folders)
				{
					AddFolderEventHandlers(childFolder);
				}
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex, logger);
			}
		}


		public void AddSingleFolderEventHandler(MAPIFolder folder)
		{
			AddSingleFolderEventHandler(folder, false);
		}
		
		public void AddSingleFolderEventHandler(MAPIFolder folder, bool bUnignore)
		{
			try
			{			
				if ( bUnignore )
				{
					if ( settings.IgnoredFolders.Contains(folder.FullFolderPath) ) 
					{
						settings.IgnoredFolders.Remove(folder.FullFolderPath);
					}
				}

				if ( folder.DefaultItemType == OlItemType.olTaskItem ) 
				{
					Items items = folder.Items;

					if ( ! hshEventFolders.Contains(folder.EntryID) )
					{
						// Note: maintaining a reference to the items collection ensures that
						//       the event will fire when an item is added to the folder
						hshEventFolders.Add(folder.EntryID, items);
						items.ItemAdd += new ItemsEvents_ItemAddEventHandler(Task_Added);
						items.ItemRemove += new ItemsEvents_ItemRemoveEventHandler(items_ItemRemove);
						items.ItemChange += new ItemsEvents_ItemChangeEventHandler(items_ItemChange);
						AddAllItemsBeforeDeleteEventHandler(items);
					}
				}
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex,logger);
			}
		}

		void AddAllItemsBeforeDeleteEventHandler(Items items) 
		{
			foreach (object obj in items) 
			{
				AddSingleItemBeforeDeleteEventHandler(obj);
			}
		}

		void AddSingleItemBeforeDeleteEventHandler(Object item) 
		{
			try
			{
				if (item is TaskItem)
				{
					TaskItem task = (TaskItem)item;
					hshEventTasks.Add(task.EntryID, task);
					task.BeforeDelete += new ItemEvents_10_BeforeDeleteEventHandler(Task_BeforeDelete);
				}
			}
			catch (System.Exception ex)
			{
				ErrorHandler.PublishError(ex, ex.Message, logger);
			}
		}
		
		//---------------------------------------------------------------------
		//
		// EVENT HANDLERS
		//

		private void Task_Added(object item)
		{
			
			TaskItem taskItem = null;
			MAPIFolder folder = null;

			try
			{
				AddSingleItemBeforeDeleteEventHandler(item);

				// attempt to cast the item to a TaskItem
				taskItem = (TaskItem) item;

				folder = (MAPIFolder)taskItem.Parent;

				// make sure it's not in an ignore folder
				if ( ! settings.IgnoredFolders.Contains(folder.FolderPath))
				{
					

					// if the item doesn't already have a Project ID property
					// then prompt the user for the info. (doesn't have to have a value)
					if ( Utils.HasUserProperty(taskItem, Utils.RT_TODO_PROJID_PROP_NAME) )
					{
						return; // already has a project ID, so don't prompt
					}
					// display a form prompting the user to choose a project for the new task
					AssignProjectID frmAssignID = new AssignProjectID(this);
					frmAssignID.AssignTaskProjID(taskItem);
				}
			}
			catch (System.Exception ex)
			{
				ErrorHandler.PublishError(ex,
					"Failed attempt to cast a newly added item to a TaskItem. Item ignored.",logger);
			}
		}

		private void Task_BeforeDelete(object Item, ref bool Cancel)
		{
			/*
			 * Task Removed Functionality:
			 * 
			 * If the user who triggered the Removal of the Task is the owner
			 * of that task, Trigger a dialog asking them if they would also
			 * like to delete the task on RoundTable. If they do, remove it. If 
			 * they select no, add the task to a list of "blocked tasks", leaving
			 * the task in tact on RoundTable but, keeping it from showing up again
			 * on the users Outlook Client.
			 * 
			 * If the user is not the owner of the task, show a dialog telling them 
			 * something like: 
			 * "You cannott delete this task from RoundTable as you
			 * are not the owner. If you would like to see the task again after you've
			 * deleted it, selecte 'Settings -> Advanced Settings -> "Show Locally Deleted Items"
			 * and remove the task from that list."
			 * */

			// we only look at this if it's actually on RoundTable.
			try
			{
				if (Item is TaskItem)
				{
					//TaskItem taskItem = (TaskItem)Item;
				
					if (Utils.HasUserProperty((TaskItem)Item, Utils.RT_TODO_PROJID_PROP_NAME))
					{
						MessageBox.Show("Deleting RoundTable Task: " + ((TaskItem)Item).Subject);
					}

					hshEventTasks.Remove(((TaskItem)Item).EntryID);
				}
			}
			catch (System.Exception ex)
			{
				ErrorHandler.PublishError(ex, ex.Message, logger);
			}
		}

		private void Folders_FolderAdd(MAPIFolder folder)
		{
			AddSingleFolderEventHandler(folder);
		}

		private bool IsLoggedIn()
		{
			return (psc.SessionID != null  && psc.SessionID.Length > 0);
		}

		private RoundTable.TaskStatus GetProjStatusByTitle(string sTitle, int iProjID)
		{
			try
			{
				if ( psc == null ) 
					return null;

				RoundTable.TaskStatus[] allTodoStatus = psc.TaskManager.getAllTaskStatusForProject(iProjID);

				foreach ( RoundTable.TaskStatus todoStatus in allTodoStatus)
				{
					if ( todoStatus.title.Trim().ToLower() == sTitle.Trim().ToLower())
					{
						return todoStatus;
					}
				}
				return null;
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex,logger);
				return null;
			}
		}

		private RoundTable.TaskStatus GetProjStatusByOutlookStatus(OlTaskStatus status, int iProjID)
		{
			try
			{
				switch (status)
				{
					case OlTaskStatus.olTaskNotStarted:
						return GetProjStatusByTitle("Not Started",iProjID);
					case OlTaskStatus.olTaskComplete:
						return GetProjStatusByTitle("Completed", iProjID);
					default:
						return GetProjStatusByTitle("In Progress", iProjID);
				}
			}
			catch (System.Exception ex)
			{
				ErrorHandler.PublishError(ex,logger);
				return null;
			}
		}

		private OlTaskStatus GetOutlookStatusByTitle(string sStatusTitle)
		{
			try
			{
				switch (sStatusTitle)
				{
					case "Not Started":
						return OlTaskStatus.olTaskNotStarted;
					case "Completed":
						return OlTaskStatus.olTaskComplete;
					default:
						return OlTaskStatus.olTaskInProgress;
				}
			}
			catch (System.Exception ex)
			{
				ErrorHandler.PublishError(ex,logger);
				return OlTaskStatus.olTaskInProgress; 
			}
		}

		private void timer_Elapsed(object sender, System.Timers.ElapsedEventArgs e)
		{
			try
			{
				if (this.Settings.AutoSyncEnabled) 
				{
					if ( this.GetConnection() )
					{
						this.SyncTasks(true);
					}
				}
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex, logger);
			}
		}

		private void items_ItemRemove()
		{
		}

		private void items_ItemChange(object Item)
		{
		}
	}
}
