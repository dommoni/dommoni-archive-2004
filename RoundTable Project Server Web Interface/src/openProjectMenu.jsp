<%@page import="com.dommoni.roundtable.Project" %>
<%@page import="com.dommoni.ece.webui.Operations" %>

<%
	Project currentProject = (Project)session.getAttribute("currentproject");
%>

<%
if(currentProject == null)
{
   %><li><a href="selectProjects.jsp">Open a Project</a></li><%
}
else
{
   %><li><a href="./servlet/ControllerServlet?opcode=<%=Operations.CLOSE_PROJECT%>">Close Project</a></li><%
}
%>