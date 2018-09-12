package org.apache.jsp;

import java.util.HashMap;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectNotificationsNewNotification extends HttpJspBase {


    static {
    }
    public projectNotificationsNewNotification( ) {
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

            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(0,37);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(2,52);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(3,60);to=(5,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectNotificationsNewNotification.jsp";from=(5,2);to=(10,0)]
                
                   String notificationObject = request.getParameter("no");
                   
                   HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                   HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(10,2);to=(19,9)]
                out.write("\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectNotificationsNewNotification.jsp";from=(19,12);to=(19,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(19,32);to=(150,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n//-->\r\n</script>\r\n</head>\r\n\r\n<script>\r\nfunction newTodoFolder()\r\n{\r\n   var newWin = open('projectTodosNewToDoFolder.jsp','','height=200,width=300,directories=no,location=no,menubar=no,resizable=no,scrollbars=no,status=no,toolbar=no,screenX=200,screenY=200,top=0,left=0');\r\n}\r\n</script>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectNotificationsNewNotification.jsp";from=(150,3);to=(150,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(150,36);to=(153,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectNotificationsNewNotification.jsp";from=(153,9);to=(153,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(153,41);to=(160,1)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \r\n\t");

            // end
            // begin [file="/projectNotificationsNewNotification.jsp";from=(160,3);to=(163,4)]
                 	
                	if(notificationObject != null && notificationObject.length() > 0)
                	{	
                	   
            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(163,6);to=(163,14)]
                out.write("<h1>New ");

            // end
            // begin [file="/projectNotificationsNewNotification.jsp";from=(163,17);to=(163,35)]
                out.print(notificationObject);
            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(163,37);to=(163,55)]
                out.write(" Notification</h1>");

            // end
            // begin [file="/projectNotificationsNewNotification.jsp";from=(163,57);to=(167,4)]
                
                	}
                	else
                	{
                	   
            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(167,6);to=(167,31)]
                out.write("<h1>New Notification</h1>");

            // end
            // begin [file="/projectNotificationsNewNotification.jsp";from=(167,33);to=(169,1)]
                
                	}
                	
            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(169,3);to=(184,49)]
                out.write("\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n  <!--ToDo's--> \r\n  \t      <form name=\"form1\" method=\"post\" action=\"./servlet/ControllerServlet\">\r\n            <p>Name: \r\n              <input type=\"text\" name=\"name\">\r\n              (optional)</p>\r\n            <p>Type: </p>\r\n            <table width=\"334\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n              <tr>\r\n                <td width=\"28\">&nbsp;</td>\r\n                <td width=\"266\">Notify me when a ");

            // end
            // begin [file="/projectNotificationsNewNotification.jsp";from=(184,52);to=(184,70)]
                out.print(notificationObject);
            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(184,72);to=(191,49)]
                out.write(" is <b>created</b>:</td>\r\n                <td width=\"40\"> \r\n                  <input type=\"checkbox\" name=\"create\" value=\"true\">\r\n                </td>\r\n              </tr>\r\n              <tr>\r\n                <td width=\"28\">&nbsp;</td>\r\n                <td width=\"266\">Notify me when a ");

            // end
            // begin [file="/projectNotificationsNewNotification.jsp";from=(191,52);to=(191,70)]
                out.print(notificationObject);
            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(191,72);to=(198,49)]
                out.write(" is <b>deleted</b>:</td>\r\n                <td width=\"40\"> \r\n                  <input type=\"checkbox\" name=\"delete\" value=\"true\">\r\n                </td>\r\n              </tr>\r\n              <tr>\r\n                <td width=\"28\">&nbsp;</td>\r\n                <td width=\"266\">Notify me when a ");

            // end
            // begin [file="/projectNotificationsNewNotification.jsp";from=(198,52);to=(198,70)]
                out.print(notificationObject);
            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(198,72);to=(212,52)]
                out.write(" is <b>modified</b>:</td>\r\n                <td width=\"40\"> \r\n                  <input type=\"checkbox\" name=\"modify\" value=\"true\">\r\n                </td>\r\n              </tr>\r\n              <tr>\r\n                <td width=\"28\">&nbsp;</td>\r\n                <td width=\"266\">&nbsp;</td>\r\n                <td width=\"40\">&nbsp; </td>\r\n              </tr>\r\n            </table>\r\n            <p> \r\n              <input type=\"submit\" name=\"Submit\" value=\"Create\">\r\n              <input type=\"button\" name=\"Button\" value=\"Cancel\" onClick=\"MM_callJS('window.history.go(-1)')\">\r\n              <input type=\"hidden\" name=\"no\" value=\"");

            // end
            // begin [file="/projectNotificationsNewNotification.jsp";from=(212,55);to=(212,73)]
                out.print(notificationObject);
            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(212,75);to=(213,56)]
                out.write("\">\r\n              <input type=\"hidden\" name=\"opcode\" value=\"");

            // end
            // begin [file="/projectNotificationsNewNotification.jsp";from=(213,59);to=(213,89)]
                out.print(Operations.CREATE_NOTIFICATION);
            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(213,91);to=(226,5)]
                out.write("\">\r\n            </p>\r\n          </form>\r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectNotificationsNewNotification.jsp";from=(226,5);to=(226,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectNotificationsNewNotification.jsp";from=(226,47);to=(247,0)]
                out.write("\r\n\t</ul>\r\n     <br/>\r\n    <br/>\r\n\t<P>&nbsp;</P>    \r\n</div>\r\n\r\n\r\n</div>\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
