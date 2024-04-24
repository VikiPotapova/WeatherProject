package com.example.weatherproject.exceptionHandler;

public class ResponseReadingException extends RuntimeException {
    public ResponseReadingException(Throwable cause) {
        super(cause);
    }
}
