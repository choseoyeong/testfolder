package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Person;

@Controller
public class AjaxController {
	
	@RequestMapping("/")	// http://127.0.0.1:8888/spring
	public String index() {
		System.out.println("context path request.../...");
		
		return "redirect:index.jsp";
	}
	
	@RequestMapping("synchro") 
	public String synchro(Model model) {
		System.out.println("synchro..request..");
		
		model.addAttribute("info", "와 동기통신이다");
		return "synchro_result";
	}
	
	@RequestMapping("asynch")
	public String asynch(Model model) {
		System.out.println("asynchro..request..");
		
		model.addAttribute("person", new Person("구자경", "산포시"));
		return "JsonView";
	}
	
}
