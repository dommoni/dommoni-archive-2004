package org.apache.jsp;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.Document;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectDocumentsModifyDocument extends HttpJspBase {


    static {
    }
    public projectDocumentsModifyDocument( ) {
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

            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(0,46);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(1,37);to=(3,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(3,50);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(4,51);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(5,50);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(6,66);to=(8,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(8,52);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(9,60);to=(11,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(11,2);to=(39,0)]
                
                    ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	int documentId = -1;
                	Document document = null;
                	
                	try
                	{
                	   System.out.println("DID: " + request.getParameter("documentid"));
                	   documentId = Integer.parseInt(request.getParameter("documentid"));
                	}
                	catch(NumberFormatException nfe)
                	{
                	   nfe.printStackTrace();
                	}
                	
                	if(documentId > -1)
                	   document = psc.getDocumentManager().getDocumentShallow(documentId);
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
                	
                	System.out.println("ContextPath: " 	+ request.getContextPath());
                	System.out.println("RequstURI: " 	+ request.getRequestURI()); 
                	System.out.println("RequestURL: " 	+ request.getRequestURL()); 
                	System.out.println("ServletPath: " 	+ request.getServletPath());
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(39,2);to=(49,9)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n    <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n\t <title>");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(49,12);to=(49,30)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(49,32);to=(172,3)]
                out.write("</title>\r\n    <link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n\t<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n\t\r\n    <style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n//-->\r\n</script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\t<div id=\"Statusbar\">\r\n\t\t<div id=\"StatusRight\"> \r\n\t\t\t<img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n\t\t</div>\r\n\t</div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(172,3);to=(172,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(172,36);to=(175,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(175,9);to=(175,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(175,41);to=(181,5)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t\t<div id=\"ContentFrame\">\r\n\t\t\t<div class=\"Left\">\r\n\t\t\t\t<div class=\"SectionHeader\">\r\n\t\t\t\t\t");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(181,7);to=(184,21)]
                
                		                if(document != null)
                                        {	
                		                   
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(184,23);to=(184,44)]
                out.write("<h1>Modify Document: ");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(184,47);to=(184,65)]
                out.print(document.getName());
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(184,67);to=(184,72)]
                out.write("</h1>");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(184,74);to=(188,27)]
                
                                        }
                                        else
                                        {
                                           
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(188,29);to=(188,53)]
                out.write("<h1>Modify Document</h1>");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(188,55);to=(190,24)]
                
                                        }
                                        
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(190,26);to=(196,5)]
                out.write("\r\n\t\t\t\t</div>\r\n\r\n       \r\n\t\t\t\t<div class=\"Post\">\r\n\t\t\t\t\t<!-- PAGE TEXT GOES HERE -->\r\n\t\t\t\t\t");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(196,7);to=(199,24)]
                
                                        if(document != null)
                                        {
                                        
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(199,26);to=(203,52)]
                out.write("\r\n\t\t\t\t\t\t    \r\n          <form name=\"form1\" method=\"post\" action=\"./servlet/ControllerServlet\">\r\n            <p>Name: \r\n              <input type=\"text\" name=\"name\" value=\"");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(203,55);to=(203,73)]
                out.print(document.getName());
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(203,75);to=(206,56)]
                out.write("\">\r\n            </p>\r\n\t\t\t<p>File Name: \r\n              <input type=\"text\" name=\"filename\" value=\"");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(206,59);to=(206,81)]
                out.print(document.getFilename());
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(206,83);to=(211,54)]
                out.write("\">\r\n            </p>\r\n\t\t\t<br>\r\n\t\t\t<input type=\"submit\" name=\"Submit\" value=\"Save\">\r\n\t\t\t<input type=\"button\" name=\"Button\" value=\"Cancel\" onClick=\"MM_callJS('window.history.go(-1)')\">\r\n            <input type=\"hidden\" name=\"opcode\" value=\"");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(211,57);to=(211,81)]
                out.print(Operations.EDIT_DOCUMENT);
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(211,83);to=(212,46)]
                out.write("\">\r\n\t\t\t<input type=\"hidden\" name=\"respath\" value=\"");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(212,49);to=(212,80)]
                out.print(request.getParameter("respath"));
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(212,82);to=(213,49)]
                out.write("\">\r\n\t\t\t<input type=\"hidden\" name=\"documentid\" value=\"");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(213,52);to=(213,68)]
                out.print(document.getId());
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(213,70);to=(215,6)]
                out.write("\">\r\n\t\t  </form>\r\n\t\t\t\t\t\t");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(215,8);to=(219,24)]
                
                                        } 
                                        else 
                                        {
                                        
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(219,26);to=(221,6)]
                out.write("\r\n\t\t\t\t\t\t<font color=\"#FF0000\" face=\"Arial, Helvetica, sans-serif\">An error occured processing your request.</font> \r\n\t\t\t\t\t\t");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(221,8);to=(223,24)]
                
                                        }
                                        
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(223,26);to=(233,6)]
                out.write("\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\r\n\r\n\t\t\t<div class=\"Right\">\r\n\r\n\t\t\t\t<div class=\"Sidebar\">        \r\n\t\t\t\t\t<h1>Operations</h1>\r\n\t\t\t\t\t<ul id=\"MTabs\">\r\n\t\t\t\t\t\t");

            // end
            // begin [file="/projectDocumentsModifyDocument.jsp";from=(233,6);to=(233,48)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectDocumentsModifyDocument.jsp";from=(233,48);to=(252,0)]
                out.write("\r\n\t\t\t\t\t</ul>\r\n\t\t\t\t\t<br />\r\n\t\t\t\t\t<br\t/>    \r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n            \r\n\t\t\t<!--<div id=\"showhelp\">\r\n\t\t\t\t<a href=\"#\">Show \"Things to do\"</a></div>-->\r\n            </div>\r\n\t\t</div>\r\n\r\n\t\t<div class=\"ShadowCap\">&nbsp;</div>\r\n\t</div>\r\n\t<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
