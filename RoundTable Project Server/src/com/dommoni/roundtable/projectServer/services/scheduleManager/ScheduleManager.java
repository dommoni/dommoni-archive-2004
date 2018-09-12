package com.dommoni.roundtable.projectServer.services.scheduleManager;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.Schedule;
import com.dommoni.roundtable.ScheduleItem;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.services.accountManager.AccountManager;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.commentManager.CommentManager;
import com.dommoni.roundtable.projectServer.services.commentManager.ICommentManager;

public class ScheduleManager implements IScheduleManager
{
   public synchronized int addSchedule(Schedule schedule) 
      throws Exception
   {
      // TODO: Need to re-add event mapping
      Connection connection = null;
      int scheduleId = -1;
      
      try
      {
         if (schedule != null)
         {
            Calendar clTimestamp = Calendar.getInstance();
            connection = ConnectionManager.getConnection();

            PreparedStatement pstmt = 
               connection.prepareStatement("insert into schedules (name, project_id, created_by, created_on) values (?, ?, ?, ?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt.setString(1, schedule.getName());
            pstmt.setInt(2, schedule.getProjectId());
            pstmt.setInt(3, schedule.getCreatedBy());
            pstmt.setTimestamp(4, new Timestamp(clTimestamp.getTimeInMillis()));
            pstmt.executeUpdate();
            
            PreparedStatement ivalPstmt = 
               connection.prepareStatement("select IDENTITY_VAL_LOCAL() from schedules", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ivalPstmt.executeQuery();
            if (rs.first())
               scheduleId = rs.getInt(1);
            
            PreparedStatement psScheduleItems = 
               connection.prepareStatement("insert into schedule_items (" +
                     "schedule_id, " +
                     "title, " +
                     "created_by, " +
                     "created_on, " +
                     "start_date, " +
                     "end_date, " +
                     "duration, " +
                     "percent_complete, " +
                     "priority, " +
                     "description, " +
                     "ordinal) " +
                     "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
                     ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            PreparedStatement psScheduleItemResources = 
               connection.prepareStatement("insert into schedule_item_resources (" +
                     "schedule_item_id, resource_id) values (?, ?)", 
                     ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            ScheduleItem[] items = schedule.getScheduleItems();
            if (items != null && items.length > 0)
            {
               for (int i = 0; i < items.length; i++)
               {
                  try
                  {
                     psScheduleItems.setInt(1, scheduleId);
                     psScheduleItems.setString(2, items[i].getTitle());
                     psScheduleItems.setInt(3, items[i].getCreatedBy());
                     psScheduleItems.setTimestamp(4, new Timestamp(clTimestamp.getTimeInMillis()));
                     if (items[i].getStartDate() != null)
                        psScheduleItems.setDate(5, new Date(items[i].getStartDate().getTimeInMillis()));
                     if (items[i].getEndDate() != null)
                        psScheduleItems.setDate(6, new Date(items[i].getEndDate().getTimeInMillis()));
                     psScheduleItems.setFloat(7, items[i].getDuration());
                     psScheduleItems.setInt(8, items[i].getPercentComplete());
                     psScheduleItems.setInt(9, items[i].getPriority());
                     psScheduleItems.setString(10, items[i].getDescription());
                     psScheduleItems.setInt(11, items[i].getOrdinal());
                     
                     psScheduleItems.executeUpdate();
                     
                     int scheduleItemId = -1;
                     PreparedStatement s = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from schedule_items", 
                           ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                     ResultSet ivalRs = s.executeQuery();
                     if (ivalRs.first())
                     {
                        scheduleItemId = ivalRs.getInt(1);
                     }
                     
                     if (items[i].getResources() != null && 
                           items[i].getResources().length > 0)
                     {
                        if (scheduleItemId == -1)
                        {
                           // TODO: need to throw an Exception...
                        }
                        
                        Account[] resources = items[i].getResources();
                        for (int j = 0; j < resources.length; j++)
                        {
                           // TODO: consider adding a try/catch here...
                           psScheduleItemResources.setInt(1, scheduleItemId);
                           psScheduleItemResources.setInt(2, resources[j].getId());
                           psScheduleItemResources.addBatch();
                        }
                        psScheduleItemResources.executeBatch();
                     }
                     
                     if (items[i].getComments() != null && 
                           items[i].getComments().length > 0)
                     {
                        Comment[] comments = items[i].getComments();
                        for (int iComments = 0; iComments < comments.length; iComments++)
                           this.addCommentForScheduleItem(items[i], comments[iComments]);
                     }
                  }
                  catch(Exception e)
                  {
                     // eat the ex for now... 
                     e.printStackTrace();
                  }
               } // end-for            
            }
            
            if (schedule.getComments() != null && 
                  schedule.getComments().length > 0)
            {
               // TODO: We need to add schedules comments like this
               // on the add operation as the implementation of the client
               // allows for this operation. DETERMINE: Weather other services
               // should handle comments on the add operation. The WebUI wont
               // allow comments to be added before an object already exist 
               // but, other client applications possibly could?
               
               Comment[] comments = schedule.getComments();
               for (int i = 0; i < comments.length; i++)
                  this.addCommentForSchedule(schedule, comments[i]);
            }
         }
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
            if (connection != null)
               connection.close();
         }
         catch(Exception e)
         {
         }
      }
      
      return scheduleId;
   }
   
   public synchronized void dropSchedule(int scheduleId)
      throws Exception
   {
      /*
       * del: 
       *    - Schedule
       *    - Sched-Items
       *    - Comments for sched + sched-items... 
       *    - Resource-Entries for items... 
       * */

      Connection connection = null;
      
      try
      {
         Schedule tmpDelSched = getSchedule(scheduleId);
         connection = ConnectionManager.getConnection();
         
         //
         // Delete comments...
         //
         try
         {
            ICommentManager cm = new CommentManager();
            Comment[] schedComments = tmpDelSched.getComments();
            for (int i = 0; i < schedComments.length; i++)
            {   
               cm.dropComment(schedComments[i].getId());
            }
            
            ScheduleItem[] items = tmpDelSched.getScheduleItems();
            for (int i = 0; i < items.length; i++)
            {
               Comment[] siComments = items[i].getComments();
               for (int j = 0; j < siComments.length; j++)
               {   
                  cm.dropComment(siComments[j].getId());
               }
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
         
         //
         // Delete Schedule-Item Resources...
         //
         try
         {
            ScheduleItem[] schedItems = tmpDelSched.getScheduleItems();
            if (schedItems != null && schedItems.length > 0)
            {
               PreparedStatement pstmtDelResources = 
                  connection.prepareStatement("delete from schedule_item_resources where schedule_item_id=?");
   
               for (int i = 0; i < schedItems.length; i++)
               {
                  pstmtDelResources.setInt(1, schedItems[i].getId());
                  pstmtDelResources.addBatch();
               }
               pstmtDelResources.executeBatch();
               
               pstmtDelResources.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
         
         
         PreparedStatement pstmt = connection.prepareStatement("delete from schedules where id=?");
         pstmt.setInt(1, scheduleId);
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("delete from schedule_items where schedule_id=?");
         pstmt.setInt(1, scheduleId);
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
            if (connection != null)
            {
               connection.close();
            }
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
   }
   
   public synchronized void modifySchedule(Schedule schedule)
      throws Exception
   {
      Connection connection = null;
      
      if (schedule == null)
         return;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("update schedules set name=? where id=?");
         pstmt.setString(1, schedule.getName());
         pstmt.setInt(2, schedule.getId());
         pstmt.executeUpdate();
      
         //
         // find/handle deleted items...
         //
         try
         {
            List deletedItems = new Vector();
            
            PreparedStatement psSelectOriginalSIs = 
               connection.prepareStatement("select id from schedule_items where schedule_id=?", 
                     ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            PreparedStatement psDeleteScheduleItems = 
               connection.prepareStatement("delete from schedule_items where id=?",
                     ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            
            psSelectOriginalSIs.setInt(1, schedule.getId());
            ResultSet rsOriginalSis = psSelectOriginalSIs.executeQuery();
            while (rsOriginalSis.next())
            {
               try
               {
                  int origSchedId = rsOriginalSis.getInt(1);
                  ScheduleItem[] items = schedule.getScheduleItems();
                  boolean found = false;
                  if (items != null)
                  {
                     for (int i = 0; i < items.length; i++)
                     {
                        if (origSchedId == items[i].getId())
                        {   
                           found = true;
                        }
                     }
                  }
                  
                  if (!found)
                  {   
                     psDeleteScheduleItems.setInt(1, origSchedId);
                     psDeleteScheduleItems.addBatch();
                  }
               }
               catch(Exception e)
               {
                  e.printStackTrace();
               }
            }
            psDeleteScheduleItems.executeBatch();
         }
         catch(Exception e)
         {
         }
         
         //
         // Items + Item-Resources + Item-Comments
         ScheduleItem[] scheduleItems = schedule.getScheduleItems();
         if (scheduleItems != null && scheduleItems.length > 0)
         {
            PreparedStatement psUpdateScheduleItem = 
               connection.prepareStatement("update schedule_items set " +
                  "schedule_id=?, " + 
                  "title=?, " +
                  "start_date=?, " +
                  "end_date=?, " +
                  "duration=?, " +
                  "percent_complete=?, " +
                  "priority=?, " +
                  "description=?, " +
                  "ordinal=? where id=?");
            
            PreparedStatement psInsertScheduleItem = 
               connection.prepareStatement("insert into schedule_items (" +
                  "schedule_id, " +
                  "title, " +
                  "created_by, " +
                  "created_on, " +
                  "start_date, " +
                  "end_date, " +
                  "duration, " +
                  "percent_complete, " +
                  "priority, " +
                  "description, " +
                  "ordinal) " +
                  "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            PreparedStatement psDelItemResources = 
               connection.prepareStatement("delete from schedule_item_resources where schedule_item_id=?");
            
            PreparedStatement psInsertItemResources =
               connection.prepareStatement("insert into schedule_item_resources (" +
               "schedule_item_id, resource_id) values (?, ?)");
            
            
            ICommentManager commentManager = new CommentManager();
            
            for (int i = 0; i < scheduleItems.length; i++)
            {
               if (!doesScheduleItemExist(scheduleItems[i], schedule.getId()))
               {
                  // Doesnt exist, let's do an Insert-O
                  psInsertScheduleItem.setInt(1, schedule.getId());
                  psInsertScheduleItem.setString(2, scheduleItems[i].getTitle());
                  psInsertScheduleItem.setInt(3, scheduleItems[i].getCreatedBy());
                  psInsertScheduleItem.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
               
                  psInsertScheduleItem.setDate(5, new Date(scheduleItems[i].getStartDate().getTimeInMillis()));
                  psInsertScheduleItem.setDate(6, new Date(scheduleItems[i].getEndDate().getTimeInMillis()));
               
                  psInsertScheduleItem.setFloat(7, scheduleItems[i].getDuration());
                  psInsertScheduleItem.setInt(8, scheduleItems[i].getPercentComplete());
                  psInsertScheduleItem.setInt(9, scheduleItems[i].getPriority());
                  psInsertScheduleItem.setString(10, scheduleItems[i].getDescription());
                  psInsertScheduleItem.setInt(11, scheduleItems[i].getOrdinal());
                  
                  psInsertScheduleItem.addBatch();
               }
               else
               {
                  // Do an Update
                  
                  psUpdateScheduleItem.setInt(1, schedule.getId());
                  psUpdateScheduleItem.setString(2, scheduleItems[i].getTitle());
               
                  // should never be null...
                  if (scheduleItems[i].getStartDate() != null)
                     psUpdateScheduleItem.setDate(3, new Date(scheduleItems[i].getStartDate().getTimeInMillis())); 
                  if (scheduleItems[i].getEndDate() != null)
                     psUpdateScheduleItem.setDate(4, new Date(scheduleItems[i].getEndDate().getTimeInMillis()));
               
                  psUpdateScheduleItem.setFloat(5, scheduleItems[i].getDuration());
                  psUpdateScheduleItem.setInt(6, scheduleItems[i].getPercentComplete());
                  psUpdateScheduleItem.setInt(7, scheduleItems[i].getPriority());
                  psUpdateScheduleItem.setString(8, scheduleItems[i].getDescription());
                  psUpdateScheduleItem.setInt(9, scheduleItems[i].getOrdinal());
               
                  // where clause...
                  psUpdateScheduleItem.setInt(10, scheduleItems[i].getId());
               
                  psUpdateScheduleItem.addBatch();
               }
               
               //
               // do resources...
               //
               psDelItemResources.setInt(1, scheduleItems[i].getId());
               psDelItemResources.executeUpdate();
               
               Account[] resources = scheduleItems[i].getResources();
               if (resources != null && resources.length > 0)
               {
                  for (int iiResource = 0; iiResource < resources.length; iiResource++)
                  {
                     psInsertItemResources.setInt(1, scheduleItems[i].getId());
                     psInsertItemResources.setInt(2, resources[iiResource].getId());
                     
                     psInsertItemResources.addBatch();
                  }
                  psInsertItemResources.executeBatch();
               }
               
               // do comments...
               Comment[] comments = scheduleItems[i].getComments();
               if (comments != null && comments.length > 0)
               {   
                  for (int iiComment = 0; iiComment < comments.length; iiComment++)
                  {   
                     commentManager.modifyComment(scheduleItems[i], comments[iiComment]);
                  }
               }
            }
            
            // execute inserts and updates.
            psInsertScheduleItem.executeBatch();
            psUpdateScheduleItem.executeBatch();
         }
      }
      catch (SQLException se)
      {
         se.printStackTrace();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if (connection != null)
            {   
               connection.close();
            }
         }
         catch(Exception e)
         {
         }
      }
   }
   
   public boolean doesScheduleItemExist(ScheduleItem item, int scheduleId)
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement(
                  "select title from schedule_items where id=? and schedule_id=?",
                  ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, item.getId());
         pstmt.setInt(2, scheduleId);
         ResultSet rs = pstmt.executeQuery();
         if (rs.first())
         {
            return true;
         }
         else
         {
            return false;
         }
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
            if (connection != null)
            {   
               connection.close();
            }
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return false;
   }
   
   public synchronized Schedule getSchedule(int scheduleId)
      throws Exception
   {
      Connection connection = null;
      Schedule schedule = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("select name, project_id, created_by, created_on from schedules where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        
         PreparedStatement pstmtResources = 
            connection.prepareStatement("select resource_id from schedule_item_resources where schedule_item_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         
         pstmt.setInt(1, scheduleId);
         ResultSet rs = pstmt.executeQuery();
         if (rs.first())
         {
            schedule = new Schedule();
            schedule.setId(scheduleId);
            schedule.setName(rs.getString(1));
            schedule.setProjectId(rs.getInt(2));
            schedule.setCreatedBy(rs.getInt(3));
            
            if (rs.getTimestamp(4) != null)
            {
               Calendar clCreatedOn = Calendar.getInstance();
               clCreatedOn.setTime(rs.getTimestamp(4));
               schedule.setCreatedOn(clCreatedOn);
            }
            
            ICommentManager cm = new CommentManager();
            schedule.setComments(cm.getCommentsForObject(schedule));
            
            PreparedStatement pstmtScheduleItems = 
               connection.prepareStatement("select id, " +
                     "title, " +
                     "created_by, " +
                     "created_on, " +
                     "start_date, " +
                     "end_date, " +
                     "duration, " +
                     "percent_complete, " +
                     "priority, " +
                     "description, " +
                     "ordinal " +
                     "from schedule_items where schedule_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmtScheduleItems.setInt(1, scheduleId);
            ResultSet rsItems = pstmtScheduleItems.executeQuery();
            List alItems = new ArrayList();
            
            IAccountManager accountManager = new AccountManager();
            while (rsItems.next())
            {
               //System.out.println("getSchedule - Doing RSItems Loop....");
               
               ScheduleItem si = new ScheduleItem();
               si.setId(rsItems.getInt(1));
               si.setTitle(rsItems.getString(2));
               si.setCreatedBy(rsItems.getInt(3));
               if (rsItems.getTimestamp(4) != null)
               {
                  Calendar clCreatedOn = Calendar.getInstance();
                  clCreatedOn.setTime(rsItems.getTimestamp(4));
                  si.setCreatedOn(clCreatedOn);
               }
               
               if (rsItems.getDate(5) != null)
               {
                  Calendar clStartDate = Calendar.getInstance();
                  clStartDate.setTime(rsItems.getDate(5));
                  si.setStartDate(clStartDate);
               }
               if (rsItems.getDate(6) != null)
               {
                  Calendar clEndDate = Calendar.getInstance();
                  clEndDate.setTime(rsItems.getDate(6));
                  si.setEndDate(clEndDate);
               }
               si.setDuration(rsItems.getFloat(7));
               si.setPercentComplete(rsItems.getInt(8));
               si.setPriority(rsItems.getInt(9));
               si.setDescription(rsItems.getString(10));
               si.setOrdinal(rsItems.getInt(11));
               
               //
               // do resources...
               //
               List alResources = new ArrayList();
               pstmtResources.setInt(1, si.getId());
               ResultSet rsResources = pstmtResources.executeQuery();
               while(rsResources.next())
               {
                  alResources.add(accountManager.getAccount(rsResources.getInt(1)));
               }
               si.setResources((Account[])alResources.toArray(new Account[alResources.size()]));
               
               // do comments
               si.setComments(getCommentsForScheduleItem(si));
               
               alItems.add(si);
            }// while
            
            ScheduleItem[] items = (ScheduleItem[])alItems.toArray(new ScheduleItem[alItems.size()]);
            //System.out.println("getSchedule - items.length: " + items.length);
            schedule.setScheduleItems(items);
         }
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
            if (connection != null)
            {   
               connection.close();
            }
         }
         catch(Exception e)
         {
         }
      }
      
      return schedule;
   }
   
   public synchronized Schedule[] getAllSchedulesForProject(int projectId) 
      throws Exception
   {
      //System.out.println("Entering getAllSchedulesForProject...");
      
      Connection connection = null;
      List schedules = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         
         PreparedStatement pstmt = 
            connection.prepareStatement("select id from schedules where project_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, projectId);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            //System.out.println("\tProjectSelect..");
            schedules.add(getSchedule(rs.getInt(1)));
         }
      }
      catch(SQLException se)
      {
         se.printStackTrace();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         try
         {
            if (connection != null)
               connection.close();
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return (Schedule[])schedules.toArray(new Schedule[schedules.size()]);
   }
   
   //
   // Comments Convenience Methods
   //
   public int addCommentForSchedule(Schedule schedule, Comment comment)
      throws Exception 
   {
      ICommentManager cm = new CommentManager();
      return cm.addComment(schedule, comment);
   }
   
   public synchronized Comment[] getCommentsForSchedule(Schedule schedule)
      throws Exception
   {
      ICommentManager cm = new CommentManager();
      return cm.getCommentsForObject(schedule);
   }
   
   public synchronized int addCommentForScheduleItem(ScheduleItem scheduleItem, Comment comment)
      throws Exception
   {
      ICommentManager cm = new CommentManager();
      return cm.addComment(scheduleItem, comment);
   }
   
   public synchronized Comment[] getCommentsForScheduleItem(ScheduleItem scheduleItem)
      throws Exception
   {
      ICommentManager cm = new CommentManager();
      return cm.getCommentsForObject(scheduleItem);
   }
}
/*
 *
 * $Log$
 *
 */