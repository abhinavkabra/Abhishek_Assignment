package com.example.Booking;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Booking.entity.BookingInfoEntity;
import com.example.Booking.model.Payment;
import com.example.Booking.repository.BookingRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingService {

	private BookingRepository bookingRepository;

	public BookingInfoEntity addBooking(BookingInfoEntity bookingInfoEntity) {
		bookingInfoEntity.setRoomNumbers(String.join(",", getRandomNumbers(bookingInfoEntity.getNumOfRooms())));
		bookingInfoEntity.setRoomPrice(getPrice(bookingInfoEntity));
		long millis=System.currentTimeMillis();
		bookingInfoEntity.setBookedOn(new Date(millis));
		return bookingRepository.save(bookingInfoEntity);
	}

	private int getPrice(BookingInfoEntity bookingInfoEntity) {
		long diff = bookingInfoEntity.getToDate().getTime() - bookingInfoEntity.getFromDate().getTime();
		TimeUnit time = TimeUnit.DAYS;
		long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
		return 1000 * bookingInfoEntity.getNumOfRooms() * (int) diffrence;
	}

	private ArrayList<String> getRandomNumbers(int count) {
		Random random = new Random();
		int upperBound = 100;
		ArrayList<String> numberList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			numberList.add(String.valueOf(random.nextInt(upperBound)));
		}
		return numberList;
	}

	public BookingInfoEntity addTransaction(Payment payment, int bookingId) {
		
		URI url = null;
		try {
			url = new URI("http://localhost:8083/payment/transaction");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer body = new RestTemplate().postForEntity(url, payment, Integer.class).getBody();
		BookingInfoEntity bookingInfo = bookingRepository.findById(new Long(bookingId)).get();
		bookingInfo.setTransactionId(body);
		return bookingInfo;	
	}

}
