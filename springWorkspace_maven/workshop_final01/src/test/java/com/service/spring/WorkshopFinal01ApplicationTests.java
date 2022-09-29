package com.service.spring;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.spring.domain.Emp;
import com.service.spring.model.EmpDAO;

@SpringBootTest
class WorkshopFinal01ApplicationTests {

	@Autowired
	private EmpDAO empDAO;
	
	@Test
	void insert() {
//		Emp emp = new Emp("1700105", "홍길동", "개발팀");
//		empDAO.insert(emp);
	}
	
	@Test
	void delete() {
//		empDAO.delete("1700105");
	}
	
	@Test
	void findEmp() {
//		Emp emp = empDAO.findEmp("1700105");
//		
//		System.out.println(emp);
	}
	
	@Test
	void findAllEmp() {
//		List<Emp> list = empDAO.findAllEmp();
//		
//		System.out.println(list);
	}

}
