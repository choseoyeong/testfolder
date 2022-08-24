package web.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FS")
public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	// doGet이든 doPost든 한 함수에서 처리하기 위해
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성
		/*
		 * 1. Form값 받는다...Client --> Server로 요청이 들어올 때 :: ServletRequest
		 * 2. 받은 값을 다시 클라이언트로 전송함
		 */
		
		//인자로 form의 이름을 넣음
		String user_id = request.getParameter("id");
		String user_pass = request.getParameter("pass");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<li>Your ID : " + user_id + "<br>");
		out.println("<li>Your Password : " + user_pass + "<br>");
		out.println("</body><html>");
		
		out.close();
	}

}
