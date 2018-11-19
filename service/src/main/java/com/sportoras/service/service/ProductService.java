package com.sportoras.service.service;

import com.sportoras.database.entity.Product;
import com.sportoras.database.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    @Autowired
    private ProductService productService;

    private final ProductRepository productRepository;

    @Transactional
    public Optional<Product> findProductById(Long materialId) {
        return productRepository.findById(1L);
    }

    @Transactional
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public List<Product> filterProduct(String name, double minValue, double maxValue, Pageable pageable) {
        return productRepository.findAllByNameBetweenOrderByValue(name, minValue, maxValue, pageable);
    }
}