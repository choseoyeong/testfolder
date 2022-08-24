package web.servlet.config;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 1. @Annotation
//@WebServlet("/MainServlet")

// 2.
/*
<servlet>
	<servlet-name>MainServlet</servlet-name>
	<servlet-class>web.servlet.config.MainServlet</servlet-class>
	
	<init-param>
		<param-name>FAIL</param-name>
		<param-value>LOGIN FAIL!!</param-value>
	</init-param>
	
	<load-on-startup>1</load-on-startup>
</servlet>
*/
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String failMessage = "";

    public MainServlet() {
    	System.out.println("1. 서블릿 객체가 생성");
    }
    
    public void init() throws ServletException {
		System.out.println("2. init() 호출...컨테이너에 의해서");
		failMessage = getInitParameter("FAIL");
	}

	// 브라우저가 아니라 서버를 종료해야 destroy가 동작됨
	public void destroy() {
		System.out.println("4. destroy() 호출...컨테이너에 의해서");
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
    	System.out.println("3. service() 호출 ");
    	
    	String id = request.getParameter("id");
    	String password = request.getParameter("password");
    	
    	if(id.equals("bnk") && password.equals("1234")) {
    		request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
    	}
    	else {
    		request.getRequestDispatcher("LoginError.jsp?FAIL=" + failMessage).forward(request, response);
    	}
    	
    }
}
