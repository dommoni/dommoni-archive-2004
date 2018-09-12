<%@page import="java.util.HashMap" %>
<%@page import="java.util.Vector" %>

<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>
<%@page import="com.dommoni.roundtable.Account" %>
<%@page import="com.dommoni.roundtable.AccountContact" %>
<%@page import="com.dommoni.roundtable.AccountProfile" %>
<%@page import="com.dommoni.roundtable.AccountSettings" %>
<%@page import="com.dommoni.roundtable.AccountType" %>
<%@page import="com.dommoni.roundtable.Project" %>

<%@page import="com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager" %>
<%@page import="com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager" %>

<%@page import="com.dommoni.ece.webui.MenuItem" %>
<%@page import="com.dommoni.ece.webui.WebUIConfiguration" %>

<%
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
	 	
		
	<h1>Member: <%=projectMember.getName()%></h1>
		
	 </div>

        
        <div class="Post">
	  <!--projects member -->
	  <%
	if(accountProfile != null)
	  {
	  %>
	  <h2>Profile</h2>
	  <table width="376" border="0" cellspacing="5" cellpadding="0">
  <tr> 
    <td valign="top"><% 
	
	byte image[] = accountProfile.getImage();
	if(image != null && image.length > 0)
	{
		// make a gif image...
		%><img src="./getProfileImage.jsp?accountid=<%=projectMember.getId()%>" align="right"><%
	}
	else
	{
		%><img src="./images/no-pro-pic_lghtgrey-line.gif" width="64" height="75" align="right"><%
	}
	
	 if(accountProfile.getProfileText() != null && accountProfile.getProfileText().length() > 0)
	 {
		%><%=accountProfile.getProfileText()%><%
	 }
	 else
	 {
		%><p>This member has not yet added a profile.</p><%
	 }
	%>
	</td>
  </tr>
</table>

  <% if(accountContact != null)
  {
     %>
	 <h2>Contact Information</h2>
	 <%if(accountSettings.getPrimaryEmailAddress() != null && accountSettings.getPrimaryEmailAddress().length() > 0){%>
	   <img src="images/spacer.gif" height="1" width="10"><font size="2">Email:</font> <font size="2"><%=accountSettings.getPrimaryEmailAddress()%></font><br>
	 <%}%>
	 <%if(accountContact.getPhoneNumber() != null && accountContact.getPhoneNumber().length() > 0){%> 
	   <img src="images/spacer.gif" height="1" width="10"><font size="2">Phone Number:</font> <font size="2"><%=accountContact.getPhoneNumber()%></font><br>
	 <%}%>
	 
	 <%if(accountContact.getOfficeAddress() != null && accountContact.getOfficeAddress().length() > 0 &&
	      accountContact.getCity() != null && accountContact.getCity().length() > 0 &&
		  accountContact.getState() != null && accountContact.getState().length() > 0 &&
		  accountContact.getZip() != null && accountContact.getZip().length() > 0)
	 {%> 
	   <img src="images/spacer.gif" height="1" width="10"><font size="2">Address:</font> <font size="2"><%=accountContact.getOfficeAddress()%></font><br>
	   <img src="images/spacer.gif" height="1" width="10"><font size="2">City:</font> <font size="2"><%=accountContact.getCity()%></font><br>
	   <img src="images/spacer.gif" height="1" width="10"><font size="2">State:</font> <font size="2"><%=accountContact.getState()%></font><br>
	   <img src="images/spacer.gif" height="1" width="10"><font size="2">Zip:</font> <font size="2"><%=accountContact.getZip()%></font><br>
	 <%}%>
	 <%
  }
  %>

<%
}
else
	  {
	     %><p><font color="#FF0000">Error! No profile was found for this member.</font></p><%
	  }%>
	  
	  
    </div>

</div>


<div class="Right">

<div class="Sidebar">        
    <h1>Operations</h1>
	<ul id="MTabs">
    	<jsp:include page="openProjectMenu.jsp" />	  
	</ul>
     <br/>
    <br/>    
    <P>&nbsp;</P>
</div>


</div>


</div>
</div>

<div class="ShadowCap">&nbsp;</div>
</div>


<div id="Footer">Copyright &copy; 2004 Dommoni Corporation.</div>


</body>
</html>
