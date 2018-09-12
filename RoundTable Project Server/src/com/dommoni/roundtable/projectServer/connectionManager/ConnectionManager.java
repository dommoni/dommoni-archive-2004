/*
 * Created on May 2, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.connectionManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDriver;
import org.apache.commons.pool.impl.GenericObjectPool;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ConnectionManager implements IConnectionManager
{
   public void init()
   {
      GenericObjectPool connectionPool = 
         new GenericObjectPool(null, 10, (byte)1, 2000, 10, true, true, 10000, 5, 5000, true);
      
      connectionPool.setWhenExhaustedAction(GenericObjectPool.WHEN_EXHAUSTED_GROW);
      
      //DriverManagerConnectionFactory connectionFactory = 
         //new DriverManagerConnectionFactory("jdbc:mysql://localhost:3306/ece", "root", "");
      DriverManagerConnectionFactory connectionFactory = 
         new DriverManagerConnectionFactory("jdbc:derby:./db/core;create=true", "", "");
 
      PoolableConnectionFactory poolableConnectionFactory = 
         new PoolableConnectionFactory(connectionFactory, connectionPool, null, null, false, true);
      
      PoolingDriver driver = new PoolingDriver();
      driver.registerPool("default", connectionPool);
   }
   
   public static Connection getConnection() 
      throws SQLException
   {
      return DriverManager.getConnection("jdbc:apache:commons:dbcp:default");
   }
}
/*
 * 
 * $Log: ConnectionManager.java,v $
 * Revision 1.2  2005/03/26 19:19:55  brian
 * Added footer.
 *
 * 
 */