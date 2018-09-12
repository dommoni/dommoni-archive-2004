
<%

	String objectName = request.getParameter("name");
	String opCode = request.getParameter("opcode");
	String opParam = request.getParameter("opparam");
	String context = request.getParameter("context");
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
  <%
  //
  // We have to do this ridiculous context-name compare to generate the 
  // parameter name...
  if(context.equalsIgnoreCase("document")){%>
  
  <input type="hidden" name="documentid" value="<%=opParam%>">
  <%}%>
</form>
</body>