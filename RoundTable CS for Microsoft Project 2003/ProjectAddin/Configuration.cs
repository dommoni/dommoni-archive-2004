using System;
using System.Data;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using Microsoft.Office.Interop.MSProject;
using System.Threading;

namespace ProjectAddin
{
	/// <summary>
	/// Summary description for Configuration.
	/// </summary>
	class Configuration : System.Windows.Forms.Form
	{
		// tab index values
		private const int TAB_CONNECTION = 2;

		private System.Windows.Forms.Button btnCancel;
		private System.Windows.Forms.Button btnOK;
		private System.Windows.Forms.Panel panLine;
		private dotNetFlatControls.GradientPanel gradHeader;
		private dotNetFlatControls.FlatLabel lblHeader;
		private System.Windows.Forms.Panel panLineHeader;
		private System.Windows.Forms.Panel panel1;
		private dotNetFlatControls.FlatTabStrip tabSettings;
		private System.Windows.Forms.Panel panConnection;
		private System.Windows.Forms.Button btnTest;
		private System.Windows.Forms.CheckBox chkSavePassword;
		private System.Windows.Forms.Label lblPort;
		private System.Windows.Forms.Label lblIPAddress;
		private System.Windows.Forms.Label lblUsername;
		private System.Windows.Forms.Label lblPassword;
		private dotNetFlatControls.FlatTextBox txtPort;
		private dotNetFlatControls.FlatTextBox txtServerAddress;
		private dotNetFlatControls.FlatTextBox txtPassword;
		private dotNetFlatControls.FlatTextBox txtUsername;
		private dotNetFlatControls.CustomPanel customPanel1;
		private dotNetFlatControls.FlatLabel flatLabel1;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public Configuration()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();
			
			// TODO: pass in something to maintain settings info (username, password, etc.)

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

				// TODO: attempt to get a connection to the server using current credentials

				// close the progress bar
				frmConnectionProgress.Close();
				if ( thread != null && thread.ThreadState != ThreadState.Stopped ) thread.Abort();

				bNoConnection = false;

				if (bNoConnection) 
				{
					// TODO: handle failed connection
				}

				// show the dialog regardless of whether or not we got a connection
				this.ShowDialog();

			}
			catch (System.Exception ex) 
			{
//				ErrorHandler.PublishError(ex, syncMgr.Logger);
			}
			finally 
			{
				// just in case the progress bar is still open (due to an exception), close it
				if (frmConnectionProgress != null) frmConnectionProgress.Close();
			}
		}
		
		private void LoadConnectionInfo()
		{
			// TODO: Load the connection information from the settings object
//			txtServerAddress.Text = syncMgr.Settings.ServerAddress;
//			txtPort.Text = syncMgr.Settings.Port.ToString();
//			txtUsername.Text = syncMgr.Settings.User;
//			chkSavePassword.Checked = syncMgr.Settings.SavePassword;
//			if ( syncMgr.Settings.SavePassword ) txtPassword.Text = "********";
		}

		private void SaveConnectionSettings()
		{
			
			// TODO: Save connection settings

			//			syncMgr.Settings.User = txtUsername.Text;
//			syncMgr.Settings.ServerAddress = txtServerAddress.Text;
//			syncMgr.Settings.Port = Convert.ToInt32(txtPort.Text);
//			syncMgr.Settings.SavePassword = chkSavePassword.Checked;
//
//			if ( txtPassword.Modified ) 
//			{
//				syncMgr.Settings.Password = txtPassword.Text;
//			}
		}

		// NO TOUCHY !
		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.btnCancel = new System.Windows.Forms.Button();
			this.btnOK = new System.Windows.Forms.Button();
			this.tabSettings = new dotNetFlatControls.FlatTabStrip();
			this.panLine = new System.Windows.Forms.Panel();
			this.gradHeader = new dotNetFlatControls.GradientPanel();
			this.lblHeader = new dotNetFlatControls.FlatLabel();
			this.panLineHeader = new System.Windows.Forms.Panel();
			this.panel1 = new System.Windows.Forms.Panel();
			this.panConnection = new System.Windows.Forms.Panel();
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
			this.customPanel1 = new dotNetFlatControls.CustomPanel();
			this.flatLabel1 = new dotNetFlatControls.FlatLabel();
			this.gradHeader.SuspendLayout();
			this.panConnection.SuspendLayout();
			this.customPanel1.SuspendLayout();
			this.SuspendLayout();
			// 
			// btnCancel
			// 
			this.btnCancel.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.btnCancel.BackColor = System.Drawing.Color.WhiteSmoke;
			this.btnCancel.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnCancel.Location = new System.Drawing.Point(320, 372);
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
			this.btnOK.Location = new System.Drawing.Point(404, 372);
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
			this.tabSettings.Size = new System.Drawing.Size(504, 29);
			this.tabSettings.TabCount = 1;
			this.tabSettings.TabIndex = 3;
			this.tabSettings.TabNames = "Connection Settings";
			this.tabSettings.SelectedIndexChange += new dotNetFlatControls.FlatTabStrip.SelectedIndexChangeEventHandler(this.tabSettings_SelectedIndexChange);
			// 
			// panLine
			// 
			this.panLine.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.panLine.BackColor = System.Drawing.SystemColors.ActiveBorder;
			this.panLine.Location = new System.Drawing.Point(0, 100);
			this.panLine.Name = "panLine";
			this.panLine.Size = new System.Drawing.Size(496, 1);
			this.panLine.TabIndex = 4;
			// 
			// gradHeader
			// 
			this.gradHeader.BackColor = System.Drawing.Color.GhostWhite;
			this.gradHeader.ColorFrom = System.Drawing.Color.GhostWhite;
			this.gradHeader.ColorTo = System.Drawing.Color.CornflowerBlue;
			this.gradHeader.Controls.Add(this.flatLabel1);
			this.gradHeader.FillStyle = 0;
			this.gradHeader.Location = new System.Drawing.Point(0, 0);
			this.gradHeader.Name = "gradHeader";
			this.gradHeader.RelativeStartPerc = 40;
			this.gradHeader.Size = new System.Drawing.Size(704, 52);
			this.gradHeader.TabIndex = 7;
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
			this.panLineHeader.Size = new System.Drawing.Size(496, 1);
			this.panLineHeader.TabIndex = 8;
			// 
			// panel1
			// 
			this.panel1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.panel1.BackColor = System.Drawing.SystemColors.ActiveBorder;
			this.panel1.Location = new System.Drawing.Point(-3, 352);
			this.panel1.Name = "panel1";
			this.panel1.Size = new System.Drawing.Size(496, 1);
			this.panel1.TabIndex = 9;
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
			this.chkSavePassword.BackColor = System.Drawing.Color.Transparent;
			this.chkSavePassword.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.chkSavePassword.Location = new System.Drawing.Point(100, 116);
			this.chkSavePassword.Name = "chkSavePassword";
			this.chkSavePassword.Size = new System.Drawing.Size(134, 24);
			this.chkSavePassword.TabIndex = 47;
			this.chkSavePassword.Text = "Save Password?";
			// 
			// lblPort
			// 
			this.lblPort.BackColor = System.Drawing.Color.Transparent;
			this.lblPort.Location = new System.Drawing.Point(20, 44);
			this.lblPort.Name = "lblPort";
			this.lblPort.Size = new System.Drawing.Size(66, 23);
			this.lblPort.TabIndex = 52;
			this.lblPort.Text = "Port";
			this.lblPort.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lblIPAddress
			// 
			this.lblIPAddress.BackColor = System.Drawing.Color.Transparent;
			this.lblIPAddress.Location = new System.Drawing.Point(20, 20);
			this.lblIPAddress.Name = "lblIPAddress";
			this.lblIPAddress.Size = new System.Drawing.Size(66, 23);
			this.lblIPAddress.TabIndex = 52;
			this.lblIPAddress.Text = "IP Address";
			this.lblIPAddress.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lblUsername
			// 
			this.lblUsername.BackColor = System.Drawing.Color.Transparent;
			this.lblUsername.Location = new System.Drawing.Point(20, 68);
			this.lblUsername.Name = "lblUsername";
			this.lblUsername.Size = new System.Drawing.Size(66, 23);
			this.lblUsername.TabIndex = 52;
			this.lblUsername.Text = "Username";
			this.lblUsername.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lblPassword
			// 
			this.lblPassword.BackColor = System.Drawing.Color.Transparent;
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
			// flatLabel1
			// 
			this.flatLabel1.AutoSizeWidth = false;
			this.flatLabel1.BackColor = System.Drawing.Color.Transparent;
			this.flatLabel1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.flatLabel1.Location = new System.Drawing.Point(24, 16);
			this.flatLabel1.Name = "flatLabel1";
			this.flatLabel1.Size = new System.Drawing.Size(248, 24);
			this.flatLabel1.TabIndex = 0;
			this.flatLabel1.Text = "RoundTable OIS Configuration";
			// 
			// Configuration
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.BackColor = System.Drawing.Color.White;
			this.ClientSize = new System.Drawing.Size(490, 404);
			this.Controls.Add(this.tabSettings);
			this.Controls.Add(this.gradHeader);
			this.Controls.Add(this.panLine);
			this.Controls.Add(this.panel1);
			this.Controls.Add(this.panLineHeader);
			this.Controls.Add(this.btnOK);
			this.Controls.Add(this.btnCancel);
			this.Controls.Add(this.panConnection);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "Configuration";
			this.Text = "RoundTable OIS Project Configuration";
			this.gradHeader.ResumeLayout(false);
			this.panConnection.ResumeLayout(false);
			this.customPanel1.ResumeLayout(false);
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

//			syncMgr.Settings.SaveSettings();

			this.Close();
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
//			switch (iIndexSelected)
//			{
//				case TAB_SYNC: 
//					panConnection.Visible = false;
//					panSynchronization.Visible = true;
//					break;
//				case TAB_CONNECTION:
//					panConnection.Visible = true;
//					panSynchronization.Visible = false;
//					break;
//			}
		}

		private void btnTest_Click(object sender, System.EventArgs e)
		{

			this.Cursor = Cursors.WaitCursor;

			SaveConnectionSettings();

			// TODO: Put back what's needed for testing connection

//			if (syncMgr.GetConnection())
//			{
//				// enable the other tab, if not already
//				tabSettings.Tabs.get_Item(1).Enabled = true;
//				syncMgr.Settings.IsSuccessfulConnection = true;
//				// populate the project info
//				LoadProjectInfo();
//
//				this.Cursor = Cursors.Default;
//				MessageBox.Show(this, Utils.MESSAGE_CONNECT_SUCCESS,
//					Utils.MESSAGE_CONNECT_SUCCESS_TITLE,
//					MessageBoxButtons.OK, MessageBoxIcon.Information);
//			}
//			else
//			{
//				this.Cursor = Cursors.Default;
//				MessageBox.Show(this, Utils.MESSAGE_CONNECT_FAILURE,
//					Utils.MESSAGE_CONNECT_FAILURE_TITLE,
//					MessageBoxButtons.OK, MessageBoxIcon.Information);
//			}
		}
	}
}
