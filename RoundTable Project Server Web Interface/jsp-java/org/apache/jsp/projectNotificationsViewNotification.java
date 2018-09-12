package org.apache.jsp;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Notification;
import com.dommoni.roundtable.NotificationType;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.projectServer.services.notificationManager.INotificationManager;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.notifications.NotificationUtils;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectNotificationsViewNotification extends HttpJspBase {


    static {
    }
    public projectNotificationsViewNotification( ) {
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

            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(0,46);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(1,37);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(3,50);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(4,55);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(5,59);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(6,50);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(7,66);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(8,106);to=(10,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(10,52);to=(11,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(11,73);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(12,60);to=(14,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(14,2);to=(28,0)]
                
                // notification for User/Project/Object
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	
                	Account account = (Account)session.getAttribute("useraccount");
                	Project project = (Project)session.getAttribute("currentproject");
                	
                	int notificationId = Integer.parseInt(request.getParameter("notificationid"));
                	
                	INotificationManager notificationManager = psc.getNotificationManager();
                	Notification notification = notificationManager.getNotification(notificationId);
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(28,2);to=(38,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(38,12);to=(38,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(38,32);to=(156,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script src=\"./includes/deleteDlgPopup.js\"></script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(156,3);to=(156,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(156,36);to=(159,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(159,9);to=(159,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(159,41);to=(172,3)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t<h1>Notifications</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\"> \r\n  \t");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(172,5);to=(176,9)]
                
                	    if(notification != null)
                	    {
                	        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMMM d yyyy, hh:mm aaa");
                	        
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(176,11);to=(177,18)]
                out.write("\r\n\t\t<p><b>Name:</b> ");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(177,21);to=(177,43)]
                out.print(notification.getName());
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(177,45);to=(178,35)]
                out.write("</p>\r\n                <p><b>Context:</b> ");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(178,38);to=(178,63)]
                out.print(notification.getContext());
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(178,65);to=(179,38)]
                out.write("</p>\r\n                <p><b>Created On:</b> ");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(179,41);to=(179,90)]
                out.print(sdf.format(notification.getCreatedOn().getTime()));
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(179,92);to=(181,2)]
                out.write("</p>\r\n\t\t\r\n\t\t");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(181,4);to=(183,5)]
                if(notification.getType() == NotificationType.USER) 
                		{
                		   
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(183,7);to=(183,53)]
                out.write("<p><b>Type:</b> User Oriented Notification</p>");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(183,55);to=(187,5)]
                 
                		} 
                		else if(notification.getType() == NotificationType.OBJECT) 
                		{
                		   
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(187,7);to=(187,55)]
                out.write("<p><b>Type:</b> Object Oriented Notification</p>");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(187,57);to=(192,5)]
                
                		}
                   		
                		if(notification.getOperation() == Notification.CREATE_OPERATION) 
                		{
                		   
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(192,7);to=(192,38)]
                out.write("<p><b>Operation:</b> Create</p>");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(192,40);to=(196,5)]
                
                		}
                                else if(notification.getOperation() == Notification.MODIFICATION_OPERATION) 
                		{
                		   
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(196,7);to=(196,38)]
                out.write("<p><b>Operation:</b> Modify</p>");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(196,40);to=(200,5)]
                
                		}
                                else if(notification.getOperation() == Notification.DELETION_OPERATION) 
                		{
                		   
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(200,7);to=(200,38)]
                out.write("<p><b>Operation:</b> Delete</p>");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(200,40);to=(205,5)]
                
                		}
                                //if(notification.getOperation() == Notification.RETREIVAL_OPERATION) {}// not implemented.
                                else if(notification.getOperation() == Notification.ANY_OPERATION) 
                		{
                		   
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(205,7);to=(205,45)]
                out.write("<p><b>Operation:</b> Any Operation</p>");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(205,47);to=(208,1)]
                
                		}
                            }
                	
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(208,3);to=(219,5)]
                out.write("\r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(219,5);to=(219,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(219,47);to=(220,8)]
                out.write("\r\n        ");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(220,10);to=(222,4)]
                if(notification.getCreatedBy() == account.getId())
                	{
                	   
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(222,6);to=(223,81)]
                out.write("\r\n\t   <!--<li><a href=\"./projectNotificationsModifyNotification.jsp?notificationid=");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(223,84);to=(223,104)]
                out.print(notification.getId());
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(223,106);to=(223,115)]
                out.write("&respath=");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(223,118);to=(223,142)]
                out.print(request.getServletPath());
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(223,144);to=(224,56)]
                out.write("\">Modify Notification</a></li>-->\r\n\t   <li><a href=\"#\" onClick=\"showDelete('Notification','");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(224,59);to=(224,89)]
                out.print(Operations.DELETE_NOTIFICATION);
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(224,91);to=(224,94)]
                out.write("','");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(224,97);to=(224,117)]
                out.print(notification.getId());
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(224,119);to=(225,4)]
                out.write("','Notification','projectNotificationsViewNotification.jsp');\">Delete Notification</a></li>\r\n\t   ");

            // end
            // begin [file="/projectNotificationsViewNotification.jsp";from=(225,6);to=(226,2)]
                
                	}
            // end
            // HTML // begin [file="/projectNotificationsViewNotification.jsp";from=(226,4);to=(250,0)]
                out.write("\t\r\n\t</ul>\r\n     <br/>\r\n    <br/>\r\n\t<P>&nbsp;</P>    \r\n</div>\r\n\r\n\r\n</div>\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n\r\n\r\n");

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
