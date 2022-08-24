package com.edu.bank.test;

import com.edu.bank.Account;

/*
 * Class Type Array의 생성과 선언
 * 
 */

public class BankArrayTest1 {
	public static void main(String[] args) {
		Account[] accounts = new Account[3];
		
		System.out.println(accounts);
		for(Account acc: accounts) System.out.println(acc);
		
		// 객체의 결과는 주소값이므로 Heap의 3칸에는 각각 주소가 들어가고 그 주소가 Account 객체 하나하나를 참조함
		// 그러므로 출력하면 주소값이 출력됨
		System.out.println("==============================");
		accounts[0] = new Account(10000, "부산은행");
		accounts[1] = new Account(20000, "국민은행");
		accounts[2] = new Account(30000, "신한은행");
		
		System.out.println(accounts);
		for(Account acc: accounts) System.out.println(acc);
		
		System.out.println("\n==============배열안의 정보를 출력==============");
		for(int i=0; i<accounts.length; i++) 
		     System.out.println(accounts[i].getBankName()+","+accounts[i].getBalance());
		 
//		for(Account acc: accounts) 
//			System.out.println(acc.getBankName() + ": " + acc.getBalance());
		
	}

}
