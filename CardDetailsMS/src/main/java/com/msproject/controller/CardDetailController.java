package com.msproject.controller;

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

import com.msproject.dto.CardDTO;
import com.msproject.service.CardDetailService;

@RestController
@RequestMapping("/card")
public class CardDetailController {

	Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	CardDetailService cardService;
	
	@PostMapping(value = "/add/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addCard(@PathVariable String userId, @RequestBody CardDTO cardDto) {
		logger.info("Inside add card controller");
		cardService.addCard(cardDto,userId);
		
	}
	
	@GetMapping(value = "/delete/{userId}/{cardNumber}")
	public void deleteCard(@PathVariable String userId, @PathVariable String cardNumber) {
		logger.info("Inside delete card controller");
		cardService.deleteCard(cardNumber,userId);
	}
	
	@GetMapping(value = "/{userId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CardDTO> getCards(@PathVariable String userId) {
		logger.info("Inside get cards controller");
		return cardService.getCards(userId);
		
	}
	
}
