/*
 * Created on Feb 13, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.services.logging.eventlogManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.dommoni.roundtable.exceptions.ContextNotFoundException;
import com.dommoni.roundtable.logging.EventLogEntry;
import com.dommoni.roundtable.logging.SessionLogEntry;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.services.logging.sessionlogManager.SessionLogManager;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EventLogManager implements IEventLogManager
{
	//public EventLogEntry[] getEventLogsForAccount(Event event, int accountId)
   public EventLogEntry[] getEventLogsForAccount(int accountId)
   throws Exception
   {
      return null;
   }
   
   /*public EventLogEntry[] getEventLogsForAccount(int accountId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public EventLogEntry[] getEventLogsForProject(Event event, int projectId)
   public EventLogEntry[] getEventLogsForProject(int projectId)
   throws Exception
   {
      return null;
   }
   
   /*public EventLogEntry[] getEventLogsForProject(int projectId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/

   //public EventLogEntry[] getEventLogsFromQueryString(Event event, String queryString)
   public EventLogEntry[] getEventLogsFromQueryString(String queryString)
   throws Exception
   {
      int[] userIds = null;
      int[] projectIds = null;
      Date periodFrom = null;
      Date periodTo = null;
      
      List eventLogs = new Vector();
      
      // parse the query string and from that build a DB Query.
      //users=(1,2,3);projects=(1,4,12);period=(11/1/2004,1/1/2005);
      String queryParams[] = queryString.split(";");
      for(int i = 0; i < queryParams.length; i++)
      {
         if(queryParams[i].startsWith("users"))
         {
            try
            {
               String usersCommand = queryParams[i];
               String subCmd = usersCommand.substring(usersCommand.indexOf("(") + 1,usersCommand.indexOf(")"));
               String[] numbers = subCmd.split(",");
               
               userIds = new int[numbers.length];
               for(int j = 0; j < userIds.length; j++)
                  userIds[j] = Integer.parseInt(numbers[j]);
            }
            catch(Exception e)
            {
               e.printStackTrace();
            }
         }
         if(queryParams[i].startsWith("projects"))
         {
            String projectsCommand = queryParams[i];
            String subCmd = projectsCommand.substring(projectsCommand.indexOf("(") + 1,projectsCommand.indexOf(")"));
            String[] numbers = subCmd.split(",");
            
            projectIds = new int[numbers.length];
            for(int j = 0; j < projectIds.length; j++)
               projectIds[j] = Integer.parseInt(numbers[j]);
         }
         if(queryParams[i].startsWith("period"))
         {
            String periodCommand = queryParams[i];
            String subCmd = periodCommand.substring(periodCommand.indexOf("(") + 1, periodCommand.indexOf(")"));
         
            String pf = subCmd.split(",")[0];
            String pt = subCmd.split(",")[1];
            
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            periodFrom = sdf.parse(pf);
            periodTo = sdf.parse(pt);
         }
      }
      
      // build and run the query
      
      StringBuffer sbQuery = new StringBuffer();
      sbQuery.append("select " +
            "id," +
            "session_id," +
            "instigator_id," +
            "project_id," +
            "context," +
            "operation_type," +
            "operation_name," +
            "timestamp " +
            "from event_logs ");
      boolean appendedContraintClause = false;
      
      // userIds
      if(userIds != null && userIds.length > 0)
      {
         if(!appendedContraintClause)
         {
            sbQuery.append("where ");
            appendedContraintClause = true;
         }
         
         for(int i = 0; i < userIds.length; i++)
         {
            sbQuery.append("instigator_id=" + userIds[i]);
            if(i < userIds.length - 1)
               sbQuery.append(" or ");
         }
      }
      
      // projectIds
      if(projectIds != null && projectIds.length > 0)
      {
         if(!appendedContraintClause)
         {
            sbQuery.append("where ");
            appendedContraintClause = true;
         }
         else
         {
            sbQuery.append(" and ");
         }
         
         for(int i = 0; i < projectIds.length; i++)
         {
            sbQuery.append("project_id=" + projectIds[i]);
            if(i < projectIds.length - 1)
               sbQuery.append(" or ");
         }
      }
      
      // period
      if(periodFrom != null && periodTo != null)
      {
         if(!appendedContraintClause)
         {
            sbQuery.append("where ");
            appendedContraintClause = true;
         }
         else
         {
            sbQuery.append(" and ");
         }
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         sbQuery.append("timestamp > '" + sdf.format(periodFrom) + "'");
         sbQuery.append(" and timestamp < '" + sdf.format(periodTo) + "'");
      }
      
      //System.out.println("\n\nEXECUTING LOG-QUERY: " + sbQuery.toString() + "\n\n");
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         ResultSet rs = stmt.executeQuery(sbQuery.toString());
         while(rs.next())
         {
            EventLogEntry ele = new EventLogEntry();
            ele.setId(rs.getInt("id"));
            
            SessionLogManager slm = new SessionLogManager();
            SessionLogEntry sle = slm.getSessionLogEntry(rs.getInt("session_id"));
            if(sle != null)
               ele.setSessionId(sle.getSessionId());
            
            ele.setAccountId(rs.getInt("instigator_id"));
            ele.setProjectId(rs.getInt("project_id"));
            ele.setContext(rs.getString("context"));
            ele.setOperationType(rs.getInt("operation_type"));
            ele.setOperationName(rs.getString("operation_name"));
            
            if(rs.getTimestamp("timestamp") != null)
            {
               Calendar clTimestamp = Calendar.getInstance();
               clTimestamp.setTimeInMillis(rs.getTimestamp("timestamp").getTime());
               ele.setTimestamp(clTimestamp);
            }
            
            eventLogs.add(ele);
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
      
      return (EventLogEntry[])eventLogs.toArray(new EventLogEntry[eventLogs.size()]);
   }
  
   /*public EventLogEntry[] getEventLogsFromQueryString(String queryString)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   //public EventLogEntry[] getAllEventLogs(Event event)
   public EventLogEntry[] getAllEventLogs()
   throws Exception
   {
      return null;
   }
   
   /*public EventLogEntry[] getAllEventLogs()
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
}
/*
 * 
 * $Log: EventLogManager.java,v $
 * Revision 1.3  2005/10/17 07:42:01  brian
 * Removed print statements.
 *
 * 
 */
