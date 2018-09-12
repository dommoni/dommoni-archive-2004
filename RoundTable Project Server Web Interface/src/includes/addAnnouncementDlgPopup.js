
function newAnnouncement()
{
    var w = 450;
	var h = 380;

	var winl = (screen.width - w) / 2;
  	var wint = (screen.height - h) / 2;
  	var settings  ='height='+h+',';
        settings +='width='+w+',';
		settings +='top='+wint+',';
        settings +='left='+winl+',';
        settings +='scrollbars=no,';
        settings +='resizable=no';
	
	var pageLink = "./projectAnnouncementsAddAnnouncementDlg.jsp";
	win = window.open(pageLink,'noname',settings);
}
