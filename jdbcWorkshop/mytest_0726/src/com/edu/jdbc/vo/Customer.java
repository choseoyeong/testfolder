package com.edu.jdbc.vo;

public class Customer {
	private int ssn;
	private String custName;
	private String address;
	
	public static final String BASE_NAME = "홍길동";
	public static final String BASE_ADDRESS = "기본주소";
	
	
	public Customer(int ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.custName = name;
		this.address = address;
	}
	
	public Customer(int ssn) {
		this(ssn, BASE_NAME, BASE_ADDRESS);
	}
	

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return custName;
	}

	public void setName(String name) {
		this.custName = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return ssn + "\t" + custName + "\t" + address;
	}
	
	
}
