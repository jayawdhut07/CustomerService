package com.project.package1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.package1.model.CustomerModel;
import com.project.package1.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/save")
	public ResponseEntity<CustomerModel> addCustomer(@RequestBody CustomerModel customerModel) {
		CustomerModel newCustomer = customerService.saveCustomer(customerModel);

		ResponseEntity<CustomerModel> responseEntity = new ResponseEntity<CustomerModel>(newCustomer, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/get/{cid}")
	public ResponseEntity<?> fetchCustomerDetails(@PathVariable("cid") int customerId) {

		CustomerModel customerModel = customerService.getCustomerById(customerId);
		
		return new ResponseEntity<>(customerModel, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<CustomerModel> modifyCustomer(@RequestBody CustomerModel customerModel) {

		CustomerModel updatedCustomer = customerService.updateCustomerProfile(customerModel);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}
}
