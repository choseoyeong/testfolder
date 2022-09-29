package com.bank.busan;

public class Account {
	public int accNumber;
	public String custName;
	public double balance;
	public String bankName;

	public Account(int accNumber, String custName, double balance, String bankName) {
		this.accNumber = accNumber;
		this.custName = custName;
		this.balance = balance;
		this.bankName = bankName;
	}

	public double getBalance() {
		return balance;
	}

	public void withdraw(double amt) {
		if (balance>amt) balance -=amt;
	}
	
	public void deposit(double amt) {
		if (amt>=1000) balance +=amt;
	}
	
	public String getAccountInfo() {
		return accNumber + ", "+ custName;
	}

	public String getBankName() {
		return bankName;
	}
	
}
