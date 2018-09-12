/*
 * Created on Feb 20, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.services.logging.sessionlogManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.dommoni.roundtable.logging.SessionLogEntry;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SessionLogManager
{
   public SessionLogEntry getSessionLogEntry(int id)
   {
      Connection connection = null;
      SessionLogEntry sle = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("select session_id, account_id, type, start_time, end_time, remote_ip_address from session_logs where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, id);
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            sle = new SessionLogEntry();
            sle.setId(id);
            sle.setSessionId(rs.getString("session_id"));
            sle.setAccountId(rs.getInt("account_id"));
            sle.setType(rs.getInt("type"));
            
            if(rs.getTimestamp("start_time") != null)
            {
               Calendar clStartTime = Calendar.getInstance();
               clStartTime.setTimeInMillis(rs.getTimestamp("start_time").getTime());
               sle.setStartTime(clStartTime);
            }
            
            if(rs.getTimestamp("end_time") != null)
            {
               Calendar clEndTime = Calendar.getInstance();
               clEndTime.setTimeInMillis(rs.getTimestamp("end_time").getTime());
               sle.setEndTime(clEndTime);
            }
            
            sle.setRemoteIpAddress(rs.getString("remote_ip_address"));
         }
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
      
      return sle;
   }
   
   public SessionLogEntry getSessionLogEntry(String sessionId)
   {
      return null;
   }
  
}
