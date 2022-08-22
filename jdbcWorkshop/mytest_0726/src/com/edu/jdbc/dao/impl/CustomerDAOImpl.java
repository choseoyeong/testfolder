package com.edu.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.jdbc.dao.CustomerDAO;
import com.edu.jdbc.exception.DuplicateSsnException;
import com.edu.jdbc.exception.RecordNotFoundException;
import com.edu.jdbc.vo.Customer;

import config.ServerInfo;

public class CustomerDAOImpl implements CustomerDAO{
	private static CustomerDAOImpl dao = new CustomerDAOImpl();
	private CustomerDAOImpl() {
		System.out.println("싱글톤 패턴 생성중...");
	}
	public static CustomerDAOImpl getInstance() {
		return dao;
	}

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public Connection getConnect() throws SQLException {
		conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		
		System.out.println("DB 서버 연결...");
		
		return conn;
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}

	@Override
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(conn, ps);
	}
	
	// 존재 여부 확인 함수
	private boolean ssnExist(int ssn, Connection conn) throws SQLException, DuplicateSsnException{
		
		String query = "SELECT ssn FROM customer WHERE ssn=?";
		ps = conn.prepareStatement(query);
		
		ps.setInt(1, ssn);
		
		rs = ps.executeQuery();
		
		return rs.next();
	}

	@Override
	public void registerCustomer(Customer vo) throws SQLException, DuplicateSsnException {
		conn = getConnect();
		
		try {
			if(!ssnExist(vo.getSsn(), conn)) {
				String query = 
						"INSERT INTO customer(ssn, cust_name, address) VALUES(?,?,?)";
				ps = conn.prepareStatement(query);
				
				ps.setInt(1, vo.getSsn());
				ps.setString(2, vo.getName());
				ps.setString(3, vo.getAddress());
				
				System.out.println(ps.executeUpdate() + " 명이 추가되었습니다.");
			}
			else {
				throw new DuplicateSsnException("이미 존재하는 사람입니다.");
			}
		} finally {
			closeAll(conn, ps);
		}
	}

	@Override
	public void removeCustomer(int ssn) throws SQLException, RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(Customer vo) throws SQLException, RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomer(int ssn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Customer> getCustomer() throws SQLException {
		ArrayList<Customer> custArray = new ArrayList<Customer>();
		conn = getConnect();
		try {
			String query = "SELECT * FROM customer";
			ps = conn.prepareStatement(query);

			rs = ps.executeQuery();
			while(rs.next()) {
				custArray.add(
						new Customer(rs.getInt("ssn"), rs.getString("cust_name"), rs.getString("address")));
			}
		} finally {
			closeAll(conn, ps, rs);
		}
		
		return custArray;
	}

	@Override
	public ArrayList<Customer> getCustomer(String address) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCountByAddress(String address) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
