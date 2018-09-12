/*
 * IDiscussionManager.cs
 * 
 * Created on Mar 17, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;

namespace RoundTable.ProjectServer.Services.DiscussionManager
{
	/// <summary>
	/// Summary description for IDiscussionManager.
	/// </summary>
	public interface IDiscussionManager
	{
		int addDiscussion(Discussion discussion);

		void dropDiscussion(int discussionId);
   
		Discussion getDiscussion(int discussionId);
   
		Discussion[] getAllDiscussionsForProject(int projectId);
   
		// Comment convenience methods
		//int addCommentForDiscussion(Discussion discussion, Comment comment);
   
		//Comment[] getCommentsForDiscussion(Discussion discussion);
	}
}
/*
 * 
 * $Log: IDiscussionManager.cs,v $
 * Revision 1.1  2005/03/20 15:49:26  brian
 * Initial Revision.
 *
 * 
 */