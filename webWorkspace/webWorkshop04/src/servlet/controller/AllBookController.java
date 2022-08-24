package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookDAOImpl;
import servlet.model.ModelAndView;

public class AllBookController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AllBookController...");
		
		BookDAOImpl dao = BookDAOImpl.getInstance();
		ModelAndView mv = null;
		
		try {
			ArrayList<Book> books = dao.showAllBook();
			
			request.setAttribute("results", books);
			mv = new ModelAndView("booklist.jsp");
			
		} catch (SQLException e) {
			System.out.println("Search-All Failed.");
			mv = new ModelAndView("../error.jsp", true);  // error 페이지로 이동
		}
		
		return mv;
	}

}
