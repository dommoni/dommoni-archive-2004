<%@page import="java.util.HashMap" %>
<%@page import="java.util.Vector" %>

<%@page import="com.dommoni.roundtable.Account" %>
<%@page import="com.dommoni.roundtable.NotificationContext" %>
<%@page import="com.dommoni.roundtable.Project" %>
<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>
<%@page import="com.dommoni.roundtable.Schedule" %>

<%@page import="com.dommoni.roundtable.projectServer.services.scheduleManager.IScheduleManager" %>
<%@page import="com.dommoni.roundtable.projectServer.services.systemManager.ISystemManager" %>

<%@page import="com.dommoni.ece.webui.WebUIConfiguration" %>
<%@page import="com.dommoni.ece.webui.utils.StringUtils" %>

<%
	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
	Project currentProject = (Project)session.getAttribute("currentproject");
	Account account = (Account)session.getAttribute("useraccount");
	
	String serverIp = "0.0.0.0";
	int serverPort = 0;
	ISystemManager systemManager = psc.getSystemManager();
	if (systemManager != null)
	{	
		serverIp = systemManager.getServerIpAddr();
		serverPort = systemManager.getServerPort();
	}
	
	Schedule[] schedules = null;
	if (currentProject != null)
	{
		IScheduleManager scheduleManager = psc.getScheduleManager();
		schedules = scheduleManager.getAllSchedulesForProject(currentProject.getId());
	}
	
	String editScheduleId = request.getParameter("editschedule");
	String origPath = request.getParameter("originalpath"); // This should fully close out the applet by reseting it to this on close.
	if (editScheduleId != null)
	{
	   String sscResources = (String)WebUIConfiguration.getInstance().get("ssc_path");
	   %>
	   <!--<APPLET ARCHIVE="sslib/SharedSchedulingClient.jar,sslib/ProjectServerAPI.jar,sslib/looks-1.3.1.jar,sslib/forms-1.0.5.jar,sslib/axis.jar,sslib/commons-discovery-0.2.jar,sslib/commons-logging-1.0.4.jar,sslib/jaxrpc.jar,sslib/log4j-1.2.8.jar,sslib/saaj.jar,sslib/wsdl4j-1.5.1.jar" 
          CODE=com.dommoni.roundtable.is.ISClientApplet.class WIDTH = "0" HEIGHT = "0">
          <PARAM NAME="currentproject" VALUE="<%=currentProject.getId()%>" >
          <PARAM NAME="username" VALUE ="<%=account.getUsername()%>" >
          <PARAM NAME="password" VALUE = "<%=account.getPassword()%>" >
          <PARAM NAME="scheduleid" VALUE = "<%=editScheduleId%>" >
		  <PARAM NAME="ipaddr" VALUE = "<%=serverIp%>" >
		  <PARAM NAME="port" VALUE = "<%=serverPort%>" >
       </APPLET>-->

	
	
	
	<object
    classid = "clsid:8AD9C840-044E-11D1-B3E9-00805F499D93"
    codebase = "http://java.sun.com/update/1.5.0/jinstall-1_5-windows-i586.cab#Version=5,0,0,5"
    WIDTH = "0" HEIGHT = "0" >
    <PARAM NAME = CODE VALUE = com.dommoni.roundtable.is.ISClientApplet.class >

    <PARAM NAME = ARCHIVE VALUE = "<%=sscResources%>" >
    <param name = "type" value = "application/x-java-applet;version=1.5">
    <param name = "scriptable" value = "false">
	
    <PARAM NAME = "currentproject" VALUE="<%=currentProject.getId()%>" >
    <PARAM NAME = "username" VALUE ="<%=account.getUsername()%>" >
    <PARAM NAME = "password" VALUE = "<%=account.getPassword()%>" >
    <PARAM NAME = "scheduleid" VALUE = "<%=editScheduleId%>" >
    <PARAM NAME = "ipaddr" VALUE = "<%=serverIp%>" >
    <PARAM NAME = "port" VALUE = "<%=serverPort%>" >
	<PARAM NAME = "parentpath" VALUE = "<%=origPath%>" >

    <comment>
	<embed
            type = "application/x-java-applet;version=1.5" \
            CODE = com.dommoni.roundtable.is.ISClientApplet.class \
            ARCHIVE = "<%=sscResources%>" \
            WIDTH = "0" \
            HEIGHT = "0" \
            currentproject ="<%=currentProject.getId()%>" \
            username ="<%=account.getUsername()%>" \
            password = "<%=account.getPassword()%>" \
            scheduleid = "<%=editScheduleId%>" \
            ipaddr = "<%=serverIp%>" \
            port = "<%=serverPort%>" \
			parentpath = "<%=origPath%>"
	    scriptable = false
	    pluginspage = "http://java.sun.com/products/plugin/index.html#download">
	    <noembed>
        </noembed>
	</embed>
    </comment>
</object>
	
	
	
	   <%
	}
	
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
</head>

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
	 	
		
	<h1>Schedules</h1>
		
	 </div>

        
        <div class="Post">
  <!-- Documents --> 
	    <%
		if (schedules != null && schedules.length > 0)
		{
		    %><table border="0" cellspacing="3" cellpadding="6"><%
			
			for (int i = 0; i < schedules.length; i++)
			{
				%><tr>
				    <td width="225"><font face="Verdana, Arial, Helvetica, sans-serif"><a href="./projectSchedulesViewSchedule.jsp?scheduleid=<%=schedules[i].getId()%>"><%=schedules[i].getName()%></a></font></td>
					<td><a href="./projectSchedules.jsp?editschedule=<%=schedules[i].getId()%>&originalpath=<%=request.getRequestURL()%>">Edit</a></td>
				  </tr><%
			}
			%></table><%
		}
		%>
        </div>

</div>


<div class="Right">

<div class="Sidebar">        
    <h1>Operations</h1>
	<ul id="MTabs">
    	<jsp:include page="openProjectMenu.jsp" />
		<li><a href="projectSchedulesNewSchedule.jsp">New Schedule</a></li>
		<li><a href="projectNotificationsNotificationWizard.jsp?nc=<%=NotificationContext.SCHEDULE_CONTEXT%>&path=<%=request.getServletPath()%>">New Notification</a></li>
	</ul>
     <br/>
    <br/>    
	<p>&nbsp;</p>
</div>


</div>

</div>
</div>

<div class="ShadowCap">&nbsp;</div>
</div>


<div id="Footer">Copyright &copy; 2004 Dommoni Corporation.</div>


</body>
</html>
<%--
*
* $Log: projectSchedules.jsp,v $
* Revision 1.1  2005/10/17 01:30:05  brian
* Initial Revision.
*
*
--%>