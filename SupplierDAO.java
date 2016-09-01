package com.niit.shoppingcart.dao;

import java.util.List;


import com.niit.shoppingcart.model.Supplier;

public interface SupplierDAO {
 
	 //Declare all CRUD operations
	
	public boolean save(Supplier supplier);  //if save returns true then saved successfully...return type boolean is optional or else can be void
	
	public boolean update(Supplier supplier);
	
	public boolean delete(Supplier supplier);
	
	public Supplier get(String id);
	
	public List<Supplier> list();
}
