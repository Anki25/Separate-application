package com.niit.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CartItem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String cartItemID;	
	@ManyToOne
	@JoinColumn(name="pro_Id", unique=true, nullable=false, updatable=false)
	private Product product;
	/*@ManyToOne
	@JoinColumn(name="cartid", unique=true, nullable=false, updatable=false)
	private Cart cart;*/
	private int quantity;
	private double price;
	
	public String getCartItemID() {
		return cartItemID;
	}
	public void setCartItemID(String cartItemID) {
		this.cartItemID = cartItemID;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	/*public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}*/
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public CartItem() {
		
		this.cartItemID ="CRTITEM" +UUID.randomUUID().toString().substring(24).toUpperCase();
			}

			

}
