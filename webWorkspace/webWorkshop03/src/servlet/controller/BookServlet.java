package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
		
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN BOOKServlet");
		// 도서번호, 도서제목, 도서종류, 출판국가, 출판일, 출판사, 저자, 도서가격, 요약내용
		String[] isbns = request.getParameterValues("bookNo");
		String isbn = isbns[0] + "-" + isbns[1] + "-" + isbns[2];
		System.out.println(isbn);
		String title  = request.getParameter("bookTitle");
		String catalogue = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String publish_date = request.getParameter("bookDate");
		String publisher  = request.getParameter("bookPublisher");
		String author  = request.getParameter("bookAuthor");
		int price = Integer.parseInt(request.getParameter("bookPrice"));
		String description  = request.getParameter("bookSummary");
		
		System.out.println(publish_date);
		
		Book pvo = new Book(isbn, title, catalogue, nation, publish_date, publisher, author, price, description);
		BookDAOImpl dao = BookDAOImpl.getInstance();
		
		try {
			HttpSession session = request.getSession();
			
			if(pvo!=null) {
				session.setAttribute("vo", pvo);
				System.out.println("book 객체 생성 성공");
				dao.registerBook(pvo);
				request.getRequestDispatcher("./book/bookSuccess.jsp").forward(request, response);
			} 		
			
		} catch (Exception e){
			System.out.println("BookServlet Fail..");
		}
		
	}
}
