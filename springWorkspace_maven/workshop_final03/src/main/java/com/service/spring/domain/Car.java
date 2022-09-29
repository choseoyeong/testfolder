package com.service.spring.domain;

public class Car {
	private String num;
	private String model;
	private int price;
	private String vcode;
	
	private Company company;

	public Car() {}
	
	public Car(String num) {
		super();
		this.num = num;
	}
	
	public Car(String num, String model, int price, String vcode) {
		super();
		this.num = num;
		this.model = model;
		this.price = price;
		this.vcode = vcode;
	}
	
	public Car(String num, String model, int price, String vcode, Company company) {
		super();
		this.num = num;
		this.model = model;
		this.price = price;
		this.vcode = vcode;
		this.company = company;
	}


	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	@Override
	public String toString() {
		return "Car [num=" + num + ", model=" + model + ", price=" + price + ", vcode=" + vcode + ", company=" + company
				+ "]";
	}

}
