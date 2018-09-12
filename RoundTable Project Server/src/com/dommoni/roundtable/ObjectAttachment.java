/*
 * Created on Jan 28, 2005
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
public class ObjectAttachment
{
   private int id;
   private int projectId;
   private int createdBy;
   private Calendar createdOn;
   private int objectId;
   private String objectContext;
   private int attachmentObjectId;
   private String attachmentObjectContext;
   private String notes;
   private String name;
   
   public int getId()
   {
      return id;
   }
   
   public void setId(int id)
   {
      this.id = id;
   }
   
   public int getProjectId()
   {
      return projectId;
   }
   
   public void setProjectId(int projectId)
   {
      this.projectId = projectId;
   }
   
   public int getCreatedBy()
   {
      return createdBy;
   }
   
   public void setCreatedBy(int createdBy)
   {
      this.createdBy = createdBy;
   }
   
   public Calendar getCreatedOn()
   {
      return createdOn;
   }
   
   public void setCreatedOn(Calendar createdOn)
   {
      this.createdOn = createdOn;
   }
   
   public int getObjectId()
   {
      return objectId;
   }
   
   public void setObjectId(int objectId)
   {
      this.objectId = objectId;
   }
   
   public String getObjectContext()
   {
      return objectContext;
   }
   
   public void setObjectContext(String objectContext)
   {
      this.objectContext = objectContext;
   }

   public int getAttachmentObjectId()
   {
      return attachmentObjectId;
   }
   
   public void setAttachmentObjectId(int attachmentObjectId)
   {
      this.attachmentObjectId = attachmentObjectId;
   }
   
   /**
    * @return Returns the attachmentObjectContext.
    */
   public String getAttachmentObjectContext()
   {
      return attachmentObjectContext;
   }

   /**
    * @param attachmentObjectContext The attachmentObjectContext to set.
    */
   public void setAttachmentObjectContext(String attachmentObjectContext)
   {
      this.attachmentObjectContext = attachmentObjectContext;
   }
   
   public String getNotes()
   {
      return notes;
   }
   
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
 * $Log: ObjectAttachment.java,v $
 * Revision 1.2  2005/03/26 19:11:42  brian
 * Added footer.
 *
 * 
 */