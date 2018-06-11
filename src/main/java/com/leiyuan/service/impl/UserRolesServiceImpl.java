package com.leiyuan.service.impl;

import java.util.List;

import com.leiyuan.entity.User;
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
    public List<String> getRolesByNum(String Num) {
        // TODO Auto-generated method stub
        return userRoles.getRolesByNum(Num);
    }

    @Override
    public void deleteRoles(User user) {
        userRoles.deleteRoles(user);
    }

    @Override
    public List<UserRoles> queryByStudentNum(String num) {
        return userRoles.queryAll("from UserRoles where studentNum=" + num);
    }
}