package com.edu.vo;

public class Pet {
	private String species;
	private int age;
	private char gender;
	private String petName;
	private boolean isHungry;
	private double temperature;
	private int hour;
	private int cost;
	
	public static final double BASIC_TEMPERATURE = 36.5;
	
	public Pet(String species, int age, char gender, String petName, int cost) {
		super();
		this.species = species;
		this.age = age;
		this.gender = gender;
		this.petName = petName;
		this.cost = cost;
		this.temperature = BASIC_TEMPERATURE;
	}
	
	
	
	public void setHungry(boolean isHungry) {
		this.isHungry = isHungry;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	
	
	public String getSpecies() {
		return species;
	}
	public int getAge() {
		return age;
	}
	public char getGender() {
		return gender;
	}
	public String getPetName() {
		return petName;
	}
	public boolean isHungry() {
		return isHungry;
	}
	public double getTemperature() {
		return temperature;
	}
	public int getHour() {
		return hour;
	}
	public int getCost() {
		return cost;
	}
	
	
}
