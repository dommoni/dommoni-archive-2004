using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;

namespace SL_Send
{
	/// <summary>
	/// Summary description for MxSendStatus.
	/// </summary>
	public class MxSendStatus : System.Windows.Forms.Form
	{
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.ProgressBar progressBar;
		private System.Windows.Forms.Label lbCurrentStatus;
		private System.Windows.Forms.Panel panel1;
		private System.Windows.Forms.Label lbStatusMsg;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public MxSendStatus()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
		}

		public void IncrementProgress(int val)
		{
			this.progressBar.Increment(val);
		}

		public void SetStatus(string status)
		{
			lbStatusMsg.Text = status;
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
			this.progressBar = new System.Windows.Forms.ProgressBar();
			this.label1 = new System.Windows.Forms.Label();
			this.lbCurrentStatus = new System.Windows.Forms.Label();
			this.panel1 = new System.Windows.Forms.Panel();
			this.lbStatusMsg = new System.Windows.Forms.Label();
			this.panel1.SuspendLayout();
			this.SuspendLayout();
			// 
			// progressBar
			// 
			this.progressBar.Location = new System.Drawing.Point(24, 120);
			this.progressBar.Name = "progressBar";
			this.progressBar.Size = new System.Drawing.Size(296, 23);
			this.progressBar.TabIndex = 0;
			// 
			// label1
			// 
			this.label1.Font = new System.Drawing.Font("Arial", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.label1.Location = new System.Drawing.Point(24, 96);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(280, 23);
			this.label1.TabIndex = 1;
			this.label1.Text = "Overall Progress:";
			this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// lbCurrentStatus
			// 
			this.lbCurrentStatus.Font = new System.Drawing.Font("Arial", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.lbCurrentStatus.Location = new System.Drawing.Point(24, 16);
			this.lbCurrentStatus.Name = "lbCurrentStatus";
			this.lbCurrentStatus.Size = new System.Drawing.Size(296, 23);
			this.lbCurrentStatus.TabIndex = 2;
			this.lbCurrentStatus.Text = "Current Status:";
			this.lbCurrentStatus.TextAlign = System.Drawing.ContentAlignment.MiddleLeft;
			// 
			// panel1
			// 
			this.panel1.BackColor = System.Drawing.Color.Black;
			this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
			this.panel1.Controls.Add(this.lbStatusMsg);
			this.panel1.Location = new System.Drawing.Point(24, 40);
			this.panel1.Name = "panel1";
			this.panel1.Size = new System.Drawing.Size(296, 40);
			this.panel1.TabIndex = 3;
			// 
			// lbStatusMsg
			// 
			this.lbStatusMsg.Font = new System.Drawing.Font("Lucida Console", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.lbStatusMsg.ForeColor = System.Drawing.Color.White;
			this.lbStatusMsg.Location = new System.Drawing.Point(0, 0);
			this.lbStatusMsg.Name = "lbStatusMsg";
			this.lbStatusMsg.Size = new System.Drawing.Size(296, 40);
			this.lbStatusMsg.TabIndex = 0;
			// 
			// MxSendStatus
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(346, 176);
			this.Controls.Add(this.panel1);
			this.Controls.Add(this.lbCurrentStatus);
			this.Controls.Add(this.label1);
			this.Controls.Add(this.progressBar);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
			this.Name = "MxSendStatus";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Mx Send Status";
			this.panel1.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

	}
}
