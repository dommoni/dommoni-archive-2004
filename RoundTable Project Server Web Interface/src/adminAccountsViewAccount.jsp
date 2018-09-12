<%@page import="java.util.HashMap" %>

<%@page import="com.dommoni.roundtable.Account"%>
<%@page import="com.dommoni.roundtable.AccountType"%>
<%@page import="com.dommoni.roundtable.Project"%>
<%@page import="com.dommoni.roundtable.ProjectServerConnection"%>

<%@page import="com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager"%>

<%@page import="com.dommoni.ece.webui.WebUIConfiguration"%>

<%
	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
	Project currentProject = (Project)session.getAttribute("currentproject");
	Account account = (Account)session.getAttribute("useraccount");
	
	int accountId;
	Account viewAccount = null;
	try
	{
	   accountId = Integer.parseInt(request.getParameter("accountid"));
	   IAccountManager accountManager = psc.getAccountManager();
	   viewAccount = accountManager.getAccount(accountId);
	}
	catch(Exception e)
	{
	   e.printStackTrace();
	}
	
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
	    <% if(viewAccount != null) {%>
		
	    <div class="SectionHeader">
	 	  <h1>Account: <%=viewAccount.getName()%></h1>
	    </div>

        <div class="Post">
	    <!-- PAGE TEXT GOES HERE -->
   		  <p>
		  <%if(viewAccount.getName() != null) {%>
		    <b>Name:</b> <%=viewAccount.getName()%><br />
		  <%}%>
   		  <%if(viewAccount.getNickName() != null) {%>
            <b>Nick Name:</b> <%=viewAccount.getNickName()%><br />
		  <%}%>
		  <%if(viewAccount.getUsername() != null) {%>
		    <b>Username:</b> <%=viewAccount.getUsername()%><br />
          <%}%>
		  <%
		    if(viewAccount.getAccountType() == AccountType.SYSTEM_ADMINISTRATOR)
			{
			   %><b>Account Type:</b> System Administrator<br /><%
			}
			else if(viewAccount.getAccountType() == AccountType.END_USER)
			{
			   %><b>Account Type:</b> End User<br /><%
			}
			else if(viewAccount.getAccountType() == AccountType.MANAGER)
			{
			   %><b>Account Type:</b> Manager<br /><%
			}
			else
			{
			   %><b>Account Type:</b> Unknown<br /><%
			}
          %>
		  <%if(viewAccount.getProfile() != null) {%>
		  <%}%>
		  
		  <p align="center">
		  <img src="./adminAccountsGet2WeekActivityChart.jsp?accountid=<%=viewAccount.getId()%>" />
		  </p>
		<%} else {%>
		   <font color="#FF0000">ERROR: Unable to retrieve account.</font>
		<%}%>
		</p>  
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

$Log: adminAccountsViewAccount.jsp,v $
Revision 1.2  2005/10/16 06:46:15  brian
Added code to generate Activity Chart.


--%>