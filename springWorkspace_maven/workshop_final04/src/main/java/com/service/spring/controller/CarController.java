package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.service.spring.domain.UserInfo;
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
		Car car = carService.findCar(new Car(num));
		
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
		model.addAttribute("num", num);
		return "detail";
	}
	
	@RequestMapping("updateCar.do")
	public String updateCar(Car car, Model model, HttpSession session) {
		session.setAttribute("errorLocation", "차량 수정");
		System.out.println("before update: "+car);
		
		int res = carService.updateCar(car);
		
		session.setAttribute("num", car.getNum());
		System.out.println("getnum : "+ car.getNum());
		session.setAttribute("message", "수정 성공");
		
		session.setAttribute("destName", "자동차 목록 조회");
		session.setAttribute("destUrl", "list.jsp");
		return "redirect:result.jsp";
	}
	
	////////////////////////////////////////////////////////
	@RequestMapping("idExist.do")
	@ResponseBody
	public boolean idExist(String id, Model model, HttpSession session) {
		session.setAttribute("errorLocation", "아이디 중복 확인");
		UserInfo us = carService.selectUser(new UserInfo(id));
		int check = 0;

		if(us == null) {
			check = 1;
			session.setAttribute("check", check);
			return true;
		}
	
		session.setAttribute("check", check);
		return false;
	}
	
	@RequestMapping("selectUser.do")
	public String selectUser(UserInfo user, Model model, HttpSession session) {
		session.setAttribute("errorLocation", "로그인");
		UserInfo us = carService.selectUser(user);
		
		if(us != null) {
			session.setAttribute("loginUser", us);
			session.setAttribute("num", us.getId());
			session.setAttribute("message", "로그인성공");
			
			session.setAttribute("destName", "로그아웃");
			session.setAttribute("destUrl", "login.jsp");
			return "redirect:result.jsp";
		}
		
		return "redirect:login.jsp";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")!=null) {
			session.invalidate();
			return "login";
		}
		return null;
	}
	
	@RequestMapping("insertUser.do")
	public String insertUser(UserInfo user, Model model, HttpSession session) {
		session.setAttribute("errorLocation", "유저 등록");
		int res = carService.insertUser(user);
	
		return "redirect:login.jsp";
	}
	
	////////////////////////////////////////////////////////
	@ExceptionHandler
	 public String nullex(Exception e, HttpSession session) {
//        System.err.println(e.getClass());
        session.setAttribute("message", e);
        return "redirect:errorPage.jsp";
    }
}
