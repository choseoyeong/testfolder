package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.ModelAndView;

@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
		
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN FrontController");
		String command = request.getParameter("command");
		
		System.out.println("command:: " + command);
		
		Controller controller = ControllerFactory.getInstance().createController(command);
		
		ModelAndView mv = controller.handleRequest(request, response);
		
		if(mv!=null) {
			if(!mv.isRedirect())
				request.getRequestDispatcher(mv.getPath()).forward(request, response);
			else
				response.sendRedirect(mv.getPath());
		}
	}

}
