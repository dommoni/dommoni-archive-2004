<%@page import="java.io.File" %>

<%@page import="java.util.Enumeration" %>
<%@page import="java.util.HashMap" %>

<%@page import="com.dommoni.roundtable.Account" %>
<%@page import="com.dommoni.roundtable.AccountType" %>
<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>
<%@page import="com.dommoni.roundtable.SessionType" %>

<%@page import="com.dommoni.ece.webui.MenuController" %>
<%@page import="com.dommoni.ece.webui.Operations" %>
<%@page import="com.dommoni.ece.webui.WebUIConfiguration" %>
<%@page import="com.dommoni.ece.webui.XMLProperties" %>

<%@page import="com.dommoni.ece.webui.menus.MenuItemMap" %>

<%
	boolean loginFailed = false;
	String loginFailureReason = "";
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
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

<script>
function setFocus()
{
	document.form1.username.focus();
}
</script>

<%
	if(username != null && password != null)
	{
	    String ipaddr = (String)getServletContext().getAttribute("projectServerIpAddress");
		
		int port;
		try
		{
		   port = Integer.parseInt((String)getServletContext().getAttribute("projectServerPort"));
		}
		catch(NumberFormatException nfe)
		{
		   port = 8080;
		   nfe.printStackTrace();
		}
		
		ProjectServerConnection psc = new ProjectServerConnection(username, password, SessionType.WEBUI_SESSION, ipaddr, port);
		try
		{
			psc.login();
			
			session.setAttribute("psc", psc);
			session.setAttribute("menus", ((MenuItemMap)WebUIConfiguration.getInstance().get("menus")).clone());
			session.setAttribute("mc", new MenuController());
			
			response.sendRedirect("./servlet/ControllerServlet?opcode=" + Operations.LOGIN);
		}
		catch(Exception e)
		{
		    e.printStackTrace();
			loginFailed = true;
		}
	}
%>
<body onload="setFocus()">
<div id="StatusBarContainer"> 
  <div id="Statusbar"> 
    <div id="StatusRight"> <img src="images/spacer.gif" width="10" height="10"> 
    </div>
  </div>
</div>
<div class="Shadow" id="Shadow"> 
  <div class="Container"> 
    <div id="Header"> 
      
      <img src="images/roundtable-logo.gif" width="302" height="71">
      
    </div>
    <div id="ContentFrame"> 
      <div class="Left"> 
        
        <div class="Post"> 
          <h1> Login 
          </h1>
          <form name="form1" method="post" action="" focus="username">
            <p>Username: 
              <input type="text" name="username">
            </p>
            <p>Password: 
              <input type="password" name="password">
            </p>
            <p> 
              <input type="submit" name="Submit" value="Login">
            </p>
            <%if(loginFailed)
						  {
							   if(loginFailureReason.length() == 0) {
						        %><p><font color="#FF0000"><%=texts.get("login.failure")%></font></p><%
								 } else {
								    %><p><font color="#FF0000"><%=loginFailureReason%></font></p><%
								 }
							}%>
          </form>
        </div>
      </div>
      
    </div>
  </div>
  <div class="ShadowCap"> &nbsp; </div>
</div>
<div id="Footer">Copyright &copy; 2004 Dommoni Corporation.</div>
</body>
</html>
