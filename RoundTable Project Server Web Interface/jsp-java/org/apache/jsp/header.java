package org.apache.jsp;

import java.util.HashMap;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class header extends HttpJspBase {


    static {
    }
    public header( ) {
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

            // HTML // begin [file="/header.jsp";from=(0,37);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/header.jsp";from=(2,50);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/header.jsp";from=(3,50);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/header.jsp";from=(4,66);to=(6,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/header.jsp";from=(6,52);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/header.jsp";from=(7,60);to=(9,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/header.jsp";from=(9,2);to=(15,0)]
                
                   ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                   Project currentProject = (Project)session.getAttribute("currentproject");
                   Account account = (Account)session.getAttribute("useraccount");
                   
                   HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
            // end
            // HTML // begin [file="/header.jsp";from=(15,2);to=(44,16)]
                out.write("\r\n\r\n<script>\r\nfunction showHelp()\r\n{\r\n   // width and height.\r\n   var w = 300;\r\n   var h = 125;\r\n\r\n   var winl = (screen.width - w) / 2;\r\n   var wint = (screen.height - h) / 2;\r\n   var settings  ='height='+h+',';\r\n   settings +='width='+w+',';\r\n   settings +='top='+wint+',';\r\n   settings +='left='+winl+',';\r\n   settings +='scrollbars=no,';\r\n   settings +='resizable=no';\r\n   \r\n   var win = window.open('', 'nohelp', settings);\r\n   win.document.write('<html>');\r\n   win.document.write('<head><title>Unavailable Feature</title></head>');\r\n   win.document.write('<body>');\r\n   win.document.write('<font face=\"Verdana\">We Appologize, Help is not currently available. <br>Please Check for RoundTable Updates.</font>');\r\n   win.document.write('</body>');\r\n   win.document.write('</html>');\r\n}\r\n</script>\r\n\r\n<h3>\r\n   Logged in as ");

            // end
            // begin [file="/header.jsp";from=(44,19);to=(44,36)]
                out.print(account.getName());
            // end
            // HTML // begin [file="/header.jsp";from=(44,38);to=(44,84)]
                out.write(" (<a href=\"./servlet/ControllerServlet?opcode=");

            // end
            // begin [file="/header.jsp";from=(44,87);to=(44,104)]
                out.print(Operations.LOGOUT);
            // end
            // HTML // begin [file="/header.jsp";from=(44,106);to=(48,8)]
                out.write("\">Log-out</a>) <BR/>\r\n   <a href=\"projectUserSettings.jsp\">Settings</a> | <a href=\"#\" onClick=\"showHelp();\">Help</a> \r\n</h3>\r\n\t\t\t  \r\n      \t\t");

            // end
            // begin [file="/header.jsp";from=(48,10);to=(52,6)]
                
                			if(currentProject == null)
                			{
                			// <img src="images/main-logo.gif">
                			   
            // end
            // HTML // begin [file="/header.jsp";from=(52,8);to=(52,46)]
                out.write("<img src=\"images/roundtable-logo.gif\">");

            // end
            // begin [file="/header.jsp";from=(52,48);to=(56,6)]
                
                			}
                			else
                			{
                			   
            // end
            // HTML // begin [file="/header.jsp";from=(56,8);to=(57,56)]
                out.write("<h1>\r\n\t\t\t\t <font face=\"Verdana, Arial, Helvetica, sans-serif\">");

            // end
            // begin [file="/header.jsp";from=(57,59);to=(57,83)]
                out.print(currentProject.getName());
            // end
            // HTML // begin [file="/header.jsp";from=(57,85);to=(59,6)]
                out.write("</font>\r\n\t\t\t     </h1>\r\n\t\t\t   ");

            // end
            // begin [file="/header.jsp";from=(59,8);to=(61,3)]
                
                			}
                			
            // end
            // HTML // begin [file="/header.jsp";from=(61,5);to=(63,64)]
                out.write("\r\n\t\t\t \t\r\n            <img src=\"images/spacer.gif\" width=\"10\" height=\"20\">");

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
