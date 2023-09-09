package com.dev.attendance.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Student {

	@Id
	private String id;
	
	@Field
	private Integer batchNumber;
	@Field
	private String firstName;
	@Field
	private String lastName;
	@Field
	private Integer deposit;
	@Field
	private Integer balance;
	@Field
	private String email;
	@Field
	private String mobile;
	@Field
	private String address;
	
	public Student() {}
	
	public Student(String id, Integer batchNumber, String firstName, String lastName, Integer deposit, Integer balance, String email,
			String mobile, String address) {
		super();
		this.id = id;
		this.batchNumber = batchNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deposit = deposit;
		this.balance = balance;
		this.email = email;
		this.mobile = mobile;
		this.address = address;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getDeposit() {
		return deposit;
	}
	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public Integer getBatchNumber() {
		return batchNumber;
	}
	public void setBatchNumber(Integer batchNumber) {
		this.batchNumber = batchNumber;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", batch=" + batchNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", deposit=" + deposit + ", balance=" + balance + ", email=" + email + ", mobile=" + mobile
				+ ", address=" + address + "]";
	}	
}
