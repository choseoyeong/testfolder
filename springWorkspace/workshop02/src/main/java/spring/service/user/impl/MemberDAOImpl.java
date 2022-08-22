package spring.service.user.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;

public class MemberDAOImpl implements MemberDAO{
	private SqlSession sqlSession;
	public static final String MAPPER_NAME = "MemberMapper.";
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::" +getClass().getName()+".setSqlSession() Call...");
		this.sqlSession = sqlSession;
	}

	@Override
	public int registerMember(MemberVO vo) throws Exception {
		int result = 0;
		if(!idExist(vo.getId())) {
			result = sqlSession.delete(MAPPER_NAME+"registerMember", vo);
			sqlSession.commit();
		}
		return result;
	}

	@Override
	public int deleteMember(MemberVO vo) throws Exception {
		int result = 0;
		if(idExist(vo.getId())) {
			result = sqlSession.delete(MAPPER_NAME+"deleteMember", vo);
			sqlSession.commit();
		}
		return result;
	}

	@Override
	public int updateMember(MemberVO vo) throws Exception {
		int result = 0;
		if(idExist(vo.getId())) {
			result = sqlSession.delete(MAPPER_NAME+"updateMember", vo);
			sqlSession.commit();
		}
		return result;
	}

	@Override
	public List<MemberVO> showAllMember() throws Exception {
		return sqlSession.selectList(MAPPER_NAME+"showAllMember");
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		return sqlSession.selectOne(MAPPER_NAME+"getMember", id);
	}

	@Override
	public boolean idExist(String id) throws Exception {
		MemberVO vo = sqlSession.selectOne(MAPPER_NAME+"idExist", id);
		return vo!=null;
	}

	@Override
	public MemberVO login(String id, String pass) throws Exception {
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("password", pass);
		MemberVO vo = sqlSession.selectOne(MAPPER_NAME+"login", map);
		return vo;
	}

}
