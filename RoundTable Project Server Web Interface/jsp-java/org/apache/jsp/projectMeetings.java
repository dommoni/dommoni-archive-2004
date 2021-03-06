package org.apache.jsp;

import java.util.HashMap;
import java.util.Vector;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.NotificationContext;
import com.dommoni.roundtable.Meeting;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.meetingManager.IMeetingManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import com.dommoni.ece.webui.MenuItem;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectMeetings extends HttpJspBase {


    static {
    }
    public projectMeetings( ) {
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

            // HTML // begin [file="/projectMeetings.jsp";from=(0,37);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(1,36);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(3,66);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(5,54);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(6,62);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(7,50);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(8,50);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(9,96);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(10,96);to=(11,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(11,96);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(12,50);to=(13,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(13,60);to=(15,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectMeetings.jsp";from=(15,2);to=(25,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	IMeetingManager meetingManager = psc.getMeetingManager();
                	Meeting meetings[] = meetingManager.getAllMeetingsForProject(currentProject.getId());
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(25,2);to=(35,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectMeetings.jsp";from=(35,12);to=(35,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(35,32);to=(152,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectMeetings.jsp";from=(152,3);to=(152,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(152,36);to=(155,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectMeetings.jsp";from=(155,9);to=(155,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(155,41);to=(170,5)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t<h1>Meetings</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n  <!--projects--> \r\n\t    ");

            // end
            // begin [file="/projectMeetings.jsp";from=(170,7);to=(173,6)]
                
                	  if(meetings != null && meetings.length > 0)
                	  {
                	  	  
            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(173,8);to=(173,58)]
                out.write("<table border=\"0\" cellspacing=\"3\" cellpadding=\"6\">");

            // end
            // begin [file="/projectMeetings.jsp";from=(173,60);to=(176,8)]
                
                		  for(int i = 0; i < meetings.length; i++)
                		  {
                		      
            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(176,10);to=(177,72)]
                out.write("<tr>\r\n\t\t\t\t  <td width=\"225\"><a href=\"projectMeetingsViewMeeting.jsp?meetingid=");

            // end
            // begin [file="/projectMeetings.jsp";from=(177,75);to=(177,94)]
                out.print(meetings[i].getId());
            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(177,96);to=(177,149)]
                out.write("\"><font face=\"Verdana, Arial, Helvetica, sans-serif\">");

            // end
            // begin [file="/projectMeetings.jsp";from=(177,152);to=(177,174)]
                out.print(meetings[i].getTitle());
            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(177,176);to=(178,13)]
                out.write("</font></a></td>\r\n\t\t      </tr>");

            // end
            // begin [file="/projectMeetings.jsp";from=(178,15);to=(180,4)]
                
                		  }
                		  
            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(180,6);to=(180,14)]
                out.write("</table>");

            // end
            // begin [file="/projectMeetings.jsp";from=(180,16);to=(184,4)]
                
                	  }
                	  else
                	  {
                	   
            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(184,6);to=(184,58)]
                out.write("<p>No meetings currently exist for this project.</p>");

            // end
            // begin [file="/projectMeetings.jsp";from=(184,60);to=(186,3)]
                
                	  }
                	  
            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(186,5);to=(197,5)]
                out.write("\r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectMeetings.jsp";from=(197,5);to=(197,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(197,47);to=(199,61)]
                out.write("\t  \r\n\t\t<li><a href=\"projectMeetingsNewMeeting.jsp\">New Meeting</a></li>\r\n\t\t<li><a href=\"projectNotificationsNotificationWizard.jsp?nc=");

            // end
            // begin [file="/projectMeetings.jsp";from=(199,64);to=(199,99)]
                out.print(NotificationContext.MEETING_CONTEXT);
            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(199,101);to=(199,107)]
                out.write("&path=");

            // end
            // begin [file="/projectMeetings.jsp";from=(199,110);to=(199,134)]
                out.print(request.getServletPath());
            // end
            // HTML // begin [file="/projectMeetings.jsp";from=(199,136);to=(222,0)]
                out.write("\">New Notification</a></li>\r\n\t</ul>\r\n     <br/>\r\n    <br/>  \r\n\t<p>&nbsp;</p>  \r\n</div>\r\n\r\n\r\n</div>\r\n\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
