package org.service;

import org.beans.User;
import org.inv.dao.LoginDAO;
import org.inv.dao.LoginDAOimpl;

public class LoginServiceimpl implements LoginService{

	
private LoginDAOimpl loginDAo=new LoginDAOimpl();

	@Override
	public boolean checkLogin(User Login) {
	boolean res=loginDAo.checkLogin(Login);
		//System.out.println(Login.getEmail());
		return res;
	}

	@Override
	public User getUserLogged(String Uemail, String Upass) {
		// TODO Auto-generated method stub
		return loginDAo.getUserLogged(Uemail, Upass);
	}
	
	
}
