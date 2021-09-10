package com.example.Transaction.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDetailsEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int transactionId;
	
	private String paymentMode;
	
	private int bookingId;
	
	private String upiId;
	
	private String cardNumber;
	
	
}
