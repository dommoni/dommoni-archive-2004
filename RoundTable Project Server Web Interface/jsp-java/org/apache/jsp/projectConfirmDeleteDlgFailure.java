package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectConfirmDeleteDlgFailure extends HttpJspBase {


    static {
    }
    public projectConfirmDeleteDlgFailure( ) {
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

            // HTML // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(0,0);to=(1,0)]
                out.write("\r\n");

            // end
            // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(1,2);to=(7,0)]
                
                
                	String objectName = request.getParameter("name");
                	String opCode = request.getParameter("opcode");
                	String opParam = request.getParameter("opparam");
                	String context = request.getParameter("context");
            // end
            // HTML // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(7,2);to=(9,20)]
                out.write("\r\n<html>\r\n<head><title>Delete ");

            // end
            // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(9,23);to=(9,30)]
                out.print(context);
            // end
            // HTML // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(9,32);to=(19,2)]
                out.write("</title>\r\n<script language=\"JavaScript\">\r\nfunction closeWindow()\r\n{\r\n \twindow.close();\r\n}\r\n</script>\r\n</head>\r\n<body bgcolor=\"#FFFFFF\">\r\n<p><font size=\"3\" color=\"#000000\" face=\"Arial, Helvetica, sans-serif\"><b>Delete \r\n  ");

            // end
            // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(19,5);to=(19,12)]
                out.print(context);
            // end
            // HTML // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(19,14);to=(21,12)]
                out.write(" </b> </font></p>\r\n<p><font face=\"Arial, Helvetica, sans-serif\" size=\"2\">Are you sure you want to \r\n  delete <b>");

            // end
            // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(21,15);to=(21,25)]
                out.print(objectName);
            // end
            // HTML // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(21,27);to=(26,44)]
                out.write("</b>?</font></p>\r\n\r\n<form name=\"form1\" method=\"post\" action=\"./servlet/ControllerServlet\">\r\n  <input type=\"submit\" name=\"Submit\" value=\"Delete\">\r\n  <input type=\"button\" name=\"Button\" value=\"Cancel\" onClick=\"closeWindow()\">\r\n  <input type=\"hidden\" name=\"opcode\" value=\"");

            // end
            // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(26,47);to=(26,53)]
                out.print(opCode);
            // end
            // HTML // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(26,55);to=(27,2)]
                out.write("\">\r\n  ");

            // end
            // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(27,4);to=(31,43)]
                
                  //
                  // We have to do this ridiculous context-name compare to generate the 
                  // parameter name...
                  if(context.equalsIgnoreCase("document")){
            // end
            // HTML // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(31,45);to=(33,48)]
                out.write("\r\n  \r\n  <input type=\"hidden\" name=\"documentid\" value=\"");

            // end
            // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(33,51);to=(33,58)]
                out.print(opParam);
            // end
            // HTML // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(33,60);to=(34,2)]
                out.write("\">\r\n  ");

            // end
            // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(34,4);to=(34,5)]
                }
            // end
            // HTML // begin [file="/projectConfirmDeleteDlgFailure.jsp";from=(34,7);to=(36,7)]
                out.write("\r\n</form>\r\n</body>");

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
