package com.service.mybatis.client;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

import util.FactoryService;

public class MySawonAppTest03 {

	public static void main(String[] args) throws Exception{
		SqlSessionFactory factory = FactoryService.getFactory();
		
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












