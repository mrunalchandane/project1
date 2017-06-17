package com.niit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;

@Repository
@Transactional
public class CartDaoImpl implements CartDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Cart getCart(int customerId) {
		System.out.println("getting cart in CartDaoImpl with customerID = "+customerId);
		String hql="from Cart where customer_ID = " + "'" + customerId + "'";
		
		@SuppressWarnings({ "rawtypes" })
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings({ "unchecked" })
		List<Cart> list=query.list();
		if(list==null || list.isEmpty())
		{
			System.out.println("No cart found with this customerID in CartDaoImpl");
			return null;
		}
		else
		{
			return list.get(0);
		}
	}


	public void updateCart(Cart cart) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(cart);
			session.flush();
			System.out.println("Cart successfully updated in CartDaoImpl");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while updating Cart in CartDaoImpl");
			
			e.printStackTrace();
		}
		
	}

}
