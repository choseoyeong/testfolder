package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.print.attribute.ResolutionSyntax;
import javax.sql.DataSource;
import javax.swing.plaf.synth.SynthSeparatorUI;

import sun.security.jca.GetInstance;

public class BookDAOImpl implements BookDAO{
	private DataSource ds;
	
	private static BookDAOImpl dao = new BookDAOImpl();
	private BookDAOImpl() {
		try {
			Context ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource LookUP Success");
		} catch (NamingException e) {
			System.out.println("DataSource LookUP Fail");
		}
	}
	public static BookDAOImpl getInstance() { return dao; }
	

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
	public void registerBook(Book vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = ds.getConnection();
			
			String query = "INSERT INTO "
						+ "book(isbn, title, catalogue, nation, publish_date, publisher, author, price, description)"
						+ "VALUES(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, vo.getIsbn());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getCatalogue());
			ps.setString(4, vo.getNation());
			ps.setString(5, vo.getPublish_date());
			ps.setString(6, vo.getPublisher());
			ps.setString(7, vo.getAuthor());
			ps.setInt(8, vo.getPrice());
			ps.setString(9, vo.getDescription());
			
			System.out.println(ps.executeUpdate()+ "개의 책이 등록되었습니다.");
			
		} finally {
			closeAll(ps, conn);
		}
		
	}
}










