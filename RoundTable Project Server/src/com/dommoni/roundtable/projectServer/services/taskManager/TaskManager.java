/*
 * Created on Mar 27, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.taskManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.CustomField;
import com.dommoni.roundtable.NamedFieldCollection;
import com.dommoni.roundtable.NamedFieldTemplate;
import com.dommoni.roundtable.Task;
import com.dommoni.roundtable.TaskStatus;
//import com.dommoni.roundtable.exceptions.ContextNotFoundException;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.customfields.CustomFieldManager;
import com.dommoni.roundtable.projectServer.customfields.ICustomFieldManager;
//import com.dommoni.roundtable.projectServer.events.Event;
import com.dommoni.roundtable.projectServer.namedFieldCollections.INamedFieldCollectionManager;
import com.dommoni.roundtable.projectServer.namedFieldCollections.NamedFieldCollectionManager;
import com.dommoni.roundtable.projectServer.services.commentManager.CommentManager;
import com.dommoni.roundtable.projectServer.utils.DateHandler;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class TaskManager implements ITaskManager
{  
	//public int addToDo(Event event, ToDo todo)
   public synchronized int addTask(Task task)
   throws Exception
   {
      Connection connection = null;
      int taskId = -1;
      
      DateHandler dateHandler = new DateHandler();
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("insert into tasks (" +
                  "project_id, " +
                  "title, " +
                  "created_by, " +
                  "created_on, " +
                  "description, " +
                  "start_date, " +
                  "due_date, " +
                  "flag, " +
                  "percent_complete, " +
                  "is_public, " +
                  "current_status, " +
                  "last_modified, " +
                  "assigned_to" +
                  ") values (?,?,?,?,?,?,?,?,?,?,?,?,?)");            
         
         pstmt.setInt(1, task.getProjectId());
         pstmt.setString(2, task.getTitle());
         pstmt.setInt(3, task.getCreatedBy());
         
         if(task.getCreatedOn() != null && dateHandler.isSetDotNET(task.getCreatedOn()))
         {   
            pstmt.setTimestamp(4, new Timestamp(task.getCreatedOn().getTimeInMillis()));
         }
         else
         {   
            pstmt.setTimestamp(4, new Timestamp(Calendar.getInstance().getTimeInMillis()));
         }
         
         pstmt.setString(5, task.getDescription());
         
         // start date
         if(task.getStartDate() != null && dateHandler.isSetDotNET(task.getStartDate()))
         {
            pstmt.setDate(6, new java.sql.Date(task.getStartDate().getTime().getTime()));
         }
         else
         {
            pstmt.setDate(6, null);
         }
         
         // due date
         if(task.getDueDate() != null && dateHandler.isSetDotNET(task.getDueDate()))
         {   
            pstmt.setDate(7, new java.sql.Date(task.getDueDate().getTime().getTime()));
         }
         else
         {   
            pstmt.setDate(7, null);
         }
         pstmt.setInt(8, task.getFlag());
         pstmt.setInt(9, task.getPercentComplete());
         pstmt.setBoolean(10, task.getIsPublic());
         
         if(task.getCurrentStatus() != null)
         {   
            pstmt.setInt(11, task.getCurrentStatus().getId());
         }
         else
         {   
            pstmt.setInt(11, -1);
         }
         
         pstmt.setTimestamp(12, new Timestamp(Calendar.getInstance().getTimeInMillis()));
         pstmt.setInt(13, task.getAssignedTo());
         
         pstmt.executeUpdate();
         
         //
         // retrieve and return the id..
         //
         pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from tasks", 
               ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            taskId = rs.getInt(1);
            task.setId(taskId);
         }
        
         if(task.getTaskReminder() != null)
         {
            // CREATE A REMINDER ENTRY.
         }
         
         //
         // Custom Fields (add any occurences on the create operation..)
         //
         try
         {
            if (task.getCustomFields() != null && task.getCustomFields().length > 0)
            {
               ICustomFieldManager cfm = new CustomFieldManager();
               CustomField[] customFields = task.getCustomFields();
               for (int i = 0; i < customFields.length; i++)
               {
                  cfm.addCustomField(task, customFields[i]);
               }
            }
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
         
         //
         // NamedFieldCollections
         //
         try
         {
            if (task.getNamedFieldCollections() != null && task.getNamedFieldCollections().length > 0)
            {
               INamedFieldCollectionManager ncm = new NamedFieldCollectionManager();
               NamedFieldCollection[] collections = task.getNamedFieldCollections();
               for (int i = 0; i < collections.length; i++)
               {
                  ncm.addNamedFieldCollection(task, collections[i]);
               }
            }
         }
         catch (Exception e)
         {
            e.printStackTrace();
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
      
      return taskId;
   }

   /*public int addToDo(ToDo todo)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   /*public int addToDo(Event event, ToDo todo, int projectId)
   throws Exception
   {
      if(todo != null)
      {
         todo.setProjectId(projectId);
         return addToDo(todo);
      }
      return -1;
   }*/

   /*public int addToDo(ToDo todo, int projectId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public void dropToDo(Event event, int todoId)
   public synchronized void dropTask(int taskId)
      throws Exception
   {
      Connection connection = null;
      
      try
      {
         // TODO: Determine expense of adding a task-retrieval + field deletion in this method.
         Task dropTask = this.getTask(taskId);
         
         if (dropTask != null)
         {   
            connection = ConnectionManager.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("delete from tasks where id=?");
            pstmt.setInt(1, taskId);
            pstmt.executeUpdate();
            
            pstmt.close();
            
            //
            // Handle Custom Fields
            //
            CustomField[] fields = dropTask.getCustomFields();
            if (fields != null && fields.length > 0)
            {
               ICustomFieldManager cfm = new CustomFieldManager();
               
               for (int i = 0; i < fields.length; i++)
               {
                  try
                  {
                     cfm.dropCustomField(fields[i].getId());
                  }
                  catch(Exception e)
                  {
                     e.printStackTrace();
                  }
               }
            }
            
            //
            // Handle NamedFieldCollections
            //
            NamedFieldCollection[] collections = dropTask.getNamedFieldCollections();
            if (collections != null && collections.length > 0)
            {
               INamedFieldCollectionManager ncm = new NamedFieldCollectionManager();
               
               for (int i = 0; i < collections.length; i++)
               {
                  try
                  {
                     ncm.dropNamedFieldCollection(collections[i].getId());
                  }
                  catch (Exception e)
                  {
                     e.printStackTrace();
                  }
               }
            }
         }
      }
      catch(SQLException se)
      {
         se.printStackTrace();
         
         throw new Exception(se.getMessage());
      }
      catch(Exception e)
      {
         e.printStackTrace();
         
         throw new Exception(e.getMessage());
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

   /*public void dropToDo(int todoId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public void modifyToDo(Event event, ToDo todo)
   public synchronized void modifyTask(Task task)
      throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("update tasks set " +
                  "project_id=?, " +
                  "title=?, " +
                  "created_by=?, " +
                  "created_on=?, " +
                  "description=?, " +
                  "due_date=?, " +
                  "flag=?, " +
                  "is_public=?, " +
                  "current_status=?, " +
                  "last_modified=?, " +
                  "assigned_to=? " +
                  "where id=?");
         
         // Project ID
         pstmt.setInt(1, task.getProjectId());
         // Title
         pstmt.setString(2, task.getTitle());
         // CreatedBy
         pstmt.setInt(3, task.getCreatedBy());    
         // CreatedOn
         pstmt.setTimestamp(4, new Timestamp(task.getCreatedOn().getTimeInMillis()));       
         // Description
         pstmt.setString(5, task.getDescription());       
         
         // Due Date
         if(task.getDueDate() != null)
            pstmt.setTimestamp(6, new Timestamp(task.getDueDate().getTimeInMillis()));
         else
            pstmt.setTimestamp(6, null);
          
         // Flag
         pstmt.setInt(7, task.getFlag());
         
         // Is Public
         pstmt.setBoolean(8, task.getIsPublic());         
         
         // Current Status
         if (task.getCurrentStatus() != null)
         {   
            pstmt.setInt(9, task.getCurrentStatus().getId());        
         }
         else
         {
            // TODO: This is dumb. We shouldnt be instering a -1 and relying on the handling of a flag to
            // communicate that the status is null. The Data Model supports a null field for this.
            // The correct handling would be to modify the SQL statement and execute a differant statement
            // when differant parameters are initialized in the Object Model.
            
            pstmt.setInt(9, -1);
         }
         
         // Last Modified
         pstmt.setTimestamp(10, new Timestamp(Calendar.getInstance().getTimeInMillis()));
         
         // assigned to
         pstmt.setInt(11, task.getAssignedTo());
           
         pstmt.setInt(12, task.getId()); // where clause
         
         pstmt.executeUpdate();
         
         pstmt.close();
         
         //
         // Custom Fields...
         //
         CustomField[] fields = task.getCustomFields();
         if (fields !=  null && fields.length > 0)
         {   
            ICustomFieldManager cfm = new CustomFieldManager();
            
            for (int i = 0; i < fields.length; i++)
            {   
               try
               {
                  cfm.modifyCustomField(task, fields[i]);
               }
               catch(Exception e)
               {
                  e.printStackTrace();
               }
            }
         }
         
         //
         // Named Collections...
         //
         NamedFieldCollection[] fieldCollections = task.getNamedFieldCollections();
         if (fieldCollections != null && fieldCollections.length > 0)
         {
            INamedFieldCollectionManager collectionManager = new NamedFieldCollectionManager();
            
            for (int i = 0; i < fieldCollections.length; i++)
            {
               try
               {
                  collectionManager.modifyNamedFieldCollection(fieldCollections[i]);
               }
               catch (Exception e)
               {
                  e.printStackTrace();
               }
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

   /*public void modifyToDo(ToDo todo)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public ToDo getToDo(Event event, int todoId)
   public synchronized Task getTask(int taskId)
   throws Exception
   {
      Connection connection = null;
      Task task = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("select " +
                  "project_id, " +
                  "title, " +
                  "created_by, " +
                  "created_on, " +
                  "description, " +
                  "due_date, " +
                  "flag, " +
                  "is_public, " +
                  "current_status, " +
                  "last_modified, " +
                  "assigned_to " +
                  "from tasks where id=?", 
                  ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         
         pstmt.setInt(1, taskId);
         
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            task = new Task();
            
            // ID
            task.setId(taskId);
            // Project ID
            task.setProjectId(rs.getInt(1));
            // Title
            task.setTitle(rs.getString(2));
            // Created By
            task.setCreatedBy(rs.getInt(3));
            
            // Created On
            if(rs.getTimestamp(4) != null)
            {
               Calendar cal = new GregorianCalendar();
               cal.setTime(rs.getTimestamp(4));
               task.setCreatedOn(cal);
            }
            
            // Description
            task.setDescription(rs.getString(5));
            
            // Due Date
            if(rs.getTimestamp(6) != null)
            {
               Calendar clDueDate = new GregorianCalendar();
               clDueDate.setTime(rs.getDate(6));
               task.setDueDate(clDueDate);
            }
            
            // Flag
            task.setFlag(rs.getInt(7));
            // Is Public
            task.setIsPublic(rs.getBoolean(8));
            // Current Status
            task.setCurrentStatus(getTaskStatus(rs.getInt(9)));//event, rs.getInt(9)));
            
            // Last Modified
            if(rs.getTimestamp(10) != null)
            {
               Calendar clLastModified = new GregorianCalendar();
               clLastModified.setTime(rs.getTimestamp(10));
               task.setLastModified(clLastModified);
            }
            
            // Assigned To
            task.setAssignedTo(rs.getInt(11));
            
            // Custom Fields...
            ICustomFieldManager cfm = new CustomFieldManager();
            task.setCustomFields(cfm.getAllCustomFieldsForObject(task));
            
            //
            // NamedFieldCollections
            //
            INamedFieldCollectionManager nfcm = new NamedFieldCollectionManager();
            task.setNamedFieldCollections(nfcm.getAllNamedFieldCollectionsForObject(task));
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
      
      return task;
   }

   /*public ToDo getToDo(int todoId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public ToDo[] getAllToDos(Event event)
   public synchronized Task[] getAllTasks()
   throws Exception
   {
      return null;
   }

   /*public ToDo[] getAllToDos()
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public ToDo[] getAllToDosForProject(Event event, int projectId)
   public synchronized Task[] getAllTasksForProject(int projectId)
   throws Exception
   {
      Connection connection = null;
      List todos = new Vector();

      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id from tasks where project_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, projectId);
   
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            todos.add(getTask(rs.getInt(1)));//event, rs.getInt(1)));
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

      return (Task[])todos.toArray(new Task[todos.size()]);
   }

   /*public ToDo[] getAllToDosForProject(int projectId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/

   
   //
   // ToDo Status
   //
   
   /* the "is_global" field determines if this is a dommoni status (true) or,
   a status created by the customer, which is false. only customer
   created entries can be deleted.
  */
   //public int addToDoStatus(Event event, ToDoStatus status)
   public synchronized int addTaskStatus(TaskStatus status)
   throws Exception
   {
      Connection connection = null;
      int todoStatusId = -1;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("insert into task_status (project_id,title,is_global) values (?,?,?)");
         pstmt.setInt(1, status.getProjectId());
         pstmt.setString(2, status.getTitle());
         
         // variable not available in the object. only non-dommoni todos can be deleted
         pstmt.setBoolean(3, false);
         
         pstmt.executeUpdate();
         
         //
         // retrieve and return the id..
         //
         pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from task_status", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            todoStatusId = rs.getInt(1);
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
               connection.close();
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      
      return todoStatusId;
   }

   /*public int addToDoStatus(ToDoStatus status)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public int addToDoStatus(Event event, ToDoStatus status, int projectId)
   public synchronized int addTaskStatus(TaskStatus status, int projectId)
   throws Exception
   {
      if(status != null)
      {
         status.setProjectId(projectId);
         return addTaskStatus(status);
      }
      return -1;
   }

   /*public int addToDoStatus(ToDoStatus status, int projectId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public void dropToDoStatus(Event event, int statusId)
   public synchronized void dropTaskStatus(int statusId)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         // first find out if it's protected
         connection = ConnectionManager.getConnection();
         PreparedStatement getGlobal = connection.prepareStatement("select is_global from task_status where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         getGlobal.setInt(1, statusId);
         ResultSet rsGetGlobal = getGlobal.executeQuery();
         if(rsGetGlobal.first() && !rsGetGlobal.getBoolean(1))
         {
            PreparedStatement pstmt = connection.prepareStatement("delete from task_status where id=?");
            pstmt.setInt(1, statusId);
            pstmt.executeUpdate();
            
            pstmt.close();
         }
         
         rsGetGlobal.close();
         getGlobal.close();
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
               connection.close();
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
   }

   /*public void dropToDoStatus(int statusId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public void modifyToDoStatus(Event event, ToDoStatus status)
   public synchronized void modifyTaskStatus(TaskStatus status)
   throws Exception
   {
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("update task_status set title=? where id=?");
         pstmt.setString(1, status.getTitle());
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
               connection.close();
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
   }

   /*public void modifyToDoStatus(ToDoStatus status)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/

   //public ToDoStatus getToDoStatus(Event event, int statusId)
   public synchronized TaskStatus getTaskStatus(int statusId)
   throws Exception
   {
      Connection connection = null;
      TaskStatus status = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("select id,project_id,title from task_status where id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         pstmt.setInt(1, statusId);
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            status = new TaskStatus();
            status.setId(rs.getInt("id"));
            status.setProjectId(rs.getInt("project_id"));
            status.setTitle(rs.getString("title"));
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
      return status;
   }

   /*public ToDoStatus getToDoStatus(int statusId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public ToDoStatus[] getAllToDoStatusForProject(Event event, int projectId)
   public synchronized TaskStatus[] getAllTaskStatusForProject(int projectId)
   throws Exception
   {
      Connection connection = null;
      List todoStatus = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         
         PreparedStatement psGetGlobals = connection.prepareStatement("select id from task_status where is_global=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         psGetGlobals.setBoolean(1, true);
         ResultSet rs = psGetGlobals.executeQuery();
         
         while(rs.next())
         {
            todoStatus.add(getTaskStatus(rs.getInt(1)));//event, rs.getInt(1)));
         }
         
         rs.close();
         psGetGlobals.close();
         
         PreparedStatement psGetProject = connection.prepareStatement("select id from task_status where project_id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         psGetProject.setInt(1, projectId);
         ResultSet prRs = psGetProject.executeQuery();
         while(prRs.next())
         {
            todoStatus.add(getTaskStatus(rs.getInt(1)));//event, rs.getInt(1)));
         }
         
         prRs.close();
         psGetProject.close();
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
      
      // first, get the globals, then get the per project todos
      
      return (TaskStatus[])todoStatus.toArray(new TaskStatus[todoStatus.size()]);
   }
   
   /*public ToDoStatus[] getAllToDoStatusForProject(int projectId)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/

   
   // Comment Convenience Methods
   //public int addCommentForToDo(Event event, ToDo todo, Comment comment)
   public synchronized int addCommentForTask(Task task, Comment comment) 
   throws Exception
   {
      CommentManager commentManager = new CommentManager();
      return commentManager.addComment(task, comment);
   }

   /*public int addCommentForToDo(ToDo todo, Comment comment) 
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   //public Comment[] getCommentsForToDo(Event event, ToDo todo)
   
   public synchronized Comment[] getCommentsForTask(Task task)
   throws Exception
   {
      CommentManager commentManager = new CommentManager();
      return commentManager.getCommentsForObject(task);
   }
   
   /*public Comment[] getCommentsForToDo(ToDo todo)
   throws Exception
   {
      throw new ContextNotFoundException();
   }*/
   
   //--------------------------------------------------------------------------
   // Custom Fields...
   //
   
   public synchronized int addCustomFieldForTask(Task task, CustomField customField)
      throws Exception
   {
      ICustomFieldManager cfm = new CustomFieldManager();
      return cfm.addCustomField(task, customField);
   }
   
   public synchronized CustomField[] getAllCustomFieldsForTask(Task task)
      throws Exception
   {
      ICustomFieldManager cfm = new CustomFieldManager();
      return cfm.getAllCustomFieldsForObject(task);
   }
   
   //--------------------------------------------------------------------------
   // Named Field Collections...
   //
   // TODO: Determine if these should be removed. All operations on the 'inner services' should
   // be accessed through the respective service. So... to add a NFC to a task, call modify task,
   // with the new nfc as a member.
   //
   public synchronized int addNamedFieldCollectionForTask(Task task, NamedFieldCollection customFieldCollection)
      throws Exception 
   {
      INamedFieldCollectionManager nfcm = new NamedFieldCollectionManager();
      return nfcm.addNamedFieldCollection(task, customFieldCollection);
   }
   
   public synchronized NamedFieldCollection[] getAllNamedFieldCollectionsForTask(Task task)
      throws Exception 
   {
      INamedFieldCollectionManager nfcm = new NamedFieldCollectionManager();
      return nfcm.getAllNamedFieldCollectionsForObject(task);
   }
}
/*
 * 
 * $Log: ToDoManager.java,v $
 * Revision 1.2  2005/03/26 19:27:35  brian
 * no message
 *
 * Revision 1.1.1.1  2005/03/14 21:02:40  Brian Abbott
 * no message
 *
 * 
 */
