using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;
using System.Data;
using System.Web.Mail;

using SourceGrid2.Cells.Real;

namespace SL_Send
{
	/// <summary>
	/// Summary description for Form1.
	/// </summary>
	public class SLSend : System.Windows.Forms.Form
	{
		private const int COL_EMAILADDRESS = 0;
		private const int COL_NAME = 1;
		private const int COL_COMPANY = 2;
		private const int COL_INTRO = 3;
		private const int COL_CONTACT = 4;

		private AppMode appMode;

		string[] intros = {
			"Thank you for taking my call.",
			"I'm sorry you missed my call." 
		};

		private System.Windows.Forms.Button bnCancel;
		private System.Windows.Forms.Button bnSend;
		private System.Windows.Forms.ToolBar toolBar1;
		private System.Windows.Forms.Button bnAddRecipient;
		private System.Windows.Forms.PictureBox pictureBox1;
		private System.Windows.Forms.Panel panel1;
		private System.Windows.Forms.Button bnRemoveRecipient;
		private SourceGrid2.Grid gridRecipients;
		private System.Windows.Forms.Button bnSettings;
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public SLSend(AppMode appMode)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//
			this.appMode = appMode;
			InitRecipientsGrid();
		}

		private void InitRecipientsGrid()
		{
			if (gridRecipients != null)
			{
				gridRecipients.AutoStretchColumnsToFitWidth = true;

				SourceGrid2.VisualModels.Common vmHeader = 
					new SourceGrid2.VisualModels.FlatHeader();
				vmHeader.BackColor = Color.FromArgb(228,229,237);
				SourceGrid2.BehaviorModels.Header bmHeader = new SourceGrid2.BehaviorModels.Header();

				// set up the header row
				gridRecipients.Rows.Insert(0);

				gridRecipients.Columns.Insert(0);
				gridRecipients[0, COL_EMAILADDRESS] = new SourceGrid2.Cells.Real.ColumnHeader("Email", vmHeader, bmHeader);

				gridRecipients.Columns.Insert(1); 
				gridRecipients[0, COL_NAME] = new SourceGrid2.Cells.Real.ColumnHeader("Name", vmHeader, bmHeader);

				gridRecipients.Columns.Insert(2); 
				gridRecipients[0, COL_COMPANY] = new SourceGrid2.Cells.Real.ColumnHeader("Company", vmHeader, bmHeader);
			
				gridRecipients.Columns.Insert(3); 
				gridRecipients[0, COL_INTRO] = new SourceGrid2.Cells.Real.ColumnHeader("Intro", vmHeader, bmHeader);

				gridRecipients.Columns.Insert(4); 
				gridRecipients[0, COL_CONTACT] = new SourceGrid2.Cells.Real.ColumnHeader("Contact", vmHeader, bmHeader);

				// Size Column Widths
				int columnWidth = gridRecipients.Width / gridRecipients.ColumnsCount;
				for (int i = 0; i < gridRecipients.ColumnsCount; i++)
					gridRecipients.Columns[i].Width = columnWidth;

				//AddRow(); // first row
			}
		}

		// Method to allow SLSend to be started from other applications.
		//setRecipients()

		public int AddRow()
		{
			int newRow = gridRecipients.RowsCount;
			gridRecipients.Rows.Insert(newRow);

			gridRecipients[newRow, COL_EMAILADDRESS] =	new Cell("", typeof(string));
			gridRecipients[newRow, COL_NAME] =			new Cell("", typeof(string));
			gridRecipients[newRow, COL_COMPANY] =		new Cell("", typeof(string));
			gridRecipients[newRow, COL_INTRO] =			new Cell("", typeof(string));
			
			gridRecipients[newRow, COL_INTRO].DataModel = 
				new SourceGrid2.DataModels.EditorComboBox(typeof(string), intros, false);

			gridRecipients[newRow, COL_CONTACT] = new Cell("", typeof(string));
			
			return newRow;
		}

		public void AddRecipient(Recipient recipient)
		{
			if (recipient != null)
			{
				int rowid = AddRow();

				gridRecipients[rowid, COL_EMAILADDRESS].Value = recipient.EmailAddress;
				gridRecipients[rowid, COL_NAME].Value = recipient.Name;
				gridRecipients[rowid, COL_COMPANY].Value = recipient.Company;
				gridRecipients[rowid, COL_INTRO].Value = recipient.Intro;
				gridRecipients[rowid, COL_CONTACT].Value = recipient.ContactStatement;
			}
		}

		public IList MakeModel()
		{
			IList recipientsModel = new ArrayList();

			for (int i = 1; i < gridRecipients.RowsCount; i++)
			{
				Recipient rec = new Recipient();
				rec.EmailAddress = (string)gridRecipients[i, COL_EMAILADDRESS].Value;
				rec.Name = (string)gridRecipients[i, COL_NAME].Value;
				rec.Company = (string)gridRecipients[i, COL_COMPANY].Value;
				rec.Intro = (string)gridRecipients[i, COL_INTRO].Value;
				rec.ContactStatement = (string)gridRecipients[i, COL_CONTACT].Value;

				if (rec.IsValid())
				{
					recipientsModel.Add(rec);
				}
				else
				{
				}
			}

			return recipientsModel;
		}

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		protected override void Dispose( bool disposing )
		{
			if( disposing )
			{
				if (components != null) 
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
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(SLSend));
			this.gridRecipients = new SourceGrid2.Grid();
			this.bnSend = new System.Windows.Forms.Button();
			this.bnCancel = new System.Windows.Forms.Button();
			this.toolBar1 = new System.Windows.Forms.ToolBar();
			this.bnAddRecipient = new System.Windows.Forms.Button();
			this.pictureBox1 = new System.Windows.Forms.PictureBox();
			this.panel1 = new System.Windows.Forms.Panel();
			this.bnRemoveRecipient = new System.Windows.Forms.Button();
			this.bnSettings = new System.Windows.Forms.Button();
			this.panel1.SuspendLayout();
			this.SuspendLayout();
			// 
			// gridRecipients
			// 
			this.gridRecipients.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
				| System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.gridRecipients.AutoSizeMinHeight = 10;
			this.gridRecipients.AutoSizeMinWidth = 10;
			this.gridRecipients.AutoStretchColumnsToFitWidth = false;
			this.gridRecipients.AutoStretchRowsToFitHeight = false;
			this.gridRecipients.BackColor = System.Drawing.SystemColors.Control;
			this.gridRecipients.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.gridRecipients.ContextMenuStyle = SourceGrid2.ContextMenuStyle.None;
			this.gridRecipients.CustomSort = false;
			this.gridRecipients.GridToolTipActive = true;
			this.gridRecipients.Location = new System.Drawing.Point(16, 64);
			this.gridRecipients.Name = "gridRecipients";
			this.gridRecipients.Size = new System.Drawing.Size(552, 200);
			this.gridRecipients.SpecialKeys = SourceGrid2.GridSpecialKeys.Default;
			this.gridRecipients.TabIndex = 0;
			// 
			// bnSend
			// 
			this.bnSend.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.bnSend.BackColor = System.Drawing.SystemColors.Control;
			this.bnSend.Location = new System.Drawing.Point(504, 16);
			this.bnSend.Name = "bnSend";
			this.bnSend.TabIndex = 1;
			this.bnSend.Text = "Send";
			this.bnSend.Click += new System.EventHandler(this.bnSend_Click);
			// 
			// bnCancel
			// 
			this.bnCancel.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
			this.bnCancel.BackColor = System.Drawing.SystemColors.Control;
			this.bnCancel.Location = new System.Drawing.Point(416, 16);
			this.bnCancel.Name = "bnCancel";
			this.bnCancel.TabIndex = 2;
			this.bnCancel.Text = "Cancel";
			this.bnCancel.Click += new System.EventHandler(this.bnCancel_Click);
			// 
			// toolBar1
			// 
			this.toolBar1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.toolBar1.DropDownArrows = true;
			this.toolBar1.Location = new System.Drawing.Point(0, 0);
			this.toolBar1.Name = "toolBar1";
			this.toolBar1.ShowToolTips = true;
			this.toolBar1.Size = new System.Drawing.Size(584, 43);
			this.toolBar1.TabIndex = 3;
			// 
			// bnAddRecipient
			// 
			this.bnAddRecipient.Location = new System.Drawing.Point(8, 8);
			this.bnAddRecipient.Name = "bnAddRecipient";
			this.bnAddRecipient.Size = new System.Drawing.Size(64, 32);
			this.bnAddRecipient.TabIndex = 4;
			this.bnAddRecipient.Text = "Add";
			this.bnAddRecipient.Click += new System.EventHandler(this.bnAddRecipient_Click);
			// 
			// pictureBox1
			// 
			this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
			this.pictureBox1.Location = new System.Drawing.Point(16, 8);
			this.pictureBox1.Name = "pictureBox1";
			this.pictureBox1.Size = new System.Drawing.Size(208, 48);
			this.pictureBox1.TabIndex = 5;
			this.pictureBox1.TabStop = false;
			// 
			// panel1
			// 
			this.panel1.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
				| System.Windows.Forms.AnchorStyles.Right)));
			this.panel1.BackColor = System.Drawing.SystemColors.Window;
			this.panel1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
			this.panel1.Controls.Add(this.pictureBox1);
			this.panel1.Controls.Add(this.bnCancel);
			this.panel1.Controls.Add(this.bnSend);
			this.panel1.Location = new System.Drawing.Point(-8, 272);
			this.panel1.Name = "panel1";
			this.panel1.Size = new System.Drawing.Size(600, 56);
			this.panel1.TabIndex = 6;
			// 
			// bnRemoveRecipient
			// 
			this.bnRemoveRecipient.Location = new System.Drawing.Point(80, 8);
			this.bnRemoveRecipient.Name = "bnRemoveRecipient";
			this.bnRemoveRecipient.Size = new System.Drawing.Size(64, 32);
			this.bnRemoveRecipient.TabIndex = 7;
			this.bnRemoveRecipient.Text = "Remove";
			// 
			// bnSettings
			// 
			this.bnSettings.Location = new System.Drawing.Point(496, 8);
			this.bnSettings.Name = "bnSettings";
			this.bnSettings.Size = new System.Drawing.Size(75, 32);
			this.bnSettings.TabIndex = 8;
			this.bnSettings.Text = "Settings";
			this.bnSettings.Click += new System.EventHandler(this.bnSettings_Click);
			// 
			// SLSend
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.BackColor = System.Drawing.SystemColors.Control;
			this.ClientSize = new System.Drawing.Size(584, 326);
			this.Controls.Add(this.bnSettings);
			this.Controls.Add(this.bnRemoveRecipient);
			this.Controls.Add(this.panel1);
			this.Controls.Add(this.bnAddRecipient);
			this.Controls.Add(this.toolBar1);
			this.Controls.Add(this.gridRecipients);
			this.Name = "SLSend";
			this.Text = "Dommoni SL Send";
			this.panel1.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void bnCancel_Click(object sender, System.EventArgs e)
		{
			if (appMode == AppMode.WindowsApplication)
			{	
				Application.Exit();
				return;
			}
			if (appMode == AppMode.ExcelHostedAddin)
			{
				this.Visible = false;
				return;
			}
		}

		private void bnSend_Click(object sender, System.EventArgs e)
		{
			IList recipients = MakeModel();
			int percent = 100 / recipients.Count;

			MxSendStatus stats = new MxSendStatus();
			stats.Visible = true;

			SmtpMail.SmtpServer = "mail.dommoni.com";
			string attachmentFile = Settings.LoadSettings().AttachmentFile;

			string msgBody = 
				"Dear $NAME$:  $COMPANY$" +                    
				"\n\n" +
				"$INTRO$\n\n" +

				"RoundTable is browser based software that allows your team to share documents, participate in forums, share tasks and more.\n\n" +
 
				"We've also enabled existing software to communicate with RoundTable through RoundTable Connected Services (Included w/RoundTable)." + 
				"Connected Services are components that run in your existing applications such as Microsoft Outlook or Word and allow those applications to work with RoundTable directly. Connected Services encourage information sharing and increase the value and functionality of your existing applications.\n\n" +

				"I've attached a product data sheet that further describes RoundTable. Also, if you have a moment, I would appreciate it if you could look at our website which can be found at http://www.dommoni.com/. If you click on the \"Solutions-> Learn more about RoundTable Links\", that will give you a good overview of what RoundTable is and how it can help you.\n\n" +

				"We offer a free 30 day trial with RoundTable and are anxious for you and your company to give it a try!  $CONTACTSTMT$  In the meantime, please e-mail me at this address or contact me by phone at 619-696-8630 should you have any questions.\n\n" +

				"Thank you for your interest,\n\n\n" +


				"Gail Olmsted\n" +
				"Dommoni Corporation\n" +
				"http://www.dommoni.com\n";

			foreach (Recipient r in recipients)
			{
				try
				{
					if (r.IsValid())
					{
						MailMessage msg = new MailMessage();
						msg.To = r.EmailAddress;
						msg.From = "Gail Olmsted <glo@dommoni.com>";
						msg.Subject = "Dommoni RoundTable Collaboration Environment";
						msg.Bcc = "brian@dommoni.com;gloinsdgo@aol.com";

						// Make the Message...
						string rcptMessage = (string)msgBody.Clone();
						rcptMessage = rcptMessage.Replace("$NAME$", r.Name);
						rcptMessage = rcptMessage.Replace("$COMPANY$", r.Company);
						rcptMessage = rcptMessage.Replace("$INTRO$", r.Intro);
						// I will be recontacting you within the next two working days as discussed.
						rcptMessage = rcptMessage.Replace("$CONTACTSTMT$", r.ContactStatement);

						msg.Body = rcptMessage;

						// Handle the Attachment...
						if (attachmentFile == null || attachmentFile.Length == 0)
						{
							MessageBox.Show("Invalid Attachment File. Please Review your attachment Settings.");
							return;
						}
						MailAttachment attach = new MailAttachment(attachmentFile);
						msg.Attachments.Add(attach);

						stats.SetStatus("Sending To: " + r.EmailAddress);
						SmtpMail.Send(msg);
						stats.SetStatus("Successfully Sent To: " + r.EmailAddress);
						stats.IncrementProgress(percent);
					}
				}
				catch(Exception ex)
				{
					MessageBox.Show("Error: " + ex.Message);
					stats.SetStatus("Sending failed for: " + r.EmailAddress);
				}
			}
		}

		private void bnAddRecipient_Click(object sender, System.EventArgs e)
		{
			AddRow();
		}

		private void bnSettings_Click(object sender, System.EventArgs e)
		{
			SettingsDlg sd = new SettingsDlg();
			sd.Show();
		}
	}
}
