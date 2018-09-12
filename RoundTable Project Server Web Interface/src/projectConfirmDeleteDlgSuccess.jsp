
<%
    String objectName = request.getParameter("name");
	String opCode = request.getParameter("opcode");
	String opParam = request.getParameter("opparam");
	String context = request.getParameter("context");
%>
<html>
<head><title>Delete <%=context%></title>
<script language="JavaScript">
window.opener.location = '<%=request.getParameter("parentlink")%>';
window.close();
</script>
</head>
<body bgcolor="#FFFFFF">
</body>