package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	// 폼에 입력된 값이 Controller로 넘어올 때 자동으로 바인딩됨.
	
	// "form.do"라는 이름으로 요청이 들어오면
	@RequestMapping("form.do")
	public ModelAndView form(HttpServletRequest request, String name, String addr) {
		
		/*
		 * 1. 폼값 받아서
		 * 2. VO 생성
		 * 3. Service 받아와서
		 * 4. service.registerForm(); --> dao.register(); --> sqlSession.insert("mapper.addRegister")
		 * 5. ModelAndView 생성
		 */
		
//		String name = request.getParameter("name");
//		String addr = request.getParameter("addr");
		
		/*
		 * form_result는 결과 페이지 이름
		 * form_resut.jsp 라는 이름으로
		 * WEB-INF<views< 에 저장됨
		 * --> 이런 정보가 어디 나와있을까?
		 * 
		 *  WEB-INF/views/  --> prefix
		 *  .jsp 			--> suffix
		 * => InternalResourceViewResolver라는 Bean에서 이런 내용을 다룸  
		 * -> 코드에 경로까지 집어넣으면 필요 없지만, 나중에 꼭 필요할 일이 생김 
		 *  
		 * "info"는 바인딩 된 이름인데, request 객체에 바인딩된다.
		 * 
		 * 3번째 인자는 info라는 이름으로 바인딩 된 객체. 
		 * 출력이 되려면 ${info}
		 * 
		 * FormController에서 form_result.jsp로 페이지 이동하는데, default는 forward 방식.
		 */
		
		return new ModelAndView("form_result", "info", name + " 님이 사는 곳은 " + addr);
	}
	
}
