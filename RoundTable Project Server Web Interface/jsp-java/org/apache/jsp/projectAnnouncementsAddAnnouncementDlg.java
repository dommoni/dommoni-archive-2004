package org.apache.jsp;

import com.dommoni.ece.webui.Operations;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectAnnouncementsAddAnnouncementDlg extends HttpJspBase {


    static {
    }
    public projectAnnouncementsAddAnnouncementDlg( ) {
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

            // HTML // begin [file="/projectAnnouncementsAddAnnouncementDlg.jsp";from=(0,52);to=(28,50)]
                out.write("\r\n\r\n<html>\r\n<head>\r\n<title>New Announcement</title> <meta http-equiv=\"Content-Type\" content=\"text/html;\"> \r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n//-->\r\n</script>\r\n</head>\r\n<body bgcolor=\"#ffffff\" onload=\"\" topmargin=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\">\r\n<FORM NAME=\"form1\" METHOD=\"post\" ENCTYPE=\"multipart/form-data\" action=\"./servlet/ControllerServlet\"> \r\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"450\"> <!-- fwtable fwsrc=\"AddAnnouncementDlg.png\" fwbase=\"projectAnnouncementsAddAnnouncementDlg.jsp.gif\" fwstyle=\"Generic\" fwdocid = \"742308039\" fwnested=\"\"0\" --> \r\n<tr> <td><img src=\"images/spacer.gif\" width=\"12\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"6\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"7\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"2\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"95\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"75\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"80\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"79\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"6\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"61\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"12\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"6\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"9\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"1\" border=\"0\"></td></tr> \r\n<tr> <td colspan=\"13\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"15\" border=\"0\"></td></tr> \r\n<tr> <td colspan=\"2\"><img name=\"projectAnnouncementsAddAnnouncementDlgjsp_r2_c1\" src=\"images/projectAnnouncementsAddAnnouncementDlg.jsp_r2_c1.gif\" width=\"18\" height=\"19\" border=\"0\"></td><td colspan=\"4\"><img name=\"projectAnnouncementsAddAnnouncementDlgjsp_r2_c3\" src=\"images/projectAnnouncementsAddAnnouncementDlg.jsp_r2_c3.gif\" width=\"179\" height=\"19\" border=\"0\"></td><td colspan=\"7\"><img name=\"projectAnnouncementsAddAnnouncementDlgjsp_r2_c7\" src=\"images/projectAnnouncementsAddAnnouncementDlg.jsp_r2_c7.gif\" width=\"253\" height=\"19\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"19\" border=\"0\"></td></tr> \r\n<tr> <td rowspan=\"8\">&nbsp;</td><td colspan=\"10\"><img name=\"projectAnnouncementsAddAnnouncementDlgjsp_r3_c2\" src=\"images/projectAnnouncementsAddAnnouncementDlg.jsp_r3_c2.gif\" width=\"423\" height=\"4\" border=\"0\"></td><td rowspan=\"6\" colspan=\"2\"><img name=\"projectAnnouncementsAddAnnouncementDlgjsp_r3_c12\" src=\"images/projectAnnouncementsAddAnnouncementDlg.jsp_r3_c12.gif\" width=\"15\" height=\"238\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"4\" border=\"0\"></td></tr> \r\n<tr> <td colspan=\"10\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"9\" border=\"0\"></td></tr> \r\n<tr> <td rowspan=\"6\" colspan=\"2\">&nbsp;</td><td colspan=\"2\"><FONT FACE=\"Arial, Helvetica, sans-serif\" SIZE=\"2\">Announcement:</FONT></td><td rowspan=\"2\" colspan=\"6\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"16\" border=\"0\"></td></tr> \r\n<tr> <td colspan=\"2\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"9\" border=\"0\"></td></tr> \r\n<tr> <td rowspan=\"4\"><img name=\"projectAnnouncementsAddAnnouncementDlgjsp_r7_c4\" src=\"images/projectAnnouncementsAddAnnouncementDlg.jsp_r7_c4.gif\" width=\"2\" height=\"228\" border=\"0\"></td><td colspan=\"6\" VALIGN=\"TOP\"><P><FONT FACE=\"Arial, Helvetica, sans-serif\" SIZE=\"2\">Title:</FONT> \r\n<INPUT TYPE=\"text\" NAME=\"title\"> </P><P><FONT FACE=\"Arial, Helvetica, sans-serif\" SIZE=\"2\">Message:</FONT><BR><TEXTAREA NAME=\"message\" COLS=\"45\" ROWS=\"5\"></TEXTAREA></P></td><td rowspan=\"2\"><img name=\"projectAnnouncementsAddAnnouncementDlgjsp_r7_c11\" src=\"images/projectAnnouncementsAddAnnouncementDlg.jsp_r7_c11.gif\" width=\"12\" height=\"200\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"108\" border=\"0\"></td></tr> \r\n<tr> <td colspan=\"6\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"92\" border=\"0\"></td></tr> \r\n<tr> <td rowspan=\"2\" colspan=\"3\">&nbsp;</td><td ALIGN=\"RIGHT\"><INPUT TYPE=\"submit\" NAME=\"Submit\" VALUE=\"Submit\"></td><td rowspan=\"2\"><img name=\"projectAnnouncementsAddAnnouncementDlgjsp_r9_c9\" src=\"images/projectAnnouncementsAddAnnouncementDlg.jsp_r9_c9.gif\" width=\"6\" height=\"28\" border=\"0\"></td><td colspan=\"3\"><INPUT TYPE=\"button\" NAME=\"Submit2\" VALUE=\"Cancel\" ONCLICK=\"MM_callJS('window.close();')\"></td><td rowspan=\"2\"><img name=\"projectAnnouncementsAddAnnouncementDlgjsp_r9_c13\" src=\"images/projectAnnouncementsAddAnnouncementDlg.jsp_r9_c13.gif\" width=\"9\" height=\"28\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"22\" border=\"0\"></td></tr> \r\n<tr> <td><img name=\"projectAnnouncementsAddAnnouncementDlgjsp_r10_c8\" src=\"images/projectAnnouncementsAddAnnouncementDlg.jsp_r10_c8.gif\" width=\"79\" height=\"6\" border=\"0\"></td><td colspan=\"3\"><img name=\"projectAnnouncementsAddAnnouncementDlgjsp_r10_c10\" src=\"images/projectAnnouncementsAddAnnouncementDlg.jsp_r10_c10.gif\" width=\"79\" height=\"6\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"6\" border=\"0\"></td></tr> \r\n</table><INPUT TYPE=\"hidden\" NAME=\"opcode\" VALUE=\"");

            // end
            // begin [file="/projectAnnouncementsAddAnnouncementDlg.jsp";from=(28,53);to=(28,83)]
                out.print(Operations.CREATE_ANNOUNCEMENT);
            // end
            // HTML // begin [file="/projectAnnouncementsAddAnnouncementDlg.jsp";from=(28,85);to=(32,0)]
                out.write("\"> \r\n</FORM>\r\n</body>\r\n</html>\r\n");

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
