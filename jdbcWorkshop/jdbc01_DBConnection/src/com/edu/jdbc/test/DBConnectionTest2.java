package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 *  
 * 4. Query문 실행
 * 	RusultSet rs = ps.executeQuery()
 * 	int row = st.executeUpdate()
 */
public class DBConnectionTest2 {
	public DBConnectionTest2() {
		try {
			// 1. 드라이버 로딩...
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 드라이버 로딩 성공...");
			
			// 2. DB 서버와 연결
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			Connection conn = DriverManager.getConnection(url, "hr", "hr");
			System.out.println("2. DB서버 연결 성공...");
			
			// 3. PreparedStatement 객체 생성
			String query = "SELECT id, name, addr FROM custom";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("3. PrepareStatement 생성...");
			
			// 4. 바인딩, 쿼리문 실행
			// 쿼리문에 ? 없으므로 바인딩 과정은 필요없음
			
			/*
			 * ResultSet 메카니즘
			 * 
			 * 정보를 가장 잘 담기 위해서 table 형태로 생김
			 * custom table이랑 똑같이 생겼는데 맨 위와 아래 한 행씩 더 있음(BOE, EOE)
			 * 생성하면 커서 위치는 BOE에 있음
			 * 
			 * while(rs.next()){ -> 커서 한칸 내려감
			 * 	 rs.getInt("id") + " "
			 * 	 + rs.getString("name") + " "
			 * 	 + rs.getString("addr")
			 * }
			 */
			ResultSet rs=ps.executeQuery();
	        while(rs.next()) {
	            System.out.println(rs.getInt("id")+"\t"
	                              +rs.getString("name")+"\t"
	                              +rs.getString("addr"));
	        }
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패...");
		} catch (SQLException e) {
			System.out.println("DB서버 연결 실패...");
		}
	}
	
	public static void main(String[] args) {
		new DBConnectionTest2();
	}

}
