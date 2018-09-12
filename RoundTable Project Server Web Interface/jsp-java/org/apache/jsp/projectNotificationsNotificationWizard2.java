package org.apache.jsp;

import java.util.HashMap;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.NotificationContext;
import com.dommoni.roundtable.NotificationContextObject;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectNotificationsNotificationWizard2 extends HttpJspBase {


    static {
    }
    public projectNotificationsNotificationWizard2( ) {
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

            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(0,37);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(2,50);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(3,62);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(4,68);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(5,50);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(6,66);to=(8,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(8,52);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(9,60);to=(11,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(11,2);to=(54,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	String nc = null;
                	if(request.getParameter("nc") != null && request.getParameter("nc").length() > 0)
                		nc = request.getParameter("nc");
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
                	
                	// nc objects (this is terrible that i'm doing it this way!!!)
                	NotificationContextObject ncObjects[] = null;
                	if (nc != null)
                	{
                		
                		if(nc.equals(NotificationContext.DOCUMENT_CONTEXT))
                		{
                			ncObjects = psc.getDocumentManager().getAllDocumentsForProject(currentProject.getId());
                		}
                		else if(nc.equals(NotificationContext.FORUM_CONTEXT))
                		{
                			ncObjects = psc.getForumManager().getAllForumsForProject(currentProject.getId());
                		}
                		//------
                		else if(nc.equals(NotificationContext.TASK_CONTEXT))
                		{
                			ncObjects = psc.getTaskManager().getAllTasksForProject(currentProject.getId());
                		}
                		else if(nc.equals(NotificationContext.MEETING_CONTEXT))
                		{
                			ncObjects = psc.getMeetingManager().getAllMeetingsForProject(currentProject.getId());
                		}
                		else if(nc.equals(NotificationContext.DISCUSSION_CONTEXT))
                		{
                			ncObjects = psc.getDiscussionManager().getAllDiscussionsForProject(currentProject.getId());
                		}
                		else if(nc.equals(NotificationContext.SCHEDULE_CONTEXT))
                		{
                		    ncObjects = psc.getScheduleManager().getAllSchedulesForProject(currentProject.getId());
                		}
                    }		
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(54,2);to=(64,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(64,12);to=(64,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(64,32);to=(213,6)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n\r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n\r\nfunction loadOps()\r\n{\r\n   if(document.form2.object.value != 'all')\r\n   {   \r\n      document.form2.operation.options.remove(3);// = null;\r\n\t  document.form2.operation.options.remove(2);//[1] = null;\r\n\t  document.form2.operation.options.remove(1);//[2] = null;\r\n\t  document.form2.operation.options.remove(0);//[3] = null;\r\n      \r\n\t  document.form2.operation.options[0] = new Option(\"Modify\", \"modify\");\r\n\t  document.form2.operation.options[1] = new Option(\"Delete\", \"delete\"); \r\n   }\r\n   else\r\n   {\r\n      document.form2.operation.options.remove(1);//[2] = null;\r\n\t  document.form2.operation.options.remove(0);//[3] = null;\r\n\t  \r\n\t  document.form2.operation.options[0] = new Option(\"All\", \"all\");\r\n\t  document.form2.operation.options[1] = new Option(\"Create\", \"create\");\r\n\t  document.form2.operation.options[2] = new Option(\"Modify\", \"modify\");\r\n\t  document.form2.operation.options[3] = new Option(\"Delete\", \"delete\"); \r\n   }\r\n}\r\n//-->\r\n</script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\"> \r\n  <div class=\"Container\"> \r\n    <div id=\"Header\"> \r\n      ");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(213,6);to=(213,39)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(213,39);to=(215,6)]
                out.write("\r\n      <!-- TABS -->\r\n      ");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(215,6);to=(215,38)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(215,38);to=(220,10)]
                out.write("\r\n    </div>\r\n    <div id=\"ContentFrame\"> \r\n      <div class=\"Left\"> \r\n        <div class=\"SectionHeader\"> \r\n          ");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(220,12);to=(225,1)]
                
                	String ncName = nc.toLowerCase();
                	char[] ncChars = ncName.toCharArray();
                	ncChars[0] = Character.toUpperCase(ncName.charAt(0));
                	ncName = new String(ncChars); 
                	
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(225,3);to=(226,18)]
                out.write("\r\n          <h1>New ");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(226,21);to=(226,27)]
                out.print(ncName);
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(226,29);to=(230,10)]
                out.write(" Notification</h1>\r\n        </div>\r\n        <div class=\"Post\"> \r\n          <!-- PAGE TEXT GOES HERE -->\r\n          ");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(230,12);to=(236,3)]
                
                String typeStr = request.getParameter("type");
                
                if(typeStr != null && typeStr.equals("object"))
                {
                   // select the object, operation
                   
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(236,5);to=(245,20)]
                out.write("\r\n          <form name=\"form2\" method=\"post\" action=\"./servlet/ControllerServlet\">\r\n            <blockquote>\r\n              <p><font face=\"Arial, Helvetica, sans-serif\" size=\"3\" color=\"#000000\">Select \r\n                the object and operation:</font> </p>\r\n              <blockquote>\r\n                <p><font face=\"Arial, Helvetica, sans-serif\">Object:</font> \r\n                  <select name=\"object\" STYLE=\"width: 175px\" onChange=\"MM_callJS('loadOps()')\">\r\n                    <option value=\"all\">All</option>\r\n                    ");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(245,22);to=(250,7)]
                
                					if (ncObjects != null && ncObjects.length > 0)
                					{
                						for(int i = 0; i < ncObjects.length; i++)
                						{
                							
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(250,9);to=(250,24)]
                out.write("<option value=\"");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(250,27);to=(250,47)]
                out.print(ncObjects[i].getId());
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(250,49);to=(250,51)]
                out.write("\">");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(250,54);to=(250,76)]
                out.print(ncObjects[i].getName());
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(250,78);to=(250,87)]
                out.write("</option>");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(250,89);to=(253,5)]
                 
                						}
                					}
                					
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(253,7);to=(268,48)]
                out.write("\r\n\t\t\t\t\t\r\n                  </select>\r\n                </p>\r\n                <p><font face=\"Arial, Helvetica, sans-serif\">Operation:</font> \r\n                  <select name=\"operation\">\r\n                    <option value=\"all\">All</option>\r\n                    <option value=\"create\">Create</option>\r\n                    <option value=\"modify\">Modify</option>\r\n                    <option value=\"delete\">Delete</option>\r\n                  </select>\r\n                </p>\r\n                <p> \r\n                  <input type=\"submit\" name=\"Submit\" value=\"Done\">\r\n                  <input type=\"button\" name=\"Submit2\" value=\"Cancel\" onClick=\"MM_callJS('window.history.go(-1)')\">\r\n\t\t\t\t  <input type=\"hidden\" name=\"opcode\" value=\"");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(268,51);to=(268,81)]
                out.print(Operations.CREATE_NOTIFICATION);
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(268,83);to=(269,44)]
                out.write("\">\r\n\t\t\t\t  <input type=\"hidden\" name=\"nc\" value=\"");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(269,47);to=(269,49)]
                out.print(nc);
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(269,51);to=(270,46)]
                out.write("\">\r\n\t\t\t\t  <input type=\"hidden\" name=\"path\" value=\"");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(270,49);to=(270,77)]
                out.print(request.getParameter("path"));
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(270,79);to=(272,18)]
                out.write("\">\r\n\t\t\t\t  \r\n                  ");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(272,20);to=(275,4)]
                
                	if(request.getParameter("user") != null)
                	{
                	   
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(275,6);to=(276,57)]
                out.write("\r\n                  <input type=\"hidden\" name=\"user\" value=");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(276,60);to=(276,88)]
                out.print(request.getParameter("user"));
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(276,90);to=(278,18)]
                out.write(">\r\n                  <input type=\"hidden\" name=\"type\" value=\"user\">\r\n                  ");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(278,20);to=(282,4)]
                
                	}
                	else
                	{
                	   
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(282,6);to=(284,18)]
                out.write("\r\n                  <input type=\"hidden\" name=\"type\" value=\"object\">\r\n                  ");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(284,20);to=(286,1)]
                
                	}
                	
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(286,3);to=(291,10)]
                out.write("\r\n                </p>\r\n              </blockquote>\r\n            </blockquote>\r\n          </form>\r\n          ");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(291,12);to=(295,3)]
                
                }
                else if(typeStr != null && typeStr.equals("user"))
                {
                   
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(295,5);to=(301,18)]
                out.write("\r\n          <form name=\"form1\" method=\"get\" action=\"projectNotificationsNotificationWizard2.jsp\">\r\n            <blockquote>\r\n              <p><font face=\"Arial, Helvetica, sans-serif\">User:</font> \r\n                <select name=\"user\" STYLE=\"width: 175px\">\r\n                  <!-- TODO: write out all members that are part of the proj -->\r\n                  ");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(301,20);to=(307,9)]
                
                				  Account projectAccounts[] = psc.getAccountManager().getAllAccountsForProject(currentProject.getId());
                				  for(int i = 0; i < projectAccounts.length; i++)
                				  {
                				  	 if(projectAccounts[i].getId() != account.getId())
                					 {	
                					    
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(307,11);to=(307,26)]
                out.write("<option value=\"");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(307,29);to=(307,55)]
                out.print(projectAccounts[i].getId());
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(307,57);to=(307,59)]
                out.write("\">");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(307,62);to=(307,90)]
                out.print(projectAccounts[i].getName());
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(307,92);to=(307,101)]
                out.write("</option>");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(307,103);to=(310,6)]
                
                					 }
                				  }	
                				  
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(310,8);to=(318,42)]
                out.write("\r\n\t\t\t\t  \r\n                </select>\r\n              </p>\r\n              <p> \r\n                <input type=\"submit\" name=\"Submit\" value=\"Next\">\r\n                <input type=\"button\" name=\"Button\" value=\"Cancel\">\r\n                <input type=\"hidden\" name=\"type\" value=\"object\">\r\n\t\t\t\t<input type=\"hidden\" name=\"nc\" value=\"");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(318,45);to=(318,47)]
                out.print(nc);
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(318,49);to=(319,44)]
                out.write("\">\r\n\t\t\t\t<input type=\"hidden\" name=\"path\" value=\"");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(319,47);to=(319,75)]
                out.print(request.getParameter("path"));
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(319,77);to=(323,10)]
                out.write("\">\r\n              </p>\r\n            </blockquote>\r\n          </form>\r\n          ");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(323,12);to=(325,0)]
                
                }
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(325,2);to=(332,12)]
                out.write("\r\n        </div>\r\n      </div>\r\n      <div class=\"Right\"> \r\n        <div class=\"Sidebar\"> \r\n          <h1>Operations</h1>\r\n          <ul id=\"MTabs\">\r\n            ");

            // end
            // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(332,12);to=(332,54)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectNotificationsNotificationWizard2.jsp";from=(332,54);to=(351,0)]
                out.write("\r\n          </ul>\r\n          <br/>\r\n          <br/>\r\n\t\t  <P>&nbsp;</P>\r\n        </div>\r\n      </div>\r\n\r\n    </div>\r\n  </div>\r\n  <div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
