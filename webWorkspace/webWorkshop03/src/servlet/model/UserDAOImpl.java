package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class UserDAOImpl implements UserDAO{
	private DataSource ds;
	
	private static UserDAOImpl dao = new UserDAOImpl();
	private UserDAOImpl() {
		try {
			Context ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource LookUP Success");
		} catch (NamingException e) {
			System.out.println("DataSource LookUP Fail");
		}
	}
	public static UserDAOImpl getInstance() { return dao; }
	
	@Override
	public Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}

	@Override
	public User login(String userId, String password) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User vo = null;
		
		try {
			conn = getConnection();
			System.out.println("DB 연결 성공..");
			
			String query = "SELECT userId, password, name, email FROM USERINFO WHERE userId=? AND password=?";
			ps = conn.prepareStatement(query);
			System.out.println("PrepareStatement 완료..");
			
			ps.setString(1, userId);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new User(userId,
							  password,
							  rs.getString("name"),
							  rs.getString("email"));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		System.out.println(vo);
		
		return vo;
	}

}
