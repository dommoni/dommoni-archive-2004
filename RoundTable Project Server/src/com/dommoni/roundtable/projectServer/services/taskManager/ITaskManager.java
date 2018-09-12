/*
 * Created on Mar 27, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.taskManager;

import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.CustomField;
import com.dommoni.roundtable.NamedFieldCollection;
import com.dommoni.roundtable.NamedFieldTemplate;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.Task;
import com.dommoni.roundtable.TaskStatus;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface ITaskManager
{
   //
   // ToDo Objects...
   //
   public int addTask(Task todo)
   throws Exception;
   
   public void dropTask(int taskId)
   throws Exception;
   
   public void modifyTask(Task task)
   throws Exception;
   
   public Task getTask(int taskId)
   throws Exception;
   
   public Task[] getAllTasks()
   throws Exception;
   
   public Task[] getAllTasksForProject(int projectId)
   throws Exception;
   
   //
   // TaskStatus Operations
   //
   
   /**
    * Allows you to add custom Status Settings to
    * the RoundTable System.
    * 
    */
   public int addTaskStatus(TaskStatus status)
   throws Exception;
   
   public int addTaskStatus(TaskStatus status, int projectId)
   throws Exception;
   
   /**
    * Deletes a status setting. 
    */
   public void dropTaskStatus(int statusId)
   throws Exception;
   
   public void modifyTaskStatus(TaskStatus status)
   throws Exception;
   
   public TaskStatus getTaskStatus(int statusId)
   throws Exception;
   
   public TaskStatus[] getAllTaskStatusForProject(int projectId)
   throws Exception;
   
   // Comment Convenience Methods
   public int addCommentForTask(Task task, Comment comment)
   throws Exception;
   
   public Comment[] getCommentsForTask(Task task)
   throws Exception;
   
   //
   // Custom Value Fields
   //
   public int addCustomFieldForTask(Task task, CustomField customField)
   throws Exception;
   
   public CustomField[] getAllCustomFieldsForTask(Task task)
   throws Exception;
   
   //
   // Named Field Collection
   //
   public int addNamedFieldCollectionForTask(Task task, NamedFieldCollection customFieldCollection)
   throws Exception;
   
   public NamedFieldCollection[] getAllNamedFieldCollectionsForTask(Task task)
   throws Exception;
}
/*
 * 
 * $Log: IToDoManager.java,v $
 * Revision 1.2  2005/03/26 19:27:35  brian
 * no message
 *
 * Revision 1.1.1.1  2005/03/14 21:02:40  Brian Abbott
 * no message
 *
 * 
 */