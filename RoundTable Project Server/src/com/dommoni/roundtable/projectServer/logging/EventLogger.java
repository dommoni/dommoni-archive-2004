/*
 * Created on Nov 5, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.logging;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Session;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.utils.DebugUtils;

/**
 * This class takes an event and, from that, creates an human readable/application level log entry.
 * @author Brian Abbott
 */
public class EventLogger
{
   public void receiveEvent(Event event)
   {
      if(event != null)
         logEvent2DB(event);
   }
   
   private void logEvent2DB(Event event)
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("insert into event_logs (" +
                  "instigator_id, " +
                  "project_id, " +
                  "context, " +
                  "operation_type, " +
                  "operation_name, " +
                  "timestamp) " +
                  "values (?,?,?,?,?,?)");
         pstmt.setInt(1, event.getInstigatorId());
         pstmt.setInt(2, event.getProjectId());
         pstmt.setString(3, event.getContext());
         pstmt.setInt(4, event.getOperationType());
         pstmt.setString(5, event.getOperationName());
         pstmt.setTimestamp(6, new Timestamp(event.getTimestamp().getTimeInMillis()));
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
}
