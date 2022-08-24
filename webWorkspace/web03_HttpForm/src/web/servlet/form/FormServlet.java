package web.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
		
	// doGet이든 doPost든 한 함수에서 처리하기 위해
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 한글처리...양방향(요청, 응담) 둘다 해줘야 함
		 * form 값 받는다.(Client -> Server). request 객체와 직결됨
		 * 받은 값을 브라우저로 출력..응답(Server -> Client). response 객체와 직결됨
		 */
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		
		// check box값
		String[] tech = request.getParameterValues("tech");
		
		// 요청 시 한글 처리
		request.setCharacterEncoding("utf-8");
		// 응답 시 한글 처리
		response.setContentType("text/html;charset=utf-8");
		
		// 출력
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><h2>폼값에 입력된 정보를 출력합니다..</h2>");
		out.println("<li>당신의 아이디 " + id + "</li>");
		out.println("<li>당신의 패스워드 " + password + "</li>");
		out.println("<li>당신의 성별은 " + gender + "</li><br><br>");
		
		out.println("<b>당신이 사용 가능한 기술들입니다...</b><br><br>");
		String techs = "";
		for(String t: tech) { techs += t+"  "; }
		out.println(techs);
		
		out.println("</body></html>");
	}

}
