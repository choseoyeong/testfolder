package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		
		try {
			MemberVO vo = MemberDAOImpl.getInstance().findByIdMember(id);
			if(vo != null) {
				System.out.println("not null!!!");
				request.setAttribute("vo", vo); 	// 바인딩
				path = "find_ok.jsp";
			}

		} catch (Exception e) {
			System.out.println("error!!");
		}
		
		return new ModelAndView(path);
	}

}
