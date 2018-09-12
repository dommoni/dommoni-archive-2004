/*
 * Created on Apr 27, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.notificationEngine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import com.dommoni.roundtable.Notification;
import com.dommoni.roundtable.Session;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.notificationEngine.processors.DiscussionNotificationProcessor;
import com.dommoni.roundtable.projectServer.notificationEngine.processors.DocumentNotificationProcessor;
import com.dommoni.roundtable.projectServer.notificationEngine.processors.ForumNotificationProcessor;
import com.dommoni.roundtable.projectServer.notificationEngine.processors.MeetingNotificationProcessor;
import com.dommoni.roundtable.projectServer.notificationEngine.processors.NotificationProcessor;
import com.dommoni.roundtable.projectServer.notificationEngine.processors.NotificationProcessorNotFoundException;
import com.dommoni.roundtable.projectServer.notificationEngine.processors.ScheduleNotificationProcessor;
import com.dommoni.roundtable.projectServer.notificationEngine.processors.TaskNotificationProcessor;
import com.dommoni.roundtable.projectServer.utils.DebugUtils;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NotificationEngine
{
   public void receiveEvent(Event event) 
      throws NotificationProcessorNotFoundException
   {
      if(event == null)
         return;
         
      Notification notifications[] = getNotificationsForEvent(event);
      List processedList = new Vector();
      
      for(int i = 0; i < notifications.length; i++)
      {
         Notification no = notifications[i];
         //if(no.getType() == NotificationType.USER)
         //{
            // not yet implemented  
        // }
         //else if(no.getType() == NotificationType.OBJECT)
        // {
         //   if(event.getOperationType() == no.getOperation() || no.getOperation() == Notification.ANY_OPERATION)
         //   { 
             if(no.getCreatedBy() != event.getInstigatorId())  
                processedList.add(no); 
          //  } 
         //}
      }
      
      
      Notification notifs[] = (Notification[])processedList.toArray(new Notification[processedList.size()]);
      NotificationProcessor processor = getProcessorForContext(event, notifs);
      if(processor != null)
      {   
         processor.start(); 
      } 
      else
      {   
         throw new NotificationProcessorNotFoundException("Unable to locate a valid processor for notification context: " + event.getContext(), notifs, event); 
      } 
   }
   
   public Notification[] getNotificationsForEvent(Event event)
   {
      Connection connection = null;
      List vNotifications = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id, project_id, name, context, created_by, created_on, type from notifications where project_id=? and context=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, event.getProjectId());
         pstmt.setString(2, event.getContext());
         ResultSet rs = pstmt.executeQuery();
         
         while(rs.next())
         {
            Notification no = new Notification();
            no.setId(rs.getInt("id"));
            no.setProjectId(rs.getInt("project_id"));
            // no.setName() not used.
            no.setContext(rs.getString("context"));
            no.setCreatedBy(rs.getInt("created_by"));
            
            Calendar clCreatedOn = Calendar.getInstance();
            clCreatedOn.setTimeInMillis(rs.getTimestamp("created_on").getTime());
            no.setCreatedOn(clCreatedOn);
            no.setType(rs.getInt("type"));
            
            vNotifications.add(no);
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
      	DebugUtils.GI().logException(se);
      }
      catch(Exception e)
      {
      	  DebugUtils.GI().logException(e);
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
         	DebugUtils.GI().logException(e);
         }
      }
      
      return (Notification[])vNotifications.toArray(new Notification[vNotifications.size()]);
   }
   
   private NotificationProcessor getProcessorForContext(Event event, Notification notifications[])
   {  
      if(event.getContext().equalsIgnoreCase("document"))
      {   
         return new DocumentNotificationProcessor(event, notifications); 
      }
      if(event.getContext().equalsIgnoreCase("forum"))
      { 
         return new ForumNotificationProcessor(event, notifications);
      }
      if(event.getContext().equalsIgnoreCase("task"))
      {
         return new TaskNotificationProcessor(event, notifications);
      }
      if(event.getContext().equalsIgnoreCase("meeting"))
      {
         return new MeetingNotificationProcessor(event, notifications);
      }
      if(event.getContext().equalsIgnoreCase("discussion"))
      {
         return new DiscussionNotificationProcessor(event, notifications);
      }
      if(event.getContext().equalsIgnoreCase("schedule"))
      {
         return new ScheduleNotificationProcessor(event, notifications);
      }
      return null;
   }
}
/*
 * 
 * $Log: NotificationEngine.java,v $
 * Revision 1.3  2005/10/17 05:13:19  brian
 * API renaming from todos to tasks and added sheduling support.
 *
 * Revision 1.2  2005/03/26 19:25:11  brian
 * no message
 *
 * 
 */