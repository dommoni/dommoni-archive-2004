/*
 * Created on Jan 1, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.ece.webui.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dommoni.ece.webui.MultipartRequestHandler;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.Discussion;
import com.dommoni.roundtable.Document;
import com.dommoni.roundtable.Forum;
import com.dommoni.roundtable.Meeting;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Task;
import com.dommoni.roundtable.projectServer.services.commentManager.ICommentManager;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CommentController
{
   public void addComment(MultipartRequestHandler mrh, HttpServletResponse response)
   {
      try
      {
         String commentText = mrh.getParameter("commenttext");
         String name = mrh.getParameter("name");
         String opparam = mrh.getParameter("opparam");
         String context = mrh.getParameter("context");
         String parentLink = mrh.getParameter("parentlink");
         
         ProjectServerConnection psc = (ProjectServerConnection)((HttpServletRequest)mrh.getRequest()).getSession().getAttribute("psc");
         
         int objId = Integer.parseInt(opparam);
         
         Comment comment = new Comment();
         comment.setProjectId(psc.getCurrentProject().getId());
         comment.setObjectId(objId);
         comment.setContext(context.toUpperCase());
         comment.setCreatedBy(psc.getAccount().getId());
         comment.setComment(commentText);
         //comment.setAttachements();
         
         //if(context.equalsIgnoreCase("account")) {}
         //else 
         if(context.equalsIgnoreCase("discussion")) {
            psc.getDiscussionManager();
         }
         else if(context.equalsIgnoreCase("document")) 
         {
            Document doc = psc.getDocumentManager().getDocumentShallow(objId);
            psc.getDocumentManager().addCommentForDocument(doc, comment);
         }
         else if(context.equalsIgnoreCase("forum")) 
         {
            // NO COMMENTS FOR FORUMS
            //Forum forum = psc.getForumManager().getForum(objId);
            //psc.getForumManager().addCommentForForum();
         }
         else if(context.equalsIgnoreCase("meeting")) 
         {
            Meeting meeting = psc.getMeetingManager().getMeeting(objId);
            psc.getMeetingManager().addCommentForMeeting(meeting, comment);
         }
         //else if(context.equalsIgnoreCase("project")) {}
         else if(context.equalsIgnoreCase("task")) 
         {
            Task todo = psc.getTaskManager().getTask(objId);
            psc.getTaskManager().addCommentForTask(todo, comment);
         }
         
         try
         {   
            String returnParam = createReturnParam(context);
            response.sendRedirect("../projectConfirmAddCommentDlgSuccess.jsp?parentlink=" + parentLink + "&paramlabel=" + returnParam + "&param="+opparam);
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void deleteComment(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
         int commentId = Integer.parseInt(request.getParameter("commentid"));
         String parentLink = request.getParameter("parentlink");
         
         ProjectServerConnection psc = 
            (ProjectServerConnection)request.getSession().getAttribute("psc");
         ICommentManager commentManager = psc.getCommentManager();
         commentManager.dropComment(commentId); 
         
         response.sendRedirect("../projectConfirmDeleteCommentDlgSuccess.jsp?parentlink=" + parentLink);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   private String createReturnParam(String context)
   {
      // Generate return param (i.e. documentid, forumid, etc.)
      // very lame. 
      if(context.equalsIgnoreCase("discussion")) {return "discussionid";}
      else if(context.equalsIgnoreCase("document")) {return "documentId";}
      else if(context.equalsIgnoreCase("forum")) {return "forumid";}
      else if(context.equalsIgnoreCase("meeting")) {return "meetingid";}
      else if(context.equalsIgnoreCase("task")) {return "todoid";}
      else {return "";}
   }
}
/*
 * 
 * $Log: CommentController.java,v $
 * Revision 1.2  2005/10/16 06:01:19  brian
 * Changes for supporting RoundTable API ToDo->Task renaming.
 *
 * 
 */
