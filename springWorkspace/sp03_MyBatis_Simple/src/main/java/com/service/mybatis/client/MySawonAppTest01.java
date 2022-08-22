package com.service.mybatis.client;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonAppTest01 {

	public static void main(String[] args) throws Exception{
		//1. 폼으로부터 받은 값을 가지고 VO 생성..
		MySawon vo = new MySawon();
		vo.setId("aaa");
		vo.setPwd("777");
		vo.setName("아이유");
		vo.setAge(28);
		
		//2. 지금부터..핵심이 되는 설정문서를 읽어들인다.
		Reader r= Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//3. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//4. SqlSession
		SqlSession session = factory.openSession();
		
		//5. session안에 쿼리문 실행하는 기능이 들어있다(executeUpdate(), executeQuery()) 
		// 이제는 insert(), delete(), update(), selectOne(), selectList() 사용
		// vo가 INSERT의 parameterType 값으로 입력됨
		session.insert("sawonMapper.sawonAdd", vo);
		session.commit();		// 필수
		session.close();
		
		System.out.println(vo.getName() + "님이 등록 되셨습니다.");
	}

}













