package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.spring.domain.Emp;
import com.service.spring.model.EmpService;

@Controller
public class EmpController {
	/*
	 * update: put
	 * 가져오기, 페이지이동: get
	 * 삭제: delete
	 * 기타(데이터 담아서 보낼때):post 
	 * 
	 * */
	
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:index.jsp";
	}
	
	@RequestMapping("insert.do")
	public String insert(Emp emp, Model model) {
		try {
			empService.insert(emp);
			
			// result.jsp에 num 값을 보냄
			model.addAttribute("empNum", emp.getNum());
			model.addAttribute("message", "입사 축하!!");

			return "result";
		} catch(Exception e) {
			model.addAttribute("message", "사원 입력");
			return "error";
		}
	}
	
	@RequestMapping("findAllEmp.do")
	@ResponseBody
//	public String findAllEmp(Model model) {
	public List<Emp> findAllEmp(Model model) {
//		try {
			List<Emp> list = empService.findAllEmp();
			System.out.println(list);
			model.addAttribute("empList", list);
			return list;
//		} catch(Exception e) {
//			model.addAttribute("message", "사원 입력");
//			return "error";
//		}
		
	}
	
	@RequestMapping(value="findEmp.do", method=RequestMethod.GET)
	public String findEmp(String num, Model model) {
		try {
			Emp emp = empService.findEmp(num);
			model.addAttribute("emp", emp);
			return "detail";
		} catch(Exception e) {
			model.addAttribute("message", "사원 관리-상세정보");
			return "error";
		}
	}
	
	@RequestMapping(value="delete.do", method=RequestMethod.GET)
	public String delete(String num, Model model) {
		try {
			empService.delete(num);
			model.addAttribute("empNum", num);
			model.addAttribute("message", "삭제 성공");
			return "result";
		} catch(Exception e) {
			model.addAttribute("message", "사원 삭제");
			return "error";
		}
		
	}
}