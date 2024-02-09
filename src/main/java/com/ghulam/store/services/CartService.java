package com.ghulam.store.services;

import com.ghulam.store.models.Cart;

public interface CartService {
    Cart create();

    Cart read(String cartId);

    void delete(String cartId);

    void addItem(String bookId, Integer quantity, String cartId);

    void removeItem(String bookId, String cartId);
}
