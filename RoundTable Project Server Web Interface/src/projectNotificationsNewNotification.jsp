<%@page import="java.util.HashMap" %>

<%@page import="com.dommoni.ece.webui.Operations" %>
<%@page import="com.dommoni.ece.webui.WebUIConfiguration" %>

<%
   String notificationObject = request.getParameter("no");
   
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
function MM_callJS(jsStr) { //v2.0
  return eval(jsStr)
}
//-->
</script>
</head>

<script>
function newTodoFolder()
{
   var newWin = open('projectTodosNewToDoFolder.jsp','','height=200,width=300,directories=no,location=no,menubar=no,resizable=no,scrollbars=no,status=no,toolbar=no,screenX=200,screenY=200,top=0,left=0');
}
</script>

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
	if(notificationObject != null && notificationObject.length() > 0)
	{	
	   %><h1>New <%=notificationObject%> Notification</h1><%
	}
	else
	{
	   %><h1>New Notification</h1><%
	}
	%>
		
	 </div>

        
        <div class="Post">
  <!--ToDo's--> 
  	      <form name="form1" method="post" action="./servlet/ControllerServlet">
            <p>Name: 
              <input type="text" name="name">
              (optional)</p>
            <p>Type: </p>
            <table width="334" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="28">&nbsp;</td>
                <td width="266">Notify me when a <%=notificationObject%> is <b>created</b>:</td>
                <td width="40"> 
                  <input type="checkbox" name="create" value="true">
                </td>
              </tr>
              <tr>
                <td width="28">&nbsp;</td>
                <td width="266">Notify me when a <%=notificationObject%> is <b>deleted</b>:</td>
                <td width="40"> 
                  <input type="checkbox" name="delete" value="true">
                </td>
              </tr>
              <tr>
                <td width="28">&nbsp;</td>
                <td width="266">Notify me when a <%=notificationObject%> is <b>modified</b>:</td>
                <td width="40"> 
                  <input type="checkbox" name="modify" value="true">
                </td>
              </tr>
              <tr>
                <td width="28">&nbsp;</td>
                <td width="266">&nbsp;</td>
                <td width="40">&nbsp; </td>
              </tr>
            </table>
            <p> 
              <input type="submit" name="Submit" value="Create">
              <input type="button" name="Button" value="Cancel" onClick="MM_callJS('window.history.go(-1)')">
              <input type="hidden" name="no" value="<%=notificationObject%>">
              <input type="hidden" name="opcode" value="<%=Operations.CREATE_NOTIFICATION%>">
            </p>
          </form>
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
