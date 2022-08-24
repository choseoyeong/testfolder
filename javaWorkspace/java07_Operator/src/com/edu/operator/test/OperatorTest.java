package com.edu.operator.test;
/*
 			선언된 위치 		       기본값 유무					메모리		  	  		별칭
 
 field		메소드 바깥			    있다					Heap					멤버변수
 
 local		메소드 블럭 안		없다(사용 전 반드시 초기화)		Stack		지역, Temporary, Automatically 변수
 */
public class OperatorTest {

	public static void main(String[] args) {
		// Local 변수...main 안에서 선언
		int i = 5;
		int j = 3;
		
		System.out.println(i==j);	// false
		System.out.println(i!=j);	// true
		System.out.println("=======================");
		System.out.println("연산자: " + i%j);	// 2
		System.out.println("연산자: " + i/j);		// 1
		System.out.println("=======================");
		
		int k = 10;
		System.out.println(k++);	// 10
		System.out.println(k);		// 11
		
		int m = 10;
		System.out.println(++m);	// 11
		System.out.println(m);		// 11
	}
//	i = 50;
	
}
