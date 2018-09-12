/*
 * Created by SharpDevelop.
 * User: Brian Abbott
 * Date: 12/21/2004
 * Time: 1:57 PM
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
using System;
using System.Drawing;
using System.IO;
using System.Windows.Forms;

namespace RoundTable_LFG
{
	/// <summary>
	/// Description of MainForm.
	/// </summary>
	public class MainForm : System.Windows.Forms.Form
	{
		private System.ComponentModel.IContainer components;
		private System.Windows.Forms.NumericUpDown nudDaysInTrial;
		private System.Windows.Forms.ToolTip ttNumberOfUsers;
		private System.Windows.Forms.ToolTip toolTip1;
		private System.Windows.Forms.Label lbMode;
		private System.Windows.Forms.RadioButton rbTrial;
		private System.Windows.Forms.ToolTip ttDaysInTrial;
		private System.Windows.Forms.ToolTip ttProductMode;
		private System.Windows.Forms.Button button1;
		private System.Windows.Forms.ToolTip ttContact;
		private System.Windows.Forms.RadioButton rbProduct;
		private System.Windows.Forms.TextBox tfContactName;
		private System.Windows.Forms.GroupBox groupBox1;
		private System.Windows.Forms.Label lbContactName;
		private System.Windows.Forms.ToolTip ttMode;
		private System.Windows.Forms.ToolTip ttTrialMode;
		private System.Windows.Forms.NumericUpDown nudNumberOfUsers;
		private System.Windows.Forms.ToolTip ttCompany;
		private System.Windows.Forms.PictureBox pictureBox1;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.Label lbNumberOfUsers;
		private System.Windows.Forms.Label lbCompanyName;
		private System.Windows.Forms.SaveFileDialog saveLicenseFileDlg;
		private System.Windows.Forms.StatusBar statusBar;
		private System.Windows.Forms.Label lbDaysInTrial;
		private System.Windows.Forms.TextBox tfCompanyName;
		

		
		public MainForm()
		{
			AccessDialog ad = new AccessDialog();
			ad.ShowDialog();
			
			if(ad.Interaction == CloseState.OKAY)
			{
				//
				// The InitializeComponent() call is required for Windows Forms designer support.
				//
				InitializeComponent();
				
				statusBar.Text = "Ready";
				//progressBar1.Visible = false;
	
				// add tool tips...
				
				lbCompanyName.MouseEnter += new System.EventHandler(showCompanyToolTip);
			}
			else
			{
				Close();
				Application.Exit();
			}
		}
		
		[STAThread]
		public static void Main(string[] args)
		{
			Application.Run(new MainForm());
		}
		
		#region Windows Forms Designer generated code
		/// <summary>
		/// This method is required for Windows Forms designer support.
		/// Do not change the method contents inside the source code editor. The Forms designer might
		/// not be able to load this method if it was changed manually.
		/// </summary>
		private void InitializeComponent() {
			this.components = new System.ComponentModel.Container();
			System.Resources.ResourceManager resources = new System.Resources.ResourceManager(typeof(MainForm));
			this.tfCompanyName = new System.Windows.Forms.TextBox();
			this.lbDaysInTrial = new System.Windows.Forms.Label();
			this.statusBar = new System.Windows.Forms.StatusBar();
			this.saveLicenseFileDlg = new System.Windows.Forms.SaveFileDialog();
			this.lbCompanyName = new System.Windows.Forms.Label();
			this.lbNumberOfUsers = new System.Windows.Forms.Label();
			this.label1 = new System.Windows.Forms.Label();
			this.pictureBox1 = new System.Windows.Forms.PictureBox();
			this.ttCompany = new System.Windows.Forms.ToolTip(this.components);
			this.nudNumberOfUsers = new System.Windows.Forms.NumericUpDown();
			this.ttTrialMode = new System.Windows.Forms.ToolTip(this.components);
			this.ttMode = new System.Windows.Forms.ToolTip(this.components);
			this.lbContactName = new System.Windows.Forms.Label();
			this.groupBox1 = new System.Windows.Forms.GroupBox();
			this.tfContactName = new System.Windows.Forms.TextBox();
			this.rbProduct = new System.Windows.Forms.RadioButton();
			this.ttContact = new System.Windows.Forms.ToolTip(this.components);
			this.button1 = new System.Windows.Forms.Button();
			this.ttProductMode = new System.Windows.Forms.ToolTip(this.components);
			this.ttDaysInTrial = new System.Windows.Forms.ToolTip(this.components);
			this.rbTrial = new System.Windows.Forms.RadioButton();
			this.lbMode = new System.Windows.Forms.Label();
			this.toolTip1 = new System.Windows.Forms.ToolTip(this.components);
			this.ttNumberOfUsers = new System.Windows.Forms.ToolTip(this.components);
			this.nudDaysInTrial = new System.Windows.Forms.NumericUpDown();
			((System.ComponentModel.ISupportInitialize)(this.nudNumberOfUsers)).BeginInit();
			this.groupBox1.SuspendLayout();
			((System.ComponentModel.ISupportInitialize)(this.nudDaysInTrial)).BeginInit();
			this.SuspendLayout();
			// 
			// tfCompanyName
			// 
			this.tfCompanyName.Location = new System.Drawing.Point(136, 24);
			this.tfCompanyName.Name = "tfCompanyName";
			this.tfCompanyName.TabIndex = 5;
			this.tfCompanyName.Text = "";
			this.tfCompanyName.TextChanged += new System.EventHandler(this.TextBox1TextChanged);
			// 
			// lbDaysInTrial
			// 
			this.lbDaysInTrial.Location = new System.Drawing.Point(32, 200);
			this.lbDaysInTrial.Name = "lbDaysInTrial";
			this.lbDaysInTrial.TabIndex = 21;
			this.lbDaysInTrial.Text = "Days In Trial";
			this.ttDaysInTrial.SetToolTip(this.lbDaysInTrial, "The number of days this trial period is valid for.");
			this.lbDaysInTrial.Visible = false;
			// 
			// statusBar
			// 
			this.statusBar.Location = new System.Drawing.Point(0, 360);
			this.statusBar.Name = "statusBar";
			this.statusBar.Size = new System.Drawing.Size(416, 22);
			this.statusBar.TabIndex = 23;
			// 
			// saveLicenseFileDlg
			// 
			this.saveLicenseFileDlg.DefaultExt = "lic";
			this.saveLicenseFileDlg.Title = "Save License File";
			// 
			// lbCompanyName
			// 
			this.lbCompanyName.Location = new System.Drawing.Point(32, 24);
			this.lbCompanyName.Name = "lbCompanyName";
			this.lbCompanyName.TabIndex = 18;
			this.lbCompanyName.Text = "Company Name";
			this.ttCompany.SetToolTip(this.lbCompanyName, "The company name that this License File belongs to.");
			// 
			// lbNumberOfUsers
			// 
			this.lbNumberOfUsers.Location = new System.Drawing.Point(32, 88);
			this.lbNumberOfUsers.Name = "lbNumberOfUsers";
			this.lbNumberOfUsers.TabIndex = 20;
			this.lbNumberOfUsers.Text = "Number of Users";
			this.ttNumberOfUsers.SetToolTip(this.lbNumberOfUsers, "Number of user accounts the buyer is allowed to create in the system.");
			// 
			// label1
			// 
			this.label1.Font = new System.Drawing.Font("Tahoma", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.label1.Location = new System.Drawing.Point(16, 16);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(160, 23);
			this.label1.TabIndex = 17;
			this.label1.Text = "RoundTable LFG";
			// 
			// pictureBox1
			// 
			this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
			this.pictureBox1.Location = new System.Drawing.Point(16, 312);
			this.pictureBox1.Name = "pictureBox1";
			this.pictureBox1.Size = new System.Drawing.Size(200, 48);
			this.pictureBox1.TabIndex = 26;
			this.pictureBox1.TabStop = false;
			// 
			// nudNumberOfUsers
			// 
			this.nudNumberOfUsers.Location = new System.Drawing.Point(136, 88);
			this.nudNumberOfUsers.Name = "nudNumberOfUsers";
			this.nudNumberOfUsers.TabIndex = 25;
			// 
			// lbContactName
			// 
			this.lbContactName.Location = new System.Drawing.Point(32, 56);
			this.lbContactName.Name = "lbContactName";
			this.lbContactName.TabIndex = 19;
			this.lbContactName.Text = "Contact Name";
			this.ttContact.SetToolTip(this.lbContactName, "Name of the contact at Company that carried the deal.");
			// 
			// groupBox1
			// 
			this.groupBox1.BackColor = System.Drawing.Color.WhiteSmoke;
			this.groupBox1.Controls.Add(this.lbContactName);
			this.groupBox1.Controls.Add(this.nudDaysInTrial);
			this.groupBox1.Controls.Add(this.lbDaysInTrial);
			this.groupBox1.Controls.Add(this.rbProduct);
			this.groupBox1.Controls.Add(this.rbTrial);
			this.groupBox1.Controls.Add(this.lbMode);
			this.groupBox1.Controls.Add(this.nudNumberOfUsers);
			this.groupBox1.Controls.Add(this.lbNumberOfUsers);
			this.groupBox1.Controls.Add(this.tfContactName);
			this.groupBox1.Controls.Add(this.tfCompanyName);
			this.groupBox1.Controls.Add(this.lbCompanyName);
			this.groupBox1.Controls.Add(this.button1);
			this.groupBox1.Location = new System.Drawing.Point(16, 56);
			this.groupBox1.Name = "groupBox1";
			this.groupBox1.Size = new System.Drawing.Size(384, 232);
			this.groupBox1.TabIndex = 27;
			this.groupBox1.TabStop = false;
			this.groupBox1.Text = "License Information";
			this.groupBox1.Enter += new System.EventHandler(this.GroupBox1Enter);
			// 
			// tfContactName
			// 
			this.tfContactName.Location = new System.Drawing.Point(136, 56);
			this.tfContactName.Name = "tfContactName";
			this.tfContactName.TabIndex = 6;
			this.tfContactName.Text = "";
			// 
			// rbProduct
			// 
			this.rbProduct.Location = new System.Drawing.Point(48, 168);
			this.rbProduct.Name = "rbProduct";
			this.rbProduct.TabIndex = 16;
			this.rbProduct.Text = "Product";
			this.ttProductMode.SetToolTip(this.rbProduct, "A mode which does not expire.");
			// 
			// button1
			// 
			this.button1.BackColor = System.Drawing.SystemColors.Control;
			this.button1.Location = new System.Drawing.Point(304, 200);
			this.button1.Name = "button1";
			this.button1.TabIndex = 9;
			this.button1.Text = "Generate";
			this.button1.Click += new System.EventHandler(this.Button1Click);
			// 
			// rbTrial
			// 
			this.rbTrial.Location = new System.Drawing.Point(48, 144);
			this.rbTrial.Name = "rbTrial";
			this.rbTrial.TabIndex = 15;
			this.rbTrial.Text = "Trial";
			this.ttTrialMode.SetToolTip(this.rbTrial, "A mode which will expire in N Days.");
			this.rbTrial.CheckedChanged += new System.EventHandler(this.RadioButton1CheckedChanged);
			// 
			// lbMode
			// 
			this.lbMode.Location = new System.Drawing.Point(32, 120);
			this.lbMode.Name = "lbMode";
			this.lbMode.TabIndex = 22;
			this.lbMode.Text = "Mode";
			this.ttMode.SetToolTip(this.lbMode, "The Mode which this system operates in (trial or product)");
			// 
			// nudDaysInTrial
			// 
			this.nudDaysInTrial.Location = new System.Drawing.Point(144, 200);
			this.nudDaysInTrial.Name = "nudDaysInTrial";
			this.nudDaysInTrial.TabIndex = 24;
			this.nudDaysInTrial.Visible = false;
			// 
			// MainForm
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.BackColor = System.Drawing.Color.White;
			this.ClientSize = new System.Drawing.Size(416, 382);
			this.Controls.Add(this.groupBox1);
			this.Controls.Add(this.pictureBox1);
			this.Controls.Add(this.statusBar);
			this.Controls.Add(this.label1);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
			this.Name = "MainForm";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "RoundTable LFG";
			((System.ComponentModel.ISupportInitialize)(this.nudNumberOfUsers)).EndInit();
			this.groupBox1.ResumeLayout(false);
			((System.ComponentModel.ISupportInitialize)(this.nudDaysInTrial)).EndInit();
			this.ResumeLayout(false);
		}
		#endregion
		void Label1Click(object sender, System.EventArgs e)
		{
			
		}
		
		void Label5Click(object sender, System.EventArgs e)
		{
			
		}
		
		void Button1Click(object sender, System.EventArgs e)
		{
			if((tfCompanyName.Text != null && tfCompanyName.Text.Length > 0) &&
			   (tfContactName.Text != null && tfContactName.Text.Length > 0) && 
			   (nudDaysInTrial.Text != null && nudDaysInTrial.Text.Length > 0) && 
			   (nudNumberOfUsers.Text != null && nudNumberOfUsers.Text.Length > 0))
			{
				GenerateLicense();
			}
			else
			{
				MessageBox.Show("You must enter a value in each field", "Error");
			}
		}
		
		void TextBox1TextChanged(object sender, System.EventArgs e)
		{
			
		}
		
		public void GenerateLicense()
		{
			int posID = 200;
			int posCompany = 400;
			int posContact = 800;
			int posUsers = 1200;
			int posMode = 1600;
			int posStartDay = 2000;
			int posDays = 3200;
			
			/*
			 * posNumAccounts
			 * */
			 
			
			byte[] array = new byte[512 * 1024]; // 512K File.
			Random rand = new Random();
			
			GeneratorProgressDialog gpd = new GeneratorProgressDialog();
			gpd.Show();
			
			//progressBar1.Visible = true;
			
			//progressBar1.PerformStep();
			gpd.Progress.PerformStep();
			
			for(int i = 0; i < array.Length; i++)
			{
				if(i == 0)
				{
					statusBar.Text = "Creating Company Entry";
					//progressBar1.PerformStep();
					gpd.Progress.PerformStep();
					
					CharEnumerator ceCompany = "DOMMONI - ROUNDTABLE COLLABORATION ENVIRONMENT".GetEnumerator();
					while(ceCompany.MoveNext())
					{
						array[i++] = (byte)ceCompany.Current;
					}
				}
				
				if(i == posCompany || i == posContact || i == posUsers || i == posMode || i == posDays)
				{	
					if(i == posCompany)
					{
						statusBar.Text = "Creating Company Entry";
						//progressBar1.PerformStep();
						gpd.Progress.PerformStep();
						
						// write the length
						array[i - 1] = (byte)tfCompanyName.Text.Length;
						
						CharEnumerator ceCompany = tfCompanyName.Text.GetEnumerator();
						while(ceCompany.MoveNext())
						{
							array[i++] = (byte)ceCompany.Current;
						}
					}
					if(i == posContact)
					{
						statusBar.Text = "Creating Contact Entry";
						//progressBar1.PerformStep();
						gpd.Progress.PerformStep();
						
						// write the length
						array[i - 1] = (byte)tfContactName.Text.Length;
						
						CharEnumerator ceContact = tfContactName.Text.GetEnumerator();
						while(ceContact.MoveNext())
						{
							array[i++] = (byte)ceContact.Current;
						}
					}
					if(i == posUsers)
					{
						statusBar.Text = "Creating number of Users";
						gpd.Progress.PerformStep();
						
						// what if greater than 255?
						MessageBox.Show("Writing: " +  nudNumberOfUsers.Value);
						array[i] = (byte)nudNumberOfUsers.Value;
					}
					if(i == posMode)
					{
						//progressBar1.PerformStep();
						gpd.Progress.PerformStep();
						statusBar.Text = "Creating Mode Entry";
						if(rbProduct.Checked)
							array[i] = (byte)100;
						else
							array[i] = (byte)125;
					}
					if(i == posDays && rbTrial.Checked) // We only add this if trial mode is set.
					{
						statusBar.Text = "Creating Days Entry";
						
						array[i] = (byte)nudDaysInTrial.Value;
					}
				}
				else
				{
					array[i] = (byte)rand.Next();
				}
			}
			
			// TODO: Generate/Append a CRC to the file to prevent tampering.
			
			//progressBar1.Value = 100;
			gpd.Progress.Value = 100;
			
			
			//progressBar1.Visible = false;
			statusBar.Text = "Successfully generated license file.";
			
			saveLicenseFileDlg.FileName = tfCompanyName.Text+".lic";
			if(saveLicenseFileDlg.ShowDialog() == DialogResult.OK)
			{
				FileStream fs = new FileStream(saveLicenseFileDlg.FileName, FileMode.Create);
				fs.Write(array, 0, array.Length);
				fs.Flush();
				fs.Close();
			}
			gpd.Visible = false;
		}
		
		/*private byte[] encodeString(string str)
		{
			if(str != null && str.Length > 0)
			{
				char[] chStr = str.ToCharArray;
				byte[] btStr = new byte[chStr.Length];
				for(int i = 0; i < btStr.Length; i++)
				{
					if((i % 2) == 0)
					{
						btStr[i] = (byte)(chStr[i] + 20);
					}
					else
					{
						btStr[i] = (byte)(chStr[i] - 20);
					}
				}
			}
		}*/
		
		void RadioButton1CheckedChanged(object sender, System.EventArgs e)
		{
			if(sender is RadioButton)
			{
				RadioButton receiver = (RadioButton)sender;
				if(receiver.Checked) // were doing a trial license
				{
					nudNumberOfUsers.Text = "10";
					nudNumberOfUsers.Enabled = false;
					
					nudDaysInTrial.Visible = true;
					nudDaysInTrial.Enabled = true;
					nudDaysInTrial.Text = "14";
					lbDaysInTrial.Visible = true;
					lbDaysInTrial.Enabled = true;
				}
				else
				{
					nudNumberOfUsers.Enabled = true;
					
					nudDaysInTrial.Visible = false;
					nudDaysInTrial.Enabled = false;
					lbDaysInTrial.Visible = false;
					lbDaysInTrial.Enabled = false;
				}
			}
			
			
			//tfUsers
		}
		
		void showCompanyToolTip(object sender, System.EventArgs e)
		{

		}
		void GroupBox1Enter(object sender, System.EventArgs e)
		{
			
		}
		
		void SqlConnection1InfoMessage(object sender, System.Data.SqlClient.SqlInfoMessageEventArgs e)
		{
			
		}
		
	}
}
