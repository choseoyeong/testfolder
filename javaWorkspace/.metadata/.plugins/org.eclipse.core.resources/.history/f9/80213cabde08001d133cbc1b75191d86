package com.edu.self.test;

import com.edu.self.service.EmployeeService;
import com.edu.self.util.MyDate;
import com.edu.self.vo.Engineer;
import com.edu.self.vo.Manager;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		//1. Service ��ü�� ����
		EmployeeService service = new EmployeeService(5);
		
		//2. method�� ���� ȣ��..
		System.out.println("============ 1. addManager ============ ");
		service.addManager(new Manager("�̼���", new MyDate(1978, 1, 1), 20000.0, "���ߺ�", 10));
		service.addManager(new Manager("��ȣ��", new MyDate(1975, 2, 1), 34000.0, "��ȹ��", 20));
		service.addManager(new Manager("���ϴ�", new MyDate(1980, 3, 3), 20000.0, "������", 30));
		service.addManager(new Manager("�˼���", new MyDate(1995, 8, 1), 37000.0, "���ߺ�", 10));
		
		System.out.println("============ Manager ����Ȯ�� ============ ");
		service.printManagers();
		
		System.out.println("\n============ 1. addEngineer ============ ");
		service.addEngineer(new Engineer("������", new MyDate(1995,3,4), 350000.0, "Java", 200.0));
		service.addEngineer(new Engineer("��ä��", new MyDate(1995,7,2), 350000.0, "Java", 200.0));
		service.addEngineer(new Engineer("������", new MyDate(1994,11,2), 450000.0, "Python", 300.0));
		
		System.out.println("============ Engineer ����Ȯ�� ============ ");
		service.printEngineers();
		
		System.out.println("\n============ 2. deleteManager(��ȣ�� ����) ============ ");
		service.deleteManager("��ȣ��");
		System.out.println("============ Manager ����Ȯ�� ============ ");
		service.printManagers();
		
		System.out.println("\n============ 3. updateManager(���ϴ� ���� ���� 200->350) ============ ");
		service.updateManager(35000.0, "������", 30,  "���ϴ�");//?
		System.out.println("============ Manager ����Ȯ�� ============ ");
		service.printManagers();
		/*
		System.out.println("\n============ 4. findManager(�̼���) ============ ");
		Manager retM1=service.findManager("�̼���");
		System.out.println(retM1.getDetails());
		
		System.out.println("\n============ 4. findManager(10) ============ ");
		System.out.println("10�� �μ��� �ٹ��ϴ� ������ �Դϴ�..");
		Manager[ ] retMs1 = service.findManager(10);
		for(Manager m : retMs1) {
			if(m==null) continue;
			System.out.println(m.getDetails());
		}*/
	}
}







