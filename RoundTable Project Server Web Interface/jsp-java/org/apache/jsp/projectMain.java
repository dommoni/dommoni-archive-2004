package org.apache.jsp;

import java.util.HashMap;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Announcement;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.RecentChange;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.ece.webui.WebUIConfiguration;
import com.dommoni.ece.webui.utils.AnnouncementSorter;
import com.dommoni.ece.webui.utils.RecentChangeSorter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectMain extends HttpJspBase {


    static {
    }
    public projectMain( ) {
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

            // HTML // begin [file="/projectMain.jsp";from=(0,37);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectMain.jsp";from=(2,66);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMain.jsp";from=(3,50);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMain.jsp";from=(4,54);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMain.jsp";from=(5,55);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMain.jsp";from=(6,50);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMain.jsp";from=(7,55);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMain.jsp";from=(8,96);to=(10,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectMain.jsp";from=(10,60);to=(11,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMain.jsp";from=(11,66);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMain.jsp";from=(12,66);to=(14,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectMain.jsp";from=(14,2);to=(23,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	Announcement[] announcements = psc.getAnnouncementManager().getAllAnnouncementsForProject(currentProject.getId());
                	RecentChange[] recentChanges = psc.getRecentChangesManager().getRecentChangesForProject(currentProject.getId());
                	
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectMain.jsp";from=(23,2);to=(33,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectMain.jsp";from=(33,12);to=(33,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectMain.jsp";from=(33,32);to=(140,0)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script src=\"./includes/viewAnnouncementDlgPopup.js\"></script>\r\n<script src=\"./includes/addAnnouncementDlgPopup.js\"></script>\r\n</head>\r\n\r\n<body>\r\n<div id=\"StatusBarContainer\"> <div id=\"Statusbar\"> <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n</div></div></div><div class=\"Shadow\" id=\"Shadow\"> <div class=\"Container\"> <div id=\"Header\"> \r\n");

            // end
            // begin [file="/projectMain.jsp";from=(140,0);to=(140,33)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMain.jsp";from=(140,33);to=(140,34)]
                out.write(" ");

            // end
            // begin [file="/projectMain.jsp";from=(140,34);to=(140,66)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMain.jsp";from=(140,66);to=(142,12)]
                out.write(" </div><div id=\"ContentFrame\"> \r\n<div class=\"Left\"> <div class=\"SectionHeader\"> \r\n<h1>Welcome ");

            // end
            // begin [file="/projectMain.jsp";from=(142,15);to=(142,32)]
                out.print(account.getName());
            // end
            // HTML // begin [file="/projectMain.jsp";from=(142,34);to=(145,35)]
                out.write("</h1></div><!-- <blockquote> --> \r\n\r\n<div class=\"Post\">\r\n<h2 class=\"date\">Announcements</h2>");

            // end
            // begin [file="/projectMain.jsp";from=(145,37);to=(152,6)]
                
                	 try {
                		 
                		 if(announcements != null && announcements.length > 0)
                		 {
                		    AnnouncementSorter asorter = new AnnouncementSorter();
                		    Announcement anSorted[] = asorter.sort(announcements, 5);
                		    
            // end
            // HTML // begin [file="/projectMain.jsp";from=(152,8);to=(152,31)]
                out.write("<!--<blockquote>--><ul>");

            // end
            // begin [file="/projectMain.jsp";from=(152,33);to=(157,9)]
                
                			for(int i = 0; i < anSorted.length; i++)
                			{
                			   try
                			   {
                			      
            // end
            // HTML // begin [file="/projectMain.jsp";from=(157,11);to=(157,53)]
                out.write("<li><a href=\"#\" onClick=\"viewAnnouncement(");

            // end
            // begin [file="/projectMain.jsp";from=(157,56);to=(157,75)]
                out.print(anSorted[i].getId());
            // end
            // HTML // begin [file="/projectMain.jsp";from=(157,77);to=(157,132)]
                out.write(");\"><FONT FACE=\"Verdana, Arial, Helvetica, sans-serif\">");

            // end
            // begin [file="/projectMain.jsp";from=(157,135);to=(157,157)]
                out.print(anSorted[i].getTitle());
            // end
            // HTML // begin [file="/projectMain.jsp";from=(157,159);to=(157,175)]
                out.write("</FONT></a></li>");

            // end
            // begin [file="/projectMain.jsp";from=(157,177);to=(163,3)]
                
                			   } catch(Exception e)
                			   {
                			      e.printStackTrace();
                			   }
                			}
                			
            // end
            // HTML // begin [file="/projectMain.jsp";from=(163,5);to=(163,30)]
                out.write("</ul><!--</blockquote>-->");

            // end
            // begin [file="/projectMain.jsp";from=(163,32);to=(167,3)]
                
                		 }
                		 else
                		 {
                			
            // end
            // HTML // begin [file="/projectMain.jsp";from=(167,5);to=(167,62)]
                out.write("<p>No announcements currently exist for this project.</P>");

            // end
            // begin [file="/projectMain.jsp";from=(167,64);to=(172,5)]
                
                		 }
                	 }
                	 catch(Exception e)
                	 {
                	    
            // end
            // HTML // begin [file="/projectMain.jsp";from=(172,7);to=(172,104)]
                out.write("<p><font color=\"#FF0000\">An error occured while processing the recent-changes request.</font></p>");

            // end
            // begin [file="/projectMain.jsp";from=(172,106);to=(175,2)]
                
                	    e.printStackTrace();
                	 }
                	 
            // end
            // HTML // begin [file="/projectMain.jsp";from=(175,4);to=(176,38)]
                out.write("<p>&nbsp;</p> \r\n\t <h2 class=\"date\">Recent Changes</h2>");

            // end
            // begin [file="/projectMain.jsp";from=(176,40);to=(182,6)]
                
                	 try {
                		 RecentChangeSorter rcs = new RecentChangeSorter();
                		 RecentChange changes[] = rcs.sort(recentChanges, 5);
                		 if(changes != null && changes.length > 0)
                		 {
                		    
            // end
            // HTML // begin [file="/projectMain.jsp";from=(182,8);to=(182,20)]
                out.write("<blockquote>");

            // end
            // begin [file="/projectMain.jsp";from=(182,22);to=(187,9)]
                
                			for(int i = 0; i < changes.length; i++)
                			{
                			   try
                			   {
                			      
            // end
            // HTML // begin [file="/projectMain.jsp";from=(187,11);to=(187,14)]
                out.write("<p>");

            // end
            // begin [file="/projectMain.jsp";from=(187,17);to=(187,46)]
                out.print(changes[i].getChangeMessage());
            // end
            // HTML // begin [file="/projectMain.jsp";from=(187,48);to=(187,52)]
                out.write("</p>");

            // end
            // begin [file="/projectMain.jsp";from=(187,54);to=(193,3)]
                
                			   } catch(Exception e)
                			   {
                			      e.printStackTrace();
                			   }
                			}
                			
            // end
            // HTML // begin [file="/projectMain.jsp";from=(193,5);to=(193,18)]
                out.write("</blockquote>");

            // end
            // begin [file="/projectMain.jsp";from=(193,20);to=(197,3)]
                
                		 }
                		 else
                		 {
                			
            // end
            // HTML // begin [file="/projectMain.jsp";from=(197,5);to=(197,63)]
                out.write("<p>No recent-changes currently exist for this project.</P>");

            // end
            // begin [file="/projectMain.jsp";from=(197,65);to=(202,5)]
                
                		 }
                	 }
                	 catch(Exception e)
                	 {
                	    
            // end
            // HTML // begin [file="/projectMain.jsp";from=(202,7);to=(203,5)]
                out.write("<p><font color=\"#FF0000\">An error occured while processing the recent-changes request.</font></p>\r\n\t    ");

            // end
            // begin [file="/projectMain.jsp";from=(203,7);to=(206,2)]
                
                	    e.printStackTrace();
                	 }
                	 
            // end
            // HTML // begin [file="/projectMain.jsp";from=(206,4);to=(212,3)]
                out.write(" \r\n\t </div>\r\n</div>\r\n<div class=\"Right\"> <div class=\"Sidebar\"> \r\n<h1>Operations</h1>\r\n  <ul id=\"MTabs\"> \r\n   ");

            // end
            // begin [file="/projectMain.jsp";from=(212,3);to=(212,45)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMain.jsp";from=(212,45);to=(223,0)]
                out.write("\r\n   <li><a href=\"#\" onClick=\"newAnnouncement();\">New Announcement</a></li>\r\n   <li><a href=\"./projectNotificationsViewNotifications.jsp\">My Notifications</a></li>\r\n  </ul>\r\n  <br/> \r\n  <br/> <P>&nbsp;</P></div></div></div></div><div class=\"ShadowCap\">&nbsp;</div></div>\r\n  <div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
