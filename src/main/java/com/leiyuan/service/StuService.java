package com.leiyuan.service;

import com.leiyuan.entity.Stu;

import java.util.List;

public interface StuService {
    void saveOrUpdate(Stu stu);
    void delete(String id);
    List queryAll();
    Stu getById(String id);
}
