package com.edu.condition.test;

import java.util.Scanner;

public class GradeSwitchTest4 {
	public static void main(String[] args) {
	
		System.out.println("성적입력>> ");

		Scanner sc = new Scanner(System.in);	
		int grade = sc.nextInt();
		
		// break 하나도 안쓰면 95 입력했을 때 A, B, C, Try Again 다 뜸 => 이런걸 fall through(구멍으로 떨어지다)라고 함
		switch(grade) {
			case 95:
			case 90:
				System.out.println("A Grade...");
//				break;
			case 85:
			case 80:
				System.out.println("B Grade...");
//				break;
			case 75:
			case 70:
				System.out.println("C Grade...");
//				break;
			default:
				System.out.println("Try Again!!");
		}
	}

}
