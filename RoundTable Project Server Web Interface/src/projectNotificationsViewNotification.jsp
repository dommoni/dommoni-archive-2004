<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.HashMap" %>

<%@page import="com.dommoni.roundtable.Account" %>
<%@page import="com.dommoni.roundtable.Notification" %>
<%@page import="com.dommoni.roundtable.NotificationType" %>
<%@page import="com.dommoni.roundtable.Project" %>
<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>
<%@page import="com.dommoni.roundtable.projectServer.services.notificationManager.INotificationManager" %>

<%@page import="com.dommoni.ece.webui.Operations" %>
<%@page import="com.dommoni.ece.webui.notifications.NotificationUtils" %>
<%@page import="com.dommoni.ece.webui.WebUIConfiguration" %>

<%
// notification for User/Project/Object
	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
	
	Account account = (Account)session.getAttribute("useraccount");
	Project project = (Project)session.getAttribute("currentproject");
	
	int notificationId = Integer.parseInt(request.getParameter("notificationid"));
	
	INotificationManager notificationManager = psc.getNotificationManager();
	Notification notification = notificationManager.getNotification(notificationId);
	
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
<script src="./includes/deleteDlgPopup.js"></script>
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
	 	
	<h1>Notifications</h1>
		
	 </div>

        
        <div class="Post"> 
  	<%
	    if(notification != null)
	    {
	        SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMMM d yyyy, hh:mm aaa");
	        %>
		<p><b>Name:</b> <%=notification.getName()%></p>
                <p><b>Context:</b> <%=notification.getContext()%></p>
                <p><b>Created On:</b> <%=sdf.format(notification.getCreatedOn().getTime())%></p>
		
		<%if(notification.getType() == NotificationType.USER) 
		{
		   %><p><b>Type:</b> User Oriented Notification</p><% 
		} 
		else if(notification.getType() == NotificationType.OBJECT) 
		{
		   %><p><b>Type:</b> Object Oriented Notification</p><%
		}
   		
		if(notification.getOperation() == Notification.CREATE_OPERATION) 
		{
		   %><p><b>Operation:</b> Create</p><%
		}
                else if(notification.getOperation() == Notification.MODIFICATION_OPERATION) 
		{
		   %><p><b>Operation:</b> Modify</p><%
		}
                else if(notification.getOperation() == Notification.DELETION_OPERATION) 
		{
		   %><p><b>Operation:</b> Delete</p><%
		}
                //if(notification.getOperation() == Notification.RETREIVAL_OPERATION) {}// not implemented.
                else if(notification.getOperation() == Notification.ANY_OPERATION) 
		{
		   %><p><b>Operation:</b> Any Operation</p><%
		}
            }
	%>
    </div>

</div>


<div class="Right">

<div class="Sidebar">        
    <h1>Operations</h1>
	<ul id="MTabs">
    	<jsp:include page="openProjectMenu.jsp" />
        <%if(notification.getCreatedBy() == account.getId())
	{
	   %>
	   <!--<li><a href="./projectNotificationsModifyNotification.jsp?notificationid=<%=notification.getId()%>&respath=<%=request.getServletPath()%>">Modify Notification</a></li>-->
	   <li><a href="#" onClick="showDelete('Notification','<%=Operations.DELETE_NOTIFICATION%>','<%=notification.getId()%>','Notification','projectNotificationsViewNotification.jsp');">Delete Notification</a></li>
	   <%
	}%>	
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


