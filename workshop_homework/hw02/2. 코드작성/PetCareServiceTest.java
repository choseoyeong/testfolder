package com.edu.test;

import com.edu.service.PetCareService;
import com.edu.vo.Customer;
import com.edu.vo.Pet;

public class PetCareServiceTest {

	public static void main(String[] args) {
		
		Pet[] pets1 = {
				new Pet("강아지", 7, 'M', "영우", 8000),
				new Pet("패럿", 1, 'M', "그라미", 20000),
		};
		
		Pet[] pets2 = {
				new Pet("고양이", 4, 'M', "버디", 7000),
				new Pet("수달", 2, 'F', "디버", 15000),
		};
		
		Pet[] pets3 = {
				new Pet("강아지", 1, 'F', "짱구", 8000),
				new Pet("고양이", 5, 'M', "진", 7000),
				new Pet("토끼", 2, 'N', "예린", 10000),
		};
		
		Customer[] custs = {
				new Customer("정재호", 123, "010-1212-3434"),
				new Customer("조서영", 456, "010-5656-7878"),
				new Customer("김근영", 789, "010-9900-1234"),
		};
		
		custs[0].setPets(pets1);
		custs[1].setPets(pets2);
		custs[2].setPets(pets3);
		
		PetCareService pcs = new PetCareService(custs);
		
		System.out.println("=====1. FindBySSN=====");
		
		Pet[] returnPets = pcs.FindBySsn("김근영", 789);
		for(Pet p: returnPets) {
			System.out.println(p.getPetName());
		}
		
		
		System.out.println("=====2. FindByPhone=====");
		
		returnPets = pcs.FindByPhone("정재호", "010-1212-3434");
		for(Pet p: returnPets) {
			if(p == null) {
				break;
			} else {
				System.out.println(p.getPetName());				
			}
		}
		
		
		System.out.println("=====3. GetPetDetail=====");
		
		System.out.println(pcs.GetPetDetail(custs[1],"버디"));
		
		
		System.out.println("=====4. GetAllPetDetail=====");
		
		String[] returnStr = pcs.GetAllPetDetail(custs[1]);
		
		for(String s : returnStr)
			System.out.println(s);
		
		System.out.println("=====5. GetTotalCost=====");
		
		pets1[0].setHour(10);
		pets1[1].setHour(20);
		System.out.println(pcs.GetTotalCost(custs[0]));
		
		System.out.println("=====6. FindHungryPet=====");

		pets1[0].setHungry(true);
		pets2[1].setHungry(true);
		pets3[2].setHungry(true);
		returnPets = pcs.FindHungryPet();
		
		for(Pet p : returnPets) {
			if(p==null) continue;
			System.out.println(p.getPetName());
		}
		
		
		System.out.println("=====7. FindNeedCarePet=====");
		
		pets1[1].setTemperature(38.4);
		pets2[0].setTemperature(35);
		pets3[2].setTemperature(39);
		returnPets = pcs.FindNeedCarePet(38, 35);
		
		for(Pet p : returnPets) {
			if(p==null) continue;
			System.out.println(p.getPetName());
		}

	}

}
