package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.User;
import servlet.model.UserDAOImpl;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
		
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("id");
		String password = request.getParameter("password");
		
		try {
			User rvo = UserDAOImpl.getInstance().login(userId, password);
			
			HttpSession session = request.getSession();
			
			if(rvo!=null) {	// 로그인 성공 시
				System.out.println("로그인 성공!!");
				session.setAttribute("vo", rvo);
				request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			}
			else { // 로그인 실패 시
				System.out.println("로그인 실패..");
				response.sendRedirect("error.jsp");
			}
		} catch(Exception e) {
			
		}
		
		
	}
}
