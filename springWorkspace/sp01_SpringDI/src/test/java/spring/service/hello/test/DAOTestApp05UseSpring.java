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
		
		//1. BeanFactory(Spring Container(?))�� �̿� xml �� ���������� ����� instance ���� ȹ��
		BeanFactory factory =
				new XmlBeanFactory( new FileSystemResource
				("./src/main/resources/config/dao.xml") );
		
		//2. ���� ���ͼ�
		// Impl�� return �޴� �� �ƴ�
		MemberDAO member = (MemberDAO) factory.getBean("dao");
		
		//3. ����Ͻ������� ȣ��..���� ���⼭ ����..
		member.register("KDB", "1234");
		
		// ���������� �׸�..mm���� ����
	}
	
}//end of class