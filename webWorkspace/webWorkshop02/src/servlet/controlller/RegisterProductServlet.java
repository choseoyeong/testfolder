package servlet.controlller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.ProductDAOImpl;
import servlet.model.ProductVO;

@WebServlet("/REGISTER")
public class RegisterProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
		
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String detail = request.getParameter("detail");
		
		ProductDAOImpl dao = ProductDAOImpl.getInstance();
		ProductVO vo = new ProductVO(name, price, detail);
		
		try {
			dao.registerProduct(vo);
			System.out.println("등록 완료");
			request.setAttribute("vo", vo);
			
		} catch (SQLException e) {
		}
		request.getRequestDispatcher("register_result.jsp").forward(request, response);
	}

}
