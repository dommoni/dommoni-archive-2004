<%@page import="java.util.HashMap" %>

<%@page import="com.dommoni.roundtable.Account" %>
<%@page import="com.dommoni.roundtable.Project" %>
<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>

<%@page import="com.dommoni.ece.webui.Operations" %>
<%@page import="com.dommoni.ece.webui.WebUIConfiguration" %>

<%
   ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
   Project currentProject = (Project)session.getAttribute("currentproject");
   Account account = (Account)session.getAttribute("useraccount");
   
   HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
%>

<script>
function showHelp()
{
   // width and height.
   var w = 300;
   var h = 125;

   var winl = (screen.width - w) / 2;
   var wint = (screen.height - h) / 2;
   var settings  ='height='+h+',';
   settings +='width='+w+',';
   settings +='top='+wint+',';
   settings +='left='+winl+',';
   settings +='scrollbars=no,';
   settings +='resizable=no';
   
   var win = window.open('', 'nohelp', settings);
   win.document.write('<html>');
   win.document.write('<head><title>Unavailable Feature</title></head>');
   win.document.write('<body>');
   win.document.write('<font face="Verdana">We Appologize, Help is not currently available. <br>Please Check for RoundTable Updates.</font>');
   win.document.write('</body>');
   win.document.write('</html>');
}
</script>

<h3>
   Logged in as <%=account.getName()%> (<a href="./servlet/ControllerServlet?opcode=<%=Operations.LOGOUT%>">Log-out</a>) <BR/>
   <a href="projectUserSettings.jsp">Settings</a> | <a href="#" onClick="showHelp();">Help</a> 
</h3>
			  
      		<%
			if(currentProject == null)
			{
			// <img src="images/main-logo.gif">
			   %><img src="images/roundtable-logo.gif"><%
			}
			else
			{
			   %><h1>
				 <font face="Verdana, Arial, Helvetica, sans-serif"><%=currentProject.getName()%></font>
			     </h1>
			   <%
			}
			%>
			 	
            <img src="images/spacer.gif" width="10" height="20">
            
<%--

$Log: header.jsp,v $
Revision 1.2  2005/10/16 06:41:14  brian
Added a temporary 'Help Missing' popup.


--%>