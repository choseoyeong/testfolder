package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

public interface UserDAO {
	int addUser(User user) throws Exception;
	int updateUser(User user) throws Exception;
	int removeUser(String userId) throws Exception;
	
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;		// 동적 쿼리를 위한 인자값 User
}
