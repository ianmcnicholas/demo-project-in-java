package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class NoStudentFoundException extends Exception {
    private final String message;

    public NoStudentFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

