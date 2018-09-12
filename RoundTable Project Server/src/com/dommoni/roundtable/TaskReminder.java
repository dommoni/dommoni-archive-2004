/*
 * Created on Apr 22, 2005
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
public class TaskReminder
{
   private int id;
   private int taskId;
   private Calendar reminderTime;
   private int[] recipients;
   
   public int getId()
   {
      return this.id;
   }
   
   public void setId(int _id)
   {
      this.id = _id;
   }
   
   public int getTaskId()
   {
      return this.taskId;
   }
   
   public void setTaskId(int _taskId)
   {
      this.taskId = _taskId;
   }
   
   public Calendar getReminderTime()
   {
      return this.reminderTime;
   }
   
   public void setReminderTime(Calendar _reminderTime)
   {
      this.reminderTime = _reminderTime;
   }
   
   public int[] getRecipients()
   {
      return this.recipients;
   }
   
   public void setRecipients(int[] _recipients)
   {
      this.recipients = _recipients;
   }
}
/*
 * 
 * $Log$
 * 
 */
