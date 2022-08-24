package com.edu.self.vo;

import com.edu.self.util.MyDate;

public class Engineer extends Employee{
	private String tech;
	private double bonus;
	
	public Engineer(String name, MyDate birthday, double salary, String tech, double bonus) {
		super(name, birthday, salary);
		this.tech = tech;
		this.bonus = bonus;
	}	
	public void setTech(String tech) {
		this.tech = tech;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}	

	public String getTech() {
		return tech;
	}
	public double getBonus() {
		return bonus;
	}
	
	@Override
	public String getDetails() {
		return super.getDetails() + ", " + tech + ", " + bonus;
	}

	
	
}
