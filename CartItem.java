package com.niit.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CartItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cartItemID;	
	private String cartID; 	 	
	private String userID;
	private String pro_Id;
	private int quantity;
	private double totalPrice;
	public String getCartItemID() {
		return cartItemID;
	}
	public void setCartItemID(String cartItemID) {
		this.cartItemID = cartItemID;
	}
	public String getCartID() {
		return cartID;
	}
	public void setCartID(String cartID) {
		this.cartID = cartID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPro_Id() {
		return pro_Id;
	}
	public void setPro_Id(String pro_Id) {
		this.pro_Id = pro_Id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public CartItem() {
		
		this.cartItemID ="CRTITEM" +UUID.randomUUID().toString().substring(24).toUpperCase();
			}

			

}
