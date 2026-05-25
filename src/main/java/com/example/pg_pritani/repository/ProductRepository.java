package com.example.pg_pritani.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pg_pritani.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
