package com.edu.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;

import com.edu.book.exception.BookNotFoundException;
import com.edu.book.exception.DuplicateISBNException;
import com.edu.book.exception.InvalidInputException;
import com.edu.book.vo.Book;

public interface BookDAO {
	// 공통적인 기능의 Template
	public Connection getConnect() throws SQLException;
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException;
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException;
	
	// COUNT()
	int isExists(String isbn, Connection conn) throws SQLException;
	
	
	// 비즈니스 로직 기능 Template
	void registerBook(Book vo) throws SQLException, DuplicateISBNException;
	void deleteBook(Book vo) throws SQLException, BookNotFoundException;
	Book findByIsbn(String isbn) throws SQLException;
	
	// LIKE 연산자 사용
	Book findByTitle(String title) throws SQLException;
	ArrayList<Book> findByWriter(String writer) throws SQLException;
	ArrayList<Book> findByPublisher(String publish) throws SQLException;
	// 비교연산자....BETWEEN AND... 등 선택
	ArrayList<Book> findByPrice(int min, int max) throws SQLException, InvalidInputException;
	
	// 출판사별로 할인 제공
	// 숫자함수
	void discountBook(int per, String publish) throws SQLException;
	ArrayList<Book> findAllBook() throws SQLException;
	
}
