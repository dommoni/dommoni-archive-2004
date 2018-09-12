/*
 * Created on May 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable;

import java.util.Calendar;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DiscussionMessage
{
   private int id;
   private int accountId;
   private Calendar timestamp;
   private String messageText;
   
   public int getId()
   {
      return this.id;
   }
   
   public void setId(int _id)
   {
      this.id = _id;
   }
   
   public int getAccountId()
   {
      return this.accountId;
   }
   
   public void setAccountId(int _accountId)
   {
      this.accountId = _accountId;
   }
   
   public Calendar getTimestamp()
   {
      return this.timestamp;
   }
   
   public void setTimestamp(Calendar _timestamp)
   {
      this.timestamp = _timestamp;
   }
   
   public String getMessageText()
   {
      return this.messageText;
   }
   
   public void setMessageText(String _messageText)
   {
      this.messageText = _messageText;
   }
}
/*
 * 
 * $Log: DiscussionMessage.java,v $
 * Revision 1.2  2005/03/26 19:01:22  brian
 * Added footer.
 *
 * 
 */