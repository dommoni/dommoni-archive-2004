/*
 * Created on Dec 30, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.services.announcementManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import com.dommoni.roundtable.Announcement;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.events.Event;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AnnouncementManager implements IAnnouncementManager
{
	//public int addAnnouncement(Event event, Announcement announcement)
   public int addAnnouncement(Announcement announcement)
   throws Exception
   {
      Connection connection = null;
      int announcementId = -1;
      
      if(announcement == null)
         return announcementId;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("insert into announcements (project_id, created_by, created_on, title, text) values (?,?,?,?,?)");
         pstmt.setInt(1, announcement.getProjectId());
         pstmt.setInt(2, announcement.getCreatedBy());
         pstmt.setTimestamp(3, new Timestamp(Calendar.getInstance().getTimeInMillis()));
         pstmt.setString(4, announcement.getTitle());
         pstmt.setString(5, announcement.getText());
         
         pstmt.executeUpdate();
         
         //
         // retrieve and return the id..
         //
         pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from announcements", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            announcementId = rs.getInt(1);
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return announcementId;
   }
   
   /*public int addAnnouncement(Announcement announcement) 
   throws Exception
   {
      return this.addAnnouncement(null, announcement);
   }*/
   
   public void dropAnnouncement(int announcementId)
   throws Exception
   {
   }
   
   /*public void dropAnnouncement(int announcementId)
   throws Exception
   {
   }*/
   
   //public void modifyAnnouncement(Event event, Announcement announcement)
   public void modifyAnnouncement(Announcement announcement)
   throws Exception
   {   
   }
   
   /*public void modifyAnnouncement(Announcement announcement)
   throws Exception
   {   
   }*/
   
   //public Announcement getAnnouncement(Event event, int announcementId)
   public Announcement getAnnouncement(int announcementId)
   throws Exception
   {
      Connection connection = null;
      Announcement announcement = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select project_id, created_by, created_on, title, text from announcements where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, announcementId);
         
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            announcement = new Announcement();
            announcement.setId(announcementId);
            announcement.setProjectId(rs.getInt("project_id"));
            announcement.setCreatedBy(rs.getInt("created_by"));
            
            Calendar clCreatedOn = Calendar.getInstance();
            clCreatedOn.setTime(rs.getTimestamp("created_on"));
            announcement.setCreatedOn(clCreatedOn);
            
            announcement.setTitle(rs.getString("title"));
            announcement.setText(rs.getString("text"));
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return announcement;
   }
   
   /*public Announcement getAnnouncement(int announcementId) 
   throws Exception
   {
      return this.getAnnouncement(null, announcementId);
   }*/
   //public Announcement[] getAllAnnouncementsForProject(Event event, int projectId)
   public Announcement[] getAllAnnouncementsForProject(int projectId)
   throws Exception
   {
      Connection connection = null;
      List announcements = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id from announcements where project_id=?");
         pstmt.setInt(1, projectId);
         
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            announcements.add(getAnnouncement(rs.getInt(1)));
         }
         
         rs.close();
         pstmt.close();
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if(connection != null)
            {
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return (Announcement[])announcements.toArray(new Announcement[announcements.size()]);
   }
   
   /*public Announcement[] getAllAnnouncementsForProject(int projectId) 
   throws Exception
   {
      return this.getAllAnnouncementsForProject(null, projectId);
   }*/
}
