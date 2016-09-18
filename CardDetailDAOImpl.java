package com.niit.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CardDetailDAO;
import com.niit.model.CardDetail;

@Repository("cardDetailDAO")
public class CardDetailDAOImpl implements CardDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public CardDetailDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public void saveOrUpdate(CardDetail cardDetail) {
	sessionFactory.getCurrentSession().saveOrUpdate(cardDetail);

	}

}
