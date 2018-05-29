package com.leiyuan.service;

import com.leiyuan.entity.Discuss;
import com.leiyuan.vo.DiscussUser;

import java.util.List;

public interface DiscussService {
    void save(Discuss discuss);

    List<DiscussUser> getDiscussList(String getUserId);
}
