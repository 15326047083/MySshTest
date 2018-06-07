package com.leiyuan.service.impl;

import com.leiyuan.dao.DiscussRepository;
import com.leiyuan.entity.Discuss;
import com.leiyuan.service.DiscussService;
import com.leiyuan.vo.DiscussUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussServiceImpl implements DiscussService {
    @Autowired
    private DiscussRepository discussRepository;

    @Override
    public void save(Discuss discuss) {
        discussRepository.save(discuss);
    }

    @Override
    public List<DiscussUser> getDiscussList(String getUserId) {
        return discussRepository.getDiscussList(getUserId);
    }

    @Override
    public void deleteDiscussById(String discussId) {
        discussRepository.delete(discussId);
    }

    @Override
    public List<DiscussUser> queryAllList() {
        return discussRepository.queryAllList();
    }

    @Override
    public long count() {
        return discussRepository.count();
    }

    @Override
    public long countByGetUserId(String getUserId) {
        return discussRepository.countByGetUserId(getUserId);
    }

    @Override
    public List<Long> getStarListByGetUserId(String getUserId) {
        return discussRepository.getStarListByGetUserId(getUserId);
    }
}
