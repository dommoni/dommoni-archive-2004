/*
 * Created on Mar 27, 2004
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
public class Update
{
   private int id; 
   private int projectId; 
   private int posterId;
   private Calendar timestamp;
   private String message; 
   
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
   
   public int getPosterId()
   {
      return this.posterId;
   }
   
   public void setPosterId(int _posterId)
   {
      this.posterId = _posterId;
   }
   
   public Calendar getTimestamp()
   {
      return this.timestamp;
   }
   
   public void setTimestamp(Calendar _timestamp)
   {
      this.timestamp = _timestamp;
   }
   
   public String getMessage()
   {
      return this.message;
   }
   
   public void setMessage(String _message)
   {
      this.message = _message;
   }
}
/*
 * 
 * $Log: Update.java,v $
 * Revision 1.2  2005/03/26 19:18:25  brian
 * Added footer.
 *
 * 
 */