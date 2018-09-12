/*
 * Created on Dec 30, 2004
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
public class Announcement
{
   private int id;
   private int projectId;
   private int createdBy;
   private Calendar createdOn;
   private String title;
   private String text;
   //AnnouncementAttachement[] attachements;
   
   public int getId() {return this.id;}
   public void setId(int id) {this.id = id;}
   
   public int getProjectId() {return this.projectId;}
   public void setProjectId(int projectId) {this.projectId = projectId;}
   
   public int getCreatedBy() {return this.createdBy;}
   public void setCreatedBy(int createdBy){this.createdBy=createdBy;}
   
   public Calendar getCreatedOn(){return this.createdOn;}
   public void setCreatedOn(Calendar createdOn){this.createdOn=createdOn;}
   
   public String getTitle(){return this.title;}
   public void setTitle(String title){this.title=title;}
   
   public String getText(){return this.text;}
   public void setText(String text){this.text=text;}
}
/*
 * 
 * $Log: Announcement.java,v $
 * Revision 1.2  2005/03/23 08:59:22  brian
 * Added footer.
 *
 * 
 */