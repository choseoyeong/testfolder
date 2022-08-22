package mybatis.services.user.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.services.domain.User;
import mybatis.services.user.impl.MyBatisUserDAOImpl10;
import mybatis.services.user.impl.MyBatisUserServiceImpl11;

/*
 * FileName : MyBatisTestApp11.java
  * �� SqlMapConfig01.xml / mybatis-userservice-mapping10.xml
  * �� MyBatisUserServiceImpl11
  * �� TestUtil.java �� �̿� Test . 
  * �� Business Logic Layer ���� Test..���⼭ �������ٰ��ص� mybatis-userservice-mapping10.xml�� �� �ʿ����.
  * �� MyBatisUserDAOImpl10(UserADO), MyBatisUserServiceImpl11(UserService)�� ���� �ۼ��Ѵ�.
  * 
  * ���ش� �ڵ忡�� ������ new�� ���δ�...�ᱹ �������� Spring�� �������� �ʾҴٴ� ���̴�.
  * �������� MyBatisTestApp12.java���� ��Ÿ����Ÿ�� �߰��ϰڴ�.
  */
public class MyBatisTestApp11 {
	///Main method
	public static void main(String[] args) throws Exception{

		SqlSession session = null;
		//==> TestUtil �� getSqlSessionFactory()�� �̿� SqlSessionFactory instance GET
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session=factory.openSession();
		
		//==> MyBatisUserDAOImpl10 ���� �� SqlSession ��ü setter injection
		MyBatisUserDAOImpl10 dao = new MyBatisUserDAOImpl10();
		dao.setSqlSession(session);
		
		//==> IBatisUserServiceImpl11 ���� �� IBatisUserDAOImpl10 ��ü setter injection
		MyBatisUserServiceImpl11 userService = new  MyBatisUserServiceImpl11();
		userService.setUserDAO(dao);
		
		//==> Test �� User instance ����  
		User user = new User("user04","�ָ�","user04",null,1);
		
		
		//1. MyBatisUserServiceImpl11.addUser Test  
		System.out.println(":: 1. addUser(INSERT)  ? ");
		userService.addUser(user);
		
		//2. MyBatisUserServiceImpl11.getUser Test :: �ָ� inert Ȯ�� 
		System.out.println(":: 2. getUser(SELECT)  ? \n " + dao.getUser(user.getUserId()) );

		//3. MyBatisUserServiceImpl11.uadateUser Test  
		//                                                    :: �ָ� ==> �´� ����
		user.setUserName("�´�");
		System.out.println(":: 3. update(UPDATE)  ? ");
		userService.updateUser(user) ;
	
		//4. IBatisUserServiceImpl11.getUserList Test::Dynamic Query Ȯ�� id=user04/name=�´� �˻�
		System.out.println(":: 4. getUserList(SELECT)  ? ");
		TestUtil.printList( userService.getUserList(user) );
		
		//5. MyBatisUserServiceImpl11.removeUser Test
		//==> UserService ���� removeUser�� �����Ƿ�, DAO���� ���� ȣ�� Test
		System.out.println(":: 5. Use10.removeUser (DELETE)  ? "
													+dao.removeUser(user.getUserId()) );
		
		//6. MyBatisUserServiceImpl11.getUserList Test 
		System.out.println(":: 6. getUserList(SELECT)  ? ");
		TestUtil.printList( userService.getUserList(user) );
		
		//7. MyBatisUserServiceImpl11.getUserList Test 
		user.setUserId(null);
		user.setUserName(null);
		System.out.println(":: 7. getUserList(SELECT)  ? ");
		TestUtil.printList( userService.getUserList(user) );
		
	}//end of main
}//end of class