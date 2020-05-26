package com.msproject.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.msproject.dto.AddressDTO;

@FeignClient("AddressMS")
public interface AddressFeign {
	@RequestMapping(value = "/address/add/{userId}")
	public void addAddress(@PathVariable String userId,@RequestBody AddressDTO addressDTO);

	@RequestMapping(value = "/address/{userId}/{addressId}")
	public AddressDTO getAddressById(@PathVariable String userId,@PathVariable Long addressId);
	
	@RequestMapping(value = "/address/{userId}")
	public List<AddressDTO> getAddressListByUserId(@PathVariable String userId) ;
	
	@RequestMapping(value = "/address/modify/{userId}/{addressId}")
	public void modifyAddress(@PathVariable String userId,@PathVariable Long addressId,@RequestBody AddressDTO addressDTO) ;
	
	@RequestMapping(value = "/address/delete/{userId}/{addressId}")
	public void deleteAddress(@PathVariable String userId,@PathVariable Long addressId) ;
		
			
}
