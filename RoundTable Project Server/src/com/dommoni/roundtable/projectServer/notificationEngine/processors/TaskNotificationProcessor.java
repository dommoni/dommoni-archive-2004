
/*
 * Created on Apr 29, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.notificationEngine.processors;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountSettings;
import com.dommoni.roundtable.Notification;
import com.dommoni.roundtable.Task;
import com.dommoni.roundtable.projectServer.services.accountManager.AccountManager;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.utils.DebugUtils;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.notificationEngine.NotificationMessage;
import com.dommoni.roundtable.projectServer.notificationEngine.NotificationMessageTransporter;
import com.dommoni.roundtable.projectServer.notificationEngine.transporters.EmailTransporter;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TaskNotificationProcessor extends NotificationProcessor
{
   public TaskNotificationProcessor(Event event, Notification notifications[])
   {
      super(event, notifications);
   }
   
   public void run()
   {
      try
      {
      	DebugUtils.GI().printDbg("Running ToDoNotification processor");
         
         if(event == null)
         {
         	DebugUtils.GI().printDbg("Event was null, major error, need ot let someone know.");
            return;
         }
   
         StringBuffer message = new StringBuffer();
         message.append("ToDo Notification:\n\n");
   
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
         Task todo;
         if(event.getObject() instanceof Task)
            todo = (Task)event.getObject();
         else
            return;
      
         SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMMM d yyyy, hh:mm aaa");
         message.append("todo " + todo.getName() + " on " + sdf.format(Calendar.getInstance().getTime()));
   
         System.out.println("ToDo Processor, sending: " + message.toString());
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
                     String subject = "ToDo Notification";
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
 * $Log: TaskNotificationProcessor.java,v $
 * Revision 1.1  2005/10/17 05:14:25  brian
 * Renamed from TodoNotification Processor.
 *
 * Revision 1.2  2005/03/26 19:24:12  brian
 * no message
 *
 * Revision 1.1.1.1  2005/03/14 21:02:40  Brian Abbott
 * no message
 *
 * 
 */
