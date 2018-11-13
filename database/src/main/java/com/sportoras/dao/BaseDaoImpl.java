package com.sportoras.dao;

import com.sportoras.entity.BaseEntity;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseDaoImpl<P extends Serializable, E extends BaseEntity<P>> implements BaseDao<P, E> {

    private Class<E> clazz;

    @SuppressWarnings("unchecked")
    public BaseDaoImpl() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        this.clazz = (Class<E>) type.getActualTypeArguments()[1];
    }

    @Override
    @SuppressWarnings("unchecked")
    public P save(Session session, E entity) {
        return (P) session.save(entity);
    }

    @Override
    public void update(Session session, E entity) {
        session.update(entity);
    }

    @Override
    public void delete(Session session, E entity) {
        session.delete(entity);
    }

    @Override
    public E find(Session session, P id) {
        return session.find(clazz, id);
    }

    @Override
    public List<E> findAll(Session session) {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<E> criteria = cb.createQuery(clazz);
        criteria.select(criteria.from(clazz));
        return session.createQuery(criteria).list();
    }
}