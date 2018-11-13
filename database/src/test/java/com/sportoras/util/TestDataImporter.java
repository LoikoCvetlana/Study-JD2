package com.sportoras.util;

import com.sportoras.entity.Admin;
import com.sportoras.entity.Client;
import com.sportoras.entity.FullName;
import com.sportoras.entity.Material;
import com.sportoras.entity.Product;
import com.sportoras.entity.Rewiew;
import com.sportoras.entity.User;
import com.sportoras.entity.UserDateil;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestDataImporter {

    private static TestDataImporter INSTANCE = new TestDataImporter();

    public static TestDataImporter getInstance() {
        return INSTANCE;
    }

    public void importTestData(SessionFactory sessionFactory) {
        try (Session session = sessionFactory.openSession()) {
            saveMaterial(session, "Ткань", "Описание ткани", true);
            saveMaterial(session, "Ткань1", "Описание ткани1", true);

            Client rcop = saveClient(session, "mail0", "222",
                    LocalDate.now(), FullName.of("Irina", "Nikolaevna"));
            Client gocor = saveClient(session, "mail2", "111",
                    LocalDate.now(), FullName.of("Ivan", "Nikiforovich"));
            Admin iv = saveAdmin(session, "mail", "password",
                    "director", FullName.of("Irina", "Pshirkova"));

            saveUserDetail(session, rcop, "RCOP", "555 55 55",
                    "375 555 555 55", "Information");
            saveUserDetail(session, gocor, "GOCOR", "555 33 55",
                    "375 555 333 55", "Information2");

            saveRewiew(session, rcop, "Огонь!", LocalDate.now());
            saveRewiew(session, rcop, "Бу!", LocalDate.now());
            saveRewiew(session, rcop, "Огонь!",  LocalDate.of(2016, 10, 02));

            saveProduct(session, "Костюм спортивный парадный", "КР15",
                    "http://sportoras.com/wp-content/uploads/2015/01/kr15-624x936.jpg", 108.00);
            saveProduct(session, "Игровая форма", "КР14",
                    "http://sportoras.com/wp-content/uploads/2015/01/kr14-624x936.jpg", 60.00);
            saveProduct(session, "Костюм спортивный парадный", "КР32",
                    "http://sportoras.com/wp-content/uploads/2017/10/kostjumy-10-red1-624x964.jpg", 132.00);
            saveProduct(session, "Костюм спортивный парадный", "КР35",
                    "http://sportoras.com/wp-content/uploads/2018/04/img_6475-7-1-small-624x882.jpg", 150.00);
        }
    }

    private Product saveProduct(Session session, String name, String article, String picture, Double value) {
        Product product = new Product(name, article, picture, value);
        session.save(product);

        return product;
    }

    private Rewiew saveRewiew(Session session, User user, String text, LocalDate date) {
        Rewiew rewiew = new Rewiew(user, text, date);
        session.save(rewiew);

        return rewiew;
    }

    private UserDateil saveUserDetail(Session session, User user, String compani, String workphone, String personalPhone,
                                      String otherInformation) {
        UserDateil userDateil = new UserDateil(compani, workphone, personalPhone, otherInformation, user);
        session.save(userDateil);

        return userDateil;
    }

    private Admin saveAdmin(Session session, String email, String password, String position,
                            FullName fullName) {
        Admin admin = new Admin(email, password, position, fullName);
        session.save(admin);

        return admin;
    }

    private Client saveClient(Session session, String email, String password, LocalDate registrationDate,
                              FullName fullName) {
        Client client = new Client(email, password, registrationDate, fullName);
        session.save(client);

        return client;
    }

    private void saveMaterial(Session session, String name, String description, Boolean availability) {
        session.save(new Material(name, description, availability));
    }
}
