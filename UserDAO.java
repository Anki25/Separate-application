package com.niit.shoppingcart.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.User;

@Repository
public interface UserDAO {
 
	 //Declare all CRUD operations
	
	public boolean save(User user);  //if save returns true then saved successfully...return type boolean is optional or else can be void
	
	public boolean update(User user);
	
	public boolean delete(User user);
	
	public User get(String id);
	
	public List<User> list();
}
