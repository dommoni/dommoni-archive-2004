function showDelete(name, opcode, opparam, context, parentLink)
{
    var w = 300;
	var h = 180;

	var winl = (screen.width - w) / 2;
  	var wint = (screen.height - h) / 2;
  	var settings  ='height='+h+',';
        settings +='width='+w+',';
		settings +='top='+wint+',';
        settings +='left='+winl+',';
        settings +='scrollbars=no,';
        settings +='resizable=no';
	
	var pageLink = "./projectConfirmDeleteDlg.jsp?name="+name+"&opcode="+opcode+"&opparam="+opparam+"&context="+context+"&parentlink="+parentLink;
	win = window.open(pageLink,'noname',settings);
}