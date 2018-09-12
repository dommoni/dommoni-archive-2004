/*
 * Created on Apr 29, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.notificationEngine;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NotificationMessage
{
   public static final int SYSTEM_MESSAGE = 1;
   public static final int DESKTOPPAGER_MESSAGE = 2;
   public static final int EMAIL_MESSAGE = 3;
   
   private int recipientAccountId;
   private int messageType;
   private String message;
   
   public int getRecipientAccountId()
   {
      return this.recipientAccountId;
   }
   
   public void setRecipinetAccountId(int _recipientAccountId)
   {
      this.recipientAccountId = _recipientAccountId;
   }
   
   public int getMessageType()
   {
      return this.messageType;
   }
   
   public void setMessageType(int _messageType)
   {
      this.messageType = _messageType;
   }
   
   public String getMessage()
   {
      return this.message;
   }
   
   public void setMessage(String _message)
   {
      this.message = _message;
   }
}
/*
 * 
 * $Log: NotificationMessage.java,v $
 * Revision 1.2  2005/03/26 19:25:11  brian
 * no message
 *
 * 
 */