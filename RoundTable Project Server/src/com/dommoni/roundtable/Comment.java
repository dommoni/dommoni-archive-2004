/*
 * Created on Dec 23, 2004
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
public class Comment
{
   private int id;
   private int projectId;
   private int objectId;
   private String context;
   private int createdBy;
   private Calendar createdOn;
   
   private String comment;
   
   /** 
    * a list of 'attachements' which are binary arrays
    */
   //private List attachements;
   
   public int getId()
   {
      return this.id;
   }
   
   public void setId(int id)
   {
      this.id = id;
   }
   
   public int getProjectId()
   {
      return this.projectId;
   }
   
   public void setProjectId(int projectId)
   {
      this.projectId = projectId;
   }
   
   public int getObjectId()
   {
      return this.objectId;
   }
   
   public void setObjectId(int objectId)
   {
      this.objectId = objectId;
   }
   
   public String getContext()
   {
      return this.context;
   }
   
   public void setContext(String context)
   {
      this.context = context;
   }
   
   public int getCreatedBy()
   {
      return this.createdBy;
   }
   
   public void setCreatedBy(int createdBy)
   {
      this.createdBy = createdBy;
   }
   
   public Calendar getCreatedOn()
   {
      return this.createdOn;
   }
   
   public void setCreatedOn(Calendar createdOn)
   {
      this.createdOn = createdOn;
   }
   
   public String getComment()
   {
      return this.comment;
   }
   
   public void setComment(String comment)
   {
      this.comment = comment;
   }
   
   /*public List getAttachements()
   {
      return this.attachements;
   }
   
   public void addAttachement(CommentAttachment attachement)
   {
      this.attachements.add(attachement);
   }
   
   public void setAttachements(List attachements)
   {
      this.attachements = attachements;
   }*/
}
/*
 * 
 * $Log: Comment.java,v $
 * Revision 1.3  2005/03/23 09:06:54  brian
 * Added footer.
 *
 * 
 */