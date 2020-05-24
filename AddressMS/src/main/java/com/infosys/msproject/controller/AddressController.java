package com.infosys.msproject.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.msproject.dto.AddressDTO;

import com.infosys.msproject.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	AddressService addrService;
	
	@PostMapping(value = "/add/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addAddress(@PathVariable String userId,@RequestBody AddressDTO addressDTO) {
		
		logger.info("Inside add address controller"+ addressDTO);
		addrService.addAddress(addressDTO,userId);
		
	}
	
	@GetMapping(value = "/{userId}/{addressId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AddressDTO getAddressById(@PathVariable String userId,@PathVariable Long addressId) {
		
		logger.info("Inside get address by id controller "+ userId+"-"+addressId);
		return addrService.getAddress(userId,addressId);
		
	}
	
	@GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AddressDTO> getAddressByUserId(@PathVariable String userId) {
		
		logger.info("Inside get address by user id controller"+ userId);
		return addrService.getAddressByUserId(userId);
		
	}
	
	@PostMapping(value = "/modify/{userId}/{addressId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAddress(@PathVariable String userId,@PathVariable Long addressId,@RequestBody AddressDTO addressDTO) {
		
		logger.info("Inside modify address controller"+ addressDTO);
		addrService.modifyAddress(addressDTO,userId,addressId);
		
	}
	
	@GetMapping(value = "/delete/{userId}/{addressId}")
	public void deleteAddress(@PathVariable String userId,@PathVariable Long addressId) {
		
		logger.info("Inside delete address controller"+ userId+"- "+addressId);
		addrService.deleteAddress(addressId,userId);		
	}
	
}
