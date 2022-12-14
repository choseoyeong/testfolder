package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.dao.MemberDAO;
import spring.service.dao.impl.MemberDAOImpl;
import spring.service.hello.Greet;
import spring.service.hello.Hello;

public class DAOTestApp05UseSpring {

	/// main method
	public static void main(String[] args) {
		
		//1. BeanFactory(Spring Container(?))을 이용 xml 에 선언적으로 기술된 instance 정보 획득
		BeanFactory factory =
				new XmlBeanFactory( new FileSystemResource
				("./src/main/resources/config/dao.xml") );
		
		//2. 빈을 얻어와서
		// Impl로 return 받는 것 아님
		MemberDAO member = (MemberDAO) factory.getBean("dao");
		
		//3. 비즈니스로직을 호출..값은 여기서 주입..
		member.register("KDB", "1234");
		
		// 마지막으로 그림..mm으로 제출
	}
	
}//end of class