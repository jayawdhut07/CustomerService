package com.project.package1.service;

import com.project.package1.model.CustomerModel;

public interface CustomerService {

	
	public CustomerModel saveCustomer(CustomerModel customerModel);
	
	public CustomerModel getCustomerById(int customerId);

	public CustomerModel updateCustomerProfile(CustomerModel customerModel);


}
