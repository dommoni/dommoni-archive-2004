<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.HashMap" %>

<%@page import="com.dommoni.roundtable.Account" %>
<%@page import="com.dommoni.roundtable.Comment" %>
<%@page import="com.dommoni.roundtable.CustomField" %>
<%@page import="com.dommoni.roundtable.CustomFieldValueWrapperInt" %>
<%@page import="com.dommoni.roundtable.CustomFieldValueWrapperString" %>
<%@page import="com.dommoni.roundtable.NamedFieldCollection" %>
<%@page import="com.dommoni.roundtable.NotificationObjectRegistry" %>
<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>
<%@page import="com.dommoni.roundtable.Task" %>
<%@page import="com.dommoni.roundtable.projectServer.services.taskManager.ITaskManager" %>

<%@page import="com.dommoni.ece.webui.Operations" %>
<%@page import="com.dommoni.ece.webui.WebUIConfiguration" %>
<%@page import="com.dommoni.ece.webui.utils.DateFormatter" %>
<%@page import="com.dommoni.ece.webui.utils.StringUtils" %>

<%
	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
	Account account = (Account)session.getAttribute("useraccount");
	ITaskManager todoManager = psc.getTaskManager();
	int todoId = Integer.parseInt(request.getParameter("todoid"));
	
	// Get NOID for ToDo's
	String notificationObject = (String)NotificationObjectRegistry.getInstance().get(Task.class);
	
	Task todo = todoManager.getTask(todoId);
	
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
<script src="./includes/addCommentDlgPopup.js"></script>
<script src="./includes/deleteDlgPopup.js"></script>
</head>

<script>
function newTodoFolder()
{
   var newWin = open('projectTodosNewToDoFolder.jsp','','height=200,width=300,directories=no,location=no,menubar=no,resizable=no,scrollbars=no,status=no,toolbar=no,screenX=200,screenY=200,top=0,left=0');
}
</script>

<body>

	<div id="StatusBarContainer">
		<div id="Statusbar">
		 
    		<div id="StatusRight"> 
				<img src="images/spacer.gif" width="10" height="10"> 
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
	 	
		
	<h1>Task: <%=todo.getTitle()%></h1>
		
	 </div>

        
        <div class="Post">
        <!--ToDo's--> 
  	    <%
	    if(todo != null)
		{ 
		SimpleDateFormat dfDueDate = new SimpleDateFormat("MM/dd/yyyy");
		   %>
		   <P><b>Created By:</b> <%=psc.getAccountManager().getAccount(todo.getCreatedBy()).getName()%></P>
		   <P><b>Created On:</b> <%=DateFormatter.format(todo.getCreatedOn().getTime())%></P>
		   <P><b>Status:</b> <%if(todo.getCurrentStatus() != null){%><%=todo.getCurrentStatus().getTitle()%><%}else{%>UNKNOWN<%}%></P>
		   <P><b>Due Date:</b> <%
		   if(todo.getDueDate() != null)
		   {
		      %><%=dfDueDate.format(todo.getDueDate().getTime())%><%
		   } 
		   else 
		   {
		      %><%="not set."%><%
		   }%>
		   </p>
		   <%if(todo.getDescription() != null && todo.getDescription().length() > 0) {
		     %><p><b>Description:</b><br><%=todo.getDescription()%></p><%
		  }%>
		  
		  <%-- Custom Fields --%>
		  
		  <%-- Named Field Collections --%>
		  <% 
		  NamedFieldCollection[] fieldCollections = todo.getNamedFieldCollections();
		  if(fieldCollections != null && fieldCollections.length > 0)
		  {
		     for (int i = 0; i < fieldCollections.length; i++)
			 {
			    CustomField[] fields = fieldCollections[i].getFields();
				if (fields != null && fields.length > 0)
				{
					%>
					<br /> 
					<!--<p>-->
					<h2 class="date"><b><%=fieldCollections[i].getName()%></b></h2><%
					for (int i2 = 0; i2 < fields.length; i2++)
					{
						if (!fields[i2].getHidden())
						{
							%><p><b><%=fields[i2].getName()%>: </b><%
							if (fields[i2].getType() == CustomField.T_INTEGER)
							{
								%><%=((CustomFieldValueWrapperInt)fields[i2].getValueWrapper()).getValue()%><%
							}
							else if (fields[i2].getType() == CustomField.T_STRING)
							{
								%><%=((CustomFieldValueWrapperString)fields[i2].getValueWrapper()).getValue()%><%
							}
							else
							{
								%>Error: Unknown Data Type.<%
							}
							%></p><%
						}
					}
				}
			 }
		  }
		  %>
		  
	      <%
		  SimpleDateFormat sdf = new SimpleDateFormat("EEE, MMMMM d yyyy, hh:mm aaa");
		  Comment[] comments = psc.getTaskManager().getCommentsForTask(todo);
		  
		  if(comments != null && comments.length > 0)
		  {
		     
		     %><br><h2 class="date">Comments</h2><blockquote><%
			 
		     for(int i = 0; i < comments.length; i++)
			 {
			    String cb = ((Account)psc.getAccountManager().getAccount(comments[i].getCreatedBy())).getName();
			    %><p><%=comments[i].getComment()%><br>
              <I><font color="#cccccc">Posted by <%=cb%> <%=sdf.format(comments[i].getCreatedOn().getTime())%>.</font></I> 
              <%if(comments[i].getCreatedBy() == account.getId()) {%>
              <br><a href="#" onClick="showDelete('your comment','<%=Operations.DELETE_COMMENT%>','<%=comments[i].getId()%>','Comment','projectTodosViewTodo.jsp?todoid=<%=todo.getId()%>');"><font size="2">Delete My Comment</font></a> 
              <%}%>
            </p>
            <%
			 }
			 %></blockquote><%
		  }%>
		   
		   <%
		}
		else
		{
			%><p>There was a problem retrieving the selected Task.</P><%
		}
	%>
    </div>

</div>


<div class="Right">

<div class="Sidebar">        
    <h1>Operations</h1>
	<ul id="MTabs">
    	<jsp:include page="openProjectMenu.jsp" />	
		<% if(todo.getCreatedBy() == account.getId()) { %>
		<li><a href="./projectTodosModifyTodo.jsp?todoid=<%=todo.getId()%>">Modify Task</a></li>
		<li><a href="#" onClick="showDelete('<%=StringUtils.getJSString(todo.getTitle())%>','<%=Operations.DELETE_TODO%>','<%=todo.getId()%>','Task','projectTodos.jsp');">Delete Task</a></li>
		<%}%>
	<li><a href="#" onClick="addComment('<%=StringUtils.getJSString(todo.getName())%>','<%=todo.getId()%>','task','./<%=request.getServletPath()%>');">Add a Comment</a></li>
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

$Log: projectTodosViewTodo.jsp,v $
Revision 1.2  2005/10/16 15:14:49  brian
Changes for todo->task API renaming and support for NamedFieldCollections.


--%>