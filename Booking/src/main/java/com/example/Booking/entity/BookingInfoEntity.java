package com.example.Booking.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="booking")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingInfoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Date fromDate;
	
	private Date toDate;
	
	private String aadharNumber;
	
	private int numOfRooms;
	
	private String roomNumbers;
	
	private int roomPrice;
	
	private int transactionId;
	
	private Date bookedOn;
}
