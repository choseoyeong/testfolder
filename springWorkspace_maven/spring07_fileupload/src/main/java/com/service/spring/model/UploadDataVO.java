package com.service.spring.model;

import org.springframework.web.multipart.MultipartFile;

/*
 * ���Ͼ��ε� ���� ���� �� ���� ������ �Ѵ�.
 * 
 * 
 */
public class UploadDataVO {
	private String userName;
	private MultipartFile uploadFile;	//uploadFile �̸����� �����ؾ����� ���ε��� ������ ���� �� �ִ�.
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
}
