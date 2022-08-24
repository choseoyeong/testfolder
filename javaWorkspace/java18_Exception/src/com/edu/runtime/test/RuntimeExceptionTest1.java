package com.edu.runtime.test;

public class RuntimeExceptionTest1 {

	public static void main(String[] args) {
		String[] str = {
				"Hello",
				"No, I mean it",
				"Nice to meet you"
		};
		
		int i=0; 
		while(i<=3) {
			try {
				System.out.println(str[i]);		// Exception은 줄단위로 실행되다가 발생함
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Nice Catch~~");
			}
			
			i++;
		}//
		System.out.println("while loop end...");
	}//main

}//class
