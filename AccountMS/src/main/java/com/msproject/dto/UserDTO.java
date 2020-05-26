package com.msproject.dto;

import javax.persistence.Id;

import com.msproject.entity.UserInfo;

public class UserDTO {
	private String userId;
	private String password;
	private String name;
	public UserDTO() {}
	public UserDTO(UserInfo userInfo) {
		this.userId=userInfo.getUserId();
		this.password=userInfo.getPassword();
		this.name=userInfo.getName();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
