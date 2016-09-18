package com.niit.dao;

import com.niit.model.ShippingAddress;

public interface ShippingAddressDAO {

void saveOrUpdate(ShippingAddress shippingAddress);
	
	void deleteShippingAddress(String shippingAddressId);
	
	ShippingAddress getShippingAddress(String shippingAddressId);
}

