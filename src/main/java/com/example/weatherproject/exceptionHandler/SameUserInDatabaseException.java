package com.example.weatherproject.exceptionHandler;

public class SameUserInDatabaseException extends RuntimeException {
    public SameUserInDatabaseException(String message) {
        super(message);
    }
    public SameUserInDatabaseException(Throwable cause) {
        super(cause);
    }
}
