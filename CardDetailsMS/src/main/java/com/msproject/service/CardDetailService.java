package com.msproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msproject.dto.CardDTO;
import com.msproject.entity.CardDetails;
import com.msproject.repository.CardDetailsRepository;

@Service
@Transactional
public class CardDetailService {

	Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	CardDetailsRepository cardRepo;

	public void addCard(CardDTO cardDto, String userId) {
		logger.info("Inside add card service");
		CardDetails card=new CardDetails();
		cardDto.createEntity(card);
		card.setUserId(userId);
		cardRepo.save(card);
			
	}

	public void deleteCard(String cardNumber, String userId) {
		logger.info("Inside delete card service");
		CardDetails card=cardRepo.findByCardNumberAndUserId(cardNumber,userId);
		if (card != null) {
			cardRepo.delete(card);
		}	
		
	}

	public List<CardDTO> getCards(String userId) {
		logger.info("Inside get card service");
		List<CardDetails> cardList=cardRepo.findByUserId(userId);
		List<CardDTO> cardDtoList=new ArrayList<CardDTO>();
		for(CardDetails card:cardList) {
			CardDTO cardDto =new CardDTO(card);
			cardDtoList.add(cardDto);
		}
		return cardDtoList;
	}
}
