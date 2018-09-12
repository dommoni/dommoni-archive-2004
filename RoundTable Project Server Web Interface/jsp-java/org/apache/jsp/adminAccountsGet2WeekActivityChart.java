package org.apache.jsp;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import com.dommoni.roundtable.Project;
import com.dommoni.roundtable.ProjectServerConnection;
import com.dommoni.roundtable.logging.EventLogEntry;
import com.dommoni.roundtable.projectServer.services.logging.eventlogManager.IEventLogManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeriesDataItem;
import com.keypoint.PngEncoderB;
import ge.GIFEncoder;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.jasper.runtime.*;


public class adminAccountsGet2WeekActivityChart extends HttpJspBase {


    static {
    }
    public adminAccountsGet2WeekActivityChart( ) {
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

            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(0,33);to=(1,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(1,34);to=(2,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(2,39);to=(3,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(3,34);to=(4,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(4,43);to=(5,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(5,48);to=(6,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(6,46);to=(7,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(7,38);to=(8,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(8,34);to=(9,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(9,37);to=(10,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(10,38);to=(11,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(11,33);to=(13,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(13,50);to=(14,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(14,66);to=(15,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(15,64);to=(16,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(16,106);to=(18,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(18,48);to=(19,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(19,46);to=(20,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(20,43);to=(21,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(21,50);to=(22,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(22,60);to=(23,0)]
                out.write("\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(23,58);to=(25,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(25,44);to=(27,0)]
                out.write("\r\n\r\n");

            // end
            // HTML // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(27,33);to=(30,0)]
                out.write("\r\n\r\n\r\n");

            // end
            // begin [file="/adminAccountsGet2WeekActivityChart.jsp";from=(30,2);to=(149,0)]
                
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
