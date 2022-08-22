package com.edu.book.test;

import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.book.dao.impl.BookDAOImpl;
import com.edu.book.exception.DuplicateISBNException;
import com.edu.book.vo.Book;

import config.ServerInfo;

public class BookDAOTest {
	
	public static void main(String[] args) {
		BookDAOImpl dao = BookDAOImpl.getInstance();
		
		Book b1 = new Book("7G7", "범 내려온다", "김진", "아이들판", 12800);
		Book b2 = new Book("8H8", "몽실 언니", "권정생", "창비", 11800);
//		Book b3 = new Book();
		
		ArrayList<Book> books = new ArrayList<Book>();
		Book book = null;
		
		// 메소드를 try{ catch 안에서 하나씩 호출하면서 작업 마무리하기
		try {
//			dao.registerBook(b1);
//			dao.registerBook(b2);
			
//			dao.deleteBook(b2);
			
//			book = dao.findByIsbn("7G7");
//			book = dao.findByIsbn("NNN");
			
//			book = dao.findByTitle("강아지똥");
//			book = dao.findByTitle("내려");
//			book = dao.findByTitle("고양이");
			
//			books = dao.findByWriter("권정생");
//			books = dao.findByWriter("정생");
//			books = dao.findByWriter("없는저자");
			
//			books = dao.findByPublisher("길벗");
//			books = dao.findByPublisher("아");
//			books = dao.findByPublisher("없는출판사");
			
//			books = dao.findByPrice(10000, 30000);
//			books = dao.findByPrice(40000, 50000);
//			books = dao.findByPrice(40000, 10000);
			
//			dao.discountBook(10, "동아");
//			
//			books = dao.findAllBook();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		// PRINT
		if(book != null) {
			System.out.println(book); 
		}
		
		if(books != null) {
			for(Book b: books) 
				System.out.println(b);
		}
		
	}
	
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1. 드라이버 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 실패..");
		}
		
	}
}
