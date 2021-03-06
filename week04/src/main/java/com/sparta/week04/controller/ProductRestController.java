package com.sparta.week04.controller;

import com.sparta.week04.models.*;
import com.sparta.week04.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/api/products")
    public List<Product> readProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) {
        Product product = new Product(requestDto);
        return productRepository.save(product);
    }

    @PutMapping("/api/products/{targetId}")
    public Long updateProduct(@PathVariable Long targetId, @RequestBody ProductMypriceRequestDto requestDto) {
        return productService.update(targetId,requestDto);
    }
}
