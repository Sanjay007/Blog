package org.beans;

import java.net.URI;
import java.sql.*;  
//import java.io.*;  

import org.apache.log4j.Logger;
import org.logg.RunInvLogger;

public class DBbean {

 private static String dbURL = "jdbc:mysql://localhost:3308/invoice";
 private static String dbDriver = "com.mysql.jdbc.Driver"; 

  //private Connection dbCon;
private static Connection dbCon;

  public DBbean(){  
       super();        
       }

  public static  boolean connect() throws ClassNotFoundException,SQLException{ 
         
	  try {
		  RunInvLogger.getbaseLogger().info("Loading DB  Class  : "+dbDriver);
		  Class.forName(dbDriver);
		  }
	  
	  catch (ClassNotFoundException  e){
		RunInvLogger.getbaseLogger().debug("Class Not Found"+e.getLocalizedMessage().toString());  
		RunInvLogger.getbaseLogger().error(e.getCause());
	  
	  }
         // System.out.print("ccc");
    
          dbCon = DriverManager.getConnection(dbURL,"root","root");
          return true; 
        
  
  }

 

  public  static  synchronized void close() { 
        try {
			dbCon.close();
		} catch (SQLException e) {
			
			RunInvLogger.getbaseLogger().debug("Exception thrown \n ERROR:"+e.getMessage());
			RunInvLogger.getbaseLogger().error(e.getCause());
			RunInvLogger.getbaseLogger().error(e);
		} 
       
  }

  public static  ResultSet execSQL(String sql) {
	RunInvLogger.getbaseLogger().info("Executing : "+sql);
	  ResultSet r=null;
	  try{
                    Statement s = dbCon.createStatement(); 
                   r = s.executeQuery(sql); 
                    
                    }

catch (SQLException e){
	RunInvLogger.getbaseLogger().debug("Exception thrown \n ERROR:"+e.getMessage());
	RunInvLogger.getbaseLogger().error(e.getCause());
}
return (r == null) ? null : r; 

  }

  public static  int updateSQL(String sql) throws SQLException{  
	  RunInvLogger.getbaseLogger().info("Update SQL Block : "+sql);
                   Statement s = dbCon.createStatement();
                   int r = s.executeUpdate(sql);
                   return (r == 0) ? 0 : r; 
                }

}