package org.apache.jsp;

import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Announcement;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectAnnouncementsViewAnnouncementDlg extends HttpJspBase {


    static {
    }
    public projectAnnouncementsViewAnnouncementDlg( ) {
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

            // HTML // begin [file="/projectAnnouncementsViewAnnouncementDlg.jsp";from=(0,50);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectAnnouncementsViewAnnouncementDlg.jsp";from=(1,55);to=(2,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectAnnouncementsViewAnnouncementDlg.jsp";from=(2,50);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectAnnouncementsViewAnnouncementDlg.jsp";from=(3,66);to=(5,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectAnnouncementsViewAnnouncementDlg.jsp";from=(5,2);to=(12,0)]
                
                   ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                   Project currentProject = (Project)session.getAttribute("currentproject");
                   Account account = (Account)session.getAttribute("useraccount");
                
                   int announcementId = Integer.parseInt(request.getParameter("announcementid"));
                   Announcement announcement = psc.getAnnouncementManager().getAnnouncement(announcementId);
            // end
            // HTML // begin [file="/projectAnnouncementsViewAnnouncementDlg.jsp";from=(12,2);to=(32,191)]
                out.write("\r\n\r\n<html>\r\n<head>\r\n<title>Announcement</title> <meta http-equiv=\"Content-Type\" content=\"text/html;\"> \r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n//-->\r\n</script>\r\n</head>\r\n<body bgcolor=\"#ffffff\" onload=\"\" topmargin=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\">\r\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"450\"> <!-- fwtable fwsrc=\"ViewAnnouncementDlg.png\" fwbase=\"ViewAnnouncementDlg.gif\" fwstyle=\"Generic\" fwdocid = \"742308039\" fwnested=\"\"0\" --> \r\n<tr> <td><img src=\"images/spacer.gif\" width=\"12\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"6\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"7\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"29\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"71\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"18\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"29\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"25\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"80\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"63\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"16\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"6\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"59\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"14\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"6\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"9\" height=\"1\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"1\" border=\"0\"></td></tr> \r\n<tr> <td colspan=\"16\"><img name=\"ViewAnnouncementDlg_r1_c1\" src=\"images/ViewAnnouncementDlg_r1_c1.gif\" width=\"450\" height=\"15\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"15\" border=\"0\"></td></tr> \r\n<tr> <td colspan=\"2\"><img name=\"ViewAnnouncementDlg_r2_c1\" src=\"images/ViewAnnouncementDlg_r2_c1.gif\" width=\"18\" height=\"19\" border=\"0\"></td><td colspan=\"6\"><img name=\"ViewAnnouncementDlg_r2_c3\" src=\"images/ViewAnnouncementDlg_r2_c3.gif\" width=\"179\" height=\"19\" border=\"0\"></td><td colspan=\"8\"><img name=\"ViewAnnouncementDlg_r2_c9\" src=\"images/ViewAnnouncementDlg_r2_c9.gif\" width=\"253\" height=\"19\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"19\" border=\"0\"></td></tr> \r\n<tr> <td rowspan=\"9\">&nbsp;</td><td colspan=\"13\"><img name=\"ViewAnnouncementDlg_r3_c2\" src=\"images/ViewAnnouncementDlg_r3_c2.gif\" width=\"423\" height=\"4\" border=\"0\"></td><td rowspan=\"7\" colspan=\"2\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"4\" border=\"0\"></td></tr> \r\n<tr> <td colspan=\"13\"><img name=\"ViewAnnouncementDlg_r4_c2\" src=\"images/ViewAnnouncementDlg_r4_c2.gif\" width=\"423\" height=\"9\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"9\" border=\"0\"></td></tr> \r\n<tr> <td rowspan=\"7\" colspan=\"2\">&nbsp;</td><td><FONT FACE=\"Arial, Helvetica, sans-serif\" SIZE=\"2\"><B>Title:</B></FONT></td><td colspan=\"2\"><FONT FACE=\"Arial, Helvetica, sans-serif\" SIZE=\"2\">");

            // end
            // begin [file="/projectAnnouncementsViewAnnouncementDlg.jsp";from=(32,194);to=(32,217)]
                out.print(announcement.getTitle());
            // end
            // HTML // begin [file="/projectAnnouncementsViewAnnouncementDlg.jsp";from=(32,219);to=(44,0)]
                out.write("</font></td><td><FONT SIZE=\"2\" FACE=\"Arial, Helvetica, sans-serif\">From:</FONT></td><td colspan=\"3\">&nbsp;</td><td rowspan=\"3\" colspan=\"4\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"16\" border=\"0\"></td></tr> \r\n<tr> <td colspan=\"7\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"31\" border=\"0\"></td></tr> \r\n<tr> <td colspan=\"2\"><FONT FACE=\"Arial, Helvetica, sans-serif\" SIZE=\"2\">Message \r\nText:</FONT></td><td colspan=\"5\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"13\" border=\"0\"></td></tr> \r\n<tr> <td colspan=\"10\" VALIGN=\"TOP\"><TEXTAREA NAME=\"textfield\" COLS=\"45\" ROWS=\"5\"></TEXTAREA></td><td rowspan=\"2\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"108\" border=\"0\"></td></tr> \r\n<tr> <td colspan=\"10\">&nbsp;</td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"57\" border=\"0\"></td></tr> \r\n<tr> <td rowspan=\"2\" colspan=\"6\">&nbsp;</td><td colspan=\"2\" ALIGN=\"RIGHT\"><INPUT TYPE=\"button\" NAME=\"Button\" VALUE=\"Add Comment\"></td><td rowspan=\"2\"><img name=\"ViewAnnouncementDlg_r10_c12\" src=\"images/ViewAnnouncementDlg_r10_c12.gif\" width=\"6\" height=\"28\" border=\"0\"></td><td colspan=\"3\"><INPUT TYPE=\"submit\" NAME=\"Submit2\" VALUE=\"Close Window\" ONCLICK=\"MM_callJS('window.close();')\"></td><td rowspan=\"2\"><img name=\"ViewAnnouncementDlg_r10_c16\" src=\"images/ViewAnnouncementDlg_r10_c16.gif\" width=\"9\" height=\"28\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"22\" border=\"0\"></td></tr> \r\n<tr> <td colspan=\"2\"><img name=\"ViewAnnouncementDlg_r11_c10\" src=\"images/ViewAnnouncementDlg_r11_c10.gif\" width=\"79\" height=\"6\" border=\"0\"></td><td colspan=\"3\"><img name=\"ViewAnnouncementDlg_r11_c13\" src=\"images/ViewAnnouncementDlg_r11_c13.gif\" width=\"79\" height=\"6\" border=\"0\"></td><td><img src=\"images/spacer.gif\" width=\"1\" height=\"6\" border=\"0\"></td></tr> \r\n</table>\r\n\r\n</body>\r\n</html>\r\n");

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
