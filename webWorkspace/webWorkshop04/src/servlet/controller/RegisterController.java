package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookDAOImpl;
import servlet.model.ModelAndView;

public class RegisterController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("RegisterController...");
		
		String[] bookNoList = request.getParameterValues("bookNo");
		String isbn = "";
		for(int i=0; i<bookNoList.length; i++) {
			if(i==bookNoList.length-1) {
				isbn += bookNoList[i];
			} else {
				isbn += bookNoList[i] + "-";
			}
		}
		String title = request.getParameter("bookTitle");
		String catalogue = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String publish_date = request.getParameter("bookDate");
		String publisher = request.getParameter("bookPublisher");
		String author = request.getParameter("bookAuthor");
		int price = Integer.parseInt(request.getParameter("bookPrice"));
		String description = request.getParameter("bookSummary");
		
		Book book = new Book(isbn, title, catalogue, nation, publish_date, publisher, author, price, description);
		
		BookDAOImpl dao = BookDAOImpl.getInstance();
		ModelAndView mv = null;
		
		try {
			dao.registerBook(book);
			request.setAttribute("book", book);
			mv = new ModelAndView("bookSuccess.jsp");
			
		} catch (SQLException e) {
			System.out.println("Register Failed.");
			mv = new ModelAndView("../error.jsp", true);  // error 페이지로 이동
		}
		
		return mv;
	}

}
