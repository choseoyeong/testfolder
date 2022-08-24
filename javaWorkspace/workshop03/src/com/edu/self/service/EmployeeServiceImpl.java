package com.edu.self.service;

import com.edu.self.vo.Employee;
import com.edu.self.vo.Engineer;
import com.edu.self.vo.Manager;

public class EmployeeServiceImpl implements EmployeeService{
	public final static int MAXLEN = 20;
	
	// 싱글톤
	private static EmployeeServiceImpl service = new EmployeeServiceImpl();
	private EmployeeServiceImpl() {}
	public static EmployeeServiceImpl getInstance() {
		return service;
	}
	
	Employee[ ] es = new Employee[MAXLEN];
	int emidx;
	
//	Manager[ ] ms = new Manager[MAXLEN];
//	int midx;
//	
//	Engineer[ ] egs = new Engineer[MAXLEN];;
//	int egidx;	


	@Override
	public void addEmployee(Employee e) {
		es[emidx++] = e;
	}


	@Override
	public void deleteEmployee(String name) {
		for(int i=0; i<emidx; i++) {
			if(es[i].getName().equals(name)) {
				for(int j=i; j<emidx; j++) {
					es[j] = es[j+1];
				}
				es[emidx] = null;
				emidx--;
			}
		}
	}

	@Override
	public void updateManager(double salary, String dept, int deptno, String name) {
		for(Employee e : es) {	
			if(e==null) continue;
			if(e.getName().equals(name)) {
				e.setSalary(salary);
				((Manager)e).setDept(dept);	
				((Manager)e).setDeptno(deptno);				
			}			
		}
	}

	@Override
	public void updateEngineer(String tech, double bonus, String name) {
		for(Employee e: es) {	
			if(e==null) continue;
			if(e.getName().equals(name)) {
				((Engineer)e).setTech(tech);	
				((Engineer)e).setBonus(bonus);				
			}			
		}
	}

	@Override
	public Manager findManager(String name) {
		Manager m = null;
		for(Employee em : es) {
			if(em==null) continue;			
			if(em.getName().equals(name) && em instanceof Manager)
				m = (Manager)em;
		}
		return m;
	}

	@Override
	public Manager[] findManager(int deptno) {
		Manager[ ] temp = new Manager[es.length];
		int count = 0;
		
		for(Employee em : es) {
			if(em == null) continue;
			if(em instanceof Manager) 
				if(((Manager) em).getDeptno()==deptno)
					temp[count++] = (Manager) em;
		}
		return temp;
	}

	@Override
	public Engineer findEngineer(String name) {
		Engineer e = null;
		for(Employee em : es) {
			if(em==null) continue;			
			if(em.getName().equals(name) && em instanceof Engineer)
				e = (Engineer)em;
		}
		return e;
	}
	
	@Override
	public Employee findRichestEmployee() {
		Employee e = null;
		double maxSalary = 0;
		
		for(Employee employee: es) {
			if(employee==null) break;
			if(employee.getSalary() > maxSalary) {
				maxSalary = employee.getSalary();
				e = employee;
			}
		}
		
		return e;
	}
	
	@Override
	public double getAverageSalary() {
		double totalSalary = 0.0;
		int employeeCnt = 0;
		
		for(Employee employee: es) {
			if(employee==null) break;
			totalSalary += employee.getSalary();
			employeeCnt++;
		}
		
		return totalSalary/employeeCnt;
	}

	@Override
	public void printManagers() {
		for(Employee e: es)
			if(e instanceof Manager)
				System.out.println(e.getDetails());
		
	}

	@Override
	public void printEngineers() {
		for(Employee e: es)
			if(e instanceof Engineer)
				System.out.println(e.getDetails());
	}
	

}
