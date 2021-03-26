package com.cg.tms.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.*;
import org.springframework.http.HttpStatus;
import com.cg.tms.exceptions.*;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	private static final Logger Log = LoggerFactory.getLogger(CentralizedExceptionHandler.class);

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(PackageNotFoundException.class)
	public String handleStudentNotFound(PackageNotFoundException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPackageIdException.class)
	public String handleInvalidPackageId(InvalidPackageIdException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPackageNameException.class)
	public String handleInvalidPackageName(InvalidPackageNameException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPackageDescriptionException.class)
	public String handleInvalidPackageDescription(InvalidPackageDescriptionException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidPackageTypeException.class)
	public String handleInvalidPackageType(InvalidPackageTypeException e) {

		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public String handleCatchAllException(Exception e) {

		Log.error("parentException caught", e);
		return e.getMessage();
	}

}
