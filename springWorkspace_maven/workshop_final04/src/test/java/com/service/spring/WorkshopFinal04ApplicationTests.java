package com.service.spring;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.spring.domain.Car;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.CarDAO;

@SpringBootTest
class WorkshopFinal04ApplicationTests {

	@Autowired
	private CarDAO dao;
	
//	@Test
//	void insertCar() {
//		Car c 
//			= new Car("43나8272", "SM7", 7000, "20");
////			= new Car("11가1111", "제네시스", 9000, "10");
//		System.out.println(dao.insertCar(c));
//	}
	
//	@Test
//	void deleteCar() {
//		List<String> ls = new ArrayList<String>();
//		ls.add("11가1111");
//		ls.add("43나8272");
//		System.out.println(dao.deleteCar(ls));
//	}
	
//	@Test
//	void findCar() {
//		Car c = new Car("11가1111", "제네시스", 9000, "10");
//		System.out.println(dao.findCar(c));
//	}
	
//	@Test
//	void findAllCar() {
//		List<Car> carList = dao.findCar();
//		for(Car c: carList) { System.out.println(c); }
//	}
	
//	@Test
//	void updateCar() {
//		Car c = new Car("33다3333", "스포티지", 4000, "30");
//		System.out.println(dao.updateCar(c));
//	}
	
	///////////////////////////////////////////////
//	@Test
//	void insertUser() {
//		UserInfo user = new UserInfo("id33", "pass33");
//		System.out.println(dao.insertUser(user));
//	}
	
//	@Test
//	void selectUser() {
//		UserInfo user = new UserInfo("id33");
//		System.out.println(dao.selectUser(user));
//	}
}
