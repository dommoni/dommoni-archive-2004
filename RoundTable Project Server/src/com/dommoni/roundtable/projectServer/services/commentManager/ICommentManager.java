/*
 * Created on Dec 23, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.services.commentManager;

import com.dommoni.roundtable.Comment;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface ICommentManager
{
   public int addComment(Object parentObj, Comment comment)
   throws Exception;
   
   public void dropComment(int commentId)
   throws Exception;
   
   public void modifyComment(Object parentObj, Comment comment)
   throws Exception;
   
   public Comment[] getCommentsForObject(Object parentObj)
   throws Exception;
}
