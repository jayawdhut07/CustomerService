package com.project.package1.service;

import com.project.package1.entity.Customer;

public interface CustomerService {

	
	public Customer saveCustomer(Customer customer);
	
	public Customer getCustomerById(int customerId);

	public Customer updateCustomerProfile(Customer customer);


}
