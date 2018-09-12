package com.dommoni.ece.webui.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Schedule;
import com.dommoni.roundtable.projectServer.services.scheduleManager.IScheduleManager;

public class ScheduleController
{
   public void createSchedule(HttpServletRequest request, HttpServletResponse response) 
   {
      try
      {
         HttpSession session = request.getSession();
         Account userAccount = (Account)session.getAttribute("useraccount");
         Project currentProject = (Project)session.getAttribute("currentproject");
         
         String name = request.getParameter("name");
         String sAccessMode = request.getParameter("accessmode");
         
         int iAccessMode;
         if (sAccessMode != null)
         {
            if (sAccessMode.equals("restrictedwrite"))
               iAccessMode = Schedule.MODE_READ_RESTRICTREDWRITE;
            else if (sAccessMode.equals("readonly"))
               iAccessMode = Schedule.MODE_READONLY;
            else
               iAccessMode = Schedule.MODE_READWRITE;
         }         
         else
         {
            // Something went wrong, wasnt filled, etc...
            iAccessMode = Schedule.MODE_READWRITE;
         }
         
         Schedule schedule = new Schedule();
         schedule.setName(name);
         schedule.setCreatedBy(userAccount.getId());
         schedule.setProjectId(currentProject.getId());
         schedule.setAccessMode(iAccessMode);
         
         ProjectServerConnection psc = 
            (ProjectServerConnection)session.getAttribute("psc");
         IScheduleManager scheduleManager = psc.getScheduleManager();
         
         scheduleManager.addSchedule(schedule);
         
         try
         {
            response.sendRedirect("../projectSchedules.jsp");
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
   
   public void deleteSchedule(HttpServletRequest request, HttpServletResponse response) 
   {
      try
      {
         String stScheduleId = request.getParameter("scheduleid");
         String parentLink = request.getParameter("parentlink");
         
         int iScheduleId = -1;
         
         try
         {
            iScheduleId = Integer.parseInt(stScheduleId);
         }
         catch(NumberFormatException nfe)
         {
            nfe.printStackTrace();
         }
         
         if(iScheduleId != -1)
         {
            ProjectServerConnection psc = 
               (ProjectServerConnection)request.getSession().getAttribute("psc");
            
            psc.getScheduleManager().dropSchedule(iScheduleId);
         }
         
         try
         {   
            response.sendRedirect("../projectConfirmDeleteDlgSuccess.jsp?parentlink=" + parentLink);
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
   
   public void modifySchedule(HttpServletRequest request, HttpServletResponse response) 
   {
      // dont really have or need this...
   }
}
/*
 * 
 * $Log: ScheduleController.java,v $
 * Revision 1.1  2005/10/16 06:07:56  brian
 * Initial Revision.
 *
 * 
 */
