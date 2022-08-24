package com.edu.service.impl;
/*
 * VO클래스들을 핸들링하는 기능들만 모아놓은 서비스 클래스
 * 서비스 인터페이스를 상속받아서 작성했다.
 * 
 * 이런 서비스 클래스는 클라이언트에서 요청이 아무리 많이 들어와도
 * 클래스 인스턴스는 단 하나 서버상에 만들어놓고
 * 요청을 처리하는 것은 서비스 클래스에 메소드가 요청을 받아서 처리한다.
 * 즉 Singletone Pattern으로 작성
 * 
 * 해당 서비스 클래스는 이후 JDBC기술에서 Database 어플리케이션이 될 것이다.
 * 
 * 싱글톤 작성 패턴
 * 1. private static 객체를 일단 하나 생성
 * 2. private 생성자..다른곳에서 생성을 하지 못하도록 막아둔다
 * 3. public static 생성한 객체를 받아 쓸수 있도록 열어둔다
 */
import java.util.ArrayList;

import com.edu.service.EmployeeListService;
import com.edu.vo.Employee;
import com.edu.vo.Engineer;
import com.edu.vo.Manager;

public class EmployeeListServiceImpl implements EmployeeListService{
	
	//추가
	private ArrayList<Employee> list;
	
	//싱글톤 추가
	private static EmployeeListServiceImpl service  = new EmployeeListServiceImpl();
	private EmployeeListServiceImpl() { list = new ArrayList<>(); }
	public static EmployeeListServiceImpl getInstance() { return service; }
	
	
	@Override
	public void addEmployee(Employee e) {	
		//list에 추가하도록 로직을 작성.. 있으면 추가되지 않도록 제어한다.
		boolean find = false;
		
		for(Employee em: list)
			if(em == e) {
				find = true;
				System.out.println(em.getName() + "님은 이미 존재하는 이름입니다.");
				return ;
			}
			
		if(!find) {
			list.add(e);
			System.out.println(e.getName() + "님이 추가되었습니다");
		}
	}
	
	@Override
	public void deleteEmployee(String empId) {		
		//	list에서 삭제		
		boolean find = false;
		
		for(Employee em: list)
			if(em.getEmpId().equals(empId)) {
				find = true;
				System.out.println(em.getName() + "님을 퇴사처리 하겠습니다.");
				list.remove(em);
				break;
			}
		
		if(find == false)
			System.out.println("삭제하려는 직원이 존재하지 않습니다.");
	}
	
	
	// id는 수정의 대상이 안된다.(고유하기 때문에)
	// id를 제외한 나머지 필드값이 수정의 대상이 된다.
	@Override
	public void updateEmployee(Employee e) {		
		boolean find = false;
		
		for(Employee em: list) {
			if(em.getEmpId().equals(e.getEmpId())) {	// 수정할 대상이 존재한다면
				em.setName(e.getName());
				em.setAddr(e.getAddr());
				em.setSalary(e.getSalary());
				
				if(em instanceof Manager) {
					((Manager) em).changeDept(((Manager) e).getDept());
				}
				if(em instanceof Engineer) {
					((Engineer) em).changeTech(((Engineer) e).getTech());
					((Engineer) em).changeBonus(((Engineer) e).getBonus());
				}
			}
		}
		
		//list에서 수정
	}//updateEmployee
	
	@Override
	public ArrayList<Employee> findEmployees(String addr) {
		ArrayList<Employee> temp = new ArrayList<Employee>();
		//list에서 검색
		
		for(Employee em: list)
			if(em.getAddr().equals(addr)) 
				temp.add(em);
				
		return temp;
	}
	
	@Override
	public void findEmployees() {
		//list에 있는 데이타들을 콘솔로 출력
		
		for(Employee em: list)
			System.out.println(em);
	}
}
