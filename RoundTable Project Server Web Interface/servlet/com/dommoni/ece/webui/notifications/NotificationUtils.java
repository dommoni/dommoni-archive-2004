/*
 * Created on Sep 26, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.ece.webui.notifications;

import com.dommoni.roundtable.Notification;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NotificationUtils
{
   public String getFriendlyContextName(Notification notification)
   {
      String ncName = notification.getContext().toLowerCase();
      char[] ncChars = ncName.toCharArray();
      ncChars[0] = Character.toUpperCase(ncName.charAt(0));
      
      return new String(ncChars);
   }
   
   public String getNameFromNotification(Notification notification)
   {
      // name: ToDo Notification: any operation, any user
      StringBuffer name = new StringBuffer();
      name.append(getFriendlyContextName(notification));
      name.append(" Notification: ");
      
      System.out.println("Operation: " + notification.getOperation());
      if(notification.getOperation() == Notification.ANY_OPERATION)
      {
         System.out.println("Doing: Any Operation");
         name.append("any operation");
      }
      if(notification.getOperation() == Notification.CREATE_OPERATION)
      {
         System.out.println("Doing: Create Operation");
         name.append("create operation");
      }
      if(notification.getOperation() == Notification.DELETION_OPERATION)
      {
         System.out.println("Doing: Delete Operation");
         
         name.append("delete operation");
      }
      if(notification.getOperation() == Notification.MODIFICATION_OPERATION)
      {
         System.out.println("Doing: Modification Operation");
         
         name.append("modify operation");
      }
      
      return name.toString();
   }
}
