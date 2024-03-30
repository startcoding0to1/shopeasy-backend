package com.startcoding0to1.shopeasybackend.exception;

/**
 * Custom exception class for ShopEasy application.
 * This exception is used to handle application-specific errors.
 * 
 * @author Mahammad Khairuddin
 */
public class ShopEasyException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new ShopEasyException with the specified detail message.
     * 
     * @param message The detail message (which is saved for later retrieval by the getMessage() method).
     */
    public ShopEasyException(String message) {
        super(message);
    }
}
