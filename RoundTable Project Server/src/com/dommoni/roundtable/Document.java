/*
 * Created on Mar 17, 2004
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
public class Document extends NotificationContextObject implements Cloneable
{
   private int id;
   private String name;
   private String filename;
   private int ownerId;
   private int projectId;
   private int documentType;
   private byte document[];
   private Calendar createdOn;
   private String description;
   
   public int getId()
   {
      return this.id;
   }
   
   public void setId(int _id)
   {
      this.id = _id;
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public void setName(String _name)
   {
      this.name = _name;
   }
   
   public String getFilename()
   {
      return this.filename;
   }
   
   public void setFilename(String _filename)
   {
      this.filename = _filename;
   }
   
   public int getOwnerId()
   {
      return this.ownerId;
   }
   
   public void setOwnerId(int _ownerId)
   {
      this.ownerId = _ownerId;
   }
   
   public int getProjectId()
   {
      return this.projectId;
   }
   
   public void setProjectId(int _projectId)
   {
      this.projectId = _projectId;
   }
   
   public int getDocumentType()
   {
      return this.documentType;
   }
   
   public void setDocumentType(int _documentType)
   {
      this.documentType = _documentType;
   }
   
   public byte[] getDocument()
   {
      return this.document;
   }
   
   public void setDocument(byte _document[])
   {
      this.document = _document;
   }
   
   public Calendar getCreatedOn()
   {
      return this.createdOn;
   }
   
   public void setCreatedOn(Calendar _createdOn)
   {
      this.createdOn = _createdOn;
   }
   
   public String getDescription()
   {
      return this.description;
   }
   
   public void setDescription(String _description)
   {
      this.description = _description;
   }
   
   public String toString()
   {
      if(name != null)
      {   
         return this.name; 
      } 
      else
      {   
         return super.toString(); 
      } 
   }
   
   public Object clone()
   {
      Document clone = new Document();
     
      clone.setId(this.id);
      clone.setName(this.name);
      clone.setFilename(this.filename);
      clone.setOwnerId(this.ownerId);
      clone.setProjectId(this.projectId);
      clone.setDocumentType(this.documentType);
      clone.setDocument(this.document);
      clone.setCreatedOn(this.createdOn);
      clone.setDescription(this.description);
      
      return clone;
   }
}
/*
 * 
 * $Log: Document.java,v $
 * Revision 1.2  2005/03/26 19:01:34  brian
 * Added footer.
 *
 * 
 */