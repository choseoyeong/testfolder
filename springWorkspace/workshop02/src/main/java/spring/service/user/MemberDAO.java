package spring.service.user;

import java.util.List;

import spring.service.domain.MemberVO;

public interface MemberDAO {
	//비지니스 로직...
	int registerMember(MemberVO vo) throws Exception;
	int deleteMember(MemberVO vo) throws Exception;
	int updateMember(MemberVO vo) throws Exception;
	List<MemberVO> showAllMember() throws Exception;	
	MemberVO getMember(String id)throws Exception;	
	boolean idExist(String id) throws Exception;
	MemberVO login(String id, String pass) throws Exception;
}
