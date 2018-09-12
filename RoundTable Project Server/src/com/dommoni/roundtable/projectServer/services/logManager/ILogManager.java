/*
 * Created on Sep 14, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.logManager;

import com.dommoni.roundtable.LogEntry;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface ILogManager
{
   /**
    * Deletes an individual Entry in the Application Log.
    * 
    * @param id
    */
   public void dropLogEntry(int id);
   
   public LogEntry[] getAllLogEntriesForUser();
   
   public LogEntry[] getAllLogEntriesForProject();
   
   public LogEntry[] getAllLogEntriesForService();
   
   public LogEntry[] getAllLogEntriesForSystem(); // admin privs req'd
}
