package com.service.spring.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Member;



@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void registerMember(Member member) {
		sqlSession.insert("Member.registerMember", member);
	}

	@Override
	public List<Member> showAllMember() {
		return sqlSession.selectList("Member.showAllMember");
	}

	@Override
	public Member findByIdMember(String id) {
		return sqlSession.selectOne("Member.findByIdMember", id);
	}

	@Override
	public Member login(Member member) {
		return sqlSession.selectOne("Member.login", member);
	}

	@Override
	public void updateMember(Member member) {
		sqlSession.update("Member.updateMember", member);
	}

	@Override
	public String idExist(String id) {
		return sqlSession.selectOne("Member.idExist", id);
	}

}
