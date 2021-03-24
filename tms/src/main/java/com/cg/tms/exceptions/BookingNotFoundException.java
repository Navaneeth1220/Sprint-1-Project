package com.cg.tms.exceptions;

public class BookingNotFoundException extends RuntimeException {
	public BookingNotFoundException(String msg) {
		super(msg);
	}
}
