package spring.service.dice.test;

import spring.service.dice.impl.DiceAImpl;
import spring.service.dice.impl.DiceBImpl;
import spring.service.dice.impl.DiceCImpl;
import spring.service.dice.play.Player02;

/*
 * FileName : DiceTestApp02.java
 * �� DiceA / Player02 Test �ϴ� Application 
 */
public class DiceTestApp02 {
	///Main Method
	public static void main(String[] args){
		
		Player02 player01 = new Player02(new DiceAImpl());
		player01.playDice(3);
		System.out.println("=======================");
		System.out.println("���õ� �ֻ��� ���� ������ : "+player01.getTotalValue());
		System.out.println("=======================");
		
		Player02 player02 = new Player02();
		player02.setDice(new DiceBImpl());
		player02.playDice(3);
		System.out.println("=======================");
		System.out.println("���õ� �ֻ��� ���� ������ : "+player02.getTotalValue());
		System.out.println("=======================");
		
		Player02 player03 = new Player02(new DiceCImpl());
		player03.playDice(3);
		System.out.println("=======================");
		System.out.println("���õ� �ֻ��� ���� ������ : "+player03.getTotalValue());
		System.out.println("=======================");
		
		Player02 player04 = new Player02(new DiceCImpl());
		player04.playDice(3);
		System.out.println("=======================");
		System.out.println("���õ� �ֻ��� ���� ������ : "+player04.getTotalValue());
		System.out.println("=======================");
		
	}
}//end of class
