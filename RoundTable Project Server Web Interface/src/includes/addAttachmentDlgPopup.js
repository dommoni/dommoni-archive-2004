
function addAttachment(opparam, context, parentLink)
{
    var w = 450;
	var h = 340;

	var winl = (screen.width - w) / 2;
  	var wint = (screen.height - h) / 2;
  	var settings  ='height='+h+',';
        settings +='width='+w+',';
		settings +='top='+wint+',';
        settings +='left='+winl+',';
        settings +='scrollbars=no,';
        settings +='resizable=no';
	
	var pageLink = "./projectAttachmentsAddAttachmentWiz1.jsp?opparam="+opparam+"&context="+context+"&parentlink="+parentLink;
	win = window.open(pageLink,'noname',settings);
}