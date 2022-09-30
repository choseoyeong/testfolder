package com.service.spring.domain;

public class UserInfo {
	private String id;
	private String pw;
	private String name;

	public UserInfo() {
		super();
	}
	
	public UserInfo(String id) {
		super();
		this.id = id;
	}

	public UserInfo(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", pw=" + pw + ", name=" + name + "]";
	}

	

}
