package org.inv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.beans.DBbean;
import org.logg.RunInvLogger;

public class DashDAOimpl implements DashbDAO {

	@Override
	public int getUserCount() {
		ResultSet rscount=null;	
		int count=0;
		try {
					DBbean.connect();
					
					rscount=DBbean.execSQL("select count(*) from ds_user");
					
					count=rscount.next()?rscount.getInt(1):0;
					
		} catch (SQLException e) {
		
			RunInvLogger.getbaseLogger().error(e);
			
		} catch (Exception e) {
			RunInvLogger.getbaseLogger().error(e);
		} 
			
				finally{
					try {
						DBbean.close();
						rscount.close();
					} catch (SQLException e) {
						RunInvLogger.getbaseLogger().error(e);
					}
				}
		return count;
			
	}

	@Override
	public int getInvoiceCount() {
		
		String sql=new String("select count(*) from ds_invoices");
		return getcount(sql);
	}

	@Override
	public int getProductCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDueCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAmountPaid() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static int getcount(String sqlCount){
		
		ResultSet rscount=null;	
		int count=0;
		try {
					DBbean.connect();
					
					rscount=DBbean.execSQL(sqlCount);
					
					count=rscount.next()?rscount.getInt(1):0;
					
		} catch (SQLException e) {
		
			RunInvLogger.getbaseLogger().error(e);
			
		} catch (Exception e) {
			RunInvLogger.getbaseLogger().error(e);
		} 
			
				finally{
					try {
						DBbean.close();
						rscount.close();
					} catch (SQLException e) {
						RunInvLogger.getbaseLogger().error(e);
					}
				}
		return count;
	}

}
