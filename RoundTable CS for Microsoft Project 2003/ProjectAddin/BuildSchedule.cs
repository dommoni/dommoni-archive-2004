/*
 * RoundTable Connected Services for Microsoft Project 2003
 * 
 * Created On: 1/23/2005
 * Created By: Brian Abbott
 * 
 * Copyright 2005. Dommoni Corporation. All Rights Reserved.
 */

using System;
using System.Drawing;
using System.Collections;
using System.ComponentModel;
using System.Windows.Forms;

using MSProject = Microsoft.Office.Interop.MSProject;
using com.dommoni.roundtable;

namespace ProjectAddin
{
	/// <summary>
	/// Summary description for BuildSchedule.
	/// </summary>
	public class BuildSchedule : System.Windows.Forms.Form
	{
		private System.Windows.Forms.Button bnOk;
		private System.Windows.Forms.Button bnCancel;
		private System.Windows.Forms.Label lbProjectSelect;
		private System.Windows.Forms.ComboBox cbSelectProject;
		private System.Windows.Forms.CheckBox cbPrivateTasks;
		private dotNetFlatControls.GradientPanel gradientPanel1;
		private dotNetFlatControls.FlatLabel flTitle;

		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.Container components = null;

		public BuildSchedule(MSProject.Application projectApp, ProjectServerConnection psc)
		{
			//
			// Required for Windows Form Designer support
			//
			InitializeComponent();

			//
			// TODO: Add any constructor code after InitializeComponent call
			//

			this.projectApp = projectApp;
			this.psc = psc;
			Project[] userProjects = psc.getProjectManager().getAllProjectsForAccount(psc.getAccount().id);
			foreach(Project project in userProjects)
			{
				ProjectListItem pli = new ProjectListItem();
				pli.Name = project.name;
				pli.Project = project;
				cbSelectProject.Items.Add(pli);
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
			this.bnOk = new System.Windows.Forms.Button();
			this.bnCancel = new System.Windows.Forms.Button();
			this.lbProjectSelect = new System.Windows.Forms.Label();
			this.cbSelectProject = new System.Windows.Forms.ComboBox();
			this.cbPrivateTasks = new System.Windows.Forms.CheckBox();
			this.gradientPanel1 = new dotNetFlatControls.GradientPanel();
			this.flTitle = new dotNetFlatControls.FlatLabel();
			this.gradientPanel1.SuspendLayout();
			this.SuspendLayout();
			// 
			// bnOk
			// 
			this.bnOk.Location = new System.Drawing.Point(120, 232);
			this.bnOk.Name = "bnOk";
			this.bnOk.TabIndex = 0;
			this.bnOk.Text = "Ok";
			this.bnOk.Click += new System.EventHandler(this.bnOk_Click);
			// 
			// bnCancel
			// 
			this.bnCancel.Location = new System.Drawing.Point(208, 232);
			this.bnCancel.Name = "bnCancel";
			this.bnCancel.TabIndex = 1;
			this.bnCancel.Text = "Cancel";
			this.bnCancel.Click += new System.EventHandler(this.bnCancel_Click);
			// 
			// lbProjectSelect
			// 
			this.lbProjectSelect.Location = new System.Drawing.Point(40, 80);
			this.lbProjectSelect.Name = "lbProjectSelect";
			this.lbProjectSelect.Size = new System.Drawing.Size(56, 23);
			this.lbProjectSelect.TabIndex = 3;
			this.lbProjectSelect.Text = "Project:";
			// 
			// cbSelectProject
			// 
			this.cbSelectProject.Location = new System.Drawing.Point(112, 80);
			this.cbSelectProject.Name = "cbSelectProject";
			this.cbSelectProject.Size = new System.Drawing.Size(121, 21);
			this.cbSelectProject.TabIndex = 4;
			// 
			// cbPrivateTasks
			// 
			this.cbPrivateTasks.Location = new System.Drawing.Point(40, 112);
			this.cbPrivateTasks.Name = "cbPrivateTasks";
			this.cbPrivateTasks.Size = new System.Drawing.Size(240, 24);
			this.cbPrivateTasks.TabIndex = 5;
			this.cbPrivateTasks.Text = "Do you wish to include your private tasks?";
			// 
			// gradientPanel1
			// 
			this.gradientPanel1.BackColor = System.Drawing.Color.Blue;
			this.gradientPanel1.ColorFrom = System.Drawing.Color.Blue;
			this.gradientPanel1.ColorTo = System.Drawing.Color.White;
			this.gradientPanel1.Controls.Add(this.flTitle);
			this.gradientPanel1.FillStyle = 3;
			this.gradientPanel1.Location = new System.Drawing.Point(0, 0);
			this.gradientPanel1.Name = "gradientPanel1";
			this.gradientPanel1.RelativeStartPerc = 27;
			this.gradientPanel1.Size = new System.Drawing.Size(296, 64);
			this.gradientPanel1.TabIndex = 6;
			this.gradientPanel1.Paint += new System.Windows.Forms.PaintEventHandler(this.gradientPanel1_Paint);
			// 
			// flTitle
			// 
			this.flTitle.AutoSizeWidth = false;
			this.flTitle.BackColor = System.Drawing.Color.Transparent;
			this.flTitle.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((System.Byte)(0)));
			this.flTitle.LineCount = 3;
			this.flTitle.Location = new System.Drawing.Point(0, 8);
			this.flTitle.Name = "flTitle";
			this.flTitle.Size = new System.Drawing.Size(128, 88);
			this.flTitle.TabIndex = 0;
			this.flTitle.Text = "Build a Schedule from RoundTable";
			// 
			// BuildSchedule
			// 
			this.AutoScaleBaseSize = new System.Drawing.Size(5, 13);
			this.ClientSize = new System.Drawing.Size(292, 266);
			this.Controls.Add(this.gradientPanel1);
			this.Controls.Add(this.cbPrivateTasks);
			this.Controls.Add(this.cbSelectProject);
			this.Controls.Add(this.lbProjectSelect);
			this.Controls.Add(this.bnCancel);
			this.Controls.Add(this.bnOk);
			this.Name = "BuildSchedule";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Build from RoundTable";
			this.gradientPanel1.ResumeLayout(false);
			this.ResumeLayout(false);

		}
		#endregion

		private void bnOk_Click(object sender, System.EventArgs e)
		{
			// user hit okay. 
			ProjectListItem selectedProject = (ProjectListItem)cbSelectProject.SelectedItem;
			MSProject.Project current = projectApp.ActiveProject;
			
			if(current != null)
			{	
				try
				{
					ToDo[] todos = psc.getTodoManager().getAllToDosForProject(selectedProject.Project.id);
					DateTime startTime = todos[0].dueDate;

					for(int i = 0; i < todos.Length; i++)
					{
						try
						{
							if(todos[i].dueDate < startTime)
								startTime = todos[i].dueDate;

							MSProject.Task newTask = current.Tasks.Add(todos[i].name, i + 1);
							newTask.Notes = todos[i].description;
							newTask.Finish = todos[i].dueDate;
							//MessageBox.Show(todos[i].dueDate.GetType().Name);
							//MessageBox.Show(newTask.Finish.ToString() + " :: " + newTask.Finish.GetType().Name);
						}
						catch{}
					}
					//current.ProjectStart = startTime;

					// temporary!
					
				}
				catch(Exception ex)
				{
				}
				Close();
				Dispose();
			}
			else
			{
				MessageBox.Show("ERROR: Unable to find an Active Project!");
			}
		}

		private void bnCancel_Click(object sender, System.EventArgs e)
		{
			Close();
			Dispose();
		}

		MSProject.Application projectApp = null;
		ProjectServerConnection psc = null;

		private void gradientPanel1_Paint(object sender, System.Windows.Forms.PaintEventArgs e)
		{
		
		}
	}

	
	class ProjectListItem
	{
		private string name;
		private Project project;

		public string Name {get {return name;} set{name = value;}}
		public Project Project {get {return project;} set{project = value;}}

		public override string ToString()
		{
			return name;
		}
	}
}
