package com.example.Booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Booking.BookingService;
import com.example.Booking.entity.BookingInfoEntity;
import com.example.Booking.model.Payment;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/hotel")
@AllArgsConstructor
public class BookingController {

	private BookingService bookingService;

	@PostMapping("/booking")
	public ResponseEntity<BookingInfoEntity> addBooking(@RequestBody BookingInfoEntity bookingInfoEntity) {
		return new ResponseEntity<BookingInfoEntity>(bookingService.addBooking(bookingInfoEntity), HttpStatus.CREATED);
	}
	
	@PostMapping("/booking/{bookingId}/transaction")
	public ResponseEntity<BookingInfoEntity> addTransaction(@RequestBody Payment payment, @PathVariable int bookingId) {
		
		return new ResponseEntity<>(bookingService.addTransaction(payment,bookingId),HttpStatus.CREATED);
	}

}
