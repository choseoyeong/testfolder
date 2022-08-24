package com.edu.oop2;

/*
 * Has a Relation
 * 
 * NoteBook	----> Programmer
 * 
 */

public class NoteBook {
	
	public String brand;
	public int price;
	public int serialNumber;

	public String getNoteBookInfo() {	
		return "NoteBookInfo :: " + brand + "," + price + "," + serialNumber;
	}
	
	public String getBrand() {
		return brand;		
	}

	
	public void setNoteBookInfo(String brand, int price, int serialNumber) { 
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
	}
	
}
