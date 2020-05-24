package com.infosys.msproject.validator;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.infosys.msproject.model.User;

@Component
public class PasswordValidator implements Validator {
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());	
		
    @Autowired
    Environment env;
    
	@Override
	public boolean supports(Class<?> clazz) {
	
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.info("In user validator method");
		User user = (User)target;
		
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("confirmPassword","", env.getProperty("account.invalid.confirmpassword.match"));
		}		
		
	}
	
}
