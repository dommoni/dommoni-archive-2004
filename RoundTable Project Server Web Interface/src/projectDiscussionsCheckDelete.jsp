<%@page import="com.dommoni.ece.webui.Operations" %>

<%
	String discussionId = request.getParameter("discussionId");
	String discussionName = request.getParameter("discussionName");
%>
<script language="JavaScript">
<!--
function MM_callJS(jsStr) { //v2.0
  return eval(jsStr)
}

function closeWindow()
{
	window.close();
}
//-->
</script>
<title>Delete Discussion?</title>


<h2 align="center"><font face="Arial, Helvetica, sans-serif">Delete Discussion?</font></h2>
<form name="form1" method="post" action="./servlet/ControllerServlet">
  <p align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#006699">Are 
    you sure you want to permanently remove<br>
    <b>"<%=discussionName%>"</b> from the system?</font></p>
  <p align="center"> 
    <input type="submit" name="Submit" value="Delete">
    <input type="button" name="Submit2" value="Cancel" onClick="MM_callJS('closeWindow()')">
    <input type="hidden" name="discussionId" value="<%=discussionId%>">
    <input type="hidden" name="discussionName" value="<%=discussionName%>">
	<input type="hidden" name="opcode" value="<%=Operations.DELETE_DISCUSSION%>">
  </p>
</form>

