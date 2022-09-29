package com.service.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.Emp;
import com.service.spring.model.EmpDAO;
import com.service.spring.model.EmpService;

@Service
public class EmpServiceImpl implements EmpService{
	@Autowired
	private EmpDAO empDAO;
	
	@Override
	public void insert(Emp emp) {
		empDAO.insert(emp);
	}

	@Override
	public void delete(String num) {
		empDAO.delete(num);
	}

	@Override
	public Emp findEmp(String num) {
		Emp emp = empDAO.findEmp(num);
		return emp;
	}

	@Override
	public List<Emp> findAllEmp() {
		List<Emp> emps = empDAO.findAllEmp();
		return emps;
	}
}
