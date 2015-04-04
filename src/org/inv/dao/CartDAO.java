package org.inv.dao;

import java.util.ArrayList;

import org.beans.Cart;

public interface CartDAO {

	public boolean addCart(Cart Cart);
	public ArrayList<Cart> getbyUserandSession(String user,String session); 
	public ArrayList<Cart> getall() throws Exception;
}
