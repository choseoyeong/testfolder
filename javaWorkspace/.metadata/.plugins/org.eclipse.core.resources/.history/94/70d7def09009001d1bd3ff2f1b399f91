package com.edu.parent;
// Parent Class...
/*
 * Overloading
 * Method      Overloading
 * Constructor Overloading
 */
import com.edu.util.MyDate;

public class Employee {
	private String name;
	private double salary;
	private MyDate birthday;
	private String address;
	
	public static final double BASIC_SALARY = 100;
	public static final String BASE_NAME = "홍길동";
	
	public Employee() {}
	public Employee(String name, double salary, String address, MyDate birthday) {
		super();
		this.name = name;
		this.salary = salary;
		this.address = address;
		this.birthday = birthday;
	}
	
	public Employee(String name,String address, MyDate birthday) {
		this(name, BASIC_SALARY, address, birthday);
	}	
	
	public Employee(double salary, String address,MyDate birthday) {
		this(BASE_NAME, salary, address, birthday);
	}	
	
	public void changeAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public String getAddress() {
		return address;
	}
	public String getDetails() {
		return name+"\t"+salary+"\t"+address+"\t"+birthday;
	}	
}





















