<%@ page import="java.util.Enumeration" %>
<%
   String fieldName = request.getParameter("field");
   if(fieldName == null)
      System.out.println("FIELD PARAM WAS NULL!"); 
%>
<html>
<head>
<title>Select Date/Time</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">

<script language="JavaScript">
<!--
var dateBoxId;

var theDate = "";

var theYear = "";
var theMonth = "";
var theDay = "";

function init() 
{	
	theDate = new Date();
	
	theYear = theDate.getFullYear();
	theMonth = makeTwoDigit((theDate.getMonth() + 1));
	theDay = makeTwoDigit(theDate.getDate());

	fillMonth();
	fillDay();
	fillYear();
}

//Fill the month select box
function fillMonth() {
	monthArray = new Array('January', 'February', 'March', 'April', 'May', 'June',
                           'July', 'August', 'September', 'October', 'November', 'December');
	var m = "";
	for(i = 0; i < 12; i++) 
    {
		m = makeTwoDigit(i + 1);
		if (m == theMonth) 
	    {
			document.theForm.dateMonth.options[i] = new Option(monthArray[i], m, false, true);
		}
		else 
	    {
			document.theForm.dateMonth.options[i] = new Option(monthArray[i], m, false, false);
		}	
	}
}

//Fill the day select box
function fillDay() 
{
	var d = "";
	for(i = 0; i < getDayCount(); i++) 
    {
		d = makeTwoDigit(i+1);
		if (d == theDay) 
	    {
			document.theForm.dateDay.options[i] = new Option(d, d, false, true);
		}
		else 
	    {
			document.theForm.dateDay.options[i] = new Option(d, d, false, false);
		}
	}
}

//Fill the day select box
function fillYear() 
{
	yearArray = new Array('2001','2002','2003','2004','2005');
	for (i = 0; i < yearArray.length; i++) 
    {
		if (yearArray[i] == theYear) 
		{
			document.theForm.dateYear.options[i] = new Option(yearArray[i], yearArray[i], false, true);
		}
		else 
	    {
			document.theForm.dateYear.options[i] = new Option(yearArray[i], yearArray[i], false, false);
		}
	}
}

//Reset the day select box. Used when month or year changes to re-evaluate the number of days in the month.
function resetDay() 
{	
	while (document.theForm.dateDay.length > 0) 
	{
		document.theForm.dateDay.options[0] = null;
	}
	fillDay();
}

//Gets the number of days in the currently selected month.
function getDayCount() 
{
	var days;
    
    // RETURN 31 DAYS
    if (theMonth==1 || theMonth==3 || theMonth==5 || theMonth==7 || theMonth==8 ||
        theMonth==10 || theMonth==12)  {
        days=31;
    }
    // RETURN 30 DAYS
    else if (theMonth==4 || theMonth==6 || theMonth==9 || theMonth==11) {
        days=30;
    }
    // RETURN 29 DAYS
    else if (theMonth==2)  {
        if (isLeapYear(theYear)) {
            days=29;
        }
        // RETURN 28 DAYS
        else {
            days=28;
        }
    }
    return (days);
}

//Check to see if selected year is a leap year.  Used to calculate number of days in month
function isLeapYear (theYear) {
    if (((theYear % 4)==0) && ((theYear % 100)!=0) || ((theYear % 400)==0)) {
        return (true);
    }
    else {
        return (false);
    }
}

//ensure that the value is two digets in length
function makeTwoDigit(inValue) {
    var numVal = parseInt(inValue, 10);
    //value is less then two digets
    if (numVal < 10) {

        //add a leading 0 to the value and return it
        return("0" + numVal);
    }
    else {
        return numVal;
    }
}

//Returns the date to the parent form and closes this window.
function returnDate() {
	var field = "<%=fieldName%>";
	newDate = theMonth + '/' + theDay + '/' + theYear   ;
	opener.setDate(newDate,field);
	window.close();
}

function MM_callJS(jsStr) { //v2.0
  return eval(jsStr)
}
//-->
</script>

<link rel="stylesheet" href="forms.css" type="text/css">
</head>

<body bgcolor="#FFFFFF" text="#000000" onLoad="init();">
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tr> 
    <td valign="top"> 
      <form name="theForm" method="post" action="">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td align="center" height="45" valign="middle" width="49"> <img src="images/dot.gif" width="10" height="10"> 
            </td>
            <td class="boldBlue" width="71" height="45">Date:</td>
            <td width="981" height="45" align="center"> 
              <table width="221" border="0" cellspacing="0" cellpadding="0" height="36">
                <tr> 
                  <td width="96" height="22"> 
                    <p><font size="2"> 
                      <select name="dateMonth" style="width:80px; font-size: 9pt; font-face: verdana; color: #000099" onChange="theMonth=this.options[this.selectedIndex].value;resetDay();">
                      </select>
                      </font><font size="2">Month</font></p>
                  </td>
                  <td width="15" align="left" class="boldBlue" height="22" valign="top"> 
                    <p><font color="#000000">/</font></p>
                  </td>
                  <td width="48" height="22"> 
                    <p><font size="2"> 
                      <select name="dateDay" style="width:40px; font-size: 9pt; font-face: verdana; color: #000099" onChange="theDay=this.options[this.selectedIndex].value;">
                      </select>
                      </font><font size="2">Day</font> </p>
                  </td>
                  <td width="15" align="left" class="boldBlue" height="22" valign="top"><font color="#000000">/</font></td>
                  <td width="110" height="22"> 
                    <p><font size="2"> 
                      <select name="dateYear" style="width:50px; font-size: 9pt; font-face: verdana; color: #000099" onChange="theYear=this.options[this.selectedIndex].value;resetDay();">
                      </select>
                      </font><font size="2">Year</font></p>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr> 
            <td align="center" height="24" valign="middle" width="49">&nbsp;</td>
            <td class="boldBlue" width="71">&nbsp;</td>
            <td width="981">&nbsp;</td>
          </tr>
          <tr> 
            <td align="center" height="24" valign="middle" width="49">&nbsp;</td>
            <td class="boldBlue" width="71"> 
              <input type="button" name="Submit" value="Submit" onClick="MM_callJS('returnDate()')">
            </td>
            <td width="981">&nbsp; </td>
          </tr>
        </table>
      </form>
    </td>
    <td> <img src="spacer.gif" width="1" height="100" border="0"> </td>
  </tr>
</table>

</body>
</html>
