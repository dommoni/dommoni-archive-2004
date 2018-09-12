package org.apache.jsp;

import java.util.HashMap;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import com.dommoni.ece.webui.utils.StringUtils;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class adminConfiguration extends HttpJspBase {


    static {
    }
    public adminConfiguration( ) {
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

            // HTML // begin [file="/adminConfiguration.jsp";from=(0,37);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(2,66);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(3,50);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(4,54);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(5,50);to=(7,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(7,96);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(8,96);to=(10,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(10,52);to=(11,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(11,60);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(12,59);to=(14,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/adminConfiguration.jsp";from=(14,2);to=(26,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	
                	IAccountManager accountManager = psc.getAccountManager();
                	Account account = accountManager.getAccountFromUsername(psc.getUsername());
                	
                	IProjectManager projectManager = psc.getProjectManager();
                	Project allProjects[] = projectManager.getAllProjects();
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(26,2);to=(36,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/adminConfiguration.jsp";from=(36,12);to=(36,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(36,32);to=(154,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script src=\"./includes/deleteDlgPopup.js\"></script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/adminConfiguration.jsp";from=(154,3);to=(154,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(154,36);to=(157,2)]
                out.write("\r\n\r\n\t <!-- TABS -->\r\n\t ");

            // end
            // begin [file="/adminConfiguration.jsp";from=(157,2);to=(157,34)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(157,34);to=(173,6)]
                out.write("\r\n\t  \r\n\t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n      <h1>Configuration</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n  <!--projects--> \r\n\t     ");

            // end
            // begin [file="/adminConfiguration.jsp";from=(173,8);to=(176,3)]
                
                		 if(allProjects != null)
                		 {
                		 
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(176,5);to=(176,55)]
                out.write("<table border=\"0\" cellspacing=\"3\" cellpadding=\"6\">");

            // end
            // begin [file="/adminConfiguration.jsp";from=(176,57);to=(179,5)]
                
                			 for(int i = 0; i < allProjects.length; i++)
                			 {
                				 
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(179,7);to=(181,70)]
                out.write("\r\n\t\t\t\t<tr>\r\n\t\t\t\t  <td width=\"225\"><a href=\"adminProjectsViewProject.jsp?projectId=");

            // end
            // begin [file="/adminConfiguration.jsp";from=(181,73);to=(181,95)]
                out.print(allProjects[i].getId());
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(181,97);to=(181,150)]
                out.write("\"><font face=\"Verdana, Arial, Helvetica, sans-serif\">");

            // end
            // begin [file="/adminConfiguration.jsp";from=(181,153);to=(181,177)]
                out.print(allProjects[i].getName());
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(181,179);to=(182,6)]
                out.write("</font></a></td>\r\n\t\t\t\t  ");

            // end
            // begin [file="/adminConfiguration.jsp";from=(182,8);to=(199,6)]
                
                				  // if theres a single-quote in the name, we have to build it differantly.
                				  if(allProjects[i].getName().indexOf('\'') > -1)
                				  {
                				     StringBuffer sb = new StringBuffer();
                					 char[] chName = allProjects[i].getName().toCharArray();
                					 for(int ii =0; ii < chName.length; ii++)
                					 {
                					    sb.append(chName[ii]);
                					    if((ii + 1) < chName.length)
                					    {
                							if(chName[ii + 1] == '\'')
                							{
                								sb.append("\\");   
                							}
                						}
                					 }
                					 
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(199,8);to=(200,43)]
                out.write("\r\n\t\t\t\t\t <td><a href=\"#\" onClick=\"showDelete('");

            // end
            // begin [file="/adminConfiguration.jsp";from=(200,46);to=(200,95)]
                out.print(StringUtils.getJSString(allProjects[i].getName()));
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(200,97);to=(200,100)]
                out.write("','");

            // end
            // begin [file="/adminConfiguration.jsp";from=(200,103);to=(200,128)]
                out.print(Operations.DELETE_PROJECT);
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(200,130);to=(200,133)]
                out.write("','");

            // end
            // begin [file="/adminConfiguration.jsp";from=(200,136);to=(200,158)]
                out.print(allProjects[i].getId());
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(200,160);to=(201,8)]
                out.write("','Project','adminProjects.jsp');\"><font size=\"2\">Delete</font></a></td>\r\n\t\t\t\t  \t ");

            // end
            // begin [file="/adminConfiguration.jsp";from=(201,10);to=(205,9)]
                
                				  }
                				  else
                				  {
                				     
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(205,11);to=(206,43)]
                out.write("\r\n\t\t\t\t\t <td><a href=\"#\" onClick=\"showDelete('");

            // end
            // begin [file="/adminConfiguration.jsp";from=(206,46);to=(206,95)]
                out.print(StringUtils.getJSString(allProjects[i].getName()));
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(206,97);to=(206,100)]
                out.write("','");

            // end
            // begin [file="/adminConfiguration.jsp";from=(206,103);to=(206,128)]
                out.print(Operations.DELETE_PROJECT);
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(206,130);to=(206,133)]
                out.write("','");

            // end
            // begin [file="/adminConfiguration.jsp";from=(206,136);to=(206,158)]
                out.print(allProjects[i].getId());
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(206,160);to=(207,8)]
                out.write("','Project','adminProjects.jsp');\"><font size=\"2\">Delete</font></a></td>\r\n\t\t\t\t  \t ");

            // end
            // begin [file="/adminConfiguration.jsp";from=(207,10);to=(208,7)]
                
                				  }
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(208,9);to=(209,73)]
                out.write("\r\n\t\t\t\t  <td><font size=\"2\"><a href=\"adminProjectsEditProject.jsp?projectid=");

            // end
            // begin [file="/adminConfiguration.jsp";from=(209,76);to=(209,98)]
                out.print(allProjects[i].getId());
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(209,100);to=(211,9)]
                out.write("\">Edit</a></font></td>\r\n\t\t\t\t</tr>\t \r\n      \t\t\t");

            // end
            // begin [file="/adminConfiguration.jsp";from=(211,11);to=(213,4)]
                
                			 }
                			 
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(213,6);to=(213,14)]
                out.write("</table>");

            // end
            // begin [file="/adminConfiguration.jsp";from=(213,16);to=(217,4)]
                
                		 }
                		 else
                		 {
                		 	
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(217,6);to=(220,5)]
                out.write("\r\n\t\t\t  <font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"3\" color=\"#003399\"> \r\n\t\t\t  Currently no Projects exist in the System. </font> \r\n\t\t\t  ");

            // end
            // begin [file="/adminConfiguration.jsp";from=(220,7);to=(222,3)]
                
                		 }
                		 
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(222,5);to=(233,5)]
                out.write("\r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/adminConfiguration.jsp";from=(233,5);to=(233,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/adminConfiguration.jsp";from=(233,47);to=(256,0)]
                out.write("\r\n\t\t<li><a href=\"./adminProjectsCreateProject.jsp\">Create a Project</a></li>\t  \r\n\t</ul>\r\n    <br/>\r\n    <br/>\r\n\t<p>&nbsp;</p>    \r\n</div>\r\n\r\n\r\n</div>\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
