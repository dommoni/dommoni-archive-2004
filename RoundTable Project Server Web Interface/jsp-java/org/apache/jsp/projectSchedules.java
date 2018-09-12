package org.apache.jsp;

import java.util.HashMap;
import java.util.Vector;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.NotificationContext;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Schedule;
import com.dommoni.roundtable.projectServer.services.scheduleManager.IScheduleManager;
import com.dommoni.roundtable.projectServer.services.systemManager.ISystemManager;
import com.dommoni.ece.webui.WebUIConfiguration;
import com.dommoni.ece.webui.utils.StringUtils;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectSchedules extends HttpJspBase {


    static {
    }
    public projectSchedules( ) {
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

            // HTML // begin [file="/projectSchedules.jsp";from=(0,37);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(1,36);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(3,50);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(4,62);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(5,50);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(6,66);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(7,51);to=(9,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(9,98);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(10,94);to=(12,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(12,60);to=(13,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(13,59);to=(15,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectSchedules.jsp";from=(15,2);to=(41,4)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	String serverIp = "0.0.0.0";
                	int serverPort = 0;
                	ISystemManager systemManager = psc.getSystemManager();
                	if (systemManager != null)
                	{	
                		serverIp = systemManager.getServerIpAddr();
                		serverPort = systemManager.getServerPort();
                	}
                	
                	Schedule[] schedules = null;
                	if (currentProject != null)
                	{
                		IScheduleManager scheduleManager = psc.getScheduleManager();
                		schedules = scheduleManager.getAllSchedulesForProject(currentProject.getId());
                	}
                	
                	String editScheduleId = request.getParameter("editschedule");
                	String origPath = request.getParameter("originalpath"); // This should fully close out the applet by reseting it to this on close.
                	if (editScheduleId != null)
                	{
                	   String sscResources = (String)WebUIConfiguration.getInstance().get("ssc_path");
                	   
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(41,6);to=(44,46)]
                out.write("\r\n\t   <!--<APPLET ARCHIVE=\"sslib/SharedSchedulingClient.jar,sslib/ProjectServerAPI.jar,sslib/looks-1.3.1.jar,sslib/forms-1.0.5.jar,sslib/axis.jar,sslib/commons-discovery-0.2.jar,sslib/commons-logging-1.0.4.jar,sslib/jaxrpc.jar,sslib/log4j-1.2.8.jar,sslib/saaj.jar,sslib/wsdl4j-1.5.1.jar\" \r\n          CODE=com.dommoni.roundtable.is.ISClientApplet.class WIDTH = \"0\" HEIGHT = \"0\">\r\n          <PARAM NAME=\"currentproject\" VALUE=\"");

            // end
            // begin [file="/projectSchedules.jsp";from=(44,49);to=(44,71)]
                out.print(currentProject.getId());
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(44,73);to=(45,41)]
                out.write("\" >\r\n          <PARAM NAME=\"username\" VALUE =\"");

            // end
            // begin [file="/projectSchedules.jsp";from=(45,44);to=(45,65)]
                out.print(account.getUsername());
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(45,67);to=(46,42)]
                out.write("\" >\r\n          <PARAM NAME=\"password\" VALUE = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(46,45);to=(46,66)]
                out.print(account.getPassword());
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(46,68);to=(47,44)]
                out.write("\" >\r\n          <PARAM NAME=\"scheduleid\" VALUE = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(47,47);to=(47,61)]
                out.print(editScheduleId);
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(47,63);to=(48,34)]
                out.write("\" >\r\n\t\t  <PARAM NAME=\"ipaddr\" VALUE = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(48,37);to=(48,45)]
                out.print(serverIp);
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(48,47);to=(49,32)]
                out.write("\" >\r\n\t\t  <PARAM NAME=\"port\" VALUE = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(49,35);to=(49,45)]
                out.print(serverPort);
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(49,47);to=(61,35)]
                out.write("\" >\r\n       </APPLET>-->\r\n\r\n\t\r\n\t\r\n\t\r\n\t<object\r\n    classid = \"clsid:8AD9C840-044E-11D1-B3E9-00805F499D93\"\r\n    codebase = \"http://java.sun.com/update/1.5.0/jinstall-1_5-windows-i586.cab#Version=5,0,0,5\"\r\n    WIDTH = \"0\" HEIGHT = \"0\" >\r\n    <PARAM NAME = CODE VALUE = com.dommoni.roundtable.is.ISClientApplet.class >\r\n\r\n    <PARAM NAME = ARCHIVE VALUE = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(61,38);to=(61,50)]
                out.print(sscResources);
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(61,52);to=(65,42)]
                out.write("\" >\r\n    <param name = \"type\" value = \"application/x-java-applet;version=1.5\">\r\n    <param name = \"scriptable\" value = \"false\">\r\n\t\r\n    <PARAM NAME = \"currentproject\" VALUE=\"");

            // end
            // begin [file="/projectSchedules.jsp";from=(65,45);to=(65,67)]
                out.print(currentProject.getId());
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(65,69);to=(66,37)]
                out.write("\" >\r\n    <PARAM NAME = \"username\" VALUE =\"");

            // end
            // begin [file="/projectSchedules.jsp";from=(66,40);to=(66,61)]
                out.print(account.getUsername());
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(66,63);to=(67,38)]
                out.write("\" >\r\n    <PARAM NAME = \"password\" VALUE = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(67,41);to=(67,62)]
                out.print(account.getPassword());
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(67,64);to=(68,40)]
                out.write("\" >\r\n    <PARAM NAME = \"scheduleid\" VALUE = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(68,43);to=(68,57)]
                out.print(editScheduleId);
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(68,59);to=(69,36)]
                out.write("\" >\r\n    <PARAM NAME = \"ipaddr\" VALUE = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(69,39);to=(69,47)]
                out.print(serverIp);
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(69,49);to=(70,34)]
                out.write("\" >\r\n    <PARAM NAME = \"port\" VALUE = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(70,37);to=(70,47)]
                out.print(serverPort);
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(70,49);to=(71,37)]
                out.write("\" >\r\n\t<PARAM NAME = \"parentpath\" VALUE = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(71,40);to=(71,48)]
                out.print(origPath);
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(71,50);to=(77,23)]
                out.write("\" >\r\n\r\n    <comment>\r\n\t<embed\r\n            type = \"application/x-java-applet;version=1.5\" \\\r\n            CODE = com.dommoni.roundtable.is.ISClientApplet.class \\\r\n            ARCHIVE = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(77,26);to=(77,38)]
                out.print(sscResources);
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(77,40);to=(80,29)]
                out.write("\" \\\r\n            WIDTH = \"0\" \\\r\n            HEIGHT = \"0\" \\\r\n            currentproject =\"");

            // end
            // begin [file="/projectSchedules.jsp";from=(80,32);to=(80,54)]
                out.print(currentProject.getId());
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(80,56);to=(81,23)]
                out.write("\" \\\r\n            username =\"");

            // end
            // begin [file="/projectSchedules.jsp";from=(81,26);to=(81,47)]
                out.print(account.getUsername());
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(81,49);to=(82,24)]
                out.write("\" \\\r\n            password = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(82,27);to=(82,48)]
                out.print(account.getPassword());
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(82,50);to=(83,26)]
                out.write("\" \\\r\n            scheduleid = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(83,29);to=(83,43)]
                out.print(editScheduleId);
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(83,45);to=(84,22)]
                out.write("\" \\\r\n            ipaddr = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(84,25);to=(84,33)]
                out.print(serverIp);
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(84,35);to=(85,20)]
                out.write("\" \\\r\n            port = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(85,23);to=(85,33)]
                out.print(serverPort);
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(85,35);to=(86,17)]
                out.write("\" \\\r\n\t\t\tparentpath = \"");

            // end
            // begin [file="/projectSchedules.jsp";from=(86,20);to=(86,28)]
                out.print(origPath);
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(86,30);to=(97,4)]
                out.write("\"\r\n\t    scriptable = false\r\n\t    pluginspage = \"http://java.sun.com/products/plugin/index.html#download\">\r\n\t    <noembed>\r\n        </noembed>\r\n\t</embed>\r\n    </comment>\r\n</object>\r\n\t\r\n\t\r\n\t\r\n\t   ");

            // end
            // begin [file="/projectSchedules.jsp";from=(97,6);to=(102,0)]
                
                	}
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(102,2);to=(112,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectSchedules.jsp";from=(112,12);to=(112,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(112,32);to=(229,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectSchedules.jsp";from=(229,3);to=(229,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(229,36);to=(232,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectSchedules.jsp";from=(232,9);to=(232,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(232,41);to=(247,5)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t<h1>Schedules</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n  <!-- Documents --> \r\n\t    ");

            // end
            // begin [file="/projectSchedules.jsp";from=(247,7);to=(250,6)]
                
                		if (schedules != null && schedules.length > 0)
                		{
                		    
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(250,8);to=(250,58)]
                out.write("<table border=\"0\" cellspacing=\"3\" cellpadding=\"6\">");

            // end
            // begin [file="/projectSchedules.jsp";from=(250,60);to=(254,4)]
                
                			
                			for (int i = 0; i < schedules.length; i++)
                			{
                				
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(254,6);to=(255,130)]
                out.write("<tr>\r\n\t\t\t\t    <td width=\"225\"><font face=\"Verdana, Arial, Helvetica, sans-serif\"><a href=\"./projectSchedulesViewSchedule.jsp?scheduleid=");

            // end
            // begin [file="/projectSchedules.jsp";from=(255,133);to=(255,153)]
                out.print(schedules[i].getId());
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(255,155);to=(255,157)]
                out.write("\">");

            // end
            // begin [file="/projectSchedules.jsp";from=(255,160);to=(255,182)]
                out.print(schedules[i].getName());
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(255,184);to=(256,54)]
                out.write("</a></font></td>\r\n\t\t\t\t\t<td><a href=\"./projectSchedules.jsp?editschedule=");

            // end
            // begin [file="/projectSchedules.jsp";from=(256,57);to=(256,77)]
                out.print(schedules[i].getId());
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(256,79);to=(256,93)]
                out.write("&originalpath=");

            // end
            // begin [file="/projectSchedules.jsp";from=(256,96);to=(256,119)]
                out.print(request.getRequestURL());
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(256,121);to=(257,11)]
                out.write("\">Edit</a></td>\r\n\t\t\t\t  </tr>");

            // end
            // begin [file="/projectSchedules.jsp";from=(257,13);to=(259,3)]
                
                			}
                			
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(259,5);to=(259,13)]
                out.write("</table>");

            // end
            // begin [file="/projectSchedules.jsp";from=(259,15);to=(261,2)]
                
                		}
                		
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(261,4);to=(272,5)]
                out.write("\r\n        </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectSchedules.jsp";from=(272,5);to=(272,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(272,47);to=(274,61)]
                out.write("\r\n\t\t<li><a href=\"projectSchedulesNewSchedule.jsp\">New Schedule</a></li>\r\n\t\t<li><a href=\"projectNotificationsNotificationWizard.jsp?nc=");

            // end
            // begin [file="/projectSchedules.jsp";from=(274,64);to=(274,100)]
                out.print(NotificationContext.SCHEDULE_CONTEXT);
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(274,102);to=(274,108)]
                out.write("&path=");

            // end
            // begin [file="/projectSchedules.jsp";from=(274,111);to=(274,135)]
                out.print(request.getServletPath());
            // end
            // HTML // begin [file="/projectSchedules.jsp";from=(274,137);to=(296,0)]
                out.write("\">New Notification</a></li>\r\n\t</ul>\r\n     <br/>\r\n    <br/>    \r\n\t<p>&nbsp;</p>\r\n</div>\r\n\r\n\r\n</div>\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
