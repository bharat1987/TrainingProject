package com.msproject.validator;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.msproject.model.Card;


@Component
public class CardExpiryValidator implements Validator {
	
	protected Logger logger = Logger.getLogger(this.getClass().getName());	
		
    @Autowired
    Environment env;
    
	@Override
	public boolean supports(Class<?> clazz) {
	
		return Card.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.info("In user validator method");
		Card card = (Card)target;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
		simpleDateFormat.setLenient(false);
		Date expiry;
		try {
			expiry = simpleDateFormat.parse(card.getExpiryMonth() + "/" + card.getExpiryYear());
			boolean expired = expiry.before(new Date());
			
			if (expired) {
				errors.rejectValue("expiryYear","", env.getProperty("card.expiry.invalid"));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		
	}
	
}
