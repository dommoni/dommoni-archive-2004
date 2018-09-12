package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectConfirmDeleteCommentDlg extends HttpJspBase {


    static {
    }
    public projectConfirmDeleteCommentDlg( ) {
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

            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(0,0);to=(1,0)]
                out.write("\r\n");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(1,2);to=(8,0)]
                
                	String objectName = request.getParameter("name");
                	String opCode = request.getParameter("opcode");
                	String opParam = request.getParameter("opparam");
                	String context = request.getParameter("context");
                	
                	String parentLink = request.getParameter("parentlink");
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(8,2);to=(10,20)]
                out.write("\r\n<html>\r\n<head><title>Delete ");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(10,23);to=(10,30)]
                out.print(context);
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(10,32);to=(20,2)]
                out.write("</title>\r\n<script language=\"JavaScript\">\r\nfunction closeWindow()\r\n{\r\n \twindow.close();\r\n}\r\n</script>\r\n</head>\r\n<body bgcolor=\"#FFFFFF\">\r\n<p><font size=\"3\" color=\"#000000\" face=\"Arial, Helvetica, sans-serif\"><b>Delete \r\n  ");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(20,5);to=(20,12)]
                out.print(context);
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(20,14);to=(22,12)]
                out.write(" </b> </font></p>\r\n<p><font face=\"Arial, Helvetica, sans-serif\" size=\"2\">Are you sure you want to \r\n  delete <b>");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(22,15);to=(22,25)]
                out.print(objectName);
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(22,27);to=(27,44)]
                out.write("</b>?</font></p>\r\n\r\n<form name=\"form1\" method=\"post\" action=\"./servlet/ControllerServlet\">\r\n  <input type=\"submit\" name=\"Submit\" value=\"Delete\">\r\n  <input type=\"button\" name=\"Button\" value=\"Cancel\" onClick=\"closeWindow()\">\r\n  <input type=\"hidden\" name=\"opcode\" value=\"");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(27,47);to=(27,53)]
                out.print(opCode);
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(27,55);to=(28,48)]
                out.write("\">\r\n  <input type=\"hidden\" name=\"parentlink\" value=\"");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(28,51);to=(28,61)]
                out.print(parentLink);
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(28,63);to=(29,2)]
                out.write("\">\r\n  ");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(29,4);to=(35,5)]
                
                  //
                  // We have to do this ridiculous context-name compare to generate the 
                  // parameter name...
                  if(context.equalsIgnoreCase("document"))
                  {
                     
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(35,7);to=(35,53)]
                out.write("<input type=\"hidden\" name=\"documentid\" value=\"");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(35,56);to=(35,63)]
                out.print(opParam);
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(35,65);to=(35,67)]
                out.write("\">");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(35,69);to=(39,5)]
                
                  }
                  else if(context.equalsIgnoreCase("todo"))
                  {
                     
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(39,7);to=(39,49)]
                out.write("<input type=\"hidden\" name=\"todoid\" value=\"");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(39,52);to=(39,59)]
                out.print(opParam);
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(39,61);to=(39,63)]
                out.write("\">");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(39,65);to=(43,5)]
                
                  }
                  else if(context.equalsIgnoreCase("forum"))
                  {
                     
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(43,7);to=(43,50)]
                out.write("<input type=\"hidden\" name=\"forumid\" value=\"");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(43,53);to=(43,60)]
                out.print(opParam);
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(43,62);to=(43,64)]
                out.write("\">");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(43,66);to=(47,5)]
                
                  }
                  else if(context.equalsIgnoreCase("meeting"))
                  {
                     
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(47,7);to=(47,52)]
                out.write("<input type=\"hidden\" name=\"meetingid\" value=\"");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(47,55);to=(47,62)]
                out.print(opParam);
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(47,64);to=(47,66)]
                out.write("\">");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(47,68);to=(51,5)]
                
                  }
                  else if(context.equalsIgnoreCase("account"))
                  {
                     
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(51,7);to=(51,52)]
                out.write("<input type=\"hidden\" name=\"accountid\" value=\"");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(51,55);to=(51,62)]
                out.print(opParam);
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(51,64);to=(51,66)]
                out.write("\">");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(51,68);to=(55,5)]
                
                  }
                  else if(context.equalsIgnoreCase("project"))
                  {
                     
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(55,7);to=(55,52)]
                out.write("<input type=\"hidden\" name=\"projectid\" value=\"");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(55,55);to=(55,62)]
                out.print(opParam);
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(55,64);to=(55,66)]
                out.write("\">");

            // end
            // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(55,68);to=(57,2)]
                
                  }
                  
            // end
            // HTML // begin [file="/projectConfirmDeleteCommentDlg.jsp";from=(57,4);to=(59,7)]
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
