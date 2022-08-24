package com.edu.collection.test;

import java.util.HashSet;
import java.util.Set;

/*
 * 		Set
 * 		 |
 * 	  HashSet
 * 
 * 	Unique한 것들만 저장함
 *  순서는 없다
 */
public class HashSetTest2 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();	// == new HashSet<String>();
		set.add("구자경");
		set.add("염미정");
		set.add("강호동");
		set.add("염창희");
		set.add("염미정");
		
		System.out.println(set.size());
		// Collection은 자체적으로 toString() 메소드를 Overriding 해놓았다...멤버 출력
		System.out.println(set.toString()); // == System.out.println(set)
		System.out.println("이수근이 포함되었는가? " + set.contains("이수근"));
		
		// 리턴타입이 boolean이면 삭제 여부 확인 가능
		System.out.println("삭제진행: " + set.remove("강호동") + " !!");
		System.out.println(set);
		
		set.clear();
		System.out.println("Set안이 다 비워졌나요? " + set.isEmpty());
		
	}

}
