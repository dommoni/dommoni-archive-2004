<%@page import="java.util.HashMap" %>
<%@page import="java.util.Vector" %>

<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>
<%@page import="com.dommoni.roundtable.Account" %>
<%@page import="com.dommoni.roundtable.AccountType" %>
<%@page import="com.dommoni.roundtable.Document" %>
<%@page import="com.dommoni.roundtable.DocumentType" %>
<%@page import="com.dommoni.roundtable.NotificationContext" %>
<%@page import="com.dommoni.roundtable.Project" %>
<%@page import="com.dommoni.roundtable.projectServer.services.documentManager.IDocumentManager" %>
<%@page import="com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager" %>
<%@page import="com.dommoni.ece.webui.MenuItem" %>
<%@page import="com.dommoni.ece.webui.Operations" %>
<%@page import="com.dommoni.ece.webui.WebUIConfiguration" %>

<%
	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
	Project currentProject = (Project)session.getAttribute("currentproject");
	Account account = (Account)session.getAttribute("useraccount");
	
	IDocumentManager documentManager = psc.getDocumentManager();
	Document documents[] = documentManager.getAllDocumentsForProjectShallow(currentProject.getId());
	
	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
       "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
    <meta http-equiv="content-type" content="text/html;charset=iso-8859-1" />
	 <title><%=texts.get("title")%></title>
    <link rel="Stylesheet" href="./includes/screen_v1-0-3.css" type="text/css" media="screen" />
	<link rel="Stylesheet" href="./includes/styles.css" type="text/css" media="screen" />
	
    <style>
a:link, a:visited {
	color: #039;
}

a:hover {
	color: #fff;
	background-color: #039;
}

#Header {
	background-color: #C7E5EA;
}

#Header h1 {
	color: #000;
}

#Header h3, #Header h3 a:link, #Header h3 a:visited {
	color: #5A949E;
}

#Header h3 a:hover {
	color: #D6FFFF;
	background-color: #1E505A;
}

#Header h3 a.current:link, #Header h3 a.current:visited {
	color: #000;
}

#Header h3 a.current:hover {
	color: #000;
	background-color: #C7E5EA;
}

#Header h1 a:link, #Header h1 a:visited {
	color: #000;
	text-decoration: none;
}

#Header h1 a:hover {
	color: #000;
	background-color: #C7E5EA;
	text-decoration: underline;
}

#Header h2 {
	color: #5A949E;
}

#Header h2 a:link, #Header h2 a:visited {
	color: #5A949E;
	text-decoration: none;
}

#Header h2 a:hover {
	color: #5A949E;
	background-color: #C7E5EA;
	text-decoration: underline;
}


#Tabs a:link, #Tabs a:visited {
	background-color: #43737C;
	color: #FFF;
	border: 1px solid #C7E5EA;
	border-bottom: 1px solid #43737C;
}

#Tabs a:link.current, #Tabs a:visited.current {
	color: #000;
}

#Tabs a:hover {
	color: #D6FFFF;
	background-color: #1E505A;
	border-bottom: 1px solid #1E505A;
}

#Tabs li#AdminTab a:link, #Tabs li#AdminTab a:visited {
	color: #5A949E;
	background-color: #C7E5EA;
	border-bottom: 1px solid #C7E5EA;
	text-decoration: underline;
}

#Tabs li#AdminTab a:hover {
	color: #000;
}

#Tabs li#AdminTab a.current {
	color: #000;
	text-decoration: none;
}

</style>
</head>

<body>

<div id="StatusBarContainer">

<div id="Statusbar">
		 
    <div id="StatusRight"> <img src="images/spacer.gif" width="10" height="10"> 
    </div>
	</div>
</div>

<div class="Shadow" id="Shadow">
	<div class="Container">
		<div id="Header">
			<jsp:include page="header.jsp" />

	        <!-- TABS -->
	        <jsp:include page="menus.jsp" />
	  	</div>

	<div id="ContentFrame">
		<div class="Left">
	 <div class="SectionHeader">
	 	
		
	<h1>Documents</h1>
		
	 </div>

        
        <div class="Post">
  <!-- Documents --> 
	    <%
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
               %><%=output.toString()%><%
            }
		
		%>
        </div>

</div>


<div class="Right">

<div class="Sidebar">        
    <h1>Operations</h1>
	<ul id="MTabs">
    	<jsp:include page="openProjectMenu.jsp" />
		<li><a href="projectDocumentsUploadDocument.jsp">Upload a Document</a></li>
		<li><a href="projectNotificationsNotificationWizard.jsp?nc=<%=NotificationContext.DOCUMENT_CONTEXT%>&path=<%=request.getServletPath()%>">New Notification</a></li>	  
	</ul>
     <br/>
    <br/>    
	<p>&nbsp;</p>
</div>


</div>

</div>
</div>

<div class="ShadowCap">&nbsp;</div>
</div>


<div id="Footer">Copyright &copy; 2004 Dommoni Corporation.</div>


</body>
</html>
<%--
*
* $Log: projectDocuments.jsp,v $
* Revision 1.3  2005/10/16 07:20:18  brian
* Added support for MS Office 2003 File Types.
*
* Revision 1.2  2005/03/28 16:47:52  brian
* Removed printf and "show things to do" link.
*
*
--%>