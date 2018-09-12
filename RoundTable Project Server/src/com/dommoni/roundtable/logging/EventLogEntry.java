/*
 * Created on Feb 20, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.logging;

import java.util.Calendar;

import com.dommoni.roundtable.Session;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EventLogEntry
{
   private int id;
   private String sessionId;
   private int accountId;
   private int projectId;
   private String context;
   private int operationType;
   private String operationName;
   private String logMessage;
   private Calendar timestamp;

   public int getId() {return this.id;}
   public void setId(int id) {this.id = id;}
   
   public String getSessionId() {return this.sessionId;}
   public void setSessionId(String sessionId) {this.sessionId = sessionId;}
   
   public int getAccountId() {return this.accountId;}
   public void setAccountId(int accountId) {this.accountId = accountId;}
   
   public int getProjectId() {return this.projectId;}
   public void setProjectId(int projectId) {this.projectId = projectId;}
   
   public String getContext() {return this.context;}
   public void setContext(String context) {this.context = context;}
   
   public int getOperationType() {return this.operationType;}
   public void setOperationType(int operationType) {this.operationType = operationType;}
   
   public String getOperationName() {return this.operationName;}
   public void setOperationName(String operationName) {this.operationName = operationName;}
   
   public String getLogMessage() {return this.logMessage;}
   public void setLogMessage(String logMessage) {this.logMessage = logMessage;}
   
   public Calendar getTimestamp() {return this.timestamp;}
   public void setTimestamp(Calendar timestamp) {this.timestamp = timestamp;}
}
/*
 * 
 * $Log: EventLogEntry.java,v $
 * Revision 1.2  2005/03/23 08:46:45  brian
 * Added footer.
 *
 * 
 */
