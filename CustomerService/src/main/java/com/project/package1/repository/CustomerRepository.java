package com.project.package1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.package1.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	//Optional<Customer> findById(String customerId);

}
