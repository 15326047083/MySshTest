package com.leiyuan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leiyuan.entity.UserRoles;
import com.leiyuan.dao.UserRolesRepository;
import com.leiyuan.service.UserRolesService;

@Service
public class UserRolesServiceImpl implements UserRolesService {

    @Autowired
    private UserRolesRepository userRoles;

    @Override
    public void saveOrUpdate(UserRoles roles) {
        // TODO Auto-generated method stub
        userRoles.saveOrUpdate(roles);
    }

    @Override
    public List<String> getRolesByEmail(String email) {
        // TODO Auto-generated method stub
        return userRoles.getRolesByEamil(email);
    }
}