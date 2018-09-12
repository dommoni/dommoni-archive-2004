package org.apache.jsp;

import java.util.HashMap;
import java.util.Vector;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountContact;
import com.dommoni.roundtable.AccountProfile;
import com.dommoni.roundtable.AccountSettings;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import com.dommoni.ece.webui.MenuItem;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectMembersViewMember extends HttpJspBase {


    static {
    }
    public projectMembersViewMember( ) {
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

            // HTML // begin [file="/projectMembersViewMember.jsp";from=(0,37);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(1,36);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(3,66);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(5,57);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(6,57);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(7,58);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(8,54);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(9,50);to=(11,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(11,96);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(12,96);to=(14,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(14,50);to=(15,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(15,60);to=(17,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(17,2);to=(31,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	int accountId = Integer.parseInt(request.getParameter("accountid"));
                	
                	Account projectMember = psc.getAccountManager().getAccount(accountId);
                	AccountProfile accountProfile = psc.getAccountManager().getAccountProfile(accountId);
                	AccountContact accountContact = psc.getAccountManager().getAccountContact(accountId);
                	AccountSettings accountSettings = psc.getAccountManager().getAccountSettings(accountId);
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(31,2);to=(41,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(41,12);to=(41,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(41,32);to=(158,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(158,3);to=(158,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(158,36);to=(161,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(161,9);to=(161,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(161,41);to=(169,13)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t<h1>Member: ");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(169,16);to=(169,39)]
                out.print(projectMember.getName());
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(169,41);to=(176,3)]
                out.write("</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n\t  <!--projects member -->\r\n\t  ");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(176,5);to=(179,3)]
                
                	if(accountProfile != null)
                	  {
                	  
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(179,5);to=(183,21)]
                out.write("\r\n\t  <h2>Profile</h2>\r\n\t  <table width=\"376\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n  <tr> \r\n    <td valign=\"top\">");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(183,23);to=(189,2)]
                 
                	
                	byte image[] = accountProfile.getImage();
                	if(image != null && image.length > 0)
                	{
                		// make a gif image...
                		
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(189,4);to=(189,46)]
                out.write("<img src=\"./getProfileImage.jsp?accountid=");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(189,49);to=(189,70)]
                out.print(projectMember.getId());
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(189,72);to=(189,88)]
                out.write("\" align=\"right\">");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(189,90);to=(193,2)]
                
                	}
                	else
                	{
                		
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(193,4);to=(193,90)]
                out.write("<img src=\"./images/no-pro-pic_lghtgrey-line.gif\" width=\"64\" height=\"75\" align=\"right\">");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(193,92);to=(198,2)]
                
                	}
                	
                	 if(accountProfile.getProfileText() != null && accountProfile.getProfileText().length() > 0)
                	 {
                		
            // end
            // begin [file="/projectMembersViewMember.jsp";from=(198,7);to=(198,38)]
                out.print(accountProfile.getProfileText());
            // end
            // begin [file="/projectMembersViewMember.jsp";from=(198,42);to=(202,2)]
                
                	 }
                	 else
                	 {
                		
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(202,4);to=(202,51)]
                out.write("<p>This member has not yet added a profile.</p>");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(202,53);to=(204,1)]
                
                	 }
                	
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(204,3);to=(209,2)]
                out.write("\r\n\t</td>\r\n  </tr>\r\n</table>\r\n\r\n  ");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(209,4);to=(211,5)]
                 if(accountContact != null)
                  {
                     
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(211,7);to=(213,2)]
                out.write("\r\n\t <h2>Contact Information</h2>\r\n\t ");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(213,4);to=(213,114)]
                if(accountSettings.getPrimaryEmailAddress() != null && accountSettings.getPrimaryEmailAddress().length() > 0){
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(213,116);to=(214,99)]
                out.write("\r\n\t   <img src=\"images/spacer.gif\" height=\"1\" width=\"10\"><font size=\"2\">Email:</font> <font size=\"2\">");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(214,102);to=(214,142)]
                out.print(accountSettings.getPrimaryEmailAddress());
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(214,144);to=(215,2)]
                out.write("</font><br>\r\n\t ");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(215,4);to=(215,5)]
                }
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(215,7);to=(216,2)]
                out.write("\r\n\t ");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(216,4);to=(216,96)]
                if(accountContact.getPhoneNumber() != null && accountContact.getPhoneNumber().length() > 0){
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(216,98);to=(217,106)]
                out.write(" \r\n\t   <img src=\"images/spacer.gif\" height=\"1\" width=\"10\"><font size=\"2\">Phone Number:</font> <font size=\"2\">");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(217,109);to=(217,140)]
                out.print(accountContact.getPhoneNumber());
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(217,142);to=(218,2)]
                out.write("</font><br>\r\n\t ");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(218,4);to=(218,5)]
                }
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(218,7);to=(220,2)]
                out.write("\r\n\t \r\n\t ");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(220,4);to=(224,3)]
                if(accountContact.getOfficeAddress() != null && accountContact.getOfficeAddress().length() > 0 &&
                	      accountContact.getCity() != null && accountContact.getCity().length() > 0 &&
                		  accountContact.getState() != null && accountContact.getState().length() > 0 &&
                		  accountContact.getZip() != null && accountContact.getZip().length() > 0)
                	 {
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(224,5);to=(225,101)]
                out.write(" \r\n\t   <img src=\"images/spacer.gif\" height=\"1\" width=\"10\"><font size=\"2\">Address:</font> <font size=\"2\">");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(225,104);to=(225,137)]
                out.print(accountContact.getOfficeAddress());
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(225,139);to=(226,98)]
                out.write("</font><br>\r\n\t   <img src=\"images/spacer.gif\" height=\"1\" width=\"10\"><font size=\"2\">City:</font> <font size=\"2\">");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(226,101);to=(226,125)]
                out.print(accountContact.getCity());
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(226,127);to=(227,99)]
                out.write("</font><br>\r\n\t   <img src=\"images/spacer.gif\" height=\"1\" width=\"10\"><font size=\"2\">State:</font> <font size=\"2\">");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(227,102);to=(227,127)]
                out.print(accountContact.getState());
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(227,129);to=(228,97)]
                out.write("</font><br>\r\n\t   <img src=\"images/spacer.gif\" height=\"1\" width=\"10\"><font size=\"2\">Zip:</font> <font size=\"2\">");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(228,100);to=(228,123)]
                out.print(accountContact.getZip());
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(228,125);to=(229,2)]
                out.write("</font><br>\r\n\t ");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(229,4);to=(229,5)]
                }
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(229,7);to=(230,2)]
                out.write("\r\n\t ");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(230,4);to=(232,2)]
                
                  }
                  
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(232,4);to=(234,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(234,2);to=(238,6)]
                
                }
                else
                	  {
                	     
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(238,8);to=(238,88)]
                out.write("<p><font color=\"#FF0000\">Error! No profile was found for this member.</font></p>");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(238,90);to=(239,4)]
                
                	  }
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(239,6);to=(252,5)]
                out.write("\r\n\t  \r\n\t  \r\n    </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectMembersViewMember.jsp";from=(252,5);to=(252,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMembersViewMember.jsp";from=(252,47);to=(275,0)]
                out.write("\t  \r\n\t</ul>\r\n     <br/>\r\n    <br/>    \r\n    <P>&nbsp;</P>\r\n</div>\r\n\r\n\r\n</div>\r\n\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
