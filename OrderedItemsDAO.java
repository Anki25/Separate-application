package com.niit.dao;

import java.util.List;

import com.niit.model.OrderedItems;

public interface OrderedItemsDAO {

	void saveOrUpdate(OrderedItems orderedItems );
	
	void delete(String orderedItemId);
	
	List<OrderedItems> listOrderedItems();
}
