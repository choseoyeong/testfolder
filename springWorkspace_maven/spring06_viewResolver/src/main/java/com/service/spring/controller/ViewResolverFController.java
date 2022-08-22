package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewResolverFController {
	
	// BeanNameViewResolver ���
	@RequestMapping("findBoard.do")
	public ModelAndView findBoard() {
		System.out.println("findBoard.do ����..");
		
		return new ModelAndView("board_result");
	}
	
	// BeanNameViewResolver ���
	@RequestMapping("/findProduct.do")
	public ModelAndView findProduct() {
		System.out.println("findProduct.do ����..");
		
		return new ModelAndView("product_result");
	}
	
	// InternalResourceViewResolver ���
	@RequestMapping("register.do")
	public ModelAndView register() {
		System.out.println("register.do ����..");
		
		return new ModelAndView("register_result", "info", "InternalResourceViewResolver");
	}
}
