package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import sql.QueryInfo;

/*
 * Test3의 문제점은
 * 1. 상수값으로 서버 정보를 지정했지만 더 나은 방식은 프로그램과 완전히 분리시키는 것이다.
 * 	 다시말해서 서버의 파편적인 정보를 "MetaData화" 시키겠다.
 * 	 -> interface 적용
 */
public class DBConnectionTest4 {
	public DBConnectionTest4() throws ClassNotFoundException, SQLException{
		// 로컬변수로 일단 선언..
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 로딩...
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1. 드라이버 로딩 성공...");
			
			// 2. DB 서버와 연결
			conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
			System.out.println("2. DB서버 연결 성공...");
			
			// 3. PreparedStatement 객체 생성
			ps = conn.prepareStatement(QueryInfo.query);
			System.out.println("3. PrepareStatement 생성...");
	
			// 4. 쿼리문 실행
			rs = ps.executeQuery();
	        while(rs.next()) {
	            System.out.println(rs.getInt("id")+"\t"
	                              +rs.getString("name")+"\t"
	                              +rs.getString("addr"));
	        }
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}
	
	public static void main(String[] args) throws Exception{
		new DBConnectionTest4();
	}

}
