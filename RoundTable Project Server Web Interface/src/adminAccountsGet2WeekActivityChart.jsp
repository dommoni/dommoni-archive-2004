<%@page import="java.awt.Font" %>
<%@page import="java.awt.Frame" %>
<%@page import="java.awt.Graphics2D" %>
<%@page import="java.awt.Image" %>
<%@page import="java.awt.RenderingHints" %>
<%@page import="java.awt.image.BufferedImage" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Calendar" %>
<%@page import="java.util.Date" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.Set" %>

<%@page import="com.dommoni.roundtable.Project" %>
<%@page import="com.dommoni.roundtable.ProjectServerConnection" %>
<%@page import="com.dommoni.roundtable.logging.EventLogEntry" %>
<%@page import="com.dommoni.roundtable.projectServer.services.logging.eventlogManager.IEventLogManager" %>

<%@page import="org.jfree.chart.ChartFactory" %>
<%@page import="org.jfree.chart.JFreeChart" %>
<%@page import="org.jfree.data.time.Day" %>
<%@page import="org.jfree.data.time.TimeSeries" %>
<%@page import="org.jfree.data.time.TimeSeriesCollection" %>
<%@page import="org.jfree.data.time.TimeSeriesDataItem" %>

<%@page import="com.keypoint.PngEncoderB" %>

<%@page import="ge.GIFEncoder" %>


<%
try
{   
   Calendar clBegin;
   Calendar clEnd; 
   HashMap dates = new HashMap();

   StringBuffer querySb = new StringBuffer();
   int accountId = Integer.parseInt(request.getParameter("accountid"));
   querySb.append("users=(" + accountId + ");");
   
   ProjectServerConnection psc = (ProjectServerConnection)session.getAttribute("psc");
   Project accountProjects[] = psc.getProjectManager().getAllProjectsForAccount(accountId);
   if(accountProjects != null && accountProjects.length > 0)
   {
      StringBuffer sbProjects = new StringBuffer();
      for(int i = 0; i < accountProjects.length; i++)
      {
         sbProjects.append(accountProjects[i].getId());
		 if(i < accountProjects.length - 1)
		    sbProjects.append(",");
      }
	  querySb.append("projects(" + sbProjects.toString() + ");");
	  
	  SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	  Calendar clDate = Calendar.getInstance();
	  String toDate = sdf.format(clDate.getTime());
	  
	  long lgFrom = clDate.getTimeInMillis() - (1000 * 60 * 60 * 24 * 14);
	  Date dtFrom = new Date(lgFrom);
	  String fromDate = sdf.format(dtFrom);
	 
	  querySb.append("period=(" + fromDate + "," + toDate + ");");
   }

   IEventLogManager elm = psc.getEventLogManager();
   EventLogEntry[] eventLogs = elm.getEventLogsFromQueryString(querySb.toString());
   if(eventLogs != null && eventLogs.length > 0)
   {
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	  HashMap hm = new HashMap();
      for(int i = 0; i < eventLogs.length; i++)
	  {
	     try
		 {
	        String time = sdf.format(eventLogs[i].getTimestamp().getTime());
			Integer iCount = (Integer)hm.get(time);
			if(iCount != null)
			{
			   hm.put(time, new Integer(iCount.intValue() + 1));
			}
			else
			{
			   hm.put(time, new Integer(1));
			}
		 }
		 catch(Exception e)
		 {
		    e.printStackTrace();
		 }
	  }
	  
	  TimeSeries ts = new TimeSeries("Val", Day.class);
	  Set keys = hm.keySet();
	  Iterator it = keys.iterator();
	 
	  while(it.hasNext())
	  {
	     try
		 {
		    String key = (String)it.next();
		    Day day = new Day(sdf.parse(key));
		    ts.add(new TimeSeriesDataItem(day, (Integer)hm.get(key))); 
		 }
		 catch(Exception e)
		 {
		    e.printStackTrace();
		 }
	  }
	  
	  TimeSeriesCollection tsc = new TimeSeriesCollection(ts);
      
      JFreeChart jfc = ChartFactory.createTimeSeriesChart("Account Activity Chart", "Time", "Event Count", 
            tsc, false, false, true);
	 
      BufferedImage bi = jfc.createBufferedImage(320, 240);
	  
	  response.setContentType("image/png");

  	 // write encoded gif to servlet's output stream
     GIFEncoder gif = new GIFEncoder( bi );
     gif.Write(response.getOutputStream());
   }
   else
   {
	  Frame frame = new Frame();
	  frame.addNotify();
	  Image img = frame.createImage(320, 240);
	  Graphics2D g = (Graphics2D)img.getGraphics();
	  
	  Font font = new Font("Verdana", Font.PLAIN, 12);
	  g.setFont(font);
	  
	  g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	  
	  g.drawRect(5, 5, 310, 230);
	  g.drawString("Account Activity Chart: Unavailable (No Data)", 15, 125);
	  
	  GIFEncoder gif = new GIFEncoder( img );
      gif.Write(response.getOutputStream());
	  
	  frame.removeNotify();
	  frame = null;
   }
}
catch(Exception e)
{
   e.printStackTrace();
}
%>
<%--

$Log: adminAccountsGet2WeekActivityChart.jsp,v $
Revision 1.1  2005/10/16 06:48:04  brian
Initial Revision.


--%>