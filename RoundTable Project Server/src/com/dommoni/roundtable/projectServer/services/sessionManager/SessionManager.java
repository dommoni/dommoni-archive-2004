/*
 * Created on Mar 17, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.sessionManager;

import java.util.Calendar;
import java.util.Collection;
import java.util.Enumeration;

import org.apache.axis.MessageContext;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.Session;
import com.dommoni.roundtable.exceptions.AccessDeniedException;
import com.dommoni.roundtable.exceptions.ContextNotFoundException;
import com.dommoni.roundtable.projectServer.ProjectServer;
import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.logging.SessionLogger;
import com.dommoni.roundtable.projectServer.services.accountManager.AccountManager;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.sessions.SessionGenerator;
import com.dommoni.roundtable.projectServer.sessions.SessionRegistry;
import com.dommoni.roundtable.projectServer.utils.DebugUtils;


/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class SessionManager implements ISessionManager
{
   SessionGenerator sessionGenerator = null;
   
   public SessionManager()
   {
   	  ProjectServer ps = ProjectServer.getInstance();
   	  synchronized(ps)
	  {
   	  	 this.sessionGenerator = ps.getSessionGenerator();
	  }
   	  
   	  if(sessionGenerator == null) // if this happens we're in trouble. let's make sure it doesnt.
   	  {
   	     sessionGenerator = new SessionGenerator();
   	  }
   }
   //public String getSession(Event event, String userName, String password, int type)
   public String getSession(String userName, String password, int type)
   throws Exception
   {
      IAccountManager accountManager = new AccountManager();
      Account account = accountManager.getAccountFromUsername(userName);
      if(account != null)
      {
         if(account.getPassword().equals(password))
         {
            String sessionId = generateSessionId(account);////event, account);
            
            Session session = new Session();
            session.setSessionId(sessionId);
            session.setAccount(account);
            session.setType(type);
            session.setStartTime(Calendar.getInstance());
            
            SessionRegistry.getInstance().put(sessionId, session);
            
            SessionLogger sessionLogger = new SessionLogger();
            sessionLogger.logOpenSession(session);
            
            return sessionId;    
         }
      }
      return null;
   }
   
   // Interface Implementation
   /*public String getSession(String userName, String password, int type)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   /*public String getSession(Event event, String userName, String password, int sessionType, String ipAddress)
   throws Exception
   {
      IAccountManager accountManager = new AccountManager();
      Account account = accountManager.getAccountFromUsername(userName);
      if(account != null)
      {
         if(account.getPassword().equals(password))
         {
            String sessionId = generateSessionId(event, account);
            
            Session session = new Session();
            session.setSessionId(sessionId);
            session.setAccount(account);
            session.setType(sessionType);
            session.setStartTime(Calendar.getInstance());
            session.setRemoteIPAddress(ipAddress);
            
            SessionRegistry.getInstance().put(sessionId, session);
            
            SessionLogger sessionLogger = new SessionLogger();
            sessionLogger.logOpenSession(session);
            
            return sessionId;    
         }
      }
      return null;
   }*/
   
   public String getSession(String userName, String password, int sessionType, String ipAddress)
   throws Exception
   {
      throw new ContextNotFoundException();
   }
   
   //public Account getAccountForSession(Event event, String sessionId)
   public Account getAccountForSession(String sessionId)
   throws Exception
   {
      Session session = (Session)SessionRegistry.getInstance().get(sessionId);
      if(session != null)
         return session.getAccount();
      return null;
   }
   
   /*public Account getAccountForSession(String sessionId)
   throws Exception
   {
      return this.getAccountForSession(null, sessionId);
   }*/
  
   //public void closeSession(Event event, String sessionId)
   public void closeSession(String sessionId)
   throws Exception
   {
      SessionRegistry sr = SessionRegistry.getInstance();
      Session removedSession = (Session)sr.remove(sessionId);
      
      SessionLogger sessionLogger = new SessionLogger();
      sessionLogger.logCloseSession(removedSession);
   }
   
   /*public void closeSession(String sessionId)
   throws Exception
   {
      this.closeSession(null, sessionId);
   }*/
   
   //public void setCurrentProjectForSession(Event event, String _sessionId, Project project)
   public void setCurrentProjectForSession(String _sessionId, Project project)
   throws Exception
   {
      DebugUtils.GI().printDbg("Entering SessionManager.setCurrentProjectForSession()");
      Session session = (Session)SessionRegistry.getInstance().get(_sessionId);
      DebugUtils.GI().printDbg("\tSessionObj: " + session);
      if(session != null)
      {
         DebugUtils.GI().printDbg("\tSessionID: " + session.getSessionId());;
         session.setCurrentProject(project);
      }
   }
   
   /*public void setCurrentProjectForSession(String _sessionId, Project project) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   //private String generateSessionId(Event event, Account account)
   private String generateSessionId(Account account)
   throws Exception
   {
      return sessionGenerator.generateSessionId();
   }
   
   /*private String generateSessionId(Account account) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   //public Session[] getActiveSessions(Event event)
   public Session[] getActiveSessions() 
   throws Exception
   {
      /*if(event != null)
      {
         System.out.println("SessionManager.getActiveSessions()... EVENT NOT NULL");
         
         AccountManager am = new AccountManager();
         Account user = am.getAccount(event, event.getInstigatorId());
         if(user.getAccountType() == AccountType.SYSTEM_ADMINISTRATOR)
         {*/
            SessionRegistry sr = SessionRegistry.getInstance();
            Collection values = sr.values();
            return (Session[])values.toArray(new Session[values.size()]);
         /*}
         else
         {
            throw new AccessDeniedException();
         }
      }
      else
      {
         System.out.println("SessionManager.getActiveSessions()... EVENT WAS NULL");
      }
      return null;*/
   }
   
   /*public Session[] getActiveSessions() throws Exception
   {
      throw new ContextNotFoundException();
   }*/
}
/*
 *
 * $Log: SessionManager.java,v $
 * Revision 1.2  2005/03/26 19:27:15  brian
 * no message
 *
 * Revision 1.1.1.1  2005/03/14 21:02:40  Brian Abbott
 * no message
 *
 *
 */