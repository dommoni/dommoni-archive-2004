package org.apache.jsp;

import java.util.HashMap;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Notification;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.projectServer.services.notificationManager.INotificationManager;
import com.dommoni.ece.webui.notifications.NotificationUtils;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectNotificationsViewNotifications extends HttpJspBase {


    static {
    }
    public projectNotificationsViewNotifications( ) {
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

            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(0,37);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(2,50);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(3,55);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(5,66);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(6,106);to=(8,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(8,73);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(9,60);to=(11,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectNotificationsViewNotifications.jsp";from=(11,2);to=(23,0)]
                
                    // notification for User/Project/Object
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	
                	Account account = (Account)session.getAttribute("useraccount");
                	Project project = (Project)session.getAttribute("currentproject");
                	
                	INotificationManager notificationManager = psc.getNotificationManager();
                	Notification notifications[] = notificationManager.getAllNotificationsForAccountProject(account.getId(), project.getId());
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(23,2);to=(33,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectNotificationsViewNotifications.jsp";from=(33,12);to=(33,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(33,32);to=(150,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectNotificationsViewNotifications.jsp";from=(150,3);to=(150,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(150,36);to=(153,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectNotificationsViewNotifications.jsp";from=(153,9);to=(153,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(153,41);to=(166,3)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t<h1>Notifications</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\"> \r\n  \t");

            // end
            // begin [file="/projectNotificationsViewNotifications.jsp";from=(166,5);to=(169,5)]
                
                	    if(notifications != null && notifications.length > 0)
                		{ 
                		   
            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(169,7);to=(169,57)]
                out.write("<table border=\"0\" cellspacing=\"3\" cellpadding=\"6\">");

            // end
            // begin [file="/projectNotificationsViewNotifications.jsp";from=(169,59);to=(173,5)]
                
                		   NotificationUtils nu = new NotificationUtils();
                		   for(int i = 0; i < notifications.length; i++)
                		   {  
                			  
            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(173,7);to=(175,87)]
                out.write("\r\n\t\t\t <tr>\r\n\t\t\t   <td width=\"225\"><a href=\"projectNotificationsViewNotification.jsp?notificationid=");

            // end
            // begin [file="/projectNotificationsViewNotifications.jsp";from=(175,90);to=(175,114)]
                out.print(notifications[i].getId());
            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(175,116);to=(175,169)]
                out.write("\"><font face=\"Verdana, Arial, Helvetica, sans-serif\">");

            // end
            // begin [file="/projectNotificationsViewNotifications.jsp";from=(175,172);to=(175,216)]
                out.print(nu.getNameFromNotification(notifications[i]));
            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(175,218);to=(177,5)]
                out.write("</font></a></td>\r\n\t\t\t </tr>\r\n\t\t\t  ");

            // end
            // begin [file="/projectNotificationsViewNotifications.jsp";from=(177,7);to=(179,5)]
                  
                		   }
                		   
            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(179,7);to=(179,15)]
                out.write("</table>");

            // end
            // begin [file="/projectNotificationsViewNotifications.jsp";from=(179,17);to=(183,5)]
                
                		}
                		else
                		{
                		   
            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(183,7);to=(183,61)]
                out.write("<P>There are currently no notifications available.</P>");

            // end
            // begin [file="/projectNotificationsViewNotifications.jsp";from=(183,63);to=(185,1)]
                
                		}
                	
            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(185,3);to=(196,5)]
                out.write("\r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectNotificationsViewNotifications.jsp";from=(196,5);to=(196,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectNotificationsViewNotifications.jsp";from=(196,47);to=(221,0)]
                out.write("\t\r\n\t</ul>\r\n     <br/>\r\n    <br/>\r\n\t<P>&nbsp;</P>    \r\n</div>\r\n\r\n\r\n</div>\r\n\r\n\r\n    </div>\r\n  </div>\r\n\r\n  <div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n\r\n\r\n");

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
