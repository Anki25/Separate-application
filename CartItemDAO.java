package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;

public interface CartItemDAO {

	boolean save(CartItem cartItem);
	
	boolean update(CartItem cartItem);

	void delete(String cartItemId);

	CartItem getCartItem(String cartItemId);
	
	CartItem getCartItemsByProductId(String productID);

	List<CartItem> getCartItemsByCustomerId(String customerId);

	List<CartItem> listCartItems();

}

