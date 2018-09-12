package com.dommoni.roundtable;

import java.util.Calendar;

public class Schedule extends NotificationContextObject implements Cloneable
{
   /**
    * Schedule can be read and written to by all project
    * members.
    */
   public static final int MODE_READWRITE = 1;
   
   /**
    * Schedule can be read by all, users can only edit
    * the tasks they own with the exception of the 
    * schedules owner, who has full control.
    */
   public static final int MODE_READ_RESTRICTREDWRITE = 2;
   
   /**
    * Project Members only have Read-Access, the schedule
    * owner still has full editing control over all schedule
    * items.
    */
   public static final int MODE_READONLY = 3;
   
   private int id;
   private String name;
   private int projectId;
   private int createdBy;
   private Calendar createdOn;
   private int accessMode;
   private Calendar scheduleStartDate;
   private Calendar scheduleEndDate;
   private ScheduleItem[] scheduleItems;
   private Comment[] comments;
   
   public int getId() 
   {
      return this.id;
   }
   
   public void setId(int id) 
   {
      this.id = id;
   }
   
   public String getName() 
   {
      return this.name;
   }
   
   public void setName(String name) 
   {
      this.name = name;
   }
   
   public int getProjectId() 
   {
      return this.projectId;
   }
   
   public void setProjectId(int projectId) 
   {
      this.projectId = projectId;
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
   
   public int getAccessMode() 
   {
      return this.accessMode;
   }
   
   public void setAccessMode(int accessMode) 
   {
      this.accessMode = accessMode;
   }
   
   public Calendar getScheduleStartDate()
   {
      return this.scheduleStartDate;
   }
   
   public void setScheduleStartDate(Calendar scheduleStartDate)
   {
      this.scheduleStartDate = scheduleStartDate;
   }
   
   public Calendar getScheduleEndDate()
   {
      return this.scheduleEndDate;
   }
   
   public void setScheduleEndDate(Calendar scheduleEndDate)
   {
      this.scheduleEndDate = scheduleEndDate;
   }
   
   public ScheduleItem[] getScheduleItems() 
   {
      return this.scheduleItems;
   }
   
   public void setScheduleItems(ScheduleItem[] scheduleItems) 
   {
      this.scheduleItems = scheduleItems;
   }
   
   public Comment[] getComments()
   {
      return this.comments;
   }
   
   public void setComments(Comment[] comments)
   {
      this.comments = comments;
   }
   
   // Standard Overrides...
   
   public String toString()
   {
      return this.name;
   }
   
   public boolean equals(Object obj)
   {
      if (obj instanceof Schedule)
      {
         if (((Schedule)obj).getId() == this.id)
         {   
            return true;
         }
      }
      return false;
   }
   
   public Object clone()
   {
      Schedule clone = new Schedule();
      
      clone.setId(this.id);
      clone.setName(new String(this.name));
      clone.setProjectId(this.projectId);
      clone.setCreatedBy(this.createdBy);
      clone.setCreatedOn((Calendar)this.createdOn.clone());
      clone.setAccessMode(this.accessMode);
      clone.setScheduleStartDate((Calendar)this.scheduleStartDate.clone());
      clone.setScheduleEndDate((Calendar)this.scheduleEndDate.clone());
      
      // TODO: Were only creating a 'partial clone' at the moment, need to update the following sections to call the .clone() methods on scheduleItems and comments.
      if (this.scheduleItems != null)
      {
         ScheduleItem[] clonedSis = new ScheduleItem[scheduleItems.length];
         for (int i = 0; i < this.scheduleItems.length; i++)
         {
            clonedSis[i] = (ScheduleItem)this.scheduleItems[i];//.clone();
         }
         clone.setScheduleItems(clonedSis);
      }
      else
      {
         clone.setScheduleItems(null);
      }
      
      if (this.comments != null)
      {
         Comment[] clonedComments = new Comment[this.comments.length];
         for (int i = 0; i < this.comments.length; i++)
         {
            clonedComments[i] = (Comment)this.comments[i];//.clone();
         }
         clone.setComments(clonedComments);
      }
      else
      {
         clone.setComments(null);
      }
      
      return clone;
   }
}
