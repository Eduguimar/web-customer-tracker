package com.devedu.springdemo.service;

import java.util.List;

import com.devedu.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

}
