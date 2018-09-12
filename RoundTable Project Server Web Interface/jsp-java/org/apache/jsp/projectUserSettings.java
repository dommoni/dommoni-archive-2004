package org.apache.jsp;

import java.util.HashMap;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountContact;
import com.dommoni.roundtable.AccountSettings;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.ece.webui.MenuController;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectUserSettings extends HttpJspBase {


    static {
    }
    public projectUserSettings( ) {
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

            // HTML // begin [file="/projectUserSettings.jsp";from=(0,37);to=(2,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(2,50);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(3,57);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(4,58);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(5,50);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(6,66);to=(8,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(8,56);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(9,52);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(10,60);to=(12,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectUserSettings.jsp";from=(12,2);to=(25,0)]
                
                    ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                   	MenuController mc = (MenuController)request.getSession().getAttribute("mc");
                   	mc.setCurrentPageIdToNull(session);
                   
                    AccountSettings accountSettings = psc.getAccountManager().getAccountSettings(account.getId());
                	AccountContact accountContact = psc.getAccountManager().getAccountContact(account.getId());
                   
                   	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(25,2);to=(34,9)]
                out.write("\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(34,12);to=(34,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(34,32);to=(159,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_goToURL() { //v3.0\r\n  var i, args=MM_goToURL.arguments; document.MM_returnValue = false;\r\n  for (i=0; i<(args.length-1); i+=2) eval(args[i]+\".location='\"+args[i+1]+\"'\");\r\n}\r\n//-->\r\n</script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectUserSettings.jsp";from=(159,3);to=(159,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(159,36);to=(162,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectUserSettings.jsp";from=(162,9);to=(162,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(162,41);to=(175,10)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t<h1>Account Settings</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        <div class=\"Post\"> \r\n          ");

            // end
            // begin [file="/projectUserSettings.jsp";from=(175,12);to=(177,5)]
                
                		  if(accountSettings != null)
                		  {
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(177,7);to=(185,6)]
                out.write("\r\n\t\t  <form name=\"form1\" method=\"post\" action=\"./servlet/ControllerServlet\">\r\n            <!-- Account Contacts -->\r\n\t\t\t\r\n            <b> <font size=\"2\">Account Contact Information:</font></b> <br>\r\n          <blockquote>\r\n\t\t    <table border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n\t\t\t<tr><td>Email Address: </td> \r\n\t\t    ");

            // end
            // begin [file="/projectUserSettings.jsp";from=(185,8);to=(189,6)]
                
                			// dont want to print the word "null" in the box.
                			if(accountSettings.getPrimaryEmailAddress() != null && accountSettings.getPrimaryEmailAddress().length() > 0) 
                			{
                			   
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(189,8);to=(189,58)]
                out.write("<td><input type=\"text\" name=\"primaryEmail\" value=\"");

            // end
            // begin [file="/projectUserSettings.jsp";from=(189,61);to=(189,101)]
                out.print(accountSettings.getPrimaryEmailAddress());
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(189,103);to=(189,110)]
                out.write("\"></td>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(189,112);to=(193,6)]
                 
                			} 
                			else 
                			{
                			   
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(193,8);to=(193,57)]
                out.write("<td><input type=\"text\" name=\"primaryEmail\" ></td>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(193,59);to=(195,3)]
                 
                			} 
                			
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(195,5);to=(198,3)]
                out.write("</tr>\r\n\t\t\t\r\n\t\t\t<tr><td>Phone Number: </td> \r\n\t\t\t");

            // end
            // begin [file="/projectUserSettings.jsp";from=(198,5);to=(200,6)]
                if(accountContact.getPhoneNumber() != null && accountContact.getPhoneNumber().length() > 0) 
                			{
                			   
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(200,8);to=(200,57)]
                out.write("<td><input type=\"text\" name=\"phonenumber\" value=\"");

            // end
            // begin [file="/projectUserSettings.jsp";from=(200,60);to=(200,91)]
                out.print(accountContact.getPhoneNumber());
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(200,93);to=(200,100)]
                out.write("\"></td>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(200,102);to=(202,6)]
                
                			} else {
                			   
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(202,8);to=(202,55)]
                out.write("<td><input type=\"text\" name=\"phonenumber\"></td>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(202,57);to=(203,4)]
                
                			}
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(203,6);to=(206,3)]
                out.write("</tr>\r\n\t\t\t\r\n   \t\t\t<tr><td>Address: </td>\r\n\t\t\t");

            // end
            // begin [file="/projectUserSettings.jsp";from=(206,5);to=(208,6)]
                if(accountContact.getOfficeAddress() != null && accountContact.getOfficeAddress().length() > 0)
                			{
                			   
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(208,8);to=(208,53)]
                out.write("<td><input type=\"text\" name=\"address\" value=\"");

            // end
            // begin [file="/projectUserSettings.jsp";from=(208,56);to=(208,89)]
                out.print(accountContact.getOfficeAddress());
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(208,91);to=(208,98)]
                out.write("\"></td>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(208,100);to=(210,6)]
                
                			} else {
                			   
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(210,8);to=(210,52)]
                out.write("<td><input type=\"text\" name=\"address\" ></td>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(210,54);to=(211,4)]
                
                			}
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(211,6);to=(214,3)]
                out.write("</tr>\r\n\t\t\t\r\n   \t\t\t<tr><td>City: </td>\r\n\t\t\t");

            // end
            // begin [file="/projectUserSettings.jsp";from=(214,5);to=(216,6)]
                if(accountContact.getCity() != null && accountContact.getCity().length() > 0)
                			{
                			   
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(216,8);to=(216,50)]
                out.write("<td><input type=\"text\" name=\"city\" value=\"");

            // end
            // begin [file="/projectUserSettings.jsp";from=(216,53);to=(216,77)]
                out.print(accountContact.getCity());
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(216,79);to=(216,86)]
                out.write("\"></td>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(216,88);to=(218,6)]
                
                   			} else {
                			   
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(218,8);to=(218,49)]
                out.write("<td><input type=\"text\" name=\"city\" ></td>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(218,51);to=(219,4)]
                
                			}
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(219,6);to=(222,3)]
                out.write("\r\n\t\t\t\r\n\t\t\t<tr><td>State: </td> \r\n\t\t\t");

            // end
            // begin [file="/projectUserSettings.jsp";from=(222,5);to=(224,6)]
                if(accountContact.getState() != null && accountContact.getState().length() > 0) 
                			{
                			   
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(224,8);to=(224,51)]
                out.write("<td><input type=\"text\" name=\"state\" value=\"");

            // end
            // begin [file="/projectUserSettings.jsp";from=(224,54);to=(224,79)]
                out.print(accountContact.getState());
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(224,81);to=(224,88)]
                out.write("\"></td>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(224,90);to=(226,6)]
                
                			} else {
                			   
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(226,8);to=(226,50)]
                out.write("<td><input type=\"text\" name=\"state\" ></td>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(226,52);to=(227,5)]
                
                			} 
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(227,7);to=(230,3)]
                out.write("</tr>\r\n\t\t\t\r\n\t\t\t<tr><td>Zip: </td> \r\n\t\t\t");

            // end
            // begin [file="/projectUserSettings.jsp";from=(230,5);to=(232,6)]
                if(accountContact.getZip() != null && accountContact.getZip().length() > 0) 
                			{
                			   
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(232,8);to=(232,49)]
                out.write("<td><input type=\"text\" name=\"zip\" value=\"");

            // end
            // begin [file="/projectUserSettings.jsp";from=(232,52);to=(232,75)]
                out.print(accountContact.getZip());
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(232,77);to=(232,84)]
                out.write("\"></td>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(232,86);to=(234,6)]
                
                			} else {
                			   
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(234,8);to=(234,48)]
                out.write("<td><input type=\"text\" name=\"zip\" ></td>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(234,50);to=(235,4)]
                
                			}
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(235,6);to=(245,20)]
                out.write("</tr>\r\n\t\t\t</table>\r\n           </blockquote>\r\n\t\t    \r\n\t\t\t<br>\r\n            <font size=\"2\"><b>Notification Settings:</b></font><br>\r\n\t\t    <blockquote> \r\n              <table width=\"326\" border=\"0\" cellspacing=\"5\" cellpadding=\"0\">\r\n                <tr>\r\n                  <td width=\"39\">\r\n                    ");

            // end
            // begin [file="/projectUserSettings.jsp";from=(245,22);to=(248,8)]
                
                					if(accountSettings.getNotificationsSystemMessage())
                					{
                					   
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(248,10);to=(248,75)]
                out.write("<input type=\"checkbox\" name=\"nSystemMessage\" value=\"yes\" checked>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(248,77);to=(252,8)]
                 
                					} 
                					else 
                					{ 
                					   
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(252,10);to=(252,67)]
                out.write("<input type=\"checkbox\" name=\"nSystemMessage\" value=\"yes\">");

            // end
            // begin [file="/projectUserSettings.jsp";from=(252,69);to=(254,5)]
                 
                					} 
                					
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(254,7);to=(260,6)]
                out.write("\r\n                  </td>\r\n                  <td width=\"272\">Receive Notifications as System-Messages</td>\r\n                </tr>\r\n                <tr>\r\n                  <td width=\"39\">\r\n\t\t\t\t  ");

            // end
            // begin [file="/projectUserSettings.jsp";from=(260,8);to=(262,21)]
                if(accountSettings.getNotificationsDesktopPager())
                				  {
                                     
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(262,23);to=(262,87)]
                out.write("<input type=\"checkbox\" name=\"nDesktopPager\" value=\"yes\" checked>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(262,89);to=(266,9)]
                
                				  }
                				  else
                				  {	
                				     
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(266,11);to=(266,67)]
                out.write("<input type=\"checkbox\" name=\"nDesktopPager\" value=\"yes\">");

            // end
            // begin [file="/projectUserSettings.jsp";from=(266,69);to=(267,8)]
                
                				  } 
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(267,10);to=(273,8)]
                out.write("\r\n                  </td>\r\n                  <td width=\"272\">Receive Notifications as ECE Desktop Pager Alerts</td>\r\n                </tr>\r\n                <tr>\r\n                  <td width=\"39\">\r\n\t\t\t\t    ");

            // end
            // begin [file="/projectUserSettings.jsp";from=(273,10);to=(276,8)]
                
                					if(accountSettings.getNotificationsEmail())
                					{
                					   
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(276,10);to=(276,67)]
                out.write("<input type=\"checkbox\" name=\"nEmail\" value=\"yes\" checked>");

            // end
            // begin [file="/projectUserSettings.jsp";from=(276,69);to=(280,23)]
                
                					}
                					else
                					{
                                       
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(280,25);to=(280,74)]
                out.write("<input type=\"checkbox\" name=\"nEmail\" value=\"yes\">");

            // end
            // begin [file="/projectUserSettings.jsp";from=(280,76);to=(282,5)]
                
                					}
                					
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(282,7);to=(293,54)]
                out.write("\r\n                  </td>\r\n                  <td width=\"272\">Receive Notifications as Email</td>\r\n                </tr>\r\n              </table>\r\n              <br>\r\n              <br>\r\n            </blockquote>\r\n\t\t\t\r\n\t\t    <input type=\"submit\" name=\"Save\" value=\"Save\">\r\n            <input type=\"button\" name=\"Button\" value=\"Cancel\" onClick=\"MM_goToURL('parent','projectUserSettings.jsp');return document.MM_returnValue\">\r\n            <input type=\"hidden\" name=\"opcode\" value=\"");

            // end
            // begin [file="/projectUserSettings.jsp";from=(293,57);to=(293,81)]
                out.print(Operations.SAVE_SETTINGS);
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(293,83);to=(295,4)]
                out.write("\">\r\n          </form>\r\n\t\t  ");

            // end
            // begin [file="/projectUserSettings.jsp";from=(295,6);to=(295,12)]
                }else{
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(295,14);to=(299,4)]
                out.write("\r\n\t\t     \r\n          <p><font color=\"#FF0000\">ERROR: Unable to retrieve account settings.</font> \r\n            (<a href=\".\">Report this error</a>)</p>\r\n\t\t  ");

            // end
            // begin [file="/projectUserSettings.jsp";from=(299,6);to=(299,7)]
                }
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(299,9);to=(309,5)]
                out.write("\r\n\t\t  </div>\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectUserSettings.jsp";from=(309,5);to=(309,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectUserSettings.jsp";from=(309,47);to=(333,0)]
                out.write("\r\n\t\t    <li><a href=\"accountEditProfile.jsp\">Edit Profile</a></li>\r\n\t\t<li><a href=\"accountChangePassword.jsp\">Change Password</a></li>\r\n\t</ul>\r\n    <br/>\r\n    <br/>  \r\n\t<p>&nbsp;</p>  \r\n</div>\r\n\r\n\r\n</div>\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
