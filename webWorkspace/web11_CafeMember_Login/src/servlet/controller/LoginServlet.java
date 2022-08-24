package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
		
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 시험문제 나옴
		 * 
		 * 1. 한글처리
		 * 2. Form값 받기
		 * 3. (VO 객체 생성)
		 * 4. DAO 리턴...비즈니스 로직 호출
		 * 5. 반환값 Attribute에 바인딩...로그인 하는 동안 vo정보를 저장...httpSession 사용
		 * 6. 페이지 이동(네비게이션)
		 */
		
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		String path = "index.html";	// 로그인 실패하면 다시 로그인 화면으로 돌림

		try {
			// 화면으로부터 값을 받아서 만든 vo는 pvo
			// db에서 값을 받아서 만든 vo rvo로 사용하면 좋음
			MemberVO rvo = (MemberDAOImpl.getInstance()).login(id, password);
			System.out.println(rvo);
			
			// 클라이언트가 요청하면 세션은 서버에 자동적으로 만들어지고..개발자는 그걸 받아서 사용
			HttpSession session = request.getSession();
			
			if(rvo!=null) {	// 로그인 성공시에만 바인딩 진행
				session.setAttribute("vo", rvo);
				System.out.println("JSESSION :: " + session.getId());
				path = "login_result.jsp";
			}
		} catch(SQLException e) {
			
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
