/*
 * Created on Nov 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.recentChangesEngine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Notification;
import com.dommoni.roundtable.NotificationContext;
import com.dommoni.roundtable.NotificationContextObject;
import com.dommoni.roundtable.RecentChange;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.services.accountManager.AccountManager;
import com.dommoni.roundtable.projectServer.utils.DebugUtils;

/**
 * This class is resposible for receiving events and, from
 * those events, create recent-changes entries for that project.
 * @author Brian Abbott
 */
public class RecentChangesEngine
{
   public void receiveEvent(Event event)
   {  
      // filter out the RETRIEVAL Stuff...
      if((event.getOperationType() & Notification.RETRIEVAL_OPERATION) == 0)
      {
         try
         {
            RecentChange change = new RecentChange();
            change.setProjectId(event.getProjectId());
            change.setChangeMessage(getChangeMessageFromEvent(event));
            
            addRecentChange(change);
         }
         catch(Exception e)
         {
         	DebugUtils.GI().logException(e);
         }
      }
   }
   
   private void addRecentChange(RecentChange change)
   {
      // first, get all changes for project, if greater than 5, delete the oldest and add the newest.
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("insert into recentchanges (project_id,change_message,timestamp) values (?,?,?)");
         pstmt.setInt(1, change.getProjectId());
         pstmt.setString(2, change.getChangeMessage());
         
         if(change.getTimestamp() != null)
         {
            pstmt.setTimestamp(3, new Timestamp(change.getTimestamp().getTimeInMillis()));
         }
         else
         {
            pstmt.setTimestamp(3, new Timestamp(Calendar.getInstance().getTimeInMillis()));
         }
         
         pstmt.executeUpdate();
         
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
   }
   
   private String getChangeMessageFromEvent(Event event)
   throws Exception
   {
      StringBuffer changeMessage = new StringBuffer();
      
      //
      // Account Name
      //
      Account insAccount = new AccountManager().getAccount(event.getInstigatorId());//event, event.getInstigatorId());
      changeMessage.append(insAccount.getName() + " ");
      
      //
      // Operation
      //
      if(event.getOperationType() == Notification.CREATE_OPERATION)
      {
         changeMessage.append("created ");
      }
      else if(event.getOperationType() == Notification.DELETION_OPERATION)
      {
         changeMessage.append("deleted ");
      }
      else if(event.getOperationType() == Notification.MODIFICATION_OPERATION)
      {
         changeMessage.append("modified ");
      }
      else
      {
         throw new Exception("Unable to determine Operation Type. Operation Type was: " + event.getOperationType());
      }
      
      //
      // Context
      //
      if(event.getContext() != null && event.getContext().length() > 0)
         changeMessage.append(event.getContext().toLowerCase() + " ");
      
      //
      // Object Name
      //
      if(event.getObject() != null)
      {   
         System.out.println("NCO OBJECT TYPE: " + event.getObject().getClass().getName());
         
         NotificationContextObject nco = 
            (NotificationContextObject)event.getObject();
         
         changeMessage.append("\"" + nco.getName() + "\" ");
      }
      
      
      //
      // Timestamp
      //
      SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMMM d yyyy, hh:mm aaa");
      changeMessage.append("on " + sdf.format(event.getTimestamp().getTime()));
      
      return changeMessage.toString();
   }
}
/*
 *
 * $Log: RecentChangesEngine.java,v $
 * Revision 1.3  2005/10/17 05:33:06  brian
 * Added error handling.
 *
 *
 */