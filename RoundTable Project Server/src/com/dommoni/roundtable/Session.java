/*
 * Created on Apr 16, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable;

import java.util.Calendar;


/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Session
{
   private String sessionId = null;
   private Account account = null;
   private int type; 
   private Calendar startTime = null;
   private Calendar endTime = null;
   private Calendar lastActivityTime;
   private String remoteIPAddress = null;
   
   /**
    * Identifies which project this 
    * session is in.
    */
   private Project currentProject;
   
   public String getSessionId()
   {
      return this.sessionId;
   }
   
   public void setSessionId(String _sessionId)
   {
      this.sessionId = _sessionId;
   }
   
   public Account getAccount()
   {
      return this.account;
   }
   
   public void setAccount(Account _account)
   {
      this.account = _account;
   }
   
   public int getType()
   {
      return this.type;
   }
   
   public void setType(int _type)
   {
      this.type = _type;
   }
   
   public Calendar getStartTime()
   {
      return this.startTime;
   }
   
   public void setStartTime(Calendar _startTime)
   {
      this.startTime = _startTime;
   }
   
   public Calendar getEndTime()
   {
      return this.endTime;
   }
   
   public void setEndTime(Calendar _endTime)
   {
      this.endTime = _endTime;
   }
   
   public Calendar getLastActivityTime()
   {
      return this.lastActivityTime;
   }
   
   public void setLastActivityTime(Calendar lastActivityTime)
   {
      this.lastActivityTime = lastActivityTime;
   }
   
   public Project getCurrentProject()
   {
      return this.currentProject;
   }
   
   public void setCurrentProject(Project _currentProject)
   {
      this.currentProject = _currentProject;
   }
   
   public String getRemoteIPAddress()
   {
      return this.remoteIPAddress;
   }
   
   public void setRemoteIPAddress(String remoteIPAddress)
   {
      this.remoteIPAddress = remoteIPAddress;
   }
   
   public void touch()
   {
      lastActivityTime = Calendar.getInstance();   
   }
   
   public String toString()
   {
      if(sessionId != null)
      {   
         return this.sessionId; 
      } 
      else
      {   
         return super.toString(); 
      } 
   }
}
/*
 * 
 * $Log: Session.java,v $
 * Revision 1.2  2005/03/26 19:17:26  brian
 * Added footer.
 *
 * 
 */