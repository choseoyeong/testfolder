package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubjectController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("SubjectController...");
		
		// DB 갔다왔다 치고..데이터 리턴 받았다 치고..
		
		String result = "JAVA | JDBC | Back-End | Front-End | Framework | AI" ;
		
		request.setAttribute("result", result);
		return new ModelAndView("Result.jsp");
	}

}
