package com.msproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARDDETAILS")
public class CardDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cardDetailsId;
	public Long getCardDetailsId() {
		return cardDetailsId;
	}

	public void setCardDetailsId(Long cardDetailsId) {
		this.cardDetailsId = cardDetailsId;
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



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
	@Column(nullable = false)
	private String cardNumber;
	@Column(nullable = false)
	private String nameOnCard;
	@Column(nullable = false)
	private String expiryMonth;
	@Column(nullable = false)
	private String expiryYear;
	@Column(nullable = false)
	private String userId;
	
}
