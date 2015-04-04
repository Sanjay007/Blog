package org.inv.dao;

import java.util.ArrayList;

import org.beans.Tax;

public interface TaxDAO {


public boolean addTax(Tax taxUser);
public Tax getTaxById(String ID) throws Exception;
public ArrayList<Tax> getList();
public boolean editTax(Tax editZTax);

public double getTaxPercent(String ID);
			
}
