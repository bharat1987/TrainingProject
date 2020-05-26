package com.msproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msproject.entity.CardDetails;

public interface CardDetailsRepository extends JpaRepository<CardDetails, Long> {

	
	List<CardDetails> findByUserId(String userId);

	void deleteByCardNumberAndUserId(String cardNumber, String userId);

	CardDetails findByCardNumber(String cardNumber);

	CardDetails findByCardNumberAndUserId(String cardNumber,String userId);

}
