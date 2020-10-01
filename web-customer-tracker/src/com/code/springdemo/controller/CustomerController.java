package com.code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.code.springdemo.entity.Customer;
import com.code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String customerList(Model theModel)
	{
		List<Customer> getCustomer = customerService.getCustomer();		
		
		theModel.addAttribute("customers", getCustomer);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Customer thecustomer = new Customer();
		
		
		theModel.addAttribute("customer",thecustomer);
		return "customer-form";
		
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer")Customer thecustomer)
	{
		
		customerService.saveCustomer(thecustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model themodel )
	{
		Customer thecustomer = customerService.getCustomer(theId);
		
		themodel.addAttribute("customer",thecustomer);
		
		return "customer-form";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId)
	{
		customerService.deleteCustomer(theId);
		
		
		return "redirect:/customer/list";
	}
	

}
