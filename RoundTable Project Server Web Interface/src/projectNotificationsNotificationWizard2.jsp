<%@page import="java.util.HashMap" %>

<%@page import="com.dommoni.roundtable.Account" %>
<%@page import="com.dommoni.roundtable.NotificationContext" %>
<%@page import="com.dommoni.roundtable.NotificationContextObject" %>
<%@page import="com.dommoni.roundtable.Project" %>
<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>

<%@page import="com.dommoni.ece.webui.Operations" %>
<%@page import="com.dommoni.ece.webui.WebUIConfiguration" %>

<%
	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
	Project currentProject = (Project)session.getAttribute("currentproject");
	Account account = (Account)session.getAttribute("useraccount");
	
	String nc = null;
	if(request.getParameter("nc") != null && request.getParameter("nc").length() > 0)
		nc = request.getParameter("nc");
	
	HashMap pagelinks = (HashMap)WebUIConfiguration.getInstance().get("pagelinks");
	HashMap texts = (HashMap)WebUIConfiguration.getInstance().get("texts");
	
	// nc objects (this is terrible that i'm doing it this way!!!)
	NotificationContextObject ncObjects[] = null;
	if (nc != null)
	{
		
		if(nc.equals(NotificationContext.DOCUMENT_CONTEXT))
		{
			ncObjects = psc.getDocumentManager().getAllDocumentsForProject(currentProject.getId());
		}
		else if(nc.equals(NotificationContext.FORUM_CONTEXT))
		{
			ncObjects = psc.getForumManager().getAllForumsForProject(currentProject.getId());
		}
		//------
		else if(nc.equals(NotificationContext.TASK_CONTEXT))
		{
			ncObjects = psc.getTaskManager().getAllTasksForProject(currentProject.getId());
		}
		else if(nc.equals(NotificationContext.MEETING_CONTEXT))
		{
			ncObjects = psc.getMeetingManager().getAllMeetingsForProject(currentProject.getId());
		}
		else if(nc.equals(NotificationContext.DISCUSSION_CONTEXT))
		{
			ncObjects = psc.getDiscussionManager().getAllDiscussionsForProject(currentProject.getId());
		}
		else if(nc.equals(NotificationContext.SCHEDULE_CONTEXT))
		{
		    ncObjects = psc.getScheduleManager().getAllSchedulesForProject(currentProject.getId());
		}
    }		
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

<script language="JavaScript">
<!--
function MM_callJS(jsStr) { //v2.0
  return eval(jsStr)
}

function loadOps()
{
   if(document.form2.object.value != 'all')
   {   
      document.form2.operation.options.remove(3);// = null;
	  document.form2.operation.options.remove(2);//[1] = null;
	  document.form2.operation.options.remove(1);//[2] = null;
	  document.form2.operation.options.remove(0);//[3] = null;
      
	  document.form2.operation.options[0] = new Option("Modify", "modify");
	  document.form2.operation.options[1] = new Option("Delete", "delete"); 
   }
   else
   {
      document.form2.operation.options.remove(1);//[2] = null;
	  document.form2.operation.options.remove(0);//[3] = null;
	  
	  document.form2.operation.options[0] = new Option("All", "all");
	  document.form2.operation.options[1] = new Option("Create", "create");
	  document.form2.operation.options[2] = new Option("Modify", "modify");
	  document.form2.operation.options[3] = new Option("Delete", "delete"); 
   }
}
//-->
</script>
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
          <%
	String ncName = nc.toLowerCase();
	char[] ncChars = ncName.toCharArray();
	ncChars[0] = Character.toUpperCase(ncName.charAt(0));
	ncName = new String(ncChars); 
	%>
          <h1>New <%=ncName%> Notification</h1>
        </div>
        <div class="Post"> 
          <!-- PAGE TEXT GOES HERE -->
          <%
String typeStr = request.getParameter("type");

if(typeStr != null && typeStr.equals("object"))
{
   // select the object, operation
   %>
          <form name="form2" method="post" action="./servlet/ControllerServlet">
            <blockquote>
              <p><font face="Arial, Helvetica, sans-serif" size="3" color="#000000">Select 
                the object and operation:</font> </p>
              <blockquote>
                <p><font face="Arial, Helvetica, sans-serif">Object:</font> 
                  <select name="object" STYLE="width: 175px" onChange="MM_callJS('loadOps()')">
                    <option value="all">All</option>
                    <%
					if (ncObjects != null && ncObjects.length > 0)
					{
						for(int i = 0; i < ncObjects.length; i++)
						{
							%><option value="<%=ncObjects[i].getId()%>"><%=ncObjects[i].getName()%></option><% 
						}
					}
					%>
					
                  </select>
                </p>
                <p><font face="Arial, Helvetica, sans-serif">Operation:</font> 
                  <select name="operation">
                    <option value="all">All</option>
                    <option value="create">Create</option>
                    <option value="modify">Modify</option>
                    <option value="delete">Delete</option>
                  </select>
                </p>
                <p> 
                  <input type="submit" name="Submit" value="Done">
                  <input type="button" name="Submit2" value="Cancel" onClick="MM_callJS('window.history.go(-1)')">
				  <input type="hidden" name="opcode" value="<%=Operations.CREATE_NOTIFICATION%>">
				  <input type="hidden" name="nc" value="<%=nc%>">
				  <input type="hidden" name="path" value="<%=request.getParameter("path")%>">
				  
                  <%
	if(request.getParameter("user") != null)
	{
	   %>
                  <input type="hidden" name="user" value=<%=request.getParameter("user")%>>
                  <input type="hidden" name="type" value="user">
                  <%
	}
	else
	{
	   %>
                  <input type="hidden" name="type" value="object">
                  <%
	}
	%>
                </p>
              </blockquote>
            </blockquote>
          </form>
          <%
}
else if(typeStr != null && typeStr.equals("user"))
{
   %>
          <form name="form1" method="get" action="projectNotificationsNotificationWizard2.jsp">
            <blockquote>
              <p><font face="Arial, Helvetica, sans-serif">User:</font> 
                <select name="user" STYLE="width: 175px">
                  <!-- TODO: write out all members that are part of the proj -->
                  <%
				  Account projectAccounts[] = psc.getAccountManager().getAllAccountsForProject(currentProject.getId());
				  for(int i = 0; i < projectAccounts.length; i++)
				  {
				  	 if(projectAccounts[i].getId() != account.getId())
					 {	
					    %><option value="<%=projectAccounts[i].getId()%>"><%=projectAccounts[i].getName()%></option><%
					 }
				  }	
				  %>
				  
                </select>
              </p>
              <p> 
                <input type="submit" name="Submit" value="Next">
                <input type="button" name="Button" value="Cancel">
                <input type="hidden" name="type" value="object">
				<input type="hidden" name="nc" value="<%=nc%>">
				<input type="hidden" name="path" value="<%=request.getParameter("path")%>">
              </p>
            </blockquote>
          </form>
          <%
}
%>
        </div>
      </div>
      <div class="Right"> 
        <div class="Sidebar"> 
          <h1>Operations</h1>
          <ul id="MTabs">
            <jsp:include page="openProjectMenu.jsp" />
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
<%--

$Log: projectNotificationsNotificationWizard2.jsp,v $
Revision 1.2  2005/10/17 01:32:16  brian
Initial Revision.


--%>