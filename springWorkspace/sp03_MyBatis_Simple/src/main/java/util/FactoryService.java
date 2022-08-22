package util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// SqlSessionFactory���� �޾ƿ��� ������ ���⼭ �ۼ�...
public class FactoryService {
	private static SqlSessionFactory factory;
	static {
		try {
			//1. �ٽ��� �Ǵ� ���������� �о���δ�.
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			//2. SqlSessionFactory
			factory = new SqlSessionFactoryBuilder().build(r);
		} catch (IOException e) {
			System.out.println(e);
		}			
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}