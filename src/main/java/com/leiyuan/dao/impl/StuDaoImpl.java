package com.leiyuan.dao.impl;

import com.leiyuan.dao.StuDao;
import com.leiyuan.entity.Stu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;
@Repository
public class StuDaoImpl implements StuDao {
    @Autowired
    private SessionFactory sessionFactory;
    @SuppressWarnings("unchecked")
    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    @Override
    @Transactional
    public void saveOrUpdate(Stu stu) {
        getCurrentSession().saveOrUpdate(stu);
    }

    @Override
    @Transactional
    public void delete(String id) {
        getCurrentSession().delete(id);
    }

    @Override
    @Transactional
    public List queryAll() {
        return getCurrentSession().createQuery("from Stu").list();
    }

    @Override
    @Transactional
    public Stu getById(String id) {
        return getCurrentSession().get(Stu.class,id);
    }
}
