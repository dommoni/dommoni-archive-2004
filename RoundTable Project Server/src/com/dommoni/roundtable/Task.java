package com.dommoni.roundtable;

import java.util.Calendar;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Task extends NotificationContextObject
{  
   private int id;
   private int projectId;
   private String title;
   private int createdBy;
   private Calendar createdOn;
   private String description;
   private Calendar startDate;
   private Calendar dueDate;
   private int flag;
   private int percentComplete;
   private boolean isPublic;
   private TaskStatus currentStatus;
   private Calendar lastModified;
   private int assignedTo;
   private TaskReminder reminder;
   
   private CustomField[] customFields;
   private NamedFieldCollection[] namedFieldCollections;
   
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
   
   public int getCreatedBy()
   {
      return this.createdBy;
   }
   
   public void setCreatedBy(int _createdBy)
   {
      this.createdBy = _createdBy;
   }
   
   public Calendar getCreatedOn()
   {
      return this.createdOn;
   }
   
   public void setCreatedOn(Calendar _createdOn)
   {
      this.createdOn = _createdOn;
   }
   
   public String getDescription()
   {
      return this.description;
   }
   
   public void setDescription(String _description)
   {
      this.description = _description;
   }
   
   public Calendar getStartDate()
   {
      return this.startDate;
   }
   
   public void setStartDate(Calendar _startDate)
   {
      this.startDate = _startDate;
   }
   
   public Calendar getDueDate()
   {
      return this.dueDate;
   }
   
   public void setDueDate(Calendar _dueDate)
   {
      this.dueDate = _dueDate;
   }
   
   public int getFlag()
   {
      return this.flag;
   }
   
   public void setFlag(int _flag)
   {
      this.flag = _flag;
   }
   
   public int getPercentComplete()
   {
      return this.percentComplete;
   }
   
   public void setPercentComplete(int _percentComplete)
   {
      this.percentComplete = _percentComplete;
   }
   
   public boolean getIsPublic()
   {
      return this.isPublic;
   }
   
   public void setIsPublic(boolean _isPublic)
   {
      this.isPublic = _isPublic;
   }
   
   public TaskStatus getCurrentStatus()
   {
      return this.currentStatus;
   }
   
   public void setCurrentStatus(TaskStatus currentStatus)
   {
      this.currentStatus = currentStatus;
   }
   
   public Calendar getLastModified()
   {
      return this.lastModified;
   }
   
   public void setLastModified(Calendar _lastModified)
   {
      this.lastModified = _lastModified;
   }
   
   public int getAssignedTo()
   {
      return this.assignedTo;
   }
   
   public void setAssignedTo(int _assignedTo)
   {
      this.assignedTo = _assignedTo;
   }
   
   public TaskReminder getTaskReminder()
   {
      return this.reminder;
   }
   
   public void setTaskReminder(TaskReminder _reminder)
   {
      this.reminder = _reminder;
   }
   
   public CustomField[] getCustomFields()
   {
      return this.customFields;
   }
   
   public void setCustomFields(CustomField[] _customFields)
   {
      this.customFields = _customFields;
   }
   
   public NamedFieldCollection[] getNamedFieldCollections()
   {
      return this.namedFieldCollections;
   }
   
   public void setNamedFieldCollections(NamedFieldCollection[] _namedFieldCollections)
   {
      this.namedFieldCollections = _namedFieldCollections;
   }
}
/*
 * 
 * $Log: ToDo.java,v $
 * Revision 1.2  2005/03/26 19:17:47  brian
 * Added footer.
 *
 * 
 */