package com.sportoras.dao.productDao;

import com.sportoras.dao.BaseDao;
import com.sportoras.entity.Product;
import org.hibernate.Session;

import java.util.List;

public interface ProductDao extends BaseDao<Long, Product> {

    List<Product> findByNameAndCostOrder(Session session, String name, Double cost, int limit, int offset);

}
