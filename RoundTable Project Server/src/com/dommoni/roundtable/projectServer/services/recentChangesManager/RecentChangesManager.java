/*
 * Created on Nov 7, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.recentChangesManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import com.dommoni.roundtable.RecentChange;
import com.dommoni.roundtable.exceptions.ContextNotFoundException;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.events.Event;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class RecentChangesManager implements IRecentChangesManager
{
	//public RecentChange[] getRecentChangesForProject(Event event, int projectId)
   public RecentChange[] getRecentChangesForProject(int projectId)
   throws Exception
   {
   	Connection connection = null;
      Vector recentChanges = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id,project_id,change_message,timestamp from recentchanges where project_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, projectId);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            RecentChange rc = new RecentChange();
            rc.setId(rs.getInt("id"));
            rc.setProjectId(rs.getInt("project_id"));
            rc.setChangeMessage(rs.getString("change_message"));
            
            if(rs.getTimestamp("timestamp") != null)
            {
               Calendar clTimestamp = Calendar.getInstance();
               clTimestamp.setTimeInMillis(rs.getTimestamp("timestamp").getTime());
               rc.setTimestamp(clTimestamp);
            }
            
            recentChanges.add(rc);
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
      
      return (RecentChange[])recentChanges.toArray(new RecentChange[recentChanges.size()]);
   }
   
   /*public RecentChange[] getRecentChangesForProject(int projectId) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
}
