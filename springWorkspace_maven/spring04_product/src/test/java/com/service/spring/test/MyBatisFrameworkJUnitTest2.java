package com.service.spring.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.MyProduct;

public class MyBatisFrameworkJUnitTest2 {
	
	@Test
	public void unit() throws Exception{
		//1. ���������� DI Container�� �о�鿩�� �Ѵ�.
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//2. r�� sqlSessionFactory����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3. sqlSession
		SqlSession session = factory.openSession();
		
//		System.out.println("==== 1. addProduct ====");
//		
//		MyProduct vo = new MyProduct("������ ��Ź��", "�Ｚ", 380000);
//		int result1 = session.insert("ns.sql.MyProductMapper.addProduct", vo);
//		
//		session.commit(); // ���� spring�̶� ���� �ȵƱ� ������ �ʼ�
//		System.out.println(result1 + "�� ��ǰ �߰� ����^^");
		
		System.out.println("==== 2. findProductByName ====");
		List<MyProduct> result2 = session.selectList("ns.sql.MyProductMapper.findProductByName", "��Ź��");
		System.out.println(result2);
		
		System.out.println("==== 3. findProductByMaker ====");
		List<MyProduct> result3 = session.selectList("ns.sql.MyProductMapper.findProductByMaker", "���");
		System.out.println(result3);
		
		System.out.println("==== 4. findProducts ====");
		List<MyProduct> result4 = session.selectList("ns.sql.MyProductMapper.findProducts");
		System.out.println(result4);
	}
}