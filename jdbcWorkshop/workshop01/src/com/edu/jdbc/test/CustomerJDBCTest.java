package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import sql.QueryInfo;

public class CustomerJDBCTest {
	public CustomerJDBCTest() throws ClassNotFoundException, SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 1) 드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1. 드라이버 로딩 성공...");
			
			// 2) 디비 서버 연결
			conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
			System.out.println("2. DB서버 연결 성공...");
			
			
			// 3) PreparedStatement 생성
			ps = conn.prepareStatement(QueryInfo.query);
			System.out.println("3. PreparedStatement 생성...");
			
			// 4) sql 실행하기 (DML과 SELECT)
			rs = ps.executeQuery();
			System.out.println("4. 실행..");
			
			
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}		
	}
	
	
	public static void main(String[] args) throws Exception{
		new CustomerJDBCTest();
	}

}
