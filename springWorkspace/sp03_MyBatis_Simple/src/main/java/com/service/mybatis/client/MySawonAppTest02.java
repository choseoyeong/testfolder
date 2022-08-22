package com.service.mybatis.client;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonAppTest02 {

	public static void main(String[] args) throws Exception{
		//1. �ٽ��� �Ǵ� ���������� �о���δ�.
		Reader r= Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//2. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3. SqlSession
		SqlSession session = factory.openSession();
		
		//4. session�ȿ� ������ �����ϴ� ����� ����ִ�(executeUpdate(), executeQuery()) 
		List<MySawon> list = session.selectList("sawonMapper.sawonList");
		for(MySawon vo: list) {
			System.out.println(vo);
		}
		
		System.out.println();
	}

}












