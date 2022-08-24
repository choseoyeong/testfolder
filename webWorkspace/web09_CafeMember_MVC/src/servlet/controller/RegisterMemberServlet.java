package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/Register")
public class RegisterMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
		
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 한글 처리
		 * 2. 폼값 받는다.
		 * 3. VO 객체 생성
		 * 4. DAO리턴 받아서
		 * 5. 비즈니스 로직 호출
		 * 6. 네비게이션...register_result.jsp
		 */
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(id, password, name, address);
		
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		try {
			dao.registerMember(vo);
//			request.getRequestDispatcher("register_result.jsp").forward(request, response);
		} catch (SQLException e) {
			
		}
		// 회원가입 완료하면 바로 전체 회원 결과 보여주고 싶을 때 redirect
		response.sendRedirect("AllMember");
				
	}
}
