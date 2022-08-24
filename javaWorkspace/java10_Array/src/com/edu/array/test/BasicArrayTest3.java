package com.edu.array.test;
/*
 * 배열의 특징
 * 1. Same DataType이 전제이다.
 * 2. 클래스타입이 제공되지 않는다.
 * 3. resizing이 불가능하다. resizing하면 새로운 객체가 생성됨
 */
public class BasicArrayTest3 {
	public static void main(String[] args) {
		int[] target = {1, 2, 3, 4, 5, 6};
		System.out.println("\n============Before Resizing==============\n");
		for(int i: target) System.out.println(i + " ");
		
		System.out.println("\n============After Resizing==============\n");
		target = new int[10];		//4칸이 늘어나는게 아니라 새로운 10칸이 생김
		target[6] = 7;
		target[7] = 8;
		target[8] = 9;
		target[9] = 10;
		for(int i: target) System.out.println(i + " ");
	}

}
