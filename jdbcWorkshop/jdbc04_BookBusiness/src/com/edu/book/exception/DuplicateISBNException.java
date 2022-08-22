package com.edu.book.exception;

public class DuplicateISBNException extends Exception{
	public DuplicateISBNException() {
		this("DuplicateISBNException...");
	}
	public DuplicateISBNException(String message) {
		super(message);		//System.out.println(e.getMessage())
	}
}
