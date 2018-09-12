package org.apache.jsp;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import com.dommoni.roundtable.NotificationObjectRegistry;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.Task;
import com.dommoni.roundtable.TaskStatus;
import com.dommoni.roundtable.projectServer.services.taskManager.ITaskManager;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import com.dommoni.ece.webui.utils.DateFormatter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectTodosModifyTodo extends HttpJspBase {


    static {
    }
    public projectTodosModifyTodo( ) {
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

            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(0,46);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(1,37);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(3,69);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(4,66);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(5,50);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(6,50);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(7,47);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(8,53);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(9,90);to=(11,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(11,52);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(12,60);to=(13,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(13,61);to=(15,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(15,2);to=(30,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	ITaskManager todoManager = psc.getTaskManager();
                	int todoId = Integer.parseInt(request.getParameter("todoid"));
                	
                	// Get NOID for ToDo's
                	String notificationObject = (String)NotificationObjectRegistry.getInstance().get(Task.class);
                	
                	Task todo = todoManager.getTask(todoId);
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(30,2);to=(39,9)]
                out.write("\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(39,12);to=(39,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(39,32);to=(177,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n\r\n\r\nfunction setDate(newDate,field) \r\n{\r\n   document.form1.duedate.value = newDate;   \r\n}\r\n\r\nfunction openStartWindow() { \r\n   myWindow = open('calendar_popup.jsp?field=startTime','newWin','width=370,height=360,left=200,top=300,status=yes');\r\n   //myWindow.location.href = 'calendar_popup.jsp';\r\n   if (myWindow.opener == null) myWindow.opener = self;\r\n}\r\n//-->\r\n\r\n//-->\r\n</script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(177,3);to=(177,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(177,36);to=(180,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(180,9);to=(180,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(180,41);to=(188,18)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t<h1>Modify Task: ");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(188,21);to=(188,36)]
                out.print(todo.getTitle());
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(188,38);to=(195,7)]
                out.write("</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n        <!--ToDo's--> \r\n  \t    ");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(195,9);to=(198,5)]
                
                	    if(todo != null)
                		{ 
                		   
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(198,7);to=(201,68)]
                out.write("\r\n\t\t   \r\n          <form name=\"form1\" action=\"./servlet/ControllerServlet\" method=\"post\">\r\n            <P><b>Title:</b> <input type=\"text\" name=\"title\" value=\"");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(201,71);to=(201,86)]
                out.print(todo.getTitle());
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(201,88);to=(203,5)]
                out.write("\"></P>\r\n\t\t   <p><b>Status:</b> \r\n\t\t   ");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(203,7);to=(207,5)]
                
                		      TaskStatus status[] = psc.getTaskManager().getAllTaskStatusForProject(currentProject.getId());
                			  if(status != null && status.length > 0)
                			  {
                			  
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(207,7);to=(209,8)]
                out.write("\r\n\t\t\t  <select name=\"status\">\r\n\t\t\t     ");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(209,10);to=(214,11)]
                 for(int i = 0; i < status.length; i++)
                				 {
                				    if(todo.getCurrentStatus() != null && 
                					   todo.getCurrentStatus().getId() == status[i].getId())
                					{
                				       
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(214,13);to=(214,28)]
                out.write("<option value=\"");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(214,31);to=(214,48)]
                out.print(status[i].getId());
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(214,50);to=(214,61)]
                out.write("\" selected>");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(214,64);to=(214,84)]
                out.print(status[i].getTitle());
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(214,86);to=(214,95)]
                out.write("</option>");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(214,97);to=(218,8)]
                
                				    }
                					else
                					{
                					   
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(218,10);to=(218,25)]
                out.write("<option value=\"");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(218,28);to=(218,45)]
                out.print(status[i].getId());
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(218,47);to=(218,49)]
                out.write("\">");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(218,52);to=(218,72)]
                out.print(status[i].getTitle());
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(218,74);to=(218,83)]
                out.write("</option>");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(218,85);to=(221,5)]
                
                					}
                				 }
                				 
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(221,7);to=(221,16)]
                out.write("</select>");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(221,18);to=(223,4)]
                
                			  }
                			 
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(223,6);to=(226,5)]
                out.write("\r\n\t\t\t  \r\n\t\t   </p>\r\n\t\t   ");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(226,7);to=(230,8)]
                
                		   if(todo.getDueDate() != null) 
                		   {
                		      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                		      
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(230,10);to=(230,71)]
                out.write("<p><b>Due Date:</b> <input type=\"text\" name=\"duedate\" value=\"");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(230,74);to=(230,113)]
                out.print(sdf.format(todo.getDueDate().getTime()));
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(230,115);to=(230,278)]
                out.write("\"> <a href=\"javascript:;\" onClick=\"MM_callJS('openStartWindow()')\"><img src=\"images/icon_calendar.gif\" width=\"22\" height=\"21\" align=\"absmiddle\" border=\"0\"></a></p>");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(230,280);to=(234,8)]
                
                		   }
                		   else
                		   {
                		      
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(234,10);to=(234,234)]
                out.write("<p><b>Due Date:</b> <input type=\"text\" name=\"duedate\" value=\"\"> <a href=\"javascript:;\" onClick=\"MM_callJS('openStartWindow()')\"><img src=\"images/icon_calendar.gif\" width=\"22\" height=\"21\" align=\"absmiddle\" border=\"0\"></a></p>");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(234,236);to=(236,5)]
                
                		   }
                		   
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(236,7);to=(238,77)]
                out.write("\r\n\t\t   <p><b>Make Private:</b> <input type=\"checkbox\" name=\"isprivate\" value=\"yes\"></p>\r\n\t\t   <p><b>Description:</b> <textarea name=\"description\" rows=\"10\" cols=\"50\">");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(238,80);to=(238,101)]
                out.print(todo.getDescription());
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(238,103);to=(240,48)]
                out.write("</textarea></p>\r\n\t\t   \r\n\t\t    <input type=\"hidden\" name=\"todoid\" value=\"");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(240,51);to=(240,63)]
                out.print(todo.getId());
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(240,65);to=(243,48)]
                out.write("\">\r\n\t\t    <input type=\"submit\" name=\"Submit\" value=\"Save\">\r\n\t\t    <input type=\"button\" name=\"Button\" value=\"Cancel\" onClick=\"MM_callJS('window.history.go(-1)')\">\r\n\t\t    <input type=\"hidden\" name=\"opcode\" value=\"");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(243,51);to=(243,71)]
                out.print(Operations.EDIT_TODO);
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(243,73);to=(245,5)]
                out.write("\">\r\n\t\t   </form>\r\n\t\t   ");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(245,7);to=(249,3)]
                
                		}
                		else
                		{
                			
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(249,5);to=(249,61)]
                out.write("<p>There was a problem retrieving the selected Task.</P>");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(249,63);to=(251,1)]
                
                		}
                	
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(251,3);to=(262,5)]
                out.write("\r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectTodosModifyTodo.jsp";from=(262,5);to=(262,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectTodosModifyTodo.jsp";from=(262,47);to=(289,0)]
                out.write("\t\r\n\t</ul>\r\n     <br/>\r\n    <br/>\r\n\t<P>&nbsp;</P>    \r\n</div>\r\n\r\n\r\n</div>\r\n\r\n\r\n<!--\r\n\t<div id=\"showhelp\"><a href=\"../project/show_help?project_id=4661&return_to=%2Fclients%2Ftestproject7%2F1%2Fall%2F\">Show \"Things to do\"</a></div>\r\n-->\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
