package com.project.package1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.package1.entity.Customer;
import com.project.package1.exception.CustomerNotFoundException;
import com.project.package1.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {


	@Autowired
	private CustomerRepository customerRepository;

	
	@Override
	public Customer saveCustomer(Customer customer) {
		Customer customer1=customerRepository.save(customer);
		return customer1;
	}
	
	@Override
	public Customer getCustomerById(int customerId) throws CustomerNotFoundException {
		
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		
		if(optionalCustomer.isEmpty()) {
			
			throw new CustomerNotFoundException("Sorry! Customer not found with id" +customerId);
			
		}
		
		return optionalCustomer.get();
		
	}

	@Override
	public Customer updateCustomerProfile(Customer customer) {
	    Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
			
			if(optionalCustomer.isEmpty()) {
				
				throw new CustomerNotFoundException("Sorry! customer not found with id" +customer.getCustomerId());
				
			}
			
			Customer updatedCustomer = customerRepository.save(customer);
			return updatedCustomer;

	}

}



