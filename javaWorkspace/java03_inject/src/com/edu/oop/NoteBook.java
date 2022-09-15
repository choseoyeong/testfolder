package com.edu.oop;
/*
 * Object Class
 * 
 * 필드 선언;
 * 
 * void setXxx(o, o, o) {
 * 	// 필드 초기화
 * }
 * 리턴타입 getXxx(x) {
 * 	return 
 * )
 * 
 */

public class NoteBook {
	// 변수 선언 == 필드 선언 : 변수 타입 + 변수 이름;
	public String brand;
	public int price;
	public int serialNumber;

	// step 1
//	public String getNoteBookInfo() {	
//		System.out.println("NoteBookInfo :: " + brand + "," + price + "," + serialNumber);
//	}
	
	// step 2
	public String getNoteBookInfo() {	
		// String Data + Non-String ==> String화
		return "NoteBookInfo :: " + brand + "," + price + "," + serialNumber;
	}
	
	public String getBrand() {
		return brand;		
	}
	
	// 필드초기화 하는 기능을 추가...setField(), setInfo(), setNoteBookInfo()
	
	public void setNoteBookInfo(String brand, int price, int serialNumber) { // 로컬변수  // -> 이런걸 inject(주입)이라고 함. 주입만 하기때문에 return값 필요없음
		// 필드에 값을 할당... 값 주입,,,반환값이 필요 없다		|	매개변수는 필요하다	
		// 필드 이름과 로컬변수의 이름이 같을 때 필드 앞에 this를 붙인다.
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
	}
	
}