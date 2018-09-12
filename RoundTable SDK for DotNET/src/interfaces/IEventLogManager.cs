/*
 * IEventLogManager.cs
 * 
 * Created on Mar 17, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;

namespace RoundTable.ProjectServer.Services.Logging.EventLogManager
{
	/// <summary>
	/// Summary description for IEventLogManager.
	/// </summary>
	public interface IEventLogManager
	{
		EventLogEntry[] getEventLogsForAccount(int accountId);
   
		EventLogEntry[] getEventLogsForProject(int projectId);
   
		/// <summary>
		/// An example of the Event Log query string is as follows.
		/// 
		/// The format of the string is summarized as:
		/// QueryString - "users=(ids),projects=(ids),period=(from,to)"
		///  
		/// Here is an example in code:
		/// <code>
		/// String queryString = "users=(1,2,3);projects=(1,4,12);period=(11/1/2004,1/1/2005);";
		///  
		/// IEventLogManager elm = projectServerConnection.getEventLogManager();
		/// EventLog[] eventLogs = elm.getEventLogsFromQueryString(queryString);
		/// </code>
		EventLogEntry[] getEventLogsFromQueryString(String queryString);

		EventLogEntry[] getAllEventLogs();
	}
}
/*
 * 
 * $Log: IEventLogManager.cs,v $
 * Revision 1.1  2005/03/20 15:49:26  brian
 * Initial Revision.
 *
 * 
 */
