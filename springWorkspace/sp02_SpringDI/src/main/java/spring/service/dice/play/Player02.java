package spring.service.dice.play;

import spring.service.dice.Dice;

/*
 *	FileName : Player02.java
 *	��Player01������ DiceA�� ���� ������ �ִ� ���迴�ٸ�(Tight�� Coupling ����)
 *	�� DiceB, DiceC�� �߰��Ҷ����� Player01���� �����ؾ� �ϴ� �ڵ尡 ���ϱ޼������� �þ�� ���뼺�� ġ���� ��� �߱�
 *  �� �ذ�å���� Dice��� interface�� �߰�
 *  �� Player02�� Dice�� ������ ���踦 �ۼ�..  
 *  
 *  Dice�� �ƹ��� �þ�� �� �ڵ�� �ٲ� �ʿ䰡 ����
 */
public class Player02 {
	
	///Field
	private Dice dice;		// interface�� hasing �ϵ���	
	private int totalValue;
	
	///Constructor Method
	public Player02() {
	}
	
	public Player02(Dice dice) {
		this.dice = dice;
	}
	
	///Method (getter/setter)
	public Dice getDice() {
		return dice;
	}
	public void setDice(Dice dice) {
		this.dice = dice;
	}
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	//==> count ��ŭ �ֻ����� ������ ���� ���ϴ� ����
	public void playDice(int count){
		
		System.out.println("==>"+getClass().getName()+".playDice() start....");

		for (int i = 0; i < count; i++) {
			dice.selectedNumber();
			System.out.println("::[ "+dice.getClass().getName()+" ] �� ���õȼ� : "+dice.getValue());
			totalValue += dice.getValue(); 
		}
		
		System.out.println("==>"+getClass().getName()+".playDice() end....");
	}

}//end of class