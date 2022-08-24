package com.edu.test;

class Service{
	private static Service service = new Service();
	private Service() {
		System.out.println("Singleton Pattern Ready...");
	}
	
	public static Service getInstance() {
		return service;
	}
	
}


public class StaticExamTest4 {

	public static void main(String[] args) {
		// 생성자가 private이므로 불가능
//		Service s1 = new Service();
		
		// getInstance로 받아와야하는데, getInstance가 static이 아니면 객체 생성해서 받와야하기 때문에 불가능
		// => getInstance가 static이면 바로 받아와서 쓸 수 있음
		Service service1 = Service.getInstance();
		Service service2 = Service.getInstance();
		Service service3 = Service.getInstance();
		
		// 주소 출력해보면 모두 같은 객체임을 알 수 있음
		System.out.println(service1);
		System.out.println(service2);
		System.out.println(service3);
	}

}
