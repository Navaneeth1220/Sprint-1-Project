package com.cg.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.tms.entities.Booking;

public interface IBookingRepository extends JpaRepository<Booking,Integer>   {
	
	
	/*
	 Booking save(Booking booking);
	 
	 Booking findById(int bookingId);
	 
	 void delete(Booking booking);
	 
	 List<Booking> findAll();
	*/
	
	/*public  Booking  makeBooking(Booking booking);
	public  Booking  cancelBooking(int bookingId) throws BookingNotFoundException;
	public  Booking  viewBooking(int bookingId)throws BookingNotFoundException;
	public List<Booking> viewAllBookings();*/
	
}
