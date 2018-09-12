using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using Microsoft.Office.Interop.Outlook;

namespace OutlookOIS
{
	/// <summary>
	/// Summary description for AssignProjectID.
	/// </summary>
	class AssignProjectID : System.Windows.Forms.Form
	{
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		private SyncManager syncMgr;

		private dotNetFlatControls.GradientPanel panHeader;
		private dotNetFlatControls.FlatLabel lblHeader;
		private dotNetFlatControls.CustomPanel customPanel1;
		private System.Windows.Forms.Button btnCancel;
		private System.Windows.Forms.Button btnOK;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.ListBox lstProjects;
		private dotNetFlatControls.FlatCheckBox chkIgnoreFolder;

		private int iSelectedProject = -1;
		private bool bIgnoreFolder = false;

		public void AssignTaskProjID(TaskItem taskItem)
		{
			// if the user selects a project from the list,
			// set the project ID on the task. 
			PopulateProjectList();

			this.ShowDialog();

			if (iSelectedProject > 0 ) 
			{
				taskItem.UserProperties.Add(Utils.RT_TODO_PROJID_PROP_NAME,OlUserPropertyType.olNumber,true,Type.Missing);
				taskItem.UserProperties[Utils.RT_TODO_PROJID_PROP_NAME].Value = iSelectedProject;
				taskItem.Save();
			}

			if ( bIgnoreFolder ) 
			{
				syncMgr.Settings.IgnoredFolders.Add(((MAPIFolder) taskItem.Parent).FolderPath);
			}
		}

		private void PopulateProjectList()
		{
			try
			{
				// add the default item for non RT tasks
				lstProjects.Items.Add(Utils.NON_RT_TASK);
				
				Hashtable hshProjects = syncMgr.GetProjects(true);

				foreach(ProjectInfo proj in hshProjects.Values)
				{
					lstProjects.Items.Add(proj);
				}
			}
			catch(System.Exception ex)
			{
				ErrorHandler.PublishError(ex, syncMgr.Logger);
			}
		}

		public AssignProjectID(SyncManager _syncMgr)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			syncMgr = _syncMgr;
			lstProjects.DoubleClick +=new EventHandler(lstProjects_DoubleClick);
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
			this.panHeader = new dotNetFlatControls.GradientPanel();
			this.lblHeader = new dotNetFlatControls.FlatLabel();
			this.customPanel1 = new dotNetFlatControls.CustomPanel();
			this.btnCancel = new System.Windows.Forms.Button();
			this.btnOK = new System.Windows.Forms.Button();
			this.label2 = new System.Windows.Forms.Label();
			this.label1 = new System.Windows.Forms.Label();
			this.lstProjects = new System.Windows.Forms.ListBox();
			this.chkIgnoreFolder = new dotNetFlatControls.FlatCheckBox();
			this.panHeader.SuspendLayout();
			this.customPanel1.SuspendLayout();
			this.SuspendLayout();
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
			this.panHeader.RelativeStartPerc = 10;
			this.panHeader.Size = new System.Drawing.Size(294, 40);
			this.panHeader.TabIndex = 6;
			// 
			// lblHeader
			// 
			this.lblHeader.BackColor = System.Drawing.Color.Transparent;
			this.lblHeader.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.lblHeader.Location = new System.Drawing.Point(12, 10);
			this.lblHeader.Name = "lblHeader";
			this.lblHeader.Size = new System.Drawing.Size(239, 23);
			this.lblHeader.TabIndex = 0;
			this.lblHeader.Text = "Assign Task to Project";
			// 
			// customPanel1
			// 
			this.customPanel1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.customPanel1.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.customPanel1.BackColor2 = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.customPanel1.BorderColor = System.Drawing.Color.DarkBlue;
			this.customPanel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.customPanel1.Controls.Add(this.chkIgnoreFolder);
			this.customPanel1.Controls.Add(this.btnCancel);
			this.customPanel1.Controls.Add(this.btnOK);
			this.customPanel1.Controls.Add(this.label2);
			this.customPanel1.Controls.Add(this.label1);
			this.customPanel1.Controls.Add(this.lstProjects);
			this.customPanel1.Location = new System.Drawing.Point(-8, 40);
			this.customPanel1.Name = "customPanel1";
			this.customPanel1.Size = new System.Drawing.Size(304, 280);
			this.customPanel1.TabIndex = 7;
			// 
			// btnCancel
			// 
			this.btnCancel.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.btnCancel.BackColor = System.Drawing.SystemColors.ControlLight;
			this.btnCancel.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnCancel.Location = new System.Drawing.Point(76, 240);
			this.btnCancel.Name = "btnCancel";
			this.btnCancel.Size = new System.Drawing.Size(72, 23);
			this.btnCancel.TabIndex = 10;
			this.btnCancel.Text = "Cancel";
			this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
			// 
			// btnOK
			// 
			this.btnOK.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.btnOK.BackColor = System.Drawing.SystemColors.ControlLight;
			this.btnOK.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.btnOK.Location = new System.Drawing.Point(156, 240);
			this.btnOK.Name = "btnOK";
			this.btnOK.Size = new System.Drawing.Size(72, 23);
			this.btnOK.TabIndex = 9;
			this.btnOK.Text = "OK";
			this.btnOK.Click += new System.EventHandler(this.btnOK_Click);
			// 
			// label2
			// 
			this.label2.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.label2.Location = new System.Drawing.Point(20, 176);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(272, 32);
			this.label2.TabIndex = 8;
			this.label2.Text = "Select \"None\" or click Cancel to cause the new task to be ignored by RoundTable.";
			// 
			// label1
			// 
			this.label1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.label1.Location = new System.Drawing.Point(20, 20);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(272, 32);
			this.label1.TabIndex = 7;
			this.label1.Text = "If you would like to assign the newly created task to a RoundTable Project, selec" +
				"t the project from the list.";
			// 
			// lstProjects
			// 
			this.lstProjects.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.lstProjects.Location = new System.Drawing.Point(20, 60);
			this.lstProjects.Name = "lstProjects";
			this.lstProjects.Size = new System.Drawing.Size(272, 108);
			this.lstProjects.TabIndex = 6;
			// 
			// chkIgnoreFolder
			// 
			this.chkIgnoreFolder.FixedValue = 0;
			this.chkIgnoreFolder.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
			this.chkIgnoreFolder.IsLastTabStop = false;
			this.chkIgnoreFolder.Location = new System.Drawing.Point(20, 204);
			this.chkIgnoreFolder.Name = "chkIgnoreFolder";
			this.chkIgnoreFolder.Size = new System.Drawing.Size(174, 24);
			this.chkIgnoreFolder.TabIndex = 12;
			this.chkIgnoreFolder.Text = "Don\'t ask again for this folder";
			// 
			// AssignProjectID
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.ClientSize = new System.Drawing.Size(294, 316);
			this.Controls.Add(this.customPanel1);
			this.Controls.Add(this.panHeader);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
			this.Name = "AssignProjectID";
			this.Text = "Assign Task to RoundTable Project ";
			this.panHeader.ResumeLayout(false);
			this.customPanel1.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void btnCancel_Click(object sender, System.EventArgs e)
		{
			this.Close();
		}

		private void btnOK_Click(object sender, System.EventArgs e)
		{
			try
			{
				if (lstProjects.SelectedIndex > 0 )
				{
					ProjectInfo proj = (ProjectInfo) lstProjects.SelectedItem;
					iSelectedProject = proj.ProjID;
				}

				bIgnoreFolder = chkIgnoreFolder.Checked;
			}
			catch (System.Exception ex)
			{
				ErrorHandler.PublishError(ex, syncMgr.Logger);
			}
			finally
			{
				this.Close();
			}
		}
		private void lstProjects_DoubleClick(object sender, System.EventArgs e)
		{
			btnOK_Click(sender, e);
		}
	}
}
