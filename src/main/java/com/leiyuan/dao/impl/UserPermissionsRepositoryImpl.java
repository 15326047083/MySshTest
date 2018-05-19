package com.leiyuan.dao.impl;

import com.leiyuan.dao.UserPermissionsRepository;
import com.leiyuan.entity.UserPermissions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserPermissionsRepositoryImpl extends CommonRepositoryImpl<UserPermissions> implements UserPermissionsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public List<String> getByRoles(String roles) {
        // TODO Auto-generated method stub
        return (List<String>) getCurrentSession().createQuery("select permissions from UserPermissions where roles = '" + roles + "'").list();
    }
}
