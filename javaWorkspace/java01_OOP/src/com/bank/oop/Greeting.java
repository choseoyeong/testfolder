package com.bank.oop;

/*
 * Greeting
 * Ư���� ��󿡰� �λ��� ����ϴ� ����� �ϴ� Ŭ����
 * -> ���� 2��, ��� 1�� �ʿ�
 * 
 * !�߿�! "Ŭ������ �ʵ�(����)�� �޼ҵ�� �����Ǿ� �ִ�"
 * 
 * ::
 * ����(�ʵ�) ����� --> ����Ÿ�� + �����̸�;
 * String who;
 * String greet;
 * 
 * ���(�޼ҵ�) ����
 * sayHello()
 */

public class Greeting {
	// 1. �ʵ� ����
	public String who;
	public String greet;
	
	// 2. �޼ҵ� ����
	public void sayHello() {
		// �ش� �޼ҵ尡 �ϴ� ����� ���� �ۼ�(�ֿܼ� ���)
		// sysoutġ�� ctrl+space�ϸ� �ڵ��ϼ���
		System.out.println(who + ", " + greet);
	}
	
}