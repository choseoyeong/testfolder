package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.spring.domain.Product;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.ProductDAO;
import com.service.spring.model.ProductService;

@Component
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDAO dao;

	// 삽입
	@Override
	public int insertProduct(Product product) {
		return dao.insertProduct(product);
	}

	// 삭제(하나 + 여러개) 동적쿼리
	@Override
	public int deleteProduct(String code) {
		return dao.deleteProduct(code);
	}

	// 검색__동적쿼리 
	@Override
	public Product findProduct(Product product) {
		Product pd = dao.findProduct(product);
		return pd;
	}
	@Override
	public List<Product> findProduct() {
		List<Product> pds = dao.findProduct();
		return pds;
	}
	
	@Override
	public UserInfo selectUser(UserInfo user) {
		return dao.selectUser(user);
	}
}
