package com.edu.runtime.test;
/*
 * Catch는 여러번 가능하다.
 * 여러개의 catch구문을 작성하더라도 단 하나의 catch 구문만 실행된다.
 * 
 */
public class RuntimeExceptionTest3 {

	public static void main(String[] args) {
		String[] str = {
				"Hello",
				"No, I mean it",
				"Nice to meet you"
		};
		
		int i=0; 
		while(i<=3) {
//			try {
//				System.out.println(str[i]);		
//			} catch(Exception e) {
//				System.out.println("Nice Catch1~~");
//			} catch(ArrayIndexOutOfBoundsException e) {
//				System.out.println("Nice Catch2~~");
//			}
			
			try {
				// 예외 발생 가능 코드
				System.out.println(str[i]);		
			} catch(ArrayIndexOutOfBoundsException e) {
				// 예외 잡았을 때 코드
				System.out.println("Nice Catch1~~");
			} catch(Exception e) {
				System.out.println("Nice Catch2~~");
			} finally {
				// 예외와 상관없이 무조건 실행해야 하는 코드
				System.out.println("Always~~");
			}
			
			i++;
		}//
		System.out.println("while loop end...");
	}//main

}//class
