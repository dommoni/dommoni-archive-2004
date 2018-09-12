/*
 * Created on Feb 13, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.services.logging.eventlogManager;

import com.dommoni.roundtable.logging.EventLogEntry;
import com.dommoni.roundtable.projectServer.events.Event;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface IEventLogManager
{
   public EventLogEntry[] getEventLogsForAccount(int accountId)
   throws Exception;
   
   public EventLogEntry[] getEventLogsForProject(int projectId)
   throws Exception;
   
   /**
    * An example of the Event Log query string is as follows
    * QueryString - "users=(ids),projects=(ids),period=(from,to)"
    * 
    * Here is an example in code:
    * <code>
    * String queryString = "users=(1,2,3);projects=(1,4,12);period=(11/1/2004,1/1/2005);";
    * 
    * IEventLogManager elm = projectServerConnection.getEventLogManager();
    * EventLog[] eventLogs = elm.getEventLogsFromQueryString(queryString);
    * </code>
    * 
    * @param queryString
    * @return
    * @throws Exception
    */
   public EventLogEntry[] getEventLogsFromQueryString(String queryString)
   throws Exception;

   public EventLogEntry[] getAllEventLogs()
   throws Exception;
}
