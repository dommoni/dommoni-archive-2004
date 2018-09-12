
<%
	String objectName = request.getParameter("name");
	String opCode = request.getParameter("opcode");
	String opParam = request.getParameter("opparam");
	String context = request.getParameter("context");
	
	String parentLink = request.getParameter("parentlink");
%>
<html>
<head><title>Delete <%=context%></title>
<script language="JavaScript">
function closeWindow()
{
 	window.close();
}
</script>
</head>
<body bgcolor="#FFFFFF">
<p><font size="3" color="#000000" face="Arial, Helvetica, sans-serif"><b>Delete 
  <%=context%> </b> </font></p>
<p><font face="Arial, Helvetica, sans-serif" size="2">Are you sure you want to 
  delete <b><%=objectName%></b>?</font></p>

<form name="form1" method="post" action="./servlet/ControllerServlet">
  <input type="submit" name="Submit" value="Delete">
  <input type="button" name="Button" value="Cancel" onClick="closeWindow()">
  <input type="hidden" name="opcode" value="<%=opCode%>">
  <input type="hidden" name="parentlink" value="<%=parentLink%>">
  <%
  //
  // We have to do this ridiculous context-name compare to generate the 
  // parameter name...
  if(context.equalsIgnoreCase("document"))
  {
     %><input type="hidden" name="documentid" value="<%=opParam%>"><%
  }
  else if(context.equalsIgnoreCase("task"))
  {
     %><input type="hidden" name="todoid" value="<%=opParam%>"><%
  }
  else if(context.equalsIgnoreCase("forum"))
  {
     %><input type="hidden" name="forumid" value="<%=opParam%>"><%
  }
  else if(context.equalsIgnoreCase("meeting"))
  {
     %><input type="hidden" name="meetingid" value="<%=opParam%>"><%
  }
  else if(context.equalsIgnoreCase("account"))
  {
     %><input type="hidden" name="accountid" value="<%=opParam%>"><%
  }
  else if(context.equalsIgnoreCase("project"))
  {
     %><input type="hidden" name="projectid" value="<%=opParam%>"><%
  }
  else if(context.equalsIgnoreCase("comment"))
  {
     %><input type="hidden" name="commentid" value="<%=opParam%>"><%
  }
  else if(context.equalsIgnoreCase("schedule"))
  {
     %><input type="hidden" name="scheduleid" value="<%=opParam%>"><%
  }
  %>
</form>
</body>
<%-- 

$Log: projectConfirmDeleteDlg.jsp,v $
Revision 1.2  2005/10/16 07:08:13  brian
Renamed 'todo' to 'task'. Added support for Schedules.


--%>