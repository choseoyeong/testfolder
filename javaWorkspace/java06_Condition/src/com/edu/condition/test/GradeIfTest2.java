package com.edu.condition.test;

import java.util.Scanner;

/*
 * 실행시점에서 서로 다른 성적이 입력될 수 있도록 코드를 수정..
 * 실행할 때 값을 받으려면 Scanner 객체를 사용해야함
 * (값을 그대로 하드코딩하면 컴파일타임에 값을 받음)
 */
public class GradeIfTest2 {
	public static void main(String[] args) {
//		int grade = 88; 	//Local 변수
		
		System.out.println("성적입력>> ");

		Scanner sc = new Scanner(System.in);	// 키보드로 입력받기
		int grade = sc.nextInt();
		
		System.out.println("과목입력>> ");
		String subject = sc.next();
		
		if(grade<=100 & grade>=90) {		// false
			System.out.println(subject + ", A Grade...");
		} else if(grade<90 & grade>=80) {	// true
			System.out.println(subject + ", B Grade...");
		} else if(grade<80 & grade>=70) {	// false
			System.out.println(subject + ", C Grade...");
		} else {
			System.out.println("Try Again~~!!");
		}
	}

}
