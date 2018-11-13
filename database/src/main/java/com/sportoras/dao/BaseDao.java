package com.sportoras.dao;

import com.sportoras.entity.BaseEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<P extends Serializable, E extends BaseEntity<P>> {

    P save(Session session, E entity);

    void update(Session session, E entity);

    void delete(Session session, E entity);

    E find(Session session, P id);

    List<E> findAll(Session session);
}
