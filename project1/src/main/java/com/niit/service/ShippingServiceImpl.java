package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.ShippingDao;
import com.niit.model.ShippingAddress;

@Service
public class ShippingServiceImpl implements ShippingService{
@Autowired
private ShippingDao shippingDao;
	
	public ShippingAddress getShippingAddressById(int shippingId) {
		
		return shippingDao.getShippingAddressById(shippingId);
	}

}
