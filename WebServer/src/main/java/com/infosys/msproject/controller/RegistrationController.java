package com.infosys.msproject.controller;

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
import org.springframework.web.servlet.ModelAndView;
import com.infosys.msproject.dto.UserDTO;
import com.infosys.msproject.feign.AccountFeign;
import com.infosys.msproject.model.User;
import com.infosys.msproject.validator.PasswordValidator;

@Controller
public class RegistrationController {
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	Environment env;
	
	@Autowired
	private PasswordValidator passwordValidator;
	
	
	@Autowired
	AccountFeign acctFeign;
	
	
	@GetMapping(value = "/register")
	public ModelAndView register(Model model) {
		
		logger.info("In register get method");
		return new ModelAndView("register", "command", new User());
	}
	
	@PostMapping(value = "/registerUser")
	public ModelAndView addCustomer(@Valid @ModelAttribute("command") User user, BindingResult result,
			ModelMap model) {
		
		logger.info("In register post method");
		ModelAndView modelAndView ;
		passwordValidator.validate(user, result);
		
		if (result.hasErrors()) {

			modelAndView= new ModelAndView("register", "command", user);
		} 
		else{
		
			if(acctFeign.checkUserId(user.getUserId()).equals(env.getProperty("invalid.userId.status"))) {
				modelAndView = new ModelAndView("register"); 
				modelAndView.addObject("command",user);
				modelAndView.addObject("message", env.getProperty("account.userId.exists"));
			}else {
				UserDTO userDto=new UserDTO(user);
				acctFeign.register(userDto);
				modelAndView= new ModelAndView("register", "command", user);
				modelAndView.addObject("successMessage",env.getProperty("account.successful_registration"));
			}		
		}
		return modelAndView;
	}
}


