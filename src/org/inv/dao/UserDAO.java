package org.inv.dao;

import java.util.ArrayList;

import org.beans.User;

public interface UserDAO {

	/**
	 * @param args
	 */
	
	public ArrayList<User> listAllUser();
	public User  getUserbyId(String ID);
	public boolean AddUser(User adduser);
	public boolean removeUser(String ID);
	
}
