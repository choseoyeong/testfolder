package com.edu.test;

class A{
	public final static int BASIC_SALARY = 3000000;
	public final String test() {
		return "오버라이딩 금지";
	}
}

final class B{	//상속 금지
	
	
}

// 상속 금지
//class C extends B{
//}


// 오버라이딩 금지
//class D extends A {
//	public final String test() {
//		return "오버라이딩 금지"+100;
//	}

//	BASIC_SALARY = 3500000;
//}



public class StaticExamTest3 {

	public static void main(String[] args) {

		
	}

}
