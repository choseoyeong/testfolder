package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.Member;



public interface MemberDAO {
	void registerMember(Member member);
	List<Member> showAllMember();
	Member findByIdMember(String id);
	Member login(Member member);
	void updateMember(Member member);
	String idExist(String id);
}