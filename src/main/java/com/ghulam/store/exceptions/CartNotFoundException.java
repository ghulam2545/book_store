package com.ghulam.store.exceptions;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(String msg) {
        super(msg);
    }
}
