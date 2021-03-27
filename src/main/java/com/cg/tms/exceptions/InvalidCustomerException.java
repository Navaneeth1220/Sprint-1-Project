package com.cg.tms.exceptions;

public class InvalidCustomerException extends RuntimeException {

    public InvalidCustomerException(){

    }

    public InvalidCustomerException(String msg) {
        super(msg);
    }
}
