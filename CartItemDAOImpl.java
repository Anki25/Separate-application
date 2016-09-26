package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemDAO;
import com.niit.model.CartItem;

@Repository("cartItemDAO")
public class CartItemDAOImpl implements CartItemDAO {

	@Autowired
	SessionFactory sessionFactory;

	public CartItemDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean save(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}


	}

	@Transactional
	public void delete(String cartItemId) {
		CartItem cartItemToDelete = new CartItem();
		cartItemToDelete.setCartItemID(cartItemId);
		sessionFactory.getCurrentSession().delete(cartItemToDelete);
	}

	@Transactional
	public List<CartItem> getCartItemsByCustomerId(String userId) {
		String hql = "from CartItem where userID=" + "'" + userId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartItem> listOfCartItems = query.getResultList();
		return listOfCartItems;
	}

	@Transactional
	public List<CartItem> listCartItems() {
		String hql = "from CartItem";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartItem> cartItems = query.getResultList();
		return cartItems;

	}

	@Transactional
	public CartItem getCartItem(String cartItemId) {
		String hql = "from CartItem where cartItemId=" + "'" + cartItemId + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartItem> cartItemList = query.getResultList();
		if(cartItemList!=null && !cartItemList.isEmpty())
			return cartItemList.get(0);
		else
		return null;
	}

	@Transactional
	public CartItem getCartItemsByProductId(String productID) {
		// TODO Auto-generated method stub
		String hql = "from CartItem where pro_Id=" + "'" + productID + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<CartItem> cartItemList = query.getResultList();
		if(cartItemList!=null && !cartItemList.isEmpty())
			return cartItemList.get(0);
		else
		return null;
	}

	public boolean update(CartItem cartItem) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
		
	}


