package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Car;
import com.service.spring.domain.Company;
import com.service.spring.model.CarDAO;

@Repository
public class CarDAOImpl implements CarDAO{
	
	private final String NS = "sql.car.mapper.";
	
	@Autowired
	private SqlSession sqlSession;

	// 삽입
	@Override
	public int insertCar(Car car) {
		return sqlSession.insert(NS+"insertCar", car);
	}

	// 삭제(하나 + 여러개) 동적쿼리
	@Override
	public int deleteCar(List<String> list) {
		return sqlSession.delete(NS+"deleteCar", list);
	}

	// 검색__동적쿼리 
	@Override
	public Car findCar(Car car) {
		Car car1 = sqlSession.selectOne(NS+"findCar", car);
		return car1;
	}
	@Override
	public List<Car> findCar() {
		List<Car> cars = sqlSession.selectList(NS+"findCar", null);
		return cars;
	}
	
	@Override
	public Company findCompany(Company company) {
		Company company1 = sqlSession.selectOne(NS+"findCompany", company);
		return company1;
	}
	@Override
	public List<Company> findCompany(){
		List<Company> companies = sqlSession.selectList(NS+"findCompany", null);
		return companies;
	}
	
	@Override
	public int updateCar(Car car) {
		int res = sqlSession.update(NS+"updateCar", car);
		return res;
	}

}
