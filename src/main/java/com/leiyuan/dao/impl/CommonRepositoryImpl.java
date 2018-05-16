package com.leiyuan.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leiyuan.dao.CommonRepository;

@Repository
public class CommonRepositoryImpl<T> implements CommonRepository<T> {

    Class<T> entity;
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    private Session getCurrentSession() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        entity = (Class<T>) pt.getActualTypeArguments()[0];
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public void saveOrUpdate(T t) {
        // TODO Auto-generated method stub
        getCurrentSession().saveOrUpdate(t);
    }

    @Override
    @Transactional
    public String save(T t) {
        return (String) getCurrentSession().save(t);
    }

    @Override
    @Transactional
    public void delete(String id) {
        // TODO Auto-generated method stub
        getCurrentSession().delete(get(id));
    }

    @Override
    @Transactional
    public T get(String id) {
        // TODO Auto-generated method stub
        return (T) getCurrentSession().get(entity, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<T> queryAll() {
        // TODO Auto-generated method stub
        return getCurrentSession().createQuery("from " + entity.getSimpleName()).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<T> queryAll(String sql) {
        // TODO Auto-generated method stub
        return getCurrentSession().createQuery(sql).list();
    }

    @Override
    @Transactional
    public List<T> pagingQuery(int pages) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    @Transactional
    public long count() {
        // TODO Auto-generated method stub
        return (long) getCurrentSession().createQuery("select count(*) from " + entity.getSimpleName()).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public T getByConditions(String sql) {
        return (T) getCurrentSession().createQuery("from " + entity.getSimpleName() + " " + sql).uniqueResult();
    }
}