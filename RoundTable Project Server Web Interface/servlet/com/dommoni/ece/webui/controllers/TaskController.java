/*
 * Created on Apr 21, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.ece.webui.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Task;
import com.dommoni.roundtable.TaskStatus;
import com.dommoni.roundtable.projectServer.services.taskManager.ITaskManager;

import com.dommoni.ece.webui.MenuController;
import com.dommoni.ece.webui.MenuItem;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TaskController
{
   public void createToDo(HttpServletRequest request, 
                          HttpServletResponse response, 
                          MenuController menuController)
   {
      try
      {
         String title = request.getParameter("title");
         int flag = 0; 
         String dueDate = request.getParameter("duedate");
         String description = request.getParameter("description");
         String isPrivate = request.getParameter("isprivate");
         int status = 0;
         
         try
         {
            flag = Integer.parseInt(request.getParameter("flag"));
         }
         catch(Exception e){}
         
         try
         {
            status = Integer.parseInt(request.getParameter("status"));
         }
         catch(Exception e){}
         
         HttpSession session = request.getSession();
         
         ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
         Project currentProject = (Project)session.getAttribute("currentproject");
         Account account = (Account)session.getAttribute("useraccount");
         
         Task todo = new Task();
         todo.setTitle(title);
         todo.setProjectId(currentProject.getId());
         todo.setCreatedBy(account.getId());
         todo.setCreatedOn(Calendar.getInstance());
         todo.setFlag(flag);
         todo.setDescription(description);
         todo.setIsPublic(true); // default setting
         
         if(isPrivate != null && isPrivate.equals("yes"))
         {
            todo.setIsPublic(false);
         }
         
         // due date
         try
         {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            
            Date dtDueDate = sdf.parse(dueDate);
            
            Calendar clDueDate = Calendar.getInstance();
            clDueDate.setTime(dtDueDate);
            todo.setDueDate(clDueDate);
         }
         catch(ParseException pe)
         {
            todo.setDueDate(null);
         
            pe.printStackTrace();
         }
         
         // status
         TaskStatus todoStatus = psc.getTaskManager().getTaskStatus(status);
         if(todoStatus != null)
            todo.setCurrentStatus(todoStatus);   
            
         psc.getTaskManager().addTask(todo);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
 
      HashMap menus = (HashMap)request.getSession().getAttribute("menus");
      MenuItem currentMenu = menuController.getMenuItemFromId(menuController.getCurrentPageId(), menus);

      try
      {
         response.sendRedirect("../" + currentMenu.link);
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
   }
   
   public void deleteToDo(HttpServletRequest request, HttpServletResponse response)
   {
      String todoId = request.getParameter("todoid");
      String parentLink = request.getParameter("parentlink");
      
      try
      {
         int iTodoId = Integer.parseInt(todoId);
         
         ProjectServerConnection psc = (ProjectServerConnection)request.getSession().getAttribute("psc");
      
         psc.getTaskManager().dropTask(iTodoId);
         
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
   
   public void editToDo(HttpServletRequest request, HttpServletResponse response)
   {
      String todoId = request.getParameter("todoid");
      String title = request.getParameter("title");
      String isPrivate = request.getParameter("isprivate");
      String status = request.getParameter("status");
      String description = request.getParameter("description");
      String duedate = request.getParameter("duedate");   
      
      try
      {
         ProjectServerConnection psc = (ProjectServerConnection)request.getSession().getAttribute("psc");
         ITaskManager todoManager = psc.getTaskManager();
         
         int iTodoid = Integer.parseInt(todoId);
         Task todo = todoManager.getTask(iTodoid);
         
         if(todo != null)
         {
            // Title
            todo.setTitle(title);
            
            // IsPublic
            if(isPrivate != null && isPrivate.equalsIgnoreCase("yes"))
               todo.setIsPublic(true);
            else
               todo.setIsPublic(false);
            
            // Status
            todo.setCurrentStatus(todoManager.getTaskStatus(Integer.parseInt(status)));
            
            // Description
            todo.setDescription(description);
            
            // Due Date
            try
            {
               // yyyy/mm/dd
               SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
               Date dtDueDate = sdf.parse(duedate);
               
               Calendar clDueDate = Calendar.getInstance();
               clDueDate.setTime(dtDueDate);
               
               todo.setDueDate(clDueDate);
            }
            catch(Exception e)
            {
               todo.setDueDate(null);
            }
            
            todoManager.modifyTask(todo);   
         }
         
         // forward the output
         try
         {
            response.sendRedirect("../projectTodosViewTodo.jsp?todoid=" + todoId);
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
}
/*
 * 
 * $Log: TaskController.java,v $
 * Revision 1.1  2005/10/16 06:09:14  brian
 * Renamed from TodoController.
 *
 * 
 */
