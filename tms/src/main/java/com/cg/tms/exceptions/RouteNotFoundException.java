package com.cg.tms.exceptions;

public class RouteNotFoundException extends RuntimeException {
	public RouteNotFoundException(String msg) {
		super(msg);
	}
}
