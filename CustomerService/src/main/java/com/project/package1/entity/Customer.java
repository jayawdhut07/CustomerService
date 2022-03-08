package com.project.package1.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Insurance_tbl")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "CustomerId")
	private int customerId;

	@Column(name = "Name")
	private String customerName;

	@Column(name = "PhoneNo")
	private String mobileNo;

	@Column(name = "Email")
	private String email;

	@Column(name = "Gender")
	private char gender;

	@Column(name = "Dob")
	private LocalDate dob;

	@Column(name = "Age")
	private int age;

	@Column(name = "Address")
	private String address;

	@Column(name = "Govt_Id")
	private int govtId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getGovtId() {
		return govtId;
	}

	public void setGovtId(int govtId) {
		this.govtId = govtId;
	}

	
	

}