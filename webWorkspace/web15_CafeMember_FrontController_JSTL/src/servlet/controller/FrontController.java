package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
		
	// doGet이든 doPost든 한 함수에서 처리하기 위해
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// command로 넘어온 값에 따라서 요청을 알 수 있고, 요청에 해당하는 메소드를 하나씩 이곳에서 연결시킨다.
		String command = request.getParameter("command");
		String path = "index.html";
		
		if(command.equals("register")) {
			path = register(request, response);
		} else if(command.equals("find")) {
			path = find(request, response);
		} else if(command.equals("login")) {
			path = login(request, response);
		} else if(command.equals("showAll")) {
			path = showAll(request, response);
		} else if(command.equals("logout")) {
			path = logout(request, response);
		} else if(command.equals("update")) {
			path = update(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);
	} // doProcess
	
	public String update(HttpServletRequest request, HttpServletResponse response){
		String path = "index.jsp";
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id, password, name, address);
		
		try {
			MemberDAOImpl.getInstance().updateMember(pvo);
			
			HttpSession session = request.getSession();
			if(session.getAttribute("vo") != null) {
				session.setAttribute("vo", pvo);
				path = "update_result.jsp";
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return path;
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response){
		String path = "index.jsp";
		
		// session을 죽이는 로직...세션이 있을때만
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) { // 로그인이 되어져 있다면..
				session.invalidate();
				path = "logout.jsp";
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return path;
	}

	public String register(HttpServletRequest request, HttpServletResponse response){
		// 회원가입 요청을 서비스하는 로직을 작성..
		// 이전의 RegisterServlet 서비스 안의 내용을 여기에 입력하면 됨
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id, password, name, address);
		
		String path = "index.jsp";
		
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			request.setAttribute("vo", pvo);
			path = "register_result.jsp";
			
		} catch (Exception e) {
			
		}
		
		return path;
	}//register
	
	private String find(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		
		try {
			MemberVO vo = MemberDAOImpl.getInstance().findByIdMember(id);
			if(vo != null) {
				System.out.println("not null!!!");
				request.setAttribute("vo", vo); 	// 바인딩
				path = "find_ok.jsp";
			}

		} catch (Exception e) {
			System.out.println("error!!");
		}
		
		return path;
	}//find
	

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		String path = "index.jsp";	// 로그인 실패하면 다시 로그인 화면으로 돌림

		try {
			MemberVO rvo = (MemberDAOImpl.getInstance()).login(id, password);
			System.out.println(rvo);

			HttpSession session = request.getSession();
			
			if(rvo!=null) {	// 로그인 성공시에만 바인딩 진행
				session.setAttribute("vo", rvo);
				System.out.println("JSESSION :: " + session.getId());
				path = "login_result.jsp";
			}

		} catch(Exception e) {
			
		}
		
		return path;
	}//login


	private String showAll(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		try {
			ArrayList<MemberVO> list = MemberDAOImpl.getInstance().showAllMember();

			request.setAttribute("list", list);
			path = "allView.jsp";
		} catch (Exception e) {
			
		}
		
		return path;
	}

}
