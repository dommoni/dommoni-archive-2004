/*
 * RoundTable Connected Services for Microsoft Project 2003
 * 
 * Created On: 1/23/2005
 * Created By: Brian Abbott
 * 
 * Copyright 2005. Dommoni Corporation. All Rights Reserved.
 */
namespace ProjectAddin
{
	using System;
	using Microsoft.Office.Core;
	using Extensibility;
	using System.Runtime.InteropServices;
	using System.Windows.Forms;

	using com.dommoni.roundtable;
	using MSProject = Microsoft.Office.Interop.MSProject;
	

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
	[GuidAttribute("E4DF8FEA-A5EF-46D6-9E6F-1CE350A3E28C"), ProgId("ProjectAddin.Connect")]
	public class Connect : Object, Extensibility.IDTExtensibility2
	{
		CommandBarButton bnBuildSched = null;
		CommandBarButton bnEditSettings = null;
		CommandBarButton bnAbout = null;

		ProjectServerConnection psc = null;
		bool loggedIn = false;

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
			projectApp = (MSProject.Application)application;
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
			RemoveMenuItems(); // remove the old ones before we add...
			
			try
			{
				CommandBar menuBar = projectApp.CommandBars["Menu Bar"];
				CommandBarControl helpMenu = menuBar.Controls["&Help"]; // put it before the Help item
				CommandBarPopup popup = (CommandBarPopup)menuBar.Controls.Add(10, Type.Missing, Type.Missing, helpMenu.Index, false);
				popup.Caption = "&RoundTable";

				bnBuildSched = (CommandBarButton)popup.Controls.Add(MsoControlType.msoControlButton, Type.Missing,Type.Missing,Type.Missing, false);
				bnBuildSched.Caption = "&Build a Schedule from RoundTable";

				bnEditSettings = (CommandBarButton)popup.Controls.Add(Type.Missing,Type.Missing,Type.Missing,Type.Missing,false);
				bnEditSettings.Caption = "&Edit Settings";

				bnAbout = (CommandBarButton)popup.Controls.Add(Type.Missing,Type.Missing,Type.Missing,Type.Missing,false);
				bnAbout.Caption = "&About RoundTable Connected Services for Microsoft Project 2003";

				bnBuildSched.Click += new _CommandBarButtonEvents_ClickEventHandler(bnBuildSched_Click);
				bnEditSettings.Click += new _CommandBarButtonEvents_ClickEventHandler(bnEditSettings_Click);
				bnAbout.Click += new _CommandBarButtonEvents_ClickEventHandler(bnAbout_Click);

				//RoundTableSettings rtc = new RoundTableSettings();
				//rtc.load();
			}
			catch(Exception ex)
			{
				MessageBox.Show(ex.Message);
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
		}
		
		private void RemoveMenuItems()
		{
			// remove the RoundTable menu items
			try
			{
				// get the main menu bar
				CommandBar menuBar = projectApp.CommandBars["Menu Bar"];
				
				//if(menuBar == null) 
				//	menuBar = appOutlook.ActiveExplorer().CommandBars["Menu Bar"];

				if(menuBar == null) 
					return;
 
				// check for the Dommoni popup menu item
				foreach (CommandBarControl menuItem in menuBar.Controls)
				{
					if (menuItem.Caption == "&RoundTable") //Utils.MENU_ITEM_ROUNDTABLE)
					{
						try
						{
							CommandBarPopup popup = (CommandBarPopup)menuItem;
							
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
						}
					}
				}
			}
			catch(System.Exception ex)
			{
				//ErrorHandler.PublishError(ex, logger);
				// TODO: Put back when this is solved
				
				// TODO: Make one of these...
				//ErrorHandler.PublishError(ex);
			}

		}

		private void bnBuildSched_Click(CommandBarButton Ctrl, ref bool CancelDefault) 
		{
			try
			{
				if(!loggedIn)
				{	
					psc = psc = new ProjectServerConnection("brian", "brian", 1, "dan", 8080);//rtc.Username, rtc.Password, 1, rtc.IPAddress, rtc.Port);
					psc.login(); 
					loggedIn = true; 
				}
				BuildSchedule buildSchedule = new BuildSchedule(projectApp, psc);
				buildSchedule.Show();
			}
			catch(Exception ex)
			{
				MessageBox.Show(ex.Message);
			}
		}
		
		private void bnEditSettings_Click(CommandBarButton Ctrl, ref bool CancelDefault) 
		{
			Configuration frmConfig = new Configuration();
			frmConfig.EditSettings();
		}

		private void bnAbout_Click(CommandBarButton Ctrl, ref bool CancelDefault) 
		{
			try
			{
				About.ShowAbout();
			}
			catch(Exception ex)
			{
				MessageBox.Show(ex.Message);
			}
		}
		
		private MSProject.Application projectApp;
		private object addInInstance;
	}
}