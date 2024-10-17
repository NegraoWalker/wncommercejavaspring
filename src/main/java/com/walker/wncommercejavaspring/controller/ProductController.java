package com.walker.wncommercejavaspring.controller;

import com.walker.wncommercejavaspring.dto.ProductDto;
import com.walker.wncommercejavaspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products") //Rota /products
public class ProductController {

    @Autowired
    private ProductService productService;



    @GetMapping(value = "/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @GetMapping()
    public Page<ProductDto> findAll(Pageable pageable) {
        return productService.findAll(pageable);
    }

    @PostMapping
    public ProductDto insert(@RequestBody ProductDto productDto) {
        return productService.insert(productDto);
    }
}
