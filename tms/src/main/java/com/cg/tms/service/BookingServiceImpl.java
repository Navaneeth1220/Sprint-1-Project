package com.cg.tms.service;

import java.util.List;
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
	IBookingRepository repo;

	@Override
	public Booking makeBooking(Booking booking) {

		validateId(booking.getUserId());
		validateBookingType(booking.getBookingType());
		validateBookingTitle(booking.getBookingTitle());
		return repo.save(booking);
	}

	@Override
	public Booking cancelBooking(int bookingId) throws BookingNotFoundException {
		validateId(bookingId);
		Optional<Booking> optional = repo.findById(bookingId);
		if (!optional.isPresent()) {
			throw new BookingNotFoundException("Booking not found");
		}
		Booking fetched=optional.get();
		repo.delete(fetched);
		return fetched;
	}

	@Override
	public Booking viewBooking(int bookingId) throws BookingNotFoundException {
		Optional<Booking> optional = repo.findById(bookingId);
		if (!optional.isPresent()) {
			throw new BookingNotFoundException("Booking not found");
		}
		return optional.get();
	}

	@Override
	public List<Booking> viewAllBookings() {
		List<Booking> bookings = repo.findAll();
		return bookings;
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
	}

}
