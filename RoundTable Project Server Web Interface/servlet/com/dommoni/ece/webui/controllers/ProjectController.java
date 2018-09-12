package com.dommoni.ece.webui.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;

import com.dommoni.ece.webui.MenuController;
import com.dommoni.ece.webui.MenuItem;

public class ProjectController
{
   /**
    * Creates the project specified in the Query Params.
    * 
    * @author Brian Abbott - brian@dommoni.com
    */
   public void createProject(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
         String projectName = request.getParameter("name");
         String memberIds[] = request.getParameterValues("list2");
            
         HttpSession session = request.getSession();
         ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
         if(psc == null)
         {
            try
            {
               // previous page should now display with the new link.
               response.sendRedirect("../adminProjects.jsp");
            }
            catch(IOException ioe)
            {
               ioe.printStackTrace();
            }
            return;
         }
         
         Vector accounts = new Vector();
         IAccountManager accountManager = psc.getAccountManager();
         
         if(memberIds != null)
         {
            for(int i = 0; i < memberIds.length; i++)
            {
               try
               {
                  Account account = accountManager.getAccount(Integer.parseInt(memberIds[i]));
                  if(account != null)
                  {   
                     accounts.add(account);
                  }
               }
               catch(NumberFormatException nfe)
               {
                  // Just let everyone know and keep going...
                  nfe.printStackTrace();
               }
            }
         }
   
         Project project = new Project();
         project.setName(projectName);
         project.setMembers((Account[])accounts.toArray(new Account[accounts.size()]));
   
         psc.getProjectManager().addProject(project);
   
         try
         {
            // previous page should now display with the new link.
            response.sendRedirect("../adminProjects.jsp");
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }

   public void deleteProject(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
         Integer projectId = new Integer(request.getParameter("projectid"));
         String parentLink = request.getParameter("parentlink");
         
         ProjectServerConnection psc = (ProjectServerConnection)request.getSession().getAttribute("psc");
         IProjectManager projectManager = psc.getProjectManager();
         
         Project project = projectManager.getProject(projectId.intValue());
         String projectName = project.getName();
   
         projectManager.dropProject(projectId.intValue());
   
         try
         {
            response.sendRedirect("../projectConfirmDeleteDlgSuccess.jsp?parentlink=" + parentLink);
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }

   public void editProject(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
         HttpSession session = request.getSession();
         ProjectServerConnection psc = 
            (ProjectServerConnection)session.getAttribute("psc");
         IProjectManager projectManager = psc.getProjectManager();
         IAccountManager accountManager = psc.getAccountManager();
         
         int projectId = Integer.parseInt(request.getParameter("projectId"));
         String projectName = request.getParameter("name");
         String userIds[] = request.getParameterValues("list2");
         Account iUsers[] = new Account[userIds.length];
         for(int i = 0; i < userIds.length; i++)
         {
            try
            {
               iUsers[i] = accountManager.getAccount(Integer.parseInt(userIds[i]));
            }
            catch(Exception e)
            {
               e.printStackTrace();
            }
         }
         
         Project modifiedProject = new Project();
         modifiedProject.setId(projectId);
         modifiedProject.setMembers(iUsers);
         modifiedProject.setName(projectName);
         
         projectManager.modifyProject(modifiedProject);
         
         try
         {
            response.sendRedirect("../adminProjects.jsp");
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }

   public void setCurrentProject(HttpServletRequest request, 
                                 HttpServletResponse response,
                                 MenuController menuController)
   {
      try
      {
         HttpSession userSession = request.getSession();
         ProjectServerConnection psc = (ProjectServerConnection)userSession.getAttribute("psc");
         int projectId = Integer.parseInt(request.getParameter("projectId"));
         IProjectManager projectManager = psc.getProjectManager();
   
         Project currentProject = projectManager.getProject(projectId);
         
         if(currentProject != null)
         {
            //
            // Set current project on the ProjectServer
            //
            psc.setCurrentProject(currentProject);
            
            userSession.setAttribute("currentproject", currentProject);
   
            HttpSession session = request.getSession();
            HashMap menus = (HashMap)session.getAttribute("menus");
            MenuItem currentMenu = menuController.getMenuItemFromId(menuController.getCurrentPageId(),
                                                                     menus);
            if(currentMenu != null)
               currentMenu.current = false;
            
            Vector mainMenu = (Vector)menus.get("mainmenu");
            for(int i = 0; i < mainMenu.size(); i++)
            {
               if(((MenuItem)mainMenu.get(i)).link.equals("projectMain.jsp"))
               {
                  ((MenuItem)mainMenu.get(i)).current = true;
               }
               else
               {  // just to be sure.
                  ((MenuItem)mainMenu.get(i)).current = false;
               }
            }
           
            try
            {
               response.sendRedirect("../projectMain.jsp");
            }
            catch(IOException ioe)
            {
               ioe.printStackTrace();
            }
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void closeProject(HttpServletRequest request, 
                            HttpServletResponse response,
                            MenuController menuController)
   {      
      request.getSession().setAttribute("currentproject", null);
      try
      {
         response.sendRedirect("../selectProjects.jsp");
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
   }
}
/*
 * 
 * $Log: ProjectController.java,v $
 * Revision 1.2  2005/10/16 06:06:10  brian
 * Removed print statements.
 *
 * 
 */
