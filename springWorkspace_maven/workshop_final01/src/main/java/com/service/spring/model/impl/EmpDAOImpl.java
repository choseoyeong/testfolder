package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Emp;
import com.service.spring.model.EmpDAO;

@Repository
public class EmpDAOImpl implements EmpDAO{

	private final String NS = "sql.emp.mapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insert(Emp emp) {
		sqlSession.insert(NS+"insert", emp);
	}

	@Override
	public void delete(String num) {
		sqlSession.delete(NS+"delete", num);
	}

	@Override
	public Emp findEmp(String num) {
		Emp emp = sqlSession.selectOne(NS+"findEmp", num);
		return emp;
	}

	@Override
	public List<Emp> findAllEmp() {
		List<Emp> emps = sqlSession.selectList(NS+"findAllEmp");
		return emps;
	}
	
}
