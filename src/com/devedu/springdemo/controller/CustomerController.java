package com.devedu.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devedu.springdemo.dao.CustomerDAO;
import com.devedu.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject the customerDAO
	@Autowired
	private CustomerDAO dao;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		//get customers from the dao
		List<Customer> customers = dao.getCustomers();
		//add the customers to the model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}

}
