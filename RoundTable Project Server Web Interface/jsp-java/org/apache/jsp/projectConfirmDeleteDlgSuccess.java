package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectConfirmDeleteDlgSuccess extends HttpJspBase {


    static {
    }
    public projectConfirmDeleteDlgSuccess( ) {
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

            // HTML // begin [file="/projectConfirmDeleteDlgSuccess.jsp";from=(0,0);to=(1,0)]
                out.write("\r\n");

            // end
            // begin [file="/projectConfirmDeleteDlgSuccess.jsp";from=(1,2);to=(6,0)]
                
                    String objectName = request.getParameter("name");
                	String opCode = request.getParameter("opcode");
                	String opParam = request.getParameter("opparam");
                	String context = request.getParameter("context");
            // end
            // HTML // begin [file="/projectConfirmDeleteDlgSuccess.jsp";from=(6,2);to=(8,20)]
                out.write("\r\n<html>\r\n<head><title>Delete ");

            // end
            // begin [file="/projectConfirmDeleteDlgSuccess.jsp";from=(8,23);to=(8,30)]
                out.print(context);
            // end
            // HTML // begin [file="/projectConfirmDeleteDlgSuccess.jsp";from=(8,32);to=(10,26)]
                out.write("</title>\r\n<script language=\"JavaScript\">\r\nwindow.opener.location = '");

            // end
            // begin [file="/projectConfirmDeleteDlgSuccess.jsp";from=(10,29);to=(10,63)]
                out.print(request.getParameter("parentlink"));
            // end
            // HTML // begin [file="/projectConfirmDeleteDlgSuccess.jsp";from=(10,65);to=(15,7)]
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
