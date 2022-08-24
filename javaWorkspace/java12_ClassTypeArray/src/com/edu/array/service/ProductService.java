package com.edu.array.service;

import com.edu.array.vo.Product;

// Product들을 핸들링하는 서비스 클래스...
// 기능들로만 구성되어져 있다.
/*
 * 1) 모든 상품들의 maker를 출력하는 기능
 * 2) 상품들의 총 금액을 리턴하는 기능
 * 3) 특정금액 이상의 상품들을 리턴하는 기능
 * 4) 동일한 회사의 제품들만 리턴하는 기능
 * 5) 구입한 상품들의 평균가를 리턴하는 기능---(Quantity 포함)
 * 
 * ☆선언부(identifier, 인자, return type)☆ 먼저 작성하고 구현부 작성하기
 */
public class ProductService {
	
//	인자로 안가져오고 이렇게 구현해도 됨
//	private Product[] pros;
//	
//	public ProductService(Product[] pros) {
//		this.pros = pros;
//	}

	public void printAllMaker(Product[] pros) {
		for(Product p: pros)
			System.out.println(p.getMaker());
	}
	
	public int getTotalPrice(Product[] pros) {
		int total = 0;
		for(Product p: pros)
			total += p.getPrice() * p.getQuantity();
		
		return total;
	}
	
	public Product[] printMoreExpensive(Product[] pros, int price) {
		Product[] temp = new Product[pros.length];
		
		int index=0;
		for(Product p: pros)
			if(p.getPrice() >= price)
				temp[index++] = p;
		
		return temp;
	}
	
	public Product[] getSameCompany(Product[] pros, String company) {
		Product[] temp = new Product[pros.length];

		int index = 0;
		for(Product p: pros) 
			if(p.getCompany().equals(company))
				temp[index++] = p;
		
		return temp;
	}
	
	public int getAveragePrice(Product[] pros) {
//		int totalPrice = 0;
//		int totalQuantity = 0;
//		
//		for(Product p: pros) {
//			totalQuantity += p.getQuantity();
//			totalPrice += p.getPrice() * p.getQuantity();
//		}
//			
//		return totalPrice/totalQuantity;
		
		// 있는 함수 최대한 활용하기
		return getTotalPrice(pros) / pros.length;
	}
}
