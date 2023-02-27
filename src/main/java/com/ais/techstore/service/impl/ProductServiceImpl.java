package com.ais.techstore.service.impl;

import com.ais.techstore.model.Product;
import com.ais.techstore.repository.ProductRepository;
import com.ais.techstore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAndOrderByRating() {
        return productRepository.findAndOrderByRating()
                .stream()
                .filter(x -> x.getProductCount() >= 1)
                .limit(6)
                .collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }
}
