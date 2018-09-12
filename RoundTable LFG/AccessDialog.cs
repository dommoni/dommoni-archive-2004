/*
 * Created by SharpDevelop.
 * User: Brian Abbott
 * Date: 12/23/2004
 * Time: 3:15 AM
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */

using System;
using System.Drawing;
using System.Windows.Forms;

namespace RoundTable_LFG
{
	/// <summary>
	/// Description of AccessDialog.
	/// </summary>
	public class AccessDialog : System.Windows.Forms.Form
	{
		private System.Windows.Forms.Label label3;
		private System.Windows.Forms.Button button2;
		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.TextBox tfUsername;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Button button1;
		private System.Windows.Forms.TextBox tfPassword;
		public AccessDialog()
		{
			//
			// The InitializeComponent() call is required for Windows Forms designer support.
			//
			InitializeComponent();
			
			//
			// TODO: Add constructor code after the InitializeComponent() call.
			//
		}
		
		#region Windows Forms Designer generated code
		/// <summary>
		/// This method is required for Windows Forms designer support.
		/// Do not change the method contents inside the source code editor. The Forms designer might
		/// not be able to load this method if it was changed manually.
		/// </summary>
		private void InitializeComponent() {
			this.tfPassword = new System.Windows.Forms.TextBox();
			this.button1 = new System.Windows.Forms.Button();
			this.label2 = new System.Windows.Forms.Label();
			this.tfUsername = new System.Windows.Forms.TextBox();
			this.label1 = new System.Windows.Forms.Label();
			this.button2 = new System.Windows.Forms.Button();
			this.label3 = new System.Windows.Forms.Label();
			this.SuspendLayout();
			// 
			// tfPassword
			// 
			this.tfPassword.Location = new System.Drawing.Point(88, 72);
			this.tfPassword.Name = "tfPassword";
			this.tfPassword.PasswordChar = '*';
			this.tfPassword.TabIndex = 2;
			this.tfPassword.Text = "";
			// 
			// button1
			// 
			this.button1.BackColor = System.Drawing.SystemColors.Control;
			this.button1.Location = new System.Drawing.Point(48, 112);
			this.button1.Name = "button1";
			this.button1.TabIndex = 3;
			this.button1.Text = "Accept";
			this.button1.Click += new System.EventHandler(this.Button1Click);
			// 
			// label2
			// 
			this.label2.Location = new System.Drawing.Point(24, 40);
			this.label2.Name = "label2";
			this.label2.TabIndex = 0;
			this.label2.Text = "Username:";
			// 
			// tfUsername
			// 
			this.tfUsername.Location = new System.Drawing.Point(88, 40);
			this.tfUsername.Name = "tfUsername";
			this.tfUsername.TabIndex = 1;
			this.tfUsername.Text = "";
			// 
			// label1
			// 
			this.label1.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.label1.Location = new System.Drawing.Point(8, 8);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(240, 23);
			this.label1.TabIndex = 0;
			this.label1.Text = "Enter your LFG Access Information";
			this.label1.Click += new System.EventHandler(this.Label1Click);
			// 
			// button2
			// 
			this.button2.BackColor = System.Drawing.SystemColors.Control;
			this.button2.Location = new System.Drawing.Point(160, 112);
			this.button2.Name = "button2";
			this.button2.TabIndex = 4;
			this.button2.Text = "Cancel";
			this.button2.Click += new System.EventHandler(this.Button2Click);
			// 
			// label3
			// 
			this.label3.Location = new System.Drawing.Point(24, 72);
			this.label3.Name = "label3";
			this.label3.TabIndex = 0;
			this.label3.Text = "Password:";
			// 
			// AccessDialog
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 14);
			this.BackColor = System.Drawing.Color.WhiteSmoke;
			this.ClientSize = new System.Drawing.Size(274, 144);
			this.Controls.Add(this.tfPassword);
			this.Controls.Add(this.button2);
			this.Controls.Add(this.button1);
			this.Controls.Add(this.tfUsername);
			this.Controls.Add(this.label3);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.label1);
			this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
			this.MaximizeBox = false;
			this.Name = "AccessDialog";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Access Information";
			this.ResumeLayout(false);
		}
		#endregion
		void Label1Click(object sender, System.EventArgs e)
		{
			
		}
		
		void Button1Click(object sender, System.EventArgs e)
		{
			this.closeState = CloseState.OKAY;
			this.Close();
		}
		
		void Button2Click(object sender, System.EventArgs e)
		{
			this.closeState = CloseState.CANCEL;
			this.Close();
		}
		
		private CloseState closeState;
		public CloseState Interaction { // ok,cancel
			get {
				return this.closeState;
			}
		}
		
	}
	
	public enum CloseState {
		NONE, OKAY, CANCEL
	}
}
