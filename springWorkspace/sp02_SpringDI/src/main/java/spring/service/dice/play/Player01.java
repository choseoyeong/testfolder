package spring.service.dice.play;

import spring.service.dice.DiceA;

/*
 *	FileName : Player01.java
 *	ㅇ DiceA 을 가지고(?, has a :: Association Relationship)있는 Player Object Modeling
 *  ㅇDiceA 를 사용 합을 리턴하는 Method 정의  
 */
public class Player01 {
	
	///Field
	// 이렇게 field level에 객체를 만들면 안됨
	// 재사용성이 매우 떨어짐
	// -> interface로 고쳐야 함
	private DiceA diceA = new DiceA();	
	// private DiceB diceB = new DiceB(); ...BAD	
	private int totalValue;
	
	///Constructor Method
	public Player01() {
	}
	
	///Method (getter/setter)
	public DiceA getDiceA() {
		return diceA;
	}
	public void setDiceA(DiceA diceA) {
		this.diceA = diceA;
	}
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	//==> count 만큼 주사위를 굴려서 합을 후하는 행위
	public void playDice(int count){
		
		System.out.println("==>"+getClass().getName()+".playDice() start....");

		for (int i = 0; i < count; i++) {
			diceA.selectedNumber();
			System.out.println("::[ "+diceA.getClass().getName()+" ] 의 선택된수 : "+diceA.getValue());
			totalValue += diceA.getValue(); 
		}
		
		System.out.println("==>"+getClass().getName()+".playDice() end....");
	}

}//end of class