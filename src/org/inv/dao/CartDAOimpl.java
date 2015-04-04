package org.inv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import org.beans.Cart;
import org.beans.DBbean;
import org.logg.RunInvLogger;

public class CartDAOimpl implements CartDAO {

	@Override
	public boolean addCart(Cart Cart) {
		Random r=new Random();
		int y=r.nextInt(1000);
		boolean done=false;
		int res=0;
		String sql="INSERT INTO ds_cart (id, session_id, user, product,qty,tax,unit_price,total) values('"+y+"','"+Cart.getSessionid()+"','"+Cart.getUser()+"','"+Cart.getProductname()+"','"+Cart.getQty()+"','"+Cart.getTax()+"','"+Cart.getUnit_price()+"','"+Cart.getTotal()+"')";
		try {
			DBbean.connect();
			res=DBbean.updateSQL(sql);
			if(res>0){
				done=true;
			}
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally{
			DBbean.close();
		}
		
		return done;
	}

	private static boolean checkAlreadyexists(String user,String session,Cart cart ){
		
		
		return true;
		
	}
	
	@Override
	public ArrayList<Cart> getbyUserandSession(String user, String session) {
		ArrayList<Cart> cartlist=new ArrayList<Cart>();
		String sql="select id,session_id,user,product,sum(qty) as qty,tax,unit_price,sum(total) as total from ds_cart where user='"+user+"' and session_id='"+session+"' group by product";
		ResultSet rs=null;
		try {
			DBbean.connect();
			rs=DBbean.execSQL(sql);
			//rs.last();
			//System.out.println(rs.getRow());
			
				
			RunInvLogger.getbaseLogger().info("Retriving Cart Info ");
			
				while(rs.next()){
					System.out.println(rs.getString("product"));
				//	System.out.println(rs.getString("qty"));
					Cart listcar=new Cart();
					listcar.setProductname(rs.getString("product"));
					listcar.setQty(rs.getString("qty"));
					listcar.setSessionid(rs.getString("session_id"));
					listcar.setTax(rs.getString("tax"));
					listcar.setTotal(rs.getString("total"));
					listcar.setUser(user);
					listcar.setUnit_price(rs.getString("unit_price"));
					cartlist.add(listcar);
				}
				
				
			
		} catch (Exception e  ) {
			RunInvLogger.getbaseLogger().debug(e.getMessage());
			RunInvLogger.getbaseLogger().error(e.fillInStackTrace());
			RunInvLogger.getbaseLogger().info(e.getLocalizedMessage());
		}
		finally{DBbean.close();}
		
		System.out.println("jj"+cartlist.size());
		
		return cartlist;
	}

	@Override
	public ArrayList<Cart> getall() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
