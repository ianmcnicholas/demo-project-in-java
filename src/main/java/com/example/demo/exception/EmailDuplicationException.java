package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class EmailDuplicationException extends Exception {
    private final String message;

    public EmailDuplicationException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
