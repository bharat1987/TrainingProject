package com.msproject.dto;
import com.msproject.model.Card;

public class CardDTO {

	private long cardId;
	private String cardNumber;
	private String nameOnCard;
	private String expiryMonth;
	private String expiryYear;
	
	
	public CardDTO() {}
	
	public CardDTO(Card card) {
		this.cardId=card.getCardId();
		this.cardNumber=card.getCardNumber();
		this.nameOnCard=card.getNameOnCard();
		this.expiryMonth=card.getExpiryMonth();
		this.expiryYear=card.getExpiryYear();
	}
	
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

	public void createEntity(Card card) {
		
    	card.setCardId(this.getCardId());
    	card.setCardNumber(this.getCardNumber());
    	card.setNameOnCard(this.getNameOnCard());
    	card.setExpiryMonth(this.getExpiryMonth());
    	card.setExpiryYear(this.getExpiryYear());
    	
    }

}
