package com.infosys.msproject.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.infosys.msproject.dto.AddressDTO;

import com.infosys.msproject.feign.AddressFeign;
import com.infosys.msproject.model.Address;

import com.infosys.msproject.utility.AddressStateUtil;
import com.infosys.msproject.validator.StateValidator;


@Controller
public class AddressController {
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	Environment env;
	
	@Autowired
	StateValidator stateValidator;
		
	@Autowired
	AddressFeign addrFeign;
	
	@GetMapping(value = "/viewAddresses")
	public ModelAndView viewAddress(Model model,  Principal principal,HttpSession session) {
		
		logger.info("In view address controller");
		String userId=principal.getName();
		 session.setAttribute("addressList", getAddressList(userId));
		 session.setAttribute("stateOptions", AddressStateUtil.getStateList());
		
		model.addAttribute("userId", userId);
		//session.setAttribute("contextPath", request.getContextPath());
		return new ModelAndView("address", "adrForm", new Address());
	}
	
	@GetMapping(value = "/modifyAddress")
	public ModelAndView modifyAddress(Model model, @RequestParam ("addressId")Long addressId,HttpSession session, Principal principal) {
		
		
		logger.info("In modify address controller");
		String userId=principal.getName();
		 List<Address> adrList=(List<Address>) session.getAttribute("addressList");
		 
		 model.addAttribute("userId", userId);
		 for(Address adr:adrList) {
			 if(adr.getAddressId()==addressId) {
				 return new ModelAndView("address", "adrForm", adr);
			 }
		 }
		 
		 session.setAttribute("stateOptions", AddressStateUtil.getStateList()); 
		return new ModelAndView("address", "adrForm", new Address());
	}
	
	@PostMapping(value = "/saveAddress")
	public ModelAndView addAddress(@Valid @ModelAttribute("adrForm") Address address,BindingResult result, HttpSession session ,Model model, Principal principal) {
		
		logger.info("In view add address controller");
		ModelAndView modelAndView;
		AddressDTO adrDto;
		String userId=principal.getName();
		model.addAttribute("userId", userId);
		stateValidator.validate(address, result);
		
		if (result.hasErrors()) {
			logger.info("Address validation failed");
			modelAndView= new ModelAndView("address", "adrForm", new Address());
		} else {
			logger.info("Address validation success"+ address);
			adrDto=new AddressDTO(address);
			logger.info("Address validation adrDTO"+ adrDto.toString());
			if(address.getAddressId()==null) {
				addrFeign.addAddress(userId, adrDto);
				modelAndView=new ModelAndView("address", "adrForm", new Address());
				modelAndView.addObject("successMessage",env.getProperty("address.successful.added"));
			}else {
				addrFeign.modifyAddress(userId, address.getAddressId(), adrDto);
				modelAndView=new ModelAndView("address", "adrForm", new Address());
				modelAndView.addObject("successMessage",env.getProperty("address.successful.updated"));
			}
			
			
		}		
		session.setAttribute("addressList", getAddressList(userId));
		session.setAttribute("stateOptions", AddressStateUtil.getStateList()); 
		return modelAndView;
	}
	
	@GetMapping(value = "/deleteAddress")
	public ModelAndView deleteAddress( Principal principal,@RequestParam("addressId") Long addressId,Model model, HttpSession session) {
		
		logger.info("In view address controller");
		String userId=principal.getName();
		addrFeign.deleteAddress(userId, addressId);
		
		
		session.setAttribute("addressList", getAddressList(userId));
		session.setAttribute("stateOptions", AddressStateUtil.getStateList()); 
		model.addAttribute("userId", userId);
		model.addAttribute("successMessage",env.getProperty("address.successful.deleted"));
		return new ModelAndView("address", "adrForm", new Address());
	}

	
	   private List<Address> getAddressList(String userId) {
	        
		   List<AddressDTO> adrDtoList=  addrFeign.getAddressListByUserId(userId);
		   List<Address> adrList=new ArrayList<Address>();
		   for(AddressDTO adrDto:adrDtoList) {
			   Address adr=new Address();
			   adrDto.createEntity(adr);
			   logger.info(adrDto.toString());
			   adrList.add(adr);			   
		   }
		   return adrList;
	    }
}
