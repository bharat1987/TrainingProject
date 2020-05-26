package com.msproject.controller;

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

import com.msproject.dto.CardDTO;
import com.msproject.feign.CardFeign;
import com.msproject.model.Address;
import com.msproject.model.Card;
import com.msproject.utility.AddressStateUtil;
import com.msproject.utility.CardExpiryUtility;
import com.msproject.validator.CardExpiryValidator;
import com.msproject.validator.StateValidator;

@Controller
public class CardController {
	protected Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	Environment env;
	
	@Autowired
	CardExpiryValidator cardValidator;
				
	@Autowired
	CardFeign cardFeign;
	
	@GetMapping(value = "/viewCards")
	public ModelAndView viewCards(Model model,Principal principal,HttpSession session) {
		
		logger.info("In view cards controller");
		String userId=principal.getName();
		session.setAttribute("cardsList", getCardsList(userId));
		session.setAttribute("monthList", CardExpiryUtility.getListOfMonths());
		session.setAttribute("yearList", CardExpiryUtility.getListOfYears());
		 		
		model.addAttribute("userId", userId);
		//session.setAttribute("contextPath", request.getContextPath());
		return new ModelAndView("cards", "card", new Card());
	}
	
	
	@PostMapping(value = "/saveCard")
	public ModelAndView addCard(@Valid @ModelAttribute("card") Card card, BindingResult result,HttpSession session, Model model,Principal principal) {
		
		logger.info("In view save  controller "+ card.getNameOnCard()+""+card.getNameOnCard()+""+ card.getExpiryYear());
		String userId=principal.getName();
		ModelAndView modelAndView;
		CardDTO cardDto;
		boolean existingFlag=false;
		model.addAttribute("userId", userId);
		cardValidator.validate(card, result);
				
		if (result.hasErrors()) {
			logger.info("Card validation failed");
			modelAndView= new ModelAndView("cards", "card", card);
		} else {
			logger.info("Card validation success"+ card);
			List<Card> cardList=(List<Card>) session.getAttribute("cardsList");
			if(cardList!=null) { 		
				 for(Card cardTemp:cardList) {
					 if(cardTemp.getCardNumber().equals(card.getCardNumber())) {
						 existingFlag=true;
					 }
				 }
			 }
			if(!existingFlag) {
				cardDto=new CardDTO(card);
				logger.info("Card number does not exist"+ cardDto.toString());
				cardFeign.addCard(userId, cardDto);
				modelAndView=new ModelAndView("cards", "card", new Card());
				modelAndView.addObject("successMessage",env.getProperty("card.successful.added"));
			}else {
				modelAndView = new ModelAndView("cards"); 
				modelAndView.addObject("card",card);
				modelAndView.addObject("message", env.getProperty("card.number.already.added"));
			}			
			
		}	
				
		session.setAttribute("cardsList", getCardsList(userId));
		session.setAttribute("monthList", CardExpiryUtility.getListOfMonths());
		session.setAttribute("yearList", CardExpiryUtility.getListOfYears());
		 				 
		return modelAndView;
	}
	
	@GetMapping(value = "/deleteCard")
	public ModelAndView deleteCard(Principal principal,@RequestParam("cardNumber") String cardNumber,HttpSession session,Model model) {
		
		logger.info("In delete card  controller");
		String userId=principal.getName();
		cardFeign.deleteCard(userId, cardNumber);		
		
		session.setAttribute("cardsList", getCardsList(userId));
		session.setAttribute("monthList", CardExpiryUtility.getListOfMonths());
		session.setAttribute("yearList", CardExpiryUtility.getListOfYears());
		 		
		
		model.addAttribute("userId", userId);
		model.addAttribute("successMessage",env.getProperty("card.successful.deleted"));
		return new ModelAndView("cards", "card", new Card());
	}

	
	   private List<Card> getCardsList(String userId) {
	        
		   List<CardDTO> cardDtoList= cardFeign.getCards(userId);
		   List<Card> cardList=new ArrayList<Card>();
		   for(CardDTO cardDto:cardDtoList) {
			   Card card=new Card();
			   cardDto.createEntity(card);
			   logger.info(cardDto.toString());
			   cardList.add(card);			   
		   }
		   return cardList;
	    }


}
