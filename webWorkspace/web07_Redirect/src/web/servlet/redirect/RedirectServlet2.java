package web.servlet.redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Redirect2")
public class RedirectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
		
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1) 에러가 발생하는 경우...에러페이지로 연결(.html) --> redirect 방식
		 * 2) 에러가 발생하지 않는 경우...결과페이지로 연결 (.jsp) --> forward 방식
		 */
		
		String city = request.getParameter("city");
		if(city!=null)
			request.getRequestDispatcher("redirect2.jsp").forward(request, response);
		else
			response.sendRedirect("error/error2.html");
	}
}
