package com.leiyuan.dao;

import com.leiyuan.entity.UserPermissions;

import java.util.List;

public interface UserPermissionsRepository extends CommonRepository<UserPermissions> {
    List<String> getByRoles(String roles);
}
