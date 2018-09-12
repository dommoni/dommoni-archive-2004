/*
 * IMeetingManager.cs
 * 
 * Created on Mar 17, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;

namespace RoundTable.ProjectServer.Services.MeetingManager
{
	/// <summary>
	/// Summary description for IMeetingManager.
	/// </summary>
	public interface IMeetingManager
	{
		int addMeeting(Meeting meeting);
   
		void dropMeeting(int meetingId);
   
		void modifyMeeting(Meeting meeting);
   
		Meeting getMeeting(int meetingId);
   
		Meeting[] getAllMeetings();
   
		Meeting[] getAllMeetingsForProject(int projectId);
   
		// Comment Convenience Methods
		int addCommentForMeeting(Meeting meeting, Comment comment);
   
		Comment[] getCommentsForMeeting(Meeting meeting);
	}
}
/*
 * 
 * $Log: IMeetingManager.cs,v $
 * Revision 1.1  2005/03/20 15:49:26  brian
 * Initial Revision.
 *
 * 
 */
