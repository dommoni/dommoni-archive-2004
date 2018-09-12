/*
 * Created on Sep 29, 2004
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
import com.dommoni.roundtable.Document;
import com.dommoni.roundtable.Notification;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.notificationEngine.transporters.EmailTransporter;
import com.dommoni.roundtable.projectServer.services.accountManager.AccountManager;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.utils.DebugUtils;

/**
 * Processors and transporters...
 * 
 * The processor should:
 *   - Generate the Object Specific Message.
 *   - Call the transporter and pass it transporter-specific parameters such as A subject-title for email
 * 
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DocumentNotificationProcessor extends NotificationProcessor
{
   public DocumentNotificationProcessor(Event event, Notification notifications[])
   {
      super(event, notifications);
   }
   
   public void run()
   {
      try
      {
         DebugUtils.GI().printDbg("Running Document Notification processor");
         
         if(event == null)
         {
         	DebugUtils.GI().printDbg("Event was null, major error, need ot let someone know.");
            return;
         }
         
         StringBuffer message = new StringBuffer();
         message.append("Document Notification:\n\n");
         
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
         Document document;
         if(event.getObject() instanceof Document)
            document = (Document)event.getObject();
         else
            return;
            
         SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMMM d yyyy, hh:mm aaa");
         message.append("document " + document.getName() + " on " + sdf.format(Calendar.getInstance().getTime()));
         
         DebugUtils.GI().printDbg("Document Processor, sending: " + message.toString());
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
                     String subject = "Document Notification";
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
 * $Log: DocumentNotificationProcessor.java,v $
 * Revision 1.3  2005/10/17 05:23:21  brian
 * Fixed typo.
 *
 * Revision 1.2  2005/03/26 19:24:11  brian
 * no message
 *
 * Revision 1.1.1.1  2005/03/14 21:02:40  Brian Abbott
 * no message
 *
 * 
 */
