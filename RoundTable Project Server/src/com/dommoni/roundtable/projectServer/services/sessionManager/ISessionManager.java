/*
 * Created on Mar 18, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.sessionManager;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.Session;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface ISessionManager
{
   public String getSession(String userName, String password, int sessionType)
   throws Exception;
   
   public String getSession(String userName, String password, int sessionType, String ipAddress)
   throws Exception;
   
   public Account getAccountForSession(String sessionId)
   throws Exception;
   
   public void closeSession(String sessionId)
   throws Exception;
   
   public void setCurrentProjectForSession(String sessionId, Project currentProject)
   throws Exception;
   
   public Session[] getActiveSessions()
   throws Exception;
}
