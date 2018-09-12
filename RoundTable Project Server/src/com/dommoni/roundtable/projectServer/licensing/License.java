/*
 * Created on Feb 28, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.licensing;

import java.util.Calendar;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class License
{
   private String company;
   private String contact;
   private int users;
   private int mode;
   private int days;
   private long startDay;
   private Calendar loadDate;
   private long fileCRC;
   
   private boolean locked_company;
   private boolean locked_contact;
   private boolean locked_users;
   private boolean locked_mode;
   private boolean locked_days;
   private boolean locked_startDay;
   private boolean locked_loadDate;
   private boolean locked_fileCRC;
   
   public License()
   {
      locked_company = false;
      locked_contact = false;
      locked_users = false;
      locked_mode = false;
      locked_days = false;
      locked_startDay = false;
      locked_fileCRC = false;
   }
   
   //
   // Company Property
   //
   public String getCompany() 
   {
      return this.company;
   }
   
   public void setCompany(String company) 
   {
      if(!locked_company)
      {
         this.company = company;
         locked_company = true;
      }
   }
   
   //
   // Contact Property
   //
   public String getContact() 
   {
      return this.contact;
   }
   
   public void setContact(String contact) 
   {
      if(!locked_contact)
      {
         this.contact = contact;
         locked_contact = true;
      }
   }
   
   public int getUsers() 
   {
      return this.users;
   }
   
   public void setUsers(int users) 
   {
      if(!locked_users)
      {
         this.users = users;
         locked_users = true;
      }
   }
   
   public int getMode() 
   {
      return this.mode;
   }
   
   public void setMode(int mode) 
   {
      if(!locked_mode)
      {
         this.mode = mode;
         locked_mode = true;
      }
   }
   
   public int getDays() 
   {
      return this.days;
   }
   
   public void setDays(int days) 
   {
      if(!locked_days)
      {
         this.days = days;
         locked_days = true;
      }
   }
   
   public long getStartDay()
   {
   	  return this.startDay;
   }
   
   public void setStartDay(long startDay)
   {
   	  if(!locked_startDay)
   	  {
   	  	 this.startDay = startDay;
   	  	 locked_startDay = true;
   	  }
   }
   
   public Calendar getLoadDate() {return this.loadDate;}
   public void setLoadDate(Calendar loadDate) 
   {
   	  if(!locked_loadDate)
   	  {
   	  	 this.loadDate = loadDate;
   	  	 locked_loadDate = true;
   	  }
   } 
   
   public long getFileCRC()
   {
      return this.fileCRC;
   }
   
   public void setFileCRC(long fileCRC)
   {
      if(!locked_fileCRC)
      {
         this.fileCRC = fileCRC;
         locked_fileCRC = true;
      }
   }
}
/*
 * 
 * $Log: License.java,v $
 * Revision 1.2  2005/03/23 07:31:10  brian
 * Added Load-Date and Start-Date.
 *
 * 
 */
