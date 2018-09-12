/*
 * Created on Mar 24, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.notificationManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Vector;

import com.dommoni.roundtable.Notification;
import com.dommoni.roundtable.exceptions.ContextNotFoundException;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.events.Event;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class NotificationManager implements INotificationManager
{
	//public int addNotification(Event event, Notification notification)
   public int addNotification(Notification notification)
   throws Exception
   {
      /*
       * Algorithm:
       * 
       * First, Determine if a Notification exists for this user/ojbect 
       *   if it does, modify that object to reflect the additions made in the
       *     notification received.
       *   else, add a new one.
       */
      
      int notificationId = -1;
      
      if(notification == null)
         return -1;
      
      Notification existingNotification = getExistingNotification(notification);
      if(existingNotification == null)
      { 
         Connection connection = null;
      
         try
         {
            connection = ConnectionManager.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into notifications (project_id,name,context,created_by,created_on,type,operation) values (?,?,?,?,?,?,?)");
            pstmt.setInt(1, notification.getProjectId());
            pstmt.setString(2, notification.getName());
            pstmt.setString(3, notification.getContext());
            pstmt.setInt(4, notification.getCreatedBy());
   
            pstmt.setTimestamp(5, new Timestamp(Calendar.getInstance().getTimeInMillis()));   
            
            pstmt.setInt(6, notification.getType());
            pstmt.setInt(7, notification.getOperation());
   
            pstmt.executeUpdate();
            
            //
            // retrieve and return the id..
            //
            pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from notifications", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs.first())
            {
               notificationId = rs.getInt(1);
            }
            
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
      }
      else
      {
         int newType = (existingNotification.getType() | notification.getType());
         existingNotification.setType(newType);
         
         int newOperation = (existingNotification.getOperation() | notification.getOperation());
         existingNotification.setOperation(newOperation);
         
         notificationId = existingNotification.getId();
         
         if(notification.getName() != null && notification.getName().length() > 0)
         {   
            existingNotification.setName(notification.getName()); 
         } 
         else
         {   
            existingNotification.setName(createNotificationNameFromType(existingNotification.getContext(), newType));
         } 
         modifyNotification(existingNotification);
      }   
      
      return notificationId;
   }

   /*public int addNotification(Notification notification)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   /*public int addNotification(Event event, Notification notification, int projectId)
   throws Exception
   {
      if(notification != null)
      {
         notification.setProjectId(projectId);
         return addNotification(notification);
      }
      return -1;
   }*/

   /*public int addNotification(Notification notification, int projectId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public void dropNotification(Event event, int notificationId)
   public void dropNotification(int notificationId)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("delete from notifications where id=?");
         pstmt.setInt(1, notificationId);
         pstmt.executeUpdate();
         
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
         }
      }
   }

   /*public void dropNotification(int notificationId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public void modifyNotification(Event event, Notification notification)
   public void modifyNotification(Notification notification)
   throws Exception
   {
      Connection connection = null;
      
      if(notification == null)
         return;
         
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("update notifications set name=?, type=?, operation=? where id=?");
         pstmt.setString(1, notification.getName());
         //pstmt.setDate(2, new java.sql.Date(notification.getCreatedOn().getTime().getTime()));
         pstmt.setInt(2, notification.getType());
         pstmt.setInt(3, notification.getId());
         pstmt.setInt(4, notification.getOperation());
         
         pstmt.executeUpdate();
         
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
         }
      }
   }

   /*public void modifyNotification(Notification notification)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public Notification getNotification(Event event, int notificationId)
   public Notification getNotification(int notificationId)
   throws Exception
   {
      System.out.println("Entering NotificationManager.getNotification(): " + notificationId);
      
      Connection connection = null;
      Notification notification = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select project_id,name,context,created_by,created_on,type,operation from notifications where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, notificationId);
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            notification = new Notification();
            notification.setId(notificationId);
            notification.setProjectId(rs.getInt(1));
            notification.setName(rs.getString(2));
            notification.setContext(rs.getString(3));
            notification.setCreatedBy(rs.getInt(4));
            if(rs.getDate(5) != null)
            {
               Calendar clCreatedOn = Calendar.getInstance();
               clCreatedOn.setTimeInMillis(rs.getDate(5).getTime());
               notification.setCreatedOn(clCreatedOn);
            }
            notification.setType(rs.getInt(6));
            notification.setOperation(rs.getInt(7));
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
         }
      }
      
      return notification;
   }

   /*public Notification getNotification(int notificationId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   public Notification[] getAllNotifications()
   throws Exception
   {
      return null;
   }
   
   public Notification[] getAllNotificationsForProject(int projectId)
   throws Exception
   {
      return null;
   }
   
   public Notification[] getAllNotificationsForAccount(int accountId)
   throws Exception
   {
      return null;
   }
   
   //public Notification[] getAllNotificationsForAccountProject(Event event, int accountId, int projectId)
   public Notification[] getAllNotificationsForAccountProject(int accountId, int projectId)
   throws Exception
   {
      System.out.println("Entering NotificationManager.getAllNotificationsForAccountProject()");
      
      Connection connection = null;
      Vector notifications = new Vector();

      try
      {
         connection = ConnectionManager.getConnection();      
         PreparedStatement pstmt = connection.prepareStatement("select id from notifications where created_by=? and project_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, accountId);
         pstmt.setInt(2, projectId);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            notifications.add(getNotification(rs.getInt(1)));
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
         }
      }
      return (Notification[])notifications.toArray(new Notification[notifications.size()]);
   }

   /*public Notification[] getAllNotificationsForAccountProject(int accountId, int projectId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public Notification[] getAllNotificationsForAccountProjectObject(Event event, int accountId, int projectId, String ojbectName)
   public Notification[] getAllNotificationsForAccountProjectObject(int accountId, int projectId, String ojbectName)
   throws Exception
   {
      Connection connection = null;
      Vector notifications = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();      
         PreparedStatement pstmt = connection.prepareStatement("select id, project_id, name, object_name, created_by, created_on, type from notifications where created_by=? and project_id=? and object_name=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, accountId);
         pstmt.setInt(2, projectId);
         pstmt.setString(3, ojbectName);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            Notification notification = new Notification();
            notification.setId(rs.getInt(1));
            notification.setProjectId(rs.getInt(2));
            notification.setName(rs.getString(3));
            notification.setContext(rs.getString(4));
            notification.setCreatedBy(rs.getInt(5));
            
            if(rs.getDate(6) != null)
            {
               Calendar cal = Calendar.getInstance();
               cal.setTimeInMillis(rs.getDate(6).getTime());
               notification.setCreatedOn(cal);
            }
            notification.setType(rs.getInt(7));
            
            notifications.add(notification);
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
         }
      }
      return (Notification[])notifications.toArray(new Notification[notifications.size()]);
   }

   /*public Notification[] getAllNotificationsForAccountProjectObject(int accountId, int projectId, String ojbectName)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   /**
    * Internal helper method used in adding a notification, in order to determine
    * if it already exists.
    * 
    * @param notification
    * @return
    */
   //private Notification getExistingNotification(Event event, Notification notification)
   private Notification getExistingNotification(Notification notification)
   throws Exception
   {
      Connection connection = null;
      Notification rtNotification = null;
      
      if(notification == null)
         return null; // should throw an exception..
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id from notifications where context=? and created_by=? and project_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setString(1, notification.getContext());
         pstmt.setInt(2, notification.getCreatedBy());
         pstmt.setInt(3, notification.getProjectId());
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            rtNotification = getNotification(rs.getInt(1));
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
         }
      }
      
      return rtNotification;
   }

   /*private Notification getExistingNotification(Notification notification)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   public String createNotificationNameFromType(String notificationObject, int type)
   throws Exception
   {
      String sName = ""; 
      int typeCount = 0;
      sName += "Notify me when a ";
      sName += notificationObject + " is ";
      if((type & Notification.CREATE_OPERATION) > 0)
      {
         sName += "created";
         typeCount++;
      }
      if((type & Notification.DELETION_OPERATION) > 0)
      {
         if(typeCount > 0)
         {
            sName += " OR deleted";
         }
         else
         {
            sName += "deleted";
         }
         typeCount++;
      }
      if((type & Notification.MODIFICATION_OPERATION) > 0)
      {
         if(typeCount > 0)
         {
            sName += " OR modified";
         }
         else
         {
            sName += "modified";
         }
         typeCount++;
      }
      
      return sName;
   }
}
