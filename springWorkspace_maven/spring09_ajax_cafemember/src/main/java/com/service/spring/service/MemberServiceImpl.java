package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.Member;
import com.service.spring.model.MemberDAO;



@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public void registerMember(Member member) {
		memberDAO.registerMember(member);
	}

	@Override
	public List<Member> showAllMember() {
		return memberDAO.showAllMember();
	}

	@Override
	public Member findByIdMember(String id) {
		return memberDAO.findByIdMember(id);
	}

	@Override
	public Member login(Member member) {
		return memberDAO.login(member);
	}

	@Override
	public void updateMember(Member member) {
		memberDAO.updateMember(member);
	}

	@Override
	public String idExist(String id) {
		return memberDAO.idExist(id);
	}

}
