package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectAttachmentsAddAttachmentWiz1 extends HttpJspBase {


    static {
    }
    public projectAttachmentsAddAttachmentWiz1( ) {
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

            // HTML // begin [file="/projectAttachmentsAddAttachmentWiz1.jsp";from=(0,0);to=(44,43)]
                out.write("<html>\r\n<head>\r\n<title>Add Attachment</title>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html;\">\r\n\r\n</head>\r\n<body bgcolor=\"#ffffff\" onload=\"\" topmargin=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\">\r\n<form name=\"form1\">\r\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"450\">\r\n<!-- fwtable fwsrc=\"AddAttachmentObject.png\" fwbase=\"AddAttachmentObject.gif\" fwstyle=\"Generic\" fwdocid = \"742308039\" fwnested=\"\"0\" -->\r\n  <tr>\r\n   <td><img src=\"images/spacer.gif\" width=\"12\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"59\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"2\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"20\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"70\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"216\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"56\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"6\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"9\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"1\" border=\"0\"></td></tr>\r\n\r\n  <tr>\r\n   <td colspan=\"9\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"15\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td rowspan=\"11\">&nbsp;</td><td colspan=\"4\"><img name=\"AddAttachmentObject_r2_c2\" src=\"images/AddAttachmentObject_r2_c2.gif\" width=\"151\" height=\"19\" border=\"0\"></td><td colspan=\"4\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"19\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"6\"><img name=\"AddAttachmentObject_r3_c2\" src=\"images/AddAttachmentObject_r3_c2.gif\" width=\"423\" height=\"4\" border=\"0\"></td><td rowspan=\"8\" colspan=\"2\"><img name=\"AddAttachmentObject_r3_c8\" src=\"images/AddAttachmentObject_r3_c8.gif\" width=\"15\" height=\"238\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"4\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"6\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"31\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td rowspan=\"6\">&nbsp;</td><td colspan=\"5\"><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"2\">Select Type:</font></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"17\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"5\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"15\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td rowspan=\"4\" colspan=\"2\">&nbsp;</td><td colspan=\"3\"><input type=\"radio\" name=\"type\" value=\"object\">\r\n   <font size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">RoundTable Item</font></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"1\" height=\"18\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"3\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"11\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"3\"><input type=\"radio\" name=\"type\" value=\"file\">\r\n   <font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"2\">File</font></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"1\" height=\"20\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"3\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"122\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"2\"><input type=\"button\" name=\"Submit2\" value=\"Cancel\" OnClick=\"window.close()\"></td><td rowspan=\"2\" colspan=\"3\">&nbsp;</td><td colspan=\"2\"><input type=\"button\" name=\"Button\" value=\"  Next  \" OnClick=\"doNext()\"></td><td rowspan=\"2\"><img name=\"AddAttachmentObject_r11_c9\" src=\"images/AddAttachmentObject_r11_c9.gif\" width=\"9\" height=\"28\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"22\" border=\"0\"></td></tr>\r\n  <tr>\r\n   <td colspan=\"2\"><img name=\"AddAttachmentObject_r12_c2\" src=\"images/AddAttachmentObject_r12_c2.gif\" width=\"61\" height=\"6\" border=\"0\"></td><td colspan=\"2\"><img name=\"AddAttachmentObject_r12_c7\" src=\"images/AddAttachmentObject_r12_c7.gif\" width=\"62\" height=\"6\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"6\" border=\"0\"></td></tr>\r\n\r\n\r\n</table>\r\n<input name=\"opparam\" type=\"hidden\" value=\"");

            // end
            // begin [file="/projectAttachmentsAddAttachmentWiz1.jsp";from=(44,46);to=(44,77)]
                out.print(request.getParameter("opparam"));
            // end
            // HTML // begin [file="/projectAttachmentsAddAttachmentWiz1.jsp";from=(44,79);to=(45,43)]
                out.write("\">\r\n<input name=\"context\" type=\"hidden\" value=\"");

            // end
            // begin [file="/projectAttachmentsAddAttachmentWiz1.jsp";from=(45,46);to=(45,77)]
                out.print(request.getParameter("context"));
            // end
            // HTML // begin [file="/projectAttachmentsAddAttachmentWiz1.jsp";from=(45,79);to=(46,46)]
                out.write("\">\r\n<input name=\"parentlink\" type=\"hidden\" value=\"");

            // end
            // begin [file="/projectAttachmentsAddAttachmentWiz1.jsp";from=(46,49);to=(46,83)]
                out.print(request.getParameter("parentlink"));
            // end
            // HTML // begin [file="/projectAttachmentsAddAttachmentWiz1.jsp";from=(46,85);to=(81,0)]
                out.write("\">\r\n</form>\r\n</body>\r\n\r\n</html>\r\n<script>\r\nfunction doNext()\r\n{\r\n   var beenChecked = false;\r\n   for(i = 0; i < document.form1.type.length; i++)\r\n\t {\r\n\t\t\tif(document.form1.type[i].checked)\r\n\t\t\t{   \r\n\t\t\t   beenChecked = true;\r\n\t\t\t\t if('object' == document.form1.type[i].value)\r\n\t\t\t\t {   \r\n\t\t\t\t    document.form1.action = \"./projectAttachmentsAddAttachmentWiz2Object.jsp\";\r\n\t\t\t\t }\r\n\t\t\t\t else if('file' == document.form1.type[i].value)\r\n\t\t\t\t {\r\n\t\t\t\t    document.form1.action = \"./projectAttachmentsAddAttachmentWiz2File.jsp\";\r\n\t\t\t\t }\r\n\t\t\t}\r\n\t }\r\n\t \r\n\t if(beenChecked)\r\n\t {   \r\n\t    document.form1.submit(); \r\n\t }\r\n\t else\r\n\t {\r\n\t    alert(\"You must select a value\");\r\n\t }\r\n}\r\n</script>\r\n");

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
