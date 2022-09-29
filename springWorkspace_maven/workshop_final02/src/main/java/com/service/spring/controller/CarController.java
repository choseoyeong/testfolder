package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.spring.domain.Car;
import com.service.spring.domain.Company;
import com.service.spring.model.CarService;

@Controller
public class CarController {
	/*
	 * update: post(put)
	 * 가져오기, 페이지이동: get
	 * 삭제: post(delete)
	 * 기타(데이터 담아서 보낼때):post 
	 */
	@Autowired
	private CarService carService;
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("errorLocation", "메인페이지");
		//int test = 1/0; //error test
		return "index";
	}
	
	@RequestMapping("insertCar.do")
	public String insertCar(Car car, Model model, HttpSession session) {
		session.setAttribute("errorLocation", "차량 등록");
		int res = carService.insertCar(car);
		session.setAttribute("num", car.getNum());
		session.setAttribute("message", "등록 성공");
		
		session.setAttribute("destName", "자동차 목록 조회");
		session.setAttribute("destUrl", "list.jsp");
		return "redirect:result.jsp";
	}
	
	@RequestMapping("deleteCar.do")
	@ResponseBody
	public int deleteCar(@RequestParam(value="numList[]") List<String> numList, Model model, HttpSession session) {
		session.setAttribute("errorLocation", "차량 삭제");
		int res = carService.deleteCar(numList);
		/*int res = carService.insertCar(car);
		session.setAttribute("num", car.getNum());
		session.setAttribute("message", "등록 성공");
		
		session.setAttribute("destName", "자동차 목록 조회");
		session.setAttribute("destUrl", "list.jsp");*/
//		return "redirect:result.jsp";
		return res;
	}
	
	@RequestMapping("findCompany.do")
	@ResponseBody
	public Company findCompany(String vcode) {
		Company company = carService.findCompany(new Company(vcode));
		return company;
	}
	
	@RequestMapping("findAllCompany.do")
	@ResponseBody
	public List<Company> findAllCompany() {
		List<Company> carList = carService.findCompany();
		return carList;
	}
	
	@PostMapping("findCar.do")
	@ResponseBody
	public Car findCar(String num, Model model, HttpSession session) {
		System.out.println("in findCar.do");
		Car car = carService.findCar(new Car(num));
		System.out.println("car: "+car);
		
		return car;
	}

	@RequestMapping("findAllCar.do")
	@ResponseBody
	public List<Car> findAllCar( Model model, HttpSession session) {
		List<Car> list = carService.findCar();
//		session.setAttribute("num", car.getNum());
//		session.setAttribute("message", "등록 성공");
//		
//		session.setAttribute("destName", "자동차 목록 조회");
//		session.setAttribute("destUrl", "findAllCar.do");

		return list;
	}
	
	@RequestMapping("detail.do/{num}")
	public String toDetail(@PathVariable String num, Model model, HttpSession session) {
//		System.out.println("in findAllCar.do");
//		List<Car> list = carService.findCar();
		model.addAttribute("num", num);
//		session.setAttribute("message", "등록 성공");
//		
//		session.setAttribute("destName", "자동차 목록 조회");
//		session.setAttribute("destUrl", "findAllCar.do");

		return "detail";
	}
	
	@ExceptionHandler
	 public String nullex(Exception e, HttpSession session) {
//        System.err.println(e.getClass());
        session.setAttribute("message", e);
        return "redirect:errorPage.jsp";
    }
}
