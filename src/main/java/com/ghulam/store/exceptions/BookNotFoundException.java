package com.ghulam.store.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String msg) {
        super(msg);
    }
}
