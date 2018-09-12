package org.apache.jsp;

import java.util.HashMap;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class adminAccountsCreateAccount extends HttpJspBase {


    static {
    }
    public adminAccountsCreateAccount( ) {
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

            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(0,37);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(2,50);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(3,54);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(5,66);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(6,96);to=(8,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(8,52);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(9,60);to=(11,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/adminAccountsCreateAccount.jsp";from=(11,2);to=(21,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Account accounts[] = psc.getAccountManager().getAllAccounts();
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	
                	IAccountManager accountManager = psc.getAccountManager();
                	Account account = accountManager.getAccountFromUsername(psc.getUsername());
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(21,2);to=(31,8)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n\t<meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t<title>");

            // end
            // begin [file="/adminAccountsCreateAccount.jsp";from=(31,11);to=(31,29)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(31,31);to=(151,4)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\n\t\ta:link, a:visited {\r\n\t\t\tcolor: #039;\r\n\t\t}\r\n\r\n\t\ta:hover {\r\n\t\t\tcolor: #fff;\r\n\t\t\tbackground-color: #039;\r\n\t\t}\r\n\r\n\t\t#Header {\r\n\t\t\tbackground-color: #C7E5EA;\r\n\t\t}\r\n\r\n\t\t#Header h1 {\r\n\t\t\tcolor: #000;\r\n\t\t}\r\n\r\n\t\t#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\t\t\tcolor: #5A949E;\r\n\t\t}\r\n\r\n\t\t#Header h3 a:hover {\r\n\t\t\tcolor: #D6FFFF;\r\n\t\t\tbackground-color: #1E505A;\r\n\t\t}\r\n\r\n\t\t#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\t\t\tcolor: #000;\r\n\t\t}\r\n\r\n\t\t#Header h3 a.current:hover {\r\n\t\t\tcolor: #000;\r\n\t\t\tbackground-color: #C7E5EA;\r\n\t\t}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n//-->\r\n</script>\r\n</head>\r\n\r\n<body>\r\n\r\n\t<div id=\"StatusBarContainer\">\r\n\t\t<div id=\"Statusbar\">\r\n\t\t\t<div id=\"StatusRight\"><img src=\"images/spacer.gif\" width=\"10\" height=\"10\"></div>\r\n\t\t</div>\r\n\t</div>\r\n\r\n\t<div class=\"Shadow\" id=\"Shadow\">\r\n\t\t<div class=\"Container\">\r\n\t\t\t<div id=\"Header\">\r\n\t\t\t\t");

            // end
            // begin [file="/adminAccountsCreateAccount.jsp";from=(151,4);to=(151,37)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(151,37);to=(154,3)]
                out.write("\r\n\t  \r\n      <!-- TABS -->\r\n\t  ");

            // end
            // begin [file="/adminAccountsCreateAccount.jsp";from=(154,3);to=(154,35)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(154,35);to=(179,31)]
                out.write("\r\n\t  \r\n\t\t\t</div>\r\n\r\n\t\t\t<div id=\"ContentFrame\">\r\n\t\t\t\t<div class=\"Left\">\r\n\t \t\t\t\t<div class=\"SectionHeader\">\r\n\t\t\t\t\t\t<h1>Create Accounts</h1>\r\n\t \t\t\t\t</div>\r\n   \r\n        \r\n        <div class=\"Post\">\r\n  \r\n          <form name=\"form1\" method=\"post\" action=\"./servlet/ControllerServlet\">\r\n            <p><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"2\">Name:</font> \r\n              <input type=\"text\" name=\"name\">\r\n            </p>\r\n            <p>Username: \r\n              <input type=\"text\" name=\"username\">\r\n            </p>\r\n            <p>Password: \r\n              <input type=\"password\" name=\"password\">\r\n            </p>\r\n            <p>Account Type: \r\n              <select name=\"type\">\r\n                <option value=\"");

            // end
            // begin [file="/adminAccountsCreateAccount.jsp";from=(179,34);to=(179,54)]
                out.print(AccountType.END_USER);
            // end
            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(179,56);to=(180,31)]
                out.write("\" selected>End User</option>\r\n                <option value=\"");

            // end
            // begin [file="/adminAccountsCreateAccount.jsp";from=(180,34);to=(180,53)]
                out.print(AccountType.MANAGER);
            // end
            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(180,55);to=(181,31)]
                out.write("\">Manager</option>\r\n                <option value=\"");

            // end
            // begin [file="/adminAccountsCreateAccount.jsp";from=(181,34);to=(181,66)]
                out.print(AccountType.SYSTEM_ADMINISTRATOR);
            // end
            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(181,68);to=(187,54)]
                out.write("\">System Administrator</option>\r\n              </select>\r\n            </p>\r\n            <p>&nbsp;</p>\r\n        <input type=\"submit\" name=\"Submit\" value=\"Create\">\r\n            <input type=\"button\" name=\"Button\" value=\"Cancel\" onClick=\"MM_callJS('window.history.go(-1)')\">\r\n            <input type=\"hidden\" name=\"opcode\" value=\"");

            // end
            // begin [file="/adminAccountsCreateAccount.jsp";from=(187,57);to=(187,82)]
                out.print(Operations.CREATE_ACCOUNT);
            // end
            // HTML // begin [file="/adminAccountsCreateAccount.jsp";from=(187,84);to=(227,0)]
                out.write("\">\r\n          </form>\r\n</div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t<li><a href=\"selectProjects.jsp\">Open a Project</a></li>\r\n\t\t<li><a href=\"createProject.jsp\">Create a Project</a></li>\t  \r\n\t</ul>\r\n\t<br/>\r\n\t<p>&nbsp;</p>\r\n\t<p>&nbsp;</p>\r\n\t<p>&nbsp;</p>\r\n     \r\n</div>\r\n\r\n\r\n</div>\r\n<!--\r\n<div id=\"showhelp\"><a href=\"\">Show \"Things to do\"</a></div>\r\n-->\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
