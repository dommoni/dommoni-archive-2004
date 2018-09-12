/*
 * Created on Oct 23, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable;

/**
 * Allows you to provide custom status fields.
 * 
 * @author Brian Abbott
 */
public class TaskStatus
{
   private int id;
   private int projectId;
   private String title;
 
   /**
    * Returns the Internal ID for this Status object.
    * 
    * @return the internal key of the status object.
    */  
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
   
   public String getTitle()
   {
      return this.title;
   }
   
   public void setTitle(String title)
   {
      this.title = title;
   }
}
/*
 * 
 * $Log: ToDoStatus.java,v $
 * Revision 1.2  2005/03/26 19:18:09  brian
 * Added footer.
 *
 * 
 */