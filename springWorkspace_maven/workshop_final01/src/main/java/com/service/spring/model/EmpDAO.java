package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.Emp;

public interface EmpDAO {
	// 등록
	public void insert(Emp emp);
	
	// 삭제
	public void delete(String num);
	
	// 특정 사원 조회
	public Emp findEmp(String num);
	
	// 전체 목록 조회
	public List<Emp> findAllEmp();
}
