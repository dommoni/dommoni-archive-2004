package com.dommoni.ece.webui;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dommoni.ece.webui.controllers.*;

public class ControllerServlet extends HttpServlet
{
   AccountController accountController = new AccountController();
   AnnouncementController announcementController = new AnnouncementController();
   AttachmentController attachmentController = new AttachmentController();
   CommentController commentController = new CommentController();
   DiscussionController discussionController = new DiscussionController();
   DocumentController documentController = new DocumentController();
   ForumController forumController = new ForumController();
   LogController logController = new LogController();
   MeetingController meetingController = new MeetingController();
   NotificationController notificationController = new NotificationController();
   ProjectController projectController = new ProjectController();
   ScheduleController scheduleController = new ScheduleController();
   TaskController todoController = new TaskController();
   
   LoginHandler loginHandler = new LoginHandler();
   MenuController menuController;
   
   public void doPost(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
         if(request.getContentType() != null && request.getContentType().startsWith("multipart/form-data"))
         {
            try
            {
               MultipartRequestHandler mrh = new MultipartRequestHandler(request);//, 10 * 1024 * 1024);  
               
               Integer opcode = new Integer(mrh.getParameter("opcode"));
               
               if(opcode != null)
               {
                  System.out.println("Doing MP: " + opcode);
                  switch(opcode.intValue())
                  {
                  case Operations.UPLOAD_DOCUMENT:
                     documentController.uploadDocument(mrh, request.getSession(), response);
                     break;
                     
                  case Operations.UPDATE_PROFILE:
                     accountController.updateProfile(mrh, request.getSession(), response);
                     break;
                     
                  case Operations.CREATE_COMMENT:
                     commentController.addComment(mrh, response);
                     break;
                     
                  case Operations.CREATE_ANNOUNCEMENT:
                     announcementController.createAnnouncement(mrh, request.getSession(), response);
                     break;
                     
                  case Operations.CREATE_FILE_ATTACHMENT:
                     attachmentController.createFileAttachment(mrh, request.getSession(), response);
                     break;
                  }
               }
            }
            catch(IOException ioe)
            {
               ioe.printStackTrace();
            }
         }
         else
         {
            Integer opcode = new Integer(request.getParameter("opcode"));
            menuController = (MenuController)request.getSession().getAttribute("mc");
         
            if(opcode != null)
            {
               switch(opcode.intValue())
               {
               
               //
               // Project Operations
               //
               case Operations.CREATE_PROJECT:
                  projectController.createProject(request, response);
                  break;
      
               case Operations.DELETE_PROJECT:
                  projectController.deleteProject(request, response);
                  break;
                  
               case Operations.EDIT_PROJECT:
                  projectController.editProject(request, response);   
                  break;
      
               case Operations.SET_PROJECT:
                  projectController.setCurrentProject(request, response, menuController);
                  break;
                  
               case Operations.CLOSE_PROJECT:
                  projectController.closeProject(request, response, menuController);
                  break;
      
               //
               // Account Operations
               //
               case Operations.CREATE_ACCOUNT:
                  accountController.createAccount(request, response);
                  break;
      
               case Operations.DELETE_ACCOUNT:
                  accountController.deleteAccount(request, response);
                  break;
      
               case Operations.EDIT_ACCOUNT:
                  accountController.editAccount(request, response);
                  break;
                  
               //
               // Document Operations
               //
               case Operations.DOWNLOAD_DOCUMENT:
                  documentController.downloadDocument(request, response);
                  break;
                  
               case Operations.DELETE_DOCUMENT:
                  documentController.deleteDocument(request, response);
                  break;
                  
               case Operations.EDIT_DOCUMENT:
                  documentController.editDocument(request, response);
                  break;
                  
               //
               // Meeting Operations
               //
               case Operations.CREATE_MEETING:
                  meetingController.createMeeting(request, response, menuController);
                  break;
                  
               case Operations.DELETE_MEETING:
                  meetingController.deleteMeeting(request, response);
                  break;
                  
               case Operations.EDIT_MEETING:
                  meetingController.editMeeting(request, response);
                  break;
                  
               //
               // Notification Operations
               //
               case Operations.CREATE_NOTIFICATION:
                  notificationController.createNotification(request, response);
                  break;
                  
               case Operations.DELETE_NOTIFICATION: 
                  notificationController.deleteNotification(request, response);
                  break;  
                  
               //
               // ToDo Operations
               //
               case Operations.CREATE_TODO:
                  todoController.createToDo(request, response, menuController);
                  break;
                  
               case Operations.DELETE_TODO:
                  todoController.deleteToDo(request, response);
                  break;
                  
               case Operations.EDIT_TODO:
                  todoController.editToDo(request, response);
                  break; 
                  
               //
               // Discussion Operations
               //
               case Operations.DELETE_DISCUSSION:
                  discussionController.deleteDiscussion(request, response);
                  break;
                  
               //
               // Forum Operations
               //
               case Operations.CREATE_FORUM:
                  forumController.createForum(request, response);
                  break;
                  
               case Operations.POST_FORUM_REPLY:
                  forumController.postForumReply(request, response);
                  break;
                  
               case Operations.DELETE_FORUM:
                  forumController.deleteForum(request, response);
                  break;
                  
               case Operations.EDIT_FORUM:
                  forumController.editForum(request, response);
                  break;
                
               //
               // Account Settings Operations
               //  
               case Operations.SAVE_SETTINGS:
                  accountController.saveAccountSettings(request, response);
                  break;
                  
               case Operations.CHANGE_PASSWORD:
                  accountController.changePassword(request, response);
                  break;
                  
               //
               // Comment/Announcement Operations
               //
               case Operations.DELETE_COMMENT:
                  commentController.deleteComment(request, response);
                  break;
                  
               //
               // Attachment Operations
               //
               case Operations.DELETE_FILE_ATTACHMENT:
                  attachmentController.deleteFileAttachment(request, response);
                  break;
               
               case Operations.MODIFY_FILE_ATTACHMENT:
                  attachmentController.modifyFileAttachment(request, response);
                  break;
               
               case Operations.CREATE_OBJECT_ATTACHMENT:
                  attachmentController.createObjectAttachment(request, response);
                  break;
               
               case Operations.DELETE_OBJECT_ATTACHMENT:
                  attachmentController.deleteObjectAttachment(request, response);
                  break;
               
               case Operations.MODIFY_OBJECT_ATTACHMENT:
                  attachmentController.modifyObjectAttachment(request, response);
                  break;
                 
               //
               // Schedule Operations
               //
               case Operations.CREATE_SCHEDULE:
                  scheduleController.createSchedule(request, response);
                  break;
                  
               case Operations.DELETE_SCHEDULE:
                  scheduleController.deleteSchedule(request, response);
                  break;
                  
               case Operations.MODIFY_SCHEDULE:
                  scheduleController.modifySchedule(request, response);
                  break;
      
               //
               // Log Operations
               //
               case Operations.GENERATE_LOG_REPORT:
                  logController.generateLogReport(request, response);
                  break;
               
               case Operations.EXPORT_LOG_REPROT_XLS:
                  logController.exportLogReportAsXls(request, response);
                  break;
               
               case Operations.EXPORT_LOG_REPROT_CSV:
                  break;
               
               case Operations.EXPORT_LOG_REPROT_PDF:
                  break;
                  
               //
               // Miscellaneous Operations
               //
               case Operations.HANDLE_MENU:
                  menuController.handleMenuRequest(request, response);
                  break;
      
               case Operations.LOGIN:
                  loginHandler.handleLoginRequest(request, response);
                  break;
      
               case Operations.LOGOUT:
                  loginHandler.handleLogoutRequest(request, response);
                  break;
      
               default:
                  // need to throw an error of some type. 
                  break;
               }
            }
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
         
         // our session's probably expired... forward to the login page
         try
         {
            response.sendRedirect("../login.jsp");
         }
         catch(IOException ioe)
         {
            ioe.printStackTrace();
         }
      }
   }

   public void doGet(HttpServletRequest request, HttpServletResponse response)
   {
      doPost(request, response);
   }
}
/*
 * 
 * $Log: ControllerServlet.java,v $
 * Revision 1.2  2005/10/16 03:14:48  brian
 * Added support for attachments and schedules.
 *
 * 
 */
