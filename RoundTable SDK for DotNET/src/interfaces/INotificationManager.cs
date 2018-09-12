/*
 * INotificationManager.cs
 * 
 * Created on Mar 17, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;

namespace RoundTable.ProjectServer.Services.NotificationManager
{
	/// <summary>
	/// Summary description for INotificationManager.
	/// </summary>
	public interface INotificationManager
	{
		int addNotification(Notification notification);
   
		void dropNotification(int notificationId);
   
		void modifyNotification(Notification notification);
   
		Notification getNotification(int notificationId);
   
		Notification[] getAllNotifications();
   
		Notification[] getAllNotificationsForProject(int projectId);
   
		Notification[] getAllNotificationsForAccount(int accountId);
   
		Notification[] getAllNotificationsForAccountProject(int accountId, int projectId);
   
		Notification[] getAllNotificationsForAccountProjectObject(int accountId, int projectId, String ojbectName);
	}
}
/*
 * 
 * $Log: INotificationManager.cs,v $
 * Revision 1.1  2005/03/20 15:49:26  brian
 * Initial Revision.
 *
 * 
 */
