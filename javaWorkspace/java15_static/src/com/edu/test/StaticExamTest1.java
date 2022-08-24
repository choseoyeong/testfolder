package com.edu.test;

/*
 * static 성질 => 시험나옴
 * 1. static으로 지정된 멤버(field, method)는 객체생성 과정 없이 메모리에 올라간다.
 * 2. class파일이 loader되는 시점(실행과정 초기)에 메모리(JVM)에 로더된다. 
 * 3. static이 붙은 변수는 로컬레벨에서 사용될 수 없다.(멤버 레벨(필드 위치)에서 써야함)(멤버변수 아님)
 * 4. static으로 지정된 변수들은 생성된 객체들이 모두 공유한다!!!
 * 		필드		VS		로컬변수		VS		클래스변수(static)		=> 구별 가능해야함
 * 
 * 5. static final은 거의 함께 붙어서 사용된다. --> Usage Modifier...
 * 		final static
 * 
 * 		final은 "내가 마지막이다"를 의미
 * 		final+변수 : "내가 마지막 변수야"  --> 상수의 의미
 * 		final+메소드 : "내가 마지막 메소드야"  --> Override 금지 의미
 * 		final+클래스: "내가 마지막 클래스야"  --> 상속 금지 의미
 * 
 * 6. 싱글톤
 * 	1) 일단 클래스안에서 하나의 객체는 생성
 * 		private static으로 객체를 하나 생성
 *  2) 다른 곳에서 해당 클래스로 객체생성 못하도록 막아둔다.
 *  	private 생성자() { }
 *	3) public ☆static☆ Service getInstance() {
 *		return service;
 *	   }
 * 
 */

class StaticExam {
	//member level에서 사용해야 한다..
	static String name = "홍길동";	// static V, class V, 전역변수
	static int age = 19;
	int count = 1;		// field, 멤버변수
	
	
	// static은 static끼리 통한다.
	public static void getMember() {
		System.out.println("우/유/빛/깔/" + name);
//		count++;			// 객체 생성 안했기때문에 못씀
	}
	
	public void getMember2() {
//		static String address = "한남동";
		System.out.println("우/유/빛/깔/" + name);
	}
	
}

public class StaticExamTest1 {

	public static void main(String[] args) {
//		static String name = "홍길동";		// local level에서 사용 불가	
		
		// static한 멤버를 사용할때 -> 클래스이름.static 멤버;
		StaticExam.getMember();
		
		// static 아니기때문에 객체 생성 안하면 에러
//		StaticExam.getMember2();
		
		StaticExam exam = new StaticExam();
		exam.getMember2();
		
		System.out.println("=========================");
		
		// static은 객체생성 하든 안하든 사용 가능
		exam.getMember();
		
		/* 1~3 설명 완료 */
	}

}
