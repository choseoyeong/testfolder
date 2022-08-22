package workshop01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.broker.BrokerDatabase;
import spring.service.domain.Customer;
import spring.service.domain.Stock;

public class BrokerDISpringTest {

	public static void main(String[] args) {
		ApplicationContext factory 
			= new ClassPathXmlApplicationContext("./config/brokerservice.xml");
		
		System.out.println("\n=====================================================");
		Customer customer1 = (Customer) factory.getBean("customer1");
		System.out.println(customer1);
		
		System.out.println("\n=====================================================");
		Customer customer2 = (Customer) factory.getBean("customer2");
		System.out.println(customer2);
		
		System.out.println("\n=====================================================");
		Stock stock1 = (Stock) factory.getBean("stock1");
		System.out.println(stock1);
		
		System.out.println("\n=====================================================");
		Stock stock2 = (Stock) factory.getBean("stock2");
		System.out.println(stock2);
		
		System.out.println("\n=====================================================");
		BrokerDatabase brokerDB = (BrokerDatabase) factory.getBean("brokerdb");
		brokerDB.registerCustomer(customer1);
		brokerDB.registerCustomer(customer2);
		brokerDB.registerStock(stock1);
		brokerDB.registerStock(stock2);
	}

}
