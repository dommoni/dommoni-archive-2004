package org.apache.jsp;

import java.util.HashMap;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class selectProjects extends HttpJspBase {


    static {
    }
    public selectProjects( ) {
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

            // HTML // begin [file="/selectProjects.jsp";from=(0,37);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/selectProjects.jsp";from=(2,50);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/selectProjects.jsp";from=(3,50);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/selectProjects.jsp";from=(4,66);to=(6,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/selectProjects.jsp";from=(6,52);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/selectProjects.jsp";from=(7,60);to=(9,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/selectProjects.jsp";from=(9,96);to=(11,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/selectProjects.jsp";from=(11,2);to=(20,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	IProjectManager projectManager = psc.getProjectManager();
                	Project projects[] = projectManager.getAllProjectsForAccount(account.getId());
                	
                    HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/selectProjects.jsp";from=(20,2);to=(28,7)]
                out.write("\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n<head>\r\n<meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n<title>");

            // end
            // begin [file="/selectProjects.jsp";from=(28,10);to=(28,28)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/selectProjects.jsp";from=(28,30);to=(148,6)]
                out.write("</title>\r\n<link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n<style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n//-->\r\n</script>\r\n</head>\r\n\r\n\r\n<body>\r\n<div id=\"StatusBarContainer\"> \r\n  <div id=\"Statusbar\"> \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n  </div>\r\n</div>\r\n<div class=\"Shadow\" id=\"Shadow\"> \r\n  <div class=\"Container\"> \r\n    <div id=\"Header\"> \r\n      \r\n      ");

            // end
            // begin [file="/selectProjects.jsp";from=(148,6);to=(148,39)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/selectProjects.jsp";from=(148,39);to=(156,4)]
                out.write("\r\n      \r\n    </div>\r\n    <div id=\"ContentFrame\"> \r\n      <div class=\"Left\"> \r\n        \r\n        <div class=\"Post\">\r\n          <h1>Projects</h1>\r\n\t\t  ");

            // end
            // begin [file="/selectProjects.jsp";from=(156,6);to=(159,6)]
                
                		  if(projects != null && projects.length > 0)
                		  {
                		  	 
            // end
            // HTML // begin [file="/selectProjects.jsp";from=(159,8);to=(159,12)]
                out.write("<ul>");

            // end
            // begin [file="/selectProjects.jsp";from=(159,14);to=(162,7)]
                
                		     for(int i = 0; i < projects.length; i++)
                			 {
                			    
            // end
            // HTML // begin [file="/selectProjects.jsp";from=(162,9);to=(163,40)]
                out.write("\r\n\t\t\t\t   <!--<li><a href=main.jsp?project=");

            // end
            // begin [file="/selectProjects.jsp";from=(163,43);to=(163,62)]
                out.print(projects[i].getId());
            // end
            // HTML // begin [file="/selectProjects.jsp";from=(163,64);to=(163,65)]
                out.write(">");

            // end
            // begin [file="/selectProjects.jsp";from=(163,68);to=(163,89)]
                out.print(projects[i].getName());
            // end
            // HTML // begin [file="/selectProjects.jsp";from=(163,91);to=(164,55)]
                out.write("</li>-->\r\n\t\t\t\t   <li><a href=\"./servlet/ControllerServlet?opcode=");

            // end
            // begin [file="/selectProjects.jsp";from=(164,58);to=(164,80)]
                out.print(Operations.SET_PROJECT);
            // end
            // HTML // begin [file="/selectProjects.jsp";from=(164,82);to=(164,93)]
                out.write("&projectId=");

            // end
            // begin [file="/selectProjects.jsp";from=(164,96);to=(164,115)]
                out.print(projects[i].getId());
            // end
            // HTML // begin [file="/selectProjects.jsp";from=(164,117);to=(164,119)]
                out.write("\">");

            // end
            // begin [file="/selectProjects.jsp";from=(164,122);to=(164,143)]
                out.print(projects[i].getName());
            // end
            // HTML // begin [file="/selectProjects.jsp";from=(164,145);to=(165,4)]
                out.write("</a></li>\r\n\t\t\t\t");

            // end
            // begin [file="/selectProjects.jsp";from=(165,6);to=(167,4)]
                
                			 }
                			 
            // end
            // HTML // begin [file="/selectProjects.jsp";from=(167,6);to=(168,10)]
                out.write("</ul>\r\n          ");

            // end
            // begin [file="/selectProjects.jsp";from=(168,12);to=(172,7)]
                
                		  }
                		  else
                		  {
                		     
            // end
            // HTML // begin [file="/selectProjects.jsp";from=(172,9);to=(175,10)]
                out.write("\r\n          <font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"2\" color=\"#FF0000\">You're \r\n          not currently a member of any projects.</font> \r\n          ");

            // end
            // begin [file="/selectProjects.jsp";from=(175,12);to=(177,4)]
                
                		  }
                		  
            // end
            // HTML // begin [file="/selectProjects.jsp";from=(177,6);to=(189,0)]
                out.write("\r\n        </div>\r\n\t\t<input type=\"button\" name=\"Button\" value=\"Cancel\" onClick=\"MM_callJS('window.history.go(-1)')\">\r\n      </div>\r\n      \r\n    </div>\r\n  </div>\r\n  <div class=\"ShadowCap\"> &nbsp; </div>\r\n</div>\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n</body>\r\n</html>\r\n");

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
