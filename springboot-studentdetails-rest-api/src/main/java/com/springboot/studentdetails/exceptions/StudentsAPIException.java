package com.springboot.studentdetails.exceptions;

import org.springframework.http.HttpStatus;

public class StudentsAPIException extends RuntimeException{

    private HttpStatus status;
    private String message;

    public StudentsAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public StudentsAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
