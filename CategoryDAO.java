package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;

public interface CategoryDAO {
 
	 //Declare all CRUD operations
	
	// public boolean saveOrUpdate(Category category);  //if save returns true then saved successfully...return type boolean is optional or else can be void
	
	public boolean delete(Category category);
	
	public Category get(String id);
	
	public List<Category> list();

	public boolean save(Category category);
	
	public boolean update(Category category);
}
