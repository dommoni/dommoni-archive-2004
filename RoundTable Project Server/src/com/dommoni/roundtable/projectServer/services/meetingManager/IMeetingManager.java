/*
 * Created on Mar 17, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.meetingManager;

import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.Document;
import com.dommoni.roundtable.Meeting;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface IMeetingManager
{
   public int addMeeting(Meeting meeting)
   throws Exception;
   
   public void dropMeeting(int meetingId)
   throws Exception;
   
   public void modifyMeeting(Meeting meeting)
   throws Exception;
   
   public Meeting getMeeting(int meetingId)
   throws Exception;
   
   public Meeting[] getAllMeetings()
   throws Exception;
   
   public Meeting[] getAllMeetingsForProject(int projectId)
   throws Exception;
   
   // Comment Convenience Methods
   public int addCommentForMeeting(Meeting meeting, Comment comment)
   throws Exception;
   
   //public void dropCommentForMeeting(Meeting meeting, Comment comment);
   
   public Comment[] getCommentsForMeeting(Meeting meeting)
   throws Exception;
}
