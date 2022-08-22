package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

public class DiceBImpl implements Dice{
	private int value;

	public DiceBImpl( ) {
		System.out.println("::"+getClass().getName()+" �⺻ ������....");
	}
	
	public DiceBImpl(int value) {
		System.out.println("::"+getClass().getName()+" ����� ������....");
		this.value = value;
	}
	
	
	@Override
	public void selectedNumber() {
		value = new Random().nextInt(6) + 1;
	}

	@Override
	public int getValue() {
		return value;
	}

}
