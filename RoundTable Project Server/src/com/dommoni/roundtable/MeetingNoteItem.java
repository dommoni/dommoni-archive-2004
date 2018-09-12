/*
 * Created on Jan 15, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable;

import java.util.Calendar;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class MeetingNoteItem
{
   private int id;
   private int meetingId;
   private int createdBy;
   private Calendar createdOn;
   private String title;
   private String description;
   private BinaryAttachment[] attachments;
   
   public int getId() 
   {
      return this.id;
   }
   
   public void setId(int id) 
   {
      this.id = id;
   }
   
   public int getMeetingId() 
   {
      return this.meetingId;
   }
   
   public void setMeetingId(int meetingId) 
   {
      this.meetingId = meetingId;
   }
   
   public int getCreatedBy() 
   {
      return this.createdBy;
   }
   
   public void setCreatedBy(int createdBy) 
   {
      this.createdBy = createdBy;
   }
   
   public Calendar getCreatedOn() 
   {
      return this.createdOn;
   }
   
   public void setCreatedOn(Calendar createdOn) 
   {
      this.createdOn = createdOn;
   }
   
   public String getTitle() 
   {
      return this.title;
   }
   
   public void setTitle(String title) 
   {
      this.title = title;
   }
   
   public String getDescription() 
   {
      return this.description;
   }
   
   public void setDescription(String description) 
   {
      this.description = description;
   }
   
   public BinaryAttachment[] getAttachments() 
   {
      return this.attachments;
   }
   
   public void setAttachments(BinaryAttachment[] attachments) 
   {
      this.attachments = attachments;
   } 
}
/*
 * 
 * $Log: MeetingNoteItem.java,v $
 * Revision 1.2  2005/03/26 19:03:12  brian
 * Added footer.
 *
 * 
 */