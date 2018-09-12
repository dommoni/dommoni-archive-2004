package org.apache.jsp;

import java.util.HashMap;
import java.util.Vector;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import com.dommoni.ece.webui.MenuItem;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectMeetingsNewMeeting extends HttpJspBase {


    static {
    }
    public projectMeetingsNewMeeting( ) {
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

            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(0,37);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(1,36);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(3,66);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(5,54);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(6,50);to=(8,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(8,96);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(9,96);to=(11,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(11,50);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(12,52);to=(13,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(13,60);to=(15,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectMeetingsNewMeeting.jsp";from=(15,2);to=(25,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	IAccountManager accountManager = psc.getAccountManager();
                	Account accounts[] = accountManager.getAllAccountsForProject(currentProject.getId());
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(25,2);to=(35,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectMeetingsNewMeeting.jsp";from=(35,12);to=(35,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(35,32);to=(274,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<!--<script language=\"JavaScript\" src=\"includes/membersList.js\">\r\n-->\r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n\r\nfunction setDate(newDate,field) \r\n{\r\n   if(field == \"startTime\")\r\n   {  \r\n      document.form1.starttime.value = newDate;   \r\n   }\r\n   if(field == \"endTime\")\r\n   {   \r\n      document.form1.endtime.value = newDate;\r\n   }\t\r\n}\r\n\r\nfunction openStartWindow() { \r\n\tmyWindow = open('calendar_popup.jsp?field=startTime','newWin','width=370,height=360,left=200,top=300,status=yes');\r\n\t//myWindow.location.href = 'calendar_popup.jsp';\r\n\tif (myWindow.opener == null) myWindow.opener = self;\r\n}\r\n\r\nfunction openEndWindow() { \r\n\tmyWindow = open('calendar_popup.jsp?field=endTime','newWin','width=370,height=360,left=200,top=300,status=yes');\r\n\t//myWindow.location.href = 'calendar_popup.jsp';\r\n\tif (myWindow.opener == null) myWindow.opener = self;\r\n}\r\n\r\nallKeys = new Array();\r\nfunction move(fbox, tbox, rightBoxName) \r\n{\r\n\tvar arrFbox = new Array();\r\n\tvar arrTbox = new Array();\r\n\tvar arrLookup = new Array();\r\n\tvar returnArray = new Array();\r\n\t\r\n\tvar i;\r\n\tfor (i = 0; i < tbox.options.length; i++) \r\n\t{\r\n\t\tarrLookup[tbox.options[i].text] = tbox.options[i].value;<!-- id or name of the given option in the select box -->\r\n\t\tarrTbox[i] = tbox.options[i].text;<!-- text of field (what is being shown) -->\r\n\t}\r\n\t\r\n\tvar fLength = 0;\r\n\tvar tLength = arrTbox.length;\r\n\tfor(i = 0; i < fbox.options.length; i++) \r\n\t{\r\n\t\tarrLookup[fbox.options[i].text] = fbox.options[i].value;\r\n\t\tif (fbox.options[i].selected && fbox.options[i].value != \"\") \r\n\t\t{\r\n\t\t\tarrTbox[tLength] = fbox.options[i].text;\r\n\t\t\ttLength++;\r\n\t\t}\r\n\t\telse \r\n\t\t{\r\n\t\t\tarrFbox[fLength] = fbox.options[i].text;\r\n\t\t\tfLength++;\r\n   \t        }\t\r\n\t}\r\n\t\r\n\tarrFbox.sort();\r\n\tarrTbox.sort();\r\n\tfbox.length = 0;  <!-- reset the fbox and the tbox -->\r\n\ttbox.length = 0;  <!-- reset the fbox and the tbox -->\r\n\tvar c;\r\n\tvar no;\r\n\tfor(c = 0; c < arrFbox.length; c++) \r\n\t{\r\n\t\tno = new Option(); <!-- create a new option to insert into fBox -->\r\n\t\tno.value = arrLookup[arrFbox[c]]; <!-- this returns the id -->\r\n\t\tno.text = arrFbox[c];\t\t\t\t<!-- this sets the value -->\r\n\t\tfbox[c] = no;\r\n\t}\r\n\tfor(c = 0; c < arrTbox.length; c++) \r\n\t{\r\n\t\tno = new Option();\r\n\t\tno.value = arrLookup[arrTbox[c]];\r\n\t\tno.text = arrTbox[c];\r\n\t\ttbox[c] = no;\r\n  \t}\r\n\t\r\n\t//update the return array\r\n\treturnArray.length = 0;  <!-- reset the array -->\r\n\tvar rightBox;\r\n\t\r\n\tif(rightBoxName == \"tbox\") \r\n\t{\r\n\t\trightBox=tbox;\r\n\t}\r\n\telse \r\n\t{\r\n\t\trightBox = fbox;\r\n\t}\r\n\t\r\n\tfor (i = 0; i < rightBox.length; i++) \r\n\t{\r\n\t\tvar position = arrLookup[rightBox.options[i].text];\r\n\t\treturnArray[returnArray.length] = allKeys[position];\r\n\t}\r\n}\r\n\r\nfunction moveAll(fbox, tbox) \r\n{\r\n\tfor (x = 0; x < fbox.options.length; x++)\r\n\t{\r\n\t\tvar newOption = new Option();\r\n\t\tnewOption.value = fbox.options[x].value;\r\n\t\tnewOption.text = fbox.options[x].text;\r\n\t\ttbox.add(newOption);\r\n\t}\r\n\tfbox.length = 0;\r\n\ttbox.options = tbox.options.sort();\r\n}\r\n//-->\r\n</script>\r\n\r\n\r\n\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectMeetingsNewMeeting.jsp";from=(274,3);to=(274,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(274,36);to=(277,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectMeetingsNewMeeting.jsp";from=(277,9);to=(277,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(277,41);to=(322,32)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t      <h1>New Meeting</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n          <form name=\"form1\" method=\"post\" action=\"./servlet/ControllerServlet\">\r\n            <p><b>Title:</b> \r\n              <input type=\"text\" name=\"title\">\r\n            </p>\r\n            <p>  \r\n\t      <b>Start-Time:</b> \r\n              <input type=\"text\" name=\"starttime\">\r\n              <a href=\"javascript:;\" onClick=\"MM_callJS('openStartWindow()')\"><img src=\"images/icon_calendar.gif\" width=\"22\" height=\"21\" align=\"absbottom\" border=\"0\"></a>\r\n\t    </p>\r\n\t    <p>  \r\n\t      <b>End-Time:</b> \r\n              <input type=\"text\" name=\"endtime\">\r\n              <a href=\"javascript:;\" onClick=\"MM_callJS('openEndWindow()')\"><img src=\"images/icon_calendar.gif\" width=\"22\" height=\"21\" align=\"absbottom\" border=\"0\"></a>\r\n\t    </p>\r\n            <p>\r\n\t      <b>Attendees:</b>\r\n            <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"left\">\r\n              <!-- this starts the ugly looking table thing -->\r\n              <tr> \r\n                <td colspan=\"2\" height=\"153\"> \r\n                  <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                    <tr> \r\n                      <td align=\"center\" width=\"200\"> \r\n                        <table width=\"135\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                          <tr bgcolor=\"#000099\"> \r\n                            <td height=\"10\" width=\"135\" align=\"center\"> <b><font color=\"#000000\" size=\"2\" face=\"Verdana, Arial, Helvetica, sans-serif\">Available \r\n                              Members</font></b></td>\r\n                          </tr>\r\n                          <tr> \r\n                            <td width=\"135\" align=\"center\"> \r\n                              <select multiple size=\"7\" name=\"list1\" align=\"center\" style=\"width:125px\">\r\n                                ");

            // end
            // begin [file="/projectMeetingsNewMeeting.jsp";from=(322,34);to=(329,17)]
                
                					   if(accounts != null)
                					   {
                					      for(int i = 0; i < accounts.length; i++)
                					      {
                                                                 if(accounts[i].getId() != account.getId()) // dont want organizer to invite themselves.
                				                 {
                					            
            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(329,19);to=(329,34)]
                out.write("<option value=\"");

            // end
            // begin [file="/projectMeetingsNewMeeting.jsp";from=(329,37);to=(329,56)]
                out.print(accounts[i].getId());
            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(329,58);to=(329,60)]
                out.write("\">");

            // end
            // begin [file="/projectMeetingsNewMeeting.jsp";from=(329,63);to=(329,84)]
                out.print(accounts[i].getName());
            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(329,86);to=(329,95)]
                out.write("</option>");

            // end
            // begin [file="/projectMeetingsNewMeeting.jsp";from=(329,97);to=(333,5)]
                
                						 }
                					      }
                					   }
                					
            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(333,7);to=(413,56)]
                out.write("\r\n                              </select>\r\n                            </td>\r\n                          </tr>\r\n                        </table>\r\n                      </td>\r\n                      <td width=\"30\" align=\"center\"> \r\n                        <table width=\"30\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                          <tr> \r\n                            <td> \r\n                              <input type=\"button\" onClick='move(list1, list2, \"tbox\")' value=\" > \" name=\"button\">\r\n                            </td>\r\n                          </tr>\r\n                          <tr> \r\n                            <td> \r\n                              <input type=\"button\" onClick='moveAll(list1, list2)' value=\">>\" name=\"button\">\r\n                            </td>\r\n                          </tr>\r\n                          <tr> \r\n                            <td> \r\n                              <input type=\"button\" onClick='move(list2, list1, \"fbox\")' value=\" < \" name=\"button\">\r\n                            </td>\r\n                          </tr>\r\n                          <tr> \r\n                            <td> \r\n                              <input type=\"button\" onClick='moveAll(list2, list1)' value=\"<<\" name=\"button\">\r\n                            </td>\r\n                          </tr>\r\n                        </table>\r\n                      </td>\r\n                      <td width=\"175\" align=\"center\"> \r\n                        <table width=\"135\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n                          <tr bgcolor=\"#000099\"> \r\n                            <td height=\"10\" width=\"135\" align=\"center\"><font size=\"2\"><b><font color=\"#000000\" face=\"Verdana, Arial, Helvetica, sans-serif\">Selected \r\n                              Members</font></b></font></td>\r\n                          </tr>\r\n                          <tr> \r\n                            <td width=\"135\" align=\"center\"> \r\n                              <select multiple size=\"7\" name=\"list2\" align=\"center\" style=\"width:125px\">\r\n                              </select>\r\n                            </td>\r\n                          </tr>\r\n                        </table>\r\n                      </td>\r\n                    </tr>\r\n                  </table>\r\n                </td>\r\n              </tr>\r\n            </table>\r\n            <p>&nbsp;</p>\r\n            <p>&nbsp;</p>\r\n            <p>&nbsp;</p>\r\n            <p>&nbsp;</p>\r\n            <p>&nbsp;</p>\r\n            <p>&nbsp;</p>\r\n            <p>&nbsp;</p>\r\n            <p>&nbsp;</p>\r\n            <!-- <p> \r\n              <input type=\"checkbox\" name=\"sendinvitation\" value=\"yes\">\r\n              <b>Send an invitation to Attendees?</b></p>\r\n            <p><b>Meeting Agenda:</b><br>\r\n              <input type=\"text\" name=\"agendaItem1\" value=\"\">\r\n              <br>\r\n              <input type=\"text\" name=\"agendaItem2\">\r\n              <br>\r\n              <input type=\"text\" name=\"agendaItem3\">\r\n              <br>\r\n              <input type=\"text\" name=\"agendaItem4\">\r\n              <br>\r\n            \r\n\t     <a href=\"javascript:;\">More Agenda Items</a></p>\r\n            -->\r\n\t    <p><b>Description:</b><br>\r\n              <textarea name=\"description\" rows=\"8\" cols=\"40\"></textarea>\r\n            </p>\r\n            <p>&nbsp;</p>\r\n            <p>&nbsp;</p>\r\n            <p> \r\n              <input type=\"submit\" name=\"Submit\" value=\"Create Meeting\">\r\n              <input type=\"button\" name=\"Submit2\" value=\"Cancel\" onClick=\"MM_callJS('window.history.go(-1)')\">\r\n              <input type=\"hidden\" name=\"opcode\" value=\"");

            // end
            // begin [file="/projectMeetingsNewMeeting.jsp";from=(413,59);to=(413,84)]
                out.print(Operations.CREATE_MEETING);
            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(413,86);to=(426,5)]
                out.write("\">\r\n            </p>\r\n        </form>\r\n        </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectMeetingsNewMeeting.jsp";from=(426,5);to=(426,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectMeetingsNewMeeting.jsp";from=(426,47);to=(456,0)]
                out.write("\t  \r\n\t</ul>\r\n          <p>&nbsp;</p>\r\n          <p>&nbsp;</p>\r\n          <p>&nbsp;</p>\r\n          <p>&nbsp;</p>\r\n          <p>&nbsp;</p>\r\n          <p>&nbsp;</p>\r\n          <p>&nbsp;</p>\r\n          <br/>\r\n            <br/>\r\n       \r\n        </div>\r\n\r\n\r\n</div>\r\n\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
