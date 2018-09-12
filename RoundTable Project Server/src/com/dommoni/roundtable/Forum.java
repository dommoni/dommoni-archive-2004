/*
 * Created on Jul 10, 2004
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
public class Forum extends NotificationContextObject implements Cloneable
{
   private int id;
   private String subject;
   private String message;
   private int projectId;
   private int createdBy;
   private Calendar createdOn;
   
   public int getId()
   {
      return this.id;
   }
   
   public void setId(int _id)
   {
      this.id = _id;
   }
   
   public String getSubject()
   {
      return this.subject;
   }
   
   public void setSubject(String _subject)
   {
      this.subject = _subject;
   }
   
   // for nco
   public String getName()
   {
      return this.getSubject();
   }
   
   public String getMessage()
   {
      return this.message;
   }
   
   public void setMessage(String _message)
   {
      this.message = _message;
   }
   
   public int getProjectId()
   {
      return projectId;
   }
   
   public void setProjectId(int _projectId)
   {
      this.projectId = _projectId;
   }
   
   public int getCreatedBy()
   {
      return createdBy;
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
   
   public Object clone()
   {
      Forum clone = new Forum();
      clone.setId(this.id);
      clone.setSubject(this.subject);
      clone.setMessage(this.message);
      clone.setProjectId(this.projectId);
      clone.setCreatedBy(this.createdBy);
      clone.setCreatedOn(this.createdOn);
      
      return clone;
   }
}
/*
 * 
 * $Log: Forum.java,v $
 * Revision 1.2  2005/03/26 19:02:14  brian
 * Added footer.
 *
 * 
 */