package com.service.spring.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.MyProduct;

public class MyBatisFrameworkUnitTest {
	public static void main(String[] args) throws Exception {
		//1. ���������� DI Container�� �о�鿩�� �Ѵ�.
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//2. r�� sqlSessionFactory����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3. sqlSession
		SqlSession session = factory.openSession();
		
		System.out.println("==== 1. addProduct ====");
		
		MyProduct vo = new MyProduct("�巳 ��Ź��", "���", 530000);
		int result = session.insert("ns.sql.MyProductMapper.addProduct", vo);
		
		session.commit(); // ���� spring�̶� ���� �ȵƱ� ������ �ʼ�
		System.out.println(result + "�� ��ǰ �߰� ����^^");
	}
}