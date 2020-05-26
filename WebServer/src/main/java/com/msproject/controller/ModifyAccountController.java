package com.msproject.controller;

import java.security.Principal;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.msproject.dto.UserDTO;
import com.msproject.feign.AccountFeign;
import com.msproject.model.User;
import com.msproject.validator.PasswordValidator;

@Controller
public class ModifyAccountController {
protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	Environment env;
	
	@Autowired
	private PasswordValidator passwordValidator;
	
	
	@Autowired
	AccountFeign acctFeign;
	
	
	@GetMapping(value = "/modifyAccount")
	public ModelAndView modify(Model model,Principal principal) {
		
		logger.info("In modify account get method");
		String userId=principal.getName();
		User user=acctFeign.getUser(userId);
		return new ModelAndView("modifyAccount", "command", user);
	}
	
	@PostMapping(value = "/updateAccount")
	public ModelAndView updateAcciunt(@Valid @ModelAttribute("command") User user, BindingResult result,
			ModelMap model) {
		
		logger.info("In modify account post method");
		passwordValidator.validate(user, result);
		ModelAndView modelAndView ;
		if (result.hasErrors()) {

			modelAndView= new ModelAndView("modifyAccount", "command", user);
		} 
		else{
		
			
				UserDTO userDto=new UserDTO(user);
				acctFeign.updateUser(userDto, user.getUserId());
				modelAndView= new ModelAndView("modifyAccount", "command", user);
				modelAndView.addObject("successMessage",env.getProperty("account.successful.updation"));
					
		}
		return modelAndView;
	}


}
