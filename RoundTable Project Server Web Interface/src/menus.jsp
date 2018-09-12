<%@page import="java.util.HashMap" %>
<%@page import="java.util.Vector" %>

<%@page import="com.dommoni.roundtable.Account" %>
<%@page import="com.dommoni.roundtable.AccountType" %>
<%@page import="com.dommoni.roundtable.Project" %>
<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>
<%@page import="com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager" %>

<%@page import="com.dommoni.ece.webui.MenuItem" %>
<%@page import="com.dommoni.ece.webui.Operations" %>
<%@page import="com.dommoni.ece.webui.menus.MenuItemMap" %>

<%
	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
	Project currentProject = (Project)session.getAttribute("currentproject");
	Account userAccount = (Account)session.getAttribute("useraccount");
	MenuItemMap menus = (MenuItemMap)session.getAttribute("menus");
%>

<%
	if(userAccount.getAccountType() == AccountType.SYSTEM_ADMINISTRATOR)
	{
		// draw admin menu
		// draw project menu
		Vector adminMenu = (Vector)menus.get("adminmenu");
		if(adminMenu != null)
		{
		    %><ul id="Tabs"><%
			for(int i = 0; i < adminMenu.size(); i++)
			{
				MenuItem mi = (MenuItem)adminMenu.get(i);
				if(mi.current)
				{
				   %><li><a href="./servlet/ControllerServlet?opcode=<%=Operations.HANDLE_MENU%>&mid=<%=mi.id%>" class="current"><%=mi.title%></a></li><%
				}
				else
				{
				   %><li><a href="./servlet/ControllerServlet?opcode=<%=Operations.HANDLE_MENU%>&mid=<%=mi.id%>"><%=mi.title%></a></li><%
				}
			}
			%></ul><%
		}
	}
	else if(userAccount.getAccountType() == AccountType.MANAGER)
	{
		// draw admin menu
		// draw project menu
		Vector managerMenu = (Vector)menus.get("managermenu");
		if(managerMenu != null)
		{
		    %><ul id="Tabs"><%
			for(int i = 0; i < managerMenu.size(); i++)
			{
				MenuItem mi = (MenuItem)managerMenu.get(i);
				if(mi.current)
				{
				   %><li><a href="./servlet/ControllerServlet?opcode=<%=Operations.HANDLE_MENU%>&mid=<%=mi.id%>" class="current"><%=mi.title%></a></li><%
				}
				else
				{
				   %><li><a href="./servlet/ControllerServlet?opcode=<%=Operations.HANDLE_MENU%>&mid=<%=mi.id%>"><%=mi.title%></a></li><%
				}
			}
			%></ul><%
		}
	}
	
	if(currentProject != null)
	{
		// draw project menu
		Vector mainMenu = (Vector)menus.get("mainmenu");
		if(mainMenu != null)
		{
		    %><ul id="Tabs"><%
			for(int i = 0; i < mainMenu.size(); i++)
			{
				MenuItem mi = (MenuItem)mainMenu.get(i);
				if(mi.current)
				{
				   %><li><a href="./servlet/ControllerServlet?opcode=<%=Operations.HANDLE_MENU%>&mid=<%=mi.id%>" class="current"><%=mi.title%></a></li><%
				}
				else
				{
				   %><li><a href="./servlet/ControllerServlet?opcode=<%=Operations.HANDLE_MENU%>&mid=<%=mi.id%>"><%=mi.title%></a></li><%
				}
			}
			%></ul><%
		}
	}
%>


