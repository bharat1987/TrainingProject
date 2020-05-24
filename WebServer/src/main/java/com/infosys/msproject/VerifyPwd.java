package com.infosys.msproject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class VerifyPwd {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
		System.out.println(encoder.matches("Bharat@123", "$2a$12$rBMhbyaiNjBwPcqz83O16uuOpDKNw/fxxtQP0Nrzklc7mhpdXd3IC"));
		

	}

}
