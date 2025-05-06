package com.productSearch.controllers;

import com.productSearch.models.Product;
import com.productSearch.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:8080") // replace with your frontend URL
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts(@RequestParam(value = "search", required = false) String search) {
        if (search != null && !search.isEmpty()) {
            return productRepository.findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(search);
        }
        List<Product> productList = productRepository.findAll();
        productList.forEach(e->{
            System.out.println(e.getName());
        });
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {

        return productRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
