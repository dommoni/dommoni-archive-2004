package org.apache.jsp;

import com.dommoni.ece.webui.Operations;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectDiscussionsCheckDelete extends HttpJspBase {


    static {
    }
    public projectDiscussionsCheckDelete( ) {
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

            // HTML // begin [file="/projectDiscussionsCheckDelete.jsp";from=(0,52);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectDiscussionsCheckDelete.jsp";from=(2,2);to=(5,0)]
                
                	String discussionId = request.getParameter("discussionId");
                	String discussionName = request.getParameter("discussionName");
            // end
            // HTML // begin [file="/projectDiscussionsCheckDelete.jsp";from=(5,2);to=(25,8)]
                out.write("\r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n\r\nfunction closeWindow()\r\n{\r\n\twindow.close();\r\n}\r\n//-->\r\n</script>\r\n<title>Delete Discussion?</title>\r\n\r\n\r\n<h2 align=\"center\"><font face=\"Arial, Helvetica, sans-serif\">Delete Discussion?</font></h2>\r\n<form name=\"form1\" method=\"post\" action=\"./servlet/ControllerServlet\">\r\n  <p align=\"center\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" color=\"#006699\">Are \r\n    you sure you want to permanently remove<br>\r\n    <b>\"");

            // end
            // begin [file="/projectDiscussionsCheckDelete.jsp";from=(25,11);to=(25,25)]
                out.print(discussionName);
            // end
            // HTML // begin [file="/projectDiscussionsCheckDelete.jsp";from=(25,27);to=(29,52)]
                out.write("\"</b> from the system?</font></p>\r\n  <p align=\"center\"> \r\n    <input type=\"submit\" name=\"Submit\" value=\"Delete\">\r\n    <input type=\"button\" name=\"Submit2\" value=\"Cancel\" onClick=\"MM_callJS('closeWindow()')\">\r\n    <input type=\"hidden\" name=\"discussionId\" value=\"");

            // end
            // begin [file="/projectDiscussionsCheckDelete.jsp";from=(29,55);to=(29,67)]
                out.print(discussionId);
            // end
            // HTML // begin [file="/projectDiscussionsCheckDelete.jsp";from=(29,69);to=(30,54)]
                out.write("\">\r\n    <input type=\"hidden\" name=\"discussionName\" value=\"");

            // end
            // begin [file="/projectDiscussionsCheckDelete.jsp";from=(30,57);to=(30,71)]
                out.print(discussionName);
            // end
            // HTML // begin [file="/projectDiscussionsCheckDelete.jsp";from=(30,73);to=(31,43)]
                out.write("\">\r\n\t<input type=\"hidden\" name=\"opcode\" value=\"");

            // end
            // begin [file="/projectDiscussionsCheckDelete.jsp";from=(31,46);to=(31,74)]
                out.print(Operations.DELETE_DISCUSSION);
            // end
            // HTML // begin [file="/projectDiscussionsCheckDelete.jsp";from=(31,76);to=(35,0)]
                out.write("\">\r\n  </p>\r\n</form>\r\n\r\n");

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
