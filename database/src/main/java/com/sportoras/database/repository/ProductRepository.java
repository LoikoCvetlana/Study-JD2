package com.sportoras.database.repository;

import com.sportoras.database.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findByName(String name);

    List<Product> findAllByValueBetween(double minValue, double maxValue);

    List<Product> findAllByNameBetweenOrderByValue(String name, double minValue, double maxValue, Pageable pageable);

    List<Product> findAll();
}