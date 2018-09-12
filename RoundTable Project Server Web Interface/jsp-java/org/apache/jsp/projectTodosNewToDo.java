package org.apache.jsp;

import java.util.HashMap;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Flags;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.TaskStatus;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectTodosNewToDo extends HttpJspBase {


    static {
    }
    public projectTodosNewToDo( ) {
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

            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(3,70);to=(5,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(5,37);to=(7,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(7,50);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(8,48);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(9,50);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(10,53);to=(11,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(11,66);to=(13,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(13,52);to=(14,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(14,60);to=(16,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(16,2);to=(23,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(23,2);to=(33,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(33,12);to=(33,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(33,32);to=(175,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n\r\nfunction setDate(newDate,field) \r\n{\r\n   //if(field == \"startTime\")\r\n   //{  \r\n      document.form1.duedate.value = newDate;   \r\n   //}\r\n   //if(field == \"endTime\")\r\n   //{   \r\n      //document.form1.endtime.value = newDate;\r\n   //}\t\r\n}\r\n\r\nfunction openStartWindow() { \r\n\tmyWindow = open('calendar_popup.jsp?field=startTime','newWin','width=370,height=360,left=200,top=300,status=yes');\r\n\t//myWindow.location.href = 'calendar_popup.jsp';\r\n\tif (myWindow.opener == null) myWindow.opener = self;\r\n}\r\n//-->\r\n</script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(175,3);to=(175,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(175,36);to=(178,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(178,9);to=(178,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(178,41);to=(198,18)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t<h1>New Task</h1>\r\n\t\t\r\n\r\n        \r\n        <div class=\"Post\">\r\n  <!--New ToDo: --> \r\n\t\t  <form name=\"form1\" method=\"post\" action=\"./servlet/ControllerServlet\">\r\n              <p>Title: \r\n                <input type=\"text\" name=\"title\">\r\n              </p>\r\n              <p>Flag: \r\n                <select name=\"flag\">\r\n                  ");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(198,20);to=(201,10)]
                
                				   for(int i = 0; i < Flags.flags.length; i++)
                				   {
                				      
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(201,12);to=(202,33)]
                out.write("\r\n                  <option value=\"");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(202,36);to=(202,53)]
                out.print(Flags.flags[i].id);
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(202,55);to=(202,57)]
                out.write("\">");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(202,60);to=(202,79)]
                out.print(Flags.flags[i].name);
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(202,81);to=(203,18)]
                out.write("</option>\r\n                  ");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(203,20);to=(205,7)]
                
                				   }
                				   
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(205,9);to=(210,5)]
                out.write("\r\n                </select>\r\n                \r\n              </p>\r\n              <p>Status: \r\n\t\t\t  ");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(210,7);to=(214,5)]
                
                			  TaskStatus status[] = psc.getTaskManager().getAllTaskStatusForProject(currentProject.getId());
                			  if(status != null && status.length > 0)
                			  {
                			  
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(214,7);to=(216,8)]
                out.write("\r\n\t\t\t  <select name=\"status\">\r\n\t\t\t     ");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(216,10);to=(218,8)]
                 for(int i = 0; i < status.length; i++)
                				 {
                				    
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(218,10);to=(218,25)]
                out.write("<option value=\"");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(218,28);to=(218,45)]
                out.print(status[i].getId());
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(218,47);to=(218,49)]
                out.write("\">");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(218,52);to=(218,72)]
                out.print(status[i].getTitle());
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(218,74);to=(218,83)]
                out.write("</option>");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(218,85);to=(220,5)]
                
                				 }
                				 
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(220,7);to=(222,5)]
                out.write("\r\n\t\t\t  </select>\r\n\t\t\t  ");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(222,7);to=(222,15)]
                } else {
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(222,17);to=(222,39)]
                out.write("Currently Unavailable.");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(222,41);to=(222,42)]
                }
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(222,44);to=(225,5)]
                out.write("\r\n\t\t\t  </p>\r\n\t\t\t  <p>\r\n\t\t\t  ");

            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(225,49);to=(238,56)]
                out.write("\r\n\t\t\t  </p>\r\n              <p>Due Date: \r\n                <input type=\"text\" name=\"duedate\">\r\n                <a href=\"javascript:;\" onClick=\"MM_callJS('openStartWindow()')\"><img src=\"images/icon_calendar.gif\" width=\"22\" height=\"21\" align=\"absmiddle\" border=\"0\"></a></p>\r\n              <p>Make Private: <input type=\"checkbox\" name=\"isprivate\" value=\"yes\"></p>\r\n\t      \r\n\t      <p>Description:<br>\r\n                <textarea name=\"description\" rows=\"10\" cols=\"50\"></textarea>\r\n              </p>\r\n              <p> \r\n              <input type=\"submit\" name=\"Submit\" value=\"Create\">\r\n              <input type=\"button\" name=\"Submit2\" value=\"Cancel\" onClick=\"MM_callJS('window.history.go(-1)')\">\r\n              <input type=\"hidden\" name=\"opcode\" value=\"");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(238,59);to=(238,81)]
                out.print(Operations.CREATE_TODO);
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(238,83);to=(252,5)]
                out.write("\">\r\n            </p>\r\n          </form>\r\n\t </div>\r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectTodosNewToDo.jsp";from=(252,5);to=(252,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectTodosNewToDo.jsp";from=(252,47);to=(278,0)]
                out.write("\t\r\n  \r\n\t</ul>\r\n          <p>&nbsp;</p>\r\n          <p>&nbsp;</p>\r\n          <p>&nbsp;</p>\r\n          <br/>\r\n            <br/>\r\n          \r\n        </div>\r\n\r\n\r\n</div>\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
