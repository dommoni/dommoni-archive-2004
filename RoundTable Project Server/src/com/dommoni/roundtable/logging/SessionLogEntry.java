/*
 * Created on Feb 20, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.logging;

import java.util.Calendar;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SessionLogEntry
{
   private int id;
   private String sessionId;
   private int accountId;
   private int type;
   private Calendar startTime;
   private Calendar endTime;
   private String remoteIpAddress;
   
   public int getId() {return this.id;}
   public void setId(int id) {this.id = id;}
   
   public String getSessionId() {return this.sessionId;}
   public void setSessionId(String sessionId) {this.sessionId = this.sessionId;}
   
   public int getAccountId() {return this.accountId;}
   public void setAccountId(int accountId) {this.accountId = accountId;}
   
   public int getType() {return this.type;}
   public void setType(int type) {this.type = type;}
   
   public Calendar getStartTime() {return this.startTime;}
   public void setStartTime(Calendar startTime) {this.startTime = startTime;}
   
   public Calendar getEndTime() {return this.endTime;}
   public void setEndTime(Calendar endTime) {this.endTime = endTime;}
   
   public String getRemoteIpAddress() {return this.remoteIpAddress;}
   public void setRemoteIpAddress(String remoteIpAddress) {this.remoteIpAddress = remoteIpAddress;}
}
/*
 * 
 * $Log: SessionLogEntry.java,v $
 * Revision 1.2  2005/03/23 08:47:00  brian
 * Added footer.
 *
 * 
 */