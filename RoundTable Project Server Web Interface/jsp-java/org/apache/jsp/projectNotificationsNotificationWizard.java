package org.apache.jsp;

import java.util.HashMap;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectNotificationsNotificationWizard extends HttpJspBase {


    static {
    }
    public projectNotificationsNotificationWizard( ) {
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

            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(0,37);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(2,50);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(3,50);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(4,66);to=(6,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(6,60);to=(8,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectNotificationsNotificationWizard.jsp";from=(8,2);to=(19,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	String nc = null;
                	if(request.getParameter("nc") != null && request.getParameter("nc").length() > 0)
                		nc = request.getParameter("nc");
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(19,2);to=(29,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectNotificationsNotificationWizard.jsp";from=(29,12);to=(29,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(29,32);to=(153,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n//-->\r\n</script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectNotificationsNotificationWizard.jsp";from=(153,3);to=(153,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(153,36);to=(156,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectNotificationsNotificationWizard.jsp";from=(156,9);to=(156,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(156,41);to=(163,1)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t");

            // end
            // begin [file="/projectNotificationsNotificationWizard.jsp";from=(163,3);to=(168,1)]
                
                	String ncName = nc.toLowerCase();
                	char[] ncChars = ncName.toCharArray();
                	ncChars[0] = Character.toUpperCase(ncName.charAt(0));
                	ncName = new String(ncChars); 
                	
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(168,3);to=(169,9)]
                out.write("\t\r\n\t<h1>New ");

            // end
            // begin [file="/projectNotificationsNotificationWizard.jsp";from=(169,12);to=(169,18)]
                out.print(ncName);
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(169,20);to=(176,3)]
                out.write(" Notification</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n\t  <!-- PAGE TEXT GOES HERE -->\r\n\t  ");

            // end
            // begin [file="/projectNotificationsNotificationWizard.jsp";from=(176,5);to=(179,3)]
                
                	  if(nc != null && nc.length() > 0)
                	  {
                	  
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(179,5);to=(193,43)]
                out.write("\r\n\t  <form name=\"form1\" method=\"get\" action=\"projectNotificationsNotificationWizard2.jsp\">\r\n\t\t  <blockquote> \r\n\t\t\t  <p><font face=\"Arial, Helvetica, sans-serif\" size=\"3\" color=\"#000000\">Nofity \r\n                me of activity for a:</font></p>\r\n\t\t\t<!--<p> <font face=\"Arial, Helvetica, sans-serif\">\r\n\t\t\t  <input type=\"radio\" name=\"type\" value=\"user\" >\r\n                <font color=\"#000000\">User</font></font></p>-->\r\n\t\t\t<p> <font face=\"Arial, Helvetica, sans-serif\"> \r\n\t\t\t  <input type=\"radio\" name=\"type\" value=\"object\">\r\n                <font color=\"#000000\">Object</font></font></p>\r\n\t\t\t<p> \r\n\t\t\t  <input type=\"submit\" name=\"Submit\" value=\"Next\">\r\n\t\t\t  <input type=\"button\" name=\"Submit2\" value=\"Cancel\" onClick=\"MM_callJS('window.history.go(-1)')\">\r\n\t\t\t  <input type=\"hidden\" name=\"nc\" value=\"");

            // end
            // begin [file="/projectNotificationsNotificationWizard.jsp";from=(193,46);to=(193,48)]
                out.print(nc);
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(193,50);to=(194,45)]
                out.write("\">\r\n\t\t\t  <input type=\"hidden\" name=\"path\" value=\"");

            // end
            // begin [file="/projectNotificationsNotificationWizard.jsp";from=(194,48);to=(194,76)]
                out.print(request.getParameter("path"));
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(194,78);to=(198,7)]
                out.write("\">\r\n\t\t\t</p>\r\n\t\t  </blockquote>\r\n\t   </form>\r\n\t      ");

            // end
            // begin [file="/projectNotificationsNotificationWizard.jsp";from=(198,9);to=(202,7)]
                
                	   }
                	   else
                	   {
                	      
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(202,9);to=(205,10)]
                out.write("\r\n          <font face=\"Arial, Helvetica, sans-serif\" color=\"#FF0000\">Error creating \r\n          the notification context.</font> \r\n          ");

            // end
            // begin [file="/projectNotificationsNotificationWizard.jsp";from=(205,12);to=(207,4)]
                
                	   }
                	   
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(207,6);to=(218,5)]
                out.write("\r\n        </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectNotificationsNotificationWizard.jsp";from=(218,5);to=(218,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard.jsp";from=(218,47);to=(241,0)]
                out.write("\t  \r\n\t</ul>\r\n     <br/>\r\n    <br/>    \r\n    <P>&nbsp;</P>\r\n</div>\r\n\r\n\r\n</div>\r\n\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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