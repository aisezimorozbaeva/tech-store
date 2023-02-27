package com.ais.techstore.service;

import com.ais.techstore.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void save(Product product);
    void deleteById(long id);
    List<Product> findAndOrderByRating();
    Product findById (Long id);
}
