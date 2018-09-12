/*
 * IForumManager.cs
 * 
 * Created on Mar 17, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;

namespace RoundTable.ProjectServer.Services.ForumManager
{
	/// <summary>
	/// Summary description for IForumManager.
	/// </summary>
	public interface IForumManager
	{
		int addForum(Forum forum);
   
		void dropForum(int forumId);
   
		void modifyForum(Forum forum);
   
		Forum getForum(int forumId);
   
		Forum[] getAllForumsForProject(int projectId);
   
		void addForumReply(ForumReply forumReply);
   
		ForumReply[] getAllRepliesForForum(int forumId);
   
		// Comment Convenience Methods
		//int addCommentForForum(Forum forum, Comment comment);
   
		//Comment[] getCommentsForForum(Forum forum);
	}
}
/*
 * 
 * $Log: IForumManager.cs,v $
 * Revision 1.1  2005/03/20 15:49:26  brian
 * Initial Revision.
 *
 * 
 */