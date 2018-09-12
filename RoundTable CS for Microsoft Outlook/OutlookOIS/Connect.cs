namespace OutlookOIS
{
	using System;
	using System.Reflection;
	using System.Windows.Forms;
	using Microsoft.Office.Core;
	using Extensibility;
	using System.Runtime.InteropServices;
	using System.Diagnostics;
	using System.Collections;
	using Microsoft.Office.Interop.Outlook;
	
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
	/// <seealso class='IDTExtensibility2' />ty
	[GuidAttribute("CF7AC3FC-5962-476E-9D12-C791A568B3DF"), ProgId("OutlookOIS.Connect")]
	public class Connect : Object, Extensibility.IDTExtensibility2
	{
		private Microsoft.Office.Interop.Outlook.Application appOutlook;
		private object addInInstance;
		private SyncManager syncMgr;
		private Logger logger;

		private Microsoft.Office.Core.CommandBar menuBar;

		// Menu items 
		private CommandBarButton btnSync;
		private CommandBarButton btnSettings;
		private CommandBarButton btnAbout;

		/// <summary>
		///		Implements the constructor for the Add-in object.
		///		Place your initialization code within this method.
		/// </summary>
		public Connect()
		{
			// set the log and settings file information to be used by all components of the app
			try
			{
				Utils.SetAppPath(); // set the global variable for the application folder

				Utils.LogFile = Utils.GetAppPath + "\\" + Utils.LOG_FILE;
				Utils.SettingsFile = Utils.GetAppPath + "\\" + Utils.SETTINGS_FILE;

				logger = new Logger(Utils.LogFile);
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex, logger);
			}
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
			try
			{
				appOutlook = (Microsoft.Office.Interop.Outlook.Application) application;
				addInInstance = addInInst;

				syncMgr = new SyncManager( ref appOutlook );
				
				syncMgr.GetSettings();

				// get a connection and update the project list information from the server
				if ( syncMgr.GetConnection() ) 
					syncMgr.GetProjects(false); 

				syncMgr.AddAllFolderEventHandlers();

				// If we are not loaded upon startup, forward to OnStartupComplete()
				// and pass the incoming System.Array.
				if(connectMode != ext_ConnectMode.ext_cm_Startup)
				{
					OnStartupComplete(ref custom);
				}
				
				// TODO: Call this dynamically based off the system settings.
				syncMgr.StartTimer();
			}
			catch (System.Exception ex)
			{
				ErrorHandler.PublishError(ex, logger);
			}
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
			if(logger != null)
				logger.LogMessage("Disconnecting from Host Application");

			if(disconnectMode != 
				ext_DisconnectMode.ext_dm_HostShutdown)
			{
				OnBeginShutdown(ref custom);
			}
			appOutlook = null;

			// we need to ensure all resources are released, otherwise, the primary process
			// will fail to exit.
			GC.Collect();
			GC.WaitForPendingFinalizers();
			GC.Collect();
			GC.WaitForPendingFinalizers();
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
			try
			{
				this.menuBar = appOutlook.ActiveExplorer().CommandBars["Menu Bar"];
				ShowMenuItems();

				// wire up the click handlers
				btnSync.Click += new _CommandBarButtonEvents_ClickEventHandler(btnSync_Click);
				btnSettings.Click += new _CommandBarButtonEvents_ClickEventHandler(btnSettings_Click);
				btnAbout.Click +=new _CommandBarButtonEvents_ClickEventHandler(btnAbout_Click);
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex, logger);
			}
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
			try
			{
				// TODO: Figure out how to gracefully remove menu items at shutdown
				//       so that they're gone if the add-in is uninstalled;
				if(logger != null)
					logger.LogMessage("Starting primary shutdown routine");
				
				RemoveMenuItems();
				
				menuBar = null;
				btnSync = null;
				btnSettings = null;
				btnAbout = null;
				
				syncMgr.StopTimer();
				syncMgr = null;
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex, logger);
			}

		}
		

		private void ShowMenuItems()
		{
			RemoveMenuItems();

			// only add menu items if not already present
			CommandBarPopup popup = null;

			try
			{
				// get the main menu bar
				CommandBar menuBar = appOutlook.ActiveExplorer().CommandBars["Menu Bar"];

				// check for the Dommoni popup menu item
				foreach (CommandBarControl menuItem in menuBar.Controls)
				{
					if (menuItem.Caption == Utils.MENU_ITEM_ROUNDTABLE)
					{
						popup = (CommandBarPopup) menuItem;
					}
				}

				if ( popup == null || popup.Controls == null || popup.Controls.Count ==0 ) 
				{
					// wasn't there, so make it and add all the buttons
					CommandBarControl helpMenu = menuBar.Controls["&Help"]; // put it before the Help item
					popup = (CommandBarPopup)  menuBar.Controls.Add(10,Type.Missing,Type.Missing, helpMenu.Index,false);
					popup.Caption = Utils.MENU_ITEM_ROUNDTABLE;

					btnSync =  (CommandBarButton) popup.Controls.Add(MsoControlType.msoControlButton, Type.Missing,Type.Missing,Type.Missing, false);
					btnSync.Caption = Utils.MENU_ITEM_SYNC;

					btnSettings = (CommandBarButton)  popup.Controls.Add(Type.Missing,Type.Missing,Type.Missing,Type.Missing,false);
					btnSettings.Caption = Utils.MENU_ITEM_SETTINGS;

					btnAbout = (CommandBarButton)  popup.Controls.Add(Type.Missing,Type.Missing,Type.Missing,Type.Missing,false);
					btnAbout.Caption = Utils.MENU_ITEM_ABOUT;

				}
				else
				{
					btnSync = (CommandBarButton) popup.Controls[Utils.MENU_ITEM_SYNC];
					btnSettings = (CommandBarButton) popup.Controls[Utils.MENU_ITEM_SETTINGS];
					btnAbout = (CommandBarButton) popup.Controls[Utils.MENU_ITEM_ABOUT];
				}	
			}
			catch	 (System.Exception ex)  
			{
				ErrorHandler.PublishError(ex,logger);
			}
		}

		private void RemoveMenuItems()
		{
			// remove the RoundTable menu items
			try
			{
				// get the main menu bar
				//CommandBar menuBar = Utils.menuBar; //appOutlook.ActiveExplorer().CommandBars["Menu Bar"];
				
				if ( menuBar == null ) 
					menuBar = appOutlook.ActiveExplorer().CommandBars["Menu Bar"];

				if ( menuBar == null ) 
					return;
 
				// check for the Dommoni popup menu item
				foreach (CommandBarControl menuItem in menuBar.Controls)
				{
					if (menuItem.Caption == Utils.MENU_ITEM_ROUNDTABLE)
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
							ErrorHandler.PublishError(ex);
						}
					}
				}
			}
			catch (System.Exception ex)
			{
				//ErrorHandler.PublishError(ex, logger);
				// TODO: Put back when this is solved
				ErrorHandler.PublishError(ex);
			}

		}

		private void btnSync_Click(CommandBarButton Ctrl, ref bool CancelDefault)
		{
			try
			{
				if ( syncMgr.GetConnection() )
				{
					syncMgr.SyncTasks(false);
				}
				else
				{
					MessageBox.Show(
						"Unable to connect to the RoundTable Server. \n" + 
						"Please review your connection settings or contact \n" + 
						"your administrator.\n", 
						"RoundTable Connection Error",
						MessageBoxButtons.OK, 
						MessageBoxIcon.Error);
				}
			}
			catch (System.Exception ex)
			{
				ErrorHandler.PublishError(ex, logger);
			}
		}

		private void btnSettings_Click(CommandBarButton Ctrl, ref bool CancelDefault)
		{
			Configuration frmConfig = new Configuration(syncMgr);

			frmConfig.EditSettings();
		}

		private void btnAbout_Click(CommandBarButton Ctrl, ref bool CancelDefault)
		{
			About.ShowAbout();	
		}

		private void ec_ExplorerEvents_Event_Close()
		{
		}
	}
}
/*
 * 
 * $Log$
 * 
 */