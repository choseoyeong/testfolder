package com.service.spring.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.service.spring.domain.Product;
import com.service.spring.domain.UserInfo;

public interface ProductDAO {
	// 등록
	public int insertProduct(Product product);
	
	// 삭제
	public int deleteProduct(String code);
	
	// 일부 조회
	public Product findProduct(Product product);
	// 전체 목록 조회
	public List<Product> findProduct();
	
	
	public UserInfo selectUser(UserInfo user);
}
