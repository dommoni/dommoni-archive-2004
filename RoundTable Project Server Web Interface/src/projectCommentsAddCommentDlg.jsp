<%@page import="com.dommoni.ece.webui.Operations" %>

<%
	String name = request.getParameter("name");
  	String opparam = request.getParameter("opparam");
  	String context = request.getParameter("context");
  	String parentlink = request.getParameter("parentlink");
%>

<html>
<head>
<title>Add Comment</title>
<meta http-equiv="Content-Type" content="text/html;">

<script language="JavaScript">
<!--
function MM_callJS(jsStr) { //v2.0
  return eval(jsStr)
}
//-->
</script>
</head>
<body bgcolor="#ffffff" onload="" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
<form method="post" ENCTYPE="multipart/form-data" action="./servlet/ControllerServlet">
  <table border="0" cellpadding="0" cellspacing="0" width="450">
    <!-- fwtable fwsrc="AddCommentDlg.png" fwbase="AddCommentDlg.gif" fwstyle="Generic" fwdocid = "742308039" fwnested=""0" -->
    <tr>
   <td><img src="images/spacer.gif" width="12" height="1" border="0"></td>
   <td><img src="images/spacer.gif" width="6" height="1" border="0"></td>
   <td><img src="images/spacer.gif" width="7" height="1" border="0"></td>
   <td><img src="images/spacer.gif" width="2" height="1" border="0"></td>
   <td><img src="images/spacer.gif" width="71" height="1" border="0"></td>
   <td><img src="images/spacer.gif" width="45" height="1" border="0"></td>
   <td><img src="images/spacer.gif" width="134" height="1" border="0"></td>
   <td><img src="images/spacer.gif" width="79" height="1" border="0"></td>
   <td><img src="images/spacer.gif" width="6" height="1" border="0"></td>
   <td><img src="images/spacer.gif" width="61" height="1" border="0"></td>
   <td><img src="images/spacer.gif" width="12" height="1" border="0"></td>
   <td><img src="images/spacer.gif" width="6" height="1" border="0"></td>
   <td><img src="images/spacer.gif" width="9" height="1" border="0"></td>
   <td><img src="images/spacer.gif" width="1" height="1" border="0"></td>
  </tr>

  <tr>
    <td colspan="13">&nbsp;</td>
   <td><img src="images/spacer.gif" width="1" height="15" border="0"></td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
   <td colspan="4"><img name="AddCommentDlg_r2_c3" src="images/AddCommentDlg_r2_c3.gif" width="125" height="19" border="0"></td>
    <td colspan="7">&nbsp;</td>
   <td><img src="images/spacer.gif" width="1" height="19" border="0"></td>
  </tr>
  <tr>
    <td rowspan="8">&nbsp;</td>
   <td colspan="10"><img name="AddCommentDlg_r3_c2" src="images/AddCommentDlg_r3_c2.gif" width="423" height="4" border="0"></td>
   <td rowspan="6" colspan="2"><img name="AddCommentDlg_r3_c12" src="images/AddCommentDlg_r3_c12.gif" width="15" height="238" border="0"></td>
   <td><img src="images/spacer.gif" width="1" height="4" border="0"></td>
  </tr>
  <tr>
    <td colspan="10">&nbsp;</td>
   <td><img src="images/spacer.gif" width="1" height="9" border="0"></td>
  </tr>
  <tr>
    <td rowspan="6" colspan="2">&nbsp;</td> <td colspan="2"><font face="Arial, Helvetica, sans-serif" size="2">Comment:</font></td>
    <td rowspan="2" colspan="6">&nbsp;</td>
   <td><img src="images/spacer.gif" width="1" height="16" border="0"></td>
  </tr>
  <tr>
    <td colspan="2">&nbsp;</td>
   <td><img src="images/spacer.gif" width="1" height="9" border="0"></td>
  </tr>
  <tr>
   <td rowspan="4"><img name="AddCommentDlg_r7_c4" src="images/AddCommentDlg_r7_c4.gif" width="2" height="228" border="0"></td>
      <td colspan="6" valign="top">
        <textarea name="commenttext" rows="5" cols="45"></textarea>
      </td>
   <td rowspan="2"><img name="AddCommentDlg_r7_c11" src="images/AddCommentDlg_r7_c11.gif" width="12" height="200" border="0"></td>
   <td><img src="images/spacer.gif" width="1" height="108" border="0"></td>
  </tr>
  <tr>
      <td colspan="6">&nbsp;</td>
   <td><img src="images/spacer.gif" width="1" height="4
   2" border="0"></td>
  </tr>
  <tr>
    <td rowspan="2" colspan="3">&nbsp;</td>
      <td align="right"> 
        <input type="submit" name="Submit" value="Add">
      </td>
   <td rowspan="2"><img name="AddCommentDlg_r9_c9" src="images/AddCommentDlg_r9_c9.gif" width="6" height="28" border="0"></td>
      <td colspan="3">
        <input type="button" name="Submit2" value="Cancel" onClick="MM_callJS('window.close();')">
      </td>
   <td rowspan="2"><img name="AddCommentDlg_r9_c13" src="images/AddCommentDlg_r9_c13.gif" width="9" height="28" border="0"></td>
   <td><img src="images/spacer.gif" width="1" height="22" border="0"></td>
  </tr>
  <tr>
   <td><img name="AddCommentDlg_r10_c8" src="images/AddCommentDlg_r10_c8.gif" width="79" height="6" border="0"></td>
   <td colspan="3"><img name="AddCommentDlg_r10_c10" src="images/AddCommentDlg_r10_c10.gif" width="79" height="6" border="0"></td>
   <td><img src="images/spacer.gif" width="1" height="6" border="0"></td>
  </tr>


</table>

   
  <input type="hidden" name="opcode" value="<%=Operations.CREATE_COMMENT%>"/>
  <input type="hidden" name="name" value="<%=name%>" />
  <input type="hidden" name="opparam" value="<%=opparam%>" />
  <input type="hidden" name="context" value="<%=context%>" />
  <input type="hidden" name="parentlink" value="<%=parentlink%>" />
</form>
</body>
</html>
