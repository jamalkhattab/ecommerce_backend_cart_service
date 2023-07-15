package com.khattab.addToCart.service;

import com.khattab.addToCart.dto.CartDetails;
import com.khattab.addToCart.entity.Cart;
import com.khattab.addToCart.dto.Product;
import com.khattab.addToCart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductDetailsProxy productDetailsProxy;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository, ProductDetailsProxy productDetailsProxy) {
        this.cartRepository = cartRepository;
        this.productDetailsProxy = productDetailsProxy;
    }
    @Override
    public Cart addToCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void removeFromCart(Cart cart) {
        cartRepository.delete(cart);
    }

    @Override
    public CartDetails getProductsInCart(UUID userId) {
        ArrayList<Cart> cart = cartRepository.findByUserId(userId);
        List<Product> products = cart.stream()
                                     .map(c -> productDetailsProxy.getProductsInCart(c.getProductId()))
                                     .collect(Collectors.toList());
        return new CartDetails(userId, products);
    }
}
