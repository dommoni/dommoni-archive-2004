package org.apache.jsp;

import java.util.HashMap;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Forum;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.projectServer.services.forumManager.IForumManager;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectForumsModifyForum extends HttpJspBase {


    static {
    }
    public projectForumsModifyForum( ) {
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

            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(0,37);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(2,50);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(3,48);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(5,66);to=(7,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(7,92);to=(9,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(9,52);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(10,60);to=(12,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectForumsModifyForum.jsp";from=(12,2);to=(32,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	Forum forum = null;
                	try
                	{
                	   int forumid = Integer.parseInt(request.getParameter("forumid"));
                	
                	   IForumManager forumManager = psc.getForumManager();
                	   forum = forumManager.getForum(forumid);
                	}
                	catch(Exception e)
                	{
                	   e.printStackTrace();
                	}
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(32,2);to=(42,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectForumsModifyForum.jsp";from=(42,12);to=(42,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(42,32);to=(166,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n//-->\r\n</script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectForumsModifyForum.jsp";from=(166,3);to=(166,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(166,36);to=(169,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectForumsModifyForum.jsp";from=(169,9);to=(169,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(169,41);to=(184,7)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t<h1>Modify Forum Topic</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n\t  <!-- PAGE TEXT GOES HERE -->\r\n\t      ");

            // end
            // begin [file="/projectForumsModifyForum.jsp";from=(184,9);to=(184,28)]
                if(forum != null) {
            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(184,30);to=(187,55)]
                out.write("\r\n\t      <form name=\"form1\" method=\"post\" action=\"./servlet/ControllerServlet\">\r\n            <p>Topic: \r\n              <input type=\"text\" name=\"subject\" value=\"");

            // end
            // begin [file="/projectForumsModifyForum.jsp";from=(187,58);to=(187,76)]
                out.print(forum.getSubject());
            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(187,78);to=(191,59)]
                out.write("\">\r\n            </p>\r\n            <p>Message: </p>\r\n            <p> \r\n              <textarea name=\"message\" cols=\"40\" rows=\"10\">");

            // end
            // begin [file="/projectForumsModifyForum.jsp";from=(191,62);to=(191,80)]
                out.print(forum.getMessage());
            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(191,82);to=(195,56)]
                out.write("</textarea>\r\n              <br>\r\n              <input type=\"submit\" name=\"Submit\" value=\"Submit\">\r\n              <input type=\"button\" name=\"Submit2\" value=\"Cancel\" onClick=\"MM_callJS('window.history.go(-1)')\">\r\n              <input type=\"hidden\" name=\"opcode\" value=\"");

            // end
            // begin [file="/projectForumsModifyForum.jsp";from=(195,59);to=(195,80)]
                out.print(Operations.EDIT_FORUM);
            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(195,82);to=(196,57)]
                out.write("\">\r\n              <input type=\"hidden\" name=\"forumid\" value=\"");

            // end
            // begin [file="/projectForumsModifyForum.jsp";from=(196,60);to=(196,73)]
                out.print(forum.getId());
            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(196,75);to=(199,4)]
                out.write("\">\r\n            </p>\r\n          </form>\r\n\t\t  ");

            // end
            // begin [file="/projectForumsModifyForum.jsp";from=(199,6);to=(199,7)]
                }
            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(199,9);to=(210,5)]
                out.write("\r\n        </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectForumsModifyForum.jsp";from=(210,5);to=(210,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectForumsModifyForum.jsp";from=(210,47);to=(236,0)]
                out.write("\t  \r\n\t</ul>\r\n     <br/>\r\n    <br/>    \r\n</div>\r\n\r\n\r\n</div>\r\n\r\n\r\n\r\n\t<div id=\"showhelp\"><a href=\"../project/show_help?project_id=4661&return_to=%2Fclients%2Ftestproject7%2F1%2Fall%2F\">Show \"Things to do\"</a></div>\r\n\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
