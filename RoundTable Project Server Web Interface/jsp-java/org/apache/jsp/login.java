package org.apache.jsp;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.SessionType;
import com.dommoni.ece.webui.MenuController;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import com.dommoni.ece.webui.XMLProperties;
import com.dommoni.ece.webui.menus.MenuItemMap;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class login extends HttpJspBase {


    static {
    }
    public login( ) {
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

            // HTML // begin [file="/login.jsp";from=(0,32);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/login.jsp";from=(2,41);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/login.jsp";from=(3,37);to=(5,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/login.jsp";from=(5,50);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/login.jsp";from=(6,54);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/login.jsp";from=(7,66);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/login.jsp";from=(8,54);to=(10,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/login.jsp";from=(10,56);to=(11,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/login.jsp";from=(11,52);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/login.jsp";from=(12,60);to=(13,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/login.jsp";from=(13,55);to=(15,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/login.jsp";from=(15,59);to=(17,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/login.jsp";from=(17,2);to=(25,0)]
                
                	boolean loginFailed = false;
                	String loginFailureReason = "";
                	String username = request.getParameter("username");
                	String password = request.getParameter("password");
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/login.jsp";from=(25,2);to=(33,7)]
                out.write("\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n<head>\r\n<meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n<title>");

            // end
            // begin [file="/login.jsp";from=(33,10);to=(33,28)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/login.jsp";from=(33,30);to=(141,0)]
                out.write("</title>\r\n<link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n<style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n</head>\r\n\r\n<script>\r\nfunction setFocus()\r\n{\r\n\tdocument.form1.username.focus();\r\n}\r\n</script>\r\n\r\n");

            // end
            // begin [file="/login.jsp";from=(141,2);to=(174,0)]
                
                	if(username != null && password != null)
                	{
                	    String ipaddr = (String)getServletContext().getAttribute("projectServerIpAddress");
                		
                		int port;
                		try
                		{
                		   port = Integer.parseInt((String)getServletContext().getAttribute("projectServerPort"));
                		}
                		catch(NumberFormatException nfe)
                		{
                		   port = 8080;
                		   nfe.printStackTrace();
                		}
                		
                		ProjectServerConnection psc = new ProjectServerConnection(username, password, SessionType.WEBUI_SESSION, ipaddr, port);
                		try
                		{
                			psc.login();
                			
                			session.setAttribute("psc", psc);
                			session.setAttribute("menus", ((MenuItemMap)WebUIConfiguration.getInstance().get("menus")).clone());
                			session.setAttribute("mc", new MenuController());
                			
                			response.sendRedirect("./servlet/ControllerServlet?opcode=" + Operations.LOGIN);
                		}
                		catch(Exception e)
                		{
                		    e.printStackTrace();
                			loginFailed = true;
                		}
                	}
            // end
            // HTML // begin [file="/login.jsp";from=(174,2);to=(205,12)]
                out.write("\r\n<body onload=\"setFocus()\">\r\n<div id=\"StatusBarContainer\"> \r\n  <div id=\"Statusbar\"> \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n  </div>\r\n</div>\r\n<div class=\"Shadow\" id=\"Shadow\"> \r\n  <div class=\"Container\"> \r\n    <div id=\"Header\"> \r\n      \r\n      <img src=\"images/roundtable-logo.gif\" width=\"302\" height=\"71\">\r\n      \r\n    </div>\r\n    <div id=\"ContentFrame\"> \r\n      <div class=\"Left\"> \r\n        \r\n        <div class=\"Post\"> \r\n          <h1> Login \r\n          </h1>\r\n          <form name=\"form1\" method=\"post\" action=\"\" focus=\"username\">\r\n            <p>Username: \r\n              <input type=\"text\" name=\"username\">\r\n            </p>\r\n            <p>Password: \r\n              <input type=\"password\" name=\"password\">\r\n            </p>\r\n            <p> \r\n              <input type=\"submit\" name=\"Submit\" value=\"Login\">\r\n            </p>\r\n            ");

            // end
            // begin [file="/login.jsp";from=(205,14);to=(208,14)]
                if(loginFailed)
                						  {
                							   if(loginFailureReason.length() == 0) {
                						        
            // end
            // HTML // begin [file="/login.jsp";from=(208,16);to=(208,41)]
                out.write("<p><font color=\"#FF0000\">");

            // end
            // begin [file="/login.jsp";from=(208,44);to=(208,70)]
                out.print(texts.get("login.failure"));
            // end
            // HTML // begin [file="/login.jsp";from=(208,72);to=(208,83)]
                out.write("</font></p>");

            // end
            // begin [file="/login.jsp";from=(208,85);to=(210,12)]
                
                								 } else {
                								    
            // end
            // HTML // begin [file="/login.jsp";from=(210,14);to=(210,39)]
                out.write("<p><font color=\"#FF0000\">");

            // end
            // begin [file="/login.jsp";from=(210,42);to=(210,60)]
                out.print(loginFailureReason);
            // end
            // HTML // begin [file="/login.jsp";from=(210,62);to=(210,73)]
                out.write("</font></p>");

            // end
            // begin [file="/login.jsp";from=(210,75);to=(212,8)]
                
                								 }
                							}
            // end
            // HTML // begin [file="/login.jsp";from=(212,10);to=(224,0)]
                out.write("\r\n          </form>\r\n        </div>\r\n      </div>\r\n      \r\n    </div>\r\n  </div>\r\n  <div class=\"ShadowCap\"> &nbsp; </div>\r\n</div>\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n</body>\r\n</html>\r\n");

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
