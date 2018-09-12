package org.apache.jsp;

import com.dommoni.ece.webui.Operations;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectAttachmentsAddAttachmentWiz2File extends HttpJspBase {


    static {
    }
    public projectAttachmentsAddAttachmentWiz2File( ) {
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

            // HTML // begin [file="/projectAttachmentsAddAttachmentWiz2File.jsp";from=(0,52);to=(43,43)]
                out.write("\r\n<html>\r\n<head>\r\n<title>Add Attachment</title>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html;\">\r\n\r\n</head>\r\n<body bgcolor=\"#ffffff\" onload=\"\" topmargin=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\">\r\n<form name=\"form1\" method=\"post\" ENCTYPE=\"multipart/form-data\" action=\"./servlet/ControllerServlet\" >\r\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"450\">\r\n<!-- fwtable fwsrc=\"AddAttachmentFile2.png\" fwbase=\"AddAttachmentFile2.gif\" fwstyle=\"Generic\" fwdocid = \"742308039\" fwnested=\"\"0\" -->\r\n  <tr>\r\n   <td><img src=\"images/spacer.gif\" width=\"12\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"8\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"61\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"82\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"138\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"52\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"9\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"73\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"6\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"9\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"1\" border=\"0\"></td></tr>\r\n\r\n  <tr>\r\n   <td colspan=\"10\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"15\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td rowspan=\"12\">&nbsp;</td><td colspan=\"3\"><img name=\"AddAttachmentFile2_r2_c2\" src=\"images/AddAttachmentFile2_r2_c2.gif\" width=\"151\" height=\"19\" border=\"0\"></td><td colspan=\"6\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"19\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"7\"><img name=\"AddAttachmentFile2_r3_c2\" src=\"images/AddAttachmentFile2_r3_c2.gif\" width=\"423\" height=\"4\" border=\"0\"></td><td rowspan=\"9\" colspan=\"2\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"4\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"7\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"25\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td rowspan=\"9\">&nbsp;</td><td colspan=\"6\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"2\">Name:</font> <input name=\"name\" type=\"text\" id=\"name\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"17\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"6\"><img name=\"AddAttachmentFile2_r6_c3\" src=\"images/AddAttachmentFile2_r6_c3.gif\" width=\"415\" height=\"5\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"5\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"6\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"2\">File:</font> <input type=\"file\" name=\"file\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"17\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"6\"><img name=\"AddAttachmentFile2_r8_c3\" src=\"images/AddAttachmentFile2_r8_c3.gif\" width=\"415\" height=\"3\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"3\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"6\"><font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">Notes:</font></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"17\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"6\" valign=\"TOP\"><textarea name=\"notes\" cols=\"45\" rows=\"7\" id=\"notes\"></textarea></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"110\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"6\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"40\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td><input type=\"submit\" name=\"Submit\" value=\"Cancel\"></td><td rowspan=\"2\" colspan=\"2\">&nbsp;</td><td><input type=\"submit\" name=\"Submit2\" value=\"Back\"></td><td rowspan=\"2\"><img name=\"AddAttachmentFile2_r12_c7\" src=\"images/AddAttachmentFile2_r12_c7.gif\" width=\"9\" height=\"28\" border=\"0\"></td><td colspan=\"2\"><input type=\"submit\" name=\"Submit3\" value=\"Finish\"></td><td rowspan=\"2\"><img name=\"AddAttachmentFile2_r12_c10\" src=\"images/AddAttachmentFile2_r12_c10.gif\" width=\"9\" height=\"28\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"22\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td><img name=\"AddAttachmentFile2_r13_c3\" src=\"images/AddAttachmentFile2_r13_c3.gif\" width=\"61\" height=\"6\" border=\"0\"></td><td><img name=\"AddAttachmentFile2_r13_c6\" src=\"images/AddAttachmentFile2_r13_c6.gif\" width=\"52\" height=\"6\" border=\"0\"></td><td colspan=\"2\"><img name=\"AddAttachmentFile2_r13_c8\" src=\"images/AddAttachmentFile2_r13_c8.gif\" width=\"79\" height=\"6\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"6\" border=\"0\"></td></tr>\r\n\r\n\r\n</table>\r\n<input name=\"opparam\" type=\"hidden\" value=\"");

            // end
            // begin [file="/projectAttachmentsAddAttachmentWiz2File.jsp";from=(43,46);to=(43,77)]
                out.print(request.getParameter("opparam"));
            // end
            // HTML // begin [file="/projectAttachmentsAddAttachmentWiz2File.jsp";from=(43,79);to=(44,43)]
                out.write("\">\r\n<input name=\"context\" type=\"hidden\" value=\"");

            // end
            // begin [file="/projectAttachmentsAddAttachmentWiz2File.jsp";from=(44,46);to=(44,77)]
                out.print(request.getParameter("context"));
            // end
            // HTML // begin [file="/projectAttachmentsAddAttachmentWiz2File.jsp";from=(44,79);to=(45,46)]
                out.write("\">\r\n<input name=\"parentlink\" type=\"hidden\" value=\"");

            // end
            // begin [file="/projectAttachmentsAddAttachmentWiz2File.jsp";from=(45,49);to=(45,83)]
                out.print(request.getParameter("parentlink"));
            // end
            // HTML // begin [file="/projectAttachmentsAddAttachmentWiz2File.jsp";from=(45,85);to=(46,42)]
                out.write("\">\r\n<input name=\"opcode\" type=\"hidden\" value=\"");

            // end
            // begin [file="/projectAttachmentsAddAttachmentWiz2File.jsp";from=(46,45);to=(46,78)]
                out.print(Operations.CREATE_FILE_ATTACHMENT);
            // end
            // HTML // begin [file="/projectAttachmentsAddAttachmentWiz2File.jsp";from=(46,80);to=(50,0)]
                out.write("\">\r\n</form>\r\n</body>\r\n</html>\r\n");

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
