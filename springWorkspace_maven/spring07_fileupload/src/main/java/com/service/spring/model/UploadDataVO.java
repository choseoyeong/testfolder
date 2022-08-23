package com.service.spring.model;

import org.springframework.web.multipart.MultipartFile;

/*
 * 파일업로드 폼을 정말 잘 보고 만들어야 한다.
 * 
 * 
 */
public class UploadDataVO {
	private String userName;
	private MultipartFile uploadFile;	//uploadFile 이름으로 지정해야지만 업로드한 파일을 담을 수 있다.
	
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
