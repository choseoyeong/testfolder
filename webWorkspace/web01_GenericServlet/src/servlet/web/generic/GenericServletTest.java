package servlet.web.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// Java 파일에서 Servlet 성질을 상속받으면 servlet이 됨
public class GenericServletTest extends GenericServlet{

	// 메소드는 클라이언트의 요청이  Web Server를 거쳐서 Container 아래로 내려오면 
	// 이때 Client의 요청을 받아서 처리하는 기능은 service()이다.
	// Client의 요청이 Container에 전해지면 내부적으로 service()가 호출된다.
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// Client의 요청을 처리하는 로직이 여기서 작성된다... 
		// 요청 처리했다고 가정하고...
		// 처리 완료했음을 브라우저로 응답
		PrintWriter out =  res.getWriter();
		
		// 콘솔이 아닌 브라우저로 출력하는 기능...그래서 html 태그를 안에다 넣어야 한다.
		out.println("<html><body bgcolor='cyan'>");
		out.println("<h2>Hello GenericServlet~~!!</h2>");
		out.println("<h3>Deployment Discriptor</h3>");
		out.println("</body></html>");
		
		out.close();
	}
}

// http://127.0.0.1:8888/web01_GenericServlet/GenericServletTest