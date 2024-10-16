package com.walker.wncommercejavaspring.repository;

import com.walker.wncommercejavaspring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
