package org.apache.jsp;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Forum;
import com.dommoni.roundtable.ForumReply;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.forumManager.IForumManager;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import com.dommoni.ece.webui.utils.StringUtils;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectForumsViewForum extends HttpJspBase {


    static {
    }
    public projectForumsViewForum( ) {
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

            // HTML // begin [file="/projectForumsViewForum.jsp";from=(0,46);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(1,37);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(3,50);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(4,48);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(5,53);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(6,50);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(7,66);to=(9,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(9,96);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(10,92);to=(12,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(12,52);to=(13,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(13,60);to=(14,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(14,59);to=(16,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(16,2);to=(37,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	IAccountManager accountManager = psc.getAccountManager();
                	
                	IForumManager forumManager = psc.getForumManager();
                	Forum forum = null;
                	
                	try
                	{   
                	   forum = forumManager.getForum(Integer.parseInt(request.getParameter("forumid")));
                	}
                	catch(Exception e)
                	{
                	   e.printStackTrace();
                	}
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(37,2);to=(47,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(47,12);to=(47,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(47,32);to=(165,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script src=\"./includes/deleteDlgPopup.js\"></script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(165,3);to=(165,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(165,36);to=(168,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(168,9);to=(168,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(168,41);to=(175,1)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(175,3);to=(175,22)]
                if(forum != null){ 
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(175,24);to=(176,15)]
                out.write("\t\r\n\t   <h1>Forum: ");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(176,18);to=(176,36)]
                out.print(forum.getSubject());
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(176,38);to=(177,1)]
                out.write("</h1>\r\n\t");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(177,3);to=(177,11)]
                } else {
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(177,13);to=(179,1)]
                out.write("\r\n\t<h1>Forum: Unknown</h1>\r\n\t");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(179,3);to=(179,6)]
                 } 
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(179,8);to=(184,5)]
                out.write("\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n\t    ");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(184,7);to=(187,5)]
                
                		if(forum != null) 
                		{	
                		   
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(187,7);to=(187,10)]
                out.write("<p>");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(187,13);to=(187,31)]
                out.print(forum.getMessage());
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(187,33);to=(187,37)]
                out.write("</p>");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(187,39);to=(196,8)]
                
                		   // this is a cache for the replies to speed things up.
                		   HashMap accountReplyCache = new HashMap();
                		   
                		   ForumReply forumReplies[] = forumManager.getAllRepliesForForum(forum.getId());
                		   if(forumReplies != null && forumReplies.length > 0)
                		   {
                		      for(int i = 0; i < forumReplies.length; i++)
                			  {
                			     
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(196,10);to=(199,5)]
                out.write("\r\n\t\t\t\t <blockquote>\r\n\t\t\t\t <h2 class=\"date\"></h2>\r\n\t\t\t\t ");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(199,8);to=(199,34)]
                out.print(forumReplies[i].getReply());
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(199,36);to=(201,17)]
                out.write("\r\n\t\t\t\t <br><br>\r\n                 ");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(201,19);to=(212,8)]
                 
                			     SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMMM d yyyy, hh:mm aaa");
                			
                			     // populate the cache.
                			     Integer repAccountId = new Integer(forumReplies[i].getAccountId());
                			     Account repAccount = (Account)accountReplyCache.get(repAccountId);
                			     if(repAccount == null)
                			     {  
                			        repAccount = accountManager.getAccount(repAccountId.intValue());
                			        accountReplyCache.put(repAccountId, repAccount);
                			     }
                			     
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(212,10);to=(212,45)]
                out.write("<I><font color=\"#cccccc\">Posted by ");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(212,48);to=(212,68)]
                out.print(repAccount.getName());
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(212,70);to=(213,17)]
                out.write(" \r\n                 ");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(213,20);to=(213,72)]
                out.print(sdf.format(forumReplies[i].getTimestamp().getTime()));
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(213,74);to=(213,99)]
                out.write("</font></I> </blockquote>");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(213,101);to=(216,5)]
                
                			  }
                		   }
                		   
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(216,7);to=(218,52)]
                out.write("\r\n\t\t   <br>\r\n\t\t   <p><a href=\"projectForumsPostReply.jsp?forumid=");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(218,55);to=(218,68)]
                out.print(forum.getId());
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(218,70);to=(218,92)]
                out.write("\">post a reply</a></p>");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(218,94);to=(222,4)]
                
                		}
                		else
                		{
                		  
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(222,6);to=(222,47)]
                out.write("An error occured processing your request.");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(222,49);to=(224,2)]
                
                		}
                		
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(224,4);to=(235,5)]
                out.write("\r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(235,5);to=(235,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(235,47);to=(236,2)]
                out.write("\r\n\t\t");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(236,4);to=(236,51)]
                 if(forum.getCreatedBy() == account.getId()) { 
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(236,53);to=(237,54)]
                out.write("\r\n\t\t<li><a href=\"./projectForumsModifyForum.jsp?forumid=");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(237,57);to=(237,70)]
                out.print(forum.getId());
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(237,72);to=(238,39)]
                out.write("\">Modify Forum</a></li>\r\n\t\t<li><a href=\"#\" onClick=\"showDelete('");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(238,42);to=(238,85)]
                out.print(StringUtils.getJSString(forum.getSubject()));
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(238,87);to=(238,90)]
                out.write("','");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(238,93);to=(238,116)]
                out.print(Operations.DELETE_FORUM);
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(238,118);to=(238,121)]
                out.write("','");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(238,124);to=(238,137)]
                out.print(forum.getId());
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(238,139);to=(239,2)]
                out.write("','Forum','projectForums.jsp');\">Delete Forum</a></li>\t  \r\n\t\t");

            // end
            // begin [file="/projectForumsViewForum.jsp";from=(239,4);to=(239,5)]
                }
            // end
            // HTML // begin [file="/projectForumsViewForum.jsp";from=(239,7);to=(264,0)]
                out.write("\r\n\t</ul>\r\n     <br/>\r\n    <br/>    \r\n\t<P>&nbsp;</P>\r\n</div>\r\n\r\n\r\n</div>\r\n\r\n\r\n\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
