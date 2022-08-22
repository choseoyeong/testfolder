package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * JDBC 4단계
 * 1. 클라이언트 메모리에 드라이버를 로딩
 * 	   이때 드라이버 정보의 압축파일(~~.jar)이 dafault class path로 잡혀져 있어야 한다.
 * 	  ext 디렉토리 기억하기!!
 * 
 * 	Class.forName("드라이버 이름");		-> 로딩 코드
 * 
 * 2. DB 서버와 연결
 * 	Connection conn = DriverManager.getConnection(url, "hr", "hr");
 * 
 * 3. PreparedStatement 객체를 생성
 * 	PreparedStatement ps = conn.prepareStatement("sql문");
 * 	여기까지 query문은 만들어지기만 하고 실행되진 않음.
 *  PreparedStatement가 Query문을 실행하는 기능을 가지고 있음
 */
public class DBConnectionTest1 {
	public DBConnectionTest1() {
		try {
			// 1. 드라이버 로딩...
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 드라이버 로딩 성공...");
			
			// 2. DB 서버와 연결
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			Connection conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("2. DB서버 연결 성공...");
			
			// 3. PreparedStatement 객체 생성
			/*
			 * CREATE table custom(
			 * 		id number(10) primary key,
			 * 		name varchar2(20),
			 * 		addr varchar2(30)
			 * 		);
			 */
			
			// INSERT
			String query = "INSERT INTO custom (id, name, addr) VALUES (?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(query);
			System.out.println("3. PreparedStatement 생성...");
			
			// 4. ?에 대한 값을 바인딩하고 쿼리문 실행
			st.setInt(1, 333); 	// 흔치않게 시작이 0이 아니라 1임
			st.setString(2,  "구자경");
			st.setString(3, "신림동");
			
//			int row = st.executeUpdate();
			System.out.println(st.executeUpdate() + " row INSERT ok~~!!");
			
			
			/*
			// delete...333에 해당하는 구자경을 삭제
			String query = "DELETE FROM custom WHERE id=?";
			PreparedStatement st = conn.prepareStatement(query);
			System.out.println("3. PreparedStatement 생성...");
			
			st.setInt(1, 333);
			System.out.println(st.executeUpdate() + " row DELETE ok~~!!");
			*/
			
			/*
			// update...id가 111인 고객의 이름을 '염미정'으로 수정, addr를 산포시로 수정
			String query = "UPDATE custom SET name=?, addr=? WHERE id=?";
			PreparedStatement st = conn.prepareStatement(query);
			System.out.println("3. PreparedStatement 생성...");
			
			st.setString(1, "염미정");
			st.setString(2, "산포시");
			st.setInt(3, 111);
			
			System.out.println(st.executeUpdate() + " row UPDATE ok~~!!");
			*/
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패...");
		} catch (SQLException e) {
			System.out.println("DB서버 연결 실패...");
		}
	}
	
	public static void main(String[] args) {
		new DBConnectionTest1();
	}

}
