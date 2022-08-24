package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		String path = "index.jsp";	// 로그인 실패하면 다시 로그인 화면으로 돌림

		try {
			MemberVO rvo = (MemberDAOImpl.getInstance()).login(id, password);
			System.out.println(rvo);
		
			HttpSession session = request.getSession();
			
			if(rvo!=null) {	// 로그인 성공시에만 바인딩 진행
				session.setAttribute("vo", rvo);
				System.out.println("JSESSION :: " + session.getId());
				path = "login_result.jsp";
			}
		
		} catch(Exception e) {
			
		}
		
		return new ModelAndView(path, true);
	}

}
