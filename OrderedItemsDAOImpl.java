package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.OrderedItemsDAO;
import com.niit.model.OrderedItems;

@Repository("orderedItemsDAO")
public class OrderedItemsDAOImpl implements OrderedItemsDAO {

	@Autowired
	SessionFactory sessionFactory;

	public OrderedItemsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(OrderedItems orderedItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderedItems);

	}

	@Transactional
	public void delete(String orderedItemId) {
		OrderedItems orderedItemsTodelete = new OrderedItems();
		orderedItemsTodelete.setOrderedItemId(orderedItemId);
		sessionFactory.getCurrentSession().delete(orderedItemsTodelete);

	}

	@Transactional
	public List<OrderedItems> listOrderedItems() {
		String hql="from OrderedItems";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<OrderedItems> listOfOrderedItems = query.getResultList();
		return listOfOrderedItems;
	}

}
