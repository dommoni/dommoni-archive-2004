package com.dommoni.roundtable.projectServer.services.scheduleManager;

import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.Document;
import com.dommoni.roundtable.Schedule;
import com.dommoni.roundtable.ScheduleItem;

public interface IScheduleManager
{
   public int addSchedule(Schedule schedule)
   throws Exception;
   
   public void dropSchedule(int scheduleId)
   throws Exception;
   
   public void modifySchedule(Schedule schedule)
   throws Exception;
   
   public Schedule getSchedule(int scheduleId)
   throws Exception;
   
   public Schedule[] getAllSchedulesForProject(int projectId)
   throws Exception;
   
   //
   // Comments Convenience Methods
   //
   public int addCommentForSchedule(Schedule schedule, Comment comment)
   throws Exception;
   
   public Comment[] getCommentsForSchedule(Schedule schedule)
   throws Exception;
   
   public int addCommentForScheduleItem(ScheduleItem scheduleItem, Comment comment)
   throws Exception;
   
   public Comment[] getCommentsForScheduleItem(ScheduleItem scheduleItem)
   throws Exception;
}
/*
 *
 * $Log$
 *
 */