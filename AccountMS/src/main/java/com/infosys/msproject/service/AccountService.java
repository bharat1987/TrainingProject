package com.infosys.msproject.service;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.infosys.msproject.dto.UserDTO;
import com.infosys.msproject.entity.UserInfo;
import com.infosys.msproject.exception.UserIdAlreadyPresentException;
import com.infosys.msproject.repository.AccountRepository;

@Service
public class AccountService {
	
	Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	public void registerUser(UserDTO userDto) {
		logger.info("Inside register user service");
		UserInfo userInfo=new UserInfo();
		createEntity(userInfo,userDto);
		accountRepository.save(userInfo);		
	}

	public void updateUser(UserDTO userDto, String userId) {
		logger.info("Inside update user service");
		Optional<UserInfo> userInfoOpt=accountRepository.findById(userId);
		if(userInfoOpt.isPresent()) {
			UserInfo userInfo=userInfoOpt.get();
			createEntity(userInfo,userDto);
			accountRepository.save(userInfo);
			
		}
		
	}
	public void createEntity(UserInfo userInfo,UserDTO userDto) {
		logger.info("Inside create entity service");
		userInfo.setName(userDto.getName());
		userInfo.setPassword(encoder.encode(userDto.getPassword()));
		logger.info("Check if password matches " + encoder.matches(userDto.getPassword(), userInfo.getPassword()));
		userInfo.setUserId(userDto.getUserId());
	}

	public void checkUser(String userId) throws UserIdAlreadyPresentException {
		logger.info("Inside check user exists service");
		if(accountRepository.existsById(userId)) {
			throw new UserIdAlreadyPresentException("User Id already exists");
		}
		
	}

	public UserDTO getUser(String userId) {
		logger.info("Inside get user exists service");
		UserDTO userDto=null;
		Optional<UserInfo> userOpt=accountRepository.findById(userId);
		
		if(userOpt.isPresent()) {
			UserInfo user=userOpt.get();
			userDto=new UserDTO(user);			
		}
		return userDto;
	}

}
