package com.sportoras.dao;

import com.sportoras.connection.ConnectionManager;
import com.sportoras.dao.rewiewDao.RewiewDao;
import com.sportoras.dao.rewiewDao.RewiewDaoImpl;
import com.sportoras.entity.Client;
import com.sportoras.entity.FullName;
import com.sportoras.entity.Rewiew;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class RewiewDaoTest extends BaseDaoTest{

    private RewiewDao rewiewDao = RewiewDaoImpl.getInstance();
    private static final SessionFactory FACTORY = ConnectionManager.getFactory();

    @Test
    public void testFindAll() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        List<Rewiew> results = rewiewDao.findAll(session);
        assertThat(results, hasSize(3));
        session.getTransaction().commit();
    }

    @Test
    public void testById() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        Rewiew rewiew = rewiewDao.find(session, 1L);
        assertNotNull(rewiew);
        session.getTransaction().commit();
    }

    @Test
    public void testSave() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        Client client = new Client("mai20", "333", LocalDate.now(), FullName.of("Olga", "Ivanovna"));
        Rewiew rewiew = Rewiew.builder()
                .user(client)
                .date(LocalDate.now())
                .text("Ok")
                .build();
        rewiewDao.save(session, rewiew);
        session.save(client);
        session.getTransaction().commit();
        assertNotNull(rewiew);
        session.beginTransaction();
        session.remove(client);
        rewiewDao.delete(session, rewiew);
        session.getTransaction().commit();
    }

    @Test
    public void testUpdate() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        Rewiew rewiew = session.find(Rewiew.class, 1L);
        rewiew.setText("Хорошая продукция");
        rewiewDao.update(session, rewiew);
        session.getTransaction().commit();
        session.evict(rewiew);
        session.beginTransaction();
        rewiew = session.find(Rewiew.class, 1L);
        assertEquals(rewiew.getText(), "Хорошая продукция");
        session.getTransaction().commit();
    }

    @Test
    public void testDelite() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        Client client = new Client("mai20", "333", LocalDate.now(), FullName.of("Olga", "Ivanovna"));
        Rewiew rewiew = Rewiew.builder()
                .user(client)
                .date(LocalDate.now())
                .text("Ok")
                .build();
        rewiewDao.save(session, rewiew);
        session.save(client);
        Long savedId = (Long) session.save(rewiew);
        session.getTransaction().commit();
        session.beginTransaction();
        rewiewDao.delete(session, rewiew);
        session.remove(client);
        Rewiew delitRewiew = session.find(Rewiew.class, savedId);
        assertNull(delitRewiew);
    }

    @Test
    public void testFilters() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        List<Rewiew> results = rewiewDao.findRewiewafterDateFromUsersFromCompany
                (session, LocalDate.of(2017, 01, 01), "mail0", "RCOP");
        assertThat(results, hasSize(2));
        session.getTransaction().commit();
    }
}
