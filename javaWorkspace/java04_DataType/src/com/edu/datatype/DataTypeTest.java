package com.edu.datatype;
/*
 * madeCompany	--- "동신사"
 * color		--- W
 * price		--- 300.23
 * scratch		--- 있다 / 없다
 * material		--- 합판과 알루미늄
 * buyDate 		--- 2022-07-19 (class MyDate)
 *
 * set() / get()
 */

class MyDate {
	public String year, month, day;
	
	public void setMyDate(String year, String month, String day) { 
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public String getMyDate() {	
		return year + "-" + month + "-" + day; 
	}
}

class WhiteBoard {
	// 필드는 기본값을 가진다...
	// 로컬변수는 기본값이 없다. 그래서 사용하기 전 반드시 초기화해야한다.
	public String madeCompany;
	public char color;
	public float price;
	public boolean scratch;
	public String material;
	public MyDate buyDate;
	
	public void setWhiteBoard(String madeCompany, 
								char color, 
								float price, 
								boolean scratch, 
								String material, 
								MyDate buyDate) {
		this.madeCompany = madeCompany;
		this.color = color;
		this.price = price;
		this.scratch = scratch;
		this.material = material;
		this.buyDate = buyDate;
	}
	
	public String getWhiteBoardInfo() {
		return "WhiteBoardInfo :: " + madeCompany + ", " + color + ", " + price + ", " + scratch + ", " + material + ", " + buyDate;
	}
}

public class DataTypeTest {

	public static void main(String[] args) {
		// 1. 객체생성
		// 2. 메소드 호출
//		MyDate md = new MyDate();		
//		md.setMyDate("2022", "07", "19");
		
		WhiteBoard wb = new WhiteBoard();
		System.out.println( wb.getWhiteBoardInfo() );
		
		// class 타입에 대한 값은 '객체'임
		wb.setWhiteBoard("동신사", 'W', 300.23f, true, "합판과 알루미늄", new MyDate());
		
		System.out.println( wb.getWhiteBoardInfo() );
		
	}

}
