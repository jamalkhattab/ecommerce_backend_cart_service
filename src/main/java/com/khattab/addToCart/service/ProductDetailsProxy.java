package com.khattab.addToCart.service;

import com.khattab.addToCart.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Component
@FeignClient(name="product-details", url="localhost:8082")
public interface ProductDetailsProxy {
    @GetMapping("/ecommerce/products/{productId}")
    public Product getProductsInCart(@PathVariable UUID productId);
}
