package spring.service.test;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.apache.tomcat.jni.Mmap;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;
import spring.service.user.impl.MemberDAOImpl;

public class BusinessLogicLayerTestApp2 {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(
									new String[] {"/bean/memberservice.xml"});
		
		MemberService memberService = (MemberService) context.getBean("memberServiceImpl");
		
		MemberVO memberVO = new MemberVO("id01","1111","¼ÕÈï¹Î","street01");
		MemberVO memberVO2 = new MemberVO("id01","1111","±â¼º¿ë","street01");
		MemberVO memberLogin = new MemberVO("id01","1111",null,null);
		
		// 1. registerMember TEST
//		System.out.println("1. registerMember => " + memberService.registerMember(memberVO)); 
				
									  
		// 2. deleteMember TEST 
//		MemberDAO memberDAO = (MemberDAO) context.getBean("memberDAOImpl");
//		System.out.println("2. deleteMember => " + memberDAO.deleteMember(memberVO2));
							
		
		// 3. updateMember TEST
//		System.out.println("3. updateMember => " + memberService.updateMember(memberVO2));
		
		
		// 4. showAllMember TEST
		List<MemberVO> list = memberService.showAllMember();
		System.out.println("4. showAllMember => ");
		for(MemberVO vo: list) {
			System.out.println(vo);
		}
		  
		// 5. getMember TEST
		System.out.println("5. getMember => " + memberService.getMember("id01"));
		
		// 6. idExist TEST
		System.out.println("6. idExist => " + memberService.idExist("id01"));
		
		// 7. login TEST
		MemberVO vo =  memberService.login(memberLogin);
		System.out.println("7. login => " + vo);
				
	}
}
