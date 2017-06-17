package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.niit.dao.CustomerDao;
import com.niit.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
private CustomerDao customerDao;
	
	public void saveCustomer(Customer customer) {
		   customerDao.saveCustomer(customer);
		}
		public List<Customer> getCustomers() {
			return customerDao.getCustomers();
		}
		
		public Customer getCustomerByName(String username) {
			
			return customerDao.getCustomerByName(username);
		}
	
}
