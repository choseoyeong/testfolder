package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 -- 서버 내부 매핑 
 <servlet>
 	<servlet-name> HelloServlet </sevlet-name>
 	<servlet-class> servlet.HelloServlet </servlet-class>
 <servlet>
 
 -- client에서 사용하는 매핑
 <servlet-mapping>
 	<servlet-name> HelloServlet </servlet-name>
 	<url-pattern>/HelloServlet<url-pattern>
 <servlet-mapping> 
 */


@WebServlet("/HelloServlet")	// 위의 과정을 알아서 해줌
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Hello Servlet이 요청 받으면 실행되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloServlet...프로그램 구동중");
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}
}
