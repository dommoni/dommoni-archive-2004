/*
 * Created on Feb 20, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.dommoni.ece.webui.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.logging.EventLogEntry;
import com.dommoni.roundtable.projectServer.services.logging.eventlogManager.IEventLogManager;

/**
 * @author Brian Abbott
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class LogController
{
   public void generateLogReport(HttpServletRequest request, HttpServletResponse response)
   {
      try
      {
         // need to be able to query system... how will this work... 
         String[] projects = request.getParameterValues("projects");
         String[] accounts = request.getParameterValues("accounts");
         String from = request.getParameter("from");
         String to = request.getParameter("to");
         
         //"users=(1,2,3);projects=(1,4,12);period=(11/1/2004,1/1/2005);"
         StringBuffer sbLogQuery = new StringBuffer();
         sbLogQuery.append("users=(");
         for(int i = 0; i < accounts.length; i++)
         {
            if(i < accounts.length - 1)
               sbLogQuery.append(accounts[i]+ ",");
            else
               sbLogQuery.append(accounts[i]);
         }
         sbLogQuery.append(");");
         
         sbLogQuery.append("projects=(");
         for(int i = 0; i < projects.length; i++)
         {
            if(i < projects.length - 1)
               sbLogQuery.append(projects[i]+ ",");
            else
               sbLogQuery.append(projects[i]);
         }
         sbLogQuery.append(");");
         
         sbLogQuery.append("period=(" + from +","+to+");");
         
         ProjectServerConnection psc = 
            (ProjectServerConnection)request.getSession().getAttribute("psc");
         IEventLogManager eventLogManager = psc.getEventLogManager();
         
         System.out.println("Querying Event Log with: " + sbLogQuery.toString());
         EventLogEntry[] eventLogs = eventLogManager.getEventLogsFromQueryString(sbLogQuery.toString());
         System.out.println("Retrieved " + eventLogs.length);
         
         request.getSession().setAttribute("eventlogs", eventLogs);
         response.sendRedirect("../adminLogsViewEventLogs.jsp");
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void exportLogReportAsXls(HttpServletRequest request, HttpServletResponse response)
   {
      
   }
   
   public void exportLogReportAsCsv(HttpServletRequest request, HttpServletResponse response)
   {
      
   }
   
   public void exportLogReportAsPdf(HttpServletRequest request, HttpServletResponse response)
   {
      
   }
}
