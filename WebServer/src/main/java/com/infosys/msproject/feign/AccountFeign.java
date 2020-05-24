package com.infosys.msproject.feign;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infosys.msproject.dto.UserDTO;
import com.infosys.msproject.model.User;





@FeignClient("AccountMS")
public interface AccountFeign {

	@RequestMapping(value="/signup")
	public void register(@RequestBody UserDTO userDto);
	
	@RequestMapping(value="/updateAccount/{userId}")
	public void updateUser(@RequestBody UserDTO userDto,@PathVariable String userId);
	
	@RequestMapping(value="/checkUserId/{userId}")
	public String checkUserId(@PathVariable String userId);

	@RequestMapping(value="/getUserDetails/{userId}")
	public User getUser(@PathVariable String userId);
	
}
