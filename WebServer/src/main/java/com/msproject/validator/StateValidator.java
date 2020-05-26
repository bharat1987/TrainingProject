package com.msproject.validator;


import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

import com.msproject.model.Address;
import com.msproject.utility.AddressStateUtil;

@Component
public class StateValidator implements Validator {
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());	
		
    @Autowired
    Environment env;
    
	@Override
	public boolean supports(Class<?> clazz) {
	
		return Address.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.info("In Address validator method");
		Address adr = (Address)target;
		
		if (!AddressStateUtil.getStateList().containsKey(adr.getState())) {
			errors.rejectValue("state","", env.getProperty("address.invalid.state"));
		}		
		
	}
	
}
