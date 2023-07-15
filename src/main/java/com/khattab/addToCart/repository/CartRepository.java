package com.khattab.addToCart.repository;

import com.khattab.addToCart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    ArrayList<Cart> findByUserId(UUID userId);
}
