using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;

namespace SL_Send
{
	/// <summary>
	/// Summary description for SettingsDlg.
	/// </summary>
	public class SettingsDlg : System.Windows.Forms.Form
	{
		private Settings settings; 

		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.TextBox tfAttachment;
		private System.Windows.Forms.Button bnSave;
		private System.Windows.Forms.Button bnCancel;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public SettingsDlg()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
			try
			{
				this.settings = Settings.LoadSettings();

				tfAttachment.Text = settings.AttachmentFile;
			}
			catch(Exception ex)
			{
				MessageBox.Show(ex.Message);
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
			this.label1 = new System.Windows.Forms.Label();
			this.label2 = new System.Windows.Forms.Label();
			this.tfAttachment = new System.Windows.Forms.TextBox();
			this.bnSave = new System.Windows.Forms.Button();
			this.bnCancel = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// label1
			// 
			this.label1.Font = new System.Drawing.Font("Arial", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.label1.Location = new System.Drawing.Point(8, 8);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(160, 23);
			this.label1.TabIndex = 0;
			this.label1.Text = "Manage Settings";
			// 
			// label2
			// 
			this.label2.Location = new System.Drawing.Point(16, 48);
			this.label2.Name = "label2";
			this.label2.TabIndex = 1;
			this.label2.Text = "label2";
			// 
			// tfAttachment
			// 
			this.tfAttachment.Location = new System.Drawing.Point(88, 48);
			this.tfAttachment.Name = "tfAttachment";
			this.tfAttachment.TabIndex = 2;
			this.tfAttachment.Text = "";
			// 
			// bnSave
			// 
			this.bnSave.Location = new System.Drawing.Point(200, 224);
			this.bnSave.Name = "bnSave";
			this.bnSave.TabIndex = 3;
			this.bnSave.Text = "Save";
			this.bnSave.Click += new System.EventHandler(this.bnSave_Click);
			// 
			// bnCancel
			// 
			this.bnCancel.Location = new System.Drawing.Point(104, 224);
			this.bnCancel.Name = "bnCancel";
			this.bnCancel.TabIndex = 4;
			this.bnCancel.Text = "Cancel";
			this.bnCancel.Click += new System.EventHandler(this.bnCancel_Click);
			// 
			// SettingsDlg
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(292, 266);
			this.Controls.Add(this.bnCancel);
			this.Controls.Add(this.bnSave);
			this.Controls.Add(this.tfAttachment);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.label1);
			this.Name = "SettingsDlg";
			this.Text = "Settings";
			this.ResumeLayout(false);

		}
		#endregion

		private void bnSave_Click(object sender, System.EventArgs e)
		{
			try
			{
				settings.AttachmentFile = tfAttachment.Text;

				settings.SaveSettings();
				Close();
			}
			catch(Exception ex)
			{
				MessageBox.Show(ex.Message);
			}
		}

		private void bnCancel_Click(object sender, System.EventArgs e)
		{
			Close();
		}
	}
}
