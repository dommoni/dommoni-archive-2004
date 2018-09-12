package org.apache.jsp;

import java.util.HashMap;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class adminAccountsViewAccount extends HttpJspBase {


    static {
    }
    public adminAccountsViewAccount( ) {
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

            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(0,37);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(2,49);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(3,53);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(4,49);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(5,65);to=(7,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(7,95);to=(9,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(9,59);to=(11,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(11,2);to=(31,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	int accountId;
                	Account viewAccount = null;
                	try
                	{
                	   accountId = Integer.parseInt(request.getParameter("accountid"));
                	   IAccountManager accountManager = psc.getAccountManager();
                	   viewAccount = accountManager.getAccount(accountId);
                	}
                	catch(Exception e)
                	{
                	   e.printStackTrace();
                	}
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(31,2);to=(41,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(41,12);to=(41,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(41,32);to=(158,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(158,3);to=(158,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(158,36);to=(161,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(161,9);to=(161,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(161,41);to=(166,5)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n      <div class=\"Left\">\r\n\t    ");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(166,7);to=(166,33)]
                 if(viewAccount != null) {
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(166,35);to=(169,18)]
                out.write("\r\n\t\t\r\n\t    <div class=\"SectionHeader\">\r\n\t \t  <h1>Account: ");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(169,21);to=(169,42)]
                out.print(viewAccount.getName());
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(169,44);to=(175,4)]
                out.write("</h1>\r\n\t    </div>\r\n\r\n        <div class=\"Post\">\r\n\t    <!-- PAGE TEXT GOES HERE -->\r\n   \t\t  <p>\r\n\t\t  ");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(175,6);to=(175,41)]
                if(viewAccount.getName() != null) {
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(175,43);to=(176,19)]
                out.write("\r\n\t\t    <b>Name:</b> ");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(176,22);to=(176,43)]
                out.print(viewAccount.getName());
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(176,45);to=(177,4)]
                out.write("<br />\r\n\t\t  ");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(177,6);to=(177,7)]
                }
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(177,9);to=(178,7)]
                out.write("\r\n   \t\t  ");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(178,9);to=(178,48)]
                if(viewAccount.getNickName() != null) {
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(178,50);to=(179,30)]
                out.write("\r\n            <b>Nick Name:</b> ");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(179,33);to=(179,58)]
                out.print(viewAccount.getNickName());
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(179,60);to=(180,4)]
                out.write("<br />\r\n\t\t  ");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(180,6);to=(180,7)]
                }
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(180,9);to=(181,4)]
                out.write("\r\n\t\t  ");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(181,6);to=(181,45)]
                if(viewAccount.getUsername() != null) {
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(181,47);to=(182,23)]
                out.write("\r\n\t\t    <b>Username:</b> ");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(182,26);to=(182,51)]
                out.print(viewAccount.getUsername());
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(182,53);to=(183,10)]
                out.write("<br />\r\n          ");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(183,12);to=(183,13)]
                }
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(183,15);to=(184,4)]
                out.write("\r\n\t\t  ");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(184,6);to=(187,6)]
                
                		    if(viewAccount.getAccountType() == AccountType.SYSTEM_ADMINISTRATOR)
                			{
                			   
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(187,8);to=(187,55)]
                out.write("<b>Account Type:</b> System Administrator<br />");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(187,57);to=(191,6)]
                
                			}
                			else if(viewAccount.getAccountType() == AccountType.END_USER)
                			{
                			   
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(191,8);to=(191,43)]
                out.write("<b>Account Type:</b> End User<br />");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(191,45);to=(195,6)]
                
                			}
                			else if(viewAccount.getAccountType() == AccountType.MANAGER)
                			{
                			   
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(195,8);to=(195,42)]
                out.write("<b>Account Type:</b> Manager<br />");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(195,44);to=(199,6)]
                
                			}
                			else
                			{
                			   
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(199,8);to=(199,42)]
                out.write("<b>Account Type:</b> Unknown<br />");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(199,44);to=(201,10)]
                
                			}
                          
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(201,12);to=(202,4)]
                out.write("\r\n\t\t  ");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(202,6);to=(202,44)]
                if(viewAccount.getProfile() != null) {
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(202,46);to=(203,4)]
                out.write("\r\n\t\t  ");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(203,6);to=(203,7)]
                }
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(203,9);to=(206,65)]
                out.write("\r\n\t\t  \r\n\t\t  <p align=\"center\">\r\n\t\t  <img src=\"./adminAccountsGet2WeekActivityChart.jsp?accountid=");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(206,68);to=(206,87)]
                out.print(viewAccount.getId());
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(206,89);to=(208,2)]
                out.write("\" />\r\n\t\t  </p>\r\n\t\t");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(208,4);to=(208,12)]
                } else {
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(208,14);to=(210,2)]
                out.write("\r\n\t\t   <font color=\"#FF0000\">ERROR: Unable to retrieve account.</font>\r\n\t\t");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(210,4);to=(210,5)]
                }
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(210,7);to=(221,5)]
                out.write("\r\n\t\t</p>  \r\n        </div>\r\n      </div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/adminAccountsViewAccount.jsp";from=(221,5);to=(221,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminAccountsViewAccount.jsp";from=(221,47);to=(244,7)]
                out.write("\t  \r\n\t</ul>\r\n     <br/>\r\n    <br/>    \r\n\t<p>&nbsp;</p>\r\n</div>\r\n\r\n\r\n</div>\r\n\r\n\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>");

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
