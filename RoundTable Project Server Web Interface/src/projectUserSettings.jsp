<%@page import="java.util.HashMap" %>

<%@page import="com.dommoni.roundtable.Account" %>
<%@page import="com.dommoni.roundtable.AccountContact" %>
<%@page import="com.dommoni.roundtable.AccountSettings" %>
<%@page import="com.dommoni.roundtable.Project" %>
<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>

<%@page import="com.dommoni.ece.webui.MenuController" %>
<%@page import="com.dommoni.ece.webui.Operations" %>
<%@page import="com.dommoni.ece.webui.WebUIConfiguration" %>

<%
    ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
	Project currentProject = (Project)session.getAttribute("currentproject");
	Account account = (Account)session.getAttribute("useraccount");
	
   	MenuController mc = (MenuController)request.getSession().getAttribute("mc");
   	mc.setCurrentPageIdToNull(session);
   
    AccountSettings accountSettings = psc.getAccountManager().getAccountSettings(account.getId());
	AccountContact accountContact = psc.getAccountManager().getAccountContact(account.getId());
   
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
<script language="JavaScript">
<!--
function MM_goToURL() { //v3.0
  var i, args=MM_goToURL.arguments; document.MM_returnValue = false;
  for (i=0; i<(args.length-1); i+=2) eval(args[i]+".location='"+args[i+1]+"'");
}
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
	 	
		
	<h1>Account Settings</h1>
		
	 </div>

        <div class="Post"> 
          <%
		  if(accountSettings != null)
		  {%>
		  <form name="form1" method="post" action="./servlet/ControllerServlet">
            <!-- Account Contacts -->
			
            <b> <font size="2">Account Contact Information:</font></b> <br>
          <blockquote>
		    <table border="0" cellspacing="5" cellpadding="0">
			<tr><td>Email Address: </td> 
		    <%
			// dont want to print the word "null" in the box.
			if(accountSettings.getPrimaryEmailAddress() != null && accountSettings.getPrimaryEmailAddress().length() > 0) 
			{
			   %><td><input type="text" name="primaryEmail" value="<%=accountSettings.getPrimaryEmailAddress()%>"></td><% 
			} 
			else 
			{
			   %><td><input type="text" name="primaryEmail" ></td><% 
			} 
			%></tr>
			
			<tr><td>Phone Number: </td> 
			<%if(accountContact.getPhoneNumber() != null && accountContact.getPhoneNumber().length() > 0) 
			{
			   %><td><input type="text" name="phonenumber" value="<%=accountContact.getPhoneNumber()%>"></td><%
			} else {
			   %><td><input type="text" name="phonenumber"></td><%
			}%></tr>
			
   			<tr><td>Address: </td>
			<%if(accountContact.getOfficeAddress() != null && accountContact.getOfficeAddress().length() > 0)
			{
			   %><td><input type="text" name="address" value="<%=accountContact.getOfficeAddress()%>"></td><%
			} else {
			   %><td><input type="text" name="address" ></td><%
			}%></tr>
			
   			<tr><td>City: </td>
			<%if(accountContact.getCity() != null && accountContact.getCity().length() > 0)
			{
			   %><td><input type="text" name="city" value="<%=accountContact.getCity()%>"></td><%
   			} else {
			   %><td><input type="text" name="city" ></td><%
			}%>
			
			<tr><td>State: </td> 
			<%if(accountContact.getState() != null && accountContact.getState().length() > 0) 
			{
			   %><td><input type="text" name="state" value="<%=accountContact.getState()%>"></td><%
			} else {
			   %><td><input type="text" name="state" ></td><%
			} %></tr>
			
			<tr><td>Zip: </td> 
			<%if(accountContact.getZip() != null && accountContact.getZip().length() > 0) 
			{
			   %><td><input type="text" name="zip" value="<%=accountContact.getZip()%>"></td><%
			} else {
			   %><td><input type="text" name="zip" ></td><%
			}%></tr>
			</table>
           </blockquote>
		    
			<br>
            <font size="2"><b>Notification Settings:</b></font><br>
		    <blockquote> 
              <table width="326" border="0" cellspacing="5" cellpadding="0">
                <tr>
                  <td width="39">
                    <%
					if(accountSettings.getNotificationsSystemMessage())
					{
					   %><input type="checkbox" name="nSystemMessage" value="yes" checked><% 
					} 
					else 
					{ 
					   %><input type="checkbox" name="nSystemMessage" value="yes"><% 
					} 
					%>
                  </td>
                  <td width="272">Receive Notifications as System-Messages</td>
                </tr>
                <tr>
                  <td width="39">
				  <%if(accountSettings.getNotificationsDesktopPager())
				  {
                     %><input type="checkbox" name="nDesktopPager" value="yes" checked><%
				  }
				  else
				  {	
				     %><input type="checkbox" name="nDesktopPager" value="yes"><%
				  } %>
                  </td>
                  <td width="272">Receive Notifications as ECE Desktop Pager Alerts</td>
                </tr>
                <tr>
                  <td width="39">
				    <%
					if(accountSettings.getNotificationsEmail())
					{
					   %><input type="checkbox" name="nEmail" value="yes" checked><%
					}
					else
					{
                       %><input type="checkbox" name="nEmail" value="yes"><%
					}
					%>
                  </td>
                  <td width="272">Receive Notifications as Email</td>
                </tr>
              </table>
              <br>
              <br>
            </blockquote>
			
		    <input type="submit" name="Save" value="Save">
            <input type="button" name="Button" value="Cancel" onClick="MM_goToURL('parent','projectUserSettings.jsp');return document.MM_returnValue">
            <input type="hidden" name="opcode" value="<%=Operations.SAVE_SETTINGS%>">
          </form>
		  <%}else{%>
		     
          <p><font color="#FF0000">ERROR: Unable to retrieve account settings.</font> 
            (<a href=".">Report this error</a>)</p>
		  <%}%>
		  </div>
</div>


<div class="Right">

<div class="Sidebar">        
    <h1>Operations</h1>
	<ul id="MTabs">
    	<jsp:include page="openProjectMenu.jsp" />
		    <li><a href="accountEditProfile.jsp">Edit Profile</a></li>
		<li><a href="accountChangePassword.jsp">Change Password</a></li>
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
