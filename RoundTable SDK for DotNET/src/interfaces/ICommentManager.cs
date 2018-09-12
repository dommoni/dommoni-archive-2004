/*
 * ICommentManager.cs
 * 
 * Created on Mar 17, 2005
 * Author: Brian Abbott
 * 
 * Copyright (c) 2005 Dommoni Corporation. All rights reserved.
 */
using System;

namespace RoundTable.ProjectServer.Services.CommentManager
{
	/// <summary>
	/// Summary description for ICommentManager.
	/// </summary>
	public interface ICommentManager
	{
		int addComment(object parentObj, Comment comment);
   
		void dropComment(int commentId);
   
		void modifyComment(object parentObj, Comment comment);
   
		Comment[] getCommentsForObject(object parentObj);
	}
}
/*
 * 
 * $Log: ICommentManager.cs,v $
 * Revision 1.1  2005/03/20 15:49:26  brian
 * Initial Revision.
 *
 * 
 */