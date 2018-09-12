package com.dommoni.roundtable.projectServer.notificationEngine.processors;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountSettings;
import com.dommoni.roundtable.Document;
import com.dommoni.roundtable.Notification;
import com.dommoni.roundtable.Schedule;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.notificationEngine.transporters.EmailTransporter;
import com.dommoni.roundtable.projectServer.services.accountManager.AccountManager;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.utils.DebugUtils;

public class ScheduleNotificationProcessor extends NotificationProcessor
{
   public ScheduleNotificationProcessor(Event event, Notification notifications[])
   {
      super(event, notifications);
   }
   
   public void run()
   {
      try
      {
         DebugUtils.GI().printDbg("Running Schedule Notification processor");
         
         if(event == null)
         {
            DebugUtils.GI().printDbg("Event was null, major error, need ot let someone know.");
            return;
         }
         
         StringBuffer message = new StringBuffer();
         message.append("Schedule Notification:\n\n");
         
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
         else
         {
            // we where unable to determine the optype...
            return;
         }
         
         // should always be a document but, better safe then sorry.
         Schedule schedule;
         if(event.getObject() instanceof Schedule)
            schedule = (Schedule)event.getObject();
         else
            return;
            
         SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMMM d yyyy, hh:mm aaa");
         message.append("schedule " + schedule.getName() + " on " + sdf.format(Calendar.getInstance().getTime()));
         
         DebugUtils.GI().printDbg("Schedule Processor, sending: " + message.toString());
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
                  
                  // do transports...
                  if(settings.getNotificationsEmail()) 
                  {
                     String subject = "Schedule Notification";
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
 * $Log: ScheduleNotificationProcessor.java,v $
 * Revision 1.1  2005/10/17 05:15:59  brian
 * Initial Revision.
 *
 * 
 */
