package com.edu.array.test;
/*
 * 배열의 특징
 * 1. Same DataType이 전제이다.
 * 2. 클래스타입이 제공되지 않는다.
 * 3. resizing이 불가능하다. resizing하면 새로운 객체가 생성됨
 * 4. 사이즈가 다른 배열의 내용을 copy할 수 있음
 * 	  -> System.arraycopy()를 사용
 */
public class BasicArrayTest4 {
	public static void main(String[] args) {
		int[] target = {1, 2, 3, 4, 5, 6};	// 6
		int[] source = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};	// 10
		//System.arraycopy()
		for(int i: target) System.out.println(i + " ");	// 8,7,6,5,4,3
		
		System.arraycopy(source, 1, target, 0, 6);
	
		System.out.println("================\n");
		for(int i: target) System.out.println(i + " ");	
	}
}
