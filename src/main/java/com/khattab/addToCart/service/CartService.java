package com.khattab.addToCart.service;

import com.khattab.addToCart.dto.CartDetails;
import com.khattab.addToCart.entity.Cart;

import java.util.UUID;

public interface CartService {
    public Cart addToCart(Cart cart);
    public void removeFromCart(Cart cart);

    public CartDetails getProductsInCart(UUID userId);
}
