/*
 * Created on Mar 17, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable;

import java.util.Calendar;

/**
 * @author Brian Abbott
 *
 * The idea of a meeting in the system is more for historical purposes
 * than notification and member management although we should probably
 * support that as well. However, I am aprehensive to do this as MS Outlook
 * already has that capability.
 */
public class Meeting extends NotificationContextObject implements Cloneable
{
   private int id;
   private int projectId;
   private String title;
   private String description;
   private Calendar startTime; 
   private Calendar endTime;
   private int attendees[];
   private boolean sendInvitation;

   private int createdBy;
   private Calendar createdOn;
   
   private MeetingAgendaItem[] agendaItems;
   private MeetingNoteItem[] meetingNotes;
   private MeetingFollowupItem[] followupItems;
   
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
   
   public String getDescription()
   {
      return this.description;
   }
   
   public void setDescription(String description)
   {
      this.description = description;
   }
   
   public Calendar getStartTime()
   {
      return this.startTime;
   }
   
   public void setStartTime(Calendar _startTime)
   {
      this.startTime = _startTime;
   }
   
   public Calendar getEndTime()
   {
      return this.endTime;
   }
   
   public void setEndTime(Calendar _endTime)
   {
      this.endTime = _endTime;
   }
   
   public int[] getAttendees()
   {
      return this.attendees;
   }
   
   public void setAttendees(int _attendees[])
   {
      this.attendees = _attendees;
   }
   
   public boolean getSendInvitation()
   {
      return this.sendInvitation;
   }
   
   public void setSendInvitation(boolean _sendInvitation)
   {
      this.sendInvitation = _sendInvitation;
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
   
   public MeetingAgendaItem[] getAgendaItems()
   {
      return this.agendaItems;
   }
   
   public void setAgendaItems(MeetingAgendaItem _agendaItems[])
   {
      this.agendaItems = _agendaItems;
   }
   
   public MeetingNoteItem[] getMeetingNotes()
   {
      return this.meetingNotes;
   }
   
   public void setMeetingNotes(MeetingNoteItem[] _meetingNotes)
   {
      this.meetingNotes = _meetingNotes;
   }
   
   public MeetingFollowupItem[] getFollowupItems()
   {
      return this.followupItems;
   }
   
   public void setFollowupItems(MeetingFollowupItem _followupItems[])
   {
      this.followupItems = _followupItems;
   }
   
   public String toString()
   {
      if(title != null)
      {   
         return this.title; 
      } 
      else
      {   
         return super.toString(); 
      } 
   }
}
/*
 * 
 * $Log: Meeting.java,v $
 * Revision 1.2  2005/03/26 19:02:31  brian
 * Added footer.
 *
 * 
 */