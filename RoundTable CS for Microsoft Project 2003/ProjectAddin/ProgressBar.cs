using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Threading;

namespace ProjectAddin
{

	public enum ProgressBarType {Connecting, Synchronizing}

	/// <summary>
	/// Summary description for ProgressBar.
	/// </summary>
	class ProgressBar : System.Windows.Forms.Form
	{
		private System.Windows.Forms.Timer timer1;
		private dotNetFlatControls.CustomPanel customPanel1;
		private System.Windows.Forms.ProgressBar progressBar1;
		private dotNetFlatControls.FlatLabel lblMessage;
		private System.ComponentModel.IContainer components;

		public static ProgressBar ShowProgressBar(ProgressBarType type)
		{
			Thread thread;
			return ShowProgressBar(type, out thread);
		}

		public static ProgressBar ShowProgressBar(ProgressBarType type, out Thread thread)
		{
			// start the progress bar in a separate thread
			ProgressBar frmProgress = new ProgressBar();

			// set the display text based on the specified progress bar type
			switch (type)
			{
				case ProgressBarType.Connecting:
//					frmProgress.Text = Utils.CONNECTION_PROGRESS_TITLE;
//					frmProgress.lblMessage.Text = Utils.CONNECTION_PROGRESS_MESSAGE;
// TODO: add proper naming later
					frmProgress.Text = "Connecting to RoundTable Project Server";
					frmProgress.lblMessage.Text = "Connecting to RoundTable Project Server. Please wait ...";
					break;
				case ProgressBarType.Synchronizing:
//					frmProgress.Text = Utils.CONNECTION_PROGRESS_TITLE;
//					frmProgress.lblMessage.Text = Utils.SYNC_PROGRESS_MESSAGE;
					break;
			}

			thread = new Thread(new ThreadStart(frmProgress.ShowMe));
			thread.Start();
			
			return frmProgress;
		}


        public void ShowMe()
		{
			// NOTE: I tried several different methods for getting the form to 
			//       display with the progress bar actually running. This was 
			//       the closest I got.  
			this.StartPosition = FormStartPosition.CenterScreen;

			System.Windows.Forms.Application.Run(new ApplicationContext(this));
		}

		
		public ProgressBar()
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			// set the form title and message text from constants
			this.Text = Utils.CONNECTION_PROGRESS_TITLE;
			this.lblMessage.Text = Utils.CONNECTION_PROGRESS_MESSAGE;

			timer1.Tick +=new EventHandler(timer1_Tick);
			timer1.Start();

			this.Closing+=new CancelEventHandler(ProgressBar_Closing);
		}
		
		private void ProgressBar_Closing(object sender, CancelEventArgs e)
		{
			progressBar1.Value = progressBar1.Maximum;
			progressBar1.Refresh();
			Thread.Sleep(200);
		}

		private void timer1_Tick(object sender, System.EventArgs e)
		{
			if (progressBar1.Value == 100)
			{
				progressBar1.Value = 0;
			}

			progressBar1.Value ++;
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
			this.components = new System.ComponentModel.Container();
			this.timer1 = new System.Windows.Forms.Timer(this.components);
			this.customPanel1 = new dotNetFlatControls.CustomPanel();
			this.progressBar1 = new System.Windows.Forms.ProgressBar();
			this.lblMessage = new dotNetFlatControls.FlatLabel();
			this.customPanel1.SuspendLayout();
			this.SuspendLayout();
			// 
			// timer1
			// 
			this.timer1.Enabled = true;
			this.timer1.Interval = 25;
			// 
			// customPanel1
			// 
			this.customPanel1.BackColor = System.Drawing.Color.GhostWhite;
			this.customPanel1.BackColor2 = System.Drawing.Color.FromArgb(((System.Byte)(160)), ((System.Byte)(187)), ((System.Byte)(252)));
			this.customPanel1.Controls.Add(this.progressBar1);
			this.customPanel1.Controls.Add(this.lblMessage);
			this.customPanel1.Dock = System.Windows.Forms.DockStyle.Fill;
			this.customPanel1.GradientMode = dotNetFlatControls.LinearGradientMode.Horizontal;
			this.customPanel1.Location = new System.Drawing.Point(0, 0);
			this.customPanel1.Name = "customPanel1";
			this.customPanel1.Size = new System.Drawing.Size(426, 64);
			this.customPanel1.TabIndex = 2;
			// 
			// progressBar1
			// 
			this.progressBar1.Location = new System.Drawing.Point(12, 33);
			this.progressBar1.Name = "progressBar1";
			this.progressBar1.Size = new System.Drawing.Size(404, 23);
			this.progressBar1.TabIndex = 3;
			// 
			// lblMessage
			// 
			this.lblMessage.BackColor = System.Drawing.Color.Transparent;
			this.lblMessage.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.lblMessage.Location = new System.Drawing.Point(12, 9);
			this.lblMessage.Name = "lblMessage";
			this.lblMessage.Size = new System.Drawing.Size(451, 23);
			this.lblMessage.TabIndex = 2;
			this.lblMessage.Text = "Synchronizing Outlook with the RoundTable Server. Please wait ...";
			// 
			// ProgressBar
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.BackColor = System.Drawing.Color.FromArgb(((System.Byte)(240)), ((System.Byte)(241)), ((System.Byte)(254)));
			this.ClientSize = new System.Drawing.Size(426, 64);
			this.Controls.Add(this.customPanel1);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
			this.Name = "ProgressBar";
			this.Text = "Please Wait ...";
			this.customPanel1.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion
	}
}
