/*
 * Created on Apr 12, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.ece.webui.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Meeting;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.projectServer.services.meetingManager.IMeetingManager;

import com.dommoni.ece.webui.MenuController;
import com.dommoni.ece.webui.MenuItem;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class MeetingController
{
   public void createMeeting(HttpServletRequest request, HttpServletResponse response, 
                             MenuController menuController)
   {
      try
      {
         SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
         
         String title = request.getParameter("title");
         String startTime = request.getParameter("starttime");
         String endTime = request.getParameter("endtime");
         String sendInvitation = request.getParameter("sendinvitation");
         String attendeeList[] = request.getParameterValues("list2");
         
         System.out.println("For start time: " + startTime);
         System.out.println("For end time: " + endTime);
         
         Meeting newMeeting = new Meeting();
         newMeeting.setTitle(title);
         
         Project currentProject = (Project)request.getSession().getAttribute("currentproject");
         newMeeting.setProjectId(currentProject.getId());
         
         Account userAccount = (Account)request.getSession().getAttribute("useraccount");
         newMeeting.setCreatedBy(userAccount.getId());
         
         //
         // start time
         //
   
         Date dtStartTime = sdf.parse(request.getParameter("starttime"));
         Calendar clStartTime = Calendar.getInstance();
         clStartTime.setTime(dtStartTime);
         newMeeting.setStartTime(clStartTime);

         System.out.println("Start time were sending out: " + sdf.format(newMeeting.getStartTime().getTime()));
         
          
         //
         // End Time
         //
         try
         {
            Date dtEndTime = sdf.parse(request.getParameter("endtime"));
            Calendar clEndTime = Calendar.getInstance();
            clEndTime.setTime(dtEndTime);
            newMeeting.setEndTime(clEndTime);
            
            System.out.println("End time were sending out: " + sdf.format(newMeeting.getEndTime().getTime()));
         }
         catch(ParseException pe)
         {
            newMeeting.setEndTime(null);
            pe.printStackTrace();
         }   
         
         //
         // Attendees
         //
         if(attendeeList != null && attendeeList.length > 0)
         {
         	int attendees[] = new int[attendeeList.length];
            for(int i = 0; i < attendeeList.length; i++)
            {
               try
               {
                  attendees[i] = Integer.parseInt(attendeeList[i]);
               }
               catch(Exception e)
               {
               	e.printStackTrace();
               }
            }
            newMeeting.setAttendees(attendees);
         }
         
         //
         // Invitations
         //
         if(sendInvitation != null && sendInvitation.equals("yes"))
         {   
            newMeeting.setSendInvitation(true); 
         } 
         else
         {   
            newMeeting.setSendInvitation(false); 
         } 
         
         ProjectServerConnection psc = 
            (ProjectServerConnection)request.getSession().getAttribute("psc");
         
         IMeetingManager meetingManager = psc.getMeetingManager();
         meetingManager.addMeeting(newMeeting);
         
         HashMap menus = (HashMap)request.getSession().getAttribute("menus");
         MenuItem currentMenu = menuController.getMenuItemFromId(menuController.getCurrentPageId(), menus);
         
         try
         {
            response.sendRedirect("../" + currentMenu.link);
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
   
   public void deleteMeeting(HttpServletRequest request, HttpServletResponse response)
   {
      System.out.println("Entering MeetingController.deleteMeeting()");
      
      String stMeetingId = request.getParameter("meetingid");
      String parentLink = request.getParameter("parentlink");
      
      try
      {
         int did = Integer.parseInt(stMeetingId);
         ProjectServerConnection psc = 
            (ProjectServerConnection)request.getSession().getAttribute("psc");
         
         psc.getMeetingManager().dropMeeting(did);
         
         response.sendRedirect("../projectConfirmDeleteDlgSuccess.jsp?parentlink=" + parentLink);
      }
      catch(NumberFormatException nfe)
      {
      	nfe.printStackTrace();
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void editMeeting(HttpServletRequest request, HttpServletResponse response)
   {
      System.out.println("Entering MeetingController.editMeeting()");
   }
}
