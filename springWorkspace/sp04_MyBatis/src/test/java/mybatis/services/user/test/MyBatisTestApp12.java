package mybatis.services.user.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;
import mybatis.services.user.UserService;


/*
 * FileName : MyBatisTestApp12.java
  * �� SqlMapConfig01.xml / mybatis-userservice-mapping10.xml
  * �� MyBatisUserDAOImpl12 / MyBatisUserServiceImpl12(�̰� �̸��� �ٲ���)�� �ۼ�.
  * �� Spring meta data����..userservice12.xml
  */
public class MyBatisTestApp12 {
	///Main method
	public static void main(String[] args) throws Exception{

		ApplicationContext context =
			new ClassPathXmlApplicationContext(
							new String[] {	"/bean/userservice12.xml"	 }
								                                                    );
	//==> IoC Container �� ���� ȹ���� UserDAO �ν��Ͻ� ȹ��
	UserService userService = (UserService)context.getBean("myBatisUserServiceImpl12");
	
	User user = new User("user04","�ָ�","user04",40,40);

	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//1.userService.addUser(user) Test
	//System.out.println(":: 1. add(INSERT)  ? ");
	//userService.addUser(user);
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//2.UserService.getUser(userId) Test
	user = userService.getUser("user04");
	System.out.println(":: 2. get(SELECT)  ? "+user);
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//3.UserService.uadateUser(user) Test
	//user.setUserName("�庸��");
	//System.out.println(":: 3. update(UPDATE)  ? ");
	//userService.updateUser(user);
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//4.UserService.getUser(userId) Test
	user = userService.getUser("user04");
	System.out.println(":: 4. get(SELECT)  ? "+user);

	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//5.UserDAO.removeUser(userId) Test
	//==> UserService ���� removeUser�� �����Ƿ�, DAO���� ���� ȣ�� Test
	//UserDAO userDAO = (UserDAO)context.getBean("myBatisUserDAOImpl12");
	//System.out.println(":: 5. remove(DELETE)  ? "+userDAO.removeUser("user04"));
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	//6.UserService.getUserList() Test
	System.out.println(":: 6. all User(SELECT)  ? ");
	List<User> list = userService.getUserList(new User());
	for (int i =0 ;  i < list.size() ; i++) {
		System.out.print( "<"+ ( i +1 )+"> ��° ȸ�� ����... ");
		System.out.println( list.get(i).toString() );
	}
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		
	}//end of main
}//end of class