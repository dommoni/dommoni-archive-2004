<%--
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/extensions" prefix="x"%>--%>

<%@page import="java.util.HashMap" %>

<%@page import="com.dommoni.roundtable.Account" %>
<%@page import="com.dommoni.roundtable.Flags" %>
<%@page import="com.dommoni.roundtable.Project" %>
<%@page import="com.dommoni.roundtable.TaskStatus" %>
<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>

<%@page import="com.dommoni.ece.webui.Operations" %>
<%@page import="com.dommoni.ece.webui.WebUIConfiguration" %>

<%
	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
	Project currentProject = (Project)session.getAttribute("currentproject");
	Account account = (Account)session.getAttribute("useraccount");

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
<script language="JavaScript">
<!--
function MM_callJS(jsStr) { //v2.0
  return eval(jsStr)
}

function setDate(newDate,field) 
{
   //if(field == "startTime")
   //{  
      document.form1.duedate.value = newDate;   
   //}
   //if(field == "endTime")
   //{   
      //document.form1.endtime.value = newDate;
   //}	
}

function openStartWindow() { 
	myWindow = open('calendar_popup.jsp?field=startTime','newWin','width=370,height=360,left=200,top=300,status=yes');
	//myWindow.location.href = 'calendar_popup.jsp';
	if (myWindow.opener == null) myWindow.opener = self;
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
	 	
		
	<h1>New Task</h1>
		

        
        <div class="Post">
  <!--New ToDo: --> 
		  <form name="form1" method="post" action="./servlet/ControllerServlet">
              <p>Title: 
                <input type="text" name="title">
              </p>
              <p>Flag: 
                <select name="flag">
                  <%
				   for(int i = 0; i < Flags.flags.length; i++)
				   {
				      %>
                  <option value="<%=Flags.flags[i].id%>"><%=Flags.flags[i].name%></option>
                  <%
				   }
				   %>
                </select>
                
              </p>
              <p>Status: 
			  <%
			  TaskStatus status[] = psc.getTaskManager().getAllTaskStatusForProject(currentProject.getId());
			  if(status != null && status.length > 0)
			  {
			  %>
			  <select name="status">
			     <% for(int i = 0; i < status.length; i++)
				 {
				    %><option value="<%=status[i].getId()%>"><%=status[i].getTitle()%></option><%
				 }
				 %>
			  </select>
			  <%} else {%>Currently Unavailable.<%}%>
			  </p>
			  <p>
			  <%--<x:inputDate popupCalendar="true" />--%>
			  </p>
              <p>Due Date: 
                <input type="text" name="duedate">
                <a href="javascript:;" onClick="MM_callJS('openStartWindow()')"><img src="images/icon_calendar.gif" width="22" height="21" align="absmiddle" border="0"></a></p>
              <p>Make Private: <input type="checkbox" name="isprivate" value="yes"></p>
	      
	      <p>Description:<br>
                <textarea name="description" rows="10" cols="50"></textarea>
              </p>
              <p> 
              <input type="submit" name="Submit" value="Create">
              <input type="button" name="Submit2" value="Cancel" onClick="MM_callJS('window.history.go(-1)')">
              <input type="hidden" name="opcode" value="<%=Operations.CREATE_TODO%>">
            </p>
          </form>
	 </div>
    </div>

</div>


<div class="Right">

<div class="Sidebar">        
    <h1>Operations</h1>
	<ul id="MTabs">
    	<jsp:include page="openProjectMenu.jsp" />	
  
	</ul>
          <p>&nbsp;</p>
          <p>&nbsp;</p>
          <p>&nbsp;</p>
          <br/>
            <br/>
          
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

$Log: projectTodosNewToDo.jsp,v $
Revision 1.2  2005/10/17 01:44:53  brian
Changes for RoundTable API renaming.

--%>