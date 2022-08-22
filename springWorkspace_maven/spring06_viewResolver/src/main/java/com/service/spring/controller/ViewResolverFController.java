package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewResolverFController {
	
	// BeanNameViewResolver 사용
	@RequestMapping("findBoard.do")
	public ModelAndView findBoard() {
		System.out.println("findBoard.do 진입..");
		
		return new ModelAndView("board_result");
	}
	
	// BeanNameViewResolver 사용
	@RequestMapping("/findProduct.do")
	public ModelAndView findProduct() {
		System.out.println("findProduct.do 진입..");
		
		return new ModelAndView("product_result");
	}
	
	// InternalResourceViewResolver 사용
	@RequestMapping("register.do")
	public ModelAndView register() {
		System.out.println("register.do 진입..");
		
		return new ModelAndView("register_result", "info", "InternalResourceViewResolver");
	}
}
