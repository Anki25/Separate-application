package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;

public interface CartItemDAO {

	void saveOrUpdate(CartItem cartItem);

	void delete(String cartItemId);

	CartItem getCartItem(String cartItemId);

	List<CartItem> getCartItemsByCustomerId(String customerId);

	List<CartItem> listCartItems();

}

