package com.learn2code.springdemo.dao;

import java.util.List;

import com.learn2code.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
