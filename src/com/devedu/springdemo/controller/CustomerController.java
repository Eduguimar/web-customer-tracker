package com.devedu.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devedu.springdemo.entity.Customer;
import com.devedu.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject the customerService
	@Autowired
	private CustomerService service;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		//get customers from the service
		List<Customer> customers = service.getCustomers();
		//add the customers to the model
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@RequestMapping("/showFormForAdd")
	public String addCustomer(Model theModel) {
		
		Customer customer = new Customer();
		theModel.addAttribute("customer", customer);
		
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		//save the customer on service
		service.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		Customer customer = service.getCustomer(id);
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
}
