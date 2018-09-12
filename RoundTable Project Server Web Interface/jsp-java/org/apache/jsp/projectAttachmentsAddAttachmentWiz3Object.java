package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectAttachmentsAddAttachmentWiz3Object extends HttpJspBase {


    static {
    }
    public projectAttachmentsAddAttachmentWiz3Object( ) {
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

            // HTML // begin [file="/projectAttachmentsAddAttachmentWiz3Object.jsp";from=(0,0);to=(44,0)]
                out.write("<html>\r\n<head>\r\n<title>AddAttachmentObject3.gif</title>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html;\">\r\n\r\n</head>\r\n<body bgcolor=\"#ffffff\" onload=\"\" topmargin=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\">\r\n<form name=\"form1\" >\r\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"450\">\r\n<!-- fwtable fwsrc=\"AddAttachmentObject3.png\" fwbase=\"AddAttachmentObject3.gif\" fwstyle=\"Generic\" fwdocid = \"742308039\" fwnested=\"\"0\" -->\r\n  <tr>\r\n   <td><img src=\"images/spacer.gif\" width=\"12\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"8\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"143\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"69\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"61\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"8\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"52\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"9\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"73\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"6\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"9\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"1\" border=\"0\"></td></tr>\r\n\r\n  <tr>\r\n   <td colspan=\"11\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"15\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td rowspan=\"12\">&nbsp;</td><td colspan=\"2\"><img name=\"AddAttachmentObject3_r2_c2\" src=\"images/AddAttachmentObject3_r2_c2.gif\" width=\"151\" height=\"19\" border=\"0\"></td><td colspan=\"8\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"19\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"8\"><img name=\"AddAttachmentObject3_r3_c2\" src=\"images/AddAttachmentObject3_r3_c2.gif\" width=\"423\" height=\"4\" border=\"0\"></td><td rowspan=\"9\" colspan=\"2\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"4\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"8\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"25\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td rowspan=\"9\"><img name=\"AddAttachmentObject3_r5_c2\" src=\"images/AddAttachmentObject3_r5_c2.gif\" width=\"8\" height=\"237\" border=\"0\"></td><td colspan=\"7\"><font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">Select &lt;name&gt;:</font> <select name=\"object\"></select></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"17\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"7\"><img name=\"AddAttachmentObject3_r6_c3\" src=\"images/AddAttachmentObject3_r6_c3.gif\" width=\"415\" height=\"5\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"5\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"7\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"2\">Name:</font> <input type=\"text\" name=\"name\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"17\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"7\"><img name=\"AddAttachmentObject3_r8_c3\" src=\"images/AddAttachmentObject3_r8_c3.gif\" width=\"415\" height=\"3\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"3\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"7\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"2\">Notes: </font></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"17\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"7\" valign=\"TOP\"><textarea name=\"notes\" cols=\"45\" rows=\"7\"></textarea></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"110\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"7\"><img name=\"AddAttachmentObject3_r11_c3\" src=\"images/AddAttachmentObject3_r11_c3.gif\" width=\"415\" height=\"40\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"40\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td rowspan=\"2\" colspan=\"2\"><input type=\"submit\" name=\"Submit\" value=\"Cancel\"></td><td>&nbsp;</td><td rowspan=\"2\"><img name=\"AddAttachmentObject3_r12_c6\" src=\"images/AddAttachmentObject3_r12_c6.gif\" width=\"8\" height=\"28\" border=\"0\"></td><td><input type=\"submit\" name=\"Submit2\" value=\"Back\"></td><td rowspan=\"2\"><img name=\"AddAttachmentObject3_r12_c8\" src=\"images/AddAttachmentObject3_r12_c8.gif\" width=\"9\" height=\"28\" border=\"0\"></td><td colspan=\"2\"><input type=\"submit\" name=\"Submit3\" value=\"Finish\"></td><td rowspan=\"2\"><img name=\"AddAttachmentObject3_r12_c11\" src=\"images/AddAttachmentObject3_r12_c11.gif\" width=\"9\" height=\"28\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"22\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td><img name=\"AddAttachmentObject3_r13_c5\" src=\"images/AddAttachmentObject3_r13_c5.gif\" width=\"61\" height=\"6\" border=\"0\"></td><td><img name=\"AddAttachmentObject3_r13_c7\" src=\"images/AddAttachmentObject3_r13_c7.gif\" width=\"52\" height=\"6\" border=\"0\"></td><td colspan=\"2\"><img name=\"AddAttachmentObject3_r13_c9\" src=\"images/AddAttachmentObject3_r13_c9.gif\" width=\"79\" height=\"6\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"6\" border=\"0\"></td></tr>\r\n\r\n\r\n</table></form>\r\n</body>\r\n</html>\r\n");

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
