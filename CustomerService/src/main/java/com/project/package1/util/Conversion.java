package com.project.package1.util;


import org.springframework.stereotype.Component;

import com.project.package1.entity.Customer;
import com.project.package1.model.CustomerModel;

@Component
public class Conversion {

	public Customer modelToEntity(CustomerModel customerModel) {
		
		Customer customer = new Customer();
		
        customer.setAddress(customerModel.getAddress());
        customer.setAge(customerModel.getAge());
        customer.setCustomerId(customerModel.getCustomerId());
        customer.setCustomerName(customerModel.getCustomerName());
        customer.setDob(customerModel.getDob());
        customer.setEmail(customerModel.getEmail());
        customer.setGender(customerModel.getGender());
        customer.setGovtId(customerModel.getGovtId());
        customer.setMobileNo(customerModel.getMobileNo());
       
        return customer;
        
        
		
	}
	
	public CustomerModel entityToModel(Customer customer) {
		
		CustomerModel customerModel = new CustomerModel();
		
		customerModel.setAddress(customer.getAddress());
		customerModel.setAge(customer.getAge());
		customerModel.setCustomerId(customer.getCustomerId());
		customerModel.setCustomerName(customer.getCustomerName());
		customerModel.setDob(customer.getDob());
		customerModel.setEmail(customer.getEmail());
		customerModel.setGender(customer.getGender());
		customerModel.setGovtId(customer.getGovtId());
		customerModel.setMobileNo(customer.getMobileNo());
       
        return customerModel;
        
	}
}
