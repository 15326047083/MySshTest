package com.leiyuan.service;

import com.leiyuan.entity.Discuss;
import com.leiyuan.vo.DiscussUser;

import java.util.List;

public interface DiscussService {
    void save(Discuss discuss);

    List<DiscussUser> getDiscussList(String getUserId);

    void deleteDiscussById(String discussId);


    List<DiscussUser> queryAllList();

    long count();

    long countByGetUserId(String getUserId);

    List<Long> getStarListByGetUserId(String getUserId);
}
