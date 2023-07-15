package com.khattab.addToCart.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.UUID;

@Getter
@Setter
public class Product {
    private BigInteger id;

    private UUID productId;
    private String name;
    private double price;
    private double rating;
    private String imageUrl;


}
