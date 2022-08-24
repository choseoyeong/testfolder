package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class EmployeePolyTest1 {

	public static void main(String[] args) {
		Employee e = new Employee("구자경", 2000000, "역삼동",new MyDate(1999, 1, 3));
		Manager m =  new Manager("염미정", 2400000, "문현동", new MyDate(2000, 2, 12), "개발부");
		Engineer eg =  new Engineer("염창희", 3500000, "대연동", new MyDate(1999, 11, 14), "자바", 300);
		
		System.out.println(e.getDetails());
		System.out.println(m.getDetails());
		System.out.println(eg.getDetails());
		
		//////////////////////////////////////////////////////////////////////////
		
		/*
		 * PolyMorphism (다형성)
		 * ::
		 * 부모타입으로 자식 객체를 생성하는 것
		 * ::
		 * 1) Manager m = new Manager()		// 다형성 아님
		 * 				VS
		 * 2) Employee m1 = new Manager()	// 다형성 맞음
		 */
		/*
		 * 
		 * Virtual Method Invocation 원리
		 * 여기서 virtual은 자식을 의미함
		 * 
		 * compile때와 runtime때 호출되는 메소드가 다름.
		 * compile Type - 부모의 메소드 호출
		 * Runtime Type - 생성된 실질적인 자식의 메소드를 호출
		 * 
		 * => 상속 관계시 overriding된 자식의 메소드에서만 발생됨.
		 * 
		 */
		
		System.out.println("\n==================After Polymorphism===================");
		
		Employee m1 =  new Manager("염미정", 2400000, "문현동", new MyDate(2000, 2, 12), "개발부");
		Employee eg1 =  new Engineer("염창희", 3500000, "대연동", new MyDate(1999, 11, 14), "자바", 300);
		
		/*
		 * Object Casting
		 * 부모타입에 없는 자식만의 멤버를 호출할 때 발생
		 * 자식타입으로 Casting하고 나서 자식의 타입으로 다시 찾아야 한다. 
		 */
		
		((Manager) m1).changeDept("AI 분석부");					// Manager의 메소드인데 Employee type인 m1에서 찾으니까 없음. => Manager로 Casting 해줘야 함
		
//		Manager manager = (Manager)m1;
//		manager.changeDept("AI분석부");
		
		
		System.out.println(m1.getDetails());		// Employee에 있는 getDetails()임. 그런데 dept, tech 등이 출력됨. WHY?
		System.out.println(eg1.getDetails());

	}

}












