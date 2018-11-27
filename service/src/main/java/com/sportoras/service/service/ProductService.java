package com.sportoras.service.service;

import com.sportoras.database.entity.Product;
import com.sportoras.database.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService {

    private final ProductRepository productRepository;

    public Product findProductById(Long productId) {
        return productRepository.findProductById(productId);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> filterProduct(String name, double minValue, double maxValue, Pageable pageable) {
        return productRepository.findAllByNameBetweenOrderByValue(name, minValue, maxValue, pageable);
    }

//    public List<ProductFullDto> allProducts() {
//        return productRepository.findAll().stream()
//                .map(it -> new ProductFullDto(it.getId(), it.getName(), it.getArticle(), it.getPicture(), it.getValue(), it.getMaterials()))
//                .collect(Collectors.toList());
//    }
}