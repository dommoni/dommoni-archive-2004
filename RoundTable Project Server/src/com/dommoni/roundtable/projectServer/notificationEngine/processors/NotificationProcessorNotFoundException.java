/*
 * Created on Sep 29, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.notificationEngine.processors;

import com.dommoni.roundtable.Notification;
import com.dommoni.roundtable.projectServer.events.Event;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NotificationProcessorNotFoundException extends Exception
{
   private Notification notifications[];
   private Event event;
   
   public NotificationProcessorNotFoundException(String message, Notification notification[], Event event)
   {
      super(message);
      this.notifications = notification;
      this.event = event;
   }
   
   /**
    * Returns the Notification associated with this exception
    * 
    * @see Notification
    * @return
    */
   public Notification[] getNotifications()
   {
      return this.notifications;
   }
   
   /**
    * Returns the event associated with this exception
    * 
    * @see Event
    * @return
    */
   public Event getEvent()
   {
      return this.event;
   }
}
/*
 *
 * $Log: NotificationProcessorNotFoundException.java,v $
 * Revision 1.1.1.1  2005/03/14 21:02:40  Brian Abbott
 * no message
 *
 *
 */