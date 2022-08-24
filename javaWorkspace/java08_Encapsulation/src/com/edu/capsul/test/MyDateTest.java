package com.edu.capsul.test;
import java.util.Scanner;
/*
 * month, day값을 Scanner로 받는다.
 * 
 * 오늘은 0월 0일입니다. -> 이렇게 나오면 안됨
 */
import com.edu.capsul.MyDate;

public class MyDateTest {

	public static void main(String[] args) {
		MyDate md = new MyDate();
		System.out.println(md);
		// invalid한 값. 
		//이러면 안되니까 필드에 직접적으로 접근 못하게 해야함 => Encapsulation
//		md.month = 30;
//		md.day = 100;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("월 입력: ");
		int m = sc.nextInt();
		md.setMonth(m);
		
		System.out.println("일 입력: ");
		int d = sc.nextInt();
		md.setDay(d);

//		if(md.getMonth()!=0 || md.getDay()!=0) // 이것도 가능		
		if(md.getValid() == 2)
			System.out.println("오늘은 " + md.getMonth() + "월 " + md.getDay() + "일 입니다.");
		
		sc.close();
	}

}
