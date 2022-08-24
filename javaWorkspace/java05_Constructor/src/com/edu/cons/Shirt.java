package com.edu.cons;

public class Shirt {
	public String brand;
	public boolean longSleeved;
	public char size;
	
	
	//기본 생성자
	public Shirt() {	}	
	
	//명시적 생성자...필드 초기화
	public Shirt(String brand, boolean longSleeved, char size) {	
		this.brand = brand;
		this.longSleeved = longSleeved;
		this.size = size;
	}


	public String getBrand() {
		return brand;
	}
	public boolean isLongSleeved() {
		return longSleeved;
	}
	public char getSize() {
		return size;
	}
	
	
}
