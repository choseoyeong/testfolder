package com.edu.jdbc.test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.jdbc.dao.impl.CustomerDAOImpl;
import com.edu.jdbc.vo.Customer;

import config.ServerInfo;

public class CustomerDAOTest {

	public static void main(String[] args) {
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		
		Customer c1 = new Customer(111, "손흥민", "토트넘");
		Customer c2 = new Customer(777, "프랭키", "바르셀로나");
		
		ArrayList<Customer> tempArr = new ArrayList<Customer>();
		
		try {
			dao.registerCustomer(c1);
			tempArr = dao.getCustomer();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(tempArr != null)
			for(Customer c: tempArr) {
				System.out.println(c);
			}
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1.드라이버 연결 성공..");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패...");
		}
	}

}
