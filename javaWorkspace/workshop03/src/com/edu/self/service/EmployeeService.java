package com.edu.self.service;
import com.edu.self.vo.Employee;
import com.edu.self.vo.Engineer;
import com.edu.self.vo.Manager;

public interface EmployeeService {
//	public EmployeeService(int size);
	
//	void addManager(Employee e);
//	void addEngineer(Employee e);
	void addEmployee(Employee e);
	
	
//	void deleteManager(String name);
//	void deleteEngineer(String name);
	void deleteEmployee(String name);	
	
	void updateManager(double salary, String dept,int deptno,  String name);
	void updateEngineer(String tech, double bonus, String name);
	
	//Method Overloading
	Manager findManager(String name);
	Manager[ ] findManager(int deptno);
	Engineer findEngineer(String name);
	
	Employee findRichestEmployee();
	double getAverageSalary();
	
	
	void printManagers();
	void printEngineers();
}







