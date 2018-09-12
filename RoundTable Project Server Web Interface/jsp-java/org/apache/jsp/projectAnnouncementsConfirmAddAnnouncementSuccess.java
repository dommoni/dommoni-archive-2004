package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectAnnouncementsConfirmAddAnnouncementSuccess extends HttpJspBase {


    static {
    }
    public projectAnnouncementsConfirmAddAnnouncementSuccess( ) {
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

            // HTML // begin [file="/projectAnnouncementsConfirmAddAnnouncementSuccess.jsp";from=(0,0);to=(1,0)]
                out.write("\r\n");

            // end
            // begin [file="/projectAnnouncementsConfirmAddAnnouncementSuccess.jsp";from=(1,2);to=(3,0)]
                
                    String parentLink = request.getParameter("parentlink");
            // end
            // HTML // begin [file="/projectAnnouncementsConfirmAddAnnouncementSuccess.jsp";from=(3,2);to=(8,26)]
                out.write("\r\n<html>\r\n<head><title>Add Comment</title>\r\n<script language=\"JavaScript\">\r\n// make the parent refresh and close this window.\r\nwindow.opener.location = '");

            // end
            // begin [file="/projectAnnouncementsConfirmAddAnnouncementSuccess.jsp";from=(8,29);to=(8,39)]
                out.print(parentLink);
            // end
            // HTML // begin [file="/projectAnnouncementsConfirmAddAnnouncementSuccess.jsp";from=(8,41);to=(13,7)]
                out.write("';\r\nwindow.close();\r\n</script>\r\n</head>\r\n<body bgcolor=\"#FFFFFF\">\r\n</body>");

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
