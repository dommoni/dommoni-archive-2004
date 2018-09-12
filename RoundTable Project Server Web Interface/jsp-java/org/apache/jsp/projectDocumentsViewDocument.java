package org.apache.jsp;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;
import com.dommoni.roundtable.Account;
import com.dommoni.roundtable.BinaryAttachment;
import com.dommoni.roundtable.Comment;
import com.dommoni.roundtable.Document;
import com.dommoni.roundtable.ObjectAttachment;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.projectServer.services.attachmentManager.IAttachmentManager;
import com.dommoni.ece.webui.Operations;
import com.dommoni.ece.webui.WebUIConfiguration;
import com.dommoni.ece.webui.utils.AttachmentSorter;
import com.dommoni.ece.webui.utils.StringUtils;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class projectDocumentsViewDocument extends HttpJspBase {


    static {
    }
    public projectDocumentsViewDocument( ) {
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

            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(0,46);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(1,37);to=(2,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(2,36);to=(4,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(4,50);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(5,59);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(6,50);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(7,51);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(8,59);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(9,50);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(10,66);to=(12,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(12,102);to=(14,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(14,52);to=(15,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(15,60);to=(16,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(16,64);to=(17,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(17,59);to=(19,0)]
                out.write("\r\n\r\n");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(19,2);to=(41,0)]
                
                	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
                	Project currentProject = (Project)session.getAttribute("currentproject");
                	Account account = (Account)session.getAttribute("useraccount");
                	
                	int documentId = -1;
                	Document document = null;
                	
                	try
                	{
                	   documentId = Integer.parseInt(request.getParameter("documentId"));
                	}
                	catch(NumberFormatException nfe)
                	{
                	   nfe.printStackTrace();
                	}
                	
                	if(documentId > -1)
                	   document = psc.getDocumentManager().getDocumentShallow(documentId);
                	
                	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
                	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(41,2);to=(51,7)]
                out.write("\r\n\r\n\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\r\n       \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n\r\n<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en\" lang=\"en\">\r\n\r\n<head>\r\n<meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />\r\n<title>");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(51,10);to=(51,28)]
                out.print(texts.get("title"));
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(51,30);to=(187,3)]
                out.write("</title>\r\n<link rel=\"Stylesheet\" href=\"./includes/screen_v1-0-3.css\" type=\"text/css\" media=\"screen\" />\r\n<link rel=\"Stylesheet\" href=\"./includes/styles.css\" type=\"text/css\" media=\"screen\" />\r\n<style>\r\na:link, a:visited {\r\n\tcolor: #039;\r\n}\r\n\r\na:hover {\r\n\tcolor: #fff;\r\n\tbackground-color: #039;\r\n}\r\n\r\n#Header {\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3, #Header h3 a:link, #Header h3 a:visited {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h3 a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n}\r\n\r\n#Header h3 a.current:link, #Header h3 a.current:visited {\r\n\tcolor: #000;\r\n}\r\n\r\n#Header h3 a.current:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n}\r\n\r\n#Header h1 a:link, #Header h1 a:visited {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h1 a:hover {\r\n\tcolor: #000;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Header h2 {\r\n\tcolor: #5A949E;\r\n}\r\n\r\n#Header h2 a:link, #Header h2 a:visited {\r\n\tcolor: #5A949E;\r\n\ttext-decoration: none;\r\n}\r\n\r\n#Header h2 a:hover {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n\r\n#Tabs a:link, #Tabs a:visited {\r\n\tbackground-color: #43737C;\r\n\tcolor: #FFF;\r\n\tborder: 1px solid #C7E5EA;\r\n\tborder-bottom: 1px solid #43737C;\r\n}\r\n\r\n#Tabs a:link.current, #Tabs a:visited.current {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs a:hover {\r\n\tcolor: #D6FFFF;\r\n\tbackground-color: #1E505A;\r\n\tborder-bottom: 1px solid #1E505A;\r\n}\r\n\r\n#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {\r\n\tcolor: #5A949E;\r\n\tbackground-color: #C7E5EA;\r\n\tborder-bottom: 1px solid #C7E5EA;\r\n\ttext-decoration: underline;\r\n}\r\n\r\n#Tabs li#AdminTab a:hover {\r\n\tcolor: #000;\r\n}\r\n\r\n#Tabs li#AdminTab a.current {\r\n\tcolor: #000;\r\n\ttext-decoration: none;\r\n}\r\n\r\n</style>\r\n<script src=\"./includes/addCommentDlgPopup.js\"></script>\r\n<script src=\"./includes/addAttachmentDlgPopup.js\"></script>\r\n<script src=\"./includes/deleteDlgPopup.js\"></script>\r\n<script language=\"JavaScript\">\r\n<!--\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n//-->\r\n</script>\r\n<script language=\"JavaScript\" type=\"text/JavaScript\">\r\n<!--\r\nfunction MM_reloadPage(init) {  //reloads the window if Nav4 resized\r\n  if (init==true) with (navigator) {if ((appName==\"Netscape\")&&(parseInt(appVersion)==4)) {\r\n    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}\r\n  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();\r\n}\r\nMM_reloadPage(true);\r\n//-->\r\n</script>\r\n</head>\r\n\r\n<body>\r\n\r\n<div id=\"StatusBarContainer\">\r\n\r\n<div id=\"Statusbar\">\r\n\t\t \r\n    <div id=\"StatusRight\"> <img src=\"images/spacer.gif\" width=\"10\" height=\"10\"> \r\n    </div>\r\n  </div>\r\n</div>\r\n\r\n<div class=\"Shadow\" id=\"Shadow\">\r\n\t<div class=\"Container\">\r\n\t\t<div id=\"Header\">\r\n\t\t\t");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(187,3);to=(187,36)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "header.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(187,36);to=(190,9)]
                out.write("\r\n\r\n\t        <!-- TABS -->\r\n\t        ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(190,9);to=(190,41)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "menus.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(190,41);to=(196,3)]
                out.write("\r\n\t  \t</div>\r\n\r\n\t<div id=\"ContentFrame\">\r\n\t\t<div class=\"Left\">\r\n\t <div class=\"SectionHeader\">\r\n\t \t");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(196,5);to=(199,5)]
                
                		if(document != null)
                		{	
                		   
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(199,7);to=(199,21)]
                out.write("<h1>Document: ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(199,24);to=(199,42)]
                out.print(document.getName());
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(199,44);to=(199,49)]
                out.write("</h1>");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(199,51);to=(203,5)]
                
                		}
                		else
                		{
                		   
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(203,7);to=(203,24)]
                out.write("<h1>Document</h1>");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(203,26);to=(205,2)]
                
                		}
                		
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(205,4);to=(212,3)]
                out.write("\r\n\t </div>\r\n\r\n       \r\n    <div class=\"Post\">\r\n\t  <!-- PAGE TEXT GOES HERE -->\r\n\t  \r\n\t  ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(212,5);to=(217,3)]
                
                	  if(document != null)
                	  {
                	    SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMMM d yyyy, hh:mm aaa");
                	  	String ownerName = psc.getAccountManager().getAccount(document.getOwnerId()).getName();
                	  
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(217,5);to=(219,29)]
                out.write("\r\n\t  \r\n\t      <p><b>Created By:</b> ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(219,32);to=(219,41)]
                out.print(ownerName);
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(219,43);to=(220,29)]
                out.write("</p>\r\n\t      <p><b>Created On:</b> ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(220,32);to=(220,77)]
                out.print(sdf.format(document.getCreatedOn().getTime()));
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(220,79);to=(221,28)]
                out.write("</p>\r\n\t      <p><b>File name:</b> ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(221,31);to=(221,53)]
                out.print(document.getFilename());
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(221,55);to=(223,4)]
                out.write("</p>\r\n\t\t  \r\n\t\t  ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(223,6);to=(224,7)]
                if(document.getDescription() != null && document.getDescription().length() > 0) {
                		     
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(224,9);to=(224,35)]
                out.write("<p><b>Description:</b><br>");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(224,38);to=(224,63)]
                out.print(document.getDescription());
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(224,65);to=(224,69)]
                out.write("</p>");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(224,71);to=(225,5)]
                
                		  }
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(225,7);to=(227,4)]
                out.write("\r\n\t\t  \r\n\t\t  ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(227,6);to=(253,7)]
                
                		  IAttachmentManager attachmentManager = psc.getAttachmentManager();
                		  BinaryAttachment[] binaryAttachments = 
                		     attachmentManager.getAllBinaryAttachmentsForObject(document);
                			 
                		  ObjectAttachment[] objectAttachments = 
                		     attachmentManager.getAllObjectAttachmentsForObject(document);
                			 
                		  AttachmentSorter as = new AttachmentSorter();
                		  as.addAttachments(binaryAttachments);
                		  as.addAttachments(objectAttachments);
                		  Vector sorted = as.sort();
                		  for(int i = 0; i < sorted.size(); i++)
                		  {   
                		     if(sorted.get(i) instanceof BinaryAttachment)
                			    System.out.println("Sort: " + ((BinaryAttachment)sorted.get(i)).getCreatedOn().getTimeInMillis());
                		  	 if(sorted.get(i) instanceof ObjectAttachment)
                			    System.out.println("Sort: " + ((ObjectAttachment)sorted.get(i)).getCreatedOn().getTimeInMillis());
                		  	 
                		  }
                		  if(sorted != null && sorted.size() > 0)
                		  {
                		     for(int i = 0; i < sorted.size(); i++)
                			 {
                			    if(sorted.get(i) instanceof BinaryAttachment)
                		        {
                				   
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(253,9);to=(253,44)]
                out.write("<img src=\"images/paperclip.gif\" /> ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(253,47);to=(253,90)]
                out.print(((BinaryAttachment)sorted.get(i)).getName());
            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(253,94);to=(257,7)]
                
                				}
                				if(sorted.get(i) instanceof ObjectAttachment)
                		        {
                				   
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(257,9);to=(257,44)]
                out.write("<img src=\"images/paperclip.gif\" /> ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(257,47);to=(257,90)]
                out.print(((ObjectAttachment)sorted.get(i)).getName());
            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(257,94);to=(261,4)]
                
                				}
                			 }
                		  }
                		  
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(261,6);to=(262,7)]
                out.write("\r\n\t      ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(262,9);to=(267,7)]
                
                		  Comment[] comments = psc.getDocumentManager().getCommentsForDocument(document);
                		  if(comments != null && comments.length > 0)
                		  {
                		     
                		     
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(267,9);to=(267,55)]
                out.write("<br><h2 class=\"date\">Comments</h2><blockquote>");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(267,57);to=(272,7)]
                
                			 
                		     for(int i = 0; i < comments.length; i++)
                			 {
                			    String cb = ((Account)psc.getAccountManager().getAccount(comments[i].getCreatedBy())).getName();
                			    
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(272,9);to=(272,12)]
                out.write("<p>");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(272,15);to=(272,39)]
                out.print(comments[i].getComment());
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(272,41);to=(273,49)]
                out.write("<br>\r\n              <I><font color=\"#cccccc\">Posted by ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(273,52);to=(273,54)]
                out.print(cb);
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(273,56);to=(273,57)]
                out.write(" ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(273,60);to=(273,108)]
                out.print(sdf.format(comments[i].getCreatedOn().getTime()));
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(273,110);to=(274,14)]
                out.write(".</font></I> \r\n              ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(274,16);to=(274,67)]
                if(comments[i].getCreatedBy() == account.getId()) {
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(274,69);to=(275,66)]
                out.write("\r\n              <br><a href=\"#\" onClick=\"showDelete('your comment','");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(275,69);to=(275,94)]
                out.print(Operations.DELETE_COMMENT);
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(275,96);to=(275,99)]
                out.write("','");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(275,102);to=(275,121)]
                out.print(comments[i].getId());
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(275,123);to=(275,180)]
                out.write("','Comment','projectDocumentsViewDocument.jsp?documentId=");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(275,183);to=(275,199)]
                out.print(document.getId());
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(275,201);to=(276,14)]
                out.write("');\"><font size=\"2\">Delete My Comment</font></a> \r\n              ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(276,16);to=(276,17)]
                }
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(276,19);to=(278,12)]
                out.write("\r\n            </p>\r\n            ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(278,14);to=(280,4)]
                
                			 }
                			 
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(280,6);to=(280,19)]
                out.write("</blockquote>");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(280,21);to=(283,6)]
                
                		  }
                	  } else {
                	     
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(283,8);to=(286,10)]
                out.write("\r\n          <font color=\"#FF0000\" face=\"Arial, Helvetica, sans-serif\">An error occured \r\n          processing your request.</font> \r\n          ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(286,12);to=(288,3)]
                
                	  }
                	  
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(288,5);to=(300,5)]
                out.write("\r\n        </div>\r\n\t \r\n\r\n</div>\r\n\r\n\r\n<div class=\"Right\">\r\n\r\n<div class=\"Sidebar\">        \r\n    <h1>Operations</h1>\r\n\t<ul id=\"MTabs\">\r\n    \t");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(300,5);to=(300,47)]
                {
                    String _jspx_qStr = "";
                    JspRuntimeLibrary.include(request, response, "openProjectMenu.jsp" + _jspx_qStr, out, false);
                    if ("true".equals(request.getAttribute("javax.servlet.forward.seen")))
                        return;
                }
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(300,47);to=(302,2)]
                out.write("\r\n\t\t\r\n\t\t");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(302,4);to=(302,26)]
                if(document != null) {
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(302,28);to=(303,51)]
                out.write("\r\n\t\t\t<li><a href=\"./servlet/ControllerServlet?opcode=");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(303,54);to=(303,82)]
                out.print(Operations.DOWNLOAD_DOCUMENT);
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(303,84);to=(303,96)]
                out.write("&documentid=");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(303,99);to=(303,115)]
                out.print(document.getId());
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(303,117);to=(304,3)]
                out.write("\">Download Document</a></li>\r\n\t\t\t");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(304,5);to=(307,6)]
                
                			if(document.getOwnerId() == account.getId())
                			{
                			   
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(307,8);to=(308,67)]
                out.write("\r\n\t\t\t   <li><a href=\"./projectDocumentsModifyDocument.jsp?documentid=");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(308,70);to=(308,86)]
                out.print(document.getId());
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(308,88);to=(308,97)]
                out.write("&respath=");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(308,100);to=(308,124)]
                out.print(request.getServletPath());
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(308,126);to=(309,43)]
                out.write("\">Modify Document</a></li>\r\n\t\t\t   <li><a href=\"#\" onClick=\"showDelete('");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(309,46);to=(309,89)]
                out.print(StringUtils.getJSString(document.getName()));
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(309,91);to=(309,94)]
                out.write("','");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(309,97);to=(309,123)]
                out.print(Operations.DELETE_DOCUMENT);
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(309,125);to=(309,128)]
                out.write("','");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(309,131);to=(309,147)]
                out.print(document.getId());
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(309,149);to=(311,6)]
                out.write("','Document','projectDocuments.jsp');\">Delete Document</a></li>\r\n\t\t\t   \r\n\t\t\t   ");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(311,8);to=(313,3)]
                
                			}
                			
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(313,5);to=(314,3)]
                out.write("\r\n\t\t\t");

            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(314,146);to=(315,68)]
                out.write("\r\n\t\t\t<!--<li><a href=\"./projectDocumentsUploadRevision.jsp?documentid=");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(315,71);to=(315,87)]
                out.print(document.getId());
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(315,89);to=(316,40)]
                out.write("\">Upload New Revision</a></li>-->\r\n\t\t\t<li><a href=\"#\" onClick=\"addComment('");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(316,43);to=(316,86)]
                out.print(StringUtils.getJSString(document.getName()));
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(316,88);to=(316,91)]
                out.write("','");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(316,94);to=(316,110)]
                out.print(document.getId());
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(316,112);to=(316,128)]
                out.write("','Document','./");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(316,131);to=(316,155)]
                out.print(request.getServletPath());
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(316,157);to=(317,2)]
                out.write("');\">Add a Comment</a></li>\t  \r\n\t\t");

            // end
            // begin [file="/projectDocumentsViewDocument.jsp";from=(317,4);to=(317,5)]
                }
            // end
            // HTML // begin [file="/projectDocumentsViewDocument.jsp";from=(317,7);to=(338,0)]
                out.write("\r\n\t</ul>\r\n     <br/>\r\n    <br/>    \r\n</div>\r\n\r\n\r\n</div>\r\n\r\n</div>\r\n</div>\r\n\r\n<div class=\"ShadowCap\">&nbsp;</div>\r\n</div>\r\n\r\n\r\n<div id=\"Footer\">Copyright &copy; 2004 Dommoni Corporation.</div>\r\n\r\n\r\n</body>\r\n</html>\r\n");

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
