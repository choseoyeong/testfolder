package com.bank.busan;

import com.bank.busan.Account;

	public class Customer {
		public String name;
		public Account account;
		public String address;
		
		public Customer(String name, String address) {
			this.name = name;
			this.address = address;
		}
		
		public void makeAccount(Account account) {
			this.account = account;
		}

		public String getName() {
			return name;
		}

		public Account getAccount() {
			return account;
		}

	
}
