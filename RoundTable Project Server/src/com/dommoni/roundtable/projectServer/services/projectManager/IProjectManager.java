/*
 * Created on Mar 16, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.projectManager;

import com.dommoni.roundtable.Project;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface IProjectManager
{
   public int addProject(Project project)
   throws Exception;
   
   public void dropProject(int projectId)
   throws Exception;
   
   public void modifyProject(Project project)
   throws Exception;
   
   public Project getProject(int projectId)
   throws Exception;
   
   public Project[] getAllProjects()
   throws Exception;
   
   public Project[] getAllProjectsForAccount(int accountId)
   throws Exception;
}
