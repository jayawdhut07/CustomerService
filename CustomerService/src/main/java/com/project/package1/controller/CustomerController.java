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

import com.project.package1.entity.Customer;
import com.project.package1.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/save")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerService.saveCustomer(customer);

		ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/get/{cid}")
	public ResponseEntity<?> fetchCustomerDetails(@PathVariable("cid") int customerId) {

		Customer customer = customerService.getCustomerById(customerId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Customer> modifyCustomer(@RequestBody Customer customer) {

		Customer updatedCustomer = customerService.updateCustomerProfile(customer);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
	}
}
