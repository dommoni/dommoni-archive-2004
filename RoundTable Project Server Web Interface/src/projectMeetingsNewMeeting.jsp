<%@page import="java.util.HashMap" %>
<%@page import="java.util.Vector" %>

<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>
<%@page import="com.dommoni.roundtable.Account" %>
<%@page import="com.dommoni.roundtable.AccountType" %>
<%@page import="com.dommoni.roundtable.Project" %>

<%@page import="com.dommoni.roundtable.projectServer.services.accountManager.IAccountManager" %>
<%@page import="com.dommoni.roundtable.projectServer.services.projectManager.IProjectManager" %>

<%@page import="com.dommoni.ece.webui.MenuItem" %>
<%@page import="com.dommoni.ece.webui.Operations" %>
<%@page import="com.dommoni.ece.webui.WebUIConfiguration" %>

<%
	ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
	Project currentProject = (Project)session.getAttribute("currentproject");
	Account account = (Account)session.getAttribute("useraccount");
	
	IAccountManager accountManager = psc.getAccountManager();
	Account accounts[] = accountManager.getAllAccountsForProject(currentProject.getId());
	
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
<!--<script language="JavaScript" src="includes/membersList.js">
-->
<script language="JavaScript">
<!--
function MM_callJS(jsStr) { //v2.0
  return eval(jsStr)
}

function setDate(newDate,field) 
{
   if(field == "startTime")
   {  
      document.form1.starttime.value = newDate;   
   }
   if(field == "endTime")
   {   
      document.form1.endtime.value = newDate;
   }	
}

function openStartWindow() { 
	myWindow = open('calendar_popup.jsp?field=startTime','newWin','width=370,height=360,left=200,top=300,status=yes');
	//myWindow.location.href = 'calendar_popup.jsp';
	if (myWindow.opener == null) myWindow.opener = self;
}

function openEndWindow() { 
	myWindow = open('calendar_popup.jsp?field=endTime','newWin','width=370,height=360,left=200,top=300,status=yes');
	//myWindow.location.href = 'calendar_popup.jsp';
	if (myWindow.opener == null) myWindow.opener = self;
}

allKeys = new Array();
function move(fbox, tbox, rightBoxName) 
{
	var arrFbox = new Array();
	var arrTbox = new Array();
	var arrLookup = new Array();
	var returnArray = new Array();
	
	var i;
	for (i = 0; i < tbox.options.length; i++) 
	{
		arrLookup[tbox.options[i].text] = tbox.options[i].value;<!-- id or name of the given option in the select box -->
		arrTbox[i] = tbox.options[i].text;<!-- text of field (what is being shown) -->
	}
	
	var fLength = 0;
	var tLength = arrTbox.length;
	for(i = 0; i < fbox.options.length; i++) 
	{
		arrLookup[fbox.options[i].text] = fbox.options[i].value;
		if (fbox.options[i].selected && fbox.options[i].value != "") 
		{
			arrTbox[tLength] = fbox.options[i].text;
			tLength++;
		}
		else 
		{
			arrFbox[fLength] = fbox.options[i].text;
			fLength++;
   	        }	
	}
	
	arrFbox.sort();
	arrTbox.sort();
	fbox.length = 0;  <!-- reset the fbox and the tbox -->
	tbox.length = 0;  <!-- reset the fbox and the tbox -->
	var c;
	var no;
	for(c = 0; c < arrFbox.length; c++) 
	{
		no = new Option(); <!-- create a new option to insert into fBox -->
		no.value = arrLookup[arrFbox[c]]; <!-- this returns the id -->
		no.text = arrFbox[c];				<!-- this sets the value -->
		fbox[c] = no;
	}
	for(c = 0; c < arrTbox.length; c++) 
	{
		no = new Option();
		no.value = arrLookup[arrTbox[c]];
		no.text = arrTbox[c];
		tbox[c] = no;
  	}
	
	//update the return array
	returnArray.length = 0;  <!-- reset the array -->
	var rightBox;
	
	if(rightBoxName == "tbox") 
	{
		rightBox=tbox;
	}
	else 
	{
		rightBox = fbox;
	}
	
	for (i = 0; i < rightBox.length; i++) 
	{
		var position = arrLookup[rightBox.options[i].text];
		returnArray[returnArray.length] = allKeys[position];
	}
}

function moveAll(fbox, tbox) 
{
	for (x = 0; x < fbox.options.length; x++)
	{
		var newOption = new Option();
		newOption.value = fbox.options[x].value;
		newOption.text = fbox.options[x].text;
		tbox.add(newOption);
	}
	fbox.length = 0;
	tbox.options = tbox.options.sort();
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
	 	
		
	      <h1>New Meeting</h1>
		
	 </div>

        
        <div class="Post">
          <form name="form1" method="post" action="./servlet/ControllerServlet">
            <p><b>Title:</b> 
              <input type="text" name="title">
            </p>
            <p>  
	      <b>Start-Time:</b> 
              <input type="text" name="starttime">
              <a href="javascript:;" onClick="MM_callJS('openStartWindow()')"><img src="images/icon_calendar.gif" width="22" height="21" align="absbottom" border="0"></a>
	    </p>
	    <p>  
	      <b>End-Time:</b> 
              <input type="text" name="endtime">
              <a href="javascript:;" onClick="MM_callJS('openEndWindow()')"><img src="images/icon_calendar.gif" width="22" height="21" align="absbottom" border="0"></a>
	    </p>
            <p>
	      <b>Attendees:</b>
            <table border="0" cellspacing="0" cellpadding="0" align="left">
              <!-- this starts the ugly looking table thing -->
              <tr> 
                <td colspan="2" height="153"> 
                  <table border="0" cellspacing="0" cellpadding="0">
                    <tr> 
                      <td align="center" width="200"> 
                        <table width="135" border="0" cellspacing="0" cellpadding="0">
                          <tr bgcolor="#000099"> 
                            <td height="10" width="135" align="center"> <b><font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">Available 
                              Members</font></b></td>
                          </tr>
                          <tr> 
                            <td width="135" align="center"> 
                              <select multiple size="7" name="list1" align="center" style="width:125px">
                                <%
					   if(accounts != null)
					   {
					      for(int i = 0; i < accounts.length; i++)
					      {
                                                 if(accounts[i].getId() != account.getId()) // dont want organizer to invite themselves.
				                 {
					            %><option value="<%=accounts[i].getId()%>"><%=accounts[i].getName()%></option><%
						 }
					      }
					   }
					%>
                              </select>
                            </td>
                          </tr>
                        </table>
                      </td>
                      <td width="30" align="center"> 
                        <table width="30" border="0" cellspacing="0" cellpadding="0">
                          <tr> 
                            <td> 
                              <input type="button" onClick='move(list1, list2, "tbox")' value=" > " name="button">
                            </td>
                          </tr>
                          <tr> 
                            <td> 
                              <input type="button" onClick='moveAll(list1, list2)' value=">>" name="button">
                            </td>
                          </tr>
                          <tr> 
                            <td> 
                              <input type="button" onClick='move(list2, list1, "fbox")' value=" < " name="button">
                            </td>
                          </tr>
                          <tr> 
                            <td> 
                              <input type="button" onClick='moveAll(list2, list1)' value="<<" name="button">
                            </td>
                          </tr>
                        </table>
                      </td>
                      <td width="175" align="center"> 
                        <table width="135" border="0" cellspacing="0" cellpadding="0">
                          <tr bgcolor="#000099"> 
                            <td height="10" width="135" align="center"><font size="2"><b><font color="#000000" face="Verdana, Arial, Helvetica, sans-serif">Selected 
                              Members</font></b></font></td>
                          </tr>
                          <tr> 
                            <td width="135" align="center"> 
                              <select multiple size="7" name="list2" align="center" style="width:125px">
                              </select>
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <!-- <p> 
              <input type="checkbox" name="sendinvitation" value="yes">
              <b>Send an invitation to Attendees?</b></p>
            <p><b>Meeting Agenda:</b><br>
              <input type="text" name="agendaItem1" value="">
              <br>
              <input type="text" name="agendaItem2">
              <br>
              <input type="text" name="agendaItem3">
              <br>
              <input type="text" name="agendaItem4">
              <br>
            
	     <a href="javascript:;">More Agenda Items</a></p>
            -->
	    <p><b>Description:</b><br>
              <textarea name="description" rows="8" cols="40"></textarea>
            </p>
            <p>&nbsp;</p>
            <p>&nbsp;</p>
            <p> 
              <input type="submit" name="Submit" value="Create Meeting">
              <input type="button" name="Submit2" value="Cancel" onClick="MM_callJS('window.history.go(-1)')">
              <input type="hidden" name="opcode" value="<%=Operations.CREATE_MEETING%>">
            </p>
        </form>
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
          <p>&nbsp;</p>
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
