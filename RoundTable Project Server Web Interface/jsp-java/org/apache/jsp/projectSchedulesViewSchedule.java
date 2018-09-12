package org.apache.jsp;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Schedule;
import com.dommoni.roundtable.projectServer.services.systemManager.ISystemManager;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import com.dommoni.ece.webui.utils.StringUtils;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectSchedulesViewSchedule extends HttpJspBase {


    static {
    }
    public projectSchedulesViewSchedule( ) {
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

            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(0,46);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(1,37);to=(2,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(2,36);to=(4,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(5,50);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(6,66);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(7,51);to=(9,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(9,94);to=(11,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(11,52);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(12,60);to=(13,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(13,59);to=(15,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(15,2);to=(44,4)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	int scheduleId = -1;
                	Schedule schedule = null;
                	try
                	{
                		scheduleId = Integer.parseInt(request.getParameter("scheduleid"));
                		schedule = psc.getScheduleManager().getSchedule(scheduleId);
                	}
                	catch(Exception e)
                	{
                	   e.printStackTrace();
                	}
                	
                	String editScheduleId = request.getParameter("editschedule");
                	if (editScheduleId != null)
                	{
                		String serverIp = "0.0.0.0";
                		int serverPort = 0;
                		ISystemManager systemManager = psc.getSystemManager();
                		if (systemManager != null)
                		{	
                			serverIp = systemManager.getServerIpAddr();
                			serverPort = systemManager.getServerPort();
                		}
                		
                	   
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(44,6);to=(47,46)]
                out.write("\r\n\t   <APPLET ARCHIVE=\"sslib/SharedSchedulingClient.jar,sslib/ProjectServerAPI.jar,sslib/looks-1.3.1.jar,sslib/forms-1.0.5.jar,sslib/axis.jar,sslib/commons-discovery-0.2.jar,sslib/commons-logging-1.0.4.jar,sslib/jaxrpc.jar,sslib/log4j-1.2.8.jar,sslib/saaj.jar,sslib/wsdl4j-1.5.1.jar\" \r\n          CODE=com.dommoni.roundtable.is.ISClientApplet.class WIDTH = \"0\" HEIGHT = \"0\">\r\n          <PARAM NAME=\"currentproject\" VALUE=\"");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(47,49);to=(47,71)]
                out.print(currentProject.getId());
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(47,73);to=(48,41)]
                out.write("\" >\r\n          <PARAM NAME=\"username\" VALUE =\"");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(48,44);to=(48,65)]
                out.print(account.getUsername());
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(48,67);to=(49,42)]
                out.write("\" >\r\n          <PARAM NAME=\"password\" VALUE = \"");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(49,45);to=(49,66)]
                out.print(account.getPassword());
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(49,68);to=(50,44)]
                out.write("\" >\r\n          <PARAM NAME=\"scheduleid\" VALUE = \"");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(50,47);to=(50,61)]
                out.print(editScheduleId);
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(50,63);to=(51,34)]
                out.write("\" >\r\n\t\t  <PARAM NAME=\"ipaddr\" VALUE = \"");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(51,37);to=(51,45)]
                out.print(serverIp);
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(51,47);to=(52,32)]
                out.write("\" >\r\n\t\t  <PARAM NAME=\"port\" VALUE = \"");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(52,35);to=(52,45)]
                out.print(serverPort);
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(52,47);to=(62,42)]
                out.write("\" >\r\n       </APPLET>\r\n<!--\r\n\t<object\r\n       classid = \"clsid:8AD9C840-044E-11D1-B3E9-00805F499D93\"\r\n    codebase = \"http://java.sun.com/update/1.5.0/jinstall-1_5-windows-i586.cab#Version=5,0,0,5\"\r\n    WIDTH = \"200\" HEIGHT = \"200\" >\r\n    <PARAM NAME = CODE VALUE = com.dommoni.roundtable.is.ISClientApplet.class >\r\n    <param name = \"type\" value = \"application/x-java-applet;version=1.5\">\r\n    <param name = \"scriptable\" value = \"false\">\r\n    <PARAM NAME = \"currentproject\" VALUE=\"");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(62,45);to=(62,67)]
                out.print(currentProject.getId());
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(62,69);to=(64,36)]
                out.write("\" >\r\n\r\n    <PARAM NAME = \"username\" VALUE=\"");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(64,39);to=(64,60)]
                out.print(account.getUsername());
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(64,62);to=(66,36)]
                out.write("\" >\r\n\r\n    <PARAM NAME = \"password\" VALUE=\"");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(66,39);to=(66,60)]
                out.print(account.getPassword());
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(66,62);to=(68,38)]
                out.write("\" >\r\n\r\n    <PARAM NAME = \"scheduleid\" VALUE=\"");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(68,41);to=(68,55)]
                out.print(editScheduleId);
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(68,57);to=(77,29)]
                out.write("\" >\r\n\r\n\r\n    <comment>\r\n\t<embed\r\n            type = \"application/x-java-applet;version=1.5\" \\\r\n            CODE = com.dommoni.roundtable.is.ISClientApplet.class \\\r\n            WIDTH = \"200\" \\\r\n            HEIGHT = \"200\" \\\r\n            currentproject =\"");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(77,32);to=(77,54)]
                out.print(currentProject.getId());
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(77,56);to=(78,23)]
                out.write("\" \\\r\n            username =\"");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(78,26);to=(78,47)]
                out.print(account.getUsername());
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(78,49);to=(79,23)]
                out.write("\" \\\r\n            password =\"");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(79,26);to=(79,47)]
                out.print(account.getPassword());
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(79,49);to=(80,25)]
                out.write("\" \\\r\n            scheduleid =\"");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(80,28);to=(80,42)]
                out.print(editScheduleId);
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(80,44);to=(89,4)]
                out.write("\"\r\n\t    scriptable = false\r\n\t    pluginspage = \"http://java.sun.com/products/plugin/index.html#download\">\r\n\t    <noembed>\r\n            \r\n            </noembed>\r\n\t</embed>\r\n    </comment>\r\n    </object>-->\r\n\t   ");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(89,6);to=(94,0)]
                
                	}
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(94,2);to=(104,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(104,12);to=(104,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(104,32);to=(224,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n\r\n<script src=\"./includes/addCommentDlgPopup.js\"></script>\r\n<script src=\"./includes/deleteDlgPopup.js\"></script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(224,3);to=(224,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(224,36);to=(227,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(227,9);to=(227,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(227,41);to=(234,2)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(234,4);to=(236,3)]
                 if (schedule != null)
                		{
                			
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(236,5);to=(236,18)]
                out.write("<h1>Schedule ");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(236,21);to=(236,39)]
                out.print(schedule.getName());
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(236,41);to=(236,46)]
                out.write("</h1>");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(236,48);to=(240,3)]
                
                		}
                		else
                		{
                			
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(240,5);to=(240,22)]
                out.write("<h1>Schedule</h1>");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(240,24);to=(241,4)]
                
                		} 
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(241,6);to=(247,5)]
                out.write("\r\n\t\r\n\t\t\r\n\t </div>\r\n        \r\n        <div class=\"Post\">\r\n  \t\t\t");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(247,7);to=(254,4)]
                 
                			if (schedule != null)
                			{
                				SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMMM d yyyy, hh:mm aaa");
                				
                				Account accCreatedBy = psc.getAccountManager().getAccount(schedule.getCreatedBy());
                				String ownerName = accCreatedBy.getName();
                				
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(254,6);to=(255,26)]
                out.write("\r\n\t\t\t\t<p><b>Created By:</b> ");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(255,29);to=(255,38)]
                out.print(ownerName);
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(255,40);to=(256,31)]
                out.write("</p>\r\n\t      \t\t<p><b>Created On:</b> ");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(256,34);to=(256,79)]
                out.print(sdf.format(schedule.getCreatedOn().getTime()));
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(256,81);to=(257,4)]
                out.write("</p>\r\n\t\t\t\t");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(257,6);to=(261,4)]
                
                			}
                			else
                			{
                				
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(261,6);to=(261,112)]
                out.write("<font color=\"#FF0000\" face=\"Arial, Helvetica, sans-serif\">An error occured processing your request.</font>");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(261,114);to=(262,4)]
                
                			}
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(262,6);to=(272,5)]
                out.write("\r\n        </div>\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(272,5);to=(272,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(272,47);to=(273,39)]
                out.write("\r\n\t\t<li><a href=\"#\" onClick=\"showDelete('");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(273,42);to=(273,85)]
                out.print(StringUtils.getJSString(schedule.getName()));
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(273,87);to=(273,90)]
                out.write("','");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(273,93);to=(273,119)]
                out.print(Operations.DELETE_SCHEDULE);
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(273,121);to=(273,124)]
                out.write("','");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(273,127);to=(273,143)]
                out.print(schedule.getId());
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(273,145);to=(274,66)]
                out.write("','Schedule','projectSchedules.jsp');\">Delete Schedule</a></li>\r\n\t    <li><a href=\"./projectSchedulesViewSchedule.jsp?editschedule=");

            // end
            // begin [file="/projectSchedulesViewSchedule.jsp";from=(274,69);to=(274,85)]
                out.print(schedule.getId());
            // end
            // HTML // begin [file="/projectSchedulesViewSchedule.jsp";from=(274,87);to=(296,0)]
                out.write("\">Edit Schedule</a></li>\r\n\t</ul>\r\n     <br/>\r\n    <br/>    \r\n\t<p>&nbsp;</p>\r\n</div>\r\n\r\n\r\n</div>\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
