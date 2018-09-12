/*
 * Created on Apr 28, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.ece.webui.controllers;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Notification;
import com.dommoni.roundtable.NotificationType;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.projectServer.services.notificationManager.INotificationManager;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NotificationController
{
   public void createNotification(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
         String user = "";
         
         String nc = request.getParameter("nc"); // NotificationContext
         String type = request.getParameter("type");
         String object = request.getParameter("object");
         String operation = request.getParameter("operation");
         
         String path = request.getParameter("path");
         
         if(type.toLowerCase().equals("user"))
            user = request.getParameter("user");
             
         System.out.println("Printing Notification Parameters");
         System.out.println("NC: " + nc);
         System.out.println("Type: " + type);
         System.out.println("Object: " + object);
         System.out.println("Operation: " + operation);
         System.out.println("Path: " + path);
         System.out.println("User: " + user);
        
         Notification notif = new Notification();
         notif.setCreatedBy(((Account)request.getSession().getAttribute("useraccount")).getId());
         notif.setCreatedOn(Calendar.getInstance());
         notif.setProjectId(((Project)request.getSession().getAttribute("currentproject")).getId());
         
         notif.setContext(nc);
         
         if(type.toLowerCase().equals("user"))
         {   
            notif.setType(NotificationType.USER); 
            notif.setUserIds(new int[] {Integer.parseInt(user)});
         } 
         else
         {   
            notif.setType(NotificationType.OBJECT);
            if(!object.toLowerCase().equals("all"))
            {
               notif.setObjectIds(new int[] {Integer.parseInt(object)}); 
            }
         }
         
         // operation
         if(operation.toLowerCase().equals("all"))
         {   
            notif.setOperation(Notification.ANY_OPERATION); 
         } 
         else if(operation.toLowerCase().equals("create"))
         {   
            notif.setOperation(Notification.CREATE_OPERATION); 
         } 
         else if(operation.toLowerCase().equals("modify"))
         {   
            notif.setOperation(Notification.MODIFICATION_OPERATION); 
         } 
         else if(operation.toLowerCase().equals("delete"))
         {   
            notif.setOperation(Notification.DELETION_OPERATION); 
         } 
         
         ProjectServerConnection psc = (ProjectServerConnection)request.getSession().getAttribute("psc");
         INotificationManager notificationManager = psc.getNotificationManager();
         notificationManager.addNotification(notif);
         
         try
         {
            request.getSession().setAttribute("notif", notif);
            response.sendRedirect("../projectNotificationsNotificationWizardSuccess.jsp?path=."+path);
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
   
   public void deleteNotification(HttpServletRequest request, HttpServletResponse response)
   {
       
   }
}
