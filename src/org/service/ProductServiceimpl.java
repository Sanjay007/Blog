package org.service;

import java.util.ArrayList;

import org.beans.Product;
import org.inv.dao.ProductDAO;
import org.inv.dao.ProductDAOimpl;

public class ProductServiceimpl implements ProductDAO {

	private ProductDAOimpl productimpl=new ProductDAOimpl();
	@Override
	public ArrayList<Product> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addProduct(Product P) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product getbyId(String ID) {
		return productimpl.getbyId(ID);
		
	}

	@Override
	public double getProdPriceById(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
