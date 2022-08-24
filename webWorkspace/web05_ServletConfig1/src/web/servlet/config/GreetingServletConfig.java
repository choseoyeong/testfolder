package web.servlet.config;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/GreetingServletConfig")
public class GreetingServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 필드 선언
	private String greet = "";
	private String name = "";

    public GreetingServletConfig() {
        System.out.println("1. 서블릿 객체 생성...");
    }


	public void init() throws ServletException {
		System.out.println("2. ServletConfig 객체 생성..init 호출..");
		
		// param-name
		greet = getInitParameter("GREET");
		
		System.out.println("Greeting Message :: " + greet);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
		
	// doGet이든 doPost든 한 함수에서 처리하기 위해
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성
		System.out.println("3. doPost 호출. 요청시마다 계속 호출...");
		
		name = request.getParameter("userName");
		
		RequestDispatcher rdp = request.getRequestDispatcher("result.jsp?message=" + greet);
		// 현재 request와 response를 그대로 가져가기 때문에 name 변수는 그대로 사용 가능하다. 
		// greet 변수는 불가능하므로 따로 보내줘야 한다.
		rdp.forward(request, response); 	// 이때 실질적으로 page가 이동한다.
	}
}
