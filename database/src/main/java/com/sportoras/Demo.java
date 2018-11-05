package com.sportoras;

import com.sportoras.entity.Material;
import com.sportoras.entity.Product;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Demo {

    public static void main(String[] args) {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Material material = session.find(Material.class, 2L);
            Product product1 = session.find(Product.class, 8L);
            material.getProducts().add(product1);
            session.getTransaction().commit();
        }
    }
}