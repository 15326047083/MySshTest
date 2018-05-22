package com.leiyuan.dao;

import com.leiyuan.entity.Stu;

import java.util.List;

public interface StuDao {
    void saveOrUpdate(Stu stu);
    void delete(String id);
    List queryAll();
    Stu getById(String id);
}
