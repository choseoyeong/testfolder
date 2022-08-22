package com.service.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.MyProduct;
import com.service.spring.model.MyProductService;

@Controller
public class MyProductController {
	@Autowired
	private MyProductService myProductService;
	
	@RequestMapping("myProduct.do")
	public ModelAndView insert(MyProduct vo) throws Exception{
		// ���� �ϳ��ϳ� ���ڿ� ���� �ʿ� ���� �ڵ����� ���ε�����. �������� �˾Ƽ� vo�� ��������
		/* �ڵ� ���ε� ����. �Ʒ� �ڵ带 �ۼ� ���ص� ��
		 * String name = request.getParameter("name");
		 * String maker = request.getParameter("maker");
		 * int price = Integer.parseInt(request.getParameter("price"));
		 * 
		 * MyProduct vo = new MyProduct(name, maker, price);
		 */
		
		// addProduct ���� vo�� id���� null��
		System.out.println("DB �Է� �� :: " + vo.getId());
		
		myProductService.addProduct(vo); // -->dao.addProduct() --> session.insert()
	
		// addProduct ���� vo�� id���� ������..DB�� ����ȭ �Ϸ�
		System.out.println("DB �Է� �� :: " + vo.getId());
		
		// Request�� ���� ���ε��ǰ� ������ ����������� forward �Ǿ�����.
		
		return new ModelAndView("insert_result", "info", vo);
	}
	
	@RequestMapping("myProductSearch.do")
	public ModelAndView search(String command, String word) throws Exception{
		// Request.parameter ������ ����ϴ� ��� ���� ����ϸ� ��
		List<MyProduct> list = null;
		String viewName = "";	// ���������
		
		if(command.equals("findProductByName")) {
			list = myProductService.findProductByName(word);
			viewName = "find_result";
		} else if(command.equals("findProductByMaker")) {
			list = myProductService.findProductByMaker(word);
			viewName = "find_result";
		} else if(command.equals("findProducts")) {
			list = myProductService.findProducts();
			viewName = "find_result";
		}
		
		return new ModelAndView(viewName, "list", list);
	}
}