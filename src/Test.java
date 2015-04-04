import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.beans.DBbean;
import org.beans.Login;
import org.beans.User;
import org.inv.dao.CartDAOimpl;
import org.inv.dao.LoginDAOimpl;
import org.inv.dao.ProductDAOimpl;
import org.logg.RunInvLogger;




public class Test {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub

		
	//	System.exit(1);
		
	CartDAOimpl cd=new CartDAOimpl();
	cd.getbyUserandSession("sanjay", "");
	
	System.exit(1);
	
		FileReader f=new FileReader("D:\\DV.sql");
	
	BufferedReader bf=new BufferedReader(f);
	String out="";
	String lscon="";
	while((out=bf.readLine())!= null){
		lscon+=out;
		
	}
///	System.out.println(lscon);
	//ArrayList<String> as=lscon.split(";");
//ystem.out.println(lscon.split(";").length);

for (String retval: lscon.split(";")){
  
	try{DBbean.connect();
    System.out.println(retval);
    System.out.println(DBbean.updateSQL(retval));
    DBbean.close(); 
	}
	catch (SQLException e){
		System.out.println(e.getCause());
		continue;
	}

}

	
	
		//RunInvLogger.getbaseLogger().info("ff");
		
		
		
		
		
	
}
}
