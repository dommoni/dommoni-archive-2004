/*
 * IProjectManager.cs
 * 
 * Created on Mar 17, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;

namespace RoundTable.ProjectServer.Services.ProjectManager
{
	/// <summary>
	/// Summary description for IProjectManager.
	/// </summary>
	public interface IProjectManager
	{
		int addProject(Project project);
   
		void dropProject(int projectId);
   
		void modifyProject(Project project);
   
		Project getProject(int projectId);
   
		Project[] getAllProjects();
   
		Project[] getAllProjectsForAccount(int accountId);
	}
}
/*
 * 
 * $Log: IProjectManager.cs,v $
 * Revision 1.1  2005/03/20 15:49:26  brian
 * Initial Revision.
 *
 * 
 */