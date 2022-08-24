package web.servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// Annotation --> XML
//@WebServlet("/Life2")
public class ServletLifeCycleTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	
	// Servlet 생성할 때 실행됨. servlet은 container가 D.D 파일 읽고나서 함. 
	// 즉, Client 요청과 상관 없음 -> request, response 사용 못함 -> 브라우저에 출력 못함(PrintWriter 사용 불가)
	public ServletLifeCycleTest2() {	
		System.out.println("1b. 서블릿 객체가 생성...컨테이너에 의해서");
	}
  
	public void init() throws ServletException {
		System.out.println("2b. init() 호출...컨테이너에 의해서");
	}

	// 브라우저가 아니라 서버를 종료해야 destroy가 동작됨
	public void destroy() {
		System.out.println("4b. destroy() 호출...컨테이너에 의해서");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
		
	// 새로고침으로 계속 요청하면 1, 2는 출력 안되고 3만 반복해서 출력됨
	// 브라우저 창을 나갔다가 들어와도 Count 유지됨. 서버 종료와 브라우저 종료는 다름
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성
		System.out.println("3b. service() 호출 --> doGet(), doPost() 재호출...컨테이너에 의해서");
		
		PrintWriter out = response.getWriter();
		
		// 클라이언트의 서비스를 수행...수행결과데이터를 jsp 페이지로 연결..
		count = 1004;

		// 1. get방식으로 jsp에 값 전달. cnt라는 이름으로 count 변수의 값을 전달	--> 두번의 요청, 두번의 응답
		// 요청할 때 값을 받음
		out.println("<a href=life2.jsp?cnt=" + count + ">life2.jsp로 이동</a>");
		
		
		// 2. 브라우저로 일단 응답하지 않고... 서버 안에서 바로 jsp로 연결...응답을 jsp가 한다. --> 한번의 요청, 한번의 응답
//		request.getRequestDispatcher("life2.jsp?cnt=" + count).forward(request, response);
//		out.close();		// request, response, thread가 death됨
	}

}
