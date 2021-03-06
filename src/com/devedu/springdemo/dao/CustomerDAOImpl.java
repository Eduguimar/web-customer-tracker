package com.devedu.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devedu.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		//execute query
		List<Customer> customers = theQuery.getResultList();
		//return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//save/update the customer
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(Long id) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//get the customer
		Customer customer = currentSession.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void deleteCustomer(Long id) {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//delete the customer
		Query<Customer> theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", id);
		
		theQuery.executeUpdate();
	}

}
