package com.sportoras.service;

import com.sportoras.connection.ConnectionManager;
import com.sportoras.dao.productDao.ProductDao;
import com.sportoras.dao.productDao.ProductDaoImpl;
import com.sportoras.entity.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductService {

    private static final ProductService INSTANCE = new ProductService();

    public Product findById(Long productId) {
        ProductDao productDao = ProductDaoImpl.getInstance();
        return productDao.find(ConnectionManager.getSession(), 1L);
    }

    public List<Product> findAll() {
        ProductDao productDao = ProductDaoImpl.getInstance();
        return productDao.findAll(ConnectionManager.getSession());
    }

    public List<Product> filtrProduct(String name, Double value, int limit, int offset) {
        ProductDao productDao = ProductDaoImpl.getInstance();
        return productDao.findByNameAndCostOrder(ConnectionManager.getSession(), name, value, limit, offset);
    }

    public static ProductService getInstance() {
        return INSTANCE;
    }
}
