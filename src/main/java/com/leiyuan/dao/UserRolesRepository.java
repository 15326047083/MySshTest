package com.leiyuan.dao;

import com.leiyuan.entity.UserRoles;

import java.util.List;

public interface UserRolesRepository extends CommonRepository<UserRoles> {
    List<String> getRolesByNum(String Num);
}
