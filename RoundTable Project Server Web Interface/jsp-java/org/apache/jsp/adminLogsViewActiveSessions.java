package org.apache.jsp;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.Session;
import com.dommoni.roundtable.logging.EventLogEntry;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import com.dommoni.roundtable.projectServer.services.sessionManager.ISessionManager;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import com.dommoni.ece.webui.utils.StringUtils;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class adminLogsViewActiveSessions extends HttpJspBase {


    static {
    }
    public adminLogsViewActiveSessions( ) {
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

            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(0,46);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(1,37);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(3,66);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(5,54);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(6,50);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(7,50);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(8,64);to=(10,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(10,96);to=(11,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(11,96);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(12,96);to=(14,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(14,52);to=(15,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(15,60);to=(16,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(16,59);to=(18,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(18,2);to=(30,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	
                	IAccountManager accountManager = psc.getAccountManager();
                	Account account = accountManager.getAccountFromUsername(psc.getUsername());
                	
                	ISessionManager sessionManager = psc.getSessionManager();
                	Session[] activeSessions = sessionManager.getActiveSessions();
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(30,2);to=(40,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(40,12);to=(40,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(40,32);to=(154,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script src=\"./includes/deleteDlgPopup.js\"></script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div></div></div><div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(154,3);to=(154,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(154,36);to=(157,2)]
                out.write("\r\n\r\n\t <!-- TABS -->\r\n\t ");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(157,2);to=(157,34)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(157,34);to=(167,6)]
                out.write("\r\n\t  \r\n\t</div><div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n      <h1>Active Sessions</h1></div>\r\n\t\t\t<div class=\"Post\">\r\n  <!--projects--> \r\n      ");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(167,8);to=(171,6)]
                
                			if(activeSessions != null && activeSessions.length > 0)
                			{
                			   SimpleDateFormat sdf = new SimpleDateFormat("MMMMM d yyyy, hh:mm aaa");
                			   
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(171,8);to=(180,10)]
                out.write("\r\n\t\t\t\t <table>\r\n\t\t\t\t <tr>\r\n\t       <td><b>Account</b></td>\r\n         <td><b>Type</b></td> \r\n         <td><b>Start-Time</b></td>\r\n         <td><b>Last Activity Time</b></td>\r\n         <td><b>IP Address</b></td>\r\n         <td><b>Project</b></td>\r\n\t\t\t\t </tr>");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(180,12);to=(183,8)]
                
                			   for(int i = 0; i < activeSessions.length; i++)
                				 {
                				    
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(183,10);to=(184,10)]
                out.write("<tr>\r\n\t\t\t\t\t\t<td>");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(184,13);to=(184,43)]
                out.print(activeSessions[i].getAccount());
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(184,45);to=(185,16)]
                out.write("</td>\r\n            <td>");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(185,19);to=(185,46)]
                out.print(activeSessions[i].getType());
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(185,48);to=(187,6)]
                out.write("</td> \r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(187,8);to=(188,15)]
                if(activeSessions[i].getStartTime() != null) {
                               
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(188,17);to=(188,21)]
                out.write("<td>");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(188,24);to=(188,78)]
                out.print(sdf.format(activeSessions[i].getStartTime().getTime()));
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(188,80);to=(188,85)]
                out.write("</td>");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(188,87);to=(190,9)]
                
                						} else {
                						   
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(190,11);to=(190,23)]
                out.write("<td>N/A</td>");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(190,25);to=(191,8)]
                
                						} 
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(191,10);to=(193,6)]
                out.write("\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(193,8);to=(194,15)]
                 if(activeSessions[i].getLastActivityTime() != null) {
                               
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(194,17);to=(194,21)]
                out.write("<td>");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(194,24);to=(194,85)]
                out.print(sdf.format(activeSessions[i].getLastActivityTime().getTime()));
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(194,87);to=(194,92)]
                out.write("</td>");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(194,94);to=(196,9)]
                
                						} else {
                						   
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(196,11);to=(196,23)]
                out.write("<td>N/A</td>");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(196,25);to=(197,8)]
                
                						} 
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(197,10);to=(199,10)]
                out.write("\r\n            \r\n\t\t\t\t\t\t<td>");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(199,13);to=(199,51)]
                out.print(activeSessions[i].getRemoteIPAddress());
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(199,53);to=(200,16)]
                out.write("</td>\r\n            <td>");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(200,19);to=(200,56)]
                out.print(activeSessions[i].getCurrentProject());
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(200,58);to=(202,6)]
                out.write("</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(202,8);to=(204,5)]
                
                				 }
                				 
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(204,7);to=(204,15)]
                out.write("</table>");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(204,17);to=(206,3)]
                
                			}
                			
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(206,5);to=(213,5)]
                out.write("\r\n\t\t\t\r\n\t\t\t \r\n\t\t\t </div></div><div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1><ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/adminLogsViewActiveSessions.jsp";from=(213,5);to=(213,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminLogsViewActiveSessions.jsp";from=(213,47);to=(221,0)]
                out.write("\r\n\t\t</ul><br/>\r\n    <br/>\r\n\t<p>&nbsp;</p></div></div></div></div><div class=\"ShadowCap\">&nbsp;</div></div><div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
