package com.edu.array.vo;
/*
 * 상품에 대한 정보를 저장하는 vo(value object)클래스..
 * 
 */
public class Product {
	private String maker;
	private int price;
	private int quantity;
	private String company;
	
	public Product(String maker, int price, int quantity, String company) {
		super();
		this.maker = maker;
		this.price = price;
		this.quantity = quantity;
		this.company = company;
	}
	
	public String getMaker() {
		return maker;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getCompany() {
		return company;
	}

	// 기능 추가
	public String getDetails() {
		return maker + "\t" + price + "\t" + quantity + "\t" + company;
	}
	
	
	
	
}
