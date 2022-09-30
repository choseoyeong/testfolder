package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Product;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.ProductDAO;

@Repository
public class ProductDAOImpl implements ProductDAO{
private final String NS = "sql.bank.mapper.";
	
	@Autowired
	private SqlSession sqlSession;

	// 삽입
	@Override
	public int insertProduct(Product product) {
		return sqlSession.insert(NS+"insertProduct", product);
	}

	@Override
	public int deleteProduct(String code) {
		return sqlSession.delete(NS+"deleteProduct", code);
	}

	// 검색__동적쿼리 
	@Override
	public Product findProduct(Product product) {
		Product pd = sqlSession.selectOne(NS+"findProduct", product);
		return pd;
	}
	@Override
	public List<Product> findProduct() {
		List<Product> pds = sqlSession.selectList(NS+"findProduct", null);
		return pds;
	}
	
	@Override
	public UserInfo selectUser(UserInfo user) {
		UserInfo us = sqlSession.selectOne(NS+"selectUser", user);
		return us;
	}
}
