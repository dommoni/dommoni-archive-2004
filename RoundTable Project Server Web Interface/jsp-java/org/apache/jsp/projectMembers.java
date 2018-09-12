package org.apache.jsp;

import java.util.HashMap;
import java.util.Vector;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.AccountSettings;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import com.dommoni.ece.webui.MenuItem;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectMembers extends HttpJspBase {


    static {
    }
    public projectMembers( ) {
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

            // HTML // begin [file="/projectMembers.jsp";from=(0,37);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembers.jsp";from=(1,36);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectMembers.jsp";from=(3,66);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembers.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembers.jsp";from=(5,54);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembers.jsp";from=(6,58);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembers.jsp";from=(7,50);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembers.jsp";from=(8,96);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembers.jsp";from=(9,96);to=(11,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectMembers.jsp";from=(11,50);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembers.jsp";from=(12,60);to=(14,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectMembers.jsp";from=(14,2);to=(35,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	Account projectMembers[] = psc.getAccountManager().getAllAccountsForProject(currentProject.getId());
                	
                	try
                	{
                	   for(int i = 0; i < projectMembers.length; i++)
                	   {
                	      System.out.println(projectMembers[i].getId());
                		  System.out.println(projectMembers[i].getName()+"\n");
                	   }
                	}
                	catch(Exception e)
                	{
                	}
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectMembers.jsp";from=(35,2);to=(45,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectMembers.jsp";from=(45,12);to=(45,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectMembers.jsp";from=(45,32);to=(165,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\ntright {\r\n   text-align: right;\r\n}\r\n</style>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectMembers.jsp";from=(165,3);to=(165,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMembers.jsp";from=(165,36);to=(168,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectMembers.jsp";from=(168,9);to=(168,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMembers.jsp";from=(168,41);to=(183,3)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t<h1>Members</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n\t  <!--projects members -->\r\n\t  ");

            // end
            // begin [file="/projectMembers.jsp";from=(183,5);to=(186,6)]
                
                	  if(projectMembers != null && projectMembers.length > 0)
                	  {
                	  	  
            // end
            // HTML // begin [file="/projectMembers.jsp";from=(186,8);to=(186,58)]
                out.write("<table border=\"0\" cellspacing=\"3\" cellpadding=\"6\">");

            // end
            // begin [file="/projectMembers.jsp";from=(186,60);to=(189,8)]
                
                		  for(int i = 0; i < projectMembers.length; i++)
                		  {
                		      
            // end
            // HTML // begin [file="/projectMembers.jsp";from=(189,10);to=(191,56)]
                out.write("<tr>\r\n\t\t\t\t  <td width=\"275\">\r\n\t\t\t\t    <a href=\"projectMembersViewMember.jsp?accountid=");

            // end
            // begin [file="/projectMembers.jsp";from=(191,59);to=(191,84)]
                out.print(projectMembers[i].getId());
            // end
            // HTML // begin [file="/projectMembers.jsp";from=(191,86);to=(191,139)]
                out.write("\"><font face=\"Verdana, Arial, Helvetica, sans-serif\">");

            // end
            // begin [file="/projectMembers.jsp";from=(191,142);to=(191,169)]
                out.print(projectMembers[i].getName());
            // end
            // HTML // begin [file="/projectMembers.jsp";from=(191,171);to=(192,8)]
                out.write("</font></a> \r\n\t\t\t\t    ");

            // end
            // begin [file="/projectMembers.jsp";from=(192,10);to=(199,11)]
                
                					AccountSettings aset = psc.getAccountManager().getAccountSettings(projectMembers[i].getId());
                					if(aset != null) 
                					{
                					   String email = aset.getPrimaryEmailAddress();
                					   if(email != null && email.length() > 0)
                					   {
                					      
            // end
            // HTML // begin [file="/projectMembers.jsp";from=(199,13);to=(199,35)]
                out.write("<span class=\"tright\">(");

            // end
            // begin [file="/projectMembers.jsp";from=(199,38);to=(199,43)]
                out.print(email);
            // end
            // HTML // begin [file="/projectMembers.jsp";from=(199,45);to=(199,53)]
                out.write(")</span>");

            // end
            // begin [file="/projectMembers.jsp";from=(199,55);to=(202,5)]
                
                					   } 
                					}
                					
            // end
            // HTML // begin [file="/projectMembers.jsp";from=(202,7);to=(204,13)]
                out.write("\r\n\t\t\t\t  </td>\r\n\t\t      </tr>");

            // end
            // begin [file="/projectMembers.jsp";from=(204,15);to=(206,4)]
                
                		  }
                		  
            // end
            // HTML // begin [file="/projectMembers.jsp";from=(206,6);to=(206,14)]
                out.write("</table>");

            // end
            // begin [file="/projectMembers.jsp";from=(206,16);to=(211,4)]
                
                	  }
                	  else
                	  {
                	   // not possible in theory as you wouldnt be able to view this page if the project didnt at least one member.
                	   
            // end
            // HTML // begin [file="/projectMembers.jsp";from=(211,6);to=(211,54)]
                out.write("This project currently has no members available.");

            // end
            // begin [file="/projectMembers.jsp";from=(211,56);to=(213,3)]
                
                	  }
                	  
            // end
            // HTML // begin [file="/projectMembers.jsp";from=(213,5);to=(224,5)]
                out.write("\r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectMembers.jsp";from=(224,5);to=(224,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMembers.jsp";from=(224,47);to=(246,0)]
                out.write("\t  \r\n\t</ul>\r\n     <br/>\r\n    <br/>    \r\n\t<p>&nbsp;</p>\r\n</div>\r\n\r\n\r\n</div>\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
