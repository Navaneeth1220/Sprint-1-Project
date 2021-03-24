package com.cg.tms.util;

import org.springframework.stereotype.Component;

import com.cg.tms.entities.Booking;

@Component
public class BookingUtil {
	
	public Booking newBooking() {
		return new Booking();
	}
	
}
