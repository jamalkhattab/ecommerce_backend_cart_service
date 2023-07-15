package com.khattab.addToCart.controller;

import com.khattab.addToCart.dto.CartDetails;
import com.khattab.addToCart.entity.Cart;
import com.khattab.addToCart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/ecommerce/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.addToCart(cart);
    }

    @PostMapping("/remove")
    public void removeFromCart(@RequestBody Cart cart) {
        cartService.removeFromCart(cart);
    }

    @GetMapping("/products/{userId}")
    public CartDetails getProductsInCart(@PathVariable UUID userId) {
        return cartService.getProductsInCart(userId);
    }
}
