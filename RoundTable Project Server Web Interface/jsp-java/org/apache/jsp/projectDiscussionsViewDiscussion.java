package org.apache.jsp;

import java.util.HashMap;
import java.util.Vector;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Discussion;
import com.dommoni.roundtable.DiscussionMessage;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import com.dommoni.ece.webui.MenuItem;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectDiscussionsViewDiscussion extends HttpJspBase {


    static {
    }
    public projectDiscussionsViewDiscussion( ) {
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

            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(0,37);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(1,36);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(3,66);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(5,54);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(6,53);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(7,60);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(8,50);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(9,96);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(10,96);to=(12,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(12,50);to=(13,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(13,60);to=(15,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(15,2);to=(35,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	String sDiscussionId = request.getParameter("discussionid");
                	int discussionId = Integer.parseInt(sDiscussionId);
                	Discussion discussion = psc.getDiscussionManager().getDiscussion(discussionId);
                	
                	// Build a members map so we dont have to make multiple requests.
                	HashMap membersMap = new HashMap();
                	int memberIds[] = discussion.getMemberIds();
                	for(int i = 0; i < memberIds.length; i++)
                	{
                		membersMap.put(new Integer(memberIds[i]), psc.getAccountManager().getAccount(memberIds[i]));
                	}
                	DiscussionMessage messages[] = discussion.getMessages();
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(35,2);to=(45,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(45,12);to=(45,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(45,32);to=(162,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(162,3);to=(162,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(162,36);to=(165,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(165,9);to=(165,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(165,41);to=(180,10)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t<h1>Discussions</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\"> \r\n          <!--projects-->\r\n          ");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(180,12);to=(184,4)]
                
                		 if(discussion != null)
                		 {
                		    
                		 	
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(184,6);to=(185,68)]
                out.write("\r\n          Title: <font face=\"Arial, Helvetica, sans-serif\" size=\"2\">");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(185,71);to=(185,92)]
                out.print(discussion.getTitle());
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(185,94);to=(186,60)]
                out.write("</font><br>\r\n\t\t\tDate: <font face=\"Arial, Helvetica, sans-serif\" size=\"2\">");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(186,63);to=(186,93)]
                out.print(discussion.getDate().getTime());
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(186,95);to=(187,53)]
                out.write("</font><BR>\r\n\t\t\t<table border=\"0\" cellspacing=\"3\" cellpadding=\"6\">");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(187,55);to=(190,4)]
                
                		 	for(int i = 0; i < messages.length; i++)
                			{
                				
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(190,6);to=(192,8)]
                out.write("\r\n\t\t\t\t  <tr>\r\n\t\t\t\t    ");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(192,10);to=(209,6)]
                
                					int det = i % 2;
                					System.out.println("det: " + det);
                					Account messengerAccount = (Account)membersMap.get(new Integer(messages[i].getAccountId()));
                					String messengerName = null;
                					if(messengerAccount != null)
                					{   
                						messengerName = messengerAccount.getName();
                					}
                					else
                					{   
                						messengerName = "Unknown";
                					}
                					
                					if(0 == det) 
                					{
                					    System.out.println("making bg grey!!!");
                						
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(209,8);to=(209,95)]
                out.write("<td width=\"300\" bgcolor=\"#CCCCCC><font face=\"Verdana, Arial, Helvetica, sans-serif\"><B>");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(209,98);to=(209,111)]
                out.print(messengerName);
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(209,113);to=(209,119)]
                out.write(": </B>");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(209,122);to=(209,150)]
                out.print(messages[i].getMessageText());
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(209,152);to=(209,164)]
                out.write("</font></td>");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(209,166);to=(214,6)]
                
                					}
                					else
                					{
                					    System.out.println("making bg white!!!");
                						
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(214,8);to=(214,78)]
                out.write("<td width=\"300\"><font face=\"Verdana, Arial, Helvetica, sans-serif\"><B>");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(214,81);to=(214,94)]
                out.print(messengerName);
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(214,96);to=(214,102)]
                out.write(": </B>");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(214,105);to=(214,133)]
                out.print(messages[i].getMessageText());
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(214,135);to=(214,147)]
                out.write("</font></td>");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(214,149);to=(216,5)]
                
                					}
                					
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(216,7);to=(218,7)]
                out.write("\r\n\t\t\t\t  </tr>\r\n\t\t\t    ");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(218,9);to=(220,3)]
                
                			}
                			
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(220,5);to=(220,13)]
                out.write("</table>");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(220,15);to=(224,4)]
                
                		 }
                		 else
                		 {
                		 	
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(224,6);to=(224,74)]
                out.write("<p>Error! The system was unable to read the selected discussion.</P>");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(224,76);to=(226,3)]
                
                		 }
                		 
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(226,5);to=(238,5)]
                out.write("\r\n\t\t \r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(238,5);to=(238,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectDiscussionsViewDiscussion.jsp";from=(238,47);to=(264,0)]
                out.write("\t  \r\n\t</ul>\r\n     <br/>\r\n    <br/>    \r\n</div>\r\n\r\n\r\n</div>\r\n\r\n\r\n\r\n\t<div id=\"showhelp\"><a href=\"../project/show_help?project_id=4661&return_to=%2Fclients%2Ftestproject7%2F1%2Fall%2F\">Show \"Things to do\"</a></div>\r\n\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
