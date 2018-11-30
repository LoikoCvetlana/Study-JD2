package com.sportoras.service.service;

import com.sportoras.database.entity.Product;
import com.sportoras.database.repository.ProductRepository;
import com.sportoras.service.dto.ProductBasicDto;
import com.sportoras.service.dto.ProductCreateDto;
import com.sportoras.service.dto.ProductDtoFilter;
import com.sportoras.service.dto.ProductFullDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<ProductBasicDto> filterProduct(ProductDtoFilter productDtoFilter) {
        return productRepository.findAllByNameBetweenOrderByValue
                (productDtoFilter.getName(), productDtoFilter.getMinValue(), productDtoFilter.getMaxValue(), productDtoFilter.getPageable()).stream()
                .map(it -> new ProductBasicDto(it.getId(), it.getName(), it.getArticle(), it.getPicture()))
                .collect(Collectors.toList());
    }

    public List<ProductBasicDto> allProducts() {
        return productRepository.findAll().stream()
                .map(it -> new ProductBasicDto(it.getId(), it.getName(), it.getArticle(), it.getPicture()))
                .collect(Collectors.toList());
    }

    public ProductFullDto saveProduct(ProductCreateDto productCreateDto) {
        Product savedProduct = productRepository.save(
                Product.builder()
                        .name(productCreateDto.getName())
                        .article(productCreateDto.getArticle())
                        .picture(productCreateDto.getPicture())
                        .value(productCreateDto.getValue())
//                        .materials(Arrays.asList())
                        .build());

        return new ProductFullDto(savedProduct.getId(), savedProduct.getName(), savedProduct.getArticle(), savedProduct.getPicture(),savedProduct.getValue(), savedProduct.getMaterials() );
    }
}