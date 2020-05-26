package com.msproject.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.msproject.dto.UserDTO;
import com.msproject.exception.UserIdAlreadyPresentException;
import com.msproject.service.AccountService;

@RestController
public class AccountController {
	
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	Environment env;


	@Autowired
	AccountService acctService;
	
	@PostMapping(value="/signup", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void register(@RequestBody UserDTO userDto){
		logger.info("Inside signup account controller");
		acctService.registerUser(userDto);
		
	}
	
	@GetMapping(value="/checkUserId/{userId}")
	public String checkUserId(@PathVariable String userId){
		logger.info("Inside check user account controller");
		try {
			acctService.checkUser(userId);
			
		} catch (UserIdAlreadyPresentException e) {
			logger.info("Inside register controller-User Id already exists");
			return env.getProperty("invalid.userId.status");
		}
		return env.getProperty("valid.userId.status");
		
	}
	
	@GetMapping(value="/getUserDetails/{userId}")
	public UserDTO getUser(@PathVariable String userId){
		logger.info("Inside get user account controller");
		
			return acctService.getUser(userId);
			
		
	}
	
	@PostMapping(value="/updateAccount/{userId}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(@RequestBody UserDTO userDto,@PathVariable String userId){
		logger.info("Inside update user account controller");
		acctService.updateUser(userDto,userId);
		
	}

}
