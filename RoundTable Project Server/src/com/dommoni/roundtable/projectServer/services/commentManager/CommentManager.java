/*
 * Created on Dec 23, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.roundtable.projectServer.services.commentManager;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.CommentAttachment;
import com.dommoni.roundtable.Discussion;
import com.dommoni.roundtable.Document;
import com.dommoni.roundtable.Forum;
import com.dommoni.roundtable.Meeting;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.Task;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.events.Event;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CommentManager implements ICommentManager
{
	//public int addComment(Event event, Object parentObj, Comment comment)
   public int addComment(Object parentObj, Comment comment)
   throws Exception
   {
      Connection connection = null;
      int commentId = -1;
      
      // TODO: Need to implment a better way to return a failure.
      if(parentObj == null || comment == null)
         return commentId;
      
      try
      {
         // TODO: add support for rollbacks if anything fails.
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = 
            connection.prepareStatement("insert into comments (" +
                  "project_id," +
                  "object_id," +
                  "context," +
                  "created_by," +
                  "created_on," +
                  "comment) values (?,?,?,?,?,?)");

         
         // Find the correct object: ... TODO: this is hideously ugly, fix it... 
         if(parentObj instanceof Account)
         {
            Account parentAccount = (Account)parentObj;
            
            pstmt.setInt(1, -1);
            pstmt.setInt(2, parentAccount.getId());
            pstmt.setString(3, "ACCOUNT");            
         }
         else if(parentObj instanceof Discussion)
         {
            Discussion parentDiscussion = (Discussion)parentObj;
            
            pstmt.setInt(1, parentDiscussion.getProjectId());
            pstmt.setInt(2, parentDiscussion.getId());
            pstmt.setString(3, "DISCUSSION");            
         }
         else if(parentObj instanceof Document)
         {
            Document parentDocument = (Document)parentObj;
            
            pstmt.setInt(1, parentDocument.getProjectId());
            pstmt.setInt(2, parentDocument.getId());
            pstmt.setString(3, "DOCUMENT");            
         }
         else if(parentObj instanceof Forum)
         {
            Forum parentForum = (Forum)parentObj;
            
            pstmt.setInt(1, parentForum.getProjectId());
            pstmt.setInt(2, parentForum.getId());
            pstmt.setString(3,"FORUM");            
         }
         else if(parentObj instanceof Meeting)
         {            
            Meeting parentMeeting = (Meeting)parentObj;
            
            pstmt.setInt(1, parentMeeting.getProjectId());
            pstmt.setInt(2, parentMeeting.getId());
            pstmt.setString(3, "MEETING");            
         }
         else if(parentObj instanceof Project)
         {
            Project parentProject = (Project)parentObj;
            
            pstmt.setInt(1, -1);
            pstmt.setInt(2, parentProject.getId());
            pstmt.setString(3,"PROJECT");            
         }
         else if(parentObj instanceof Task)
         {
            Task parentToDo = (Task)parentObj;
            
            pstmt.setInt(1, parentToDo.getProjectId());
            pstmt.setInt(2, parentToDo.getId());
            pstmt.setString(3,"TASK");            
         }
         else 
         {
            // TODO: Proble, we currently do not support comments for this object.
            pstmt.close();
            return -1;
         }
         
         pstmt.setInt(4, comment.getCreatedBy());
         pstmt.setTimestamp(5, new Timestamp(Calendar.getInstance().getTimeInMillis()));
         pstmt.setString(6, comment.getComment());
         
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("select IDENTITY_VAL_LOCAL() from comments", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
         ResultSet rs = pstmt.executeQuery();
         if(rs.first())
         {
            commentId = rs.getInt(1);
         }
         
         /*List lstAttachements = comment.getAttachements();
         if(lstAttachements != null && lstAttachements.size() > 0)
         {
            Iterator it = lstAttachements.iterator();
            pstmt = connection.prepareStatement("insert into comment_attachments (comment_id, attachement, filename) values (?,?,?)");
            while(it.hasNext())
            {
               // TODO: Move this to a typed list once we move to Java 5.0
               CommentAttachment att = (CommentAttachment)it.next();
               
               pstmt.setInt(1, att.getCommentId());
               pstmt.setBinaryStream(2, new ByteArrayInputStream(att.getAttachement()), att.getAttachement().length);
               pstmt.setString(3, att.getFilename());
               pstmt.addBatch();
            }
            pstmt.executeBatch();
         }*/

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
      
      return commentId;
   }
   
   /*public int addComment(Object parentObj, Comment comment)
   throws Exception
   {
      return this.addComment(null, parentObj, comment);
   }*/
   
   //public void dropComment(Event event, int commentId)
   public void dropComment(int commentId)
   throws Exception
   {
      // remove the comment and any associated attachements... 
      // TODO: Any Object that's deleted... what about it's comments.
      
      Connection connection = null;
      
      try
      {
         connection = ConnectionManager.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("delete from comments where id=?");
         pstmt.setInt(1, commentId);
         pstmt.executeUpdate();
         
         pstmt = connection.prepareStatement("delete from comment_attachments where comment_id=?");
         pstmt.setInt(1, commentId);
         pstmt.executeUpdate();
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
   
   /*public void dropComment(int commentId)
   throws Exception
   {
      this.dropComment(null, commentId);
   }*/
   
   public void modifyComment(Object parentObj, Comment comment)
   throws Exception
   {
   }
   
   /**
    * Retreives the comments for the passed parameter.
    * 
    * Supported contexts:
    *    - Account
    *    - Discussion
    *    - Document
    *    - Forum
    *    - Meeting
    *    - Project
    *    - ToDo
    */
   //public Comment[] getCommentsForObject(Event event, Object parentObj)
   public Comment[] getCommentsForObject(Object parentObj)
   throws Exception
   {
      Connection connection = null;
      List comments = new Vector();
      
      try
      {
         connection = ConnectionManager.getConnection();
         int objectId = -1;
         String context = "";
         
         if(parentObj instanceof Account)
         {
            objectId = ((Account)parentObj).getId();
            context = "ACCOUNT";
         }
         else if(parentObj instanceof Discussion)
         {
            objectId = ((Discussion)parentObj).getId();
            context = "DISCUSSION";
         }
         else if(parentObj instanceof Document)
         {
            objectId = ((Document)parentObj).getId();
            context = "DOCUMENT";
         }
         else if(parentObj instanceof  Forum)
         {
            objectId = ((Forum)parentObj).getId();
            context = "FORUM";
         }
         else if(parentObj instanceof  Meeting)
         {
            objectId = ((Meeting)parentObj).getId();
            context = "MEETING";
         }
         else if(parentObj instanceof  Project)
         {
            objectId = ((Project)parentObj).getId();
            context = "PROJECT";
         }
         else if(parentObj instanceof Task)
         {
            objectId = ((Task)parentObj).getId();
            context = "TASK";
         }
         else
         {
            // Error, Context not supported.
         }
         
         PreparedStatement pstmt = 
            connection.prepareStatement("select id, project_id, created_by, created_on, comment from comments where context=? and object_id=?");
         pstmt.setString(1, context);
         pstmt.setInt(2, objectId);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
            Comment comment = new Comment();
            comment.setId(rs.getInt(1));        // id 
            comment.setProjectId(rs.getInt(2)); // project_id 
            comment.setCreatedBy(rs.getInt(3)); // created_by 
            if(rs.getTimestamp(4) != null)      // created_on
            {
               Calendar clCreatedOn = Calendar.getInstance();
               clCreatedOn.setTime(rs.getTimestamp(4));
               comment.setCreatedOn(clCreatedOn);
            }
            comment.setComment(rs.getString(5)); // comment
            comment.setContext(context);        // Context
            comment.setObjectId(objectId);
            /*comment.setAttachements(null);
            
            //
            // Attachements
            //
            PreparedStatement attPstmt = connection.prepareStatement("select id,filename,attachement from comment_attachments where comment_id=?");
            attPstmt.setInt(1, comment.getId());
            ResultSet rsAtt = attPstmt.executeQuery();
            List attachements = new Vector();
            
            while(rsAtt.next())
            {
               CommentAttachment attachement = new CommentAttachment();
               attachement.setId(rsAtt.getInt(1));
               attachement.setFilename(rsAtt.getString(2));
               attachement.setCommentId(comment.getId());
               
               attachements.add(attachement);
            }

            if(attachements.size() > 0)
               comment.setAttachements(attachements);
            */
            comments.add(comment);
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
      
      return (Comment[])comments.toArray(new Comment[comments.size()]);
   }
   
   /*public Comment[] getCommentsForObject(Object parentObj)
   throws Exception
   {
      return this.getCommentsForObject(null, parentObj);
   }*/
}
/*
 *
 * $Log: CommentManager.java,v $
 * Revision 1.3  2005/10/17 07:34:29  brian
 * Alterations to handle API refactoring of Todo -> Task.
 *
 * Revision 1.2  2005/03/26 19:25:54  brian
 * no message
 *
 *
 */