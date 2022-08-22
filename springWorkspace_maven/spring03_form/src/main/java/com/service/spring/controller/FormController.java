package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	// ���� �Էµ� ���� Controller�� �Ѿ�� �� �ڵ����� ���ε���.
	
	// "form.do"��� �̸����� ��û�� ������
	@RequestMapping("form.do")
	public ModelAndView form(HttpServletRequest request, String name, String addr) {
		
		/*
		 * 1. ���� �޾Ƽ�
		 * 2. VO ����
		 * 3. Service �޾ƿͼ�
		 * 4. service.registerForm(); --> dao.register(); --> sqlSession.insert("mapper.addRegister")
		 * 5. ModelAndView ����
		 */
		
//		String name = request.getParameter("name");
//		String addr = request.getParameter("addr");
		
		/*
		 * form_result�� ��� ������ �̸�
		 * form_resut.jsp ��� �̸�����
		 * WEB-INF<views< �� �����
		 * --> �̷� ������ ��� ����������?
		 * 
		 *  WEB-INF/views/  --> prefix
		 *  .jsp 			--> suffix
		 * => InternalResourceViewResolver��� Bean���� �̷� ������ �ٷ�  
		 * -> �ڵ忡 ��α��� ��������� �ʿ� ������, ���߿� �� �ʿ��� ���� ���� 
		 *  
		 * "info"�� ���ε� �� �̸��ε�, request ��ü�� ���ε��ȴ�.
		 * 
		 * 3��° ���ڴ� info��� �̸����� ���ε� �� ��ü. 
		 * ����� �Ƿ��� ${info}
		 * 
		 * FormController���� form_result.jsp�� ������ �̵��ϴµ�, default�� forward ���.
		 */
		
		return new ModelAndView("form_result", "info", name + " ���� ��� ���� " + addr);
	}
	
}