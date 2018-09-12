/*
 * Created on Jul 11, 2004
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
public class ForumReply implements Cloneable
{
   private int id;
   private int forumId;
   private String reply;
   private int accountId;
   private Calendar timestamp;
   
   public int getId()
   {
      return this.id;
   }
   
   public void setId(int _id)
   {
      this.id = _id;
   }
   
   public int getForumId()
   {
      return this.forumId;
   }
   
   public void setForumId(int _forumId)
   {
      this.forumId = _forumId;
   }
   
   public String getReply()
   {
      return this.reply;
   }
   
   public void setReply(String _reply)
   {
      this.reply = _reply;
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
   
   public Object clone()
   {
      ForumReply clone = new ForumReply();
      clone.setId(this.id);
      clone.setForumId(this.forumId);
      clone.setReply(this.reply);
      clone.setAccountId(this.accountId);
      clone.setTimestamp(this.timestamp);
      
      return clone;
   }
}
/*
 * 
 * $Log: ForumReply.java,v $
 * Revision 1.2  2005/03/26 19:02:00  brian
 * Added footer.
 *
 * 
 */