package com.edu.bank;

public class Account {
	//1.필드 선언
	private double balance;
	private String bankName;
	
	//2.주입통로를 결정
	public Account(double balance, String bankName) {
		super();
		this.balance = balance;
		this.bankName = bankName;
	}
	
	//3. 필드를 반환..
	public String getDetails() {
		return balance+","+bankName;
	}
	
	public String getBankName() {
		return bankName;
	}
	
	//나머지 기능들을 작성..
	public void deposit(double amt) {
		if(amt>=1000.0) {
			balance +=  amt; 
		}else {
			System.out.println("입금액은 1천원 이상으로 하셔야 합니다..");
			return;//호출한 지점으로 다시 되돌림...타당한 값을 다시 입력하도록 제어
		}
	}
	
	public void withdraw(double amt) {
		if(balance>=amt) {
			balance -=amt;
		}else {
			System.out.println("잔액보다 출금액이 많아서 출금이 안됩니다..");
			return;
		}
	}
	
	public double getBalance() {
		return balance;
	}	
}




