package com.dommoni.roundtable;

import java.util.Calendar;

public class ScheduleItem
{
   private int id;
   private String title;
   private int createdBy;
   private Calendar createdOn;
   private Calendar startDate;
   private Calendar endDate;
   private float duration;
   private int percentComplete;
   private int priority;
   private Account[] resources;
   private String description;
   private int ordinal;
   private Comment[] comments;
   
   public int getId() 
   {
      return this.id;
   }
   
   public void setId(int id) 
   {
      this.id = id;
   }
   
   public String getTitle() 
   {
      return this.title;
   }
   
   public void setTitle(String title) 
   {
      this.title = title;
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
   
   public Calendar getStartDate() 
   {
      return this.startDate;
   }
   
   public void setStartDate(Calendar startDate) 
   {
      this.startDate = startDate;
   }
   
   public Calendar getEndDate() 
   {
      return this.endDate;
   }
   
   public void setEndDate(Calendar endDate) 
   {
      this.endDate = endDate;
   }
   
   public float getDuration() 
   {
      return this.duration;
   }
   
   public void setDuration(float duration) 
   {
      this.duration = duration;
   }
   
   public int getPercentComplete() 
   {
      return this.percentComplete;
   }
   
   public void setPercentComplete(int percentComplete) 
   {
      this.percentComplete = percentComplete;
   }
   
   public int getPriority() 
   {
      return this.priority;
   }
   
   public void setPriority(int priority) 
   {
      this.priority = priority;
   }
   
   public Account[] getResources() 
   {
      return this.resources;
   }
   
   public void setResources(Account[] resources) 
   {
      this.resources = resources;
   }
   
   public String getDescription() 
   {
      return this.description;
   }
   
   public void setDescription(String description) 
   {
      this.description = description;
   }
   
   public int getOrdinal()
   {
      return this.ordinal;
   }
   
   public void setOrdinal(int ordinal)
   {
      this.ordinal = ordinal;
   }
   
   public Comment[] getComments() 
   {
      return this.comments;
   }
   
   public void setComments(Comment[] comments) 
   {
      this.comments = comments;
   }
}
