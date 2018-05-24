package com.leiyuan.service;

import java.util.List;

import com.leiyuan.entity.User;

public interface UserService {

    void saveOrUpdate(User user);

    String save(User t);

    void delete(String id);

    User get(String id);

    List<User> queryAll();

    List<User> pagingQuery(int pages);

    long count();

    List<User> queryAll(String sql);

    User getByNum(String num);

}