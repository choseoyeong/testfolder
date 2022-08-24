package com.edu.user.test;

import java.util.Scanner;

// 내가 만든 폭탄
class UnderAgeBoom extends Exception{
	UnderAgeBoom() {
//		super();		// 생략되어 있는 것
		this("This is UnderAgeBoom Exception...");
	}
	UnderAgeBoom(String message) {
		super(message);
	}
}

class AdultMovieService {	// 성인영화 관람서비스..
	public void entrance(int age) throws UnderAgeBoom {
		if(age >= 19) System.out.println("Ticketing OK...Enter!!");
//		else throw new UnderAgeBoom();
		else throw new UnderAgeBoom("미성년자 입니다.");			// 고의적으로 내가 터트림
	}
}

public class UserExceptionTest {
	public static void main(String[] args) {
		AdultMovieService service = new AdultMovieService();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("나이 입력 >> ");
		int age = sc.nextInt();
		try {
			service.entrance(age);
		} catch(UnderAgeBoom e) {
//			System.out.println(e.getMessage());	
			System.out.println("나이 더 먹고 오삼..");
		} finally {
			System.out.println("오후 10시가 되어서 극장문을 닫습니다.");
		}
		System.out.println("Exit...");
		
	}

}
