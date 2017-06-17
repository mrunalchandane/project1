package com.niit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.BillingAddress;
import com.niit.model.Customer;
import com.niit.model.ShippingAddress;

@Repository
@Transactional
public class ShippingDaoImpl implements ShippingDao{
@Autowired
private SessionFactory sessionFactory;

	public ShippingAddress getShippingAddressById(int shippingId) {
		try {
		Session session=sessionFactory.getCurrentSession();
		Query query = session.createQuery("from ShippingAddress where shippingid = "+shippingId );
		 return (ShippingAddress) query.uniqueResult();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in getShippingAddressById ");
			e.printStackTrace();
			return null;
		}
		
	}

}
