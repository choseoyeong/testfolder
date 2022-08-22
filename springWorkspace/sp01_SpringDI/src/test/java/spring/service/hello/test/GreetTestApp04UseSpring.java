package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.hello.Greet;
import spring.service.hello.Hello;

public class GreetTestApp04UseSpring {

	/// main method
	public static void main(String[] args) {
		
		//1. BeanFactory(Spring Container(?))을 이용 xml 에 선언적으로 기술된 instance 정보 획득
		BeanFactory factory =
				new XmlBeanFactory( new FileSystemResource
				("./src/main/resources/config/greet.xml") );

		//2. Container로 부터 greet1 의 name을 갖는 instance return 받기  
//		Greet greet = (Greet)factory.getBean("greet1");
//		greet.sayMessage();
		
//		Greet greet = (Greet)factory.getBean("greet2");
//		greet.sayMessage();
		
//		Greet greet = (Greet)factory.getBean("greet3");
//		greet.sayMessage();
		
//		Greet greet = (Greet)factory.getBean("greet4");
//		greet.sayMessage();
		
//		Greet greet5 = (Greet)factory.getBean("greet5");
//		greet5.sayMessage();
		
		Greet greet6 = (Greet)factory.getBean("greet6");
		greet6.sayMessage();
	}
	
}//end of class