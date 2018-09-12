/*
 * Created on Aug 1, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.ece.webui.controllers;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Forum;
import com.dommoni.roundtable.ForumReply;
import com.dommoni.roundtable.ProjectServerConnection;

import com.dommoni.roundtable.projectServer.services.forumManager.IForumManager;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ForumController
{
   public void createForum(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
         String subject = request.getParameter("subject");
         String message = request.getParameter("message");
         int accountId = Integer.parseInt(request.getParameter("accountid"));
         int projectId = Integer.parseInt(request.getParameter("projectid"));
         
         Forum forum = new Forum();
         forum.setCreatedBy(accountId);
         forum.setProjectId(projectId);
         forum.setSubject(subject);
         forum.setMessage(message);
         
         ProjectServerConnection psc = (ProjectServerConnection)request.getSession().getAttribute("psc");
         psc.getForumManager().addForum(forum);
         
         try
         {
            response.sendRedirect("../projectForums.jsp");
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
   
   public void postForumReply(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
         int forumId = Integer.parseInt(request.getParameter("forumid"));
         String replyMessage = request.getParameter("replymessage");
         
         ProjectServerConnection psc = 
            (ProjectServerConnection)request.getSession().getAttribute("psc");
         
         Account account = (Account)request.getSession().getAttribute("useraccount");
         
         ForumReply reply = new ForumReply();
         reply.setAccountId(account.getId());
         reply.setForumId(forumId);
         reply.setTimestamp(Calendar.getInstance());
         reply.setReply(replyMessage);
         
         IForumManager forumManager = psc.getForumManager();
         forumManager.addForumReply(reply);
         
         try
         {
            response.sendRedirect("../projectForumsViewForum.jsp?forumid=" + forumId);
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
   
   public void deleteForum(HttpServletRequest request, HttpServletResponse response)
   {
      String szForumid = request.getParameter("forumid");
      String szParentLink = request.getParameter("parentlink");
      
      try
      {
         ProjectServerConnection psc = 
            (ProjectServerConnection)request.getSession().getAttribute("psc");
         psc.getForumManager().dropForum(Integer.parseInt(szForumid));
      
         try
         {   
            response.sendRedirect("../projectConfirmDeleteDlgSuccess.jsp?parentlink=" + szParentLink);
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
   
   public void editForum(HttpServletRequest request, HttpServletResponse response)
   {
      String szForumId = request.getParameter("forumid");
      String subject = request.getParameter("subject");
      String message = request.getParameter("message");
      
      try
      {
         int forumId = Integer.parseInt(szForumId);
         ProjectServerConnection psc = (ProjectServerConnection)request.getSession().getAttribute("psc");
         Forum forum = psc.getForumManager().getForum(forumId);
         
         forum.setSubject(subject);
         forum.setMessage(message);
         
         psc.getForumManager().modifyForum(forum);
         
         try
         {
            response.sendRedirect("../projectForumsViewForum.jsp?forumid=" + szForumId);
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
}
