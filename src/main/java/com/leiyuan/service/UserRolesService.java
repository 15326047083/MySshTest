package com.leiyuan.service;

import com.leiyuan.entity.UserRoles;

import java.util.List;

public interface UserRolesService {


    void saveOrUpdate(UserRoles roles);

    List<String> getRolesByEmail(String email);
}
