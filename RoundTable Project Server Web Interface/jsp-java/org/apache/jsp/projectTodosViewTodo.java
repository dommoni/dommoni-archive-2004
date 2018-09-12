package org.apache.jsp;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.CustomField;
import com.dommoni.roundtable.CustomFieldValueWrapperInt;
import com.dommoni.roundtable.CustomFieldValueWrapperString;
import com.dommoni.roundtable.NamedFieldCollection;
import com.dommoni.roundtable.NotificationObjectRegistry;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Task;
import com.dommoni.roundtable.projectServer.services.taskManager.ITaskManager;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import com.dommoni.ece.webui.utils.DateFormatter;
import com.dommoni.ece.webui.utils.StringUtils;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectTodosViewTodo extends HttpJspBase {


    static {
    }
    public projectTodosViewTodo( ) {
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

            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(0,46);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(1,37);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(3,50);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(5,54);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(6,69);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(7,72);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(8,63);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(9,69);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(10,66);to=(11,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(11,47);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(12,90);to=(14,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(14,52);to=(15,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(15,60);to=(16,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(16,61);to=(17,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(17,59);to=(19,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(19,2);to=(32,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Account account = (Account)session.getAttribute("useraccount");
                	ITaskManager todoManager = psc.getTaskManager();
                	int todoId = Integer.parseInt(request.getParameter("todoid"));
                	
                	// Get NOID for ToDo's
                	String notificationObject = (String)NotificationObjectRegistry.getInstance().get(Task.class);
                	
                	Task todo = todoManager.getTask(todoId);
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(32,2);to=(41,9)]
                out.write("\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(41,12);to=(41,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(41,32);to=(168,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script src=\"./includes/addCommentDlgPopup.js\"></script>\r\n<script src=\"./includes/deleteDlgPopup.js\"></script>\r\n</head>\r\n\r\n<script>\r\nfunction newTodoFolder()\r\n{\r\n   var newWin = open('projectTodosNewToDoFolder.jsp','','height=200,width=300,directories=no,location=no,menubar=no,resizable=no,scrollbars=no,status=no,toolbar=no,screenX=200,screenY=200,top=0,left=0');\r\n}\r\n</script>\r\n\r\n<body>\r\n\r\n\t<div id=\"StatusBarContainer\">\r\n\t\t<div id=\"Statusbar\">\r\n\t\t \r\n    \t\t<div id=\"StatusRight\"> \r\n\t\t\t\t<img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    \t\t</div>\r\n\t\t\t\r\n\t\t</div>\r\n\t</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(168,3);to=(168,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(168,36);to=(171,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(171,9);to=(171,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(171,41);to=(179,11)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t<h1>Task: ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(179,14);to=(179,29)]
                out.print(todo.getTitle());
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(179,31);to=(186,7)]
                out.write("</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n        <!--ToDo's--> \r\n  \t    ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(186,9);to=(190,5)]
                
                	    if(todo != null)
                		{ 
                		SimpleDateFormat dfDueDate = new SimpleDateFormat("MM/dd/yyyy");
                		   
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(190,7);to=(191,27)]
                out.write("\r\n\t\t   <P><b>Created By:</b> ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(191,30);to=(191,95)]
                out.print(psc.getAccountManager().getAccount(todo.getCreatedBy()).getName());
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(191,97);to=(192,27)]
                out.write("</P>\r\n\t\t   <P><b>Created On:</b> ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(192,30);to=(192,81)]
                out.print(DateFormatter.format(todo.getCreatedOn().getTime()));
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(192,83);to=(193,23)]
                out.write("</P>\r\n\t\t   <P><b>Status:</b> ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(193,25);to=(193,61)]
                if(todo.getCurrentStatus() != null){
            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(193,66);to=(193,100)]
                out.print(todo.getCurrentStatus().getTitle());
            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(193,104);to=(193,110)]
                }else{
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(193,112);to=(193,119)]
                out.write("UNKNOWN");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(193,121);to=(193,122)]
                }
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(193,124);to=(194,25)]
                out.write("</P>\r\n\t\t   <P><b>Due Date:</b> ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(194,27);to=(197,8)]
                
                		   if(todo.getDueDate() != null)
                		   {
                		      
            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(197,13);to=(197,58)]
                out.print(dfDueDate.format(todo.getDueDate().getTime()));
            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(197,62);to=(201,8)]
                
                		   } 
                		   else 
                		   {
                		      
            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(201,13);to=(201,23)]
                out.print("not set.");
            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(201,27);to=(202,6)]
                
                		   }
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(202,8);to=(204,5)]
                out.write("\r\n\t\t   </p>\r\n\t\t   ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(204,7);to=(205,7)]
                if(todo.getDescription() != null && todo.getDescription().length() > 0) {
                		     
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(205,9);to=(205,35)]
                out.write("<p><b>Description:</b><br>");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(205,38);to=(205,59)]
                out.print(todo.getDescription());
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(205,61);to=(205,65)]
                out.write("</p>");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(205,67);to=(206,5)]
                
                		  }
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(206,7);to=(208,4)]
                out.write("\r\n\t\t  \r\n\t\t  ");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(208,27);to=(210,4)]
                out.write("\r\n\t\t  \r\n\t\t  ");

            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(210,37);to=(211,4)]
                out.write("\r\n\t\t  ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(211,6);to=(220,5)]
                 
                		  NamedFieldCollection[] fieldCollections = todo.getNamedFieldCollections();
                		  if(fieldCollections != null && fieldCollections.length > 0)
                		  {
                		     for (int i = 0; i < fieldCollections.length; i++)
                			 {
                			    CustomField[] fields = fieldCollections[i].getFields();
                				if (fields != null && fields.length > 0)
                				{
                					
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(220,7);to=(223,25)]
                out.write("\r\n\t\t\t\t\t<br /> \r\n\t\t\t\t\t<!--<p>-->\r\n\t\t\t\t\t<h2 class=\"date\"><b>");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(223,28);to=(223,57)]
                out.print(fieldCollections[i].getName());
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(223,59);to=(223,68)]
                out.write("</b></h2>");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(223,70);to=(228,7)]
                
                					for (int i2 = 0; i2 < fields.length; i2++)
                					{
                						if (!fields[i2].getHidden())
                						{
                							
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(228,9);to=(228,15)]
                out.write("<p><b>");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(228,18);to=(228,38)]
                out.print(fields[i2].getName());
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(228,40);to=(228,46)]
                out.write(": </b>");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(228,48);to=(231,8)]
                
                							if (fields[i2].getType() == CustomField.T_INTEGER)
                							{
                								
            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(231,13);to=(231,82)]
                out.print(((CustomFieldValueWrapperInt)fields[i2].getValueWrapper()).getValue());
            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(231,86);to=(235,8)]
                
                							}
                							else if (fields[i2].getType() == CustomField.T_STRING)
                							{
                								
            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(235,13);to=(235,85)]
                out.print(((CustomFieldValueWrapperString)fields[i2].getValueWrapper()).getValue());
            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(235,89);to=(239,8)]
                
                							}
                							else
                							{
                								
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(239,10);to=(239,35)]
                out.write("Error: Unknown Data Type.");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(239,37);to=(241,7)]
                
                							}
                							
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(241,9);to=(241,13)]
                out.write("</p>");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(241,15);to=(247,4)]
                
                						}
                					}
                				}
                			 }
                		  }
                		  
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(247,6);to=(249,7)]
                out.write("\r\n\t\t  \r\n\t      ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(249,9);to=(256,7)]
                
                		  SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMMM d yyyy, hh:mm aaa");
                		  Comment[] comments = psc.getTaskManager().getCommentsForTask(todo);
                		  
                		  if(comments != null && comments.length > 0)
                		  {
                		     
                		     
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(256,9);to=(256,55)]
                out.write("<br><h2 class=\"date\">Comments</h2><blockquote>");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(256,57);to=(261,7)]
                
                			 
                		     for(int i = 0; i < comments.length; i++)
                			 {
                			    String cb = ((Account)psc.getAccountManager().getAccount(comments[i].getCreatedBy())).getName();
                			    
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(261,9);to=(261,12)]
                out.write("<p>");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(261,15);to=(261,39)]
                out.print(comments[i].getComment());
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(261,41);to=(262,49)]
                out.write("<br>\r\n              <I><font color=\"#cccccc\">Posted by ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(262,52);to=(262,54)]
                out.print(cb);
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(262,56);to=(262,57)]
                out.write(" ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(262,60);to=(262,108)]
                out.print(sdf.format(comments[i].getCreatedOn().getTime()));
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(262,110);to=(263,14)]
                out.write(".</font></I> \r\n              ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(263,16);to=(263,67)]
                if(comments[i].getCreatedBy() == account.getId()) {
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(263,69);to=(264,66)]
                out.write("\r\n              <br><a href=\"#\" onClick=\"showDelete('your comment','");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(264,69);to=(264,94)]
                out.print(Operations.DELETE_COMMENT);
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(264,96);to=(264,99)]
                out.write("','");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(264,102);to=(264,121)]
                out.print(comments[i].getId());
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(264,123);to=(264,168)]
                out.write("','Comment','projectTodosViewTodo.jsp?todoid=");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(264,171);to=(264,183)]
                out.print(todo.getId());
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(264,185);to=(265,14)]
                out.write("');\"><font size=\"2\">Delete My Comment</font></a> \r\n              ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(265,16);to=(265,17)]
                }
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(265,19);to=(267,12)]
                out.write("\r\n            </p>\r\n            ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(267,14);to=(269,4)]
                
                			 }
                			 
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(269,6);to=(269,19)]
                out.write("</blockquote>");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(269,21);to=(270,5)]
                
                		  }
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(270,7);to=(272,5)]
                out.write("\r\n\t\t   \r\n\t\t   ");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(272,7);to=(276,3)]
                
                		}
                		else
                		{
                			
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(276,5);to=(276,61)]
                out.write("<p>There was a problem retrieving the selected Task.</P>");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(276,63);to=(278,1)]
                
                		}
                	
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(278,3);to=(289,5)]
                out.write("\r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(289,5);to=(289,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(289,47);to=(290,2)]
                out.write("\t\r\n\t\t");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(290,4);to=(290,50)]
                 if(todo.getCreatedBy() == account.getId()) { 
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(290,52);to=(291,51)]
                out.write("\r\n\t\t<li><a href=\"./projectTodosModifyTodo.jsp?todoid=");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(291,54);to=(291,66)]
                out.print(todo.getId());
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(291,68);to=(292,39)]
                out.write("\">Modify Task</a></li>\r\n\t\t<li><a href=\"#\" onClick=\"showDelete('");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(292,42);to=(292,82)]
                out.print(StringUtils.getJSString(todo.getTitle()));
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(292,84);to=(292,87)]
                out.write("','");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(292,90);to=(292,112)]
                out.print(Operations.DELETE_TODO);
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(292,114);to=(292,117)]
                out.write("','");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(292,120);to=(292,132)]
                out.print(todo.getId());
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(292,134);to=(293,2)]
                out.write("','Task','projectTodos.jsp');\">Delete Task</a></li>\r\n\t\t");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(293,4);to=(293,5)]
                }
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(293,7);to=(294,38)]
                out.write("\r\n\t<li><a href=\"#\" onClick=\"addComment('");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(294,41);to=(294,80)]
                out.print(StringUtils.getJSString(todo.getName()));
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(294,82);to=(294,85)]
                out.write("','");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(294,88);to=(294,100)]
                out.print(todo.getId());
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(294,102);to=(294,114)]
                out.write("','task','./");

            // end
            // begin [file="/projectTodosViewTodo.jsp";from=(294,117);to=(294,141)]
                out.print(request.getServletPath());
            // end
            // HTML // begin [file="/projectTodosViewTodo.jsp";from=(294,143);to=(317,0)]
                out.write("');\">Add a Comment</a></li>\r\n\t</ul>\r\n     <br/>\r\n    <br/>\r\n\t<p>&nbsp;</p>\r\n</div>\r\n\r\n\r\n</div>\r\n\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
