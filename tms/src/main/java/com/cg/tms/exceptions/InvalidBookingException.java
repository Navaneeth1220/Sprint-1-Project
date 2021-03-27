package com.cg.tms.exceptions;

public class InvalidBookingException extends RuntimeException{
	
	public InvalidBookingException(String msg) {
		super(msg);
	}
}
