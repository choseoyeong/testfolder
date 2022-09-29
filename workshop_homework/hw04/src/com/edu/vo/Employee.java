package com.edu.vo;
//Super Class...
public class Employee {
	private String empId;
	private String name;
	private String addr;
	private int salary;
	
	public static final String DEFAULT_ADDRESS = "연수원";
	public static final int BASIC_SALARY = 2000000;
	
	public Employee() {	}
	
	public Employee(String empId, String name, String addr, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.addr = addr;
		this.salary = salary;
	}
	
	public Employee(String empId, String name) {
		this(empId,name,DEFAULT_ADDRESS,BASIC_SALARY);		
	}

	public String getEmpId() {
		return empId;
	}

	public String getName() {
		return name;
	}

	public String getAddr() {
		return addr;
	}

	public int getSalary() {
		return salary;
	}
	
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", addr=" + addr
				+ ", salary=" + salary + "]";
	}		
}











