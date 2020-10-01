package com.code.springdemo.dao;

import java.util.List;

import com.code.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer thecustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
