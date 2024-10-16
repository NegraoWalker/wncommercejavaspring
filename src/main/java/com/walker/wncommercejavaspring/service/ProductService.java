package com.walker.wncommercejavaspring.service;

import com.walker.wncommercejavaspring.dto.ProductDto;
import com.walker.wncommercejavaspring.model.Product;
import com.walker.wncommercejavaspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDto findById(Long id) {
        Optional<Product> result = productRepository.findById(id);
        Product product = result.get();
        return new ProductDto(product);
    }
}
