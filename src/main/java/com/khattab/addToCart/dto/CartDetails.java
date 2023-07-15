package com.khattab.addToCart.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CartDetails {
    private UUID userId;
    List<Product> products;
}
