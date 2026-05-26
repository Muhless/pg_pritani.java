package com.example.pg_pritani.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
     private final ProductRepository repository;

     public ProductService(ProductRepository repository) {
          this.repository = repository;
     }

     public List<Product> getAll() {
          return repository.findAll();
     }

     public Optional<Product> getById(Long id) {
          return repository.findById(id);
     }

     public Product create(Product product) {
          return repository.save(product);
     }

     public Product update(Long id, Product product) {
          Product existing = repository.findById(id).orElseThrow();
          existing.setName(product.getName());
          existing.setPrice(product.getPrice());
          return repository.save(existing);
     }

     public void delete(Long id) {
          repository.deleteById(id);
     }

}
