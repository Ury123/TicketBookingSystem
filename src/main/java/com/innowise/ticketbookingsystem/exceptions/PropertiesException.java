package com.innowise.ticketbookingsystem.exceptions;

public class PropertiesException extends RuntimeException{
    public PropertiesException(String message) {
        super(message);
    }

    public PropertiesException(String message, Throwable cause) {
        super(message, cause);
    }
}
