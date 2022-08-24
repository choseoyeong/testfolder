package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.ModelAndView;
import servlet.model.User;
import servlet.model.UserDAOImpl;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("LoginController...");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		ModelAndView mv = null;
		
		try {
			User rvo = UserDAOImpl.getInstance().login(id, password);

			HttpSession session = request.getSession();

			if (rvo != null) {
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID: " + session.getId());
				
				mv = new ModelAndView("loginSuccess.jsp");
			} else {				
				mv = new ModelAndView("error.jsp", true);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		System.out.println(mv.getPath());
		return mv;
	}

}
