/*
 * Created on Jan 17, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.ece.webui.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dommoni.ece.webui.MultipartRequestHandler;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Announcement;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AnnouncementController
{
   public void createAnnouncement(MultipartRequestHandler mrh, HttpSession session, HttpServletResponse response)
   {
      try
      {
         String title = mrh.getParameter("title");
         String text = mrh.getParameter("message");
         
         Account userAccount = (Account)session.getAttribute("useraccount");
         Project currentProject = (Project)session.getAttribute("currentproject");
         ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
         
         Announcement announcement = new Announcement();
         announcement.setProjectId(currentProject.getId());
         announcement.setCreatedBy(userAccount.getId());
         announcement.setTitle(title);
         announcement.setText(text);
         
         psc.getAnnouncementManager().addAnnouncement(announcement);
         
         try
         {
            response.sendRedirect("../projectAnnouncementsConfirmAddAnnouncementSuccess.jsp?parentlink=projectMain.jsp");
         }
         catch(Exception e)
         {
            e.printStackTrace();
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void deleteAnnouncement()
   {
      
   }
}
