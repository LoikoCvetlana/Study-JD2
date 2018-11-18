//package com.sportoras.database.dao;
//
//import com.sportoras.database.entity.BaseEntity;
//import lombok.Getter;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.GenericTypeResolver;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.Optional;
//
//@Getter
//public abstract class BaseDaoImpl<P extends Serializable, E extends BaseEntity<P>> implements BaseDao<P, E> {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//    private Class<E> clazz;
//
//    @SuppressWarnings("unchecked")
//    public BaseDaoImpl() {
//        this.clazz = (Class<E>) GenericTypeResolver.resolveTypeArguments(getClass(), BaseDaoImpl.class)[1];
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public P save(E entity) {
//        return (P) sessionFactory.getCurrentSession().save(entity);
//    }
//
//    @Override
//    public Optional<E> find(P id) {
//        return Optional.ofNullable(sessionFactory.getCurrentSession().find(clazz, id));
//    }
//
//    @Override
//    public void delete(E entity) {
//        sessionFactory.getCurrentSession().delete(entity);
//    }
//
//    @Override
//    public void update(E entity) {
//        sessionFactory.getCurrentSession().update(entity);
//    }
//
//    @Override
//    public List<E> findAll() {
//        return sessionFactory.getCurrentSession()
//                .createQuery(String.format("select e from %s e", clazz.getSimpleName()), clazz)
//                .list();
//    }
//}