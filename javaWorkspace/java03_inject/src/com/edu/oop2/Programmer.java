package com.edu.oop2;

/*
 * NoteBook을 가지고 있는 개발자 클래스를 정의
 * 
 * 이름, 주요기술, 급여, 주소 
 * 			+ 
 * 		NoteBook
 */

// 오브젝트클래스 만들면 (필드선언, 값주입, 값반환) 무조건 만들기

public class Programmer {
	public String name;
	public String mainSkill;
	public int salary;
	public String address;
	//----------------------------------//
	// Has a Relation
	public NoteBook noteBook;	// 필드명은 클래스명과 같은게 좋음. 다만 필드니까 소문자로 시작
	
	// 메소드...값 주입 / 값 반환
	public void setProgrammerInfo(String name, String mainSkill, int salary, String address) {
		this.name = name;
		this.mainSkill = mainSkill;
		this.salary = salary;
		this.address = address;		
	}
	
//	public void setNoteBook(NoteBook noteBook) {
//		this.noteBook = noteBook;
//	}
	
	public void buyNoteBook(NoteBook noteBook) {	// 메소드 이름 변경으로 가독성 높아짐
		this.noteBook = noteBook;
	}
	
	public String getProgrammerInfo() {
		return name + ", " + mainSkill +  ", " + salary + ", " + address ;
	}
	
	public NoteBook getNoteBook() {
		return noteBook;
	}
	
	// 기능 추가
	// 1. 개발자의 연봉을 리턴
	public int getAnnaulSalary() {
		return salary*12;
	}
	
	// 2. 개발자의 급여를 기존보다 50만원 더 추가된 급여로 변경
	public void changeSalary(int amount) {
		salary += amount*12;
	}
}
