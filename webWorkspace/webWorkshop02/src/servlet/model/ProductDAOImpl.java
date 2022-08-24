package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAOImpl implements ProductDAO{
	private DataSource ds;
	
	private static ProductDAOImpl dao = new ProductDAOImpl();
	private ProductDAOImpl() {
		try {
			Context ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
			System.out.println("DataSource LookUp Success..");
		} catch (NamingException e) {
			System.out.println("DataSource LookUp Fail..");
		}
		
	}
	public static ProductDAOImpl getInstance() { return dao; }
	
	
	
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
	
	public int findProductNumber() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int productNum = 0;
		try {
			conn = getConnection();
			System.out.println("findProductNum Connection 완료");
			
			String query = "SELECT PRODUCT_NO FROM PRODUCT";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery(query);
			
			while(rs.next()) {
				productNum = rs.getInt("PRODUCT_NO");
			}
			
			System.out.println("최대 시퀀스: " + productNum);
	
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return productNum;
	}
	
	@Override
	public void registerProduct(ProductVO vo) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			System.out.println("Connection 완료");
			
			String query = "INSERT INTO PRODUCT(PRODUCT_NO, PRODUCT_NAME, PRICE, DETAIL) VALUES(PRODUCT_SEQ.nextval, ?, ?, ?)";
			ps = conn.prepareStatement(query);
			System.out.println("ps 연결 완료");
			
			ps.setString(1, vo.getName());
			ps.setInt(2, vo.getPrice());
			ps.setString(3, vo.getDetail());
			
			System.out.println(ps.executeUpdate() + "개의 상품이 등록되었습니다.");
			
			vo.setProductNumber(findProductNumber());
		} finally {
			closeAll(ps, conn);
		}
		
	}
	@Override
	public ProductVO findProduct(int productNumber) throws SQLException {
		
		return null;
	}
	@Override
	public ArrayList<ProductVO> findAllProduct() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<ProductVO> list = new ArrayList<>();
		
		try {
			conn=getConnection();
			
			String query = "SELECT * FROM product";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add( new ProductVO(rs.getInt("product_no"),
						 				rs.getString("product_name"),
						 				rs.getInt("price"),
						 				rs.getString("detail")));
			}
			
		} finally {
			closeAll(rs, ps, conn);
		}
		return list;
	}
	
	
}
