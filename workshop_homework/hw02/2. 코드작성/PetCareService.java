package com.edu.service;

import com.edu.vo.Customer;
import com.edu.vo.Pet;

public class PetCareService {
	
	private Customer[] customers;
	
	
	
	
	public PetCareService(Customer[] customers) {
		super();
		this.customers = customers;
	}

	public Pet[] getPets(Customer cust) {
		return cust.getPets();
	}
	
	public Pet[] FindBySsn(String customerName, int ssn) {
		int len = 0;
		for (Customer c: customers) {
			if(len < c.getPets().length) {
				len = c.getPets().length;
			}
		}
		Pet[] temp = new Pet[len];
		
		int idx = 0;
		for(Customer c: customers) {
			if(c.getCustomerName().equals(customerName) && c.getSsn()==ssn) {
				for(Pet p: c.getPets()) {
					temp[idx++] = p;
				}
				break;
			}
		}
		return temp;
	}
	
	public Pet[] FindByPhone(String customerName, String phone) {
		int len = 0;
		for (Customer c: customers) {
			if(len < c.getPets().length) {
				len = c.getPets().length;
			}
		}
		Pet[] temp = new Pet[len];
				
		int idx = 0;
		for(Customer c: customers) {
			if(c.getCustomerName().equals(customerName) && c.getPhone().equals(phone)) {
				for(Pet p: c.getPets()) {
					temp[idx++] = p;
				}
				break;
			}
		}
		return temp;
	}
	
	public String GetPetDetail(Customer cust, String petName) {
		String temp = null;
		
		Pet[] pets = cust.getPets();
		
		for(Pet p: pets) {
			if(p.getPetName().equals(petName)) {
				temp = p.getPetName()+"의 종족은 "+p.getSpecies()+"이고, 나이는 "+p.getAge()+"이며, 성별은 "+p.getGender()+"입니다.";
				break;
			}
		}
		
		
		return temp;
	}
	
	public String[] GetAllPetDetail(Customer cust) {
		int len = cust.getPets().length;
		
		String[] temp = new String[len];
		Pet[] pets = cust.getPets();
		int idx = 0;
				
		for(Pet p: pets) {
			temp[idx++] = p.getPetName()+"의 종족은 "+p.getSpecies()+"이고, 나이는 "+p.getAge()+"이며, 성별은 "+p.getGender()+"입니다.";
		}
		return temp;
	}
	
	public int GetTotalCost(Customer cust) {
		int totalCost = 0;
		
		Pet[] pets = cust.getPets();
				
		for(Pet p: pets) {
			totalCost += p.getCost() * p.getHour();
		}
		
		return totalCost;
	}
	
	public Pet[] FindHungryPet() {
		int len = 0;
		for(Customer c: customers) {
			len += c.getPets().length;
		}
		
		Pet[] temp = new Pet[len];
		
		int idx = 0;
		for(Customer c: customers) {
			for(Pet p: c.getPets()) {
				if(p.isHungry()) {
					temp[idx++] = p;
				}
			}
		}
		
		return temp;
	}
	
	public Pet[] FindNeedCarePet(double maxTemperature, double minTemperature) {
		int len = 0;
		for(Customer c: customers) {
			len += c.getPets().length;
		}
		
		Pet[] temp = new Pet[len];
		
		int idx = 0;
		for(Customer c: customers) {
			for(Pet p: c.getPets()) {
				if(p.getTemperature()>=maxTemperature || p.getTemperature()<=minTemperature) {
					temp[idx++] = p;
				}
				else {
					continue;
				}
			}
		}
		
		return temp;
	}
	
}
