package com.leiyuan.service.impl;

import com.leiyuan.dao.StuDao;
import com.leiyuan.entity.Stu;
import com.leiyuan.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StuDao stuDao;
    @Override
    public void saveOrUpdate(Stu stu) {
        stuDao.saveOrUpdate(stu);
    }

    @Override
    public void delete(String id) {
        stuDao.delete(id);
    }

    @Override
    public List queryAll() {
        return stuDao.queryAll();
    }

    @Override
    public Stu getById(String id) {
        return stuDao.getById(id);
    }
}
