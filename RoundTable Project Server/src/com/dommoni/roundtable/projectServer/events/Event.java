/*
 * Created on Sep 26, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.events;

import java.util.Calendar;

import com.dommoni.roundtable.Session;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class Event
{
   /**
    * The Account ID for the user who is 
    * responsible for having generated the event.
    */
   private int instigatorId;
   
   /**
    * Project for which this event is associated with.
    */
   private int projectId;
   
   private String context;
   private int operationType;
   private String operationName;
   private Object object;
   private Calendar timestamp;
   
   /**
    * Weather or not a notification can be generated for this event.
    */
   private boolean notifiable;
   
   /**
    * The session that's responsible for creating this event.
    */
   private Session session;
   
   
   public int getInstigatorId()
   {
      return this.instigatorId;
   }
   
   public void setInstigatorId(int _instigatorId)
   {
      this.instigatorId = _instigatorId;
   }
   
   public int getProjectId()
   {
      return this.projectId;
   }
   
   public void setProjectId(int _projectId)
   {
      this.projectId = _projectId;
   }
   
   public String getContext()
   {
      return this.context;
   }
   
   public void setContext(String _context)
   {
      this.context = _context;
   }
   
   public int getOperationType()
   {
      return this.operationType;
   }
   
   public void setOperationType(int _operationType)
   {
      this.operationType = _operationType;
   }
   
   public String getOperationName()
   {
      return this.operationName;
   }
   
   public void setOperationName(String operationName)
   {
      this.operationName = operationName;
   }
   
   public Object getObject()
   {
      return this.object;
   }
   
   public void setObject(Object _object)
   {
      this.object = _object;
   }
   
   public Calendar getTimestamp()
   {
      return this.timestamp;
   }
   
   public void setTimestamp(Calendar _timestamp)
   {
      this.timestamp = _timestamp;
   }
   
   public boolean isNotifiable()
   {
      return getNotifiable();
   }
   
   public boolean getNotifiable()
   {
      return this.notifiable;
   }
   
   public void setNotifiable(boolean _notifiable)
   {
      this.notifiable = _notifiable;
   }
   
   public Session getSession() 
   {
      return this.session;
   }
   
   public void setSession(Session session)
   {
      this.session = session;
   }
}
/*
 * 
 * $Log: Event.java,v $
 * Revision 1.2  2005/03/26 19:24:55  brian
 * no message
 *
 * 
 */