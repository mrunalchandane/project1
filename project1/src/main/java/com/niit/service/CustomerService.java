package com.niit.service;

import java.util.List;

import com.niit.model.Customer;

public interface CustomerService {
void saveCustomer(Customer customer);
List<Customer> getCustomers();
}
