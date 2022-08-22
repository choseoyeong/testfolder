// DB Access하는 기능만으로 이뤄진 클래스
// Business Logic으로만 구성된 클래스
// DAO 클래스
/*
 * 1. 드라이버 로딩
 * 2. DB 연결...Connection 반환받고
 * 
 * 3. PreparedStatement 객체...쿼리문 실행하는 기능을 여기서 가지고 있다.
 * 4. 값 바인딩...쿼리문 실행
 * 		int executeUpdate()	--> INSERT/UPDATE/DELETE (DML)
 * 		ResultSet executeQuery() --> SELECT
 * 
 * 5. 자원을 닫는다.
 * 		(열은 반대 순서로)
 * 		ResultSet -> PreparedStatement -> connection close()
 * 
 * => 3, 4를 메소드 형식으로 구현하겠음
 */

/*
 * Business Logic 마다
 * 1. 고정적인 로직..static 	 --> 새로운 기능을 하나 정의...이걸 매번 작성하는게 아니라 호출..
 * 		1) Connection 반환 로직 :: getConnection()
 * 		2) 자원 닫는 로직	 :: closeAll()
 * 2. 가변적인 로직..dynamic
 * 
 */
package com.edu.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class CustomerDAO {
	public CustomerDAO() {
		System.out.println("2. DAO Creating....");
	}
	//////////////// 공통적인 로직  ///////////////////
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("DB Server Connection....");
		return conn;
	}
	
	/*
	 * INSERT, DELETE, UPDATE...Connection, PreparedStatement
	 * SELECT				 ...Connection, PreparedStatement, ResultSet
	 * => Method Overloading 사용
	 */
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(conn, ps);
	}
	
	// version1 코드의 문제점(메소드마다 conn, ps, close 각각 선언했었음)
	// 1. Connection과 close()는 고정적인 로직이므로 뽑아내야 함.
	// 2. 인자를 값 하나하나로 받아오는게 아니라, 객체로 다뤄야 함.
	
	// VERSION2 문제
	// 인자 대신 객체 사용
	// 예외처리 싱글톤 INTERFACE 사용
	
	// DML
	public void addCustomer(int ssn, String name, String address) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "INSERT INTO customer(ssn, name, address) VALUES(?, ?, ?)";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, ssn);
			ps.setString(2, name);
			ps.setString(3, address);
			
			System.out.println(ps.executeUpdate() + " 명 회원 등록 성공!! ");
		} finally {
			closeAll(conn, ps);
		}
	}
	
	public void deleteCustomer(int ssn, String name, String address) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "DELETE FROM customer WHERE ssn=?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, ssn);
			
			System.out.println(ps.executeUpdate() + " 명 회원 탈퇴 성공!! ");
		} finally {
			closeAll(conn, ps);
		}
	}
	
	public void updateCustomer(int ssn, String name, String address) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "UPDATE customer SET name=?, address=? WHERE ssn=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setInt(3, ssn);
			
			System.out.println(ps.executeUpdate() + " 명 수정 성공~~");
			
		} finally {
			closeAll(conn, ps);
		}
	}
	
	// SELECT
	public void  printAllCustomer() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT ssn, name, address FROM customer";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt(1) + "\t"
								+ rs.getString("name") + "\t"
								+ rs.getString("address"));
			}
			
		} finally {
			closeAll(conn, ps, rs);
		}
	}
	
	
}
 













