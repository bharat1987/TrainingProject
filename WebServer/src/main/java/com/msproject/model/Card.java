package com.msproject.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Card {

	private long cardId;
	@NotEmpty(message = "{card.invalid.cardNumber.empty}")
	@Size(min = 16,max=16, message="{card.invalid.cardNumber.length}")
	@Pattern(regexp = "^[0-9]*$", message="{card.invalid.cardNumber.character}" )	
	private String cardNumber;
	
	@NotEmpty(message = "{card.invalid.name.empty}")
	@Size(min = 4, max = 15, message = "{card.invalid.name.length}")
	@Pattern(regexp = "^[a-zA-Z ]*$", message="{card.invalid.name.character}" )
	private String nameOnCard;
	
	@NotEmpty(message = "{card.invalid.month.empty}")
	@Size(min = 2, max = 2, message = "{card.invalid.month.length}")
	@Pattern(regexp = "^[0-9]*$", message="{card.invalid.month.character}" )
	private String expiryMonth;
	
	@NotEmpty(message = "{card.invalid.year.empty}")
	@Size(min = 4, max = 4, message = "{card.invalid.year.length}")
	@Pattern(regexp = "^[0-9]*$", message="{card.invalid.year.character}" )
	private String expiryYear;
	
	
		
	public long getCardId() {
		return cardId;
	}
	public void setCardId(long cardId) {
		this.cardId = cardId;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}

	
	

}
