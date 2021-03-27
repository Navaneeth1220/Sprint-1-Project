package com.cg.tms.repository;

<<<<<<< HEAD
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
	
=======
import java.util.List;

import com.cg.tms.entities.Booking;
import com.cg.tms.exceptions.BookingNotFoundException;

public interface IBookingRepository  {
	
	
	public  Booking  makeBooking(Booking booking);
	public  Booking  cancelBooking(int bookingId) throws BookingNotFoundException;
	public  Booking  viewBooking(int bookingId)throws BookingNotFoundException;
	public List<Booking> viewAllBookings();
	
	
	
	
	

>>>>>>> Maddy
}
