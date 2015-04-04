package org.inv.dao;

import org.beans.User;

public interface LoginDAO {

	
public boolean	checkLogin(User Login);

public User getUserLogged(String Uemail,String Upass);
}
