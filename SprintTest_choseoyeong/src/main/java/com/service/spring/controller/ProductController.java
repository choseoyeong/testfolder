package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.spring.domain.Product;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("errorLocation", "메인페이지");
		// int test = 1/0; //error test
		return "index";
	}

	@RequestMapping("insertProduct.do")
	public String insertProduct(Product Product, Model model, HttpSession session) {
		session.setAttribute("errorLocation", "상품 등록");
		int res = productService.insertProduct(Product);
		session.setAttribute("message", "등록");

		session.setAttribute("destName", "상품 목록");
		session.setAttribute("destUrl", "list.jsp");
		return "redirect:result.jsp";
	}

	@RequestMapping("deleteProduct.do")
	public String delete(String code, Model model, HttpSession session) {
		System.out.println("삭제코드: "+ code);
		session.setAttribute("errorLocation", "상품 삭제");
		int res = productService.deleteProduct(code);
		System.out.println("delete: " + res);
		session.setAttribute("message", "삭제");
		return "redirect:result.jsp";
	}

	@PostMapping("findProduct.do")
	@ResponseBody
	public Product findProduct(String code, Model model, HttpSession session) {
		Product product = productService.findProduct(new Product(code));
		System.out.println("findProduct:: " + product);
		return product;
	}

	@RequestMapping("findAllProduct.do")
	@ResponseBody
	public List<Product> findAllProduct(Model model, HttpSession session) {
		List<Product> list = productService.findProduct();
		return list;
	}

	@RequestMapping("detail.do/{code}")
	public String toDetail(@PathVariable String code, Model model, HttpSession session) {
		System.out.println("detail code: " + code);
		model.addAttribute("code", code);
		return "detail";
	}
	
	///////////////////////////////////////
	@RequestMapping("selectUser.do")
	public String selectUser(UserInfo user, Model model, HttpSession session) {
		session.setAttribute("errorLocation", "로그인");
		UserInfo us = productService.selectUser(user);
		
		session.setAttribute("loginMsg", "로그인이 필요합니다.");
		
		if(us != null) {
			session.setAttribute("loginUser", us);
			session.setAttribute("userid", us.getId());
			session.setAttribute("message", "로그인성공");
			session.setAttribute("loginMsg", "로그인 되었습니다.");
			
			session.setAttribute("destName", "로그아웃");
			session.setAttribute("destUrl", "login.jsp");
			return "redirect:index.jsp";
		}
		
		return "redirect:index.jsp";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")!=null) {
			session.invalidate();
			return "index";
		}
		return "index";
	}
	
	//////////////////////////////////////
	@ExceptionHandler
	 public String nullex(Exception e, HttpSession session) {
       session.setAttribute("message", e);
       return "redirect:errorPage.jsp";
   }

}
