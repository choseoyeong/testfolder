package com.edu.service;

import com.edu.child.Engineer;
import com.edu.parent.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	// 싱글톤 패턴
	private static EmployeeServiceImpl service = new EmployeeServiceImpl();
	private EmployeeServiceImpl() {}
	public static EmployeeServiceImpl getInstance() {
		return service;
	}
	
	@Override
	public void manageEmployee(Employee e) {
		System.out.println(e.getDetails());
	}

	@Override
	public int getAnnualSalary(Employee e) {
		int total = 0;
		
		if(e instanceof Engineer) 
			total += e.getSalary()*12 + ((Engineer) e).getBonus();
		else 
			total += e.getSalary()*12;
		
		return total;
	}

	@Override
	public Employee findEmployee(Employee[] employees, String name) {
		Employee find = null;
		
		return find;
	}

	@Override
	public Employee[] findEmployee(Employee[] employees, String dept, String address) {
		Employee[] temp = new Employee[employees.length];
		
		return temp;
	}

}
 