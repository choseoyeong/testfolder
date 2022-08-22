package com.service.mybatis.client;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonAppTest01 {

	public static void main(String[] args) throws Exception{
		//1. �����κ��� ���� ���� ������ VO ����..
		MySawon vo = new MySawon();
		vo.setId("aaa");
		vo.setPwd("777");
		vo.setName("������");
		vo.setAge(28);
		
		//2. ���ݺ���..�ٽ��� �Ǵ� ���������� �о���δ�.
		Reader r= Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//3. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//4. SqlSession
		SqlSession session = factory.openSession();
		
		//5. session�ȿ� ������ �����ϴ� ����� ����ִ�(executeUpdate(), executeQuery()) 
		// ������ insert(), delete(), update(), selectOne(), selectList() ���
		// vo�� INSERT�� parameterType ������ �Էµ�
		session.insert("sawonMapper.sawonAdd", vo);
		session.commit();		// �ʼ�
		session.close();
		
		System.out.println(vo.getName() + "���� ��� �Ǽ̽��ϴ�.");
	}

}












