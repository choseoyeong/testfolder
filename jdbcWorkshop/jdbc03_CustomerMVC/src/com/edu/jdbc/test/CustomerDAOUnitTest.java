package com.edu.jdbc.test;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.edu.jdbc.dao.impl.CustomerDAOImpl;
import com.edu.jdbc.exception.RecordNotFoundException;
import com.edu.jdbc.vo.Customer;

import config.ServerInfo;

public class CustomerDAOUnitTest {

	public static void main(String[] args) throws RecordNotFoundException {
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		
		Customer c1 = new Customer(111, "손흥민", "토트넘");
		Customer c2 = new Customer(222, "김덕배", "맨시티");
		Customer c3 = new Customer(333, "황희찬", "울브스");
		Customer c4 = new Customer(444, "정상빈", "울브스");
		Customer c5 = new Customer(555, "로메로", "토트넘");
		Customer c6 = new Customer(666, "이재성", "마인츠");
		
		Customer nc6 = new Customer(666, "이재성", "뮌헨");
		
		ArrayList<Customer> custArray = new ArrayList<Customer>();
		
		try {
//			dao.registerCustomer(nc6);
			
//			dao.removeCustomer(111);

//			dao.getCustomer(111);
//			custArray = dao.getCustomer("울브스");
			
//			custArray = dao.getCustomer();
			
//			dao.updateCustomer(nc6);
//			dao.getCustomer(666);
			
//			System.out.println(dao.getCountByAddress("울브스"));
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} 
		
		
		
		for(Customer c: custArray) { System.out.println(c);	}
		
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1. 드라이버 로딩 성공...");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패...");
		}
		
	}

}
