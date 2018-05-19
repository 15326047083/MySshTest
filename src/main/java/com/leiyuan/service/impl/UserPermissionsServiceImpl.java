package com.leiyuan.service.impl;

import com.leiyuan.dao.UserPermissionsRepository;
import com.leiyuan.entity.UserPermissions;
import com.leiyuan.service.UserPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPermissionsServiceImpl implements UserPermissionsService {
    @Autowired
    private UserPermissionsRepository userPermissionsRepository;

    @Override
    public void saveOrUpdate(UserPermissions userPermissions) {
        userPermissionsRepository.saveOrUpdate(userPermissions);
    }

    @Override
    public List<String> getByRoles(String roles) {
        return userPermissionsRepository.getByRoles(roles);
    }
}
