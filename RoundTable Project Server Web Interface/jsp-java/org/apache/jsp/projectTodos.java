package org.apache.jsp;

import java.util.HashMap;
import java.util.Vector;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.NotificationContext;
import com.dommoni.roundtable.NotificationObjectRegistry;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.Task;
import com.dommoni.roundtable.projectServer.services.taskManager.ITaskManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import com.dommoni.ece.webui.MenuItem;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectTodos extends HttpJspBase {


    static {
    }
    public projectTodos( ) {
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

            // HTML // begin [file="/projectTodos.jsp";from=(0,37);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodos.jsp";from=(1,36);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectTodos.jsp";from=(3,66);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodos.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodos.jsp";from=(5,54);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodos.jsp";from=(6,62);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodos.jsp";from=(7,69);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodos.jsp";from=(8,50);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodos.jsp";from=(9,47);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodos.jsp";from=(10,90);to=(11,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodos.jsp";from=(11,96);to=(13,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectTodos.jsp";from=(13,50);to=(14,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodos.jsp";from=(14,60);to=(16,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectTodos.jsp";from=(16,2);to=(29,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	ITaskManager todoManager = psc.getTaskManager();
                	Task todos[] = todoManager.getAllTasksForProject(currentProject.getId());
                	
                	// Get NOID for ToDo's
                	String notificationObject = (String)NotificationObjectRegistry.getInstance().get(Task.class);
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectTodos.jsp";from=(29,2);to=(39,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectTodos.jsp";from=(39,12);to=(39,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectTodos.jsp";from=(39,32);to=(163,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n</head>\r\n\r\n<script>\r\nfunction newTodoFolder()\r\n{\r\n   var newWin = open('projectTodosNewToDoFolder.jsp','','height=200,width=300,directories=no,location=no,menubar=no,resizable=no,scrollbars=no,status=no,toolbar=no,screenX=200,screenY=200,top=0,left=0');\r\n}\r\n</script>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectTodos.jsp";from=(163,3);to=(163,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectTodos.jsp";from=(163,36);to=(166,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectTodos.jsp";from=(166,9);to=(166,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectTodos.jsp";from=(166,41);to=(181,3)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t<h1>Tasks</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n  <!--ToDo's--> \r\n  \t");

            // end
            // begin [file="/projectTodos.jsp";from=(181,5);to=(184,5)]
                
                	    if(todos != null && todos.length > 0)
                		{ 
                		   
            // end
            // HTML // begin [file="/projectTodos.jsp";from=(184,7);to=(184,57)]
                out.write("<table border=\"0\" cellspacing=\"3\" cellpadding=\"6\">");

            // end
            // begin [file="/projectTodos.jsp";from=(184,59);to=(187,8)]
                
                		   for(int i = 0; i < todos.length; i++)
                		   {
                		      
            // end
            // HTML // begin [file="/projectTodos.jsp";from=(187,10);to=(188,63)]
                out.write("<tr>\r\n\t\t\t\t  <td width=\"225\"><a href=\"projectTodosViewTodo.jsp?todoid=");

            // end
            // begin [file="/projectTodos.jsp";from=(188,66);to=(188,82)]
                out.print(todos[i].getId());
            // end
            // HTML // begin [file="/projectTodos.jsp";from=(188,84);to=(188,137)]
                out.write("\"><font face=\"Verdana, Arial, Helvetica, sans-serif\">");

            // end
            // begin [file="/projectTodos.jsp";from=(188,140);to=(188,159)]
                out.print(todos[i].getTitle());
            // end
            // HTML // begin [file="/projectTodos.jsp";from=(188,161);to=(189,13)]
                out.write("</font></a></td>\r\n\t\t      </tr>");

            // end
            // begin [file="/projectTodos.jsp";from=(189,15);to=(191,5)]
                
                		   }
                		   
            // end
            // HTML // begin [file="/projectTodos.jsp";from=(191,7);to=(191,15)]
                out.write("</table>");

            // end
            // begin [file="/projectTodos.jsp";from=(191,17);to=(195,3)]
                
                		}
                		else
                		{
                			
            // end
            // HTML // begin [file="/projectTodos.jsp";from=(195,5);to=(195,54)]
                out.write("<p>No tasks currently exist for this project.</P>");

            // end
            // begin [file="/projectTodos.jsp";from=(195,56);to=(197,1)]
                
                		}
                	
            // end
            // HTML // begin [file="/projectTodos.jsp";from=(197,3);to=(208,5)]
                out.write("\r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectTodos.jsp";from=(208,5);to=(208,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectTodos.jsp";from=(208,47);to=(210,61)]
                out.write("\t\r\n\t\t<li><a href=\"projectTodosNewToDo.jsp\">New Task</a></li>\r\n\t\t<li><a href=\"projectNotificationsNotificationWizard.jsp?nc=");

            // end
            // begin [file="/projectTodos.jsp";from=(210,64);to=(210,96)]
                out.print(NotificationContext.TASK_CONTEXT);
            // end
            // HTML // begin [file="/projectTodos.jsp";from=(210,98);to=(210,104)]
                out.write("&path=");

            // end
            // begin [file="/projectTodos.jsp";from=(210,107);to=(210,131)]
                out.print(request.getServletPath());
            // end
            // HTML // begin [file="/projectTodos.jsp";from=(210,133);to=(237,0)]
                out.write("\">New Notification</a></li>  \r\n\t</ul>\r\n     <br/>\r\n    <br/>    \r\n\t<p>&nbsp;</p>\r\n</div>\r\n\r\n\r\n</div>\r\n\r\n\r\n<!--\r\n\t<div id=\"showhelp\"><a href=\"../project/show_help?project_id=4661&return_to=%2Fclients%2Ftestproject7%2F1%2Fall%2F\">Show \"Things to do\"</a></div>\r\n-->\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
