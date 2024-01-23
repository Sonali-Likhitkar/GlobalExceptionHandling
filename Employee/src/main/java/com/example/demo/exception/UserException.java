package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private HttpStatus errorCode;
    private String errorMessage;

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public UserException(HttpStatus errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public UserException() {

    }
}
