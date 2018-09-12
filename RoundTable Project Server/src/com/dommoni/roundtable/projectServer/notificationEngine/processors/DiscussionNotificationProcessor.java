/*
 * Created on Nov 21, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.notificationEngine.processors;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountSettings;
import com.dommoni.roundtable.Discussion;
import com.dommoni.roundtable.Notification;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.notificationEngine.transporters.EmailTransporter;
import com.dommoni.roundtable.projectServer.services.accountManager.AccountManager;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.utils.DebugUtils;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DiscussionNotificationProcessor extends NotificationProcessor
{
   public DiscussionNotificationProcessor(Event event, Notification notifications[])
   {
      super(event, notifications);
   }
   
   public void run()
   {
      try
      {
         if(event == null)
         {
            return;
         }
      
         StringBuffer message = new StringBuffer();
         message.append("Discussion Notification:\n\n");
      
         // User x has done y to object z
      
         IAccountManager accountManager = new AccountManager();
         Account instigator = accountManager.getAccount(event.getInstigatorId());
      
         message.append(instigator.getName());
      
         if(event.getOperationType() == Notification.CREATE_OPERATION)
         {
            message.append(" has created ");
         }
         else if(event.getOperationType() == Notification.DELETION_OPERATION)
         {
            message.append(" has deleted ");
         }
         else if(event.getOperationType() == Notification.MODIFICATION_OPERATION)
         {
            message.append(" has modified ");
         }
         else if(event.getOperationType() == Notification.RETRIEVAL_OPERATION)
         {
            return; // not yet implemented.
         }
      
         // should always be a document but, better safe then sorry.
         Discussion discussion;
         if(event.getObject() instanceof Discussion)
            discussion = (Discussion)event.getObject();
         else
            return;
         
         SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMMM d yyyy, hh:mm aaa");
         message.append("discussion " + discussion.getName() + " on " + sdf.format(Calendar.getInstance().getTime()));
      
         Map recipients = new HashMap();
      
         for(int i = 0; i < notifications.length; i++)
         {
            try
            {
               // we do this check so that we dont send multiple notifications.
               if(recipients.get(new Integer(notifications[i].getCreatedBy())) == null)
               {
                  Account recipient = accountManager.getAccount(notifications[i].getCreatedBy());
                  AccountSettings settings = accountManager.getAccountSettings(recipient.getId());
   
                  recipients.put(new Integer(recipient.getId()), recipient);
               
                  //
                  // Transports...
                  //
                  
                  if(settings.getNotificationsEmail()) 
                  {
                     String subject = "Discussion Notification";
                     String emailAddr = accountManager.getAccountSettings(notifications[i].getCreatedBy()).getPrimaryEmailAddress();
                     if(emailAddr != null && emailAddr.length() > 0)
                     {
                        EmailTransporter emailTransporter = new EmailTransporter(subject, message.toString(), emailAddr);
                        emailTransporter.send();
                     }
                  }
                  if(settings.getNotificationsDesktopPager())
                  {
                     // TODO: Need to implement this!
                  }
                  if(settings.getNotificationsSystemMessage())
                  {
                     // TODO: Need to implement this!                  
                  }
               
               }
            }
            catch(Exception e)
            {
               DebugUtils.GI().logException(e);
               continue;
            }
         }// for
      }
      catch(Exception e)
      {
         
      }
   }
}
/*
 *
 * $Log: DiscussionNotificationProcessor.java,v $
 * Revision 1.3  2005/10/17 05:23:13  brian
 * Fixed typo.
 *
 * Revision 1.2  2005/03/26 19:23:59  brian
 * no message
 *
 *
 */