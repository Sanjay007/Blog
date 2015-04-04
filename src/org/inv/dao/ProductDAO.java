package org.inv.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.beans.Product;

public interface ProductDAO {

	
	public ArrayList<Product> listAll();
	public boolean addProduct(Product P);
	public Product getbyId(String ID) throws Exception;
	
	public double getProdPriceById(int id)  throws Exception;
	
}
