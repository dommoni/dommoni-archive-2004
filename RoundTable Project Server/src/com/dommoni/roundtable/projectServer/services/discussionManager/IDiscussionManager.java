/*
 * Created on May 15, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.discussionManager;

import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.Discussion;
import com.dommoni.roundtable.Document;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface IDiscussionManager
{
   public int addDiscussion(Discussion discussion)
   throws Exception;

   public void dropDiscussion(int discussionId)
   throws Exception;
   
   public Discussion getDiscussion(int discussionId)
   throws Exception;
   
   public Discussion[] getAllDiscussionsForProject(int projectId)
   throws Exception;
   
   // Comment convenience methods
   public int addCommentForDiscussion(Discussion discussion, Comment comment)
   throws Exception;
   
   public Comment[] getCommentsForDiscussion(Discussion discussion)
   throws Exception;
   
   //getServiceContext()
}
