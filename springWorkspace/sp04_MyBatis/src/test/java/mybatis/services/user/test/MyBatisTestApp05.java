package mybatis.services.user.test;


import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.services.domain.User;

/*
 * FileName : MyBatisTestApp05.java
  * �� SqlMapConfig01.xml / mybatis-userservice-mapping05.xml
  * �� My Framework �̿� QUERY ( SELECT ) TEST 
  */
public class MyBatisTestApp05 {
	///Main method
	public static void main(String[] args) throws Exception{
		
		///==> SqlMapConfig.xml : MyBATIS Framework �� �ٽ� ȯ�漳��ȭ�� (MetaData)
		//==> mybatis-userservice-mapping.xml : SQL �� ���� ����ȭ�� (MetaData) 
		
		//==> 1. xml metadata �д� Stream ����
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig01.xml");
		//==> 2. Reader ��ü�� �̿� xml metadata �� ������ ���� ������ ����, ��밡���� 
		//==>   SqlSession  ��ü ����
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		
		//==> Test �� User instance ���� �� age / regData null setting
		//==>@@@ null���� ����ҷ��� SqlMapConfig01.xml�� Settings �±׸� �����ؾ��Ѵ�.@@@
		User user = new User("user04","�ָ�","user04",null,1);
		user.setRegDate(null);
		
	
		//1. User05.addUser Test  :: users table age/grade/redDate �Է°� Ȯ���Ұ� : OK 
		System.out.println(":: 1. addUser(INSERT)  ? "
												+ session.insert("UserMapper05.addUser",user)); //1.
		session.commit();
		
		System.out.println("\n");
		
		//2. User05.addUser Test :: users table age/grade/redDate �Է°� Ȯ���Ұ� : OK
		user.setUserId("user05");
		System.out.println(":: 2. addUser(INSERT)  ? "
										+ session.insert("UserMapper05.addUser",user));//1
		session.commit();
		System.out.println("\n");
		
		//3. User05.uadateUser Test  :: users table age/redDate �Է°� Ȯ���Ұ� : OK
		//                                                    :: �ָ� ==> �´� ����
		user.setUserName("�´�");
		System.out.println(":: 3. update(UPDATE)  ? "
													+ session.update("UserMapper05.updateUser",user));//1
		session.commit();
	}//end of main
}//end of class








