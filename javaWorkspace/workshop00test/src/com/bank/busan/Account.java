package com.bank.busan;

public class Account {
	public int accNumber;
	public String custName;
	public double balance;
	public String bankName;
	
	public Account(int accNumber,
				String custName,
				double balance,
				String bankName) {
		this.accNumber = accNumber;
		this.custName = custName;
		this.balance = balance;
		this.bankName = bankName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void withdraw(double amt) {
		balance -= amt;	
	}
	
	public void deposit(double amt) {
		balance += amt;
	}
	
	public String getAccountInfo() {
		return "AccountInfo:: " + accNumber 
								+ "\t" + custName
								+ "\t" + balance
								+ "\t" + bankName;
	}
	
	public String getBankName() {
		return bankName;
	}
	
}
