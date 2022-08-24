// AppTest나 Test가 붙은 클래스는 무조건 main도 생성하기
package com.bank.oop.test;
/*
 * 				OOP
 * 
 * 		Object Oriented Class	|	~~ Test
 * 
 * 		객체를 의미하는 클래스			객체가 아님
 * 									앞의 Object Class를 실제 객체로 만들어주는 실행 클래스(값을 집어넣는 용도)
 * 
 */

import com.bank.oop.Greeting;				// Greeting class의 위치를 알려주는 용도

public class GreetingAppTest {

	public static void main(String[] args) { // main method(=실행 메소드)
		// 객체 생성 == 메모리(JVM)에 클래스의 멤버(필드, 메소드)들을 다 올린다. == 멤버에 접근
		Greeting hello = new Greeting();
		
		/*
		 * [접근]
		 * 필드 --> 값 할당
		 * 메소드 --> 메소드를 호출
		 */
		
		hello.who = "여러부운~~";
		hello.greet = "마지막 시간입니다~~~수고많으셨어요";
		
		hello.sayHello();
		
	}

}
