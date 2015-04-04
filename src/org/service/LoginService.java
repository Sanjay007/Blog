/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.beans.DBbean;
import org.beans.User;

/**
 *
 * @author s.yadav
 */
public interface LoginService {
    
 
	public boolean checkLogin(User Login) ;
	public User getUserLogged(String Uemail, String Upass);
}
