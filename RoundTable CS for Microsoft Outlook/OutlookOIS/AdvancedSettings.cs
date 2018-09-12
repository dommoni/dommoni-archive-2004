using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;

namespace OutlookOIS
{
	/// <summary>
	/// Summary description for AdvancedSettings.
	/// </summary>
	class AdvancedSettings : System.Windows.Forms.Form
	{
		private SyncManager syncMgr = null;
		private bool bIsOK = false;
		private dotNetFlatControls.GradientPanel panHeader;
		private dotNetFlatControls.FlatLabel lblHeader;
		private System.Windows.Forms.Button btnOK;
		private System.Windows.Forms.Button btnCancel;
		private dotNetFlatControls.FlatLabel flatLabel1;
		private dotNetFlatControls.FlatLabel flatLabel2;
		private dotNetFlatControls.FlatCheckBox chkRemoveDeleted;
		private dotNetFlatControls.FlatCheckBox chkRetrieveCompleted;
		private System.Windows.Forms.NumericUpDown spinSyncInterval;
		private dotNetFlatControls.FlatCheckBox chkSyncEnable;
		private dotNetFlatControls.CustomPanel a;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public AdvancedSettings()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();
		}



		public void EditSettings(SyncManager _syncMgr)
		{
			syncMgr = _syncMgr;

			LoadSettings();

			this.ShowDialog();

			if (bIsOK)
			{
				SaveSettings();
			}
		}

		private void LoadSettings()
		{
			chkSyncEnable.Checked = syncMgr.Settings.AutoSyncEnabled;
			spinSyncInterval.Value = syncMgr.Settings.AutoSyncInterval;
			chkRetrieveCompleted.Checked = syncMgr.Settings.SyncCompleted;
			chkRemoveDeleted.Checked = syncMgr.Settings.RemoveDeletedTasks;
		}
		private void SaveSettings()
		{
			syncMgr.Settings.AutoSyncEnabled = chkSyncEnable.Checked;
			syncMgr.Settings.SyncCompleted = chkRetrieveCompleted.Checked;
			syncMgr.Settings.RemoveDeletedTasks = chkRemoveDeleted.Checked;

			if ( Convert.ToInt32(spinSyncInterval.Value) != syncMgr.Settings.AutoSyncInterval )
			{
				syncMgr.Settings.AutoSyncInterval = Convert.ToInt32(spinSyncInterval.Value);
				syncMgr.StartTimer(); // restart the timer with the new interval
			}
		}

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

		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.a = new dotNetFlatControls.CustomPanel();
			this.chkRemoveDeleted = new dotNetFlatControls.FlatCheckBox();
			this.chkRetrieveCompleted = new dotNetFlatControls.FlatCheckBox();
			this.flatLabel2 = new dotNetFlatControls.FlatLabel();
			this.flatLabel1 = new dotNetFlatControls.FlatLabel();
			this.spinSyncInterval = new System.Windows.Forms.NumericUpDown();
			this.chkSyncEnable = new dotNetFlatControls.FlatCheckBox();
			this.btnOK = new System.Windows.Forms.Button();
			this.btnCancel = new System.Windows.Forms.Button();
			this.panHeader = new dotNetFlatControls.GradientPanel();
			this.lblHeader = new dotNetFlatControls.FlatLabel();
			this.a.SuspendLayout();
			((System.ComponentModel.ISupportInitialize)(this.spinSyncInterval)).BeginInit();
			this.panHeader.SuspendLayout();
			this.SuspendLayout();
			// 
			// a
			// 
			this.a.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.a.BackColor = System.Drawing.Color.White;
			this.a.BackColor2 = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.a.BorderColor = System.Drawing.Color.DarkSlateBlue;
			this.a.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.a.Controls.Add(this.chkRemoveDeleted);
			this.a.Controls.Add(this.chkRetrieveCompleted);
			this.a.Controls.Add(this.flatLabel2);
			this.a.Controls.Add(this.flatLabel1);
			this.a.Controls.Add(this.spinSyncInterval);
			this.a.Controls.Add(this.chkSyncEnable);
			this.a.Controls.Add(this.btnOK);
			this.a.Controls.Add(this.btnCancel);
			this.a.GradientMode = dotNetFlatControls.LinearGradientMode.Vertical;
			this.a.Location = new System.Drawing.Point(-4, 42);
			this.a.Name = "a";
			this.a.Size = new System.Drawing.Size(394, 206);
			this.a.TabIndex = 0;
			// 
			// chkRemoveDeleted
			// 
			this.chkRemoveDeleted.AutoSizeWidth = false;
			this.chkRemoveDeleted.FixedValue = 0;
			this.chkRemoveDeleted.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.chkRemoveDeleted.IsLastTabStop = false;
			this.chkRemoveDeleted.Location = new System.Drawing.Point(22, 106);
			this.chkRemoveDeleted.Name = "chkRemoveDeleted";
			this.chkRemoveDeleted.Size = new System.Drawing.Size(270, 28);
			this.chkRemoveDeleted.TabIndex = 10;
			this.chkRemoveDeleted.Text = "Remove other users\' tasks when they have been deleted from the RoundTable Project" +
				" Server?";
			// 
			// chkRetrieveCompleted
			// 
			this.chkRetrieveCompleted.FixedValue = 0;
			this.chkRetrieveCompleted.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.chkRetrieveCompleted.IsLastTabStop = false;
			this.chkRetrieveCompleted.Location = new System.Drawing.Point(24, 72);
			this.chkRetrieveCompleted.Name = "chkRetrieveCompleted";
			this.chkRetrieveCompleted.Size = new System.Drawing.Size(240, 24);
			this.chkRetrieveCompleted.TabIndex = 9;
			this.chkRetrieveCompleted.Text = "Retrieve completed tasks from the server?";
			// 
			// flatLabel2
			// 
			this.flatLabel2.BackColor = System.Drawing.Color.Transparent;
			this.flatLabel2.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.flatLabel2.Location = new System.Drawing.Point(276, 42);
			this.flatLabel2.Name = "flatLabel2";
			this.flatLabel2.Size = new System.Drawing.Size(47, 23);
			this.flatLabel2.TabIndex = 8;
			this.flatLabel2.Text = "minutes.";
			// 
			// flatLabel1
			// 
			this.flatLabel1.BackColor = System.Drawing.Color.Transparent;
			this.flatLabel1.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.flatLabel1.Location = new System.Drawing.Point(48, 42);
			this.flatLabel1.Name = "flatLabel1";
			this.flatLabel1.Size = new System.Drawing.Size(179, 23);
			this.flatLabel1.TabIndex = 7;
			this.flatLabel1.Text = "Synchronization should occur every ";
			// 
			// spinSyncInterval
			// 
			this.spinSyncInterval.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.spinSyncInterval.Location = new System.Drawing.Point(232, 42);
			this.spinSyncInterval.Name = "spinSyncInterval";
			this.spinSyncInterval.Size = new System.Drawing.Size(40, 20);
			this.spinSyncInterval.TabIndex = 6;
			// 
			// chkSyncEnable
			// 
			this.chkSyncEnable.FixedValue = 0;
			this.chkSyncEnable.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.chkSyncEnable.IsLastTabStop = false;
			this.chkSyncEnable.Location = new System.Drawing.Point(24, 14);
			this.chkSyncEnable.Name = "chkSyncEnable";
			this.chkSyncEnable.Size = new System.Drawing.Size(203, 24);
			this.chkSyncEnable.TabIndex = 5;
			this.chkSyncEnable.Text = "Enable automatic synchronization?";
			// 
			// btnOK
			// 
			this.btnOK.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.btnOK.BackColor = System.Drawing.Color.WhiteSmoke;
			this.btnOK.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnOK.Location = new System.Drawing.Point(306, 166);
			this.btnOK.Name = "btnOK";
			this.btnOK.TabIndex = 4;
			this.btnOK.Text = "OK";
			this.btnOK.Click += new System.EventHandler(this.btnOK_Click);
			// 
			// btnCancel
			// 
			this.btnCancel.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.btnCancel.BackColor = System.Drawing.Color.WhiteSmoke;
			this.btnCancel.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnCancel.Location = new System.Drawing.Point(222, 166);
			this.btnCancel.Name = "btnCancel";
			this.btnCancel.TabIndex = 3;
			this.btnCancel.Text = "Cancel";
			this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
			// 
			// panHeader
			// 
			this.panHeader.BackColor = System.Drawing.Color.GhostWhite;
			this.panHeader.ColorFrom = System.Drawing.Color.GhostWhite;
			this.panHeader.ColorTo = System.Drawing.Color.CornflowerBlue;
			this.panHeader.Controls.Add(this.lblHeader);
			this.panHeader.Dock = System.Windows.Forms.DockStyle.Top;
			this.panHeader.FillStyle = 0;
			this.panHeader.Location = new System.Drawing.Point(0, 0);
			this.panHeader.Name = "panHeader";
			this.panHeader.RelativeStartPerc = 30;
			this.panHeader.Size = new System.Drawing.Size(386, 44);
			this.panHeader.TabIndex = 1;
			// 
			// lblHeader
			// 
			this.lblHeader.BackColor = System.Drawing.Color.Transparent;
			this.lblHeader.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.lblHeader.Location = new System.Drawing.Point(18, 14);
			this.lblHeader.Name = "lblHeader";
			this.lblHeader.Size = new System.Drawing.Size(239, 23);
			this.lblHeader.TabIndex = 0;
			this.lblHeader.Text = "Advanced RoundTable Settings";
			// 
			// AdvancedSettings
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(386, 240);
			this.Controls.Add(this.a);
			this.Controls.Add(this.panHeader);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "AdvancedSettings";
			this.Text = "Advanced Settings";
			this.a.ResumeLayout(false);
			((System.ComponentModel.ISupportInitialize)(this.spinSyncInterval)).EndInit();
			this.panHeader.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void btnOK_Click(object sender, System.EventArgs e)
		{
			bIsOK = true;
			this.Close();
		}
		private void btnCancel_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}
	}
}
