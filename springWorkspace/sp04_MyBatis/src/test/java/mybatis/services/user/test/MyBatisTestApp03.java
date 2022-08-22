package mybatis.services.user.test;


import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.services.domain.User;

/*
 * FileName : MyBatisTestApp03.java
  * �� SqlMapConfig01.xml / mybatis-userservice-mapping03.xml
  * �� My Framework �̿� QUERY ( SELECT ) TEST 
  */
public class MyBatisTestApp03 {
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
		
		//0. User01.getUserList 
		System.out.println(":: 0. getUserList(SELECT)  ? ");
		List<User> list = session.selectList("UserMapper.getUserList");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> ��° ȸ��.."+ list.get(i).toString() );
		}
		System.out.println("\n");
		
		//==> Test �� UserVO instance ����
		User user = new User("user04","�ָ�","user04",40,4);
		
		//1.User03.addUser Test
		/*
		Object obj = session.insert("UserMapper03.addUser", user);
		session.commit(); //�� �κ� �ݵ�� ����� �Ѵ�....mvc������ ��������.
		System.out.println(":: 1. addUser(INSERT)  result ? "+obj); //1
		System.out.println("\n");
		*/
		
		
		//2.User01.findUserId Test
		String userName = (String)session.selectOne("UserMapper01.findUserId", user);
		System.out.println(":: 2. findUserId(SELECT)  ? "+userName); //�ָ�
		System.out.println("\n");
			
	
		//3.User03.uadateUser Test
		user.setUserName("�庸��");
		int updateResult = session.update("UserMapper03.updateUser", user);
		session.commit(); //�̺κ� �ݵ�� ����� �Ѵ�.
		System.out.println(":: 3. updateUser(UPDATE) result ? "+updateResult);//1
		System.out.println("\n");
		
		
		//4.User01.findUserId Test
		userName = (String)session.selectOne("UserMapper01.findUserId", user);
		System.out.println(":: 4. findUserId(SELECT)  ? "+userName); //�庸��
		System.out.println("\n");
		
		
		//5.User03.removeUser Test
		int deleteResult = session.delete("UserMapper03.removeUser", user.getUserId());
		session.commit(); //�� �κ� �ݵ�� ����� �Ѵ�.
		System.out.println(":: 5. removeUser(DELETE) result ? "+deleteResult);
		System.out.println("\n");
		
		
		
		//6. User01.getUserList 
		System.out.println(":: 6. getUserList(SELECT)  ? ");
		 list = session.selectList("UserMapper.getUserList");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( "<"+ ( i +1 )+"> ��° ȸ��.."+ list.get(i).toString() );
		}
		
	}//end of main
}//end of class




















