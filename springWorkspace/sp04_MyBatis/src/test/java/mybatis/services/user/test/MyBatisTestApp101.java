package mybatis.services.user.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.services.domain.User;


/*
 * FileName : MyBatisTestApp101.java
  * �� SqlMapConfig01.xml / mybatis-userservice-mapping10.xml
  * �� TestUtil.java �� �̿� Test . 
  * �� �̰� ���ư��� MyBatis Framework �����׽�Ʈ�� �� �ȰŴ�...mybatis-userservice-mapping10.xml�� ���� ����.
  * 
  * �� ������ Persistance Logic �����׽�Ʈ : MyBatisTestApp102.java
  * �� MyBatisUserDAOImpl10 / UserDAO �߰��ؾ��Ѵ�.
  */
public class MyBatisTestApp101 {
	///Main method
	public static void main(String[] args) throws Exception{
		
		SqlSession session = null;
		//==> TestUtil �� getSqlSessionFactory()�� �̿� SqlSessionFactory instance GET
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session=factory.openSession();
		
		//==> Test �� User instance ����  
		User user = new User("user04","�ָ�","user04",null,1);		
		
		//1. UserMapper10.addUser Test  :: users table age/grade/redDate �Է°� Ȯ���Ұ� : OK 
		System.out.println(":: 1. addUser(INSERT)  ? "
													+ session.insert("UserMapper10.addUser",user)); //1
													  session.commit();
		//2. UserMapper10.getUser Test :: �ָ� inert Ȯ�� 
		System.out.println(":: 2. getUser(SELECT)  ? ");
		System.out.println(" :: "+session.selectOne("UserMapper10.getUser",user.getUserId()) );
		
		
		//3. UserMapper10.uadateUser Test  :: users table age/redDate �Է°� Ȯ���Ұ� : OK
		//                                                    :: �ָ� ==> �´� ����
		user.setUserName("�´�");
		System.out.println(":: 3. update(UPDATE)  ? "
													+ session.update("UserMapper10.updateUser",user));//1
											  		  session.commit();
		 
		//4. UserMapper10.getUserList Test  :: Dynamic Query Ȯ�� id=user04/name=�´� �˻�
		System.out.println(":: 4. getUserList(SELECT)  ? ");
		TestUtil.printList( (List)session.selectList("UserMapper10.getUserList",user) );
		
		//5. UserMapper10.removeUser Test
		System.out.println(":: 5. Use10.removeUser (DELETE)  ? "
								+session.delete("UserMapper10.removeUser",user.getUserId()) );//1
								 session.commit();
		
		//6. UserMapper10.getUserList Test  :: Dynamic Query Ȯ�� id=user04/name=�´� �˻�
		System.out.println(":: 6. getUserList(SELECT)  ? ");
		TestUtil.printList((List) session.selectList("UserMapper10.getUserList",user) ); //�̶� ���� ��� ����Ÿ���� 0�ΰ� Ȯ������
	
		//7. UserMapper10.getUserList Test  :: Dynamic Query Ȯ�� id=null/name=null �ΰ��
		user.setUserId(null);
		user.setUserName(null);
		System.out.println(":: 7. getUserList(SELECT)  ? ");
		TestUtil.printList( (List) session.selectList("UserMapper10.getUserList",user) );
		
	}//end of main
}//end of class




