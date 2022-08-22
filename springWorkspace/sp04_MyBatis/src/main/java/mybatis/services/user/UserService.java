package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

/*
 * Service Layer::
 * "������ ���� Layer"
 * �Խ����� ����¡ �����ϸ� �ȴ�.
 * 
 * DB���� ������ �� �����͸� �����ϴ� ���̾�
 * Persistance Layer�� DAO�� DI(����)�Ǿ�� �Ѵ�.
 */
public interface UserService {
	void addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;

	
	User getUser(String userId) throws Exception;
	List<User> getUserList(User user) throws Exception;		// ���� ������ ���� ���ڰ� User
}
