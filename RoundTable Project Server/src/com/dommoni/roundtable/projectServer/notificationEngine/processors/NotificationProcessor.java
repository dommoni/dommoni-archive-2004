/*
 * Created on Sep 27, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.notificationEngine.processors;

import com.dommoni.roundtable.Notification;
import com.dommoni.roundtable.projectServer.events.Event;

/**
 * The purpose of the processor is to handle 
 * object specific parameters and message formatting.
 * 
 * @author Brian Abbott
 */
public abstract class NotificationProcessor extends Thread
{
   protected Event event;
   protected Notification notifications[];
   
   public NotificationProcessor(Event event, Notification notifications[])
   {
      this.event = event;
      this.notifications = notifications;
   }
   
   public abstract void run();
}
/*
 * 
 * $Log: NotificationProcessor.java,v $
 * Revision 1.2  2005/03/26 19:24:12  brian
 * no message
 *
 * 
 */
