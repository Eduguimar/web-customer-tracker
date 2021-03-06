package com.devedu.springdemo.dao;

import java.util.List;

import com.devedu.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(Long id);

	public void deleteCustomer(Long id);

}
