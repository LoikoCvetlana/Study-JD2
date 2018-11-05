package com.sportoras;

import com.sportoras.entity.Admin;
import com.sportoras.entity.Client;
import com.sportoras.entity.FullName;
import com.sportoras.entity.Material;
import com.sportoras.entity.Product;
import com.sportoras.entity.Rewiew;
import com.sportoras.entity.User;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.Test;

import java.time.LocalDate;

public class EmployeeDaoTest {

    private static final SessionFactory FACTORY = new Configuration().configure().buildSessionFactory();

    @AfterClass
    public static void closeFactory() {
        FACTORY.close();
    }

    @Test
    public void saveUser() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Client client = new Client("mail", "111", LocalDate.now(), FullName.of("Лойко", "Светлана"));
            Admin admin = new Admin("sportoraz@gmail.com", "222", "manager", FullName.of("Илона", "Микула"));
            session.getTransaction().commit();
        }
    }

    @Test
    public void findUser() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.find(User.class, 1L);
            session.getTransaction().commit();
        }
    }


    @Test
    public void saveProduct() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Product product = Product.builder()
                    .picture("http://sportoras.com/wp-content/uploads/2018/04/img_6759-54-1-small-624x882.jpg")
                    .value(60.00)
                    .name("Майка парадная")
                    .article("М15")
                    .build();
            session.save(product);
            session.getTransaction().commit();
        }
    }

    @Test
    public void findProduct() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.find(Product.class, 1L);
            session.getTransaction().commit();
        }
    }

    @Test
    public void saveMaterial() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Material material = Material.builder()
                    .name("Meryl")
                    .description("Description")
                    .availability(true)
                    .build();
            session.save(material);

            session.getTransaction().commit();
        }
    }

    @Test
    public void findMaterial() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.find(Material.class, 1L);
            session.getTransaction().commit();
        }
    }

    @Test
    public void saveRewiew() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.find(User.class, 1L);
            Rewiew rewiew = Rewiew.builder()
                    .date(LocalDate.now())
                    .text("Все клево!")
                    .user(user)
                    .build();
            session.save(rewiew);

            session.getTransaction().commit();
        }
    }

    @Test
    public void findRewiew() {
        @Cleanup SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.find(Material.class, 2L);
            session.getTransaction().commit();
        }
    }
}