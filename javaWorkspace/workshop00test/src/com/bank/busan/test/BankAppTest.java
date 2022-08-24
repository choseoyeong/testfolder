package com.bank.busan.test;

import java.util.Scanner;

import com.bank.busan.Account;
import com.bank.busan.Customer;

public class BankAppTest {
	
	static Account ac;

	public static void main(String[] args) {		
		Customer c1 = new Customer("미정", "Busan");
		Customer c2 = new Customer("자경", "Seoul");
		
		System.out.println("고객1 등록");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("계좌번호: ");
		int accNumber1 = sc.nextInt();
		System.out.println("고객명: ");
		String custName1 = sc.next();
		System.out.println("잔액: ");
		double balance1 = sc.nextDouble();
		System.out.println("은행명: ");
		String bankName1 = sc.next();
		
		Account a1 = new Account(accNumber1, custName1, balance1, bankName1);
		System.out.println("고객1 등록 완료.");
		
		System.out.println("\n\n고객2 등록");
		System.out.println("계좌번호: ");
		int accNumber2 = sc.nextInt();
		System.out.println("고객명: ");
		String custName2 = sc.next();
		System.out.println("잔액: ");
		double balance2 = sc.nextDouble();
		System.out.println("은행명: ");
		String bankName2 = sc.next();
		
		Account a2 = new Account(accNumber2, custName2, balance2, bankName2);
		System.out.println("고객2 등록 완료.\n\n");
		
		c1.setAccount(a1);
		c2.setAccount(a2);
		
		Account c1Account = c1.getAccount();
		System.out.println("c1's " + c1Account.getAccountInfo());
		
		Account c2Account = c2.getAccount();
		System.out.println("c2's " + c2Account.getAccountInfo());
		System.out.println("\n\n");
		
		
	
		// 뱅킹
		System.out.println("거래하시는 분의 성함을 입력하세요: ");
		String custName = sc.next();
		
		int num = -1;
		
		switch(custName) {
			case "미정":
				ac = a1;
				break;
			case "자경":
				ac = a2;
				break;
			default:
				System.out.println("존재하지 않는 회원입니다.");
		}
		
		while(ac != null & num != 0) {
			System.out.println("\n1: 입금, 2: 출금, 3: 잔액확인, 0: 종료");
			num = sc.nextInt();
			switch(num) {
				case 1:
					System.out.println("입금 금액: ");
					double depositAmt = sc.nextDouble();
					if(depositAmt < 1000)
						System.out.println("1000원부터 입금이 가능합니다.");
					else {
						ac.deposit(depositAmt);
						System.out.println(depositAmt + "원 입금 후 잔액은 " + ac.getBalance() + "원 입니다.");
					}
					break;
				case 2:
					System.out.println("출금 금액: ");
					double withdrawAmt = sc.nextDouble();
					if(ac.getBalance() < withdrawAmt)
						System.out.println("잔액이 부족합니다.");
					else {
						ac.withdraw(withdrawAmt);
						System.out.println(withdrawAmt + "원 출금 후 잔액은 " + ac.getBalance() + "원 입니다.");
					}
					
					break;
				case 3:
					System.out.println("잔액: " + ac.getBalance());
					break;
				case 0:
					System.out.println("종료되었습니다.");
					return ;
				default:
			}
		}
		sc.close();
	}

}
