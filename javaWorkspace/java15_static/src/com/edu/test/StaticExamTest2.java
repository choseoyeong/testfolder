package com.edu.test;

class Car{
	int serialNumber;
	static int counter;
	
	// 생성자가 한번 동작 했다는 것은 객체가 하나 만들어 졌다는 뜻임
	Car() {
		counter++;		// 한번 동작할 때마다 증가. 즉 만들어진 객체 수
		serialNumber = counter;
	}
	
}


public class StaticExamTest2 {

	public static void main(String[] args) {
		Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = new Car();
		
		System.out.println("==========field============");
		System.out.println(c1.serialNumber);
		System.out.println(c2.serialNumber);
		System.out.println(c3.serialNumber);
		System.out.println("==========static c============");
		System.out.println(Car.counter);
		System.out.println(c1.counter);
		System.out.println(c2.counter);
		System.out.println(c3.counter);
		
	}

}
