package com.ecommerce.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.application.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
 
}