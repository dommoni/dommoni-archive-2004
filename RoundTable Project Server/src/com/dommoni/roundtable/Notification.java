/*
 * Created on Mar 24, 2004
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
public class Notification
{
   //
   // Notification Operations
   //
   public static final int CREATE_OPERATION = 0x01;
   public static final int MODIFICATION_OPERATION = 0x02;
   public static final int DELETION_OPERATION = 0x04;
   public static final int RETRIEVAL_OPERATION = 0x08; // not implemented for now (This might be overly invasive?).
   public static final int ANY_OPERATION = 
      CREATE_OPERATION | MODIFICATION_OPERATION | DELETION_OPERATION | RETRIEVAL_OPERATION;
   
   private int id;
   private int projectId;
   private String name;
   private String context; // {Account, Blog, Document, Meeting, etc}
   private int createdBy;
   private Calendar createdOn;
   
   /**
    * Type of notification.
    *  
    * 
    * @see NotificationType Class
    */
   private int type; 
   
   /**
    * Operation code. Where operation is one of:
    *    - Notification.CREATE_OPERATION
    *    - Notification.MODIFICATION_OPERATION
    *    - Notification.DELETION_OPERATION
    *    - Notification.RETREIVAL_OPERATION // not implemented.
    *    - Notification.ANY_OPERATION
    */
   private int operation;
   
   // Special parameters
   private int userIds[]; // only applies if attached to a user
   private int objectIds[]; // only applies if user selects a certain object.
   
   public int getId()
   {
      return this.id;
   }
   
   public void setId(int _id)
   {
      this.id = _id;
   }
   
   public int getProjectId()
   {
      return this.projectId;
   }
   
   public void setProjectId(int _projectId)
   {
      this.projectId = _projectId;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public void setName(String _name)
   {
      this.name = _name;
   }
   
   public String getContext()
   {
      return this.context;
   }
   
   public void setContext(String _context)
   {
      this.context = _context;
   }
   
   public int getCreatedBy()
   {
      return this.createdBy;
   }
   
   public void setCreatedBy(int _createdBy)
   {
      this.createdBy = _createdBy;
   }
   
   public Calendar getCreatedOn()
   {
      return this.createdOn;
   }
   
   public void setCreatedOn(Calendar _createdOn)
   {
      this.createdOn = _createdOn;
   }
   
   public int getType()
   {
      return this.type;
   }
   
   public void setType(int _type)
   {
      this.type = _type;
   }
   
   public int getOperation()
   {
      return this.operation;
   }
   
   public void setOperation(int _operation)
   {
      this.operation = _operation;
   }
   
   public int[] getUserIds()
   {
      return this.userIds;
   }
   
   public void setUserIds(int _userIds[])
   {
      this.userIds = _userIds;
   }
   
   public int[] getObjectIds()
   {
      return this.objectIds;
   }
   
   public void setObjectIds(int _objectIds[])
   {
      this.objectIds = _objectIds;
   }
}
/*
 * 
 * $Log: Notification.java,v $
 * Revision 1.1.1.1  2005/03/14 21:02:38  Brian Abbott
 * no message
 *
 * 
 */