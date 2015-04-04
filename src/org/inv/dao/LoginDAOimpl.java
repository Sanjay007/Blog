package org.inv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.beans.DBbean;
import org.beans.Login;
import org.beans.User;
import org.logg.RunInvLogger;

public class LoginDAOimpl implements LoginDAO {

	@Override
	public boolean checkLogin(User Login) {
		
		boolean matched=false; 
	       try {
	    	DBbean.connect();
	String lsSql="select * from ds_user where email='"+Login.getEmail().toString()+"' and password='"+Login.getPassWord().toString()+"'";
	System.out.println(Login.getEmail());	
	ResultSet rs=DBbean.execSQL(lsSql);
		RunInvLogger.getbaseLogger().info(lsSql);
		if(rs.next()){
		if(rs.getString("email").equals(Login.getEmail()) && rs.getString("password").equals(Login.getPassWord()) ){
			matched=true;
		} 
	       
		}  } catch (SQLException  e) {
			// TODO Auto-generated catch block
			RunInvLogger.getbaseLogger().warn(e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	finally{
		
		DBbean.close();
		
		RunInvLogger.getbaseLogger().debug("DB Closed"+LoginDAOimpl.class);
		
	}RunInvLogger.getbaseLogger().info("kbhjbjb");
			 return matched;
		 }

	@Override
	public User getUserLogged(String Uemail, String Upass) {
		ResultSet rsUser=null;
    	User loginUser=new User();
    	try {
			DBbean.connect();
			rsUser=DBbean.execSQL("select ds_user_role.name as name from ds_user LEFT JOIN ds_user_role ON ds_user.role_id=ds_user_role.id  where ds_user.email='"+Uemail+"' and ds_user.password='"+Upass+"'");
			if(rsUser.next()){
				loginUser.setEmail(Uemail);
				loginUser.setPassWord(Upass);
				loginUser.setRole(rsUser.getString("name"));
				//System.out.println(loginUser.getRole());
				
			}
    	
    	} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
    		
    		RunInvLogger.getbaseLogger().info(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			RunInvLogger.getbaseLogger().info(e.getMessage());
		}
    	finally{
    		try {
				rsUser.close();
				DBbean.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				RunInvLogger.getbaseLogger().info(e.getMessage());
			}
    	
    	}
    	//System.out.println(loginUser.getRole());
    	return loginUser;
    	
    

}
}
