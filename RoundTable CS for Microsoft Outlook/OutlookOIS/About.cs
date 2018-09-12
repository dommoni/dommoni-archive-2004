using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;

namespace OutlookOIS
{
	/// <summary>
	/// Summary description for About.
	/// </summary>
	class About : System.Windows.Forms.Form
	{
		private dotNetFlatControls.GradientPanel gradHeader;
		private dotNetFlatControls.GradientPanel gradientPanel1;
		private System.Windows.Forms.Label label1;
		private dotNetFlatControls.FlatLabel lblOIS;
		private System.Windows.Forms.Label label2;
		private dotNetFlatControls.FlatLabel lblRoundTable;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public About()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();
		}

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>

		public static void ShowAbout()
		{
			About frmAbout =  new About();

			frmAbout.ShowDialog();
		}
		
		
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
			this.lblOIS = new dotNetFlatControls.FlatLabel();
			this.gradHeader = new dotNetFlatControls.GradientPanel();
			this.lblRoundTable = new dotNetFlatControls.FlatLabel();
			this.gradientPanel1 = new dotNetFlatControls.GradientPanel();
			this.label2 = new System.Windows.Forms.Label();
			this.label1 = new System.Windows.Forms.Label();
			this.gradHeader.SuspendLayout();
			this.gradientPanel1.SuspendLayout();
			this.SuspendLayout();
			// 
			// lblOIS
			// 
			this.lblOIS.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.lblOIS.ForeColor = System.Drawing.Color.FromArgb(((System.Byte)(131)), ((System.Byte)(176)), ((System.Byte)(222)));
			this.lblOIS.Location = new System.Drawing.Point(95, 42);
			this.lblOIS.Name = "lblOIS";
			this.lblOIS.Size = new System.Drawing.Size(228, 30);
			this.lblOIS.TabIndex = 1;
			this.lblOIS.Text = "Office Integration System";
			this.lblOIS.TextAlign = System.Drawing.ContentAlignment.TopCenter;
			// 
			// gradHeader
			// 
			this.gradHeader.BackColor = System.Drawing.Color.GhostWhite;
			this.gradHeader.ColorFrom = System.Drawing.Color.GhostWhite;
			this.gradHeader.ColorTo = System.Drawing.Color.CornflowerBlue;
			this.gradHeader.Controls.Add(this.lblRoundTable);
			this.gradHeader.Controls.Add(this.lblOIS);
			this.gradHeader.Dock = System.Windows.Forms.DockStyle.Top;
			this.gradHeader.FillStyle = 0;
			this.gradHeader.Location = new System.Drawing.Point(0, 0);
			this.gradHeader.Name = "gradHeader";
			this.gradHeader.RelativeStartPerc = 55;
			this.gradHeader.Size = new System.Drawing.Size(422, 80);
			this.gradHeader.TabIndex = 8;
			// 
			// lblRoundTable
			// 
			this.lblRoundTable.BackColor = System.Drawing.Color.Transparent;
			this.lblRoundTable.Font = new System.Drawing.Font("Lucida Sans Unicode", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.lblRoundTable.Location = new System.Drawing.Point(131, 10);
			this.lblRoundTable.Name = "lblRoundTable";
			this.lblRoundTable.Size = new System.Drawing.Size(156, 34);
			this.lblRoundTable.TabIndex = 3;
			this.lblRoundTable.Text = "RoundTable";
			this.lblRoundTable.TextAlign = System.Drawing.ContentAlignment.TopCenter;
			// 
			// gradientPanel1
			// 
			this.gradientPanel1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.gradientPanel1.BackColor = System.Drawing.Color.White;
			this.gradientPanel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.gradientPanel1.ColorFrom = System.Drawing.Color.White;
			this.gradientPanel1.ColorTo = System.Drawing.Color.White;
			this.gradientPanel1.Controls.Add(this.label2);
			this.gradientPanel1.Controls.Add(this.label1);
			this.gradientPanel1.FillStyle = 1;
			this.gradientPanel1.Location = new System.Drawing.Point(-2, 76);
			this.gradientPanel1.Name = "gradientPanel1";
			this.gradientPanel1.Size = new System.Drawing.Size(474, 74);
			this.gradientPanel1.TabIndex = 9;
			// 
			// label2
			// 
			this.label2.BackColor = System.Drawing.Color.White;
			this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.label2.Location = new System.Drawing.Point(150, 12);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(118, 24);
			this.label2.TabIndex = 7;
			this.label2.Text = "Version 1.0";
			this.label2.TextAlign = System.Drawing.ContentAlignment.TopCenter;
			// 
			// label1
			// 
			this.label1.BackColor = System.Drawing.Color.White;
			this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.label1.Location = new System.Drawing.Point(100, 36);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(222, 24);
			this.label1.TabIndex = 6;
			this.label1.Text = "© 2005  Dommoni Corporation";
			this.label1.TextAlign = System.Drawing.ContentAlignment.TopCenter;
			// 
			// About
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(422, 146);
			this.Controls.Add(this.gradientPanel1);
			this.Controls.Add(this.gradHeader);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
			this.MaximizeBox = false;
			this.MinimizeBox = false;
			this.Name = "About";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "About RoundTable OIS Outlook";
			this.gradHeader.ResumeLayout(false);
			this.gradientPanel1.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion
	}
}
