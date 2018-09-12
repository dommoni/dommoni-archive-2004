/*
 * Created on Mar 24, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.notificationManager;

import com.dommoni.roundtable.Notification;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface INotificationManager
{
   public int addNotification(Notification notification)
   throws Exception;
   
   public void dropNotification(int notificationId)
   throws Exception;
   
   public void modifyNotification(Notification notification)
   throws Exception;
   
   public Notification getNotification(int notificationId)
   throws Exception;
   
   public Notification[] getAllNotifications()
   throws Exception;
   
   public Notification[] getAllNotificationsForProject(int projectId)
   throws Exception;
   
   public Notification[] getAllNotificationsForAccount(int accountId)
   throws Exception;
   
   public Notification[] getAllNotificationsForAccountProject(int accountId, int projectId)
   throws Exception;
   
   public Notification[] getAllNotificationsForAccountProjectObject(int accountId, int projectId, String ojbectName)
   throws Exception;
}
