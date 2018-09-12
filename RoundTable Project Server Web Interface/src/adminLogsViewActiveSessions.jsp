<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.HashMap" %>

<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>
<%@page import="com.dommoni.roundtable.Account" %>
<%@page import="com.dommoni.roundtable.AccountType" %>
<%@page import="com.dommoni.roundtable.Project" %>
<%@page import="com.dommoni.roundtable.Session" %>
<%@page import="com.dommoni.roundtable.logging.EventLogEntry" %>

<%@page import="com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager" %>
<%@page import="com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager" %>
<%@page import="com.dommoni.roundtable.projectServer.services.sessionManager.ISessionManager" %>

<%@page import="com.dommoni.ece.webui.Operations" %>
<%@page import="com.dommoni.ece.webui.WebUIConfiguration" %>
<%@page import="com.dommoni.ece.webui.utils.StringUtils" %>

<%
	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
	Project currentProject = (Project)session.getAttribute("currentproject");
	
	IAccountManager accountManager = psc.getAccountManager();
	Account account = accountManager.getAccountFromUsername(psc.getUsername());
	
	ISessionManager sessionManager = psc.getSessionManager();
	Session[] activeSessions = sessionManager.getActiveSessions();
	
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
<script src="./includes/deleteDlgPopup.js"></script>
</head>

<body>

<div id="StatusBarContainer">

<div id="Statusbar">
		 
    <div id="StatusRight"> <img src="images/spacer.gif" width="10" height="10"> 
    </div></div></div><div class="Shadow" id="Shadow">
	<div class="Container">
		<div id="Header">
			<jsp:include page="header.jsp" />

	 <!-- TABS -->
	 <jsp:include page="menus.jsp" />
	  
	</div><div id="ContentFrame">
		<div class="Left">
	 <div class="SectionHeader">
	 	
		
      <h1>Active Sessions</h1></div>
			<div class="Post">
  <!--projects--> 
      <%
			if(activeSessions != null && activeSessions.length > 0)
			{
			   SimpleDateFormat sdf = new SimpleDateFormat("MMMMM d yyyy, hh:mm aaa");
			   %>
				 <table>
				 <tr>
	       <td><b>Account</b></td>
         <td><b>Type</b></td> 
         <td><b>Start-Time</b></td>
         <td><b>Last Activity Time</b></td>
         <td><b>IP Address</b></td>
         <td><b>Project</b></td>
				 </tr><%
			   for(int i = 0; i < activeSessions.length; i++)
				 {
				    %><tr>
						<td><%=activeSessions[i].getAccount()%></td>
            <td><%=activeSessions[i].getType()%></td> 
						
						<%if(activeSessions[i].getStartTime() != null) {
               %><td><%=sdf.format(activeSessions[i].getStartTime().getTime())%></td><%
						} else {
						   %><td>N/A</td><%
						} %>
						
						<% if(activeSessions[i].getLastActivityTime() != null) {
               %><td><%=sdf.format(activeSessions[i].getLastActivityTime().getTime())%></td><%
						} else {
						   %><td>N/A</td><%
						} %>
            
						<td><%=activeSessions[i].getRemoteIPAddress()%></td>
            <td><%=activeSessions[i].getCurrentProject()%></td>
						</tr>
						<%
				 }
				 %></table><%
			}
			%>
			
			 
			 </div></div><div class="Right">

<div class="Sidebar">        
    <h1>Operations</h1><ul id="MTabs">
    	<jsp:include page="openProjectMenu.jsp" />
		</ul><br/>
    <br/>
	<p>&nbsp;</p></div></div></div></div><div class="ShadowCap">&nbsp;</div></div><div id="Footer">Copyright &copy; 2004 Dommoni Corporation.</div>


</body>
</html>
