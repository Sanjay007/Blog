package org.inv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.beans.DBbean;
import org.beans.Tax;
import org.logg.RunInvLogger;

public class TaxDAOimpl implements TaxDAO {

	@Override
	public boolean addTax(Tax taxUser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tax getTaxById(String ID) throws SQLException {
		Tax taxById=new Tax();
		ResultSet rs=null;
		String sql="select * from ds_tax where tax_id='"+ID+"'";
		RunInvLogger.getbaseLogger().info("Executing TaxByID"+sql);
		try {
			DBbean.connect();
			rs=DBbean.execSQL(sql);
			if(rs.next()){
				taxById.setTaxDesc(rs.getString("tax_description"));
				taxById.setTaxid(Integer.parseInt(ID));
				taxById.setTaxEnable(rs.getString("tax_enabled"));
				taxById.setTaxPercent(rs.getString("tax_percentage"));
			}
		} catch (ClassNotFoundException e) {
			RunInvLogger.getbaseLogger().debug("CausedBY:"+e.getMessage());
			RunInvLogger.getbaseLogger().error(e.getCause());
			
		} catch (SQLException e) {
			RunInvLogger.getbaseLogger().debug("CausedBY:"+e.getMessage());
			RunInvLogger.getbaseLogger().error(e.getCause());
			
		}finally{
			DBbean.close();
			rs.close();
		}
	
		return taxById;
	}

	@Override
	public ArrayList<Tax> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editTax(Tax editZTax) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getTaxPercent(String ID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
