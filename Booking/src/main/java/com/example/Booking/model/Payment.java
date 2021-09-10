package com.example.Booking.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Payment {

	private PaymentMode paymentMode;
	
	private int bookingId;
	
	private String upiId;
	
	private String cardNumber;
}
