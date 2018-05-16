package com.leiyuan.dao;

import java.util.List;

public interface CommonRepository<T> {
    void saveOrUpdate(T t);

    String save(T t);

    void delete(String id);

    T get(String id);

    List<T> queryAll();

    List<T> pagingQuery(int pages);

    long count();

    List<T> queryAll(String sql);

    T getByConditions(String sql);
}
