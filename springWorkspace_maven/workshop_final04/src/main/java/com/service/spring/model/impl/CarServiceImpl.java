package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.spring.domain.Car;
import com.service.spring.domain.Company;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.CarDAO;
import com.service.spring.model.CarService;

@Component
public class CarServiceImpl implements CarService{

	@Autowired
	private CarDAO dao;

	// 삽입
	@Override
	public int insertCar(Car car) {
		return dao.insertCar(car);
	}

	// 삭제(하나 + 여러개) 동적쿼리
	@Override
	public int deleteCar(List<String> list) {
		return dao.deleteCar(list);
	}

	// 검색__동적쿼리 
	@Override
	public Car findCar(Car car) {
		return dao.findCar(car);
	}
	@Override
	public List<Car> findCar() {
		return dao.findCar();
	}
	
	@Override
	public Company findCompany(Company company) {
		return dao.findCompany(company);
	}
	@Override
	public List<Company> findCompany(){
		return dao.findCompany();
	}
	
	@Override
	public int updateCar(Car car) {
		return dao.updateCar(car);
	}
	
	/////////////////////////////////////////////////////
	@Override
	public int insertUser(UserInfo user) {
		return dao.insertUser(user);
	}
	
	@Override
	public UserInfo selectUser(UserInfo user) {
		return dao.selectUser(user);
	}
}
