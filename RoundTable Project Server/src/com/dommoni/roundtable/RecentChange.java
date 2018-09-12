/*
 * Created on Nov 7, 2004
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
public class RecentChange implements Cloneable
{
   private int id;
   private int projectId;
   private String changeMessage;
   private Calendar timestamp;
   
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
   
   public String getChangeMessage()
   {
      return this.changeMessage;
   }
   
   public void setChangeMessage(String changeMessage)
   {
      this.changeMessage = changeMessage;
   }
   
   public Calendar getTimestamp()
   {
      return this.timestamp;
   }
   
   public void setTimestamp(Calendar timestamp)
   {
      this.timestamp = timestamp;
   }
   
   public Object clone()
   {
      RecentChange clone = new RecentChange();
      clone.setId(this.id);
      clone.setProjectId(this.projectId);
      clone.setChangeMessage(this.changeMessage);
      clone.setTimestamp(this.timestamp);
      
      return clone;
   }
}
/*
 * 
 * $Log: RecentChange.java,v $
 * Revision 1.2  2005/03/23 09:06:04  brian
 * Added footer.
 *
 * 
 */