package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 1. ���� �޾Ƽ�
		 * 2. vo����
		 * 3. DAO ����
		 * 4. DAO �޼ҵ� ȣ��..
		 * (5. ����� ���ε�) --> X
		 * 6. ModelAndView ���� 
		 */
		
		// �⺻������ request�� ���ε��ǰ� forward�� �̵���
		// ���������, �̸�, ��
		// message��� �̸����� "hello~~"�� request�� ���ε� ��
		return new ModelAndView("result", "message", "Hello Spring Maven~!!");
	}

}