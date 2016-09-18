package com.niit.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class OrderedItems implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String orderedItemId;
	private String userId;
	private String pro_Id;
	private String pro_name;
	private double totalPrice;
	private int quantity;

	public String getOrderedItemId() {
		return orderedItemId;
	}

	public void setOrderedItemId(String orderedItemId) {
		this.orderedItemId = orderedItemId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPro_Id() {
		return pro_Id;
	}

	public void setPro_Id(String pro_Id) {
		this.pro_Id = pro_Id;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderedItems() {
		this.orderedItemId = "OI" + UUID.randomUUID().toString().substring(24).toUpperCase();
	}

}
