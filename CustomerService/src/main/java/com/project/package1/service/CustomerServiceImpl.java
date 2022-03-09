package com.project.package1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.package1.entity.Customer;
import com.project.package1.exception.CustomerNotFoundException;
import com.project.package1.model.CustomerModel;
import com.project.package1.repository.CustomerRepository;
import com.project.package1.util.Conversion;

@Service
public class CustomerServiceImpl implements CustomerService {


	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private Conversion conversion;
	
	
	/******************************************
	 - Method Name      : saveCustomer
	 - Input Parameters : CustomerModel customerModel
	 - Return type      : CustomerModel
	 - Author           : Jay Vitthal Awdhut
	 - Creation Date    : 09-03-2022
	 - Description      : Customer entering customer details
	  ******************************************/
	
	@Override
	public CustomerModel saveCustomer(CustomerModel customerModel) {
		Customer customer1=customerRepository.save(conversion.modelToEntity(customerModel));
		return conversion.entityToModel(customer1);
	}
	
	/******************************************
	 - Method Name      : getCustomerById
	 - Input Parameters : int customerId
	 - Return type      : int
	 - Author           : Jay Vitthal Awdhut
	 - Creation Date    : 09-03-2022
	 - Description      : Getting customer details from customerId
	  ******************************************/
	
	@Override
	public CustomerModel getCustomerById(int customerId) throws CustomerNotFoundException{
		
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		
		if(optionalCustomer.isEmpty()) {
			
			throw new CustomerNotFoundException("Sorry! Customer not found with id" + customerId);
			
		}
		
		return conversion.entityToModel(optionalCustomer.get());
		
	}

	/******************************************
	 - Method Name      : updateCustomerProfile
	 - Input Parameters : CustomerModel customerModel
	 - Return type      : CustomerModel
	 - Author           : Jay Vitthal Awdhut
	 - Creation Date    : 09-03-2022
	 - Description      : Updating the customer deatils
	  ******************************************/
	@Override
	public CustomerModel updateCustomerProfile(CustomerModel customerModel) {
	    Optional<Customer> optionalCustomer = customerRepository.findById(customerModel.getCustomerId());
			
			if(optionalCustomer.isEmpty()) {
				
				throw new CustomerNotFoundException("Sorry! customer not found with id" +customerModel.getCustomerId());
				
			}
			
			Customer updatedCustomer = customerRepository.save(conversion.modelToEntity(customerModel));
			return conversion.entityToModel(updatedCustomer);

	}

}



