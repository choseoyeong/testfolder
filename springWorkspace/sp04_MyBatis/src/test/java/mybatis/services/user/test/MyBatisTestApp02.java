package mybatis.services.user.test;


import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.services.domain.User;

/*
 * FileName : MyBatisTestApp02.java
  * �� SqlMapConfig01.xml / mybatis-userservice-mapping02.xml
  * �� My Framework �̿� QUERY ( SELECT ) TEST 
  */
public class 	MyBatisTestApp02 {
	///Main method
	public static void main(String[] args) throws Exception{
		
		///==> SqlMapConfig01.xml : MyBATIS Framework �� �ٽ� ȯ�漳��ȭ�� (MetaData)
		//==> mybatis-userservice-mapping02.xml : SQL �� ���� ����ȭ�� (MetaData) 
				
		
		//==> 1. xml metadata �д� Stream ����
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig01.xml");
		
		//==> 2. Reader ��ü�� �̿� xml metadata �� ������ ���� ������ ����, ��밡���� 
		//==>     SqlMapClient  ��ü ����
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session=factory.openSession();
		
		//0. getUser :: # �����ڸ� �̿��� like ������ �˻� ==> �˻���� ���°� Ȯ��
		System.out.println(":: 0. user�� �����ϴ� userId User(SELECT)  ? ");
		List<User> list = session.selectList("UserMapper02.getUser01","user");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> ��° ȸ��.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//1. getUser :: # �����ڸ� �̿��� like ������ �˻� 
		// ==> �˻���� ���� Ȯ�� :: %���ϵ�ī�� �����Է°�� 
		System.out.println(":: 1. user�ν����ϴ� userId User(SELECT)  ? ");
		list = session.selectList("UserMapper02.getUser01","user%");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> ��° ȸ��.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		
		//2.  getUser :: # �����ڸ� �̿��� like ������ �˻� ==> �˻���� ���°� Ȯ��..userId�� 01�� ���
		User user = new User();
		user.setUserId("01");
		
		System.out.println(":: 2. 01�� ������ userId User(SELECT)  ? ");
		 list = session.selectList("UserMapper02.getUser02", user);
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> ��° ȸ��.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		
		//3. getUser :: # �����ڸ� �̿���  like ������ �˻� 
		//				==> �˻���� ���� Ȯ�� :: %���ϵ�ī�� �����Է°��
		user.setUserId("%01");
		System.out.println(":: 3. 01�� ������ userId User(SELECT)  ? ");
		list = session.selectList("UserMapper02.getUser02",user);
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> ��° ȸ��.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		
		//4. getUser :: % ���ϵ�ī�带 �̿��� like ������ �˻�==> �˻���� ���� Ȯ�� 
		System.out.println(":: 4. user�ν����ϴ� userId User(SELECT)  ? ");
		list = session.selectList("UserMapper02.getUser03","user");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> ��° ȸ��.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		
		//6. getUser :: $ �����ڸ� �̿��� like ������ �˻�==> �˻���� ���� Ȯ�� 
		user.setUserId("01");
		System.out.println(":: 5. 01�� ������ userId User(SELECT)  ? ");
		 list = session.selectList("UserMapper02.getUser04",user);
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> ��° ȸ��.."+ list.get(i).toString() );
		}
		System.out.println("\n");
	
	}//end of main
}//end of class






