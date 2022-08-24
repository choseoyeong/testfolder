package com.edu.array.test;
import com.edu.array.service.ProductService;
// Product
import com.edu.array.vo.Product;

public class ProductServiceTest2 {
	public static void main(String[] args) {
		Product[] pros = {
				new Product("신라면", 12000, 5, "농심"),
				new Product("새우깡", 1000, 2, "농심"),
				new Product("옥시크린", 32000, 1, "CJ"),
				new Product("삼다수", 800, 10, "제주")
		};
		
		// 객체 생성 
//		ProductService service = new ProductService(pros);
		ProductService service = new ProductService();
		
		// service라는 참조변수를 이용해서 구현한 기능을 하나씩 호출합니다...
		// 이렇게 인자로 보내는 것으로도 Hasing 관계를 구현할 수 있음
		System.out.println("\n======모든 상품의 Maker를 출력합니다.======");
		service.printAllMaker(pros);
			
		/*
		 * Method Overloading
		 * ::
		 * 하는 일은 같지만
		 * 처리하는 데이터를 달리할 때 사용하는 기법
		 * 
		 * ::
		 * 1. 메소드 이름은 같아야 한다.
		 * 2. 매개변수는 반드시 달라야 한다(순서, 갯수, 타입)
		 * 3. 리턴타입은 상관없다(같을수도, 다를수도).
		 *
		 * ::
		 * public Member[] searchMember(String name)
		 * public Member[] searchMember(String address)		// overloading 아님
		 * public Member[] searchMember(String address, String name)
		 * public Member[] searchMember(int age)
		 * 
		 * :: overloading 사용하지 않고도 통일성+의미를 모두 표현한 좋은 경우
		 * public Member[] searchMemberByName(String name)
		 * public Member[] searchMemberByAge(int age)
		 * 
		 * :: overloading 사용하지 않은 경우
		 * public Member[] searchMemberName()
		 * public Member[] getNameByAddress()
		 */
		System.out.println("\n======상품들의 총 금액을 출력합니다.======");
		int total = service.getTotalPrice(pros);
		System.out.println("총 금액: " + total);
		
		System.out.println("\n======" + 10000 + "원 이상의 상품들을 출력합니다.======");
		Product[] returnPros = service.printMoreExpensive(pros, 10000);
		for(Product p: returnPros) {
			if(p == null) break;	
			System.out.println(p.getMaker() + ", " + p.getPrice());
		}
			
		System.out.println("\n======동일한 회사의 제품들을 출력합니다.======");
		Product[] returnPros1 = service.getSameCompany(pros, "농심");
		for(Product p: returnPros1) {
			if(p==null) break;
			System.out.println(p.getMaker() + ", " + p.getCompany());
		}
		
		System.out.println("\n======구입한 상품들의 평균가를 출력합니다.======");
		int average = service.getAveragePrice(pros);
		System.out.println("평균가: " + average);
		
	}
}
