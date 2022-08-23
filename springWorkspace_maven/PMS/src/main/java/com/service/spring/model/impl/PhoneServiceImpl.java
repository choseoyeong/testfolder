package com.service.spring.model.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.PhoneDAO;
import com.service.spring.model.PhoneService;

@Service
public class PhoneServiceImpl implements PhoneService{
	
	@Autowired
	private PhoneDAO phoneDAO;
	
	//@Transactional
	@Override
	public int insert(Phone phone) {
		return phoneDAO.insert(phone);
	}
	
	//@Transactional
	@Override
	public int delete(List<String> list) {
		return phoneDAO.delete(list);
	}

	public Phone select(Phone phone) {
		return phoneDAO.select(phone);
	}
	
//	public Phone select(String num) {
//		return phoneDAO.select(num);
//	}

	public List<Phone> select() {
		System.out.println("service select()...");
		return phoneDAO.select();
	}

	public UserInfo select(UserInfo user) {
		System.out.println("service..."+user);
		return phoneDAO.select(user);
	}

}
