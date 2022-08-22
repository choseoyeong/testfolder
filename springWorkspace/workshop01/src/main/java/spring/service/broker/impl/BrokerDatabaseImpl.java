package spring.service.broker.impl;

import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

import spring.service.broker.BrokerDatabase;
import spring.service.domain.Customer;
import spring.service.domain.Stock;

public class BrokerDatabaseImpl implements BrokerDatabase{

	@Override
	public void registerCustomer(Customer customer) {
		System.out.println(customer.getCustName() + "�� ��� �Ϸ�");
	}

	@Override
	public void registerStock(Stock stock) {
		System.out.println(stock.getSymbol() + " stock ��� �Ϸ�");
	}

	@Override
	public ArrayList<Customer> getAllCustomer() {
		System.out.println("getAll Customer");
		return null;
	}

	@Override
	public ArrayList<Stock> getAllStock() {
		System.out.println("getAll Stock");
		return null;
	}

}
