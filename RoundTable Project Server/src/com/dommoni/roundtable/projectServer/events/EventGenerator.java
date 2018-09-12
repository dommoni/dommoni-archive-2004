/*
 * Created on Sep 26, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.events;

import java.util.Calendar;

import com.dommoni.roundtable.Discussion;
import com.dommoni.roundtable.Document;
import com.dommoni.roundtable.Forum;
import com.dommoni.roundtable.Meeting;
import com.dommoni.roundtable.Notification;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.Session;
import com.dommoni.roundtable.Task;
import com.dommoni.roundtable.projectServer.notificationEngine.NotificationOperationRegistry;
import com.dommoni.roundtable.projectServer.services.discussionManager.DiscussionManager;
import com.dommoni.roundtable.projectServer.services.documentManager.DocumentManager;
import com.dommoni.roundtable.projectServer.services.forumManager.ForumManager;
import com.dommoni.roundtable.projectServer.services.meetingManager.MeetingManager;
import com.dommoni.roundtable.projectServer.services.scheduleManager.ScheduleManager;
import com.dommoni.roundtable.projectServer.services.taskManager.TaskManager;
import com.dommoni.roundtable.projectServer.utils.DebugUtils;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class EventGenerator
{
	/*
	 * System Events
	 *   - Who was it (userId)
	 *   - What project does it apply to (projectId)
	 *   - What did it to? (operation)
	 *   - what was it (object)
	 *   - When did it happen? (timestamp) 
	 * */

	public synchronized Event generateEvent(Session session, 
                              String serviceName, 
                              String operationName, 
                              Object obj[])
	{
      DebugUtils.GI().printDbg("Entering EventGenerator.generateEvent()");
      if (session == null)
		{
         DebugUtils.GI().printDbg("\tSession was null!");
         return null;
		}

      DebugUtils.GI().printDbg("\tCreating an Event.");
		Event evt = new Event();
      
      //
      // InstigatorId
      //
		evt.setInstigatorId(session.getAccount().getId());

		// 
      // ProjectId
      // need to be careful with the project, we might not always have one of these (and therefore, cannot create a valid event).
		//
      Project project = session.getCurrentProject();
      DebugUtils.GI().printDbg("\tSetting the CurrentProject for the Event: " + project);
		if (project != null)
		{
         evt.setProjectId(project.getId());
		}

      //
      // Context
      //
      String context = getContextFromServiceName(serviceName);
		evt.setContext(context);
      
      //
      // OperationType
      //
		if(evt.getContext() != null)
		{	
         int optype = getOperationTypeFromName(operationName, evt.getContext());
         DebugUtils.GI().printDbg("EVT-OPTYPE: " + optype);
         evt.setOperationType(optype);
      }
      
      evt.setOperationName(operationName);
      
      // were in a thread, better safe then sorry
      NotificationOperationRegistry nor = 
         new NotificationOperationRegistry();
      evt.setNotifiable(nor.contains(operationName));
      
      evt.setTimestamp(Calendar.getInstance());
      evt.setSession(session);
      
      if(obj.length > 0)
      {   
         evt.setObject(populateObject(obj[0], evt));
      }
      else
      {   
         evt.setObject(null);
      }
      
      DebugUtils.GI().printDbg("Returning Event: " + evt);
      
		return evt;
	}

	public String getContextFromServiceName(String serviceName)
	{
		String lcName = serviceName.toLowerCase();
		if (lcName.indexOf("document") != -1)
		{
			return "DOCUMENT";
		}
      else if (lcName.indexOf("forum") != -1)
      {
         return "FORUM";
      }
      else if (lcName.indexOf("task") != -1)
      {
         return "TASK";
      }
      else if (lcName.indexOf("meeting") != -1)
      {
         return "MEETING";
      }
      else if (lcName.indexOf("discussion") != -1)
      {
         return "DISCUSSION";
      }
      else if (lcName.indexOf("announcement") != -1)
      {
         return "ANNOUNCEMENT";
      }
      else if (lcName.indexOf("recentchange") != -1)
      {
         return "RECENTCHANGE";
      }
      else if (lcName.indexOf("schedule") != -1)
      {
         return "SCHEDULE";
      }
      else
      {
         DebugUtils.GI().printDbg("\n\nUNABLE TO DETERMINE OPERATION-CONTEXT: " + lcName + "!!!\n\n");
      }
      
		return null;
	}

	public int getOperationTypeFromName(String opName, String context)
	{
      if (opName.toLowerCase().startsWith("get" + context))
		{	
         return Notification.RETRIEVAL_OPERATION; 
      }
       
      // filter out the addComment events.
      if((opName.startsWith("add") && !opName.startsWith("addComment")) || opName.startsWith("create"))
      {   
         return Notification.CREATE_OPERATION;
      }
      
      if(opName.startsWith("drop"))
      {   
         return Notification.DELETION_OPERATION; 
      } 
      
      if(opName.startsWith("modify"))
      {   
         return Notification.MODIFICATION_OPERATION; 
      } 
         
		return -1;
	}
   
   private Object populateObject(Object obj, Event event) //throws EventObjectNotFoundException
   {
      // Objects we know how to handle:
      //    - discussion, document, forum, meeting, todo
      if(obj instanceof Discussion)
      {   
         return obj;
      }
      if(obj instanceof Document)
      {   
         return obj;
      }
      if(obj instanceof Forum)
      {   
         return obj;
      }
      if(obj instanceof Meeting)
      {   
         return obj;
      }
      if(obj instanceof Task)
      {   
         return obj;
      }
      if(obj instanceof Integer && event.getOperationType() == Notification.DELETION_OPERATION)
      {
         // deletions have an integer.. 
         if(event.getContext().equalsIgnoreCase("discussion"))
         {
            try
            {
               return new DiscussionManager().getDiscussion(((Integer)obj).intValue());//event, ((Integer)obj).intValue());
            }
            catch(Exception e)
            {  
               //e.printStackTrace();
               DebugUtils.GI().logException(e);
            }
         }
         if(event.getContext().equalsIgnoreCase("document"))
         {
            try
            {
               return new DocumentManager().getDocumentShallow(((Integer)obj).intValue());//event, ((Integer)obj).intValue());
            }
            catch(Exception e) 
            {
            	DebugUtils.GI().logException(e);
            }
         }
         if(event.getContext().equalsIgnoreCase("forum"))
         {
            try
            {
               return new ForumManager().getForum(((Integer)obj).intValue());//event, ((Integer)obj).intValue());
            }
            catch(Exception e)
            {
            	DebugUtils.GI().logException(e);
            }
         }
         if(event.getContext().equalsIgnoreCase("meeting"))
         {
            try
            {
               return new MeetingManager().getMeeting(((Integer)obj).intValue());//event, ((Integer)obj).intValue());
            }
            catch(Exception e) 
            {
            	DebugUtils.GI().logException(e);
            }
         }
         if(event.getContext().equalsIgnoreCase("task"))
         {
            try
            {
               return new TaskManager().getTask(((Integer)obj).intValue());//event, ((Integer)obj).intValue());
            }
            catch(Exception e) 
            {
            	DebugUtils.GI().logException(e);
            }
         }
         if(event.getContext().equalsIgnoreCase("schedule"))
         {
            try
            {
               return new ScheduleManager().getSchedule(((Integer)obj).intValue());
            }
            catch(Exception e) 
            {
               DebugUtils.GI().logException(e);
            }
         }
      }
      
      // unable to determine what it is, just return what we recieved...
      return obj;
   }
}
/*
 * 
 * $Log: EventGenerator.java,v $
 * Revision 1.3  2005/10/17 04:22:31  brian
 * Added support for Scheduling.
 *
 * Revision 1.2  2005/03/26 19:24:55  brian
 * no message
 *
 * 
 */