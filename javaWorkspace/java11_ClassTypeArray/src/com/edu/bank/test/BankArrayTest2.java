package com.edu.bank.test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankArrayTest2 {
	public static void main(String[] args) {
		Account[] accounts = {
			new Account(10000, "부산은행"),
			new Account(20000, "국민은행"),
			new Account(30000, "신한은행")
		};
		
		Customer james = new Customer(111, "James");
		
		// 1. James가 3개의 통장을 개설...부산, 국민, 신한은행
		james.setAccounts(accounts);
		
		// 2. James가 개설한 통장중에서 부산은행 통장을 받아온다.
		Account busanBK = null;		// 로컬변수이므로 초기화 해줘야함
		Account[] returnAcc = james.getAccounts();
		for(Account acc: returnAcc) {
			if(acc.getBankName().equals("부산은행"))	//string 비교는 '=='말고 'equals' 사용
				busanBK = acc;
		}
		
		System.out.println("========부산은행 통장에 입금을 합니다. ==========\n");
		busanBK.deposit(900.0);	//return됨
		busanBK.deposit(30000.0);
		System.out.println("========부산은행 통장에 입금을 합니다. ==========\n");
		busanBK.withdraw(50000.0);	// return됨
		busanBK.withdraw(30000.0);
		System.out.println("========부산은행 통장에 입금을 합니다. ==========\n");
		System.out.println("잔액확인: " + busanBK.getBalance());
		
	}

}
