// AppTest�� Test�� ���� Ŭ������ ������ main�� �����ϱ�
package com.bank.oop.test;
/*
 * 				OOP
 * 
 * 		Object Oriented Class	|	~~ Test
 * 
 * 		��ü�� �ǹ��ϴ� Ŭ����			��ü�� �ƴ�
 * 									���� Object Class�� ���� ��ü�� ������ִ� ���� Ŭ����(���� ����ִ� �뵵)
 * 
 */

import com.bank.oop.Greeting;				// Greeting class�� ��ġ�� �˷��ִ� �뵵

public class GreetingAppTest {

	public static void main(String[] args) { // main method(=���� �޼ҵ�)
		// ��ü ���� == �޸�(JVM)�� Ŭ������ ���(�ʵ�, �޼ҵ�)���� �� �ø���. == ����� ����
		Greeting hello = new Greeting();
		
		/*
		 * [����]
		 * �ʵ� --> �� �Ҵ�
		 * �޼ҵ� --> �޼ҵ带 ȣ��
		 */
		
		hello.who = "�����ο�~~";
		hello.greet = "������ �ð��Դϴ�~~~�������̾��";
		
		hello.sayHello();
		
	}

}
