package com.startcoding0to1.shopeasybackend.exception;

import org.springframework.http.HttpStatus;

/**
 * Custom exception class for ShopEasy application.
 * This exception is used to handle application-specific errors.
 * 
 * @author Mahammad Khairuddin
 */
public class ShopEasyException extends Exception {

    private static final long serialVersionUID = 1L;

    private HttpStatus status;

    public ShopEasyException(String message, HttpStatus status) {
        super(message);
        this.status=status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
