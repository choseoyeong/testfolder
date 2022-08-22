package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Test2의 문제점은
 * 1. 서버정보가 프로그램에 하드코딩 되어져 있다. --> public static final 상수값으로 지정
 * 2. Connection을 열어서 사용한 후 close 해줘야 한다. --> finally 구문
 */
public class DBConnectionTest3 {
	// 이런 파편적인 데이터는 Meta Data화 시켜야 함.
	// (properties) 파일에 따로 분리해야함. 
	// -> 다른 환경에서 작업할 때 코드 만지지 않아도 됨.
	// => interface에서 상수로 선언하면 됨
	public static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	public static final String USER = "hr";
	public static final String PASS = "hr";
	
	public DBConnectionTest3() throws ClassNotFoundException, SQLException{
		// 로컬변수로 일단 선언..
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 로딩...
			Class.forName(DRIVER_NAME);
			System.out.println("1. 드라이버 로딩 성공...");
			
			// 2. DB 서버와 연결
			conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("2. DB서버 연결 성공...");
			
			// 3. PreparedStatement 객체 생성
			String query = "SELECT id, name, addr FROM custom";
			ps = conn.prepareStatement(query);
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
		new DBConnectionTest3();
	}

}
