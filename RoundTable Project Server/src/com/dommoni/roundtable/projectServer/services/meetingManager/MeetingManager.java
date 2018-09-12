/*
 * $header$
 * 
 * @author $author$
 * @version CVS $revision$
 *
 * Originally Created on Mar 17, 2004
 *
 * Copyright (c) 2004 Dommoni Corporation. All Rights Reserved.
 * DOMMONI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.dommoni.roundtable.projectServer.services.meetingManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Vector;

import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.Meeting;
import com.dommoni.roundtable.MeetingAgendaItem;
import com.dommoni.roundtable.MeetingFolder;
import com.dommoni.roundtable.MeetingFollowupItem;
import com.dommoni.roundtable.exceptions.ContextNotFoundException;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.services.commentManager.CommentManager;

/**
 *  
 * @author Brian Abbott
 */
public class MeetingManager implements IMeetingManager
{
   /**
    * Creates a new Meeting under the current session/project contect.
    * 
    * @author Brian Abbott, brian@dommoni.com, Dommoni Corporation
    */
	//public int addMeeting(Event event, Meeting meeting)
   public int addMeeting(Meeting meeting)
   throws Exception
   {
      Connection connection = null;
      int meetingId = -1;
      
      if(meeting == null)
         return -1;
         
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("insert into meetings (project_id,title,start_time,end_time,meeting_notes,created_by,created_on) values (?,?,?,?,?,?,?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, meeting.getProjectId());
         pstmt.setString(2, meeting.getTitle());
         
         // start time
         if(meeting.getStartTime() != null)
         {   
            pstmt.setTimestamp(3, new Timestamp(meeting.getStartTime().getTimeInMillis()));
         }
         else
         {   
            pstmt.setDate(3, null);
         }
         
         // end time
         if(meeting.getEndTime() != null)
         {   
            pstmt.setTimestamp(4, new Timestamp(meeting.getEndTime().getTimeInMillis()));
         }
         else
         {   
            pstmt.setDate(4, null);
         }
           
         // TODO: Add meeting notes.
         pstmt.setString(5, null);//meeting.getMeetingNotes());
         pstmt.setInt(6, meeting.getCreatedBy());
         pstmt.setTimestamp(7, new Timestamp(Calendar.getInstance().getTimeInMillis()));
         
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from meetings", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         ResultSet rs = pstmt.executeQuery();
         meetingId = -1;
         if(rs.first())
         {
            meetingId = rs.getInt(1);
         
            //
            // Meeting Attendees...
            //
            if(meeting.getAttendees() != null && meeting.getAttendees().length > 0)
            {
            	int attendees[] = meeting.getAttendees();
            	pstmt = connection.prepareStatement("insert into meeting_attendees (meeting_id, account_id) values (?,?)");
            	for(int i = 0; i < attendees.length; i++)
            	{
                  pstmt.setInt(1, meetingId);
            		pstmt.setInt(2, attendees[i]);
            		pstmt.addBatch();
            	}
            	pstmt.executeBatch();
            }
         
            //
            // Agenda Items
            //
            if(meeting.getAgendaItems() != null && meeting.getAgendaItems().length > 0)
            {
               MeetingAgendaItem agendaItems[] = meeting.getAgendaItems();
               pstmt = connection.prepareStatement("insert into meeting_agenda_items (meeting_id, title, notes, ordinal) values (?,?,?,?)");
               // just leave notes null until we figure out how to present it.
               for(int i = 0; i < agendaItems.length; i++)
               {
                  pstmt.setInt(1, meetingId);
                  pstmt.setString(2, agendaItems[i].getTitle());
                  pstmt.setString(3, null);
                  pstmt.setInt(4, i);
                  
                  pstmt.addBatch();
               }
               pstmt.executeBatch();
            }
            
            //
            // Followup Items
            //
            if(meeting.getFollowupItems() != null && meeting.getFollowupItems().length > 0)
            {
               MeetingFollowupItem followupItems[] = meeting.getFollowupItems();
               pstmt = connection.prepareStatement("insert into meeting_followup_items (meeting_id, title, text, ordinal) values (?, ?, ?, ?)");
               
               for(int i = 0; i < followupItems.length; i++)
               {
                  pstmt.setInt(1, meetingId);
                  //pstmt.setString(2, followupItems[i]);
                  pstmt.setString(3, null);
                  pstmt.setInt(4, i);
                  
                  pstmt.addBatch();
               }
               pstmt.executeBatch();
            }
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
      	e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return meetingId;
   }

   /*public int addMeeting(Meeting meeting)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   /**
    * Convenience Wrapper for Adding a meeting without configuring the meeting object itself.
    * 
    * @author Brian Abbott, brian@dommoni.com, Dommoni Corporation
    */
   /*public int addMeeting(Event event, Meeting meeting, int projectId)
   throws Exception
   {
      if(meeting != null)
      {
         meeting.setProjectId(projectId);
         return addMeeting(meeting);
      }
      return -1;
   }*/

   /*public int addMeeting(Meeting meeting, int projectId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public void dropMeeting(Event event, int meetingId)
   public void dropMeeting(int meetingId)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
      	connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("delete from meetings where id=?");
         pstmt.setInt(1, meetingId);
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("delete from meeting_attendees where meeting_id=?");
         pstmt.setInt(1, meetingId);
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("delete from meeting_agenda_items where meeting_id=?");
         pstmt.setInt(1, meetingId);
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("delete from meeting_followup_items where meeting_id=?");         
         pstmt.setInt(1, meetingId);
         pstmt.executeUpdate();
         
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
      	try
      	{
      	   if(connection != null)
            {
      	      connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
   }

   /*public void dropMeeting(int meetingId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public void modifyMeeting(Event event, Meeting meeting)
   public void modifyMeeting(Meeting meeting)
   throws Exception
   {
      Connection connection = null;
      
      if(meeting == null)
         return;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("update meetings set title=?, start_time=?, end_time=?, meeting_notes=? where id=?");
         pstmt.setString(1, meeting.getTitle());
         
         if(meeting.getStartTime() != null)
         {
            pstmt.setTimestamp(2, new Timestamp(meeting.getStartTime().getTimeInMillis()));
         }
         
         if(meeting.getEndTime() != null)
         {
            pstmt.setTimestamp(3, new Timestamp(meeting.getEndTime().getTimeInMillis()));
         }
         // TODO: Modify meeting notes
         pstmt.setString(4, null);//meeting.getMeetingNotes());
         
         pstmt.executeUpdate();
         
         
         /*
          * meeting_attendees 
          * meeting_agenda_items 
          * meeting_followup_items
          * */
         
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
   }

   /*public void modifyMeeting(Meeting meeting)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public Meeting getMeeting(Event event, int meetingId)
   public Meeting getMeeting(int meetingId)
   throws Exception
   {
      Connection connection = null;
      Meeting meeting = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select project_id,title,start_time,end_time,meeting_notes,created_by,created_on from meetings where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, meetingId);
         
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            meeting = new Meeting();
            meeting.setId(meetingId);
            meeting.setProjectId(rs.getInt(1));
            meeting.setTitle(rs.getString(2));
            
            if(rs.getTimestamp("start_time") != null)
            {
               Calendar clStartTime = Calendar.getInstance();
               clStartTime.setTime(rs.getTimestamp("start_time"));
               meeting.setStartTime(clStartTime);
            }
            
            if(rs.getTimestamp("end_time") != null)
            {
               Calendar clEndTime = Calendar.getInstance();
               clEndTime.setTime(rs.getTimestamp("end_time"));
               meeting.setEndTime(clEndTime);
            }
            
            // TODO: Add meeting notes support.
            //meeting.setMeetingNotes(rs.getString(5));
            meeting.setCreatedBy(rs.getInt(6));
            if(rs.getTimestamp(7) != null)
            {
               Calendar clCreatedOn = Calendar.getInstance();
               clCreatedOn.setTime(rs.getTimestamp(7));
            	meeting.setCreatedOn(clCreatedOn);
            }
            
            //
            // Attendees
            //
            pstmt = connection.prepareStatement("select account_id from meeting_attendees where meeting_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, meeting.getId());
            ResultSet rsAttendees = pstmt.executeQuery();
            Vector vAttendees = new Vector();
            while(rsAttendees.next())
            {
               vAttendees.add(new Integer(rsAttendees.getInt(1)));
            }
            
            // dumb conversion... thanks Java
            int attendees[] = new int[vAttendees.size()];
            for(int i = 0; i < attendees.length; i++)
            {
               attendees[i] = ((Integer)vAttendees.get(i)).intValue();
            }
            meeting.setAttendees(attendees);
            
            //
            // Agenda Items
            //
            pstmt = connection.prepareStatement("select title,notes,ordinal from meeting_agenda_items where meeting_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, meeting.getId());
            ResultSet rsAgendaItems = pstmt.executeQuery();
            Vector agendaItems = new Vector();
            while(rsAgendaItems.next())
            {
               MeetingAgendaItem mai = new MeetingAgendaItem();
               mai.setTitle(rsAgendaItems.getString(1));
               mai.setNotes(rsAgendaItems.getString(2));
               mai.setOrdinal(rsAgendaItems.getInt(3));
               
               agendaItems.add(mai);
            }
            meeting.setAgendaItems((MeetingAgendaItem[])agendaItems.toArray(new MeetingAgendaItem[agendaItems.size()]));
            
            //
            // Followup Items
            //
            pstmt = connection.prepareStatement("select title,text,ordinal from meeting_followup_items where meeting_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setInt(1, meeting.getId());
            ResultSet rsFollowupItems = pstmt.executeQuery();
            Vector followupItems = new Vector();
            while(rsFollowupItems.next())
            {
               MeetingFollowupItem mfi = new MeetingFollowupItem();
               mfi.setTitle(rsFollowupItems.getString(1));
               mfi.setText(rsFollowupItems.getString(2));
               mfi.setOrdinal(rsFollowupItems.getInt(3));
               
               followupItems.add(mfi);
            }
            meeting.setFollowupItems((MeetingFollowupItem[])followupItems.toArray(new MeetingFollowupItem[followupItems.size()]));
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return meeting;
   }

   /*public Meeting getMeeting(int meetingId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   // remove all of these from the system... 
   // there should be nothing accessible outside of the project context
   public Meeting[] getAllMeetings()
   throws Exception
   {
      return null;
   }
   //public Meeting[] getAllMeetingsForProject(Event event, int projectId)
   public Meeting[] getAllMeetingsForProject(int projectId)
   throws Exception
   {
      Connection connection = null;
      Vector meetings = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id from meetings where project_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, projectId);
         
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            Meeting meeting = getMeeting(rs.getInt(1));//event, rs.getInt(1));
            if(meeting != null)
               meetings.add(meeting);
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return (Meeting[])meetings.toArray(new Meeting[meetings.size()]);
   }

   /*public Meeting[] getAllMeetingsForProject(int projectId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   public void addMeetingAgendaItem(MeetingAgendaItem meetingAgendaItem)
   throws Exception
   {
   }
   
   public void dropMeetingAgendaItem(int meetingAgendaItemId)
   throws Exception
   {
   }
   
   public void modifyMeetingAgendaItem(MeetingAgendaItem mai)
   throws Exception
   {
   }
   
   // not sure if we'll need these, i'll just leave them here for now.
   //getMeetingAgendaItem()
   //getAllMeetingAgendaItems()
   //getAllMeetingAgendaItemsForMeeting()
   //getAllMeetingAgendaItemsForProject()
   
   public void addMeetingFollowupItem(MeetingFollowupItem mfi)
   throws Exception
   {
   }
   
   public void addMeetingFolder(MeetingFolder meetingFolder)
   throws Exception
   {
   }
   //public int addCommentForMeeting(Event event, Meeting meeting, Comment comment)
   public int addCommentForMeeting(Meeting meeting, Comment comment)
   throws Exception
   {
      CommentManager commentManager = new CommentManager();
      return commentManager.addComment(meeting, comment);
   }
   
   /*public int addCommentForMeeting(Meeting meeting, Comment comment)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public Comment[] getCommentsForMeeting(Event event, Meeting meeting)
   public Comment[] getCommentsForMeeting(Meeting meeting)
   throws Exception
   {
      CommentManager commentManager = new CommentManager();
      return commentManager.getCommentsForObject(meeting);
   }
   
   /*public Comment[] getCommentsForMeeting(Meeting meeting)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/

}
/*
 * 
 * $Log: MeetingManager.java,v $
 * Revision 1.2  2005/03/26 19:26:39  brian
 * no message
 *
 * Revision 1.1.1.1  2005/03/14 21:02:40  Brian Abbott
 * no message
 *
 * 
 */
