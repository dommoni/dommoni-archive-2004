/*
 * Created on Mar 17, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.xml.namespace.QName;

import org.apache.axis.EngineConfiguration;
import org.apache.axis.deployment.wsdd.WSDDConstants;
import org.apache.axis.deployment.wsdd.WSDDProvider;
import org.apache.axis.deployment.wsdd.WSDDService;

import com.dommoni.roundtable.projectServer.axis.RoundTableWSDDProvider;
import com.dommoni.roundtable.projectServer.connectionManager.ConnectionManager;
import com.dommoni.roundtable.projectServer.licensing.License;
import com.dommoni.roundtable.projectServer.licensing.LicenseFileReader;
import com.dommoni.roundtable.projectServer.sessions.SessionGenerator;
import com.dommoni.roundtable.projectServer.sessions.SessionScrubber;
import com.dommoni.roundtable.projectServer.utils.PrintUtils;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ProjectServer
{
	/*
	 * Needs to:
	 *    -- read the Config File.
	 *    -- load the DBDriver
	 */
	private static ProjectServer projectServer;
	//private SessionScrubber sessionScrubber = null;  
   private SessionGenerator sessionGenerator;
   private License license = null;
   private ServletConfig config = null;
   
	private ProjectServer()
	{
	}

	public void init()
	{
        // setup our jdbc connections.
        try
        {
           // load the Derby Driver...
           Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        
        // setup our db connection manager
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.init();
        
        // setup axis.
        WSDDProvider.registerProvider(new QName(WSDDConstants.URI_WSDD_JAVA, "ROUNDTABLE"), new RoundTableWSDDProvider());
        
        // warm-up the session generator...
        sessionGenerator = new SessionGenerator();
        sessionGenerator.generateSessionId();
        
        //sessionScrubber = new SessionScrubber();
        //sessionScrubber.start();
        
        loadLicense();
        
        try
        {
           String licClass = "com.dommoni.roundtable.projectServer.licensing.LicenseFileReader";
           InputStream isLic = getClass().getClassLoader().getResourceAsStream(LicenseFileReader.class.getName());
           
           if(isLic != null)
           {   
              System.out.println("LIC-CLS-LEN: " + isLic.available());
           }
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
   }
   
   private void loadLicense()
   {
      LicenseFileReader lfr = new LicenseFileReader();
      long crc = lfr.getCRC();
      license = lfr.getLicense();
      
      Connection connection = null;
      
      try
	  {
      	connection = ConnectionManager.getConnection();
      	PreparedStatement pstmt = connection.prepareStatement("select date from lld", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
      	ResultSet rs = pstmt.executeQuery();
      	if(rs.first())
      	{	
      		Calendar clLoad = Calendar.getInstance();
      		clLoad.setTimeInMillis(rs.getTimestamp(1).getTime());
      		license.setLoadDate(clLoad);
      	}
      	else
      	{
      		// never been loaded. first time.
            Calendar clLoadTime = Calendar.getInstance();
            license.setLoadDate(clLoadTime);
            
      		pstmt = connection.prepareStatement("insert into lld (date) values (?)", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
      		pstmt.setTimestamp(1, new Timestamp(clLoadTime.getTimeInMillis()));
      		pstmt.executeUpdate();
      	}
	  }
      catch(Exception e)
	  {
      	e.printStackTrace();
	  }
      
      System.out.println("\n\n----------- License Info -----------");
      System.out.println("\tCompany: " + license.getCompany());
      System.out.println("\tContact: " + license.getContact());
      System.out.println("\tUsers: " + license.getUsers());
      System.out.println("\tMode: " + license.getMode());
      Calendar clStart = Calendar.getInstance();
      clStart.setTimeInMillis(license.getStartDay());
      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
      System.out.println("\tStart: " + sdf.format(clStart.getTime()));
      System.out.println("\tDays: " + license.getDays());
      System.out.println("\tCRC: " + license.getFileCRC());
      
   }

   
   public void shutdown()
   {
      /*if(sessionScrubber != null)
      {   
         sessionScrubber.stop();
      }*/
   }

   public SessionGenerator getSessionGenerator()
   {
      if(sessionGenerator == null)
      {   
         sessionGenerator = new SessionGenerator();
      }
      return sessionGenerator;
   }
   
   public License getLicense()
   {
      return this.license;
   }
   
   public ServletConfig getConfig() {return this.config;}
   public void setConfig(ServletConfig config)
   {
   	this.config = config;
   }
	public static ProjectServer getInstance()
	{
		if (projectServer == null)
		{
			projectServer = new ProjectServer();
		}
		return projectServer;
	}
}
/*
 * 
 * $Log: ProjectServer.java,v $
 * Revision 1.2  2005/03/23 08:49:39  brian
 * Added License Loading and removed SessionScrubber temporarily.
 *
 * 
 */