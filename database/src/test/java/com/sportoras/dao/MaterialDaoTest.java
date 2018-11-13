package com.sportoras.dao;

import com.sportoras.connection.ConnectionManager;
import com.sportoras.dao.materialDao.MaterialDao;
import com.sportoras.dao.materialDao.MaterialDaoImpl;
import com.sportoras.entity.Material;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class MaterialDaoTest extends BaseDaoTest{

    private MaterialDao materialDao = MaterialDaoImpl.getInstance();
    private static final SessionFactory FACTORY = ConnectionManager.getFactory();

    @Test
    public void testFindAll() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        List<Material> results = materialDao.findAll(session);
        assertThat(results, hasSize(2));
        session.getTransaction().commit();
    }

    @Test
    public void testById() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        Material material = materialDao.find(session, 1L);
        assertNotNull(material);
        session.getTransaction().commit();
    }

    @Test
    public void testSave() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        Material meryl = Material.builder()
                .name("Meryl")
                .description("Description")
                .availability(true)
                .build();
        materialDao.save(session, meryl);
        session.getTransaction().commit();
        assertNotNull(meryl);
        session.beginTransaction();
        materialDao.delete(session, meryl);
        session.getTransaction().commit();
    }

    @Test
    public void testUpdate() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        Material material = session.find(Material.class, 1L);
        material.setDescription("new description");
        materialDao.update(session, material);
        session.getTransaction().commit();
        session.evict(material);
        session.beginTransaction();
        material = session.find(Material.class, 1L);
        assertEquals(material.getDescription(), "new description");
        session.getTransaction().commit();
    }

    @Test
    public void testDelite() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        Material material = Material.builder()
                .name("Meryl")
                .description("Description")
                .availability(true)
                .build();
        materialDao.save(session, material);
        Long savedId = (Long) session.save(material);
        session.getTransaction().commit();
        session.beginTransaction();
        materialDao.delete(session, material);
        Material delitMaterial = session.find(Material.class, savedId);
        assertNull(delitMaterial);
    }

    @Test
    public void testMaterialInStock() {
        @Cleanup Session session = FACTORY.openSession();
        session.beginTransaction();
        Material material = session.find(Material.class, 1L);
        material.setAvailability(false);
        session.getTransaction().commit();
        session.beginTransaction();
        List<Material> results = materialDao.findMaterialInStock(session);
        assertThat(results, hasSize(1));
        session.getTransaction().commit();
    }
}
