package org.apache.jsp;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.logging.EventLogEntry;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import com.dommoni.ece.webui.utils.StringUtils;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class adminLogsViewEventLogs extends HttpJspBase {


    static {
    }
    public adminLogsViewEventLogs( ) {
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

            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(0,46);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(1,37);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(3,66);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(5,54);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(6,50);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(7,64);to=(9,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(9,96);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(10,96);to=(12,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(12,52);to=(13,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(13,60);to=(14,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(14,59);to=(16,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(16,2);to=(34,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	
                	IAccountManager accountManager = psc.getAccountManager();
                	Account account = accountManager.getAccountFromUsername(psc.getUsername());
                	
                	Account[] allAccounts = accountManager.getAllAccounts();
                	
                	IProjectManager projectManager = psc.getProjectManager();
                	Project[] allProjects = projectManager.getAllProjects();
                	
                	// get the values from the reffering page...
                	EventLogEntry ele[] = (EventLogEntry[])session.getAttribute("eventlogs");
                	session.removeAttribute("eventlogs");
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(34,2);to=(44,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(44,12);to=(44,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(44,32);to=(158,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script src=\"./includes/deleteDlgPopup.js\"></script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div></div></div><div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(158,3);to=(158,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(158,36);to=(161,2)]
                out.write("\r\n\r\n\t <!-- TABS -->\r\n\t ");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(161,2);to=(161,34)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(161,34);to=(171,6)]
                out.write("\r\n\t  \r\n\t</div><div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n      <h1>Event-Log Report</h1></div>\r\n\t\t\t<div class=\"Post\">\r\n  <!--projects--> \r\n      ");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(171,8);to=(175,6)]
                
                			if(ele != null && ele.length > 0)
                			{
                			   SimpleDateFormat sdf = new SimpleDateFormat("MMMMM d yyyy, hh:mm aaa");
                			   
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(175,8);to=(181,5)]
                out.write("<table>\r\n\t\t\t\t <tr>\r\n\t\t\t\t <td><b>SessionId</b></td><td><b>AccountId</b></td>\r\n         <td><b>ProjectId</b></td><td><b>Context</b></td>\r\n         <td><b>OperationType</b></td><td><b>OperationName</b></td>\r\n         <td><b>LogMessage</b></td><td><b>Timestamp</b></td></tr>\r\n\t\t\t\t ");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(181,7);to=(184,8)]
                
                				 for(int i = 0; i < ele.length; i++)
                				 {
                				    
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(184,10);to=(185,10)]
                out.write("<tr>\r\n\t\t\t\t\t\t<td>");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(185,13);to=(185,34)]
                out.print(ele[i].getSessionId());
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(185,36);to=(186,16)]
                out.write("</td>\r\n            <td>");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(186,19);to=(186,40)]
                out.print(ele[i].getAccountId());
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(186,42);to=(187,16)]
                out.write("</td>\r\n            <td>");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(187,19);to=(187,40)]
                out.print(ele[i].getProjectId());
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(187,42);to=(188,16)]
                out.write("</td>\r\n            <td>");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(188,19);to=(188,38)]
                out.print(ele[i].getContext());
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(188,40);to=(189,16)]
                out.write("</td>\r\n            <td>");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(189,19);to=(189,44)]
                out.print(ele[i].getOperationType());
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(189,46);to=(190,16)]
                out.write("</td>\r\n            <td>");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(190,19);to=(190,44)]
                out.print(ele[i].getOperationName());
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(190,46);to=(191,16)]
                out.write("</td>\r\n            <td>");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(191,19);to=(191,41)]
                out.print(ele[i].getLogMessage());
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(191,43);to=(192,6)]
                out.write("</td>\r\n\t\t\t\t\t\t");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(192,8);to=(193,15)]
                if(ele[i].getTimestamp() != null) {
                               
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(193,17);to=(193,21)]
                out.write("<td>");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(193,24);to=(193,67)]
                out.print(sdf.format(ele[i].getTimestamp().getTime()));
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(193,69);to=(193,74)]
                out.write("</td>");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(193,76);to=(194,7)]
                
                						}
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(194,9);to=(195,11)]
                out.write("\r\n\t\t\t\t\t\t</tr>");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(195,13);to=(197,5)]
                
                				 }
                				 
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(197,7);to=(198,13)]
                out.write("\r\n\t\t\t\t </table>");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(198,15);to=(200,3)]
                
                			}
                			
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(200,5);to=(206,5)]
                out.write("\r\n\t\t\t \r\n\t\t\t </div></div><div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1><ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/adminLogsViewEventLogs.jsp";from=(206,5);to=(206,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminLogsViewEventLogs.jsp";from=(206,47);to=(214,0)]
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
