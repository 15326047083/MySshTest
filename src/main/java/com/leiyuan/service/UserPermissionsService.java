package com.leiyuan.service;

import com.leiyuan.entity.UserPermissions;

import java.util.List;

public interface UserPermissionsService {
    void saveOrUpdate(UserPermissions userPermissions);

    List<String> getByRoles(String roles);
}
