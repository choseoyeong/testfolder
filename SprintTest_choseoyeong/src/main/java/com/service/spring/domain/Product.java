package com.service.spring.domain;

public class Product {
	private String code;
	private String title;
	private String category;
	private double rate;
	private String memo;
	
	public Product() {
		
	}
	
	public Product(String code) {
		super();
		this.code = code;
	}
	
	public Product(String code, String title, String category, double rate, String memo) {
		super();
		this.code = code;
		this.title = title;
		this.category = category;
		this.rate = rate;
		this.memo = memo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", title=" + title + ", category=" + category + ", rate=" + rate + ", memo="
				+ memo + "]";
	}
}
