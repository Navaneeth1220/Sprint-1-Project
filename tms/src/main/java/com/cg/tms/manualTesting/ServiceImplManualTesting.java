package com.cg.tms.manualTesting;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.tms.entities.Booking;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.exceptions.InvalidBookingException;
import com.cg.tms.exceptions.InvalidIdException;
import com.cg.tms.service.IBookingService;

@Component
public class ServiceImplManualTesting {
	
	@Autowired
	private IBookingService service;
	
	public void start() {
		try {
			Booking book= new Booking();
			LocalDate currentDate = LocalDate.now();
			book.setBookingDate(currentDate);
			book.setBookingTitle("Goa Trip");
			book.setBookingType("Executive");
			book.setUserId(1);
			
			Booking booked=service.makeBooking(book);
			System.out.println("Booking made");
			display(booked);	
			
			Booking book1 = new Booking();
			book1.setBookingDate(currentDate);
			book1.setBookingTitle("Goa Trip");
			book1.setBookingType("Executive");
			book1.setUserId(2);
			Booking booked1=service.makeBooking(book1);
			display(booked1);
			
			System.out.println("Display all bookings");
			List<Booking> bookings=service.viewAllBookings();
			displayAll(bookings);
			
			Booking fetched = service.viewBooking(book.getBookingId());
			System.out.println("Fetched Booking");
			display(fetched);
			
			Booking deletedBooking = service.cancelBooking(book1.getBookingId());
			System.out.println("Deleted booking");
			display(deletedBooking);
		}
		catch(BookingNotFoundException e) {
			System.out.println("Booking not found");
		}
		catch(InvalidIdException e) {
			System.out.print("ID exception");
	
		}
		catch(InvalidBookingException e) {
			System.out.println("Booking exception");

		}
	}

	 void display(Booking booked) {
		System.out.println(booked.getBookingId()+" "+booked.getBookingType()+" "+booked.getBookingTitle()
							+" "+booked.getUserId()+" "+booked.getBookingDate());
		
	}
	 
	 void displayAll(Collection<Booking> bookings) {
		 for(Booking book : bookings) {
			 display(book);
		 }
	 }
}
