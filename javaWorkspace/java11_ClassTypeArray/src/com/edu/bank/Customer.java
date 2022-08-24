package com.edu.bank;
/*
 * 통장을 개설하는 은행의 고객정보를 담고 있는 클래스..
 * 이때 여러개의 통장 개설이 가능하다. 
 */
public class Customer {
	//1. 필드 선언
	//생성자 주입
	private int ssn;
	private String name;
	
	//Has a Relation
	//setter주입
	private Account[] accounts;
	
	
	//2. 선언한 필드값을 각각 주입한다.
	public Customer(int ssn, String name) {
		super();
		this.ssn = ssn;
		this.name = name;
	}	

	/////////////////////////////////////////////////
	
	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	
	//고객의 정보를 반환
	public String getCustomerInfo() {
		return ssn+", "+ name;
	}
}



















