package com.service.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.spring.domain.Product;
import com.service.spring.model.ProductDAO;

@SpringBootTest
class SprintTestChoseoyeongApplicationTests {

	@Autowired
	private ProductDAO dao;
	
	@Test
	void insertProduct() {
		Product c 
			= new Product("4444", "테스트적금", "목돈마련", 4.4, "4번메모");
//			= new Product("11가1111", "제네시스", 9000, "10");
		System.out.println(dao.insertProduct(c));
	}
	
//	@Test
//	void deleteProduct() {
//		List<String> ls = new ArrayList<String>();
//		ls.add("11가1111");
//		ls.add("43나8272");
//		System.out.println(dao.deleteProduct(ls));
//	}
	
//	@Test
//	void findProduct() {
//		Product c = new Product("11가1111", "제네시스", 9000, "10");
//		System.out.println(dao.findProduct(c));
//	}
	
//	@Test
//	void findAllProduct() {
//		List<Product> ProductList = dao.findProduct();
//		for(Product c: ProductList) { System.out.println(c); }
//	}
}
