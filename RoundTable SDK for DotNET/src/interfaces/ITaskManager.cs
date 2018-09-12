/*
 * ITaskManager, was IToDoManager.cs
 * 
 * Created on Mar 17, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;

namespace RoundTable.ProjectServer.Services.TaskManager
{
	/// <summary>
	/// Summary description for IToDoManager.
	/// </summary>
	public interface ITaskManager
	{
		//
		// Task Operations...
		//
		int addTask(Task task);
   
		void dropTask(int taskId);
   
		void modifyTask(Task task);
   
		Task getTask(int taskId);
   
		Task[] getAllTasks();
   
		Task[] getAllTasksForProject(int projectId);
   
		//
		// ToDoStatus Operations
		//
   
		/**
		 * Allows you to add custom Status Settings to
		 * the RoundTable System.
		 * 
		 */
		int addTaskStatus(TaskStatus status);
   
		int addTaskStatus(TaskStatus status, int projectId);
   
		/**
		 * Deletes a status setting. 
		 */
		void dropTaskStatus(int statusId);
  
		void modifyTaskStatus(TaskStatus status);
   
		TaskStatus getTaskStatus(int statusId);
   
		TaskStatus[] getAllTaskStatusForProject(int projectId);
   
		// Comment Convenience Methods
		int addCommentForTask(Task task, Comment comment);
   
		Comment[] getCommentsForTask(Task task);
	}
}
/*
 * 
 * $Log: IToDoManager.cs,v $
 * Revision 1.1  2005/03/20 15:49:27  brian
 * Initial Revision.
 *
 * 
 */