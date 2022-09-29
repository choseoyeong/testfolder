package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.Car;
import com.service.spring.domain.Company;

public interface CarService {
	// 등록
	public int insertCar(Car car);
	
	// 삭제
	public int deleteCar(List<String> list);
	
	// 일부 조회
	public Car findCar(Car car);
	// 전체 목록 조회
	public List<Car> findCar();
	
	// 일부 조회
	public Company findCompany(Company company);
	// 전체 목록 조회
	public List<Company> findCompany();
	
	// 수정
	public int updateCar(Car car);
}
