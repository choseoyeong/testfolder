package com.edu.parent;
// Parent Class..

/*
 * Overloading
 * Method		Overloading
 * Constructor 	Overloading
 */

import com.edu.util.MyDate;

public class Employee {
	private String name;
	private double salary;
	private MyDate birthday;
	
	// static final: 마지막 값. 즉 이제 변경 안됨. 상수값. -> 필드명 전체 대문자
	public static final double BASIC_SALARY = 100;
	public static final String BASIC_NAME = "홍길동";
	
	public Employee() { };
	
	public Employee(String name, double salary, MyDate birthday) {
		super();		// Object를 가리킴
		this.name = name;
		this.salary = salary;
		this.birthday = birthday;
	}
	
	public Employee(String name, MyDate birthday) {
		this(name, BASIC_SALARY, birthday);		// salary가 없으므로 기본값을 채움
	}
	
	public Employee(double salary, MyDate birthday) {
		this(BASIC_NAME, salary, birthday);
	}
	
	public String getDetails() {
		return name + "/t" + salary + "/t" + birthday.toString();
	}
}
