package com.sportoras.database.util;

import com.sportoras.database.entity.Admin;
import com.sportoras.database.entity.Client;
import com.sportoras.database.entity.FullName;
import com.sportoras.database.entity.Material;
import com.sportoras.database.entity.Product;
import com.sportoras.database.entity.Rewiew;
import com.sportoras.database.entity.UserDateil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DatabaseHelper {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public DatabaseHelper(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void cleanDatabase() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Material").executeUpdate();
        entityManager.createQuery("delete from Product").executeUpdate();
        entityManager.createQuery("delete from Rewiew").executeUpdate();
        entityManager.createQuery("delete from UserDateil").executeUpdate();
        entityManager.createQuery("delete from User").executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void prepareData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Material material1 = new Material("Ткань", "Описание ткани", true);
        Material material2 = new Material("Ткань2", "Описание ткани2", true);
        Material material3 = new Material("Ткань3", "Описание ткани3", true);

        entityManager.persist(material1);
        entityManager.persist(material2);
        entityManager.persist(material3);

        Client rcop = new Client("mail0", "222", LocalDate.now(), FullName.of("Irina", "Nikolaevna"));
        Client gocor = new Client("mail2", "111", LocalDate.now(), FullName.of("Ivan", "Nikiforovich"));
        Admin iv = new Admin("mail", "password", "director", FullName.of("Irina", "Pshirkova"));

        entityManager.persist(rcop);
        entityManager.persist(gocor);
        entityManager.persist(iv);

        entityManager.persist(new UserDateil("RCOP", "555 55 55", "375 29555 55 55",
                "Information1", rcop));
        entityManager.persist(new UserDateil("GOCOR", "555 33 55",
                "375 555 333 55", "Information2", gocor));

        entityManager.persist(new Rewiew(rcop, "Cool", LocalDate.now()));
        entityManager.persist(new Rewiew(rcop, "Огонь!",  LocalDate.of(2016, 10, 02)));
        entityManager.persist(new Rewiew(rcop, "Boo", LocalDate.now()));

        entityManager.persist(new Product("Костюм спортивный парадный", "КР15",
                "http://sportoras.com/wp-content/uploads/2015/01/kr15-624x936.jpg", BigDecimal.valueOf(108.00)));
        entityManager.persist(new Product("Игровая форма", "КР14",
                "http://sportoras.com/wp-content/uploads/2015/01/kr14-624x936.jpg", BigDecimal.valueOf(60.00f)));
        entityManager.persist(new Product("Костюм спортивный парадный", "КР32",
                "http://sportoras.com/wp-content/uploads/2017/10/kostjumy-10-red1-624x964.jpg", BigDecimal.valueOf(132.00f)));
        entityManager.persist(new Product("Костюм спортивный парадный", "КР35",
                "http://sportoras.com/wp-content/uploads/2018/04/img_6475-7-1-small-624x882.jpg", BigDecimal.valueOf(150.00f)));


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
