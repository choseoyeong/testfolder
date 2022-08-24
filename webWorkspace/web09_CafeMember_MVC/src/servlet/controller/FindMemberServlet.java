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

@WebServlet("/FIND")
public class FindMemberServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
		
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		// Controller에서는 throw하지 않고 try/catch문을 사용해서 성공 여부에 따라 다른 결과 페이지와 연결
		String path = "find_fail.jsp";
		try {
			MemberVO vo = dao.findByIdMember(id);
			if(vo != null) {
				System.out.println("not null!!!");
				request.setAttribute("vo", vo); 	// 바인딩
				path = "find_ok.jsp";
			}
		} catch (SQLException e) {
			System.out.println("error!!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
}
