package org.apache.jsp;

import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class calendar_popup extends HttpJspBase {


    static {
    }
    public calendar_popup( ) {
    }

    private static boolean _jspx_inited = false;

    public final void _jspx_init() throws org.apache.jasper.runtime.JspException {
    }

    public void _jspService(HttpServletRequest request, HttpServletResponse  response)
        throws java.io.IOException, ServletException {

        JspFactory _jspxFactory = null;
        PageContext pageContext = null;
        HttpSession session = null;
        ServletContext application = null;
        ServletConfig config = null;
        JspWriter out = null;
        Object page = this;
        String  _value = null;
        try {

            if (_jspx_inited == false) {
                synchronized (this) {
                    if (_jspx_inited == false) {
                        _jspx_init();
                        _jspx_inited = true;
                    }
                }
            }
            _jspxFactory = JspFactory.getDefaultFactory();
            response.setContentType("text/html;ISO-8859-1");
            pageContext = _jspxFactory.getPageContext(this, request, response,
            			"", true, 8192, true);

            application = pageContext.getServletContext();
            config = pageContext.getServletConfig();
            session = pageContext.getSession();
            out = pageContext.getOut();

            // HTML // begin [file="/calendar_popup.jsp";from=(0,42);to=(1,0)]
                out.write("\r\n");

            // end
            // begin [file="/calendar_popup.jsp";from=(1,2);to=(5,0)]
                
                   String fieldName = request.getParameter("field");
                   if(fieldName == null)
                      System.out.println("FIELD PARAM WAS NULL!"); 
            // end
            // HTML // begin [file="/calendar_popup.jsp";from=(5,2);to=(151,14)]
                out.write("\r\n<html>\r\n<head>\r\n<title>Select Date/Time</title>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n\r\n<script language=\"JavaScript\">\r\n<!--\r\nvar dateBoxId;\r\n\r\nvar theDate = \"\";\r\n\r\nvar theYear = \"\";\r\nvar theMonth = \"\";\r\nvar theDay = \"\";\r\n\r\nfunction init() \r\n{\t\r\n\ttheDate = new Date();\r\n\t\r\n\ttheYear = theDate.getFullYear();\r\n\ttheMonth = makeTwoDigit((theDate.getMonth() + 1));\r\n\ttheDay = makeTwoDigit(theDate.getDate());\r\n\r\n\tfillMonth();\r\n\tfillDay();\r\n\tfillYear();\r\n}\r\n\r\n//Fill the month select box\r\nfunction fillMonth() {\r\n\tmonthArray = new Array('January', 'February', 'March', 'April', 'May', 'June',\r\n                           'July', 'August', 'September', 'October', 'November', 'December');\r\n\tvar m = \"\";\r\n\tfor(i = 0; i < 12; i++) \r\n    {\r\n\t\tm = makeTwoDigit(i + 1);\r\n\t\tif (m == theMonth) \r\n\t    {\r\n\t\t\tdocument.theForm.dateMonth.options[i] = new Option(monthArray[i], m, false, true);\r\n\t\t}\r\n\t\telse \r\n\t    {\r\n\t\t\tdocument.theForm.dateMonth.options[i] = new Option(monthArray[i], m, false, false);\r\n\t\t}\t\r\n\t}\r\n}\r\n\r\n//Fill the day select box\r\nfunction fillDay() \r\n{\r\n\tvar d = \"\";\r\n\tfor(i = 0; i < getDayCount(); i++) \r\n    {\r\n\t\td = makeTwoDigit(i+1);\r\n\t\tif (d == theDay) \r\n\t    {\r\n\t\t\tdocument.theForm.dateDay.options[i] = new Option(d, d, false, true);\r\n\t\t}\r\n\t\telse \r\n\t    {\r\n\t\t\tdocument.theForm.dateDay.options[i] = new Option(d, d, false, false);\r\n\t\t}\r\n\t}\r\n}\r\n\r\n//Fill the day select box\r\nfunction fillYear() \r\n{\r\n\tyearArray = new Array('2001','2002','2003','2004','2005');\r\n\tfor (i = 0; i < yearArray.length; i++) \r\n    {\r\n\t\tif (yearArray[i] == theYear) \r\n\t\t{\r\n\t\t\tdocument.theForm.dateYear.options[i] = new Option(yearArray[i], yearArray[i], false, true);\r\n\t\t}\r\n\t\telse \r\n\t    {\r\n\t\t\tdocument.theForm.dateYear.options[i] = new Option(yearArray[i], yearArray[i], false, false);\r\n\t\t}\r\n\t}\r\n}\r\n\r\n//Reset the day select box. Used when month or year changes to re-evaluate the number of days in the month.\r\nfunction resetDay() \r\n{\t\r\n\twhile (document.theForm.dateDay.length > 0) \r\n\t{\r\n\t\tdocument.theForm.dateDay.options[0] = null;\r\n\t}\r\n\tfillDay();\r\n}\r\n\r\n//Gets the number of days in the currently selected month.\r\nfunction getDayCount() \r\n{\r\n\tvar days;\r\n    \r\n    // RETURN 31 DAYS\r\n    if (theMonth==1 || theMonth==3 || theMonth==5 || theMonth==7 || theMonth==8 ||\r\n        theMonth==10 || theMonth==12)  {\r\n        days=31;\r\n    }\r\n    // RETURN 30 DAYS\r\n    else if (theMonth==4 || theMonth==6 || theMonth==9 || theMonth==11) {\r\n        days=30;\r\n    }\r\n    // RETURN 29 DAYS\r\n    else if (theMonth==2)  {\r\n        if (isLeapYear(theYear)) {\r\n            days=29;\r\n        }\r\n        // RETURN 28 DAYS\r\n        else {\r\n            days=28;\r\n        }\r\n    }\r\n    return (days);\r\n}\r\n\r\n//Check to see if selected year is a leap year.  Used to calculate number of days in month\r\nfunction isLeapYear (theYear) {\r\n    if (((theYear % 4)==0) && ((theYear % 100)!=0) || ((theYear % 400)==0)) {\r\n        return (true);\r\n    }\r\n    else {\r\n        return (false);\r\n    }\r\n}\r\n\r\n//ensure that the value is two digets in length\r\nfunction makeTwoDigit(inValue) {\r\n    var numVal = parseInt(inValue, 10);\r\n    //value is less then two digets\r\n    if (numVal < 10) {\r\n\r\n        //add a leading 0 to the value and return it\r\n        return(\"0\" + numVal);\r\n    }\r\n    else {\r\n        return numVal;\r\n    }\r\n}\r\n\r\n//Returns the date to the parent form and closes this window.\r\nfunction returnDate() {\r\n\tvar field = \"");

            // end
            // begin [file="/calendar_popup.jsp";from=(151,17);to=(151,26)]
                out.print(fieldName);
            // end
            // HTML // begin [file="/calendar_popup.jsp";from=(151,28);to=(226,0)]
                out.write("\";\r\n\tnewDate = theMonth + '/' + theDay + '/' + theYear   ;\r\n\topener.setDate(newDate,field);\r\n\twindow.close();\r\n}\r\n\r\nfunction MM_callJS(jsStr) { //v2.0\r\n  return eval(jsStr)\r\n}\r\n//-->\r\n</script>\r\n\r\n<link rel=\"stylesheet\" href=\"forms.css\" type=\"text/css\">\r\n</head>\r\n\r\n<body bgcolor=\"#FFFFFF\" text=\"#000000\" onLoad=\"init();\">\r\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n  <tr> \r\n    <td valign=\"top\"> \r\n      <form name=\"theForm\" method=\"post\" action=\"\">\r\n        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n          <tr> \r\n            <td align=\"center\" height=\"45\" valign=\"middle\" width=\"49\"> <img src=\"images/dot.gif\" width=\"10\" height=\"10\"> \r\n            </td>\r\n            <td class=\"boldBlue\" width=\"71\" height=\"45\">Date:</td>\r\n            <td width=\"981\" height=\"45\" align=\"center\"> \r\n              <table width=\"221\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"36\">\r\n                <tr> \r\n                  <td width=\"96\" height=\"22\"> \r\n                    <p><font size=\"2\"> \r\n                      <select name=\"dateMonth\" style=\"width:80px; font-size: 9pt; font-face: verdana; color: #000099\" onChange=\"theMonth=this.options[this.selectedIndex].value;resetDay();\">\r\n                      </select>\r\n                      </font><font size=\"2\">Month</font></p>\r\n                  </td>\r\n                  <td width=\"15\" align=\"left\" class=\"boldBlue\" height=\"22\" valign=\"top\"> \r\n                    <p><font color=\"#000000\">/</font></p>\r\n                  </td>\r\n                  <td width=\"48\" height=\"22\"> \r\n                    <p><font size=\"2\"> \r\n                      <select name=\"dateDay\" style=\"width:40px; font-size: 9pt; font-face: verdana; color: #000099\" onChange=\"theDay=this.options[this.selectedIndex].value;\">\r\n                      </select>\r\n                      </font><font size=\"2\">Day</font> </p>\r\n                  </td>\r\n                  <td width=\"15\" align=\"left\" class=\"boldBlue\" height=\"22\" valign=\"top\"><font color=\"#000000\">/</font></td>\r\n                  <td width=\"110\" height=\"22\"> \r\n                    <p><font size=\"2\"> \r\n                      <select name=\"dateYear\" style=\"width:50px; font-size: 9pt; font-face: verdana; color: #000099\" onChange=\"theYear=this.options[this.selectedIndex].value;resetDay();\">\r\n                      </select>\r\n                      </font><font size=\"2\">Year</font></p>\r\n                  </td>\r\n                </tr>\r\n              </table>\r\n            </td>\r\n          </tr>\r\n          <tr> \r\n            <td align=\"center\" height=\"24\" valign=\"middle\" width=\"49\">&nbsp;</td>\r\n            <td class=\"boldBlue\" width=\"71\">&nbsp;</td>\r\n            <td width=\"981\">&nbsp;</td>\r\n          </tr>\r\n          <tr> \r\n            <td align=\"center\" height=\"24\" valign=\"middle\" width=\"49\">&nbsp;</td>\r\n            <td class=\"boldBlue\" width=\"71\"> \r\n              <input type=\"button\" name=\"Submit\" value=\"Submit\" onClick=\"MM_callJS('returnDate()')\">\r\n            </td>\r\n            <td width=\"981\">&nbsp; </td>\r\n          </tr>\r\n        </table>\r\n      </form>\r\n    </td>\r\n    <td> <img src=\"spacer.gif\" width=\"1\" height=\"100\" border=\"0\"> </td>\r\n  </tr>\r\n</table>\r\n\r\n</body>\r\n</html>\r\n");

            // end

        } catch (Throwable t) {
            if (out != null && out.getBufferSize() != 0)
                out.clearBuffer();
            if (pageContext != null) pageContext.handlePageException(t);
        } finally {
            if (_jspxFactory != null) _jspxFactory.releasePageContext(pageContext);
        }
    }
}
