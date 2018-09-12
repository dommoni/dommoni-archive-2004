<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.Vector" %>

<%@page import="com.dommoni.roundtable.Account" %>
<%@page import="com.dommoni.roundtable.BinaryAttachment" %>
<%@page import="com.dommoni.roundtable.Comment" %>
<%@page import="com.dommoni.roundtable.Document" %>
<%@page import="com.dommoni.roundtable.ObjectAttachment" %>
<%@page import="com.dommoni.roundtable.Project" %>
<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>

<%@page import="com.dommoni.roundtable.projectServer.services.attachmentManager.IAttachmentManager" %>

<%@page import="com.dommoni.ece.webui.Operations" %>
<%@page import="com.dommoni.ece.webui.WebUIConfiguration" %>
<%@page import="com.dommoni.ece.webui.utils.AttachmentSorter" %>
<%@page import="com.dommoni.ece.webui.utils.StringUtils" %>

<%
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
<script src="./includes/addCommentDlgPopup.js"></script>
<script src="./includes/addAttachmentDlgPopup.js"></script>
<script src="./includes/deleteDlgPopup.js"></script>
<script language="JavaScript">
<!--
function MM_callJS(jsStr) { //v2.0
  return eval(jsStr)
}
//-->
</script>
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_reloadPage(init) {  //reloads the window if Nav4 resized
  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
}
MM_reloadPage(true);
//-->
</script>
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
	 	<%
		if(document != null)
		{	
		   %><h1>Document: <%=document.getName()%></h1><%
		}
		else
		{
		   %><h1>Document</h1><%
		}
		%>
	 </div>

       
    <div class="Post">
	  <!-- PAGE TEXT GOES HERE -->
	  
	  <%
	  if(document != null)
	  {
	    SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMMM d yyyy, hh:mm aaa");
	  	String ownerName = psc.getAccountManager().getAccount(document.getOwnerId()).getName();
	  %>
	  
	      <p><b>Created By:</b> <%=ownerName%></p>
	      <p><b>Created On:</b> <%=sdf.format(document.getCreatedOn().getTime())%></p>
	      <p><b>File name:</b> <%=document.getFilename()%></p>
		  
		  <%if(document.getDescription() != null && document.getDescription().length() > 0) {
		     %><p><b>Description:</b><br><%=document.getDescription()%></p><%
		  }%>
		  
		  <%
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
				   %><img src="images/paperclip.gif" /> <%=((BinaryAttachment)sorted.get(i)).getName()%><%
				}
				if(sorted.get(i) instanceof ObjectAttachment)
		        {
				   %><img src="images/paperclip.gif" /> <%=((ObjectAttachment)sorted.get(i)).getName()%><%
				}
			 }
		  }
		  %>
	      <%
		  Comment[] comments = psc.getDocumentManager().getCommentsForDocument(document);
		  if(comments != null && comments.length > 0)
		  {
		     
		     %><br><h2 class="date">Comments</h2><blockquote><%
			 
		     for(int i = 0; i < comments.length; i++)
			 {
			    String cb = ((Account)psc.getAccountManager().getAccount(comments[i].getCreatedBy())).getName();
			    %><p><%=comments[i].getComment()%><br>
              <I><font color="#cccccc">Posted by <%=cb%> <%=sdf.format(comments[i].getCreatedOn().getTime())%>.</font></I> 
              <%if(comments[i].getCreatedBy() == account.getId()) {%>
              <br><a href="#" onClick="showDelete('your comment','<%=Operations.DELETE_COMMENT%>','<%=comments[i].getId()%>','Comment','projectDocumentsViewDocument.jsp?documentId=<%=document.getId()%>');"><font size="2">Delete My Comment</font></a> 
              <%}%>
            </p>
            <%
			 }
			 %></blockquote><%
		  }
	  } else {
	     %>
          <font color="#FF0000" face="Arial, Helvetica, sans-serif">An error occured 
          processing your request.</font> 
          <%
	  }
	  %>
        </div>
	 

</div>


<div class="Right">

<div class="Sidebar">        
    <h1>Operations</h1>
	<ul id="MTabs">
    	<jsp:include page="openProjectMenu.jsp" />
		
		<%if(document != null) {%>
			<li><a href="./servlet/ControllerServlet?opcode=<%=Operations.DOWNLOAD_DOCUMENT%>&documentid=<%=document.getId()%>">Download Document</a></li>
			<%
			if(document.getOwnerId() == account.getId())
			{
			   %>
			   <li><a href="./projectDocumentsModifyDocument.jsp?documentid=<%=document.getId()%>&respath=<%=request.getServletPath()%>">Modify Document</a></li>
			   <li><a href="#" onClick="showDelete('<%=StringUtils.getJSString(document.getName())%>','<%=Operations.DELETE_DOCUMENT%>','<%=document.getId()%>','Document','projectDocuments.jsp');">Delete Document</a></li>
			   
			   <%
			}
			%>
			<%--<li><a href="#" onClick="addAttachment('<%=document.getId()%>','Document','<%=request.getServletPath()%>');">Add an Attachment</a></li>--%>
			<!--<li><a href="./projectDocumentsUploadRevision.jsp?documentid=<%=document.getId()%>">Upload New Revision</a></li>-->
			<li><a href="#" onClick="addComment('<%=StringUtils.getJSString(document.getName())%>','<%=document.getId()%>','Document','./<%=request.getServletPath()%>');">Add a Comment</a></li>	  
		<%}%>
	</ul>
     <br/>
    <br/>    
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

$Log: projectDocumentsViewDocument.jsp,v $
Revision 1.2  2005/10/16 07:41:55  brian
Added support for attachments.


--%>