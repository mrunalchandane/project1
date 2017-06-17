package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.BillingDao;
import com.niit.model.BillingAddress;

@Service
public class BillingServiceImpl implements BillingService{
@Autowired
private BillingDao billingDao;
	
	public BillingAddress getBillingAddressById(int billingId) {
		
		return billingDao.getBillingAddressById(billingId);
	}

}
