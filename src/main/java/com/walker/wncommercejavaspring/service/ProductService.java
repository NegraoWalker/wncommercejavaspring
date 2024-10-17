package com.walker.wncommercejavaspring.service;

import com.walker.wncommercejavaspring.dto.ProductDto;
import com.walker.wncommercejavaspring.model.Product;
import com.walker.wncommercejavaspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    @Transactional(readOnly = true)
    public Page<ProductDto> findAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        Page<ProductDto> productDtos = products.map(ProductDto::new);
        return productDtos;
    }

    @Transactional
    public ProductDto insert(ProductDto productDto) {
        Product product = new Product();
        copyDtoToEntity(productDto, product);
        productRepository.save(product);
        return new ProductDto(product);
    }

    @Transactional
    public ProductDto update(Long id, ProductDto productDto) {
        Product product = productRepository.getReferenceById(id);
        copyDtoToEntity(productDto, product);
        productRepository.save(product);
        return new ProductDto(product);
    }



    public void copyDtoToEntity(ProductDto productDto, Product product) {
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImgUrl(productDto.getImgUrl());
    }

}
