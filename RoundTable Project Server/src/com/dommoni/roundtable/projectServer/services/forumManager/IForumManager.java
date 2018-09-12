/*
 * Created on Jul 10, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.services.forumManager;

import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.Document;
import com.dommoni.roundtable.Forum;
import com.dommoni.roundtable.ForumReply;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public interface IForumManager
{
   public int addForum(Forum forum)
   throws Exception;
   
   /*public int addForum(Forum forum, int projectId)
   throws Exception;
   */
   public void dropForum(int forumId)
   throws Exception;
   
   public void modifyForum(Forum forum)
   throws Exception;
   
   public Forum getForum(int forumId)
   throws Exception;
   
   public Forum[] getAllForumsForProject(int projectId)
   throws Exception;
   
   public void addForumReply(ForumReply forumReply)
   throws Exception;
   
   public ForumReply[] getAllRepliesForForum(int forumId)
   throws Exception;
   
   // Comment Convenience Methods
   public int addCommentForForum(Forum forum, Comment comment)
   throws Exception;
   
   //public void dropCommentForForum(Forum forum, Comment comment);
   
   public Comment[] getCommentsForForum(Forum forum)
   throws Exception;
}