package com.bank.busan.test;

import java.util.Scanner;

import com.bank.busan.Account;
import com.bank.busan.Customer;

public class BankAppTest {

	public static void main(String[] args) {
		
		System.out.println("계좌번호>>");
		Scanner sc = new Scanner(System.in);
		int accnumber1 = sc.nextInt();
		
		System.out.println("이름>>");
		String custName1 = sc.next();
		
		System.out.println("잔액>>");
		double balance1 = sc.nextDouble();
		
		System.out.println("은행명>>");
		String bankName1 = sc.next();
		
		System.out.println("계좌번호>>");
		int accnumber2 = sc.nextInt();
		
		System.out.println("이름>>");
		String custName2 = sc.next();
		
		System.out.println("잔액>>");
		double balance2 = sc.nextDouble();
	
		System.out.println("은행명>>");
		String bankName2 = sc.next();
		
		Account ac1 = new Account(accnumber1, custName1, balance1, bankName1);
		Account ac2 = new Account(accnumber2, custName2, balance2, bankName2);
		
		Customer cu1 = new Customer("미정", "부산");
		Customer cu2 = new Customer("자경", "대구");
		
		cu1.makeAccount(ac1);
		cu2.makeAccount(ac2);
		
		// getAccount 빠져있음. 추가해야함
		
		ac1.deposit(7000.00);
		ac1.withdraw(5000.00);
		ac1.deposit(7000.00);
	
		ac1.withdraw(4000.00);
		ac1.deposit(7000.00);
		ac1.deposit(300.00);
		ac1.withdraw(10000000.00);
		System.out.println(ac1.getBalance());
		
		sc.close();
	}
	
}
