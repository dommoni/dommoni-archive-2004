<%@page import="java.util.HashMap" %>

<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>
<%@page import="com.dommoni.roundtable.Account" %>
<%@page import="com.dommoni.roundtable.AccountType" %>
<%@page import="com.dommoni.roundtable.Announcement" %>
<%@page import="com.dommoni.roundtable.Project" %>
<%@page import="com.dommoni.roundtable.RecentChange" %>
<%@page import="com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager" %>

<%@page import="com.dommoni.ece.webui.WebUIConfiguration" %>
<%@page import="com.dommoni.ece.webui.utils.AnnouncementSorter" %>
<%@page import="com.dommoni.ece.webui.utils.RecentChangeSorter" %>

<%
	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
	Project currentProject = (Project)session.getAttribute("currentproject");
	Account account = (Account)session.getAttribute("useraccount");
	
	Announcement[] announcements = psc.getAnnouncementManager().getAllAnnouncementsForProject(currentProject.getId());
	RecentChange[] recentChanges = psc.getRecentChangesManager().getRecentChangesForProject(currentProject.getId());
	
	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
       "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
    <meta http-equiv="content-type" content="text/html;charset=iso-8859-1" />
	 <title><%=texts.get("title")%></title>
    <link rel="Stylesheet" href="./includes/screen_v1-0-3.css" type="text/css" media="screen" />

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
<script src="./includes/viewAnnouncementDlgPopup.js"></script>
<script src="./includes/addAnnouncementDlgPopup.js"></script>
</head>

<body>
<div id="StatusBarContainer"> <div id="Statusbar"> <div id="StatusRight"> <img src="images/spacer.gif" width="10" height="10"> 
</div></div></div><div class="Shadow" id="Shadow"> <div class="Container"> <div id="Header"> 
<jsp:include page="header.jsp" /> <jsp:include page="menus.jsp" /> </div><div id="ContentFrame"> 
<div class="Left"> <div class="SectionHeader"> 
<h1>Welcome <%=account.getName()%></h1></div><!-- <blockquote> --> 

<div class="Post">
<h2 class="date">Announcements</h2><%
	 try {
		 
		 if(announcements != null && announcements.length > 0)
		 {
		    AnnouncementSorter asorter = new AnnouncementSorter();
		    Announcement anSorted[] = asorter.sort(announcements, 5);
		    %><!--<blockquote>--><ul><%
			for(int i = 0; i < anSorted.length; i++)
			{
			   try
			   {
			      %><li><a href="#" onClick="viewAnnouncement(<%=anSorted[i].getId()%>);"><FONT FACE="Verdana, Arial, Helvetica, sans-serif"><%=anSorted[i].getTitle()%></FONT></a></li><%
			   } catch(Exception e)
			   {
			      e.printStackTrace();
			   }
			}
			%></ul><!--</blockquote>--><%
		 }
		 else
		 {
			%><p>No announcements currently exist for this project.</P><%
		 }
	 }
	 catch(Exception e)
	 {
	    %><p><font color="#FF0000">An error occured while processing the recent-changes request.</font></p><%
	    e.printStackTrace();
	 }
	 %><p>&nbsp;</p> 
	 <h2 class="date">Recent Changes</h2><%
	 try {
		 RecentChangeSorter rcs = new RecentChangeSorter();
		 RecentChange changes[] = rcs.sort(recentChanges, 5);
		 if(changes != null && changes.length > 0)
		 {
		    %><blockquote><%
			for(int i = 0; i < changes.length; i++)
			{
			   try
			   {
			      %><p><%=changes[i].getChangeMessage()%></p><%
			   } catch(Exception e)
			   {
			      e.printStackTrace();
			   }
			}
			%></blockquote><%
		 }
		 else
		 {
			%><p>No recent-changes currently exist for this project.</P><%
		 }
	 }
	 catch(Exception e)
	 {
	    %><p><font color="#FF0000">An error occured while processing the recent-changes request.</font></p>
	    <%
	    e.printStackTrace();
	 }
	 %> 
	 </div>
</div>
<div class="Right"> <div class="Sidebar"> 
<h1>Operations</h1>
  <ul id="MTabs"> 
   <jsp:include page="openProjectMenu.jsp" />
   <li><a href="#" onClick="newAnnouncement();">New Announcement</a></li>
   <li><a href="./projectNotificationsViewNotifications.jsp">My Notifications</a></li>
  </ul>
  <br/> 
  <br/> <P>&nbsp;</P></div></div></div></div><div class="ShadowCap">&nbsp;</div></div>
  <div id="Footer">Copyright &copy; 2004 Dommoni Corporation.</div>


</body>
</html>
