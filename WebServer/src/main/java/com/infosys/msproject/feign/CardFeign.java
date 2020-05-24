package com.infosys.msproject.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infosys.msproject.dto.CardDTO;

@FeignClient("CardDetailsMS")
public interface CardFeign {
	
	@RequestMapping(value = "/card/add/{userId}")
	public void addCard(@PathVariable String userId, @RequestBody CardDTO cardDto) ;
	
	@RequestMapping(value = "/card/delete/{userId}/{cardNumber}")
	public void deleteCard(@PathVariable String userId, @PathVariable String cardNumber);
	
	@RequestMapping(value = "/card/{userId}")
	public List<CardDTO> getCards(@PathVariable String userId) ;

}
