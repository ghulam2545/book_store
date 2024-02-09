package com.ghulam.store.controllers;

import com.ghulam.store.models.Cart;
import com.ghulam.store.services.CartService;
import com.ghulam.store.utils.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("${api.endpoints.base-url}/carts")
public class CartController {

    private final CartService cartService;

    @GetMapping
    public Result createCart() {
        Cart cart = cartService.create();

        return new Result(true, HttpStatus.CREATED, "Empty cart created successfully", cart);
    }

    @GetMapping("/{cartId}")
    public Result readCart(@PathVariable String cartId) {
        Cart cart = cartService.read(cartId);

        return new Result(true, HttpStatus.OK, "Cart retrieved successfully", cart);
    }

    @DeleteMapping("/{cartId}")
    public Result deleteCart(@PathVariable String cartId) {
        cartService.delete(cartId);

        return new Result(true, HttpStatus.OK, "Cart deleted successfully");
    }

    @PostMapping("/{cartId}")
    public Result addItem(@PathVariable String cartId, @RequestParam String bookId, @RequestParam Integer qty) {
        cartService.addItem(bookId, qty, cartId);

        return new Result(true, HttpStatus.CREATED, "Item added to cart successfully");
    }

    @DeleteMapping("/{cartId}/{bookId}")
    public Result removeItem(@PathVariable String cartId, @PathVariable String bookId) {
        cartService.removeItem(bookId, cartId);

        return new Result(true, HttpStatus.OK, "Item removed from cart successfully");
    }

}
