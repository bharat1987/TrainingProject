package com.msproject.dto;

import com.msproject.model.User;

public class UserDTO {
	private String userId;
	private String password;
	private String name;
	public UserDTO() {}
	public UserDTO(User user) {
		this.userId=user.getUserId();
		this.password=user.getPassword();
		this.name=user.getName();
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
