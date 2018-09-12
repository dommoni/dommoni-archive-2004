/*
 * Created on Apr 29, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.notificationEngine;

import com.dommoni.roundtable.projectServer.notificationEngine.transporters.DesktopPagerTransporter;
import com.dommoni.roundtable.projectServer.notificationEngine.transporters.EmailTransporter;
import com.dommoni.roundtable.projectServer.notificationEngine.transporters.SystemMessageTransporter;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NotificationMessageTransporter
{
   /*NotificationMessage messages[];
   
   public NotificationMessageTransporter(NotificationMessage messages[])
   {
      this.messages = messages;
   }
   
   /**
    * Determines which sub-transporters to use and starts those.
    *
    *
   public void transport()
   {
      System.out.println("Entering NotificationMessageTransporter.transport()");
      System.out.println("\tmessages.length: " + messages.length);
      
      for(int i = 0; i < messages.length; i++)
      {
         if(messages[i].getMessageType() == NotificationMessage.SYSTEM_MESSAGE)
         {
            SystemMessageTransporter smt = new SystemMessageTransporter(messages[i]);
            smt.transport();
         }
         else if(messages[i].getMessageType() == NotificationMessage.DESKTOPPAGER_MESSAGE)
         {
            DesktopPagerTransporter dpt = new DesktopPagerTransporter(messages[i]);
            dpt.transport();
         }
         else if(messages[i].getMessageType() == NotificationMessage.EMAIL_MESSAGE)
         {
            //EmailTransporter et = new EmailTransporter(messages[i]);
            //et.transport();
         }
      }
   }*/
}
/*
 * 
 * $Log: NotificationMessageTransporter.java,v $
 * Revision 1.1.1.1  2005/03/14 21:02:40  Brian Abbott
 * no message
 *
 * 
 */
