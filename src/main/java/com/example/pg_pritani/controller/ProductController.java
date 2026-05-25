package com.example.pg_pritani.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pg_pritani.model.Product;
import com.example.pg_pritani.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

     private final ProductService service;

     public ProductController(ProductService service) {
          this.service = service;
     }

     // get all products
     @GetMapping
     public List<Product> getAll() {
          return service.getAll();
     }

     @GetMapping("/{id}")
     public Product getById(@PathVariable Long id) {
          return service.getById(id).orElse(null);
     }

     // post
     @PostMapping
     public Product create(@RequestBody Product product) {
          return service.create(product);
     }

     @PutMapping("/{id}")
     public Product update(@PathVariable Long id, @RequestBody Product product) {
          return service.update(id, product);
     }

     @DeleteMapping("/{id}")
     public void delete(@PathVariable Long id) {
          service.delete(id);
     }
}
