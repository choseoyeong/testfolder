package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

// Child Class...
public class Engineer extends Employee{

	private String tech;
	private double bonus;


	public Engineer(String name, double salary, String address,MyDate birthday, String tech, double bonus) {
		super(name, salary, address,birthday);
		this.tech = tech;
		this.bonus = bonus;
	}		
	
	@Override
	public String getDetails() {		
		return super.getDetails()+"\t"+tech+"\t"+bonus;
	}

	public String getTech() {
		return tech;
	}

	public void changeTech(String tech) {
		this.tech = tech;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}











