package com.edu.oop.test;
/*
 * NoteBookTest의 문제점
 * ::
 * 필드가 많아질수록 코드라인이 늘어남 => 재사용성이 떨어짐
 * 생성되는 객체가 커질수록 코드량은 기하급수적으로 증가한다.
 * 
 * 필드의 값을 직접 할당하면 발생하는 문제점
 * --------------------------------------------
 * NoteBookTest의 해결책
 * ::
 * 필드초기화 하는 기능(메소드)을 만든다.
 */
import com.edu.oop.NoteBook;

public class NoteBookTest {

	public static void main(String[] args) {
		/*
		 * 1. 객체 생성
		 * 2. 값 할당 | 메소드 호출
		 */
		
		NoteBook nb = new NoteBook();
		NoteBook nb1 = new NoteBook();
		
//		nb.brand = "HP";
//		nb.price = 1200000;
//		nb.serialNumber = 1234;
		
//		nb1.brand = "SAMSUNG";
//		nb1.price = 1500000;
//		nb1.serialNumber = 1212;
		
		nb.setNoteBookInfo("HP", 1200000, 1234);
		nb1.setNoteBookInfo("SAMSUNG", 1500000, 1212);
		
		System.out.println( nb.getNoteBookInfo() );
		System.out.println( "Brand : " + nb.getBrand() );
		
		System.out.println( nb1.getNoteBookInfo() );
		System.out.println( "Brand : " + nb1.getBrand() );
	}

}
