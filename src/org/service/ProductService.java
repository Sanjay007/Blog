package org.service;

import java.util.ArrayList;

import org.beans.Product;

public interface ProductService {

	
	public Product getById(String id);
	public ArrayList<Product> getallList();
	
}
