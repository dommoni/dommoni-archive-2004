/*
 * ISessionManager.cs
 * 
 * Created on Mar 17, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;

namespace RoundTable.ProjectServer.Services.SessionManager
{
	/// <summary>
	/// Summary description for ISessionManager.
	/// </summary>
	public interface ISessionManager
	{
		String getSession(string userName, string password, int sessionType);
   
		String getSession(string userName, string password, int sessionType, string ipAddress);
   
		Account getAccountForSession(string sessionId);
   
		void closeSession(string sessionId);
   
		void setCurrentProjectForSession(string sessionId, Project currentProject);
   
		Session[] getActiveSessions();
	}
}
/*
 * 
 * $Log: ISessionManager.cs,v $
 * Revision 1.1  2005/03/20 15:49:27  brian
 * Initial Revision.
 *
 * 
 */
