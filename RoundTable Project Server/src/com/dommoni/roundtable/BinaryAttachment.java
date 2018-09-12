/*
 * Created on Jan 15, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable;

import java.util.Calendar;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BinaryAttachment
{
   private int id;
   private int projectId;
   private int createdBy;
   private Calendar createdOn;
   private int objectId;
   private String objectContext;
   private byte[] attachment;
   private String notes;
   private String name;
   
   /**
    * @return Returns the id.
    */
   public int getId()
   {
      return id;
   }
   
   /**
    * @param id The id to set.
    */
   public void setId(int id)
   {
      this.id = id;
   }
   
   /**
    * @return Returns the projectId.
    */
   public int getProjectId()
   {
      return projectId;
   }
   
   /**
    * @param projectId The projectId to set.
    */
   public void setProjectId(int projectId)
   {
      this.projectId = projectId;
   }
   
   /**
    * @return Returns the createdBy.
    */
   public int getCreatedBy()
   {
      return createdBy;
   }
   
   /**
    * @param createdBy The createdBy to set.
    */
   public void setCreatedBy(int createdBy)
   {
      this.createdBy = createdBy;
   }
   
   /**
    * @return Returns the createdOn.
    */
   public Calendar getCreatedOn()
   {
      return createdOn;
   }
   
   /**
    * @param createdOn The createdOn to set.
    */
   public void setCreatedOn(Calendar createdOn)
   {
      this.createdOn = createdOn;
   }
   
   /**
    * @return Returns the objectId.
    */
   public int getObjectId()
   {
      return objectId;
   }
   
   /**
    * @param objectId The objectId to set.
    */
   public void setObjectId(int objectId)
   {
      this.objectId = objectId;
   }
   
   /**
    * @return Returns the objectContext.
    */
   public String getObjectContext()
   {
      return objectContext;
   }
   
   /**
    * @param objectContext The objectContext to set.
    */
   public void setObjectContext(String objectContext)
   {
      this.objectContext = objectContext;
   }
   
   /**
    * @return Returns the attachment.
    */
   public byte[] getAttachment()
   {
      return attachment;
   }
   
   /**
    * @param attachment The attachment to set.
    */
   public void setAttachment(byte[] attachment)
   {
      this.attachment = attachment;
   }
   
   /**
    * @return Returns the notes.
    */
   public String getNotes()
   {
      return notes;
   }
   
   /**
    * @param notes The notes to set.
    */
   public void setNotes(String notes)
   {
      this.notes = notes;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
}
/*
 * 
 * $Log: BinaryAttachment.java,v $
 * Revision 1.3  2005/04/21 01:10:03  brian
 * Added name field and corresponding getter/setters.
 *
 * Revision 1.2  2005/03/23 08:59:37  brian
 * Added footer.
 *
 * 
 */