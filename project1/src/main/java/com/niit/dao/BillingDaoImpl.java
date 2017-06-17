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

@Repository
@Transactional
public class BillingDaoImpl implements BillingDao{
@Autowired
private SessionFactory sessionFactory;

	@Transactional
	public BillingAddress getBillingAddressById(int billingId) {
		 try {
			 System.out.println("Getting BillingAddress for "+billingId);
			 Session session = sessionFactory.getCurrentSession();
		        Query query = session.createQuery("from BillingAddress where billingid = "+billingId);
		       //BillingAddress  billingAddressList=query.;
		       return (BillingAddress) query.uniqueResult();			   
			    
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception in getBillingAddressById ");
			e.printStackTrace();
			return null;
		}
		
		
	}

}
