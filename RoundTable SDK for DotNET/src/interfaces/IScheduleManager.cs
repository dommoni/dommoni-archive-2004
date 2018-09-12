using System;

namespace RoundTable.ProjectServer.Services.ScheduleManager
{
	/// <summary>
	/// Summary description for IScheduleManager.
	/// </summary>
	public interface IScheduleManager
	{
		int addSchedule(Schedule schedule);
   
		void dropSchedule(int scheduleId);
   
		void modifySchedule(Schedule schedule);
   
		Schedule getSchedule(int scheduleId);
   
		Schedule[] getAllSchedulesForProject(int projectId);
   
		//
		// Comments Convenience Methods
		//
		int addCommentForSchedule(Schedule schedule, Comment comment);
   
		Comment[] getCommentsForSchedule(Schedule schedule);
   
		int addCommentForScheduleItem(ScheduleItem scheduleItem, Comment comment);
   
		Comment[] getCommentsForScheduleItem(ScheduleItem scheduleItem);
	}
}
