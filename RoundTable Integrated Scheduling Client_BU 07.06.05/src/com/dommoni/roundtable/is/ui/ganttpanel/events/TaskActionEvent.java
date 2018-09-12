package com.dommoni.roundtable.is.ui.ganttpanel.events;

import java.util.EventObject;

import com.dommoni.roundtable.is.ui.ganttpanel.GanttTask;

public class TaskActionEvent extends EventObject
{  
   public static final int TASK_ADDED = 1;
   public static final int TASK_DELETED = 2;
   public static final int TASK_MODIFIED = 3;
   public static final int TASK_SELECTED = 4;
   public static final int TASK_DESELECTED = 5;
   
   private int type;
   private long when;
   
   public TaskActionEvent(GanttTask task, int type)
   {
      super(task);
      
      this.type = type;
      this.when = System.currentTimeMillis();
   }
   
   public int getType()
   {
      return this.type;
   }
   
   public long getWhen()
   {
      return this.when;
   }
}
