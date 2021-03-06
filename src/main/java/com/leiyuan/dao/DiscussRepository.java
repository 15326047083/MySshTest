package com.leiyuan.dao;

import com.leiyuan.entity.Discuss;
import com.leiyuan.vo.DiscussUser;

import java.util.List;

public interface DiscussRepository extends CommonRepository<Discuss> {

    List<DiscussUser> getDiscussList(String getUserId);

    List<DiscussUser> queryAllList();

    long countByGetUserId(String getUserId);

    List<Long> getStarListByGetUserId(String getUserId);
}
