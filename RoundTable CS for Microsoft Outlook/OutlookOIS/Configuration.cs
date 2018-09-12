using System;
using System.Data;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using Microsoft.Office.Interop.Outlook;
using SourceGrid2;
using SourceGrid2.VisualModels;
using System.Threading;

namespace OutlookOIS
{
	/// <summary>
	/// Summary description for Configuration.
	/// </summary>
	class Configuration : System.Windows.Forms.Form
	{
		// project table column indexes
		private const int col_SyncFolderFull= 0;
		private const int col_SyncEnabled = 1;
		private const int col_ProjName = 2;
		private const int col_SyncFolder = 3;
		private const int col_BrowseButton = 4;

		// tab index values
		private const int TAB_SYNC = 1;
		private const int TAB_CONNECTION = 2;

		private SyncManager syncMgr;
		private Hashtable hshProjects;
		private Hashtable hshProjRows = new Hashtable();

		private System.Windows.Forms.Button btnCancel;
		private System.Windows.Forms.Button btnOK;
		private System.Windows.Forms.Panel panLine;
		private System.Windows.Forms.Panel panSynchronization;
		private SourceGrid2.Grid gridProjects;
		private System.Windows.Forms.Panel panConnection;
		private dotNetFlatControls.GradientPanel gradHeader;
		private dotNetFlatControls.FlatLabel lblHeader;
		private System.Windows.Forms.PictureBox pictureBox1;
		private System.Windows.Forms.Panel panLineHeader;
		private System.Windows.Forms.Panel panel1;
		private dotNetFlatControls.FlatTabStrip tabSettings;
		private dotNetFlatControls.CustomPanel customPanel1;
		private System.Windows.Forms.Button btnTest;
		private System.Windows.Forms.CheckBox chkSavePassword;
		private dotNetFlatControls.FlatTextBox txtPort;
		private dotNetFlatControls.FlatTextBox txtServerAddress;
		private dotNetFlatControls.FlatTextBox txtPassword;
		private dotNetFlatControls.FlatTextBox txtUsername;
		private System.Windows.Forms.Label lblIPAddress;
		private System.Windows.Forms.Label lblPort;
		private System.Windows.Forms.Label lblUsername;
		private System.Windows.Forms.Label lblPassword;
		private dotNetFlatControls.CustomPanel customPanel2;
		private dotNetFlatControls.CustomPanel customPanel3;
		private System.Windows.Forms.Button btnAdvanced;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public Configuration(SyncManager _syncMgr)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			syncMgr = _syncMgr;

			this.Location = new Point((Screen.PrimaryScreen.WorkingArea.Width - this.Width)/3,(Screen.PrimaryScreen.WorkingArea.Height - this.Height)/3);
			this.StartPosition = FormStartPosition.Manual;
		}


		public void EditSettings()
		{
			ProgressBar frmConnectionProgress = null;

			try
			{
				bool bNoConnection = false;

				// TODO: Figure out why the progress bar doesn't start moving right away
				// show the progress bar
				Thread thread;
				frmConnectionProgress = ProgressBar.ShowProgressBar(ProgressBarType.Connecting, out thread);

				// attempt to get a connection to the server using current credentials
				if ( ! syncMgr.GetConnection())
				{   // if no connection, show the connection info page of the settings
					bNoConnection = true;
					ShowConnectionPage();

					// if we have never had a successful login, disable the project tab
					if ( ! syncMgr.Settings.IsSuccessfulConnection ) 
					{
						tabSettings.Tabs.get_Item(1).Enabled = false;
					}
				}

				// populate the fields
				LoadProjectInfo();
				LoadConnectionInfo();

				// close the progress bar
				frmConnectionProgress.Close();
				if ( thread != null && thread.ThreadState != ThreadState.Stopped ) thread.Abort();

				if (bNoConnection) 
				{
					if ( syncMgr.Settings.IsSuccessfulConnection ) 
					{
						MessageBox.Show(this,Utils.MESSAGE_CONNECT_FAILURE_REVIEW,Utils.MESSAGE_CONNECT_FAILURE_TITLE,
							MessageBoxButtons.OK,MessageBoxIcon.Exclamation);
					}
					else
					{
						MessageBox.Show(this,Utils.MESSAGE_NO_SUCCESSFUL_CONNECTION,Utils.MESSAGE_NO_SUCCESSFUL_CONNECTION_TITLE,
							MessageBoxButtons.OK,MessageBoxIcon.Exclamation);
					}
				}

				// show the dialog regardless of whether or not we got a connection
				this.ShowDialog();

			}
			catch (System.Exception ex) 
			{
				ErrorHandler.PublishError(ex, syncMgr.Logger);
			}
			finally 
			{
				// just in case the progress bar is still open (due to an exception), close it
				if (frmConnectionProgress != null) frmConnectionProgress.Close();
			}
		}

		private void ShowConnectionPage()
		{
			// Display the connection tab page
			tabSettings.SelectedIndex = 2;
		}

		private void LoadProjectInfo()
		{
			try
			{
				hshProjects = syncMgr.GetProjects(false);

				gridProjects.FixedRows = 1;
				gridProjects.AutoStretchColumnsToFitWidth = true;

				// create a visual model for right-aligned text with trimming
				SourceGrid2.VisualModels.Common vmEllipsePath = new SourceGrid2.VisualModels.Common();
				vmEllipsePath.StringFormat.Trimming = StringTrimming.EllipsisPath;
				// create a visual model for flat headers
				SourceGrid2.VisualModels.Common vmHeader = new SourceGrid2.VisualModels.FlatHeader();
				vmHeader.BackColor = Color.FromArgb(228,229,237);
				SourceGrid2.BehaviorModels.Header bmHeader = new SourceGrid2.BehaviorModels.Header();
			
				// set up the header row
				gridProjects.Rows.Insert(0);

				// set up the columns
				gridProjects.Columns.Insert(0); // hidden sync project full path
				gridProjects[0,0] = new SourceGrid2.Cells.Real.ColumnHeader("",vmHeader,bmHeader);

				gridProjects.Columns.Insert(1); // check box column
				gridProjects[0,1] = new SourceGrid2.Cells.Real.ColumnHeader("Sync?",vmHeader,bmHeader);

				gridProjects.Columns.Insert(2); // project name
				gridProjects[0,2] = new SourceGrid2.Cells.Real.ColumnHeader("Project Name",vmHeader,bmHeader);
			
				gridProjects.Columns.Insert(3); // sync folder short for display
				gridProjects[0,3] = new SourceGrid2.Cells.Real.ColumnHeader("Outlook Sync Folder",vmHeader,bmHeader);

				gridProjects.Columns.Insert(4); // browse button 
				gridProjects[0,4] = new SourceGrid2.Cells.Real.ColumnHeader("",vmHeader,bmHeader);

				SizeColumns();

				if (hshProjects == null) return;
			
				// add rows for projects
				int iRow = 0;
				foreach (ProjectInfo projInfo in hshProjects.Values) 
				{
					iRow ++;
					gridProjects.Rows.Insert(iRow);

					// add row
					if ( ! hshProjRows.Contains(projInfo.ProjID) )
					{
						hshProjRows.Add(projInfo.ProjID, iRow);
					}

					// add each cell individually
					// sync folder path
					gridProjects[iRow,col_SyncFolderFull] = new SourceGrid2.Cells.Real.Cell(projInfo.SyncFolder);
					// checkbox for sync enabled
					gridProjects[iRow,col_SyncEnabled] = new SourceGrid2.Cells.Real.CheckBox(projInfo.SyncEnabled);
					// project name
					gridProjects[iRow,col_ProjName] = new SourceGrid2.Cells.Real.Cell(projInfo.ProjectName);
					// sync folder short
					gridProjects[iRow,col_SyncFolder] = new SourceGrid2.Cells.Real.Cell(projInfo.SyncFolderShort);
					gridProjects[iRow,col_SyncFolder].VisualModel = vmEllipsePath;
					// browse button				
					gridProjects[iRow,col_BrowseButton] = new SourceGrid2.Cells.Real.Button("...", new SourceGrid2.PositionEventHandler(BrowseOutlookFolders_Click));
					FlatHeader vm = new FlatHeader();
					vm.BackColor = Color.FromArgb(228,229,237);
					gridProjects[iRow,col_BrowseButton].VisualModel = vm;
				
					// TODO: NEXT VERSION ... add a hidden row for additional project settings that displays when 
					//       the main project row is selected
				}
			}
			catch (System.Exception ex)
			{
				ErrorHandler.PublishError(ex,syncMgr.Logger);
			}
		}
		
		private void SizeColumns()
		{
			// set column widths based on total control width.
			gridProjects.Columns[0].Width = 0; // hidden col contains full sync path
			gridProjects.Columns[1].Width = 40; // check box. doesn't stretch
			gridProjects.Columns[2].Width = (int) ((gridProjects.Width - 80)*.50); // project name - 50%
			gridProjects.Columns[3].Width = (int) ((gridProjects.Width - 80)*.50); // sync folder short - 50%
			gridProjects.Columns[4].Width = 40; // browse button

			// hide the scrollbar if necessary
			if ( gridProjects.HScrollBar != null ) gridProjects.HScrollBar.Visible = false;
		}

		private void LoadConnectionInfo()
		{
			txtServerAddress.Text = syncMgr.Settings.ServerAddress;
			txtPort.Text = syncMgr.Settings.Port.ToString();
			txtUsername.Text = syncMgr.Settings.User;
			chkSavePassword.Checked = syncMgr.Settings.SavePassword;
			if ( syncMgr.Settings.SavePassword ) txtPassword.Text = "********";
		}

		private void SaveConnectionSettings()
		{
			syncMgr.Settings.User = txtUsername.Text;
			syncMgr.Settings.ServerAddress = txtServerAddress.Text;
			syncMgr.Settings.Port = Convert.ToInt32(txtPort.Text);
			syncMgr.Settings.SavePassword = chkSavePassword.Checked;

			if ( txtPassword.Modified ) 
			{
				syncMgr.Settings.Password = txtPassword.Text;
			}
		}

		private void SaveProjectSettings()
		{
			// update hshProjects with current grid info 
			foreach (ProjectInfo projInfo in hshProjects.Values)
			{
				int iRow = (int) hshProjRows[projInfo.ProjID];

				projInfo.SyncEnabled = (bool) gridProjects[iRow,col_SyncEnabled].Value;
				projInfo.SyncFolder = gridProjects[iRow,col_SyncFolderFull].Value.ToString();
			}
		}


		// NO TOUCHY !
		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(Configuration));
			this.btnCancel = new System.Windows.Forms.Button();
			this.btnOK = new System.Windows.Forms.Button();
			this.tabSettings = new dotNetFlatControls.FlatTabStrip();
			this.panLine = new System.Windows.Forms.Panel();
			this.panSynchronization = new System.Windows.Forms.Panel();
			this.gridProjects = new SourceGrid2.Grid();
			this.customPanel2 = new dotNetFlatControls.CustomPanel();
			this.customPanel3 = new dotNetFlatControls.CustomPanel();
			this.panConnection = new System.Windows.Forms.Panel();
			this.customPanel1 = new dotNetFlatControls.CustomPanel();
			this.btnTest = new System.Windows.Forms.Button();
			this.chkSavePassword = new System.Windows.Forms.CheckBox();
			this.lblPort = new System.Windows.Forms.Label();
			this.lblIPAddress = new System.Windows.Forms.Label();
			this.lblUsername = new System.Windows.Forms.Label();
			this.lblPassword = new System.Windows.Forms.Label();
			this.txtPort = new dotNetFlatControls.FlatTextBox();
			this.txtServerAddress = new dotNetFlatControls.FlatTextBox();
			this.txtPassword = new dotNetFlatControls.FlatTextBox();
			this.txtUsername = new dotNetFlatControls.FlatTextBox();
			this.gradHeader = new dotNetFlatControls.GradientPanel();
			this.pictureBox1 = new System.Windows.Forms.PictureBox();
			this.lblHeader = new dotNetFlatControls.FlatLabel();
			this.panLineHeader = new System.Windows.Forms.Panel();
			this.panel1 = new System.Windows.Forms.Panel();
			this.btnAdvanced = new System.Windows.Forms.Button();
			this.panSynchronization.SuspendLayout();
			this.customPanel2.SuspendLayout();
			this.panConnection.SuspendLayout();
			this.customPanel1.SuspendLayout();
			this.gradHeader.SuspendLayout();
			this.SuspendLayout();
			// 
			// btnCancel
			// 
			this.btnCancel.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.btnCancel.BackColor = System.Drawing.Color.WhiteSmoke;
			this.btnCancel.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnCancel.Location = new System.Drawing.Point(592, 372);
			this.btnCancel.Name = "btnCancel";
			this.btnCancel.TabIndex = 1;
			this.btnCancel.Text = "Cancel";
			this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
			// 
			// btnOK
			// 
			this.btnOK.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.btnOK.BackColor = System.Drawing.Color.WhiteSmoke;
			this.btnOK.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnOK.Location = new System.Drawing.Point(676, 372);
			this.btnOK.Name = "btnOK";
			this.btnOK.TabIndex = 2;
			this.btnOK.Text = "OK";
			this.btnOK.Click += new System.EventHandler(this.btnOK_Click);
			// 
			// tabSettings
			// 
			this.tabSettings.ActiveBackColor = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.tabSettings.ActiveBorderColor = System.Drawing.SystemColors.ActiveBorder;
			this.tabSettings.ActiveForeColor = System.Drawing.SystemColors.ControlText;
			this.tabSettings.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.tabSettings.DisabledBackColor = System.Drawing.Color.Gainsboro;
			this.tabSettings.DisabledBorderColor = System.Drawing.SystemColors.InactiveBorder;
			this.tabSettings.DisabledForeColor = System.Drawing.SystemColors.GrayText;
			this.tabSettings.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F);
			this.tabSettings.HighlightBorderColor = System.Drawing.SystemColors.Highlight;
			this.tabSettings.InActiveBackColor = System.Drawing.Color.FromArgb(((System.Byte)(213)), ((System.Byte)(219)), ((System.Byte)(233)));
			this.tabSettings.InActiveBorderColor = System.Drawing.SystemColors.InactiveBorder;
			this.tabSettings.InActiveForeColor = System.Drawing.SystemColors.ControlText;
			this.tabSettings.Location = new System.Drawing.Point(16, 72);
			this.tabSettings.Name = "tabSettings";
			this.tabSettings.Size = new System.Drawing.Size(776, 29);
			this.tabSettings.TabCount = 2;
			this.tabSettings.TabIndex = 3;
			this.tabSettings.TabNames = "Synchronization\r\nConnection Settings";
			this.tabSettings.SelectedIndexChange += new dotNetFlatControls.FlatTabStrip.SelectedIndexChangeEventHandler(this.tabSettings_SelectedIndexChange);
			// 
			// panLine
			// 
			this.panLine.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.panLine.BackColor = System.Drawing.SystemColors.ActiveBorder;
			this.panLine.Location = new System.Drawing.Point(0, 100);
			this.panLine.Name = "panLine";
			this.panLine.Size = new System.Drawing.Size(768, 1);
			this.panLine.TabIndex = 4;
			// 
			// panSynchronization
			// 
			this.panSynchronization.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.panSynchronization.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.panSynchronization.Controls.Add(this.gridProjects);
			this.panSynchronization.Controls.Add(this.customPanel2);
			this.panSynchronization.Location = new System.Drawing.Point(0, 100);
			this.panSynchronization.Name = "panSynchronization";
			this.panSynchronization.Size = new System.Drawing.Size(764, 252);
			this.panSynchronization.TabIndex = 5;
			// 
			// gridProjects
			// 
			this.gridProjects.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.gridProjects.AutoSizeMinHeight = 10;
			this.gridProjects.AutoSizeMinWidth = 10;
			this.gridProjects.AutoStretchColumnsToFitWidth = false;
			this.gridProjects.AutoStretchRowsToFitHeight = false;
			this.gridProjects.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.gridProjects.ContextMenuStyle = SourceGrid2.ContextMenuStyle.None;
			this.gridProjects.CustomSort = false;
			this.gridProjects.GridToolTipActive = true;
			this.gridProjects.Location = new System.Drawing.Point(20, 20);
			this.gridProjects.Name = "gridProjects";
			this.gridProjects.Size = new System.Drawing.Size(724, 216);
			this.gridProjects.SpecialKeys = SourceGrid2.GridSpecialKeys.Default;
			this.gridProjects.TabIndex = 5;
			// 
			// customPanel2
			// 
			this.customPanel2.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.customPanel2.BorderColor = System.Drawing.SystemColors.ActiveBorder;
			this.customPanel2.Controls.Add(this.customPanel3);
			this.customPanel2.GradientMode = dotNetFlatControls.LinearGradientMode.Horizontal;
			this.customPanel2.Location = new System.Drawing.Point(20, 20);
			this.customPanel2.Name = "customPanel2";
			this.customPanel2.Size = new System.Drawing.Size(744, 232);
			this.customPanel2.TabIndex = 44;
			// 
			// customPanel3
			// 
			this.customPanel3.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.customPanel3.GradientMode = dotNetFlatControls.LinearGradientMode.Vertical;
			this.customPanel3.Location = new System.Drawing.Point(724, 0);
			this.customPanel3.Name = "customPanel3";
			this.customPanel3.Size = new System.Drawing.Size(20, 216);
			this.customPanel3.TabIndex = 0;
			// 
			// panConnection
			// 
			this.panConnection.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.panConnection.Controls.Add(this.customPanel1);
			this.panConnection.Location = new System.Drawing.Point(0, 100);
			this.panConnection.Name = "panConnection";
			this.panConnection.Size = new System.Drawing.Size(764, 252);
			this.panConnection.TabIndex = 6;
			// 
			// customPanel1
			// 
			this.customPanel1.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.customPanel1.BorderColor = System.Drawing.SystemColors.ActiveBorder;
			this.customPanel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.customPanel1.Controls.Add(this.btnTest);
			this.customPanel1.Controls.Add(this.chkSavePassword);
			this.customPanel1.Controls.Add(this.lblPort);
			this.customPanel1.Controls.Add(this.lblIPAddress);
			this.customPanel1.Controls.Add(this.lblUsername);
			this.customPanel1.Controls.Add(this.lblPassword);
			this.customPanel1.Controls.Add(this.txtPort);
			this.customPanel1.Controls.Add(this.txtServerAddress);
			this.customPanel1.Controls.Add(this.txtPassword);
			this.customPanel1.Controls.Add(this.txtUsername);
			this.customPanel1.GradientMode = dotNetFlatControls.LinearGradientMode.Horizontal;
			this.customPanel1.Location = new System.Drawing.Point(24, 20);
			this.customPanel1.Name = "customPanel1";
			this.customPanel1.Size = new System.Drawing.Size(740, 236);
			this.customPanel1.TabIndex = 43;
			// 
			// btnTest
			// 
			this.btnTest.BackColor = System.Drawing.Color.WhiteSmoke;
			this.btnTest.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnTest.Location = new System.Drawing.Point(176, 152);
			this.btnTest.Name = "btnTest";
			this.btnTest.Size = new System.Drawing.Size(68, 23);
			this.btnTest.TabIndex = 48;
			this.btnTest.Text = "Test";
			this.btnTest.Click += new System.EventHandler(this.btnTest_Click);
			// 
			// chkSavePassword
			// 
			this.chkSavePassword.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.chkSavePassword.Location = new System.Drawing.Point(100, 116);
			this.chkSavePassword.Name = "chkSavePassword";
			this.chkSavePassword.Size = new System.Drawing.Size(134, 24);
			this.chkSavePassword.TabIndex = 47;
			this.chkSavePassword.Text = "Save Password?";
			// 
			// lblPort
			// 
			this.lblPort.Location = new System.Drawing.Point(20, 44);
			this.lblPort.Name = "lblPort";
			this.lblPort.Size = new System.Drawing.Size(66, 23);
			this.lblPort.TabIndex = 52;
			this.lblPort.Text = "Port";
			this.lblPort.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lblIPAddress
			// 
			this.lblIPAddress.Location = new System.Drawing.Point(20, 20);
			this.lblIPAddress.Name = "lblIPAddress";
			this.lblIPAddress.Size = new System.Drawing.Size(66, 23);
			this.lblIPAddress.TabIndex = 52;
			this.lblIPAddress.Text = "IP Address";
			this.lblIPAddress.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lblUsername
			// 
			this.lblUsername.Location = new System.Drawing.Point(20, 68);
			this.lblUsername.Name = "lblUsername";
			this.lblUsername.Size = new System.Drawing.Size(66, 23);
			this.lblUsername.TabIndex = 52;
			this.lblUsername.Text = "Username";
			this.lblUsername.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lblPassword
			// 
			this.lblPassword.Location = new System.Drawing.Point(20, 92);
			this.lblPassword.Name = "lblPassword";
			this.lblPassword.Size = new System.Drawing.Size(66, 23);
			this.lblPassword.TabIndex = 52;
			this.lblPassword.Text = "Password";
			this.lblPassword.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// txtPort
			// 
			this.txtPort.AutoSize = false;
			this.txtPort.BackColor = System.Drawing.Color.White;
			this.txtPort.BorderColor = System.Drawing.Color.DarkGray;
			this.txtPort.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.txtPort.FormatString = null;
			this.txtPort.FormatStyle = 0;
			this.txtPort.HighlightColor = System.Drawing.Color.RoyalBlue;
			this.txtPort.IsHighlighted = false;
			this.txtPort.IsLastTabStop = false;
			this.txtPort.Location = new System.Drawing.Point(100, 44);
			this.txtPort.Name = "txtPort";
			this.txtPort.Size = new System.Drawing.Size(144, 20);
			this.txtPort.TabIndex = 44;
			this.txtPort.Text = "";
			// 
			// txtServerAddress
			// 
			this.txtServerAddress.AutoSize = false;
			this.txtServerAddress.BackColor = System.Drawing.Color.White;
			this.txtServerAddress.BorderColor = System.Drawing.Color.DarkGray;
			this.txtServerAddress.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.txtServerAddress.FormatString = null;
			this.txtServerAddress.FormatStyle = 0;
			this.txtServerAddress.HighlightColor = System.Drawing.Color.RoyalBlue;
			this.txtServerAddress.IsHighlighted = false;
			this.txtServerAddress.IsLastTabStop = false;
			this.txtServerAddress.Location = new System.Drawing.Point(100, 20);
			this.txtServerAddress.Name = "txtServerAddress";
			this.txtServerAddress.Size = new System.Drawing.Size(144, 20);
			this.txtServerAddress.TabIndex = 43;
			this.txtServerAddress.Text = "";
			// 
			// txtPassword
			// 
			this.txtPassword.AutoSize = false;
			this.txtPassword.BackColor = System.Drawing.Color.White;
			this.txtPassword.BorderColor = System.Drawing.Color.DarkGray;
			this.txtPassword.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.txtPassword.FormatString = null;
			this.txtPassword.FormatStyle = 0;
			this.txtPassword.HighlightColor = System.Drawing.Color.RoyalBlue;
			this.txtPassword.IsHighlighted = false;
			this.txtPassword.IsLastTabStop = false;
			this.txtPassword.Location = new System.Drawing.Point(100, 92);
			this.txtPassword.Name = "txtPassword";
			this.txtPassword.PasswordChar = '*';
			this.txtPassword.Size = new System.Drawing.Size(144, 20);
			this.txtPassword.TabIndex = 46;
			this.txtPassword.Text = "";
			// 
			// txtUsername
			// 
			this.txtUsername.AutoSize = false;
			this.txtUsername.BackColor = System.Drawing.Color.White;
			this.txtUsername.BorderColor = System.Drawing.Color.DarkGray;
			this.txtUsername.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.txtUsername.FormatString = null;
			this.txtUsername.FormatStyle = 0;
			this.txtUsername.HighlightColor = System.Drawing.Color.RoyalBlue;
			this.txtUsername.IsHighlighted = false;
			this.txtUsername.IsLastTabStop = false;
			this.txtUsername.Location = new System.Drawing.Point(100, 68);
			this.txtUsername.Name = "txtUsername";
			this.txtUsername.Size = new System.Drawing.Size(144, 20);
			this.txtUsername.TabIndex = 45;
			this.txtUsername.Text = "";
			// 
			// gradHeader
			// 
			this.gradHeader.BackColor = System.Drawing.Color.GhostWhite;
			this.gradHeader.ColorFrom = System.Drawing.Color.GhostWhite;
			this.gradHeader.ColorTo = System.Drawing.Color.CornflowerBlue;
			this.gradHeader.Controls.Add(this.pictureBox1);
			this.gradHeader.FillStyle = 0;
			this.gradHeader.Location = new System.Drawing.Point(0, 0);
			this.gradHeader.Name = "gradHeader";
			this.gradHeader.RelativeStartPerc = 40;
			this.gradHeader.Size = new System.Drawing.Size(880, 52);
			this.gradHeader.TabIndex = 7;
			// 
			// pictureBox1
			// 
			this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
			this.pictureBox1.Location = new System.Drawing.Point(16, 12);
			this.pictureBox1.Name = "pictureBox1";
			this.pictureBox1.Size = new System.Drawing.Size(328, 28);
			this.pictureBox1.TabIndex = 0;
			this.pictureBox1.TabStop = false;
			// 
			// lblHeader
			// 
			this.lblHeader.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.lblHeader.Location = new System.Drawing.Point(0, 0);
			this.lblHeader.Name = "lblHeader";
			this.lblHeader.TabIndex = 0;
			// 
			// panLineHeader
			// 
			this.panLineHeader.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.panLineHeader.BackColor = System.Drawing.SystemColors.ActiveBorder;
			this.panLineHeader.Location = new System.Drawing.Point(0, 52);
			this.panLineHeader.Name = "panLineHeader";
			this.panLineHeader.Size = new System.Drawing.Size(768, 1);
			this.panLineHeader.TabIndex = 8;
			// 
			// panel1
			// 
			this.panel1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.panel1.BackColor = System.Drawing.SystemColors.ActiveBorder;
			this.panel1.Location = new System.Drawing.Point(-3, 352);
			this.panel1.Name = "panel1";
			this.panel1.Size = new System.Drawing.Size(768, 1);
			this.panel1.TabIndex = 9;
			// 
			// btnAdvanced
			// 
			this.btnAdvanced.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.btnAdvanced.BackColor = System.Drawing.Color.WhiteSmoke;
			this.btnAdvanced.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnAdvanced.Location = new System.Drawing.Point(12, 372);
			this.btnAdvanced.Name = "btnAdvanced";
			this.btnAdvanced.Size = new System.Drawing.Size(84, 23);
			this.btnAdvanced.TabIndex = 10;
			this.btnAdvanced.Text = "Advanced ...";
			this.btnAdvanced.Click += new System.EventHandler(this.btnAdvanced_Click);
			// 
			// Configuration
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.BackColor = System.Drawing.Color.White;
			this.ClientSize = new System.Drawing.Size(762, 404);
			this.Controls.Add(this.btnAdvanced);
			this.Controls.Add(this.tabSettings);
			this.Controls.Add(this.gradHeader);
			this.Controls.Add(this.panLine);
			this.Controls.Add(this.panSynchronization);
			this.Controls.Add(this.panel1);
			this.Controls.Add(this.panLineHeader);
			this.Controls.Add(this.btnOK);
			this.Controls.Add(this.btnCancel);
			this.Controls.Add(this.panConnection);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "Configuration";
			this.Text = "RoundTable OIS Outlook Configuration";
			this.panSynchronization.ResumeLayout(false);
			this.customPanel2.ResumeLayout(false);
			this.panConnection.ResumeLayout(false);
			this.customPanel1.ResumeLayout(false);
			this.gradHeader.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion
		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if(components != null)
				{
					components.Dispose();
				}
			}
			base.Dispose( disposing );
		}


		private void btnOK_Click(object sender, System.EventArgs e)
		{
			// save project and connection info to settings
			SaveConnectionSettings();
			SaveProjectSettings();

			syncMgr.Settings.ProjectInfoTable = hshProjects;
			syncMgr.Settings.SaveSettings();

			this.Close();
		}

		private void BrowseOutlookFolders_Click(object sender, SourceGrid2.PositionEventArgs e)
		{

			try
			{
				// display the Outlook PickFolder dialog
				MAPIFolder folder = syncMgr.AppOutlook.Session.PickFolder();

				if ( folder == null )
				{
					// they clicked cancel or something. do nothing
				}
				else
				{
					// make sure they've specified a valid task folder
					if ( folder.DefaultItemType == OlItemType.olTaskItem )
					{
						// update the grid
						gridProjects[e.Position.Row,col_SyncFolder].Value = 
							Utils.GetShortOutlookFolderName(folder.FolderPath);
					
						gridProjects[e.Position.Row,col_SyncFolderFull].Value = 
							folder.FolderPath.Replace("\\\\","");

						// add an event handler for the selected folder if not present
						syncMgr.AddSingleFolderEventHandler(folder, true);

						// remove the folder from ingored folder list, if appropriate
						if (syncMgr.Settings.IgnoredFolders.Contains(folder.FolderPath))
						{
							syncMgr.Settings.IgnoredFolders.Remove(folder.FolderPath);
						}
						
						// TODO: prompt the user if they would like to move existing tasks
						//       for this project to the new folder and if so, move them.
					}
					else
					{
						MessageBox.Show(this, "Please select a Task Item folder.","Invalid Folder",
							MessageBoxButtons.OK,MessageBoxIcon.Hand);
					}
				}
			}
			catch (System.Exception ex)
			{
				ErrorHandler.PublishError(ex, syncMgr.Logger);
			}
		}


		private void btnCancel_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		private void txtPassword_Enter(object sender, System.EventArgs e)
		{
			txtPassword.SelectAll();
		}


		private void tabSettings_SelectedIndexChange(int iIndexSelected, int iIndexFrom)
		{
			switch (iIndexSelected)
			{
				case TAB_SYNC: 
					panConnection.Visible = false;
					panSynchronization.Visible = true;
					break;
				case TAB_CONNECTION:
					panConnection.Visible = true;
					panSynchronization.Visible = false;
					break;
			}
		}

		private void btnTest_Click(object sender, System.EventArgs e)
		{

			this.Cursor = Cursors.WaitCursor;

			SaveConnectionSettings();

			if (syncMgr.GetConnection())
			{
				// enable the other tab, if not already
				tabSettings.Tabs.get_Item(1).Enabled = true;
				syncMgr.Settings.IsSuccessfulConnection = true;
				// populate the project info
				LoadProjectInfo();

				this.Cursor = Cursors.Default;
				MessageBox.Show(this, Utils.MESSAGE_CONNECT_SUCCESS,
					Utils.MESSAGE_CONNECT_SUCCESS_TITLE,
					MessageBoxButtons.OK, MessageBoxIcon.Information);
			}
			else
			{
				this.Cursor = Cursors.Default;
				MessageBox.Show(this, Utils.MESSAGE_CONNECT_FAILURE,
					Utils.MESSAGE_CONNECT_FAILURE_TITLE,
					MessageBoxButtons.OK, MessageBoxIcon.Information);
			}
		}

		private void btnAdvanced_Click(object sender, System.EventArgs e)
		{
			AdvancedSettings frmAdvanced = new AdvancedSettings();
			frmAdvanced.EditSettings(syncMgr);
		}
	}
}
