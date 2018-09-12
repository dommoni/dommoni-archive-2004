/*
 * Created on May 2, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.messageManager;

import com.dommoni.roundtable.Message;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface IMessageManager
{
   public void addMessage(Message message);
   
   public void dropMessage(int messageId);
   
   public void modifyMessage(Message message);
   
   public Message getMessage(int messageId);
   
   public Message[] getAllMessagesToAccount(int accountId);
   
   public Message[] getAllMessagesFromAccount(int accountId);
}
