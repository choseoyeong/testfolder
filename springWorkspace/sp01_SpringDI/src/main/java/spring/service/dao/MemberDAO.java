package spring.service.dao;
// ����Ͻ� ������ ���ø�..
public interface MemberDAO {
	void register(String id, String pass);
	void delete(String id);
}
