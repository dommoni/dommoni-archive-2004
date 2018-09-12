package org.apache.jsp;

import java.util.HashMap;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import com.dommoni.ece.webui.utils.StringUtils;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class adminLogs extends HttpJspBase {


    static {
    }
    public adminLogs( ) {
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

            // HTML // begin [file="/adminLogs.jsp";from=(0,37);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminLogs.jsp";from=(2,66);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogs.jsp";from=(3,50);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogs.jsp";from=(4,54);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogs.jsp";from=(5,50);to=(7,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminLogs.jsp";from=(7,96);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogs.jsp";from=(8,96);to=(10,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminLogs.jsp";from=(10,52);to=(11,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogs.jsp";from=(11,60);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogs.jsp";from=(12,59);to=(14,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/adminLogs.jsp";from=(14,2);to=(28,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	
                	IAccountManager accountManager = psc.getAccountManager();
                	Account account = accountManager.getAccountFromUsername(psc.getUsername());
                	
                	Account[] allAccounts = accountManager.getAllAccounts();
                	
                	IProjectManager projectManager = psc.getProjectManager();
                	Project[] allProjects = projectManager.getAllProjects();
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/adminLogs.jsp";from=(28,2);to=(38,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/adminLogs.jsp";from=(38,12);to=(38,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/adminLogs.jsp";from=(38,32);to=(152,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script src=\"./includes/deleteDlgPopup.js\"></script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div></div></div><div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/adminLogs.jsp";from=(152,3);to=(152,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminLogs.jsp";from=(152,36);to=(155,2)]
                out.write("\r\n\r\n\t <!-- TABS -->\r\n\t ");

            // end
            // begin [file="/adminLogs.jsp";from=(155,2);to=(155,34)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminLogs.jsp";from=(155,34);to=(169,5)]
                out.write("\r\n\t  \r\n\t</div><div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n      <h1>Generate Log Report</h1></div><div class=\"Post\">\r\n  <!--projects--> \r\n\t     <form name=\"form1\" method=\"post\" action=\"./servlet/ControllerServlet\">\r\n\t\t\t <p>\r\n\t\t\t <b>Select Projects:</b> <br>\r\n\t\t\t <select name=\"projects\" size=\"5\" MULTIPLE>\r\n\t\t\t    <option value=\"all\" selected>All Projects</option>\r\n\t\t\t\t\t");

            // end
            // begin [file="/adminLogs.jsp";from=(169,7);to=(172,8)]
                
                					for(int i = 0; i < allProjects.length; i++)
                					{
                					   
            // end
            // HTML // begin [file="/adminLogs.jsp";from=(172,10);to=(172,25)]
                out.write("<option value=\"");

            // end
            // begin [file="/adminLogs.jsp";from=(172,28);to=(172,50)]
                out.print(allProjects[i].getId());
            // end
            // HTML // begin [file="/adminLogs.jsp";from=(172,52);to=(172,54)]
                out.write("\">");

            // end
            // begin [file="/adminLogs.jsp";from=(172,57);to=(172,81)]
                out.print(allProjects[i].getName());
            // end
            // HTML // begin [file="/adminLogs.jsp";from=(172,83);to=(172,92)]
                out.write("</option>");

            // end
            // begin [file="/adminLogs.jsp";from=(172,94);to=(174,5)]
                
                					}
                					
            // end
            // HTML // begin [file="/adminLogs.jsp";from=(174,7);to=(180,5)]
                out.write("\r\n\t\t\t </select>\r\n\t\t\t \r\n\t\t\t <br><br><b>Select Users:</b><br>\r\n\t\t\t <select name=\"accounts\" size=\"5\" MULTIPLE>\r\n\t\t\t \t\t<option value=\"all\" selected>All Users</option>\r\n\t\t\t\t\t");

            // end
            // begin [file="/adminLogs.jsp";from=(180,7);to=(183,8)]
                
                					for(int i = 0; i < allAccounts.length; i++)
                					{
                					   
            // end
            // HTML // begin [file="/adminLogs.jsp";from=(183,10);to=(183,25)]
                out.write("<option value=\"");

            // end
            // begin [file="/adminLogs.jsp";from=(183,28);to=(183,50)]
                out.print(allAccounts[i].getId());
            // end
            // HTML // begin [file="/adminLogs.jsp";from=(183,52);to=(183,54)]
                out.write("\">");

            // end
            // begin [file="/adminLogs.jsp";from=(183,57);to=(183,81)]
                out.print(allAccounts[i].getName());
            // end
            // HTML // begin [file="/adminLogs.jsp";from=(183,83);to=(183,92)]
                out.write("</option>");

            // end
            // begin [file="/adminLogs.jsp";from=(183,94);to=(185,5)]
                
                					}
                					
            // end
            // HTML // begin [file="/adminLogs.jsp";from=(185,7);to=(187,320)]
                out.write("\r\n\t\t\t </select>\r\n\t\t\t <br><br><b>Select Period:</b></p><p>From: <input type=\"text\" name=\"from\"> <img src=\"images/icon_calendar.gif\" width=\"22\" height=\"21\" align=\"ABSMIDDLE\"><br>To: <input type=\"text\" name=\"to\"> <img src=\"images/icon_calendar.gif\" width=\"22\" height=\"21\" align=\"ABSMIDDLE\"><br><br><input type=\"hidden\" name=\"opcode\" value=\"");

            // end
            // begin [file="/adminLogs.jsp";from=(187,323);to=(187,353)]
                out.print(Operations.GENERATE_LOG_REPORT);
            // end
            // HTML // begin [file="/adminLogs.jsp";from=(187,355);to=(191,5)]
                out.write("\"></p><p><input type=\"submit\" name=\"Submit\" value=\"Generate Report\"></p></form></div></div><div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1><ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/adminLogs.jsp";from=(191,5);to=(191,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminLogs.jsp";from=(191,47);to=(200,0)]
                out.write("\r\n\t\t\t<li><a href=\"./adminLogsViewActiveSessions.jsp\">Active Sessions</a></li>\r\n\t\t</ul><br/>\r\n    <br/>\r\n\t<p>&nbsp;</p></div></div></div></div><div class=\"ShadowCap\">&nbsp;</div></div><div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
