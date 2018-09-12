package org.apache.jsp;

import java.util.HashMap;
import java.util.Vector;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Forum;
import com.dommoni.roundtable.NotificationContext;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.forumManager.IForumManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import com.dommoni.ece.webui.MenuItem;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectForums extends HttpJspBase {


    static {
    }
    public projectForums( ) {
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

            // HTML // begin [file="/projectForums.jsp";from=(0,37);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForums.jsp";from=(1,36);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectForums.jsp";from=(3,66);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForums.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForums.jsp";from=(5,54);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForums.jsp";from=(6,48);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForums.jsp";from=(7,62);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForums.jsp";from=(8,50);to=(10,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectForums.jsp";from=(10,96);to=(11,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForums.jsp";from=(11,92);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForums.jsp";from=(12,96);to=(14,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectForums.jsp";from=(14,50);to=(15,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForums.jsp";from=(15,60);to=(17,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectForums.jsp";from=(17,2);to=(27,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	IForumManager forumManager = psc.getForumManager();
                	Forum forums[] = forumManager.getAllForumsForProject(currentProject.getId());
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectForums.jsp";from=(27,2);to=(37,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectForums.jsp";from=(37,12);to=(37,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectForums.jsp";from=(37,32);to=(154,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectForums.jsp";from=(154,3);to=(154,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectForums.jsp";from=(154,36);to=(157,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectForums.jsp";from=(157,9);to=(157,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectForums.jsp";from=(157,41);to=(172,6)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t<h1>Forums</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n  <!-- Forums --> \r\n\t     ");

            // end
            // begin [file="/projectForums.jsp";from=(172,8);to=(175,6)]
                
                		 if(forums != null && forums.length >0)
                		 {
                		    
            // end
            // HTML // begin [file="/projectForums.jsp";from=(175,8);to=(175,69)]
                out.write("<!--<table border=\"0\" cellspacing=\"3\" cellpadding=\"6\">--><ul>");

            // end
            // begin [file="/projectForums.jsp";from=(175,71);to=(178,8)]
                
                			for(int i = 0; i < forums.length; i++)
                		  	{
                		      
            // end
            // HTML // begin [file="/projectForums.jsp";from=(178,10);to=(179,75)]
                out.write("<!--<tr>\r\n\t\t\t\t  <td width=\"225\">--><li><a href=\"./projectForumsViewForum.jsp?forumid=");

            // end
            // begin [file="/projectForums.jsp";from=(179,78);to=(179,95)]
                out.print(forums[i].getId());
            // end
            // HTML // begin [file="/projectForums.jsp";from=(179,97);to=(179,150)]
                out.write("\"><font face=\"Verdana, Arial, Helvetica, sans-serif\">");

            // end
            // begin [file="/projectForums.jsp";from=(179,153);to=(179,175)]
                out.print(forums[i].getSubject());
            // end
            // HTML // begin [file="/projectForums.jsp";from=(179,177);to=(180,16)]
                out.write("</font></a></li><!--</td>\r\n\t\t      </tr>-->");

            // end
            // begin [file="/projectForums.jsp";from=(180,18);to=(182,5)]
                
                		  	}
                		  	
            // end
            // HTML // begin [file="/projectForums.jsp";from=(182,7);to=(182,27)]
                out.write("</ul><!--</table>-->");

            // end
            // begin [file="/projectForums.jsp";from=(182,29);to=(186,4)]
                
                		 }
                		 else
                		 {
                		 	
            // end
            // HTML // begin [file="/projectForums.jsp";from=(186,6);to=(186,62)]
                out.write("<p>No forum-topics currently exist for this project.</P>");

            // end
            // begin [file="/projectForums.jsp";from=(186,64);to=(188,3)]
                
                		 }
                		 
            // end
            // HTML // begin [file="/projectForums.jsp";from=(188,5);to=(199,5)]
                out.write("\r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectForums.jsp";from=(199,5);to=(199,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectForums.jsp";from=(199,47);to=(201,61)]
                out.write("\t  \r\n\t    <li><a href=\"projectForumsNewForumTopic.jsp\">New Topic</a></li>\r\n\t\t<li><a href=\"projectNotificationsNotificationWizard.jsp?nc=");

            // end
            // begin [file="/projectForums.jsp";from=(201,64);to=(201,97)]
                out.print(NotificationContext.FORUM_CONTEXT);
            // end
            // HTML // begin [file="/projectForums.jsp";from=(201,99);to=(201,105)]
                out.write("&path=");

            // end
            // begin [file="/projectForums.jsp";from=(201,108);to=(201,132)]
                out.print(request.getServletPath());
            // end
            // HTML // begin [file="/projectForums.jsp";from=(201,134);to=(228,0)]
                out.write("\">New Notification</a></li>\r\n\t</ul>\r\n     <br/>\r\n    <br/> \r\n\t<p>&nbsp;</p>   \r\n</div>\r\n\r\n\r\n</div>\r\n\r\n\r\n<!--\r\n\t<div id=\"showhelp\"><a href=\"../project/show_help?project_id=4661&return_to=%2Fclients%2Ftestproject7%2F1%2Fall%2F\">Show \"Things to do\"</a></div>\r\n-->\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
