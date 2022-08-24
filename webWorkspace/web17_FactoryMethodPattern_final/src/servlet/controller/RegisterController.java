package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class RegisterController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id, password, name, address);
		
		String path = "index.jsp";
		
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			request.setAttribute("vo", pvo);
			path = "register_result.jsp";
			
		} catch (Exception e) {
			
		}
		
		return new ModelAndView(path);
	}

}
