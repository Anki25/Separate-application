package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;


public interface ProductDAO {
 
	 //Declare all CRUD operations
	public boolean add(Product product);
	
	public boolean save(Product product);  //if save returns true then saved successfully...return type boolean is optional or else can be void
	
	public boolean update(Product product);  //to find and replace select word ctrl C and ctrl F
	
	public boolean delete(Product product);
	
	public Product get(String id);
	
	public List<Product> list();
}
