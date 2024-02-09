package com.ghulam.store.services.impl;

import com.ghulam.store.exceptions.BookNotFoundException;
import com.ghulam.store.exceptions.CartNotFoundException;
import com.ghulam.store.models.Book;
import com.ghulam.store.models.Cart;
import com.ghulam.store.repositories.BookRepository;
import com.ghulam.store.repositories.CartRepository;
import com.ghulam.store.services.CartService;
import com.ghulam.store.utils.IdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepo;
    private final BookRepository bookRepo;

    @Override
    public Cart create() {
        // Create a new cart with a unique ID
        Cart cart = new Cart();
        final String id = IdGenerator.next();
        cart.setCartId(id);

        cartRepo.save(cart);
        return cart;
    }

    @Override
    public Cart read(String cartId) {
        return cartRepo.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException("Cart with ID " + cartId + " not found."));
    }

    @Override
    public void delete(String cartId) {
        boolean exists = cartRepo.existsById(cartId);
        if (exists) {
            cartRepo.deleteById(cartId);
        } else {
            throw new CartNotFoundException("Cart with ID " + cartId + " not found.");
        }
    }

    @Override
    public void addItem(String bookId, Integer quantity, String cartId) {
        Cart cart = cartRepo.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException("Cart with ID " + cartId + " not found."));

        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + bookId + " not found."));

        // Update quantity, ensuring non-negative values
        Integer oldQty = cart.getBooks().getOrDefault(book, 0);
        Integer newQty = oldQty + 1;
        cart.getBooks().put(book, newQty);

        cartRepo.save(cart);
    }

    @Override
    public void removeItem(String bookId, String cartId) {
        Cart cart = cartRepo.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException("Cart with ID " + cartId + " not found."));

        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + bookId + " not found."));

        // Remove item if it exists, otherwise ignore
        cart.getBooks().remove(book);

        cartRepo.save(cart);
    }
}
