/*
 * Created on Mar 15, 2004
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
public class Project
{
   private int id;
   private String name;
   private Account members[];
   //private Calendar createdOn;
   //private int createdBy;
   
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
   
   public Account[] getMembers()
   {
      return this.members;
   }
   
   public void setMembers(Account _members[])
   {
      this.members = _members;
   }
   
   /*
   public Calendar getCreatedOn() 
   {
   }
   
   public void setCreatedOn(Calendar createdOn) 
   {
   }
   
   public int getCreatedBy() 
   {
   }
   
   public void setCreatedBy(int createdBy) 
   {
   }*/
   
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
}
