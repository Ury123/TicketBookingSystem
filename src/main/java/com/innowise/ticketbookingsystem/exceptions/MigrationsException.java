package com.innowise.ticketbookingsystem.exceptions;

public class MigrationsException extends RuntimeException {
    public MigrationsException(String message) {
        super(message);
    }

    public MigrationsException(String message, Throwable cause) {
        super(message, cause);
    }
}
