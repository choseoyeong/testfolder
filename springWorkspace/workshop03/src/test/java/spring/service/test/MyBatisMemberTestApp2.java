package spring.service.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jni.Mmap;

import spring.service.domain.MemberVO;
import spring.service.user.impl.MemberDAOImpl;

public class MyBatisMemberTestApp2 {
	public static void main(String[] args) throws Exception {
		// SqlSession »ý¼º
		SqlSession session = null;
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session = factory.openSession();
		
		MemberDAOImpl dao = new MemberDAOImpl();
		dao.setSqlSession(session);
		
		MemberVO memberVO = new MemberVO("id01","1111","¼ÕÈï¹Î","street01");
		MemberVO memberVO2 = new MemberVO("id01","1111","±â¼º¿ë","street01");
		MemberVO memberLogin = new MemberVO("id01","1111",null,null);
		
		// 1. registerMember TEST
		//System.out.println("1. registerMember => " + dao.registerMember(memberVO)); 
				
									  
		// 2. deleteMember TEST
		//System.out.println("2. deleteMember => " + dao.deleteMember(memberVO2));
							
		
		// 3. updateMember TEST
		//System.out.println("3. updateMember => " + dao.updateMember(memberVO2));
		
		
		// 4. showAllMember TEST
		List<MemberVO> list = dao.showAllMember();
		System.out.println("4. showAllMember => ");
		for(MemberVO vo: list) {
			System.out.println(vo);
		}
		  
		// 5. getMember TEST
		System.out.println("5. getMember => " + dao.getMember("id01"));
		
		// 6. idExist TEST
		System.out.println("6. idExist => " + dao.idExist("id01"));
		
		// 7. login TEST
		MemberVO vo =  dao.login(memberLogin);
		System.out.println("7. login => " + vo);
				
	}
}
