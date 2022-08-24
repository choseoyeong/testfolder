package com.edu.array.test;
import com.edu.array.service.ProductOutletService;
import com.edu.array.vo.Customer;
import com.edu.array.vo.Product;;



public class ProductOutletServiceTest3 {
	public static void main(String[] args) {
		Product[] pros1 = {
				new Product("신라면", 12000, 5, "농심"),
				new Product("새우깡", 1000, 2, "농심"),
				new Product("옥시크린", 32000, 1, "CJ"),
				new Product("삼다수", 800, 10, "제주")
		};
		
		Product[] pros2 = {
				new Product("안성탕면", 22000, 5, "농심"),
				new Product("칭따오", 500000, 50, "따오"),
				new Product("Terra", 2200, 3, "부산은행")
		};
		
		Customer[] custs = {
				new Customer(111, "구자경", "역삼동"),
				new Customer(222, "염미정", "산포시")
		};
		
		// 각각의 고객과 상품들을 Hasing하는 코드 작성
		custs[0].buyProducts(pros2);
		custs[1].buyProducts(pros1);
		
		//
		ProductOutletService service = new ProductOutletService();
		
		// Scanner는 Test에서 쓰고 Service에서 쓰면 안됨
		////// 아래에서는 서비스의 기능을 하나씩 호출합니다. ///////
		
		System.out.println("=========1. 특정 고객이 구입한 상품을 리턴=========");
		for(Product p: service.getProducts(custs[0])) 
			System.out.println(p.getMaker());
		
		
		System.out.println("=========2. 특정 고객이 구입한 상품의 maker들만 리턴..=========");
		for(String s: service.getAllProductMaker(custs[1]))
			System.out.println(s);
		
		
		System.out.println("=========3. 모든 고객들 중에서 특정한 고객을 검색하는 기능=========");
		Customer ssnCust = service.findCustomerBySsn(custs, 111);
		System.out.println(ssnCust.getName());
		
		
		System.out.println("=========4. 특정한 동네에 살고있는 고객들을 검색=========");
		Customer[] addressCust = service.findCustomerByAddress(custs, "산포시");
		for(Customer c: addressCust) {
			if(c == null) break;
			System.out.println(c.getName());
		}
		
		System.out.println("=========5. 특정 고객이 구입한 물건들 중에서 최고가에 해당하는 물건의 가격을 리턴=========");
		System.out.println(service.getMaxPriceProduct(custs[1]));
		
		System.out.println("=========6. 특정 고객이 구입한 물건 중 특정 가격 이상이 되는 제품들을 리턴=========");
		for(Product p: service.getMorePriceProducts(custs[1], 9000)) {
			if(p == null) break;
			System.out.println(p.getMaker());
		}
			
		System.out.println("=========7. 모든 고객이 구입한 물건 중 특정 가격 이상이 되는 제품들을 리턴=========");
		Product[] morePriceProduct = service.getMorePriceProducts(custs, 15000);
		for(Product p: morePriceProduct) {
			if(p == null) break;
			System.out.println(p.getMaker());
		}
		
	}
}
