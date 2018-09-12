package com.dommoni.ece.webui;

import java.io.IOException;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;

import com.dommoni.ece.webui.menus.MenuItemMap;

public class LoginHandler
{
   String ADMIN_HOME = "adminMain.jsp";
   String USER_HOME = "projectMain.jsp";
   String MANAGER_HOME = "adminProjects.jsp";
   
   public void handleLoginRequest(HttpServletRequest request, HttpServletResponse response)
   {
      Account account = null;
      ProjectServerConnection psc = 
         (ProjectServerConnection)request.getSession().getAttribute("psc");
      
      try
      {
         account = psc.getAccountManager().getAccountFromUsername(psc.getUsername());
         request.getSession().setAttribute("useraccount", account);
         request.getSession().setAttribute("currentstate", new UIState(UIState.LOGGED_IN));
         request.getSession().setAttribute("currentproject", null);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      
      if(account.getAccountType() == AccountType.SYSTEM_ADMINISTRATOR)
      {
         MenuItemMap menus = (MenuItemMap)request.getSession().getAttribute("menus");
         Vector menu = (Vector)menus.get("adminmenu");
         for(int i = 0; i < menu.size(); i++)
         {
            if(((MenuItem)menu.get(i)).link.equals(ADMIN_HOME))
            {
               ((MenuItem)menu.get(i)).current = true;
            }
            else
            {
               ((MenuItem)menu.get(i)).current = false;
            }
         }

         try
         {
            response.sendRedirect("../" + ADMIN_HOME);
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
      }
      else if(account.getAccountType() == AccountType.END_USER)
      {
         // this works because either way, the user will end up at projectsMain.jsp
         MenuItemMap menus = (MenuItemMap)request.getSession().getAttribute("menus");
         Vector menu = (Vector)menus.get("mainmenu");
         for(int i = 0; i < menu.size(); i++)
         {
            if(((MenuItem)menu.get(i)).link.equals(USER_HOME))
            {
               ((MenuItem)menu.get(i)).current = true;
            }
            else
            {
               ((MenuItem)menu.get(i)).current = false;
            }
         }

         Project projects[] = null;
         try
         {
            IProjectManager projectManager = psc.getProjectManager();
            projects = projectManager.getAllProjectsForAccount(account.getId());
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
         
         if(projects != null && projects.length >= 1)
         {
            if(projects.length == 1)
            {
               // user is only a member of 1 project
               request.getSession().setAttribute("currentproject", projects[0]);
               psc.setCurrentProject(projects[0]);
               
               try
               {
                  response.sendRedirect("../projectMain.jsp");
               }
               catch(IOException ioe)
               {
                  ioe.printStackTrace();
               }
            }
            else if(projects.length > 1)
            {
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
         else // selectProjects gives a message if the user doesnt belong to any projects
         {
            try
            {
               response.sendRedirect("../selectProjects.jsp");
            }
            catch(IOException ioe)
            {
               ioe.printStackTrace();
            }
         }
      }// END-USER
      else if(account.getAccountType() == AccountType.MANAGER)
      {
         MenuItemMap menus = (MenuItemMap)request.getSession().getAttribute("menus");
         Vector menu = (Vector)menus.get("managermenu");
         for(int i = 0; i < menu.size(); i++)
         {
            if(((MenuItem)menu.get(i)).link.equals(MANAGER_HOME))
            {
               ((MenuItem)menu.get(i)).current = true;
            }
            else
            {
               ((MenuItem)menu.get(i)).current = false;
            }
         }

         try
         {
            response.sendRedirect("../" + MANAGER_HOME);
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
      }
   }

   public void handleLogoutRequest(HttpServletRequest request, HttpServletResponse response)
   {
      request.getSession().setAttribute("currentproject", null);
      try
      {
         response.sendRedirect("../login.jsp");
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
   }
}
