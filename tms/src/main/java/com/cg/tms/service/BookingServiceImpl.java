package com.cg.tms.service;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.tms.entities.Booking;
import com.cg.tms.exceptions.BookingNotFoundException;
import com.cg.tms.exceptions.InvalidBookingException;
import com.cg.tms.exceptions.InvalidIdException;
import com.cg.tms.repository.IBookingRepository;

@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	private IBookingRepository repo;

	@Override
	public Booking makeBooking(Booking booking) {

		validateBooking(booking);
		return repo.save(booking);
=======

import com.cg.tms.entities.Booking;
import com.cg.tms.exceptions.BookingNotFoundException;


public class BookingServiceImpl implements IBookingService {

	@Override	
	public Booking makeBooking(Booking booking) {
		return null;
>>>>>>> Maddy
	}

	@Override
	public Booking cancelBooking(int bookingId) throws BookingNotFoundException {
<<<<<<< HEAD
		validateId(bookingId);
		Optional<Booking> optional = repo.findById(bookingId);
		if (!optional.isPresent()) {
			throw new BookingNotFoundException("Booking not found");
		}
		Booking fetched=optional.get();
		repo.delete(fetched);
		return fetched;
=======
		return null;
>>>>>>> Maddy
	}

	@Override
	public Booking viewBooking(int bookingId) throws BookingNotFoundException {
<<<<<<< HEAD
		Optional<Booking> optional = repo.findById(bookingId);
		if (!optional.isPresent()) {
			throw new BookingNotFoundException("Booking not found");
		}
		return optional.get();
=======
		return null;
>>>>>>> Maddy
	}

	@Override
	public List<Booking> viewAllBookings() {
<<<<<<< HEAD
		List<Booking> bookings = repo.findAll();
		return bookings;
	}
	
	
	void validateBooking(Booking booking) {
		validateId(booking.getBookingId());
		validateBookingType(booking.getBookingTitle());
		validateBookingTitle(booking.getBookingTitle());
	}

	void validateId(int id) {
		if (id < 0) {
			throw new InvalidIdException("ID cannot be negative");
		}
	}

	void validateBookingType(String type) {
		if (type == null || type.isEmpty() || type.trim().isEmpty()) {
			throw new InvalidBookingException("Check Booking type");
		}
	}

	void validateBookingTitle(String title) {
		if (title == null || title.isEmpty() || title.trim().isEmpty()) {
			throw new InvalidBookingException("Check Booking title");
		}
=======
		return null;
>>>>>>> Maddy
	}

}
