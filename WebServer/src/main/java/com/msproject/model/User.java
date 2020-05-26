package com.msproject.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@NotEmpty(message = "{account.invalid.userid.empty}")
	@Size(min = 4, max = 15, message = "{account.invalid.userId.length}")
	@Pattern(regexp = "^[a-zA-Z0-9]+$" , message="{account.invalid.userid.character}")
	private String userId;

	@NotEmpty(message = "{account.invalid.password.empty}")
	@Size(min = 8, max = 15, message = "{account.invalid.password.length}")
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*\\W).*$", message="{account.invalid.password.character}")
	private String password;
	
	@NotEmpty(message = "{account.invalid.confirmpassword.empty}")
	private String confirmPassword;
	
	@NotEmpty(message = "{account.invalid.name.empty}")
	@Size(min = 4, max = 15, message = "{account.invalid.name.length}")
	@Pattern(regexp = "^[a-zA-Z ]*$", message="{account.invalid.name.character}" )
	private String name;
	
}
