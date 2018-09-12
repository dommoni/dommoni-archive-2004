package org.apache.jsp;

import com.dommoni.ece.webui.Operations;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectCommentsAddCommentDlg extends HttpJspBase {


    static {
    }
    public projectCommentsAddCommentDlg( ) {
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

            // HTML // begin [file="/projectCommentsAddCommentDlg.jsp";from=(0,52);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectCommentsAddCommentDlg.jsp";from=(2,2);to=(7,0)]
                
                	String name = request.getParameter("name");
                  	String opparam = request.getParameter("opparam");
                  	String context = request.getParameter("context");
                  	String parentlink = request.getParameter("parentlink");
            // end
            // HTML // begin [file="/projectCommentsAddCommentDlg.jsp";from=(7,2);to=(107,44)]
                out.write("\r\n\r\n<html>\r\n<head>\r\n<title>Add Comment</title>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html;\">\r\n\r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n//-->\r\n</script>\r\n</head>\r\n<body bgcolor=\"#ffffff\" onload=\"\" topmargin=\"0\" leftmargin=\"0\" marginheight=\"0\" marginwidth=\"0\">\r\n<form method=\"post\" ENCTYPE=\"multipart/form-data\" action=\"./servlet/ControllerServlet\">\r\n  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"450\">\r\n    <!-- fwtable fwsrc=\"AddCommentDlg.png\" fwbase=\"AddCommentDlg.gif\" fwstyle=\"Generic\" fwdocid = \"742308039\" fwnested=\"\"0\" -->\r\n    <tr>\r\n   <td><img src=\"images/spacer.gif\" width=\"12\" height=\"1\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"6\" height=\"1\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"7\" height=\"1\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"2\" height=\"1\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"71\" height=\"1\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"45\" height=\"1\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"134\" height=\"1\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"79\" height=\"1\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"6\" height=\"1\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"61\" height=\"1\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"12\" height=\"1\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"6\" height=\"1\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"9\" height=\"1\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"1\" height=\"1\" border=\"0\"></td>\r\n  </tr>\r\n\r\n  <tr>\r\n    <td colspan=\"13\">&nbsp;</td>\r\n   <td><img src=\"images/spacer.gif\" width=\"1\" height=\"15\" border=\"0\"></td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">&nbsp;</td>\r\n   <td colspan=\"4\"><img name=\"AddCommentDlg_r2_c3\" src=\"images/AddCommentDlg_r2_c3.gif\" width=\"125\" height=\"19\" border=\"0\"></td>\r\n    <td colspan=\"7\">&nbsp;</td>\r\n   <td><img src=\"images/spacer.gif\" width=\"1\" height=\"19\" border=\"0\"></td>\r\n  </tr>\r\n  <tr>\r\n    <td rowspan=\"8\">&nbsp;</td>\r\n   <td colspan=\"10\"><img name=\"AddCommentDlg_r3_c2\" src=\"images/AddCommentDlg_r3_c2.gif\" width=\"423\" height=\"4\" border=\"0\"></td>\r\n   <td rowspan=\"6\" colspan=\"2\"><img name=\"AddCommentDlg_r3_c12\" src=\"images/AddCommentDlg_r3_c12.gif\" width=\"15\" height=\"238\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"1\" height=\"4\" border=\"0\"></td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"10\">&nbsp;</td>\r\n   <td><img src=\"images/spacer.gif\" width=\"1\" height=\"9\" border=\"0\"></td>\r\n  </tr>\r\n  <tr>\r\n    <td rowspan=\"6\" colspan=\"2\">&nbsp;</td> <td colspan=\"2\"><font face=\"Arial, Helvetica, sans-serif\" size=\"2\">Comment:</font></td>\r\n    <td rowspan=\"2\" colspan=\"6\">&nbsp;</td>\r\n   <td><img src=\"images/spacer.gif\" width=\"1\" height=\"16\" border=\"0\"></td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">&nbsp;</td>\r\n   <td><img src=\"images/spacer.gif\" width=\"1\" height=\"9\" border=\"0\"></td>\r\n  </tr>\r\n  <tr>\r\n   <td rowspan=\"4\"><img name=\"AddCommentDlg_r7_c4\" src=\"images/AddCommentDlg_r7_c4.gif\" width=\"2\" height=\"228\" border=\"0\"></td>\r\n      <td colspan=\"6\" valign=\"top\">\r\n        <textarea name=\"commenttext\" rows=\"5\" cols=\"45\"></textarea>\r\n      </td>\r\n   <td rowspan=\"2\"><img name=\"AddCommentDlg_r7_c11\" src=\"images/AddCommentDlg_r7_c11.gif\" width=\"12\" height=\"200\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"1\" height=\"108\" border=\"0\"></td>\r\n  </tr>\r\n  <tr>\r\n      <td colspan=\"6\">&nbsp;</td>\r\n   <td><img src=\"images/spacer.gif\" width=\"1\" height=\"4\r\n   2\" border=\"0\"></td>\r\n  </tr>\r\n  <tr>\r\n    <td rowspan=\"2\" colspan=\"3\">&nbsp;</td>\r\n      <td align=\"right\"> \r\n        <input type=\"submit\" name=\"Submit\" value=\"Add\">\r\n      </td>\r\n   <td rowspan=\"2\"><img name=\"AddCommentDlg_r9_c9\" src=\"images/AddCommentDlg_r9_c9.gif\" width=\"6\" height=\"28\" border=\"0\"></td>\r\n      <td colspan=\"3\">\r\n        <input type=\"button\" name=\"Submit2\" value=\"Cancel\" onClick=\"MM_callJS('window.close();')\">\r\n      </td>\r\n   <td rowspan=\"2\"><img name=\"AddCommentDlg_r9_c13\" src=\"images/AddCommentDlg_r9_c13.gif\" width=\"9\" height=\"28\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"1\" height=\"22\" border=\"0\"></td>\r\n  </tr>\r\n  <tr>\r\n   <td><img name=\"AddCommentDlg_r10_c8\" src=\"images/AddCommentDlg_r10_c8.gif\" width=\"79\" height=\"6\" border=\"0\"></td>\r\n   <td colspan=\"3\"><img name=\"AddCommentDlg_r10_c10\" src=\"images/AddCommentDlg_r10_c10.gif\" width=\"79\" height=\"6\" border=\"0\"></td>\r\n   <td><img src=\"images/spacer.gif\" width=\"1\" height=\"6\" border=\"0\"></td>\r\n  </tr>\r\n\r\n\r\n</table>\r\n\r\n   \r\n  <input type=\"hidden\" name=\"opcode\" value=\"");

            // end
            // begin [file="/projectCommentsAddCommentDlg.jsp";from=(107,47);to=(107,72)]
                out.print(Operations.CREATE_COMMENT);
            // end
            // HTML // begin [file="/projectCommentsAddCommentDlg.jsp";from=(107,74);to=(108,42)]
                out.write("\"/>\r\n  <input type=\"hidden\" name=\"name\" value=\"");

            // end
            // begin [file="/projectCommentsAddCommentDlg.jsp";from=(108,45);to=(108,49)]
                out.print(name);
            // end
            // HTML // begin [file="/projectCommentsAddCommentDlg.jsp";from=(108,51);to=(109,45)]
                out.write("\" />\r\n  <input type=\"hidden\" name=\"opparam\" value=\"");

            // end
            // begin [file="/projectCommentsAddCommentDlg.jsp";from=(109,48);to=(109,55)]
                out.print(opparam);
            // end
            // HTML // begin [file="/projectCommentsAddCommentDlg.jsp";from=(109,57);to=(110,45)]
                out.write("\" />\r\n  <input type=\"hidden\" name=\"context\" value=\"");

            // end
            // begin [file="/projectCommentsAddCommentDlg.jsp";from=(110,48);to=(110,55)]
                out.print(context);
            // end
            // HTML // begin [file="/projectCommentsAddCommentDlg.jsp";from=(110,57);to=(111,48)]
                out.write("\" />\r\n  <input type=\"hidden\" name=\"parentlink\" value=\"");

            // end
            // begin [file="/projectCommentsAddCommentDlg.jsp";from=(111,51);to=(111,61)]
                out.print(parentlink);
            // end
            // HTML // begin [file="/projectCommentsAddCommentDlg.jsp";from=(111,63);to=(115,0)]
                out.write("\" />\r\n</form>\r\n</body>\r\n</html>\r\n");

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
