package org.apache.jsp;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.Meeting;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import com.dommoni.ece.webui.MenuItem;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import com.dommoni.ece.webui.utils.StringUtils;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectMeetingsViewMeeting extends HttpJspBase {


    static {
    }
    public projectMeetingsViewMeeting( ) {
    }

    private static boolean _jspx_inited = false;

    public final void _jspx_init() throws org.apache.jasper.runtime.JspException {
    }

    public void _jspService(HttpServletRequest request, HttpServletResponse  response)
        throws java.io.IOException, ServletException {

        JspFactory _jspxFactory = null;
        PageContext pageContext = null;
        HttpSession session = null;
        ServletContext application = null;
        ServletConfig config = null;
        JspWriter out = null;
        Object page = this;
        String  _value = null;
        try {

            if (_jspx_inited == false) {
                synchronized (this) {
                    if (_jspx_inited == false) {
                        _jspx_init();
                        _jspx_inited = true;
                    }
                }
            }
            _jspxFactory = JspFactory.getDefaultFactory();
            response.setContentType("text/html;ISO-8859-1");
            pageContext = _jspxFactory.getPageContext(this, request, response,
            			"", true, 8192, true);

            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();

            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(0,46);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(1,37);to=(2,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(2,36);to=(4,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(4,66);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(5,50);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(6,54);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(7,50);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(8,50);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(9,50);to=(11,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(11,96);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(12,96);to=(14,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(14,50);to=(15,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(15,52);to=(16,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(16,60);to=(17,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(17,59);to=(19,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(19,2);to=(30,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	SimpleDateFormat dtsdf = new SimpleDateFormat("MM/dd/yyyy");
                	
                	int meetingId = Integer.parseInt(request.getParameter("meetingid"));
                	Meeting meeting = psc.getMeetingManager().getMeeting(meetingId);
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(30,2);to=(40,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(40,12);to=(40,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(40,32);to=(159,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script src=\"./includes/addCommentDlgPopup.js\"></script>\r\n<script src=\"./includes/deleteDlgPopup.js\"></script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(159,3);to=(159,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(159,36);to=(162,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(162,9);to=(162,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(162,41);to=(170,14)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t<h1>Meeting: ");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(170,17);to=(170,35)]
                out.print(meeting.getTitle());
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(170,37);to=(178,3)]
                out.write("</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n\t  <p>\r\n\t  <b>Start Time: </b>\r\n\t  ");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(178,5);to=(179,5)]
                 if(meeting.getStartTime() != null) {
                	    
            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(179,10);to=(179,56)]
                out.print(dtsdf.format(meeting.getStartTime().getTime()));
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(179,58);to=(179,62)]
                out.write("<br>");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(179,64);to=(181,7)]
                
                	   } else {
                	      
            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(181,12);to=(181,21)]
                out.print("not set");
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(181,23);to=(181,27)]
                out.write("<br>");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(181,29);to=(182,5)]
                
                	   }
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(182,7);to=(185,3)]
                out.write(" \r\n\t   \r\n   \t  <b>End Time: </b>\r\n\t  ");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(185,5);to=(186,5)]
                 if(meeting.getEndTime() != null) {
                	    
            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(186,10);to=(186,54)]
                out.print(dtsdf.format(meeting.getEndTime().getTime()));
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(186,56);to=(186,60)]
                out.write("<br>");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(186,62);to=(188,7)]
                
                	    } else {
                	      
            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(188,12);to=(188,21)]
                out.print("not set");
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(188,23);to=(188,27)]
                out.write("<br>");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(188,29);to=(189,7)]
                
                	    } 
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(189,9);to=(190,24)]
                out.write("\r\n      <b>Organizer: </b>");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(190,27);to=(190,95)]
                out.print(psc.getAccountManager().getAccount(meeting.getCreatedBy()).getName());
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(190,97);to=(192,3)]
                out.write("<br>\r\n\t  \r\n\t  ");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(192,5);to=(195,7)]
                int attendees[] = meeting.getAttendees();
                	  if(attendees.length > 0)
                	  {   
                	      
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(195,9);to=(195,30)]
                out.write("<b>Attendees:</b><ul>");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(195,32);to=(198,4)]
                
                		  for(int i = 0; i < attendees.length; i++)
                		  {
                			 
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(198,6);to=(198,10)]
                out.write("<li>");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(198,13);to=(198,71)]
                out.print(psc.getAccountManager().getAccount(attendees[i]).getName());
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(198,73);to=(198,78)]
                out.write("</li>");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(198,80);to=(200,4)]
                
                		  }
                		  
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(200,6);to=(200,11)]
                out.write("</ul>");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(200,13);to=(202,3)]
                
                	  }
                	  
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(202,5);to=(205,3)]
                out.write("\r\n\t  \r\n\t  \r\n\t  ");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(205,5);to=(206,7)]
                if(meeting.getDescription() != null && meeting.getDescription().length() > 0) {
                		     
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(206,9);to=(206,35)]
                out.write("<p><b>Description:</b><br>");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(206,38);to=(206,62)]
                out.print(meeting.getDescription());
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(206,64);to=(206,68)]
                out.write("</p>");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(206,70);to=(207,5)]
                
                		  }
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(207,7);to=(208,7)]
                out.write("\r\n\t      ");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(208,9);to=(214,7)]
                SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMMM d yyyy, hh:mm aaa");
                		  Comment[] comments = psc.getMeetingManager().getCommentsForMeeting(meeting);
                		  
                		  if(comments != null && comments.length > 0)
                		  {
                		     
                		     
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(214,9);to=(214,55)]
                out.write("<br><h2 class=\"date\">Comments</h2><blockquote>");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(214,57);to=(219,7)]
                
                			 
                		     for(int i = 0; i < comments.length; i++)
                			 {
                			    String cb = ((Account)psc.getAccountManager().getAccount(comments[i].getCreatedBy())).getName();
                			    
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(219,9);to=(219,12)]
                out.write("<p>");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(219,15);to=(219,39)]
                out.print(comments[i].getComment());
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(219,41);to=(220,49)]
                out.write("<br>\r\n              <I><font color=\"#cccccc\">Posted by ");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(220,52);to=(220,54)]
                out.print(cb);
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(220,56);to=(220,57)]
                out.write(" ");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(220,60);to=(220,108)]
                out.print(sdf.format(comments[i].getCreatedOn().getTime()));
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(220,110);to=(221,14)]
                out.write(".</font></I> \r\n              ");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(221,16);to=(221,67)]
                if(comments[i].getCreatedBy() == account.getId()) {
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(221,69);to=(222,66)]
                out.write("\r\n              <br><a href=\"#\" onClick=\"showDelete('your comment','");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(222,69);to=(222,94)]
                out.print(Operations.DELETE_COMMENT);
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(222,96);to=(222,99)]
                out.write("','");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(222,102);to=(222,121)]
                out.print(comments[i].getId());
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(222,123);to=(222,177)]
                out.write("','Comment','projectMeetingsViewMeeting.jsp?meetingid=");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(222,180);to=(222,195)]
                out.print(meeting.getId());
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(222,197);to=(223,14)]
                out.write("');\"><font size=\"2\">Delete My Comment</font></a> \r\n              ");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(223,16);to=(223,17)]
                }
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(223,19);to=(225,12)]
                out.write("\r\n            </p>\r\n            ");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(225,14);to=(227,4)]
                
                			 }
                			 
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(227,6);to=(227,19)]
                out.write("</blockquote>");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(227,21);to=(228,5)]
                
                		  }
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(228,7);to=(239,5)]
                out.write("\r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(239,5);to=(239,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(239,47);to=(240,2)]
                out.write("\r\n\t\t");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(240,4);to=(243,5)]
                
                		if(meeting.getCreatedBy() == account.getId())
                		{
                		   
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(243,7);to=(244,63)]
                out.write("\r\n\t\t   <li><a href=\"./projectMeetingsModifyMeeting.jsp?meetingid=");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(244,66);to=(244,81)]
                out.print(meeting.getId());
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(244,83);to=(244,92)]
                out.write("&respath=");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(244,95);to=(244,119)]
                out.print(request.getServletPath());
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(244,121);to=(245,42)]
                out.write("\">Modify Meeting</a></li>\r\n\t\t   <li><a href=\"#\" onClick=\"showDelete('");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(245,45);to=(245,87)]
                out.print(StringUtils.getJSString(meeting.getName()));
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(245,89);to=(245,92)]
                out.write("','");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(245,95);to=(245,120)]
                out.print(Operations.DELETE_MEETING);
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(245,122);to=(245,125)]
                out.write("','");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(245,128);to=(245,143)]
                out.print(meeting.getId());
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(245,145);to=(246,11)]
                out.write("','Meeting','projectMeetings.jsp');\">Delete Meeting</a></li>\r\n           ");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(246,13);to=(248,2)]
                
                		}
                		
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(248,4);to=(249,39)]
                out.write("\t  \r\n\t\t<li><a href=\"#\" onClick=\"addComment('");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(249,42);to=(249,84)]
                out.print(StringUtils.getJSString(meeting.getName()));
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(249,86);to=(249,89)]
                out.write("','");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(249,92);to=(249,107)]
                out.print(meeting.getId());
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(249,109);to=(249,124)]
                out.write("','Meeting','./");

            // end
            // begin [file="/projectMeetingsViewMeeting.jsp";from=(249,127);to=(249,151)]
                out.print(request.getServletPath());
            // end
            // HTML // begin [file="/projectMeetingsViewMeeting.jsp";from=(249,153);to=(271,0)]
                out.write("');\">Add a Comment</a></li>\r\n\t</ul>\r\n     <br/>\r\n    <br/>    \r\n\t<P>&nbsp;</P>\r\n</div>\r\n\r\n\r\n</div>\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

            // end

        } catch (Throwable t) {
            if (out != null && out.getBufferSize() != 0)
                out.clearBuffer();
            if (pageContext != null) pageContext.handlePageException(t);
        } finally {
            if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);
        }
    }
}
