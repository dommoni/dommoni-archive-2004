/*
 * Created on May 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable;

import java.util.Calendar;

/**
 * There might be other things we want to do with discussions on 
 * the project server side. 
 * 
 * @author Brian Abbott
 */
public class Discussion extends NotificationContextObject implements Cloneable
{
   private int id;
   private int projectId;
   private String title;
   private Calendar date;
   private int memberIds[];
   private DiscussionMessage messages[];
   
   public int getId()
   {
      return this.id;
   }
   
   public void setId(int _id)
   {
      this.id = _id;
   }
   
   public int getProjectId()
   {
      return this.projectId;
   }
   
   public void setProjectId(int _projectId)
   {
      this.projectId = _projectId;
   }
   
   public String getTitle()
   {
      return this.title;
   }
   
   // for NCO
   public String getName()
   {
      return this.getTitle();
   }
   
   public void setTitle(String _title)
   {
      this.title = _title;
   }
   
   public Calendar getDate()
   {
      return this.date;
   }
   
   public void setDate(Calendar _date)
   {
      this.date = _date;
   }
   
   public int[] getMemberIds()
   {
      return this.memberIds;
   }
   
   public void setMemberIds(int _memberIds[])
   {
      this.memberIds = _memberIds;
   }
   
   public DiscussionMessage[] getMessages()
   {
      return this.messages;
   }
   
   public void setMessages(DiscussionMessage _messages[])
   {
      this.messages = _messages;
   }
   
   public Object clone()
   {
      Discussion clone = new Discussion();
      clone.setId(this.id);
      clone.setProjectId(this.projectId);
      clone.setTitle(this.title);
      clone.setDate(this.date);
      clone.setMemberIds(this.memberIds);
      clone.setMessages(this.messages);
      return clone;
   }
}
/*
 * 
 * $Log: Discussion.java,v $
 * Revision 1.2  2005/03/23 09:07:50  brian
 * Added footer.
 *
 * 
 */