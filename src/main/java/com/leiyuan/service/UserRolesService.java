package com.leiyuan.service;

import com.leiyuan.entity.User;
import com.leiyuan.entity.UserRoles;

import java.util.List;

public interface UserRolesService {


    void saveOrUpdate(UserRoles roles);

    List<String> getRolesByNum(String email);

    void deleteRoles(User user);

    List<UserRoles> queryByStudentNum(String num);
}
