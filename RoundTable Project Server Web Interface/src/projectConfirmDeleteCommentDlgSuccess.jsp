
<%
    String parentLink = request.getParameter("parentlink");
    //String param = request.getParameter("param");
	//String paramLabel = request.getParameter("paramlabel");

	//String retLink = parentLink + "?" + paramLabel + "=" + param;
%>
<html>
<head><title>Add Comment</title>
<script language="JavaScript">
// make the parent refresh and close this window.
window.opener.location = '<%=parentLink%>';
window.close();
</script>
</head>
<body bgcolor="#FFFFFF">
</body>