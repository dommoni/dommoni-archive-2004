package org.apache.jsp;

import java.util.HashMap;
import java.util.Vector;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.AccountType;
import com.dommoni.roundtable.Document;
import com.dommoni.roundtable.DocumentType;
import com.dommoni.roundtable.NotificationContext;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.projectServer.services.documentManager.IDocumentManager;
import com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager;
import com.dommoni.ece.webui.MenuItem;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectDocuments extends HttpJspBase {


    static {
    }
    public projectDocuments( ) {
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

            // HTML // begin [file="/projectDocuments.jsp";from=(0,37);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(1,36);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(3,66);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(5,54);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(6,51);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(7,55);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(8,62);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(9,50);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(10,98);to=(11,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(11,96);to=(12,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(12,50);to=(13,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(13,52);to=(14,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(14,60);to=(16,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectDocuments.jsp";from=(16,2);to=(26,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	IDocumentManager documentManager = psc.getDocumentManager();
                	Document documents[] = documentManager.getAllDocumentsForProjectShallow(currentProject.getId());
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(26,2);to=(36,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectDocuments.jsp";from=(36,12);to=(36,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(36,32);to=(153,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectDocuments.jsp";from=(153,3);to=(153,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(153,36);to=(156,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectDocuments.jsp";from=(156,9);to=(156,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(156,41);to=(171,5)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t\r\n\t\t\r\n\t<h1>Documents</h1>\r\n\t\t\r\n\t </div>\r\n\r\n        \r\n        <div class=\"Post\">\r\n  <!-- Documents --> \r\n\t    ");

            // end
            // begin [file="/projectDocuments.jsp";from=(171,7);to=(245,15)]
                
                		    StringBuffer output = new StringBuffer();
                			try
                			{
                		       if(documents != null && documents.length > 0)
                			   {
                			      output.append("<table border=\"0\" cellspacing=\"3\" cellpadding=\"6\">");
                				  for(int i = 0; i < documents.length; i++)
                				  {
                                     output.append("<tr><td width=\"225\">");
                						  
                                     if(documents[i].getDocumentType() == DocumentType.PDF)
                					 {
                                        output.append("<img src=\"images/ico_pdf_18x18.gif\" align=\"absmiddle\">");
                                     }
                                     else if(documents[i].getDocumentType() == DocumentType.UNKNOWN)
                					 {
                                        output.append("<img src=\"images/plainfile_icon.gif\" align=\"absmiddle\">");
                                     }
                					 else if(documents[i].getDocumentType() == DocumentType.MSOFFICE_ACCESS) 
                					 {
                					    output.append("<img src=\"images/ico_access_18x18.gif\" align=\"absmiddle\">");
                					 }
                                     else if(documents[i].getDocumentType() == DocumentType.MSOFFICE_EXCEL) 
                					 {
                					    output.append("<img src=\"images/ico_excel_18x18.gif\" align=\"absmiddle\">");
                					 }
                                     else if(documents[i].getDocumentType() == DocumentType.MSOFFICE_INFOPATH) 
                					 {
                					    output.append("<img src=\"images/ico_infopath_18x18.gif\" align=\"absmiddle\">");
                					 }
                                     else if(documents[i].getDocumentType() == DocumentType.MSOFFICE_ONENOTE) 
                					 {
                					    output.append("<img src=\"images/ico_onenote_18x18.gif\" align=\"absmiddle\">");
                					 }
                                     else if(documents[i].getDocumentType() == DocumentType.MSOFFICE_POWERPOINT) 
                					 {
                					    output.append("<img src=\"images/ico_powerpoint_18x18.gif\" align=\"absmiddle\">");
                					 }
                                     else if(documents[i].getDocumentType() == DocumentType.MSOFFICE_PROJECT) 
                					 {
                					    output.append("<img src=\"images/ico_project_18x18.gif\" align=\"absmiddle\">");
                					 }
                                     else if(documents[i].getDocumentType() == DocumentType.MSOFFICE_PUBLISHER) 
                					 {
                					    output.append("<img src=\"images/ico_publisher_18x18.gif\" align=\"absmiddle\">");
                					 }
                                     else if(documents[i].getDocumentType() == DocumentType.MSOFFICE_VISIO) 
                					 {
                					    output.append("<img src=\"images/ico_visio_18x18.gif\" align=\"absmiddle\">");
                					 }
                   					 else if(documents[i].getDocumentType() == DocumentType.MSOFFICE_WORD) 
                					 {
                					    output.append("<img src=\"images/ico_word_18x18.gif\" align=\"absmiddle\">");
                					 }	  
                                     output.append("<a href=\"./projectDocumentsViewDocument.jsp?documentId="+documents[i].getId()+"\"><font face=\"Verdana, Arial, Helvetica, sans-serif\">"+documents[i].getName()+"</font></a></td>");
                				     output.append("<td><img src=\"images/dl_sm_dlnow.png\" align=\"absmiddle\"> <a href=\"./servlet/ControllerServlet?opcode="+Operations.DOWNLOAD_DOCUMENT+"&documentid="+documents[i].getId()+"\"><font face=\"Verdana, Arial, Helvetica, sans-serif\">Download</font></a></td>");
                					 output.append("</tr>");
                                  }
                                  output.append("</table>");
                				}
                				else
                				{
                					output.append("<p>No documents currently exist for this project.</P>");
                				}
                			}
                			catch(Exception e)
                			{
                			   output.delete(0, output.length());
                               output.append("<font face=\"Arial, Helvetica, sans-serif\" color=\"#FF0000\">An error occured while processing your request.</font>"); 
                            }
                			finally
                            {
                               // write the output.
                               
            // end
            // begin [file="/projectDocuments.jsp";from=(245,20);to=(245,37)]
                out.print(output.toString());
            // end
            // begin [file="/projectDocuments.jsp";from=(245,41);to=(248,2)]
                
                            }
                		
                		
            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(248,4);to=(259,5)]
                out.write("\r\n        </div>\r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectDocuments.jsp";from=(259,5);to=(259,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(259,47);to=(261,61)]
                out.write("\r\n\t\t<li><a href=\"projectDocumentsUploadDocument.jsp\">Upload a Document</a></li>\r\n\t\t<li><a href=\"projectNotificationsNotificationWizard.jsp?nc=");

            // end
            // begin [file="/projectDocuments.jsp";from=(261,64);to=(261,100)]
                out.print(NotificationContext.DOCUMENT_CONTEXT);
            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(261,102);to=(261,108)]
                out.write("&path=");

            // end
            // begin [file="/projectDocuments.jsp";from=(261,111);to=(261,135)]
                out.print(request.getServletPath());
            // end
            // HTML // begin [file="/projectDocuments.jsp";from=(261,137);to=(283,0)]
                out.write("\">New Notification</a></li>\t  \r\n\t</ul>\r\n     <br/>\r\n    <br/>    \r\n\t<p>&nbsp;</p>\r\n</div>\r\n\r\n\r\n</div>\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
