package mybatis.services.user.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.services.domain.User;
import mybatis.services.user.impl.MyBatisUserDAOImpl10;

/*
 * FileName : MyBatisTestApp102.java
  * �� SqlMapConfig01.xml / mybatis-userservice-mapping10.xml
  * �� MyBatisUserDAOImpl10
  * �� TestUtil.java �� �̿� Test . 
  * �� Persistance Logic Layer ���� Test..���⼭ �������ٰ��ص� mybatis-userservice-mapping10.xml�� �� �ʿ����.
  *   ::Persistence Layer�� �����׽�Ʈ ������
  *  
  *  �� ������ Service Layer ���� �׽�Ʈ : MyBatisTestApp11.java
  */
public class MyBatisTestApp102 {
	///Main method
	public static void main(String[] args) throws Exception{

		SqlSession session = null;
		//==> TestUtil �� getSqlSessionFactory()�� �̿� SqlSessionFactory instance GET
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session=factory.openSession();
		
			
		//==> MyBatisUserDAOImpl10 ���� �� sqlMapClient ��ü setter injection
		MyBatisUserDAOImpl10 dao = new MyBatisUserDAOImpl10();
		dao.setSqlSession(session);
		
		//==> Test �� User instance ����  
		User user = new User("user04","�ָ�","user04",null,1);
			
		//1. MyBatisUserDAOImpl10.addUser Test  
		//System.out.println(":: 1. addUser(INSERT)  ? "	+ dao.addUser(user) );
		
		//2. MyBatisUserDAOImpl10.getUser Test :: �ָ� inert Ȯ�� 
		System.out.println(":: 2. getUser(SELECT)  ? \n " + dao.getUser(user.getUserId()) );

		//3. MyBatisUserDAOImpl10.uadateUser Test  
		//                                                    :: �ָ� ==> �´� ����
//		user.setUserName("�´�");
//		System.out.println(":: 3. update(UPDATE)  ? "+dao.updateUser(user) );
		
		//4. MyBatisUserDAOImpl10.getUserList Test::Dynamic Query Ȯ�� id=user04/name=�´� �˻�
		System.out.println(":: 4. getUserList(SELECT)  ? ");
		TestUtil.printList( dao.getUserList(user) );
		
		//5. MyBatisUserDAOImpl10.removeUser Test
		System.out.println(":: 5. UserMapper10.removeUser (DELETE)  ? "
															+dao.removeUser(user.getUserId()) );
		
		//6. MyBatisUserDAOImpl10.getUserList Test 
		System.out.println(":: 6. UserMapper10.getUserList(SELECT)  ? ");
		TestUtil.printList( dao.getUserList(user) );
		
		//7. MyBatisUserDAOImpl10.getUserList Test 
		user.setUserId(null);
		user.setUserName(null);
		System.out.println(":: 7. UserMapper10.getUserList(SELECT)  ? ");
		TestUtil.printList( dao.getUserList(user) );
		
	}//end of main
}//end of class