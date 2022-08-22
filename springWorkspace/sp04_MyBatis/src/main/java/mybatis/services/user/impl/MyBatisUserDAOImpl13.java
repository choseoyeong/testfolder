/*
 * 
 * 						Layer	
 * Presentation						BusinessLogic
 * 		|							   	 |	
 * 	Controller				Service				Persistance
 * 		|					    |					 |
 *  ~~Controller			UserService		 	 UserDAO
 * 								|					 |
 * 					MyBatisUserServiceImpl13	MyBatisUserDAOImpl13			
 * 
 * 
 * Component(bean) => ~~Controller, MyBatisUserServiceImpl13, MyBatisUserDAOImpl13
 * Presentation Layer의 component를 @Controller라 함
 * Service Layer의 component를 @Service라 함
 * Persistance Layer의 component를 @Repository라 함
 * 
 * Annotation은 '@Component'
 * -> annotation 선언하면 bean을 줄 일 수 있음
 */
package mybatis.services.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;

@Repository
public class MyBatisUserDAOImpl13 implements UserDAO{
	
	@Autowired
	private SqlSession sqlSession;
	public static final String MAPPER_NAME = "UserMapper10.";
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::" +getClass().getName()+".setSqlSession() Call...");
		this.sqlSession = sqlSession;
	}

	@Override
	public int addUser(User user) throws Exception {
		int result = sqlSession.insert(MAPPER_NAME+"addUser", user);
		//sqlSession.commit();
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.update(MAPPER_NAME+"updateUser", user);
		//sqlSession.commit();
		return result;
	}

	@Override
	public int removeUser(String userId) throws Exception {
		int result = sqlSession.delete(MAPPER_NAME+"removeUser", userId);
		//sqlSession.commit();
		return result;
	}

	@Override
	public User getUser(String userId) throws Exception {
		User user = sqlSession.selectOne(MAPPER_NAME+"getUser", userId);
		return user;
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		List<User> list = sqlSession.selectList(MAPPER_NAME+"getUserList", user);
		return list;
	}

}
