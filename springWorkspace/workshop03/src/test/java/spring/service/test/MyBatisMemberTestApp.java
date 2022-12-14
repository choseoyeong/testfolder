package spring.service.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jni.Mmap;

import spring.service.domain.MemberVO;
import spring.service.user.impl.MemberDAOImpl;

public class MyBatisMemberTestApp {
	public static void main(String[] args) throws Exception {
		// SqlSession ????
		SqlSession session = null;
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session = factory.openSession();
		
		
		MemberVO memberVO = new MemberVO("id01","1111","??????","street01");
		MemberVO memberVO2 = new MemberVO("id01","1111","?⼺??","street01");
		MemberVO memberLogin = new MemberVO("id01","1111",null,null);
		
		// 1. registerMember TEST
//		System.out.println("1. registerMember => " 
//							+ session.insert("MemberMapper.registerMember",memberVO));
//							  session.commit();

						  
		// 2. deleteMember TEST
//		System.out.println("2. deleteMember => "
//							+ session.delete("MemberMapper.deleteMember", memberVO2));
//							  session.commit();
		
		
		// 3. updateMember TEST
//		System.out.println("3. updateMember => "
//							+ session.delete("MemberMapper.updateMember", memberVO2));
//				  			  session.commit();

		
		// 4. showAllMember TEST
		List<MemberVO> list = session.selectList("MemberMapper.showAllMember");
		System.out.println("4. showAllMember => ");
		for(MemberVO vo: list) {
			System.out.println(vo);
		}
		 
		
		// 5. getMember TEST
		System.out.println("5. getMember => "
							+ session.selectOne("MemberMapper.getMember", "id01"));
		
		// 6. idExist TEST
		System.out.println("6. idExist => " 
							+ session.selectOne("MemberMapper.idExist", "id01"));
		
		// 7. login TEST
		MemberVO vo =  session.selectOne("MemberMapper.login", memberLogin);
		System.out.println("7. login => " + vo);
	}
}
