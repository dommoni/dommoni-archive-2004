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


public class adminAccountsModifyAccount extends HttpJspBase {


    static {
    }
    public adminAccountsModifyAccount( ) {
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

            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(0,37);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(2,50);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(3,54);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(5,66);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(6,96);to=(8,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(8,52);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(9,60);to=(11,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(11,2);to=(25,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Account accounts[] = psc.getAccountManager().getAllAccounts();
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	
                	IAccountManager accountManager = psc.getAccountManager();
                	Account account = accountManager.getAccountFromUsername(psc.getUsername());
                	
                	String szAccountId = request.getParameter("accountid");
                	int accountId = Integer.parseInt(szAccountId);
                	Account modAccount = accountManager.getAccount(accountId);
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(25,2);to=(35,7)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n<meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n<title>");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(35,10);to=(35,28)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(35,30);to=(155,2)]
                out.write("</title>\r\n<link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\r\n<style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n//-->\r\n</script>\r\n</head>\r\n\r\n<body>\r\n\r\n\t<div id=\"StatusBarContainer\">\r\n\t<div id=\"Statusbar\">\r\n\t  <div id=\"StatusRight\"><img src=\"images/spacer.gif\" width=\"10\" height=\"10\"></div>\r\n\t</div>\r\n\t</div>\r\n\r\n\t<div class=\"Shadow\" id=\"Shadow\">\r\n\t  <div class=\"Container\">\r\n             <div id=\"Header\">\r\n\t\t");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(155,2);to=(155,35)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(155,35);to=(158,3)]
                out.write("\r\n\t  \r\n      <!-- TABS -->\r\n\t  ");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(158,3);to=(158,35)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(158,35);to=(165,24)]
                out.write("\r\n\t  \r\n\t\t\t</div>\r\n\r\n\t\t\t<div id=\"ContentFrame\">\r\n\t\t\t\t<div class=\"Left\">\r\n\t \t\t\t\t<div class=\"SectionHeader\">\r\n\t\t\t\t\t\t<h1>Edit Account: ");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(165,27);to=(165,47)]
                out.print(modAccount.getName());
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(165,49);to=(173,52)]
                out.write("</h1>\r\n\t \t\t\t\t</div>\r\n   \r\n        \r\n        <div class=\"Post\">\r\n  \r\n          <form name=\"form1\" method=\"post\" action=\"./servlet/ControllerServlet\">\r\n            <p><font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"2\">Name:</font> \r\n              <input type=\"text\" name=\"name\" value=\"");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(173,55);to=(173,75)]
                out.print(modAccount.getName());
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(173,77);to=(176,56)]
                out.write("\">\r\n            </p>\r\n            <p>Username: \r\n              <input type=\"text\" name=\"username\" value=\"");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(176,59);to=(176,83)]
                out.print(modAccount.getUsername());
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(176,85);to=(183,16)]
                out.write("\">\r\n            </p>\r\n            <!--<p>Password: \r\n              <input type=\"password\" name=\"password\">\r\n            </p>-->\r\n            <p>Account Type: \r\n              <select name=\"type\">\r\n                ");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(183,18);to=(184,5)]
                if(modAccount.getAccountType() == AccountType.END_USER)
                		{  
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(184,7);to=(184,22)]
                out.write("<option value=\"");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(184,25);to=(184,45)]
                out.print(AccountType.END_USER);
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(184,47);to=(184,75)]
                out.write("\" selected>End User</option>");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(184,77);to=(186,6)]
                  }
                                else 
                		{   
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(186,8);to=(186,23)]
                out.write("<option value=\"");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(186,26);to=(186,46)]
                out.print(AccountType.END_USER);
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(186,48);to=(186,67)]
                out.write("\">End User</option>");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(186,69);to=(186,72)]
                 } 
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(186,74);to=(188,2)]
                out.write("\r\n\t\t\r\n\t\t");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(188,4);to=(189,6)]
                if(modAccount.getAccountType() == AccountType.MANAGER) 
                		{   
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(189,8);to=(189,23)]
                out.write("<option value=\"");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(189,26);to=(189,45)]
                out.print(AccountType.MANAGER);
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(189,47);to=(189,74)]
                out.write("\" selected>Manager</option>");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(189,76);to=(191,6)]
                 }
                		else 
                		{   
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(191,8);to=(191,23)]
                out.write("<option value=\"");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(191,26);to=(191,45)]
                out.print(AccountType.MANAGER);
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(191,47);to=(191,65)]
                out.write("\">Manager</option>");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(191,67);to=(191,70)]
                  }
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(191,72);to=(193,2)]
                out.write("\r\n\t\t\r\n\t\t");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(193,4);to=(194,6)]
                if(modAccount.getAccountType() == AccountType.SYSTEM_ADMINISTRATOR) 
                		{   
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(194,8);to=(194,23)]
                out.write("<option value=\"");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(194,26);to=(194,58)]
                out.print(AccountType.SYSTEM_ADMINISTRATOR);
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(194,60);to=(194,100)]
                out.write("\" selected>System Administrator</option>");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(194,102);to=(196,6)]
                 }
                		else
                		{   
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(196,8);to=(196,23)]
                out.write("<option value=\"");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(196,26);to=(196,58)]
                out.print(AccountType.SYSTEM_ADMINISTRATOR);
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(196,60);to=(196,91)]
                out.write("\">System Administrator</option>");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(196,93);to=(196,95)]
                 }
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(196,97);to=(202,54)]
                out.write("\r\n              </select>\r\n            </p>\r\n            <p>&nbsp;</p>\r\n        <input type=\"submit\" name=\"Submit\" value=\"Create\">\r\n            <input type=\"button\" name=\"Button\" value=\"Cancel\" onClick=\"MM_callJS('window.history.go(-1)')\">\r\n            <input type=\"hidden\" name=\"opcode\" value=\"");

            // end
            // begin [file="/adminAccountsModifyAccount.jsp";from=(202,57);to=(202,80)]
                out.print(Operations.EDIT_ACCOUNT);
            // end
            // HTML // begin [file="/adminAccountsModifyAccount.jsp";from=(202,82);to=(239,0)]
                out.write("\">\r\n          </form>\r\n</div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t<li><a href=\"selectProjects.jsp\">Open a Project</a></li>\r\n\t\t<li><a href=\"createProject.jsp\">Create a Project</a></li>\t  \r\n\t</ul>\r\n\t<br/>\r\n\t<p>&nbsp;</p>\r\n\t<p>&nbsp;</p>\r\n\t<p>&nbsp;</p>\r\n     \r\n</div>\r\n\r\n\r\n</div>\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
