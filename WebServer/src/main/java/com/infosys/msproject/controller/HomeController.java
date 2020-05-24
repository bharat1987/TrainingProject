package com.infosys.msproject.controller;

import java.security.Principal;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	protected Logger logger = Logger.getLogger(HomeController.class.getName());

	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView getLoginDetails(Principal principal,Model model) {
		String userId=principal.getName();
		logger.info("Inside Home Page "+ userId);
		model.addAttribute("userId", userId);
		return new ModelAndView("home");
	}

}
