/*
 * Created on Jun 28, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.ece.webui.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dommoni.roundtable.ProjectServerConnection;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DiscussionController
{
   public void deleteDiscussion(HttpServletRequest request, 
                                HttpServletResponse response)
   {
      try
      {
         ProjectServerConnection psc = (ProjectServerConnection)request.getSession().getAttribute("psc");
         int discussionId = -1;
         String discussionName = request.getParameter("discussionName");    
         
         discussionId = Integer.parseInt(request.getParameter("discussionId"));
         psc.getDiscussionManager().dropDiscussion(discussionId);
   
         try
         {
            PrintWriter out = response.getWriter();
            if(true)//psc.getDiscussionManager().getDiscussion(discussionId) == null)
            {
               out.println("<center>Successfully deleted <B>\"" + discussionName + "\"</B>." +
                           "<BR><input type=button onClick=window.close() value=\"  OK  \"></center>");
            }
            else
            {
               out.println("<p align=\"center\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" color=\"#006699\">Unable to delete \"" + discussionName + "\". <BR>"+
                           "You might want to try again.</font>");
            }
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
