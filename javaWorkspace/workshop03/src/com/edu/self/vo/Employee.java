package com.edu.self.vo;

import com.edu.self.util.MyDate;

public class Employee {
	private String name;
	private MyDate birthday;
	private double salary;

	private final static double BASIC_SALARY = 100;
	private final static String BASIC_NAME = "홍길동";  
	
	public Employee() {}
	
	public Employee(String name, MyDate birthday, double salary) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
	}
	
	public Employee(String name, MyDate birthday) {
		this(name, birthday ,BASIC_SALARY);
	}

	public Employee(MyDate birthday, double salary) {
		this(BASIC_NAME, birthday, salary);
	}
	
	
	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getDetails() {
		return name + ", " + salary + ", " + birthday;
	}

	public String getName() {
		return name;
	}

	public MyDate getBirthday() {
		return birthday;
	}

	public double getSalary() {
		return salary;
	}

	
}
