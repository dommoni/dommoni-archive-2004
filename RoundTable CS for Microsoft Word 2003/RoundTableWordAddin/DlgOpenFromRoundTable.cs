/*using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.IO;
using System.Windows.Forms;

using RoundTable;

namespace RoundTableWordAddin
{
	/// <summary>
	/// Summary description for DlgOpenFromRoundTable.
	/// </summary>
	public class DlgOpenFromRoundTable : System.Windows.Forms.Form
	{
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public DlgOpenFromRoundTable(IDocumentActivator activator, ProjectServerConnection psc)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
			listBox1.MouseDown += new MouseEventHandler(listBox1_MouseDown);
			listBox1.KeyDown += new KeyEventHandler(listBox1_KeyDown);

			this.documentActivator = activator;
			this.psc = psc;
			hshProjects = new Hashtable();
			hshDocuments = new Hashtable();

			Project[] projects = psc.ProjectManager.getAllProjectsForAccount(psc.Account.id);
			foreach(Project p in projects)
			{
				comboBox1.Items.Add(p.name);
				hshProjects.Add(p.name, p);
			}

			if(comboBox1.Items.Count > 0)
				comboBox1.Text = (string)comboBox1.Items[0];
			else
				MessageBox.Show("You are not currently a member of any RoundTable Projects.");
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
			this.comboBox1 = new System.Windows.Forms.ComboBox();
			this.lbProject = new System.Windows.Forms.Label();
			this.label1 = new System.Windows.Forms.Label();
			this.listBox1 = new System.Windows.Forms.ListBox();
			this.SuspendLayout();
			// 
			// comboBox1
			// 
			this.comboBox1.Location = new System.Drawing.Point(136, 24);
			this.comboBox1.Name = "comboBox1";
			this.comboBox1.Size = new System.Drawing.Size(121, 21);
			this.comboBox1.TabIndex = 0;
			this.comboBox1.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged);
			// 
			// lbProject
			// 
			this.lbProject.Location = new System.Drawing.Point(16, 24);
			this.lbProject.Name = "lbProject";
			this.lbProject.TabIndex = 1;
			this.lbProject.Text = "Project:";
			// 
			// label1
			// 
			this.label1.Location = new System.Drawing.Point(16, 64);
			this.label1.Name = "label1";
			this.label1.TabIndex = 2;
			this.label1.Text = "Documents:";
			// 
			// listBox1
			// 
			this.listBox1.Location = new System.Drawing.Point(16, 96);
			this.listBox1.Name = "listBox1";
			this.listBox1.Size = new System.Drawing.Size(264, 147);
			this.listBox1.TabIndex = 3;
			this.listBox1.SelectedIndexChanged += new System.EventHandler(this.listBox1_SelectedIndexChanged);
			// 
			// DlgOpenFromRoundTable
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(292, 266);
			this.Controls.Add(this.listBox1);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.lbProject);
			this.Controls.Add(this.comboBox1);
			this.Name = "DlgOpenFromRoundTable";
			this.Text = "DlgOpenFromRoundTable";
			this.ResumeLayout(false);

		}
		#endregion

		private System.Windows.Forms.ComboBox comboBox1;
		private System.Windows.Forms.Label lbProject;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.ListBox listBox1;
	
		// Member Variables
		//private Word.Application word;
		private IDocumentActivator documentActivator;
		private ProjectServerConnection psc;
		private Hashtable hshProjects;
		private Hashtable hshDocuments;

		private void listBox1_SelectedIndexChanged(object sender, System.EventArgs e)
		{
		
		}

		private void comboBox1_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			ComboBox cb1 = (ComboBox)sender;
			
			// clean out the old items from the list control.
			listBox1.Items.Clear();
			hshDocuments.Clear();
			
			string projectName = (string)cb1.SelectedItem;
			
			Project project = (Project)hshProjects[projectName];
			Document[] projectDocuments = psc.DocumentManager.getDocumentsForProjectFromDocumentType(project.id, DocumentType.MSOFFICE_WORD);
			if (projectDocuments != null && projectDocuments.Length > 0)
			{
				foreach(Document doc in projectDocuments)
				{
					listBox1.Items.Add(doc.name);
					hshDocuments.Add(doc.name, doc);
				}
			}
			else
			{
				listBox1.Items.Add("[NO AVAILABLE DOCUMENTS]");
			}
		}

		private void listBox1_MouseDown(object sender, MouseEventArgs e)
		{
			ListBox lb = (ListBox)sender;
			if (e.Clicks == 2)
			{
				Document doc = (Document)hshDocuments[listBox1.SelectedItem];
				documentActivator.ActivateDocument(doc, this.psc);
				this.Close();
			}
		}

		private void listBox1_KeyDown(object sender, KeyEventArgs e)
		{
			MessageBox.Show("Key: " + e.KeyData.ToString());
		}
	}
}
*/

using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.IO;
using System.Threading;
using System.Windows.Forms;

using RoundTable;
using dotNetFlatControls;

namespace RoundTableWordAddin
{
	/// <summary>
	/// Summary description for BuildSchedFromTasksDlg.
	/// </summary>
	public class DlgOpenFromRoundTable : System.Windows.Forms.Form
	{
		Word.Application msword;
		ProjectServerConnection psc;

		private IDocumentActivator documentActivator;

		private Hashtable hshProjects;
		private Hashtable hshDocuments;
		private System.Windows.Forms.Panel panLine;
		private System.Windows.Forms.Panel panSynchronization;
		private System.Windows.Forms.Panel panConnection;
		private dotNetFlatControls.GradientPanel gradHeader;
		private dotNetFlatControls.FlatLabel lblHeader;
		private System.Windows.Forms.Panel panLineHeader;
		private System.Windows.Forms.Panel panel1;
		private dotNetFlatControls.CustomPanel customPanel1;
		private System.Windows.Forms.Button btnTest;
		private System.Windows.Forms.CheckBox chkSavePassword;
		private dotNetFlatControls.CustomPanel customPanel2;
		private dotNetFlatControls.CustomPanel customPanel3;
		private dotNetFlatControls.CustomPanel customPanel4;
		private System.Windows.Forms.Panel panel2;
		private dotNetFlatControls.FlatLabel flatLabel1;
		private dotNetFlatControls.FlatLabel flatLabel2;
		private System.Windows.Forms.ComboBox comboBox1;
		private dotNetFlatControls.FlatListBox listBox1;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public DlgOpenFromRoundTable(IDocumentActivator activator, ProjectServerConnection psc)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();
	
			//
			// TODO: Add any constructor code after InitializeComponent call
			//
			listBox1.MouseDown += new MouseEventHandler(listBox1_MouseDown);
			listBox1.KeyDown += new KeyEventHandler(listBox1_KeyDown);

			this.documentActivator = activator;
			this.psc = psc;
			hshProjects = new Hashtable();
			hshDocuments = new Hashtable();

			Project[] projects = psc.ProjectManager.getAllProjectsForAccount(psc.Account.id);
			foreach(Project p in projects)
			{
				comboBox1.Items.Add(p.name);
				hshProjects.Add(p.name, p);
			}

			if(comboBox1.Items.Count > 0)
				comboBox1.Text = (string)comboBox1.Items[0];
			else
				MessageBox.Show("You are not currently a member of any RoundTable Projects.");
		}
		
		#region Windows Form Designer generated code
		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent()
		{
			this.panLine = new System.Windows.Forms.Panel();
			this.panSynchronization = new System.Windows.Forms.Panel();
			this.customPanel4 = new dotNetFlatControls.CustomPanel();
			this.customPanel2 = new dotNetFlatControls.CustomPanel();
			this.panel2 = new System.Windows.Forms.Panel();
			this.listBox1 = new dotNetFlatControls.FlatListBox();
			this.comboBox1 = new System.Windows.Forms.ComboBox();
			this.flatLabel2 = new dotNetFlatControls.FlatLabel();
			this.customPanel3 = new dotNetFlatControls.CustomPanel();
			this.panConnection = new System.Windows.Forms.Panel();
			this.customPanel1 = new dotNetFlatControls.CustomPanel();
			this.btnTest = new System.Windows.Forms.Button();
			this.chkSavePassword = new System.Windows.Forms.CheckBox();
			this.gradHeader = new dotNetFlatControls.GradientPanel();
			this.flatLabel1 = new dotNetFlatControls.FlatLabel();
			this.lblHeader = new dotNetFlatControls.FlatLabel();
			this.panLineHeader = new System.Windows.Forms.Panel();
			this.panel1 = new System.Windows.Forms.Panel();
			this.panSynchronization.SuspendLayout();
			this.customPanel2.SuspendLayout();
			this.panel2.SuspendLayout();
			this.panConnection.SuspendLayout();
			this.customPanel1.SuspendLayout();
			this.gradHeader.SuspendLayout();
			this.SuspendLayout();
			// 
			// panLine
			// 
			this.panLine.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.panLine.BackColor = System.Drawing.SystemColors.ActiveBorder;
			this.panLine.Location = new System.Drawing.Point(0, 100);
			this.panLine.Name = "panLine";
			this.panLine.Size = new System.Drawing.Size(435, 1);
			this.panLine.TabIndex = 4;
			// 
			// panSynchronization
			// 
			this.panSynchronization.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.panSynchronization.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.panSynchronization.Controls.Add(this.customPanel4);
			this.panSynchronization.Controls.Add(this.customPanel2);
			this.panSynchronization.Location = new System.Drawing.Point(0, 100);
			this.panSynchronization.Name = "panSynchronization";
			this.panSynchronization.Size = new System.Drawing.Size(435, 255);
			this.panSynchronization.TabIndex = 5;
			// 
			// customPanel4
			// 
			this.customPanel4.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.customPanel4.GradientMode = dotNetFlatControls.LinearGradientMode.Vertical;
			this.customPanel4.Location = new System.Drawing.Point(407, 24);
			this.customPanel4.Name = "customPanel4";
			this.customPanel4.Size = new System.Drawing.Size(22, 232);
			this.customPanel4.TabIndex = 45;
			// 
			// customPanel2
			// 
			this.customPanel2.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.customPanel2.BorderColor = System.Drawing.SystemColors.ActiveBorder;
			this.customPanel2.Controls.Add(this.panel2);
			this.customPanel2.Controls.Add(this.customPanel3);
			this.customPanel2.GradientMode = dotNetFlatControls.LinearGradientMode.Horizontal;
			this.customPanel2.Location = new System.Drawing.Point(20, 20);
			this.customPanel2.Name = "customPanel2";
			this.customPanel2.Size = new System.Drawing.Size(388, 236);
			this.customPanel2.TabIndex = 44;
			// 
			// panel2
			// 
			this.panel2.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.panel2.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.panel2.Controls.Add(this.listBox1);
			this.panel2.Controls.Add(this.comboBox1);
			this.panel2.Controls.Add(this.flatLabel2);
			this.panel2.Location = new System.Drawing.Point(0, 0);
			this.panel2.Name = "panel2";
			this.panel2.Size = new System.Drawing.Size(387, 216);
			this.panel2.TabIndex = 1;
			// 
			// listBox1
			// 
			this.listBox1.BorderColor = System.Drawing.Color.LightGray;
			this.listBox1.BorderStyle = System.Windows.Forms.BorderStyle.None;
			this.listBox1.Location = new System.Drawing.Point(16, 56);
			this.listBox1.Name = "listBox1";
			this.listBox1.ScrollAlwaysVisible = true;
			this.listBox1.Size = new System.Drawing.Size(352, 143);
			this.listBox1.TabIndex = 7;
			// 
			// comboBox1
			// 
			this.comboBox1.Location = new System.Drawing.Point(152, 24);
			this.comboBox1.Name = "comboBox1";
			this.comboBox1.Size = new System.Drawing.Size(216, 21);
			this.comboBox1.TabIndex = 2;
			this.comboBox1.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged);
			// 
			// flatLabel2
			// 
			this.flatLabel2.BackColor = System.Drawing.Color.Transparent;
			this.flatLabel2.Font = new System.Drawing.Font("Microsoft Sans Serif", 8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.flatLabel2.Location = new System.Drawing.Point(16, 24);
			this.flatLabel2.Name = "flatLabel2";
			this.flatLabel2.Size = new System.Drawing.Size(139, 23);
			this.flatLabel2.TabIndex = 1;
			this.flatLabel2.Text = "Select Project:";
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
			this.panConnection.Size = new System.Drawing.Size(400, 252);
			this.panConnection.TabIndex = 6;
			// 
			// customPanel1
			// 
			this.customPanel1.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.customPanel1.BorderColor = System.Drawing.SystemColors.ActiveBorder;
			this.customPanel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.customPanel1.Controls.Add(this.btnTest);
			this.customPanel1.Controls.Add(this.chkSavePassword);
			this.customPanel1.GradientMode = dotNetFlatControls.LinearGradientMode.Horizontal;
			this.customPanel1.Location = new System.Drawing.Point(24, 20);
			this.customPanel1.Name = "customPanel1";
			this.customPanel1.Size = new System.Drawing.Size(400, 236);
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
			this.gradHeader.Size = new System.Drawing.Size(432, 52);
			this.gradHeader.TabIndex = 7;
			// 
			// flatLabel1
			// 
			this.flatLabel1.BackColor = System.Drawing.Color.Transparent;
			this.flatLabel1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.flatLabel1.Location = new System.Drawing.Point(8, 16);
			this.flatLabel1.Name = "flatLabel1";
			this.flatLabel1.Size = new System.Drawing.Size(258, 24);
			this.flatLabel1.TabIndex = 0;
			this.flatLabel1.Text = "Open Word Document from RoundTable";
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
			this.panLineHeader.Size = new System.Drawing.Size(428, 1);
			this.panLineHeader.TabIndex = 8;
			// 
			// panel1
			// 
			this.panel1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.panel1.BackColor = System.Drawing.SystemColors.ActiveBorder;
			this.panel1.Location = new System.Drawing.Point(0, 355);
			this.panel1.Name = "panel1";
			this.panel1.Size = new System.Drawing.Size(435, 1);
			this.panel1.TabIndex = 9;
			// 
			// DlgOpenFromRoundTable
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.BackColor = System.Drawing.Color.White;
			this.ClientSize = new System.Drawing.Size(426, 404);
			this.Controls.Add(this.gradHeader);
			this.Controls.Add(this.panLine);
			this.Controls.Add(this.panSynchronization);
			this.Controls.Add(this.panel1);
			this.Controls.Add(this.panLineHeader);
			this.Controls.Add(this.panConnection);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "DlgOpenFromRoundTable";
			this.Text = "Open Document from RoundTable";
			this.panSynchronization.ResumeLayout(false);
			this.customPanel2.ResumeLayout(false);
			this.panel2.ResumeLayout(false);
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


		private void comboBox1_SelectedIndexChanged(object sender, System.EventArgs e)
		{
			ComboBox cb1 = (ComboBox)sender;
			
			// clean out the old items from the list control.
			listBox1.Items.Clear();
			hshDocuments.Clear();
			
			string projectName = (string)cb1.SelectedItem;
			
			Project project = (Project)hshProjects[projectName];
			Document[] projectDocuments = psc.DocumentManager.getDocumentsForProjectFromDocumentType(project.id, DocumentType.MSOFFICE_WORD);
			if (projectDocuments != null && projectDocuments.Length > 0)
			{
				foreach(Document doc in projectDocuments)
				{
					listBox1.Items.Add(doc.name);
					hshDocuments.Add(doc.name, doc);
				}
			}
			else
			{
				listBox1.Items.Add("[NO AVAILABLE DOCUMENTS]");
			}
		}

		private void listBox1_MouseDown(object sender, MouseEventArgs e)
		{
			ListBox lb = (ListBox)sender;
			if (e.Clicks == 2)
			{
				Document doc = (Document)hshDocuments[listBox1.SelectedItem];
				documentActivator.ActivateDocument(doc, this.psc);
				this.Close();
			}
		}

		private void listBox1_KeyDown(object sender, KeyEventArgs e)
		{
			Document doc = (Document)hshDocuments[listBox1.SelectedItem];
			documentActivator.ActivateDocument(doc, this.psc);
			Close();
		}
	}
}

