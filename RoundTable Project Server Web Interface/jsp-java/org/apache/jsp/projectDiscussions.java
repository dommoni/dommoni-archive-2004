package org.apache.jsp;

import java.util.HashMap;
import java.util.Vector;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Discussion;
import com.dommoni.roundtable.DiscussionMessage;
import com.dommoni.roundtable.NotificationContext;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import com.dommoni.ece.webui.MenuItem;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectDiscussions extends HttpJspBase {


    static {
    }
    public projectDiscussions( ) {
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

            // HTML // begin [file="/projectDiscussions.jsp";from=(0,37);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(1,36);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(3,66);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(5,54);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(6,53);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(7,60);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(8,62);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(9,50);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(10,96);to=(11,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(11,96);to=(13,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(13,50);to=(14,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(14,52);to=(15,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(15,60);to=(17,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectDiscussions.jsp";from=(17,2);to=(26,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	Discussion discussions[] = psc.getDiscussionManager().getAllDiscussionsForProject(currentProject.getId());
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(26,2);to=(36,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectDiscussions.jsp";from=(36,12);to=(36,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(36,32);to=(160,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n</head>\r\n\r\n<script>\r\nfunction checkDelete(discussionId, discussionName)\r\n{\r\n   open(\"projectDiscussionsCheckDelete.jsp?discussionId=\"+discussionId+\"&discussionName=\"+discussionName, '', 'height=200,width=300,directories=no,location=no,menubar=no,resizable=no,scrollbars=no,status=no,toolbar=no,screenX=200,screenY=200,top=200,left=200');\r\n}\r\n</script>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectDiscussions.jsp";from=(160,3);to=(160,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(160,36);to=(163,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectDiscussions.jsp";from=(163,9);to=(163,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(163,41);to=(178,6)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t<h1>Discussions</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n  <!--projects--> \r\n\t     ");

            // end
            // begin [file="/projectDiscussions.jsp";from=(178,8);to=(181,4)]
                
                		 if(discussions != null && discussions.length > 0)
                		 {
                		 	
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(181,6);to=(181,56)]
                out.write("<table border=\"0\" cellspacing=\"3\" cellpadding=\"6\">");

            // end
            // begin [file="/projectDiscussions.jsp";from=(181,58);to=(184,4)]
                
                		 	for(int i = 0; i < discussions.length; i++)
                			{
                				
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(184,6);to=(186,83)]
                out.write("\r\n\t\t\t\t  <tr>\r\n\t\t\t\t    <td width=\"225\"><a href=\"projectDiscussionsViewDiscussion.jsp?discussionid=");

            // end
            // begin [file="/projectDiscussions.jsp";from=(186,86);to=(186,108)]
                out.print(discussions[i].getId());
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(186,110);to=(186,163)]
                out.write("\"><font face=\"Verdana, Arial, Helvetica, sans-serif\">");

            // end
            // begin [file="/projectDiscussions.jsp";from=(186,166);to=(186,191)]
                out.print(discussions[i].getTitle());
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(186,193);to=(187,13)]
                out.write("</font></a></td>\r\n\t\t          \t");

            // end
            // begin [file="/projectDiscussions.jsp";from=(187,15);to=(208,8)]
                
                					// it's the organizer's account...
                					if(discussions[i].getMemberIds() != null && 
                					   discussions[i].getMemberIds().length > 0 &&
                					   discussions[i].getMemberIds()[0] == account.getId())
                					{
                					   if(discussions[i].getTitle().indexOf('\'') > -1)
                					   {
                						  StringBuffer sb = new StringBuffer();
                						  char[] chName = discussions[i].getTitle().toCharArray();
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
            // HTML // begin [file="/projectDiscussions.jsp";from=(208,10);to=(208,47)]
                out.write("<td><a href=\"javascript:checkDelete('");

            // end
            // begin [file="/projectDiscussions.jsp";from=(208,50);to=(208,72)]
                out.print(discussions[i].getId());
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(208,74);to=(208,77)]
                out.write("','");

            // end
            // begin [file="/projectDiscussions.jsp";from=(208,80);to=(208,93)]
                out.print(sb.toString());
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(208,95);to=(208,114)]
                out.write("')\">Delete</a></td>");

            // end
            // begin [file="/projectDiscussions.jsp";from=(208,116);to=(212,11)]
                
                					   }
                					   else
                					   {
                					      
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(212,13);to=(212,50)]
                out.write("<td><a href=\"javascript:checkDelete('");

            // end
            // begin [file="/projectDiscussions.jsp";from=(212,53);to=(212,75)]
                out.print(discussions[i].getId());
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(212,77);to=(212,80)]
                out.write("','");

            // end
            // begin [file="/projectDiscussions.jsp";from=(212,83);to=(212,108)]
                out.print(discussions[i].getTitle());
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(212,110);to=(212,129)]
                out.write("')\">Delete</a></td>");

            // end
            // begin [file="/projectDiscussions.jsp";from=(212,131);to=(217,8)]
                
                					   }
                					}
                					else
                					{
                					   
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(217,10);to=(217,25)]
                out.write("<td>Delete</td>");

            // end
            // begin [file="/projectDiscussions.jsp";from=(217,27);to=(219,5)]
                
                					}
                					
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(219,7);to=(221,7)]
                out.write("\r\n\t\t\t\t  </tr>\r\n\t\t\t    ");

            // end
            // begin [file="/projectDiscussions.jsp";from=(221,9);to=(223,3)]
                
                			}
                			
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(223,5);to=(223,13)]
                out.write("</table>");

            // end
            // begin [file="/projectDiscussions.jsp";from=(223,15);to=(227,4)]
                
                		 }
                		 else
                		 {
                		 	
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(227,6);to=(227,61)]
                out.write("<p>No discussions currently exist for this project.</P>");

            // end
            // begin [file="/projectDiscussions.jsp";from=(227,63);to=(229,3)]
                
                		 }
                		 
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(229,5);to=(241,5)]
                out.write("\r\n\t\t \r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectDiscussions.jsp";from=(241,5);to=(241,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(241,47);to=(242,61)]
                out.write("\t  \r\n\t\t<li><a href=\"projectNotificationsNotificationWizard.jsp?nc=");

            // end
            // begin [file="/projectDiscussions.jsp";from=(242,64);to=(242,102)]
                out.print(NotificationContext.DISCUSSION_CONTEXT);
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(242,104);to=(242,110)]
                out.write("&path=");

            // end
            // begin [file="/projectDiscussions.jsp";from=(242,113);to=(242,137)]
                out.print(request.getServletPath());
            // end
            // HTML // begin [file="/projectDiscussions.jsp";from=(242,139);to=(269,0)]
                out.write("\">New Notification</a></li>\r\n\t</ul>\r\n     <br/>\r\n    <br/>\r\n\t<p>&nbsp;</p>    \r\n</div>\r\n\r\n\r\n</div>\r\n\r\n\r\n<!--\r\n\t<div id=\"showhelp\"><a href=\"../project/show_help?project_id=4661&return_to=%2Fclients%2Ftestproject7%2F1%2Fall%2F\">Show \"Things to do\"</a></div>\r\n-->\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
