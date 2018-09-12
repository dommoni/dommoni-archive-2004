namespace Dommoni.SalesTools.ExcelAddin
{
	using System;
	using System.Collections;
	using Microsoft.Office.Core;
	using Extensibility;
	using System.Runtime.InteropServices;
	using System.Windows.Forms;
	
	using SL_Send;

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
	[GuidAttribute("B94A2BBB-5D35-4EFF-94A1-7D2FBC1BF03D"), ProgId("ExcelAddin.Connect")]
	public class Connect : Object, Extensibility.IDTExtensibility2
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
			excelApp = (Excel.Application)application;
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
			try
			{
				ShowMenuItems();

				bnSendSales.Click += new _CommandBarButtonEvents_ClickEventHandler(bnSendSales_Click);
				bnFormatPinPointer.Click += new _CommandBarButtonEvents_ClickEventHandler(bnFormatPinPointer_Click);
			}
			catch(Exception ex)
			{
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
		
		private void ShowMenuItems()
		{
			try
			{
				// get the main menu bar
				menuBar = excelApp.CommandBars["Worksheet Menu Bar"];//["Menu Bar"];

				RemoveMenuItems();

				// only add menu items if not already present
				CommandBarPopup popup = null;

				// check for the Dommoni popup menu item
				foreach (CommandBarControl menuItem in menuBar.Controls)
				{
					if (menuItem.Caption == Utils.MENU_ITEM_DMNISALES)
					{
						popup = (CommandBarPopup)menuItem;
					}
				}

				if ( popup == null || popup.Controls == null || popup.Controls.Count == 0 ) 
				{
					// wasn't there, so make it and add all the buttons
					CommandBarControl helpMenu = menuBar.Controls["&Help"]; // put it before the Help item
					popup = (CommandBarPopup)menuBar.Controls.Add(10, Type.Missing, Type.Missing, helpMenu.Index, false);
					popup.Caption = Utils.MENU_ITEM_DMNISALES;

					bnSendSales = (CommandBarButton) popup.Controls.Add(MsoControlType.msoControlButton, Type.Missing,Type.Missing,Type.Missing, false);
					bnSendSales.Caption = Utils.MENU_ITEM_SNDSALES;

					bnFormatPinPointer = (CommandBarButton) popup.Controls.Add(MsoControlType.msoControlButton, Type.Missing,Type.Missing,Type.Missing, false);
					bnFormatPinPointer.Caption = Utils.MENU_ITEM_FMTPINPOINTER;
				}
				else
				{
					bnSendSales = (CommandBarButton) popup.Controls[Utils.MENU_ITEM_SNDSALES];
					bnFormatPinPointer = (CommandBarButton) popup.Controls[Utils.MENU_ITEM_FMTPINPOINTER];
				}
			}
			catch(System.Exception ex)  
			{
				//ErrorHandler.PublishError(ex,logger);
				MessageBox.Show(ex.Message);
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
					menuBar = excelApp.CommandBars["Worksheet Menu Bar"];

				if ( menuBar == null ) 
					return;
 
				// check for the Dommoni popup menu item
				foreach (CommandBarControl menuItem in menuBar.Controls)
				{
					if (menuItem.Caption == Utils.MENU_ITEM_DMNISALES)
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
						}
					}
				}
			}
			catch (System.Exception ex)
			{
				//ErrorHandler.PublishError(ex, logger);
				// TODO: Put back when this is solved
			}
		}

		private Excel.Application excelApp;
		private object addInInstance;

		private CommandBar menuBar;
		private CommandBarButton bnSendSales;
		private CommandBarButton bnFormatPinPointer;

		private void bnSendSales_Click(CommandBarButton Ctrl, ref bool CancelDefault)
		{
			// Get the Selected Rows, Create SLSend.Recipients from them, Load SLSend
			try
			{
				SLSend slSend = new SLSend(AppMode.ExcelHostedAddin);

				//Excel.Worksheet wks = 
				//	(Excel.Worksheet)excelApp.ActiveWorkbook.ActiveSheet;
				//Excel.Range selectedRange = (Excel.Range)excelApp.Selection;

				// TRY-FIND
				Excel.Areas areas = ((Excel.Range)excelApp.Selection).Areas;
				for (int ai = 1; ai < areas.Count + 1; ai++)
				{
					Excel.Range selectedRange = areas[ai];
					Excel.Range entireRange = selectedRange.EntireRow;
					entireRange.Select();
				
					for (int i = 1; i < entireRange.Rows.Count + 1; i++)
					{	
						Recipient recipient = new Recipient();
						recipient.Company = (string)((Excel.Range)entireRange.Rows.Cells.get_Item(i,2)).Text;
						recipient.Name = (string)((Excel.Range)entireRange.Rows.Cells.get_Item(i,3)).Text;
					
						string tmpEmail = (string)((Excel.Range)entireRange.Rows.Cells.get_Item(i,8)).Text;
						if (tmpEmail != null && tmpEmail.Length > 0)
						{
							recipient.EmailAddress = tmpEmail;
						}
						slSend.AddRecipient(recipient);
					}
				}
				// END

//				Excel.Range entireRange = selectedRange.EntireRow;
//				entireRange.Select();
//				
//				for (int i = 1; i < entireRange.Rows.Count + 1; i++)
//				{	
//					Recipient recipient = new Recipient();
//					recipient.Company = (string)((Excel.Range)entireRange.Rows.Cells.get_Item(i,2)).Text;
//					recipient.Name = (string)((Excel.Range)entireRange.Rows.Cells.get_Item(i,3)).Text;
//					
//					slSend.AddRecipient(recipient);
//				}
				
				slSend.Visible = true;
			}
			catch(Exception ex)
			{
				MessageBox.Show(ex.Message);
			}
		}

		private void bnFormatPinPointer_Click(CommandBarButton Ctrl, ref bool CancelDefault)
		{
			//MessageBox.Show("PinPointer Formatting...");

			try
			{
				Excel.Range pinPointerSelection = (Excel.Range)excelApp.Selection;
				IList logEntries = new ArrayList();

				for (int i = 1; i < pinPointerSelection.Rows.Count + 1; i++)
				{	
					CallLogEntry cle = new CallLogEntry();
					
					// Get Company name
					string companyName = (string)((Excel.Range)pinPointerSelection.Rows.Cells.get_Item(i,1)).Text;
					companyName = companyName.Trim();
					cle.CompanyName = companyName;
					
					// Get contact and title
					string contact = (string)((Excel.Range)pinPointerSelection.Rows.Cells.get_Item(i, 9)).Text;
					contact = contact.Trim();
					string title = (string)((Excel.Range)pinPointerSelection.Rows.Cells.get_Item(i, 10)).Text;
					title = title.Trim();
					cle.ContactAndTitle = contact + "/" + title;

					// Get phone + area
					string area = (string)((Excel.Range)pinPointerSelection.Rows.Cells.get_Item(i, 6)).Text;
					area = area.Trim();
					string phone = (string)((Excel.Range)pinPointerSelection.Rows.Cells.get_Item(i, 7)).Text;
					phone = phone.Trim();
					cle.PhoneNumber = area + "-" + phone;

					// IndustryAndEmployees
					// PRoduct: 13, Emp: 11
					string product = (string)((Excel.Range)pinPointerSelection.Rows.Cells.get_Item(i, 13)).Text;
					product = product.Trim();
					string emp = (string)((Excel.Range)pinPointerSelection.Rows.Cells.get_Item(i, 11)).Text;
					emp = emp.Trim();
					cle.IndustryEmployeeCount = product + " " + emp;


					logEntries.Add(cle);
				}

				pinPointerSelection.Clear();

				int row = 1;
				foreach(CallLogEntry c in logEntries)
				{
					((Excel.Range)pinPointerSelection.Rows.Cells[row, 2]).Value2 = c.CompanyName;
					((Excel.Range)pinPointerSelection.Rows.Cells[row, 3]).Value2 = c.ContactAndTitle;
					((Excel.Range)pinPointerSelection.Rows.Cells[row, 4]).Value2 = c.PhoneNumber;
					((Excel.Range)pinPointerSelection.Rows.Cells[row, 7]).Value2 = c.IndustryEmployeeCount;

					row++;
				}
			}
			catch(Exception ex)
			{
				MessageBox.Show("An exception occured during processing: " + ex.Message);
			}
		}
	}
}