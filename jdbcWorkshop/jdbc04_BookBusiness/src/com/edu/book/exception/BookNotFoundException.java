package com.edu.book.exception;

public class BookNotFoundException extends Exception{
	public BookNotFoundException() {
		this("BookNotFoundException...");
	}
	public BookNotFoundException(String message) {
		super(message);		//System.out.println(e.getMessage())
	}
}
