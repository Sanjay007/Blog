package org.inv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.beans.DBbean;
import org.beans.Product;

public class ProductDAOimpl  implements ProductDAO{

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
		// TODO Auto-generated method stub
		
	
		Product loProduct=new Product();
	
			try {
				DBbean.connect();
				ResultSet rsProduct=DBbean.execSQL("select * from ds_products where  id='"+ID+"'");
				while(rsProduct.next()){
					loProduct.setProdId(Integer.parseInt(ID));
					loProduct.setDesc(rsProduct.getString("description"));
					loProduct.setUnitPrice(rsProduct.getString("unit_price"));
					loProduct.setEnabled(rsProduct.getString("enabled"));
					System.out.print(rsProduct.getString("description"));
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{			
				DBbean.close();
				//	rsProduct.close();
			}
		return loProduct;
	}
	public double getProdPriceById(int id) throws SQLException{
		double count=0;
		try {
			DBbean.connect();
			ResultSet rs=DBbean.execSQL("select unit_price from ds_products where id='"+id+"' ");
		count=rs.next()? Double.parseDouble(rs.getString("unit_price")):0;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DBbean.close();
			
		}
		
		return count;
		
		
	}

	
}
