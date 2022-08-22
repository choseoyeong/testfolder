package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.hello.Greet;
import spring.service.hello.Hello;

public class GreetTestApp04UseSpring {

	/// main method
	public static void main(String[] args) {
		
		//1. BeanFactory(Spring Container(?))�� �̿� xml �� ���������� ����� instance ���� ȹ��
		BeanFactory factory =
				new XmlBeanFactory( new FileSystemResource
				("./src/main/resources/config/greet.xml") );

		//2. Container�� ���� greet1 �� name�� ���� instance return �ޱ�  
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