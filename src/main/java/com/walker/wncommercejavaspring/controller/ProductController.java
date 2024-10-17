package com.walker.wncommercejavaspring.controller;

import com.walker.wncommercejavaspring.dto.ProductDto;
import com.walker.wncommercejavaspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products") //Rota /products
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<Page<ProductDto>> findAll(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<ProductDto> insert(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.insert(productDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(id, productDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
