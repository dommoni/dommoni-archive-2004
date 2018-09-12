namespace RoundTableWordAddin
{
	using System;
	using System.IO;
	using Microsoft.Office.Core;
	using Extensibility;
	using System.Runtime.InteropServices;
	using System.Windows.Forms;
	using RoundTable;

	#region Read me for Add-in installation and setup information.
	// When run, the Add-in wizard prepared the registry for the Add-in.
	// At a later time, if the Add-in becomes unavailable for reasons such as:
	//   1) You moved this project to a computer other than which is was originally created on.
	//   2) You chose 'Yes' when presented with a message asking if you wish to remove the Add-in.
	//   3) Registry corruption.
	// you will need to re-register the Add-in by building the MyAddin21Setup project 
	// by right clicking the project in the Solution Explorer, then choosing install.
	#endregion
	
	/// <summary>
	///   The object for implementing an Add-in.
	/// </summary>
	/// <seealso class='IDTExtensibility2' />
	[GuidAttribute("2A27E218-40AE-4B21-926A-C0419DF6D262"), ProgId("RoundTableWordAddin.Connect")]
	public class Connect : Object, Extensibility.IDTExtensibility2, IDocumentActivator
	{
		/// <summary>
		///		Implements the constructor for the Add-in object.
		///		Place your initialization code within this method.
		/// </summary>
		public Connect()
		{
		}

		/// <summary>
		///      Implements the OnConnection method of the IDTExtensibility2 interface.
		///      Receives notification that the Add-in is being loaded.
		/// </summary>
		/// <param term='application'>
		///      Root object of the host application.
		/// </param>
		/// <param term='connectMode'>
		///      Describes how the Add-in is being loaded.
		/// </param>
		/// <param term='addInInst'>
		///      Object representing this Add-in.
		/// </param>
		/// <seealso class='IDTExtensibility2' />
		public void OnConnection(object application, Extensibility.ext_ConnectMode connectMode, object addInInst, ref System.Array custom)
		{
			wordApp = (Word.Application)application;
			addInInstance = addInInst;
		}

		/// <summary>
		///     Implements the OnDisconnection method of the IDTExtensibility2 interface.
		///     Receives notification that the Add-in is being unloaded.
		/// </summary>
		/// <param term='disconnectMode'>
		///      Describes how the Add-in is being unloaded.
		/// </param>
		/// <param term='custom'>
		///      Array of parameters that are host application specific.
		/// </param>
		/// <seealso class='IDTExtensibility2' />
		public void OnDisconnection(Extensibility.ext_DisconnectMode disconnectMode, ref System.Array custom)
		{
		}

		/// <summary>
		///      Implements the OnAddInsUpdate method of the IDTExtensibility2 interface.
		///      Receives notification that the collection of Add-ins has changed.
		/// </summary>
		/// <param term='custom'>
		///      Array of parameters that are host application specific.
		/// </param>
		/// <seealso class='IDTExtensibility2' />
		public void OnAddInsUpdate(ref System.Array custom)
		{
		}

		/// <summary>
		///      Implements the OnStartupComplete method of the IDTExtensibility2 interface.
		///      Receives notification that the host application has completed loading.
		/// </summary>
		/// <param term='custom'>
		///      Array of parameters that are host application specific.
		/// </param>
		/// <seealso class='IDTExtensibility2' />
		public void OnStartupComplete(ref System.Array custom)
		{
			ShowMenuItems();

			bnSendToRoundTable.Click += new _CommandBarButtonEvents_ClickEventHandler(bnSendToRoundTable_Click);
			bnOpenFromRoundTable.Click += new _CommandBarButtonEvents_ClickEventHandler(bnOpenFromRoundTable_Click);
			bnEditSettings.Click += new _CommandBarButtonEvents_ClickEventHandler(bnEditSettings_Click);
			bnAbout.Click += new _CommandBarButtonEvents_ClickEventHandler(bnAbout_Click);
		
			string appPath = Application.UserAppDataPath;
			// Dommoni\RoundTable CS for Word
		}

		/// <summary>
		///      Implements the OnBeginShutdown method of the IDTExtensibility2 interface.
		///      Receives notification that the host application is being unloaded.
		/// </summary>
		/// <param term='custom'>
		///      Array of parameters that are host application specific.
		/// </param>
		/// <seealso class='IDTExtensibility2' />
		public void OnBeginShutdown(ref System.Array custom)
		{
		}

		private void ShowMenuItems()
		{
			RemoveMenuItems();
			// only add menu items if not already present
			try
			{
				// get the main menu bar
				CommandBar menuBar = wordApp.CommandBars["Menu Bar"];

				// check for the Dommoni popup menu item
				foreach (CommandBarControl menuItem in menuBar.Controls)
				{
					if (menuItem.Caption == MENU_ITEM_ROUNDTABLE)
					{
						popup = (CommandBarPopup)menuItem;
					}
				}

				if ( popup == null || popup.Controls == null || popup.Controls.Count ==0 ) 
				{
					// wasn't there, so make it and add all the buttons
					CommandBarControl helpMenu = menuBar.Controls["&Help"]; // put it before the Help item
					popup = (CommandBarPopup)menuBar.Controls.Add(10,Type.Missing,Type.Missing, helpMenu.Index,false);
					popup.Caption = MENU_ITEM_ROUNDTABLE;

					bnSendToRoundTable = 
						(CommandBarButton)popup.Controls.Add(MsoControlType.msoControlButton, Type.Missing, Type.Missing, Type.Missing, false);
					bnSendToRoundTable.Caption = MENU_ITEM_SEND_TO_ROUNDTABLE;
					bnSendToRoundTable.Tag = "SEND";

					bnOpenFromRoundTable = 
						(CommandBarButton)popup.Controls.Add(Type.Missing,Type.Missing,Type.Missing,Type.Missing,false);
					bnOpenFromRoundTable.Caption = MENU_ITEM_OPEN_FROM_ROUNDTABLE;
					bnOpenFromRoundTable.Tag = "OPEN";

					bnEditSettings = 
						(CommandBarButton)popup.Controls.Add(Type.Missing,Type.Missing,Type.Missing,Type.Missing,false);
					bnEditSettings.Caption = MENU_ITEM_EDIT_SETTINGS;
					bnEditSettings.Tag = "EDIT";

					bnAbout = 
						(CommandBarButton)popup.Controls.Add(Type.Missing,Type.Missing,Type.Missing,Type.Missing,false);
					bnAbout.Caption = MENU_ITEM_ABOUT;
					bnAbout.Tag = "ABOUT";
				}
				else
				{
					// TODO: Add check here. This could cause an error.

					bnSendToRoundTable = (CommandBarButton)popup.Controls[MENU_ITEM_SEND_TO_ROUNDTABLE];
					bnOpenFromRoundTable = (CommandBarButton)popup.Controls[MENU_ITEM_OPEN_FROM_ROUNDTABLE];
					bnEditSettings = (CommandBarButton)popup.Controls[MENU_ITEM_EDIT_SETTINGS];
					bnAbout = (CommandBarButton)popup.Controls[MENU_ITEM_ABOUT];
				}	
			}
			catch(System.Exception ex)  
			{
				//ErrorHandler.PublishError(ex,logger);
			} 
		}

		private void RemoveMenuItems()
		{
			// remove the RoundTable menu items
			try
			{
				// get the main menu bar
				if(menuBar == null) 
					menuBar = wordApp.CommandBars["Menu Bar"];

				if ( menuBar == null ) 
					return;
 
				// check for the Dommoni popup menu item
				foreach (CommandBarControl menuItem in menuBar.Controls)
				{
					if (menuItem.Caption == MENU_ITEM_ROUNDTABLE)
					{
						try
						{
							CommandBarPopup popup = (CommandBarPopup) menuItem;
							
							try
							{
								foreach (CommandBarControl item in popup.Controls)
								{
									item.Delete(false);
								}
							}
							catch(System.Exception)
							{
								// ignore. just means there are no sub items, perhaps
								// due to a previously failed cleanup
							}
						
							popup.Delete(false);
						}
						catch(System.Exception ex)
						{
							//ErrorHandler.PublishError(ex,logger);
							// TODO: Put back when this is solved
							//ErrorHandler.PublishError(ex);
							MessageBox.Show(ex.Message);
						}
					}
				}
			}
			catch (System.Exception ex)
			{
				//ErrorHandler.PublishError(ex, logger);
				// TODO: Put back when this is solved
				//ErrorHandler.PublishError(ex);
				MessageBox.Show(ex.Message);
			}
		}
				
		/*
		 * Activates a word document.
		 */
		public void ActivateDocument(Document slDoc, ProjectServerConnection psc)
		{
			Word.Document wdDoc = null;
			try
			{
				Document slDocDeep = psc.DocumentManager.getDocumentDeep(slDoc.id);
				
				// Todo: I think part of the problem here is opening one document in word,
				// overwriting that document (FHANDLE, ETC)  and reloading as a new doc
				// with the existing one still open. 
				//
				// This should be testable by uploading multiple documents to RoundTable
				// and opening each one.
				FileStream fs = new FileStream(slDocDeep.filename, FileMode.Create);
				BinaryWriter bw = new BinaryWriter(fs);
				bw.Write(slDocDeep.document, 0, slDocDeep.document.Length);
				bw.Flush();
				bw.Close();
				fs.Close(); // Already done by bw?

				// Activate the RoundTable Document.
				object missing = Type.Missing;
				object filepath = Path.GetFullPath(slDocDeep.filename);
				wdDoc = wordApp.Documents.Open(ref filepath, 
					ref missing, ref missing, ref missing, ref missing, 
					ref missing, ref missing, ref missing, ref missing, 
					ref missing, ref missing, ref missing, ref missing, 
					ref missing, ref missing, ref missing);

				wdDoc.Activate();
			}
			catch (Exception ex)
			{
				MessageBox.Show(ex.Message);
			}
			finally
			{
				try
				{
					Marshal.ReleaseComObject(wdDoc);
				}
				catch(Exception ex)
				{
				}
			}
		}

		private Word.Application wordApp;
		private object addInInstance;

		private CommandBar menuBar;
		private CommandBarPopup popup = null;
		private CommandBarButton bnSendToRoundTable;
		private CommandBarButton bnOpenFromRoundTable;
		private CommandBarButton bnEditSettings;
		private CommandBarButton bnAbout;

		private const string PRODUCTNAME = "RoundTable CS for Word";
		private const string MENU_ITEM_ROUNDTABLE = "&RoundTable";
		private const string MENU_ITEM_SEND_TO_ROUNDTABLE = "&Send to RoundTable";
		private const string MENU_ITEM_OPEN_FROM_ROUNDTABLE = "&Open from RoundTable";
		private const string MENU_ITEM_EDIT_SETTINGS = "Edit Settings";
		private const string MENU_ITEM_ABOUT = "&About " + PRODUCTNAME;

		//
		// Event Handlers...
		//
		
		private void bnSendToRoundTable_Click(CommandBarButton Ctrl, ref bool CancelDefault)
		{
			try
			{
				ConnectionSettings cs = ConnectionSettings.LoadSettings();
				ProjectServerConnection psc = 
					new ProjectServerConnection(cs.Username, cs.Password, 1, cs.IPAddr, cs.Port);
				psc.login();

				DlgSendToRoundTable dSendToRoundTable = 
					new DlgSendToRoundTable(psc, ref wordApp);
				dSendToRoundTable.Show();
			}
			catch(System.Exception ex)
			{
				MessageBox.Show(Utils.MSG_CONNECTION_ERROR, Utils.MSG_CONNECTION_ERROR_DLGTITLE, MessageBoxButtons.OK, MessageBoxIcon.Error);
			}

			/*Word.Document doc = wordApp.ActiveDocument;
			if (!doc.Saved)
			{
				// Prompt for save
				DialogResult dr;
				dr = MessageBox.Show("This document has not been saved. Would you like to save first?", 
					"Un-Saved Document", 
					MessageBoxButtons.YesNoCancel, 
					MessageBoxIcon.Question);

				if (dr == DialogResult.Yes)
				{
					bool docSaved = false;
					try
					{
						doc.Save();
						docSaved = true;
					}
					catch(System.Exception ex)
					{
						docSaved = false;
					}
				}
				else if (dr == DialogResult.No)
				{
					return;
				}
				else if (dr == DialogResult.Cancel)
				{
					return;
				}
			}

			if (doc.Saved)
			{
				try
				{
					object missing = Type.Missing;
					string tmpPath = doc.Path + "\\" + doc.Name;
					doc.Close(ref missing, ref missing, ref missing);
					object filepath = Path.GetFullPath(tmpPath);
					FileStream fs = new FileStream((string)filepath, FileMode.Open, FileAccess.Read);
					BinaryReader br = new BinaryReader(fs);
					byte[] bDocument = br.ReadBytes((int)fs.Length);
							
					br.Close();
							
					doc = wordApp.Documents.Open(ref filepath, 
						ref missing, ref missing, ref missing, 
						ref missing, ref missing, ref missing, 
						ref missing, ref missing, ref missing, 
						ref missing, ref missing, ref missing, 
						ref missing, ref missing, ref missing);

					if (doc != null)
					{
						// Create the RoundTable document
						ProjectServerConnection psc = new ProjectServerConnection("brian", "brian", 1, "localhost", 8080);
						psc.login();
								
						RoundTable.Document rtDoc = new RoundTable.Document();
						rtDoc.document = bDocument;
						rtDoc.name = doc.Name;
						rtDoc.documentType = RoundTable.DocumentType.MSOFFICE_WORD;
						rtDoc.description = "none for now";
						rtDoc.filename = doc.Name;
						rtDoc.ownerId = psc.Account.id;
						rtDoc.projectId = 1;

						// TODO: Need to be sure to always set the current project here!
						RoundTable.Project p = psc.ProjectManager.getProject(1);
						psc.CurrentProject = p;

						psc.DocumentManager.addDocument(rtDoc);
					}
				}
				catch(System.Exception ex)
				{
					MessageBox.Show(ex.Message);
				}
			}*/
		}

		private void bnOpenFromRoundTable_Click(CommandBarButton Ctrl, ref bool CancelDefault)
		{
			// TODO: Add progress bar, etc.
			try
			{
				ProjectServerConnection psc = 
					new ProjectServerConnection("brian", "brian", 1, "localhost", 8080);
				psc.login();
				DlgOpenFromRoundTable dlgOpenFrom = new DlgOpenFromRoundTable(this, psc);
				dlgOpenFrom.Show();
			}
			catch(Exception e)
			{
				MessageBox.Show("Unable to connect and authenticate with RoundTable.", 
					"RoundTable Connection Error", 
					MessageBoxButtons.OK,
					MessageBoxIcon.Error);
			}
		}

		private void bnEditSettings_Click(CommandBarButton Ctrl, ref bool CancelDefault)
		{
			DlgEditSettings settings = new DlgEditSettings();
			settings.Connect();
		}

		private void bnAbout_Click(CommandBarButton Ctrl, ref bool CancelDefault)
		{
			MessageBox.Show("About");
		}

		bool wasActiveDocumentSaved = false;
	}
}