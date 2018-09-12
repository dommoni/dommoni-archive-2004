/*
 * Created on Feb 19, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.logging;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.dommoni.roundtable.Session;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.utils.DebugUtils;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SessionLogger
{
   public void logOpenSession(Session session)
   {
      Connection connection = null;
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("insert into session_logs (" +
                  "session_id, " +
                  "account_id, " +
                  "type, " +
                  "start_time, " +
                  "remote_ip_address) values (?,?,?,?,?)");
         pstmt.setString(1, session.getSessionId());
         pstmt.setInt(2, session.getAccount().getId());
         pstmt.setInt(3, session.getType());
         pstmt.setTimestamp(4, new Timestamp(session.getStartTime().getTimeInMillis()));
         pstmt.setString(5, session.getRemoteIPAddress());
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
            e.printStackTrace();
         }
      }
   }
   
   public void logCloseSession(Session session)
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("update session_logs set end_time=? where session_id=?");
         pstmt.setTimestamp(1, new Timestamp(session.getEndTime().getTimeInMillis()));
         pstmt.setString(2, session.getSessionId());
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
/*
 * 
 * $Log: SessionLogger.java,v $
 * Revision 1.2  2005/03/26 19:25:03  brian
 * no message
 *
 * 
 */