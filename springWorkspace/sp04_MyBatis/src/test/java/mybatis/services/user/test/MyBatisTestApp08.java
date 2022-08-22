package mybatis.services.user.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.services.domain.User;

/*
 * FileName : MyBatisTestApp08.java
  * �� SqlMapConfig01.xml / mybatis-userservice-mapping08.xml
  * �� MyBATIS Framework �̿� Dynamic query ( SELECT ) TEST | sql������ Moduleȭ
  * �� TestUtil.java �� �̿� Test . 
  * 
  * �� ������ MyBatisTestApp101.java : MyBatis Framework ���� �׽�Ʈ
  */
public class MyBatisTestApp08 {
	///Main method
	public static void main(String[] args) throws Exception{
		SqlSession session = null;
		//==> TestUtil �� getSqlSessionFactory()�� �̿� SqlSessionFactory instance GET
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session=factory.openSession();
		
		//==> Test �� User instance ����  
		User user = new User("userMapper01","ȫ�浿","user01",new Integer(30),1);
	
		//1. UserMapper08.getUserList01 Test 
		System.out.println(":: 1. getUserList01(SELECT)  ? ");
		TestUtil.printList( (List)session.selectList("UserMapper08.getUserList01",user) );
		
		//2. UserMapper08.getUserList01 Test 
		System.out.println(":: 2. getUserList01(SELECT)  ? ");
		user.setUserName(null);
		TestUtil.printList( (List)session.selectList("UserMapper08.getUserList01",user) );
		
		//3. UserMapper08.getUserList01 Test 
		System.out.println(":: 3. getUserList01(SELECT)  ? ");
		user.setUserName("ȫ�浿");
		user.setAge(null);
		TestUtil.printList( (List)session.selectList("UserMapper08.getUserList01",user));
	
		//4. UserMapper08.getUserList01 Test 
		System.out.println(":: 4. getUserList01(SELECT)  ? ");
		user.setUserName(null);
		user.setAge(null);
		TestUtil.printList( (List)session.selectList("UserMapper08.getUserList01",user) );
		
	}//end of main
}//end of class