package com.walker.wncommercejavaspring.controller;

import com.walker.wncommercejavaspring.model.Product;
import com.walker.wncommercejavaspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/products") //Rota /products
public class ProductController {

    @Autowired
    private ProductRepository productRepository;



    @GetMapping
    public String test() {
        Optional<Product> result = productRepository.findById(1L);
        Product product = result.get();
        return product.getName();
    }
}
