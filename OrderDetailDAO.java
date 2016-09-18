package com.niit.dao;

import java.util.List;

import com.niit.model.OrderDetail;

public interface OrderDetailDAO {

	void saveOrUpdate(OrderDetail orderDetail);

	void delete(String orderDetailId);

	List<OrderDetail> listOrderDetails();

}

