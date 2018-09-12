/*
 * Created on May 2, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.notificationEngine.transporters;

import com.dommoni.roundtable.Message;
import com.dommoni.roundtable.projectServer.services.messageManager.IMessageManager;
import com.dommoni.roundtable.projectServer.services.messageManager.MessageManager;
import com.dommoni.roundtable.projectServer.utils.DebugUtils;
import com.dommoni.roundtable.projectServer.notificationEngine.NotificationMessage;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SystemMessageTransporter
{
   NotificationMessage message;
   
   public SystemMessageTransporter(NotificationMessage message)
   {
      this.message = message;
   }
   
   public void transport()
   {
   	DebugUtils.GI().printDbg("Entering SystemMessageTransporter.transport()...");
      IMessageManager messageManager = new MessageManager();
      Message msg = new Message();
      msg.setToId(message.getRecipientAccountId());
      msg.setType(Message.NOTIFICATION_MESSAGE);
      msg.setText(message.getMessage());
      
      // todo: need to figure out some way to notify the WebUI of this while
      // the session is active... I guess, the fact that the main page
      // will refresh... and, the footers could check for it... it'd be cool
      // to be able to have a dialog popup when one's recieved... 
      messageManager.addMessage(msg);
   }
}
