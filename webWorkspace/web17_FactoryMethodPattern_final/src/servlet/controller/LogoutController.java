package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LogoutController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		
		// session을 죽이는 로직...세션이 있을때만
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) { // 로그인이 되어져 있다면..
				session.invalidate();
				path = "logout.jsp";
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return new ModelAndView(path, true);
	}

}
