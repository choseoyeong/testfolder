package com.edu.vo;

public class Customer {
	private String customerName;
	private int ssn;
	private String phone;

	private Pet[] pets;

	public Customer(String customerName, int ssn, String phone) {
		super();
		this.customerName = customerName;
		this.ssn = ssn;
		this.phone = phone;
	}
	
	public void setPets(Pet[] pets) {
		this.pets = pets;
	}
	

	public String getCustomerName() {
		return customerName;
	}

	public int getSsn() {
		return ssn;
	}

	public String getPhone() {
		return phone;
	}

	public Pet[] getPets() {
		return pets;
	}
	
	
}
