package com.example.Booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Booking.entity.BookingInfoEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingInfoEntity, Long> {
	
}
