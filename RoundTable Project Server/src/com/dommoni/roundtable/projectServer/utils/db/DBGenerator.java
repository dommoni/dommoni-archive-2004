/*
 * Created on Aug 26, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.dommoni.roundtable.projectServer.utils.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author Brian Abbott
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class DBGenerator
{
   String sqlFileDir;
   String dbConnection;
   String driver;
   String user;
   String pass;

   int glob;
   File createDbLog;
   int compCount = 0;
   
   String tmpExecSql = "";
   
   public DBGenerator(String sqlFileDir, String dbConnection, String driver, String user, String pass)
   {
      System.out.println("Initializing RoundTable Data Set.\r\n");
       
      this.sqlFileDir = sqlFileDir;
      this.dbConnection = dbConnection;
      this.driver = driver;
      this.user = user;
      this.pass = pass;   

      createDbLog = new File("createdb.log");
   }
   
   public void generate()
   {
      try
      {
         Class.forName(driver).newInstance();
         Connection conn = DriverManager.getConnection(dbConnection, user, pass);
         createTables(conn);
         seedData(conn);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
   
   public void createTables(Connection conn) throws Exception
   {
      File dbDir = new File(sqlFileDir);
      String sqlFileNames[] = dbDir.list();

      int total = sqlFileNames.length;
      
      FileWriter logWriter = new FileWriter(createDbLog);

      for(int i = 0; i < sqlFileNames.length; i++)
      {
         if(sqlFileNames[i].startsWith("create_table"))
         {
            try
            {
               executeSQLScript(sqlFileDir + File.separator + sqlFileNames[i], logWriter, conn, true);
               String entry = "Created: " + sqlFileNames[i] + "\r\n";
               logWriter.write(entry, 0, entry.length()); 
               
               this.tmpExecSql = ""; // clear error-log info...
            }
            catch(Exception e)
            {
               //e.printStackTrace();
               String entry = "Error: FILE=" + sqlFileNames[i] + ", SQL: " + this.tmpExecSql + ", ERROR-MSG: " + e.getMessage() + "\r\n";
               logWriter.write(entry, 0, entry.length());
               logWriter.flush();
            }
            
            int perc = ((++compCount * 100) / total);
            System.out.print("\rPercent Complete: " + perc +"%.");
         }
      }
      
      logWriter.flush();
      logWriter.close();
   }
   
   public void seedData(Connection conn) throws Exception
   {
      File dbDir = new File(sqlFileDir);
      String sqlFileNames[] = dbDir.list();
      
      int total = sqlFileNames.length;
      String tmpSql = "";
      
      for(int i = 0; i < sqlFileNames.length; i++)
      {
         if(sqlFileNames[i].startsWith("seed"))
         {     
            //System.out.println("Found seed Script: " + sqlFileNames[i]);
            executeSQLScript(sqlFileDir + File.separator + sqlFileNames[i], null, conn, false);
         
            int perc = ((++compCount * 100) / total);
            System.out.print("\rPercent Complete: " + perc +"%.");
         }
      }
      
      System.out.print("\rInitialization Successful.");
      long time = System.currentTimeMillis();
      while(time + 1500 > System.currentTimeMillis())
         glob++;
   }
   
   /*
    * Returns the SQL that was Executed by the underlying Database.
    */
   public void executeSQLScript(String sqlScriptFile, FileWriter logger, 
         Connection dbConnection, boolean toLowerCase)
      throws Exception
   {
      File ctbf = new File(sqlScriptFile);
      BufferedReader br = new BufferedReader(new FileReader(ctbf));
      StringBuffer sb = new StringBuffer();
      String createTableStmt;
      while((createTableStmt = br.readLine()) != null)
      {
         sb.append(createTableStmt.trim());
      }
      
      String sql = sb.toString();
      if(sql.length() == 0)
      {  
         return;
      }

      if(toLowerCase)
         sql = sql.toLowerCase();

      if(this.driver.indexOf("hsql") > 0)
      {  
         sql = sql.replaceAll("`", "");
         sql = sql.replaceAll("auto_increment", "identity");
         if(sql.indexOf("identity") > 0)
            sql = sql.replaceAll(" not null", "");
          
         sql = sql.replaceAll(",\\s*index\\(.*?\\)", "");
         sql = sql.replaceAll("\\s+text", " longvarchar ");
         sql = sql.replaceAll("\\s+mediumtext", " longvarchar ");
         sql = sql.replaceAll("\\s+blob", " binary ");
         sql = sql.replaceAll("\\s+bool", " boolean ");
         sql = sql.replaceAll("create table", "create cached table");
      }
      
      if(this.driver.indexOf("derby") > 0)
      { 
         sql = sql.replaceAll("`", "");
         sql = sql.replaceAll("auto_increment", " GENERATED ALWAYS AS IDENTITY ");
         sql = sql.replaceAll(",\\s*index\\(.*?\\)", "");
         //sql = sql.replaceAll(",\\s*unique\\(.*?\\)", "");
         sql = sql.replaceAll("\\s+text", " long varchar ");
         sql = sql.replaceAll("\\s+mediumtext", " long varchar ");
         sql = sql.replaceAll("\\s+datetime", " timestamp ");
         sql = sql.replaceAll("\\s+bool", " smallint ");
      }
      
      this.tmpExecSql = new String(sql);
      Statement stmt = dbConnection.createStatement();
      stmt.execute(sql);
      stmt.close();
   }
   
   public static void main(String args[])
   {
      if(args.length != 5)
      {   
         System.out.println("There must be 5 arguments on the Command Line Interface.");
         return; 
      } 
      
      String sqlFileDir = args[0];
      String dbConnection = args[1];
      String driver = args[2];
      String user = args[3];
      String pass = args[4];
      
      DBGenerator dbGen = new DBGenerator(sqlFileDir, dbConnection, driver, user, pass);
      dbGen.generate();
   }
}
/*
 *
 * $Log$
 *
 */