package com.sportoras.dao;

import com.sportoras.connection.ConnectionManager;
import com.sportoras.dao.productDao.ProductDao;
import com.sportoras.dao.productDao.ProductDaoImpl;
import com.sportoras.entity.Material;
import com.sportoras.entity.Product;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class ProductDaoTest extends BaseDaoTest{

    private ProductDao productDao = ProductDaoImpl.getInstance();
    private static final SessionFactory FACTORY = ConnectionManager.getFactory();

    @Test
    public void testFindAll() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        List<Product> results = productDao.findAll(session);
        assertThat(results, hasSize(4));
        session.getTransaction().commit();
    }

    @Test
    public void testById() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        Product product = productDao.find(session, 1L);
        assertNotNull(product);
        session.getTransaction().commit();
    }

    @Test
    public void testSave() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        Product product = Product.builder()
                .name("Костюм")
                .article("А")
                .value(60.00)
                .picture("http://sportoras.com/wp-content/uploads/2015/01/kr15-624x936.jpg")
                .build();
        productDao.save(session, product);
        session.getTransaction().commit();
        assertNotNull(product);
        session.beginTransaction();
        productDao.delete(session, product);
        session.getTransaction().commit();
    }

    @Test
    public void testUpdate() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        Product product = session.find(Product.class, 1L);
        product.setArticle("B");
        productDao.update(session, product);
        session.getTransaction().commit();
        product = session.find(Product.class, 1L);
        assertEquals(product.getArticle(), "B");
    }

    @Test
    public void testDelite() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        Product product = Product.builder()
                .name("Костюм")
                .article("А")
                .value(60.00)
                .picture("http://sportoras.com/wp-content/uploads/2015/01/kr15-624x936.jpg")
                .build();
        productDao.save(session, product);
        Long savedId = (Long) session.save(product);
        session.getTransaction().commit();
        session.beginTransaction();
        productDao.delete(session, product);
        session.getTransaction().commit();
        session.beginTransaction();
        Material delitMaterial = session.find(Material.class, savedId);
        assertNull(delitMaterial);
    }


    @Test
    public void testProsuctLimit() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        List<Product> results = productDao.findByNameAndCostOrder
                (session, "Костюм спортивный парадный", 140.00, 6,1);
        List<Double> values = results.stream().map(Product::getValue).collect(toList());
        assertThat(results, hasSize(1));
        assertThat(values, containsInAnyOrder(132.00));
        session.getTransaction().commit();
    }
}

